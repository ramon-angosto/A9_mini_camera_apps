package com.vungle.warren.ui.presenter;

import android.content.ActivityNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.ClickCoordinateTracker;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.model.token.Gdpr;
import com.vungle.warren.omsdk.OMTracker;
import com.vungle.warren.omsdk.WebViewObserver;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.ui.DurationRecorder;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.ui.PresenterAppLeftCallback;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.contract.WebAdContract;
import com.vungle.warren.ui.state.OptionsState;
import com.vungle.warren.ui.view.WebViewAPI;
import com.vungle.warren.utility.AsyncFileUtils;
import com.vungle.warren.utility.Constants;
import com.vungle.warren.utility.Scheduler;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class MRAIDAdPresenter implements WebAdContract.WebAdPresenter, WebViewAPI.MRAIDDelegate, WebViewAPI.WebClientErrorHandler {
    private static final String ACTION = "action";
    private static final String ACTION_WITH_VALUE = "actionWithValue";
    private static final String CLOSE = "close";
    private static final String CONSENT_ACTION = "consentAction";
    private static final String ERROR = "error";
    private static final String EXTRA_INCENTIVIZED_SENT = "incentivized_sent";
    private static final String EXTRA_REPORT = "saved_report";
    private static final String OPEN = "open";
    private static final String OPEN_DEEPLINK_SUCCESS = "deeplinkSuccess";
    private static final String OPEN_NON_MRAID = "openNonMraid";
    private static final String OPEN_PRIVACY = "openPrivacy";
    private static final String SUCCESSFUL_VIEW = "successfulView";
    private static final String TAG = MRAIDAdPresenter.class.getCanonicalName();
    private static final String TPAT = "tpat";
    private static final String USE_CUSTOM_CLOSE = "useCustomClose";
    private static final String USE_CUSTOM_PRIVACY = "useCustomPrivacy";
    private static final String VIDEO_VIEWED = "videoViewed";
    /* access modifiers changed from: private */
    public WebAdContract.WebAdView adView;
    private boolean adViewed;
    private Advertisement advertisement;
    private final AdAnalytics analytics;
    private File assetDir;
    /* access modifiers changed from: private */
    public boolean backEnabled;
    private AdContract.AdvertisementPresenter.EventListener bus;
    private ClickCoordinateTracker clickCoordinateTracker;
    private Map<String, Cookie> cookieMap = new HashMap();
    private long duration;
    private DurationRecorder durationRecorder;
    private AsyncFileUtils.ExistenceOperation fileExistenceOperation;
    private final String[] impressionUrls;
    private AtomicBoolean isDestroying = new AtomicBoolean(false);
    private final OMTracker omTracker;
    private final Placement placement;
    private Repository.SaveCallback repoCallback = new Repository.SaveCallback() {
        boolean errorHappened = false;

        public void onSaved() {
        }

        public void onError(Exception exc) {
            if (!this.errorHappened) {
                this.errorHappened = true;
                VungleException vungleException = new VungleException(26);
                MRAIDAdPresenter.this.makeBusError(vungleException);
                VungleLogger.error(MRAIDAdPresenter.class.getSimpleName(), vungleException.getLocalizedMessage());
                MRAIDAdPresenter.this.closeView();
            }
        }
    };
    private Report report;
    private Repository repository;
    private final Scheduler scheduler;
    private AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public WebViewAPI webClient;

    public MRAIDAdPresenter(Advertisement advertisement2, Placement placement2, Repository repository2, Scheduler scheduler2, AdAnalytics adAnalytics, WebViewAPI webViewAPI, OptionsState optionsState, File file, OMTracker oMTracker, String[] strArr) {
        this.advertisement = advertisement2;
        this.repository = repository2;
        this.placement = placement2;
        this.scheduler = scheduler2;
        this.analytics = adAnalytics;
        this.webClient = webViewAPI;
        this.assetDir = file;
        this.omTracker = oMTracker;
        this.impressionUrls = strArr;
        loadData(optionsState);
        if (advertisement2.isClickCoordinatesTrackingEnabled()) {
            this.clickCoordinateTracker = new ClickCoordinateTracker(advertisement2, adAnalytics);
        }
    }

    public void setEventListener(AdContract.AdvertisementPresenter.EventListener eventListener) {
        this.bus = eventListener;
    }

    public void reportAction(String str, String str2) {
        if (str.equals("videoLength")) {
            this.duration = Long.parseLong(str2);
            this.report.setVideoLength(this.duration);
            this.repository.save(this.report, this.repoCallback);
            return;
        }
        this.report.recordAction(str, str2, System.currentTimeMillis());
        this.repository.save(this.report, this.repoCallback);
    }

    public void onViewConfigurationChanged() {
        this.adView.updateWindow();
        this.webClient.notifyPropertiesChange(true);
    }

    public void attach(WebAdContract.WebAdView webAdView, OptionsState optionsState) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = webAdView;
        webAdView.setPresenter(this);
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext(Constants.ATTACH, this.advertisement.getCreativeId(), this.placement.getId());
        }
        this.omTracker.start();
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            if ((settings & 2) == 2) {
                z = true;
            }
            this.backEnabled = z;
        }
        int adOrientation = this.advertisement.getAdConfig().getAdOrientation();
        int i = 6;
        if (adOrientation == 3) {
            int orientation = this.advertisement.getOrientation();
            if (orientation != 0) {
                if (orientation != 1) {
                    i = -1;
                }
                Log.d(TAG, "Requested Orientation " + i);
                webAdView.setOrientation(i);
                prepare(optionsState);
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, true).addData(SessionAttribute.EVENT_ID, this.advertisement.getId()).build());
            }
        } else if (adOrientation != 0) {
            if (adOrientation != 1) {
                i = 4;
            }
            Log.d(TAG, "Requested Orientation " + i);
            webAdView.setOrientation(i);
            prepare(optionsState);
            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, true).addData(SessionAttribute.EVENT_ID, this.advertisement.getId()).build());
        }
        i = 7;
        Log.d(TAG, "Requested Orientation " + i);
        webAdView.setOrientation(i);
        prepare(optionsState);
        SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, true).addData(SessionAttribute.EVENT_ID, this.advertisement.getId()).build());
    }

    public void detach(int i) {
        AsyncFileUtils.ExistenceOperation existenceOperation = this.fileExistenceOperation;
        if (existenceOperation != null) {
            existenceOperation.cancel();
        }
        stop(i);
        this.webClient.setWebViewObserver((WebViewObserver) null);
        this.adView.destroyAdView(this.omTracker.stop());
    }

    private void prepare(OptionsState optionsState) {
        String str;
        this.webClient.setMRAIDDelegate(this);
        this.webClient.setErrorHandler(this);
        loadMraid(new File(this.assetDir.getPath() + File.separator + "template"));
        Cookie cookie = this.cookieMap.get(Cookie.INCENTIVIZED_TEXT_COOKIE);
        if (cookie != null) {
            this.advertisement.setIncentivizedText(cookie.getString(CampaignEx.JSON_KEY_TITLE), cookie.getString(TtmlNode.TAG_BODY), cookie.getString("continue"), cookie.getString("close"));
        }
        if (cookie == null) {
            str = null;
        } else {
            str = cookie.getString("userID");
        }
        if (this.report == null) {
            this.report = new Report(this.advertisement, this.placement, System.currentTimeMillis(), str);
            this.report.setTtDownload(this.advertisement.getTtDownload());
            this.repository.save(this.report, this.repoCallback);
        }
        if (this.durationRecorder == null) {
            this.durationRecorder = new DurationRecorder(this.report, this.repository, this.repoCallback);
        }
        Cookie cookie2 = this.cookieMap.get(Cookie.CONSENT_COOKIE);
        if (cookie2 != null) {
            boolean z = cookie2.getBoolean("is_country_data_protected").booleanValue() && "unknown".equals(cookie2.getString("consent_status"));
            this.webClient.setConsentStatus(z, cookie2.getString("consent_title"), cookie2.getString("consent_message"), cookie2.getString("button_accept"), cookie2.getString("button_deny"));
            if (z) {
                cookie2.putValue("consent_status", Gdpr.OPTED_OUT_BY_TIMEOUT);
                cookie2.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie2.putValue("consent_source", "vungle_modal");
                this.repository.save(cookie2, this.repoCallback);
            }
        }
        int showCloseDelay = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
        if (showCloseDelay > 0) {
            this.scheduler.schedule(new Runnable() {
                public void run() {
                    boolean unused = MRAIDAdPresenter.this.backEnabled = true;
                }
            }, (long) showCloseDelay);
        } else {
            this.backEnabled = true;
        }
        this.adView.updateWindow();
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext("start", (String) null, this.placement.getId());
        }
    }

    private void loadMraid(File file) {
        File file2 = new File(file.getParent());
        final File file3 = new File(file2.getPath() + File.separator + "index.html");
        this.fileExistenceOperation = AsyncFileUtils.isFileExistAsync(file3, new AsyncFileUtils.FileExistCallback() {
            public void status(boolean z) {
                if (!z) {
                    MRAIDAdPresenter.this.makeBusError(new VungleException(27));
                    MRAIDAdPresenter.this.makeBusError(new VungleException(10));
                    MRAIDAdPresenter.this.adView.close();
                    return;
                }
                WebAdContract.WebAdView access$300 = MRAIDAdPresenter.this.adView;
                access$300.showWebsite(Advertisement.FILE_SCHEME + file3.getPath());
                MRAIDAdPresenter.this.recordPlayRemoteUrl();
            }
        });
    }

    public void start() {
        if (!this.adView.hasWebView()) {
            reportErrorAndCloseAd(new VungleException(31));
            return;
        }
        this.adView.setImmersiveMode();
        this.adView.resumeWeb();
        setAdVisibility(true);
    }

    public void stop(int i) {
        boolean z = (i & 1) != 0;
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        this.adView.pauseWeb();
        setAdVisibility(false);
        if (!z && z2 && !this.isDestroying.getAndSet(true)) {
            WebViewAPI webViewAPI = this.webClient;
            String str = null;
            if (webViewAPI != null) {
                webViewAPI.setMRAIDDelegate((WebViewAPI.MRAIDDelegate) null);
            }
            if (z3) {
                reportAction("mraidCloseByApi", (String) null);
            }
            this.repository.save(this.report, this.repoCallback);
            AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext(TtmlNode.END, str, this.placement.getId());
            }
        }
    }

    public void setAdVisibility(boolean z) {
        this.webClient.setAdVisibility(z);
        if (z) {
            this.durationRecorder.start();
        } else {
            this.durationRecorder.stop();
        }
    }

    public void onViewTouched(MotionEvent motionEvent) {
        ClickCoordinateTracker clickCoordinateTracker2 = this.clickCoordinateTracker;
        if (clickCoordinateTracker2 != null) {
            clickCoordinateTracker2.trackCoordinate(motionEvent);
        }
    }

    public void generateSaveState(OptionsState optionsState) {
        if (optionsState != null) {
            this.repository.save(this.report, this.repoCallback);
            optionsState.put(EXTRA_REPORT, this.report.getId());
            optionsState.put(EXTRA_INCENTIVIZED_SENT, this.sendReportIncentivized.get());
        }
    }

    public void restoreFromSave(OptionsState optionsState) {
        if (optionsState != null) {
            boolean z = optionsState.getBoolean(EXTRA_INCENTIVIZED_SENT, false);
            if (z) {
                this.sendReportIncentivized.set(z);
            }
            if (this.report == null) {
                this.adView.close();
                VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#restoreFromSave", "The advertisement was not started and cannot be restored.");
            }
        }
    }

    public boolean handleExit() {
        if (!this.backEnabled) {
            return false;
        }
        this.adView.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ca, code lost:
        if (r1.equals("gone") != false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0218, code lost:
        if (r1.equals("gone") != false) goto L_0x0226;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0228 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processCommand(java.lang.String r17, com.google.gson.JsonObject r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            android.os.Handler r3 = new android.os.Handler
            android.os.Looper r4 = android.os.Looper.getMainLooper()
            r3.<init>(r4)
            int r4 = r17.hashCode()
            java.lang.String r5 = "useCustomPrivacy"
            java.lang.String r6 = "openNonMraid"
            java.lang.String r7 = "successfulView"
            java.lang.String r8 = "open"
            r10 = 0
            r11 = 2
            r12 = 1
            switch(r4) {
                case -1912374177: goto L_0x0090;
                case -1422950858: goto L_0x0086;
                case -735200587: goto L_0x007c;
                case -660787472: goto L_0x0072;
                case -511324706: goto L_0x0067;
                case -418575596: goto L_0x005f;
                case -348095344: goto L_0x0056;
                case 3417674: goto L_0x004e;
                case 3566511: goto L_0x0044;
                case 94756344: goto L_0x003a;
                case 96784904: goto L_0x002e;
                case 1614272768: goto L_0x0023;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0099
        L_0x0023:
            java.lang.String r4 = "useCustomClose"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0099
            r4 = 7
            goto L_0x009a
        L_0x002e:
            java.lang.String r4 = "error"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0099
            r4 = 11
            goto L_0x009a
        L_0x003a:
            java.lang.String r4 = "close"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0099
            r4 = r10
            goto L_0x009a
        L_0x0044:
            java.lang.String r4 = "tpat"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0099
            r4 = 3
            goto L_0x009a
        L_0x004e:
            boolean r4 = r1.equals(r8)
            if (r4 == 0) goto L_0x0099
            r4 = 5
            goto L_0x009a
        L_0x0056:
            boolean r4 = r1.equals(r5)
            if (r4 == 0) goto L_0x0099
            r4 = 8
            goto L_0x009a
        L_0x005f:
            boolean r4 = r1.equals(r6)
            if (r4 == 0) goto L_0x0099
            r4 = 6
            goto L_0x009a
        L_0x0067:
            java.lang.String r4 = "openPrivacy"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0099
            r4 = 9
            goto L_0x009a
        L_0x0072:
            java.lang.String r4 = "consentAction"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0099
            r4 = r12
            goto L_0x009a
        L_0x007c:
            java.lang.String r4 = "actionWithValue"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0099
            r4 = r11
            goto L_0x009a
        L_0x0086:
            java.lang.String r4 = "action"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0099
            r4 = 4
            goto L_0x009a
        L_0x0090:
            boolean r4 = r1.equals(r7)
            if (r4 == 0) goto L_0x0099
            r4 = 10
            goto L_0x009a
        L_0x0099:
            r4 = -1
        L_0x009a:
            java.lang.String r13 = "url"
            r14 = 3178655(0x30809f, float:4.454244E-39)
            java.lang.String r15 = "event"
            r9 = 0
            switch(r4) {
                case 0: goto L_0x0387;
                case 1: goto L_0x034a;
                case 2: goto L_0x02bf;
                case 3: goto L_0x02ab;
                case 4: goto L_0x02aa;
                case 5: goto L_0x0245;
                case 6: goto L_0x0245;
                case 7: goto L_0x01ed;
                case 8: goto L_0x0197;
                case 9: goto L_0x0180;
                case 10: goto L_0x00fc;
                case 11: goto L_0x00c2;
                default: goto L_0x00a5;
            }
        L_0x00a5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Class<com.vungle.warren.ui.presenter.MRAIDAdPresenter> r2 = com.vungle.warren.ui.presenter.MRAIDAdPresenter.class
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            java.lang.String r2 = "#processCommand"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "Unknown MRAID Command"
            com.vungle.warren.VungleLogger.error(r1, r2)
            return r10
        L_0x00c2:
            java.lang.String r1 = "code"
            java.lang.String r1 = com.vungle.warren.model.JsonUtil.getAsString(r2, r1, r9)
            java.lang.Object[] r2 = new java.lang.Object[r11]
            r2[r10] = r1
            com.vungle.warren.model.Advertisement r3 = r0.advertisement
            java.lang.String r3 = r3.getCreativeId()
            r2[r12] = r3
            java.lang.String r3 = "%s Creative Id: %s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Receive Creative error: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4)
            r0.recordMraidError(r1)
            com.vungle.warren.ui.presenter.MRAIDAdPresenter$7 r1 = new com.vungle.warren.ui.presenter.MRAIDAdPresenter$7
            r1.<init>(r2)
            com.vungle.warren.utility.ThreadUtil.runOnUiThread(r1)
            return r12
        L_0x00fc:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r0.bus
            if (r1 == 0) goto L_0x0109
            com.vungle.warren.model.Placement r2 = r0.placement
            java.lang.String r2 = r2.getId()
            r1.onNext(r7, r9, r2)
        L_0x0109:
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r1 = r0.cookieMap
            java.lang.String r2 = "configSettings"
            java.lang.Object r1 = r1.get(r2)
            com.vungle.warren.model.Cookie r1 = (com.vungle.warren.model.Cookie) r1
            com.vungle.warren.model.Placement r2 = r0.placement
            boolean r2 = r2.isIncentivized()
            if (r2 == 0) goto L_0x017f
            if (r1 == 0) goto L_0x017f
            java.lang.String r2 = "isReportIncentivizedEnabled"
            java.lang.Boolean r1 = r1.getBoolean(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x017f
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.sendReportIncentivized
            boolean r1 = r1.getAndSet(r12)
            if (r1 != 0) goto L_0x017f
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
            r1.<init>()
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Placement r3 = r0.placement
            java.lang.String r3 = r3.getId()
            r2.<init>((java.lang.String) r3)
            java.lang.String r3 = "placement_reference_id"
            r1.add(r3, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Advertisement r3 = r0.advertisement
            java.lang.String r3 = r3.getAppID()
            r2.<init>((java.lang.String) r3)
            java.lang.String r3 = "app_id"
            r1.add(r3, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r3 = r0.report
            long r3 = r3.getAdStartTime()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.<init>((java.lang.Number) r3)
            java.lang.String r3 = "adStartTime"
            r1.add(r3, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r3 = r0.report
            java.lang.String r3 = r3.getUserID()
            r2.<init>((java.lang.String) r3)
            java.lang.String r3 = "user"
            r1.add(r3, r2)
            com.vungle.warren.analytics.AdAnalytics r2 = r0.analytics
            r2.ri(r1)
        L_0x017f:
            return r12
        L_0x0180:
            com.google.gson.JsonElement r1 = r2.get(r13)
            java.lang.String r1 = r1.getAsString()
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r2 = r0.adView
            com.vungle.warren.ui.PresenterAppLeftCallback r3 = new com.vungle.warren.ui.PresenterAppLeftCallback
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r0.bus
            com.vungle.warren.model.Placement r5 = r0.placement
            r3.<init>(r4, r5)
            r2.open(r9, r1, r3, r9)
            return r12
        L_0x0197:
            com.google.gson.JsonElement r1 = r2.get(r5)
            java.lang.String r1 = r1.getAsString()
            int r2 = r1.hashCode()
            if (r2 == r14) goto L_0x01c4
            r3 = 3569038(0x36758e, float:5.001287E-39)
            if (r2 == r3) goto L_0x01ba
            r3 = 97196323(0x5cb1923, float:1.9099262E-35)
            if (r2 == r3) goto L_0x01b0
            goto L_0x01cd
        L_0x01b0:
            java.lang.String r2 = "false"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01cd
            r10 = r11
            goto L_0x01ce
        L_0x01ba:
            java.lang.String r2 = "true"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01cd
            r10 = r12
            goto L_0x01ce
        L_0x01c4:
            java.lang.String r2 = "gone"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01cd
            goto L_0x01ce
        L_0x01cd:
            r10 = -1
        L_0x01ce:
            if (r10 == 0) goto L_0x01ec
            if (r10 == r12) goto L_0x01ec
            if (r10 != r11) goto L_0x01d5
            goto L_0x01ec
        L_0x01d5:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unknown value "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x01ec:
            return r12
        L_0x01ed:
            java.lang.String r1 = "sdkCloseButton"
            com.google.gson.JsonElement r1 = r2.get(r1)
            java.lang.String r1 = r1.getAsString()
            int r2 = r1.hashCode()
            r3 = -1901805651(0xffffffff8ea4bfad, float:-4.06137E-30)
            if (r2 == r3) goto L_0x021b
            if (r2 == r14) goto L_0x0212
            r3 = 466743410(0x1bd1f072, float:3.4731534E-22)
            if (r2 == r3) goto L_0x0208
            goto L_0x0225
        L_0x0208:
            java.lang.String r2 = "visible"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0225
            r10 = r11
            goto L_0x0226
        L_0x0212:
            java.lang.String r2 = "gone"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0225
            goto L_0x0226
        L_0x021b:
            java.lang.String r2 = "invisible"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0225
            r10 = r12
            goto L_0x0226
        L_0x0225:
            r10 = -1
        L_0x0226:
            if (r10 == 0) goto L_0x0244
            if (r10 == r12) goto L_0x0244
            if (r10 != r11) goto L_0x022d
            goto L_0x0244
        L_0x022d:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unknown value "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0244:
            return r12
        L_0x0245:
            java.lang.String r3 = "download"
            r0.reportAction(r3, r9)
            boolean r3 = r8.equalsIgnoreCase(r1)
            if (r3 == 0) goto L_0x0256
            java.lang.String r1 = "mraidOpen"
            r0.reportAction(r1, r9)
            goto L_0x0261
        L_0x0256:
            boolean r1 = r6.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0261
            java.lang.String r1 = "nonMraidOpen"
            r0.reportAction(r1, r9)
        L_0x0261:
            com.vungle.warren.model.Advertisement r1 = r0.advertisement
            java.lang.String r1 = r1.getDeeplinkUrl()
            com.google.gson.JsonElement r2 = r2.get(r13)
            java.lang.String r2 = r2.getAsString()
            if (r1 == 0) goto L_0x0277
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x0280
        L_0x0277:
            if (r2 == 0) goto L_0x0294
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x0280
            goto L_0x0294
        L_0x0280:
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r3 = r0.adView
            com.vungle.warren.ui.PresenterAppLeftCallback r4 = new com.vungle.warren.ui.PresenterAppLeftCallback
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r5 = r0.bus
            com.vungle.warren.model.Placement r6 = r0.placement
            r4.<init>(r5, r6)
            com.vungle.warren.ui.presenter.MRAIDAdPresenter$6 r5 = new com.vungle.warren.ui.presenter.MRAIDAdPresenter$6
            r5.<init>()
            r3.open(r1, r2, r4, r5)
            goto L_0x029b
        L_0x0294:
            java.lang.String r1 = TAG
            java.lang.String r2 = "CTA destination URL is not configured properly"
            android.util.Log.e(r1, r2)
        L_0x029b:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r0.bus
            if (r1 == 0) goto L_0x02aa
            com.vungle.warren.model.Placement r2 = r0.placement
            java.lang.String r2 = r2.getId()
            java.lang.String r3 = "adClick"
            r1.onNext(r8, r3, r2)
        L_0x02aa:
            return r12
        L_0x02ab:
            com.google.gson.JsonElement r1 = r2.get(r15)
            java.lang.String r1 = r1.getAsString()
            com.vungle.warren.analytics.AdAnalytics r2 = r0.analytics
            com.vungle.warren.model.Advertisement r3 = r0.advertisement
            java.lang.String[] r1 = r3.getTpatUrls(r1)
            r2.ping(r1)
            return r12
        L_0x02bf:
            com.google.gson.JsonElement r1 = r2.get(r15)
            java.lang.String r1 = r1.getAsString()
            java.lang.String r4 = "value"
            com.google.gson.JsonElement r2 = r2.get(r4)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.model.Report r4 = r0.report
            long r5 = java.lang.System.currentTimeMillis()
            r4.recordAction(r1, r2, r5)
            com.vungle.warren.persistence.Repository r4 = r0.repository
            com.vungle.warren.model.Report r5 = r0.report
            com.vungle.warren.persistence.Repository$SaveCallback r6 = r0.repoCallback
            r4.save(r5, r6)
            java.lang.String r4 = "videoViewed"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0328
            r4 = 0
            float r5 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x02f1 }
            goto L_0x02f9
        L_0x02f1:
            java.lang.String r5 = TAG
            java.lang.String r6 = "value for videoViewed is null !"
            android.util.Log.e(r5, r6)
            r5 = r4
        L_0x02f9:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r6 = r0.bus
            if (r6 == 0) goto L_0x031b
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x031b
            boolean r4 = r0.adViewed
            if (r4 != 0) goto L_0x031b
            r0.adViewed = r12
            com.vungle.warren.model.Placement r4 = r0.placement
            java.lang.String r4 = r4.getId()
            java.lang.String r5 = "adViewed"
            r6.onNext(r5, r9, r4)
            java.lang.String[] r4 = r0.impressionUrls
            if (r4 == 0) goto L_0x031b
            com.vungle.warren.analytics.AdAnalytics r5 = r0.analytics
            r5.ping(r4)
        L_0x031b:
            long r4 = r0.duration
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0328
            com.vungle.warren.ui.DurationRecorder r4 = r0.durationRecorder
            r4.update()
        L_0x0328:
            java.lang.String r4 = "videoLength"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0341
            long r5 = java.lang.Long.parseLong(r2)
            r0.duration = r5
            r0.reportAction(r4, r2)
            com.vungle.warren.ui.presenter.MRAIDAdPresenter$4 r1 = new com.vungle.warren.ui.presenter.MRAIDAdPresenter$4
            r1.<init>()
            r3.post(r1)
        L_0x0341:
            com.vungle.warren.ui.presenter.MRAIDAdPresenter$5 r1 = new com.vungle.warren.ui.presenter.MRAIDAdPresenter$5
            r1.<init>()
            r3.post(r1)
            return r12
        L_0x034a:
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r1 = r0.cookieMap
            java.lang.String r3 = "consentIsImportantToVungle"
            java.lang.Object r1 = r1.get(r3)
            com.vungle.warren.model.Cookie r1 = (com.vungle.warren.model.Cookie) r1
            if (r1 != 0) goto L_0x035b
            com.vungle.warren.model.Cookie r1 = new com.vungle.warren.model.Cookie
            r1.<init>(r3)
        L_0x035b:
            com.google.gson.JsonElement r2 = r2.get(r15)
            java.lang.String r2 = r2.getAsString()
            java.lang.String r3 = "consent_status"
            r1.putValue(r3, r2)
            java.lang.String r2 = "consent_source"
            java.lang.String r3 = "vungle_modal"
            r1.putValue(r2, r3)
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "timestamp"
            r1.putValue(r3, r2)
            com.vungle.warren.persistence.Repository r2 = r0.repository
            com.vungle.warren.persistence.Repository$SaveCallback r3 = r0.repoCallback
            r2.save(r1, r3)
            return r12
        L_0x0387:
            java.lang.String r1 = "mraidClose"
            r0.reportAction(r1, r9)
            r16.closeView()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.ui.presenter.MRAIDAdPresenter.processCommand(java.lang.String, com.google.gson.JsonObject):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMraidAction(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -314498168(0xffffffffed412388, float:-3.7358476E27)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 94756344(0x5a5ddf8, float:1.5598064E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 1427818632(0x551ac888, float:1.06366291E13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "download"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = r3
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "close"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "privacy"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = r2
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x0057
            if (r0 == r3) goto L_0x0053
            if (r0 != r2) goto L_0x003c
            goto L_0x005a
        L_0x003c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown action "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0053:
            r4.download()
            goto L_0x005a
        L_0x0057:
            r4.closeView()
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.ui.presenter.MRAIDAdPresenter.onMraidAction(java.lang.String):void");
    }

    private void download() {
        reportAction("cta", "");
        try {
            this.analytics.ping(new String[]{this.advertisement.getCTAURL(true)});
            this.adView.open(this.advertisement.getDeeplinkUrl(), this.advertisement.getCTAURL(false), new PresenterAppLeftCallback(this.bus, this.placement), new PresenterAdOpenCallback() {
                public void onAdOpenType(PresenterAdOpenCallback.AdOpenType adOpenType) {
                    if (adOpenType == PresenterAdOpenCallback.AdOpenType.DEEP_LINK) {
                        MRAIDAdPresenter.this.reportAction(MRAIDAdPresenter.OPEN_DEEPLINK_SUCCESS, (String) null);
                    }
                }
            });
        } catch (ActivityNotFoundException unused) {
            VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#download", "Download - Activity Not Found");
        }
    }

    /* access modifiers changed from: private */
    public void closeView() {
        this.adView.close();
        this.scheduler.cancelAll();
    }

    private void loadData(OptionsState optionsState) {
        this.cookieMap.put(Cookie.INCENTIVIZED_TEXT_COOKIE, this.repository.load(Cookie.INCENTIVIZED_TEXT_COOKIE, Cookie.class).get());
        this.cookieMap.put(Cookie.CONSENT_COOKIE, this.repository.load(Cookie.CONSENT_COOKIE, Cookie.class).get());
        this.cookieMap.put(Cookie.CONFIG_COOKIE, this.repository.load(Cookie.CONFIG_COOKIE, Cookie.class).get());
        if (optionsState != null) {
            String string = optionsState.getString(EXTRA_REPORT);
            Report report2 = TextUtils.isEmpty(string) ? null : this.repository.load(string, Report.class).get();
            if (report2 != null) {
                this.report = report2;
            }
        }
    }

    public void onReceivedError(String str, boolean z) {
        recordMraidError(str);
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#onReceivedError", str);
        if (z) {
            reportErrorAndCloseAd(new VungleException(38));
        }
    }

    public boolean onWebRenderingProcessGone(WebView webView, boolean z) {
        handleWebViewException(new VungleException(31));
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "onWebRenderingProcessGone", new VungleException(31).getLocalizedMessage());
        return true;
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        VungleException vungleException = new VungleException(32);
        handleWebViewException(vungleException);
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#onRenderProcessUnresponsive", vungleException.getLocalizedMessage());
    }

    /* access modifiers changed from: private */
    public void handleWebViewException(VungleException vungleException) {
        WebAdContract.WebAdView webAdView = this.adView;
        if (webAdView != null) {
            webAdView.removeWebView();
        }
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#handleWebViewException", "WebViewException: " + vungleException.getLocalizedMessage());
        reportErrorAndCloseAd(vungleException);
    }

    private void reportErrorAndCloseAd(VungleException vungleException) {
        makeBusError(vungleException);
        closeView();
    }

    /* access modifiers changed from: private */
    public void makeBusError(VungleException vungleException) {
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onError(vungleException, this.placement.getId());
        }
    }

    /* access modifiers changed from: private */
    public void recordPlayRemoteUrl() {
        Report report2;
        Advertisement advertisement2 = this.repository.load(this.advertisement.getId(), Advertisement.class).get();
        if (advertisement2 != null && (report2 = this.report) != null) {
            report2.setAllAssetDownloaded(advertisement2.assetsFullyDownloaded);
            this.repository.save(this.report, this.repoCallback);
        }
    }

    private void recordMraidError(String str) {
        if (this.report != null && !TextUtils.isEmpty(str)) {
            this.report.recordError(str);
            this.repository.save(this.report, this.repoCallback);
        }
    }
}
