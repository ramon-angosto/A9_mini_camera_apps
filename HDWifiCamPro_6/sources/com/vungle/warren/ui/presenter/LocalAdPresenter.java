package com.vungle.warren.ui.presenter;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.analytics.AnalyticsEvent;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.model.token.Gdpr;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.ui.DurationRecorder;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.ui.PresenterAppLeftCallback;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.contract.LocalAdContract;
import com.vungle.warren.ui.state.OptionsState;
import com.vungle.warren.ui.view.WebViewAPI;
import com.vungle.warren.utility.AsyncFileUtils;
import com.vungle.warren.utility.Constants;
import com.vungle.warren.utility.Scheduler;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class LocalAdPresenter implements LocalAdContract.LocalPresenter, WebViewAPI.WebClientErrorHandler {
    static final String EXTRA_INCENTIVIZED_SENT = "incentivized_sent";
    static final String EXTRA_IN_POST = "in_post_roll";
    static final String EXTRA_IS_MUTED = "is_muted_mode";
    static final String EXTRA_REPORT = "saved_report";
    static final String EXTRA_VIDEO_POSITION = "videoPosition";
    static final String HTTPS_VUNGLE_COM_PRIVACY = "https://vungle.com/privacy/";
    public static final int INCENTIVIZED_TRESHOLD = 75;
    static final String TAG = "LocalAdPresenter";
    /* access modifiers changed from: private */
    public LocalAdContract.LocalView adView;
    private boolean adViewed;
    /* access modifiers changed from: private */
    public Advertisement advertisement;
    /* access modifiers changed from: private */
    public final AdAnalytics analytics;
    private File assetDir;
    private AdContract.AdvertisementPresenter.EventListener bus;
    private AtomicBoolean busy = new AtomicBoolean(false);
    private LinkedList<Advertisement.Checkpoint> checkpointList = new LinkedList<>();
    private final Map<String, Cookie> cookies = new HashMap();
    private String dialogBody = "If you exit now, you will not get your reward";
    private String dialogClose = "Close";
    private String dialogContinue = "Continue";
    private String dialogTitle = "Are you sure?";
    private int duration;
    private DurationRecorder durationRecorder;
    private AsyncFileUtils.ExistenceOperation fileExistenceOperation;
    private final String[] impressionUrls;
    /* access modifiers changed from: private */
    public boolean inPost;
    private AtomicBoolean isDestroying = new AtomicBoolean(false);
    private boolean muted;
    private Placement placement;
    private int progress;
    private Repository.SaveCallback repoCallback = new Repository.SaveCallback() {
        boolean errorHappened = false;

        public void onSaved() {
        }

        public void onError(Exception exc) {
            if (!this.errorHappened) {
                this.errorHappened = true;
                LocalAdPresenter.this.makeBusError(26);
                VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onError", new VungleException(26).getLocalizedMessage());
                LocalAdPresenter.this.closeAndReport();
            }
        }
    };
    private Report report;
    /* access modifiers changed from: private */
    public Repository repository;
    private final Scheduler scheduler;
    private AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public boolean userExitEnabled;
    private int videoPosition;
    private final WebViewAPI webViewAPI;

    public LocalAdPresenter(Advertisement advertisement2, Placement placement2, Repository repository2, Scheduler scheduler2, AdAnalytics adAnalytics, WebViewAPI webViewAPI2, OptionsState optionsState, File file, String[] strArr) {
        this.advertisement = advertisement2;
        this.placement = placement2;
        this.scheduler = scheduler2;
        this.analytics = adAnalytics;
        this.webViewAPI = webViewAPI2;
        this.repository = repository2;
        this.assetDir = file;
        this.impressionUrls = strArr;
        if (advertisement2.getCheckpoints() != null) {
            this.checkpointList.addAll(advertisement2.getCheckpoints());
            Collections.sort(this.checkpointList);
        }
        loadData(optionsState);
    }

    public void setEventListener(AdContract.AdvertisementPresenter.EventListener eventListener) {
        this.bus = eventListener;
    }

    private void reportError(String str) {
        this.report.recordError(str);
        this.repository.save(this.report, this.repoCallback);
        makeBusError(27);
        if (this.inPost || !this.advertisement.hasPostroll()) {
            makeBusError(10);
            this.adView.close();
            return;
        }
        playPost();
    }

    public void reportAction(String str, String str2) {
        if (str.equals("videoLength")) {
            this.duration = Integer.parseInt(str2);
            this.report.setVideoLength((long) this.duration);
            this.repository.save(this.report, this.repoCallback);
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -840405966) {
            if (hashCode != 3363353) {
                if (hashCode == 1370606900 && str.equals(AnalyticsEvent.Ad.videoClose)) {
                    c = 2;
                }
            } else if (str.equals("mute")) {
                c = 0;
            }
        } else if (str.equals("unmute")) {
            c = 1;
        }
        if (c == 0 || c == 1 || c == 2) {
            this.analytics.ping(this.advertisement.getTpatUrls(str));
        }
        this.report.recordAction(str, str2, System.currentTimeMillis());
        this.repository.save(this.report, this.repoCallback);
    }

    public void onViewConfigurationChanged() {
        this.webViewAPI.notifyPropertiesChange(true);
        this.adView.refreshDialogIfVisible();
    }

    public void attach(LocalAdContract.LocalView localView, OptionsState optionsState) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = localView;
        localView.setPresenter(this);
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext(Constants.ATTACH, this.advertisement.getCreativeId(), this.placement.getId());
        }
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            this.muted = (settings & 1) == 1;
            if ((settings & 2) == 2) {
                z = true;
            }
            this.userExitEnabled = z;
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
                localView.setOrientation(i);
                prepare(optionsState);
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, true).addData(SessionAttribute.EVENT_ID, this.advertisement.getId()).build());
            }
        } else if (adOrientation != 0) {
            if (adOrientation != 1) {
                i = 4;
            }
            Log.d(TAG, "Requested Orientation " + i);
            localView.setOrientation(i);
            prepare(optionsState);
            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, true).addData(SessionAttribute.EVENT_ID, this.advertisement.getId()).build());
        }
        i = 7;
        Log.d(TAG, "Requested Orientation " + i);
        localView.setOrientation(i);
        prepare(optionsState);
        SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, true).addData(SessionAttribute.EVENT_ID, this.advertisement.getId()).build());
    }

    public void detach(int i) {
        AsyncFileUtils.ExistenceOperation existenceOperation = this.fileExistenceOperation;
        if (existenceOperation != null) {
            existenceOperation.cancel();
        }
        stop(i);
        this.adView.destroyAdView(0);
    }

    private void playPost() {
        File file = new File(this.assetDir.getPath());
        final File file2 = new File(file.getPath() + File.separator + "index.html");
        this.fileExistenceOperation = AsyncFileUtils.isFileExistAsync(file2, new AsyncFileUtils.FileExistCallback() {
            public void status(boolean z) {
                if (z) {
                    LocalAdContract.LocalView access$200 = LocalAdPresenter.this.adView;
                    access$200.showWebsite(Advertisement.FILE_SCHEME + file2.getPath());
                    LocalAdPresenter.this.analytics.ping(LocalAdPresenter.this.advertisement.getTpatUrls(AnalyticsEvent.Ad.postrollView));
                    boolean unused = LocalAdPresenter.this.inPost = true;
                    return;
                }
                LocalAdPresenter.this.makeBusError(27);
                LocalAdPresenter.this.makeBusError(10);
                VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#playPost", "Error Rendering Postroll");
                LocalAdPresenter.this.closeAndReport();
            }
        });
    }

    private void prepare(OptionsState optionsState) {
        String str;
        restoreFromSave(optionsState);
        Cookie cookie = this.cookies.get(Cookie.INCENTIVIZED_TEXT_COOKIE);
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
        this.webViewAPI.setErrorHandler(this);
        this.adView.showCTAOverlay(this.advertisement.isCtaOverlayEnabled(), this.advertisement.getCtaClickArea());
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext("start", (String) null, this.placement.getId());
        }
    }

    private boolean needShowGDPR(Cookie cookie) {
        return cookie != null && cookie.getBoolean("is_country_data_protected").booleanValue() && "unknown".equals(cookie.getString("consent_status"));
    }

    private void showGDPR(final Cookie cookie) {
        AnonymousClass3 r5 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                cookie.putValue("consent_status", i == -2 ? "opted_out" : i == -1 ? "opted_in" : Gdpr.OPTED_OUT_BY_TIMEOUT);
                cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie.putValue("consent_source", "vungle_modal");
                LocalAdPresenter.this.repository.save(cookie, (Repository.SaveCallback) null);
                LocalAdPresenter.this.start();
            }
        };
        cookie.putValue("consent_status", Gdpr.OPTED_OUT_BY_TIMEOUT);
        cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        cookie.putValue("consent_source", "vungle_modal");
        this.repository.save(cookie, this.repoCallback);
        showDialog(cookie.getString("consent_title"), cookie.getString("consent_message"), cookie.getString("button_accept"), cookie.getString("button_deny"), r5);
    }

    public boolean handleExit() {
        if (this.inPost) {
            closeAndReport();
            return true;
        } else if (!this.userExitEnabled) {
            return false;
        } else {
            if (!this.placement.isIncentivized() || this.progress > 75) {
                reportAction(AnalyticsEvent.Ad.videoClose, (String) null);
                if (this.advertisement.hasPostroll()) {
                    playPost();
                    return false;
                }
                closeAndReport();
                return true;
            }
            showIncetivizedDialog();
            return false;
        }
    }

    private void showIncetivizedDialog() {
        String str = this.dialogTitle;
        String str2 = this.dialogBody;
        String str3 = this.dialogContinue;
        String str4 = this.dialogClose;
        Cookie cookie = this.cookies.get(Cookie.INCENTIVIZED_TEXT_COOKIE);
        if (cookie != null) {
            str = cookie.getString(CampaignEx.JSON_KEY_TITLE);
            if (TextUtils.isEmpty(str)) {
                str = this.dialogTitle;
            }
            str2 = cookie.getString(TtmlNode.TAG_BODY);
            if (TextUtils.isEmpty(str2)) {
                str2 = this.dialogBody;
            }
            str3 = cookie.getString("continue");
            if (TextUtils.isEmpty(str3)) {
                str3 = this.dialogContinue;
            }
            str4 = cookie.getString("close");
            if (TextUtils.isEmpty(str4)) {
                str4 = this.dialogClose;
            }
        }
        showDialog(str, str2, str3, str4, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == -2) {
                    LocalAdPresenter.this.reportAction(AnalyticsEvent.Ad.videoClose, (String) null);
                    LocalAdPresenter.this.continueWithPostroll();
                }
            }
        });
    }

    private void showDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        this.adView.pauseVideo();
        this.adView.showDialog(str, str2, str3, str4, onClickListener);
    }

    /* access modifiers changed from: private */
    public void continueWithPostroll() {
        if (this.advertisement.hasPostroll()) {
            playPost();
        } else {
            closeAndReport();
        }
    }

    private boolean isWebPageBlank() {
        String websiteUrl = this.adView.getWebsiteUrl();
        return TextUtils.isEmpty(websiteUrl) || "about:blank".equalsIgnoreCase(websiteUrl);
    }

    public void start() {
        this.durationRecorder.start();
        if (!this.adView.hasWebView()) {
            reportErrorAndCloseAd(31);
            VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#start", new VungleException(31).getLocalizedMessage());
            return;
        }
        this.adView.setImmersiveMode();
        this.adView.resumeWeb();
        Cookie cookie = this.cookies.get(Cookie.CONSENT_COOKIE);
        if (needShowGDPR(cookie)) {
            showGDPR(cookie);
        } else if (this.inPost) {
            if (isWebPageBlank()) {
                playPost();
            }
        } else if (!this.adView.isVideoPlaying() && !this.adView.isDialogVisible()) {
            this.adView.playVideo(new File(this.assetDir.getPath() + File.separator + "video"), this.muted, this.videoPosition);
            int showCloseDelay = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
            if (showCloseDelay > 0) {
                this.scheduler.schedule(new Runnable() {
                    public void run() {
                        boolean unused = LocalAdPresenter.this.userExitEnabled = true;
                        if (!LocalAdPresenter.this.inPost) {
                            LocalAdPresenter.this.adView.showCloseButton();
                        }
                    }
                }, (long) showCloseDelay);
                return;
            }
            this.userExitEnabled = true;
            this.adView.showCloseButton();
        }
    }

    public void stop(int i) {
        this.durationRecorder.stop();
        boolean z = false;
        boolean z2 = (i & 1) != 0;
        if ((i & 2) != 0) {
            z = true;
        }
        this.adView.pauseWeb();
        if (this.adView.isVideoPlaying()) {
            this.videoPosition = this.adView.getVideoPosition();
            this.adView.pauseVideo();
        }
        if (z2 || !z) {
            if (this.inPost || z) {
                this.adView.showWebsite("about:blank");
            }
        } else if (!this.isDestroying.getAndSet(true)) {
            String str = null;
            reportAction("close", (String) null);
            this.scheduler.cancelAll();
            AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext(TtmlNode.END, str, this.placement.getId());
            }
        }
    }

    public void onProgressUpdate(int i, float f) {
        this.progress = (int) ((((float) i) / f) * 100.0f);
        this.videoPosition = i;
        this.durationRecorder.update();
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext("percentViewed:" + this.progress, (String) null, this.placement.getId());
        }
        AdContract.AdvertisementPresenter.EventListener eventListener2 = this.bus;
        if (eventListener2 != null && i > 0 && !this.adViewed) {
            this.adViewed = true;
            eventListener2.onNext("adViewed", (String) null, this.placement.getId());
            String[] strArr = this.impressionUrls;
            if (strArr != null) {
                this.analytics.ping(strArr);
            }
        }
        reportAction("video_viewed", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(i)}));
        if (this.progress == 100) {
            if (this.checkpointList.peekLast() != null && this.checkpointList.peekLast().getPercentage() == 100) {
                this.analytics.ping(this.checkpointList.pollLast().getUrls());
            }
            continueWithPostroll();
        }
        this.report.recordProgress(this.videoPosition);
        this.repository.save(this.report, this.repoCallback);
        while (this.checkpointList.peek() != null && this.progress > this.checkpointList.peek().getPercentage()) {
            this.analytics.ping(this.checkpointList.poll().getUrls());
        }
        Cookie cookie = this.cookies.get(Cookie.CONFIG_COOKIE);
        if (this.placement.isIncentivized() && this.progress > 75 && cookie != null && cookie.getBoolean("isReportIncentivizedEnabled").booleanValue() && !this.sendReportIncentivized.getAndSet(true)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("placement_reference_id", new JsonPrimitive(this.placement.getId()));
            jsonObject.add("app_id", new JsonPrimitive(this.advertisement.getAppID()));
            jsonObject.add(ReportDBAdapter.ReportColumns.COLUMN_AD_START_TIME, new JsonPrimitive((Number) Long.valueOf(this.report.getAdStartTime())));
            jsonObject.add("user", new JsonPrimitive(this.report.getUserID()));
            this.analytics.ri(jsonObject);
        }
    }

    public void onVideoStart(int i, float f) {
        reportAction("videoLength", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf((int) f)}));
    }

    public void onMute(boolean z) {
        this.muted = z;
        if (z) {
            reportAction("mute", "true");
        } else {
            reportAction("unmute", "false");
        }
    }

    public void onDownload() {
        download();
    }

    public boolean onMediaError(String str) {
        reportError(str);
        VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onMediaError", "Media Error: " + str);
        return false;
    }

    public void onPrivacy() {
        this.adView.open((String) null, HTTPS_VUNGLE_COM_PRIVACY, new PresenterAppLeftCallback(this.bus, this.placement), (PresenterAdOpenCallback) null);
    }

    public void generateSaveState(OptionsState optionsState) {
        if (optionsState != null) {
            this.repository.save(this.report, this.repoCallback);
            Report report2 = this.report;
            optionsState.put(EXTRA_REPORT, report2 == null ? null : report2.getId());
            optionsState.put(EXTRA_INCENTIVIZED_SENT, this.sendReportIncentivized.get());
            optionsState.put(EXTRA_IN_POST, this.inPost);
            optionsState.put(EXTRA_IS_MUTED, this.muted);
            LocalAdContract.LocalView localView = this.adView;
            optionsState.put(EXTRA_VIDEO_POSITION, (localView == null || !localView.isVideoPlaying()) ? this.videoPosition : this.adView.getVideoPosition());
        }
    }

    public void restoreFromSave(OptionsState optionsState) {
        if (optionsState != null) {
            if (optionsState.getBoolean(EXTRA_INCENTIVIZED_SENT, false)) {
                this.sendReportIncentivized.set(true);
            }
            this.inPost = optionsState.getBoolean(EXTRA_IN_POST, this.inPost);
            this.muted = optionsState.getBoolean(EXTRA_IS_MUTED, this.muted);
            this.videoPosition = optionsState.getInt(EXTRA_VIDEO_POSITION, this.videoPosition).intValue();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
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
            if (r0 == 0) goto L_0x0076
            if (r0 == r3) goto L_0x006f
            if (r0 != r2) goto L_0x003c
            goto L_0x0079
        L_0x003c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<com.vungle.warren.ui.presenter.LocalAdPresenter> r1 = com.vungle.warren.ui.presenter.LocalAdPresenter.class
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = "#onMraidAction"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Unknown MRAID Command"
            com.vungle.warren.VungleLogger.error(r0, r1)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown action "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x006f:
            r4.download()
            r4.closeAndReport()
            goto L_0x0079
        L_0x0076:
            r4.closeAndReport()
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.ui.presenter.LocalAdPresenter.onMraidAction(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0079 A[Catch:{ ActivityNotFoundException -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void download() {
        /*
            r7 = this;
            java.lang.String r0 = "LocalAdPresenter"
            java.lang.String r1 = "cta"
            java.lang.String r2 = ""
            r7.reportAction(r1, r2)
            com.vungle.warren.analytics.AdAnalytics r1 = r7.analytics     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.model.Advertisement r2 = r7.advertisement     // Catch:{ ActivityNotFoundException -> 0x0089 }
            java.lang.String r3 = "postroll_click"
            java.lang.String[] r2 = r2.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r1.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.analytics.AdAnalytics r1 = r7.analytics     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.model.Advertisement r2 = r7.advertisement     // Catch:{ ActivityNotFoundException -> 0x0089 }
            java.lang.String r3 = "click_url"
            java.lang.String[] r2 = r2.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r1.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.analytics.AdAnalytics r1 = r7.analytics     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.model.Advertisement r2 = r7.advertisement     // Catch:{ ActivityNotFoundException -> 0x0089 }
            java.lang.String r3 = "video_click"
            java.lang.String[] r2 = r2.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r1.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.analytics.AdAnalytics r1 = r7.analytics     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.model.Advertisement r4 = r7.advertisement     // Catch:{ ActivityNotFoundException -> 0x0089 }
            java.lang.String r2 = r4.getCTAURL(r2)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r4 = 0
            r3[r4] = r2     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r1.ping(r3)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            java.lang.String r1 = "download"
            r2 = 0
            r7.reportAction(r1, r2)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.model.Advertisement r1 = r7.advertisement     // Catch:{ ActivityNotFoundException -> 0x0089 }
            java.lang.String r1 = r1.getCTAURL(r4)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            if (r1 == 0) goto L_0x0070
            boolean r2 = r1.isEmpty()     // Catch:{ ActivityNotFoundException -> 0x0089 }
            if (r2 == 0) goto L_0x0056
            goto L_0x0070
        L_0x0056:
            com.vungle.warren.ui.contract.LocalAdContract$LocalView r2 = r7.adView     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.model.Advertisement r3 = r7.advertisement     // Catch:{ ActivityNotFoundException -> 0x0089 }
            java.lang.String r3 = r3.getDeeplinkUrl()     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.ui.PresenterAppLeftCallback r4 = new com.vungle.warren.ui.PresenterAppLeftCallback     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r5 = r7.bus     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.model.Placement r6 = r7.placement     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r4.<init>(r5, r6)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            com.vungle.warren.ui.presenter.LocalAdPresenter$6 r5 = new com.vungle.warren.ui.presenter.LocalAdPresenter$6     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r5.<init>()     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r2.open(r3, r1, r4, r5)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            goto L_0x0075
        L_0x0070:
            java.lang.String r1 = "CTA destination URL is not configured properly"
            android.util.Log.e(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x0089 }
        L_0x0075:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r7.bus     // Catch:{ ActivityNotFoundException -> 0x0089 }
            if (r1 == 0) goto L_0x00aa
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r7.bus     // Catch:{ ActivityNotFoundException -> 0x0089 }
            java.lang.String r2 = "open"
            java.lang.String r3 = "adClick"
            com.vungle.warren.model.Placement r4 = r7.placement     // Catch:{ ActivityNotFoundException -> 0x0089 }
            java.lang.String r4 = r4.getId()     // Catch:{ ActivityNotFoundException -> 0x0089 }
            r1.onNext(r2, r3, r4)     // Catch:{ ActivityNotFoundException -> 0x0089 }
            goto L_0x00aa
        L_0x0089:
            java.lang.String r1 = "Unable to find destination activity"
            android.util.Log.e(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<com.vungle.warren.ui.presenter.LocalAdPresenter> r1 = com.vungle.warren.ui.presenter.LocalAdPresenter.class
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = "#download"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Download - Activity Not Found"
            com.vungle.warren.VungleLogger.error(r0, r1)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.ui.presenter.LocalAdPresenter.download():void");
    }

    /* access modifiers changed from: private */
    public void closeAndReport() {
        if (this.busy.get()) {
            Log.w(TAG, "Busy with closing");
            return;
        }
        this.busy.set(true);
        reportAction("close", (String) null);
        this.scheduler.cancelAll();
        this.adView.close();
    }

    private void loadData(OptionsState optionsState) {
        this.cookies.put(Cookie.INCENTIVIZED_TEXT_COOKIE, this.repository.load(Cookie.INCENTIVIZED_TEXT_COOKIE, Cookie.class).get());
        this.cookies.put(Cookie.CONSENT_COOKIE, this.repository.load(Cookie.CONSENT_COOKIE, Cookie.class).get());
        this.cookies.put(Cookie.CONFIG_COOKIE, this.repository.load(Cookie.CONFIG_COOKIE, Cookie.class).get());
        if (optionsState != null) {
            String string = optionsState.getString(EXTRA_REPORT);
            Report report2 = TextUtils.isEmpty(string) ? null : this.repository.load(string, Report.class).get();
            if (report2 != null) {
                this.report = report2;
            }
        }
    }

    public void onReceivedError(String str, boolean z) {
        Report report2 = this.report;
        if (report2 != null) {
            report2.recordError(str);
            this.repository.save(this.report, this.repoCallback);
            VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "onReceivedError", str);
        }
    }

    public boolean onWebRenderingProcessGone(WebView webView, boolean z) {
        handleWebViewException(31);
        VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onWebRenderingProcessGone", new VungleException(31).getLocalizedMessage());
        return true;
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException(32);
        VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onRenderProcessUnresponsive", new VungleException(32).getLocalizedMessage());
    }

    private void handleWebViewException(int i) {
        LocalAdContract.LocalView localView = this.adView;
        if (localView != null) {
            localView.removeWebView();
        }
        reportErrorAndCloseAd(i);
    }

    private void reportErrorAndCloseAd(int i) {
        makeBusError(i);
        String simpleName = LocalAdPresenter.class.getSimpleName();
        VungleLogger.error(simpleName, "WebViewException: " + new VungleException(i).getLocalizedMessage());
        closeAndReport();
    }

    /* access modifiers changed from: private */
    public void makeBusError(int i) {
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onError(new VungleException(i), this.placement.getId());
        }
    }
}
