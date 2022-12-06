package com.vungle.warren.ui.presenter;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.model.token.Gdpr;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.ui.DurationRecorder;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.ui.PresenterAppLeftCallback;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.contract.NativeAdContract;
import com.vungle.warren.ui.state.OptionsState;
import com.vungle.warren.utility.Constants;
import com.vungle.warren.utility.Scheduler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeAdPresenter implements NativeAdContract.NativePresenter {
    private static final String EXTRA_INCENTIVIZED_SENT = "incentivized_sent";
    private static final String EXTRA_REPORT = "saved_report";
    private static final String NO_VALUE = "";
    private static final String OPEN_ACTION = "mraidOpen";
    private static final String OPEN_DEEPLINK_SUCCESS = "deeplinkSuccess";
    private static final String TAG = NativeAdPresenter.class.getSimpleName();
    private NativeAdContract.NativeView adView;
    private boolean adViewed;
    private final Advertisement advertisement;
    private final AdAnalytics analytics;
    private AdContract.AdvertisementPresenter.EventListener bus;
    private final LinkedList<Advertisement.Checkpoint> checkpointList = new LinkedList<>();
    private final Map<String, Cookie> cookies = new HashMap();
    private DurationRecorder durationRecorder;
    private final String[] impressionUrls;
    private final AtomicBoolean isDestroying = new AtomicBoolean(false);
    private final Placement placement;
    private final Repository.SaveCallback repoCallback = new Repository.SaveCallback() {
        boolean errorHappened = false;

        public void onSaved() {
        }

        public void onError(Exception exc) {
            if (!this.errorHappened) {
                this.errorHappened = true;
                NativeAdPresenter.this.makeBusError(26);
                VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onError", new VungleException(26).getLocalizedMessage());
                NativeAdPresenter.this.closeView();
            }
        }
    };
    private Report report;
    /* access modifiers changed from: private */
    public final Repository repository;
    private final Scheduler scheduler;
    private final AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);

    public void onMraidAction(String str) {
    }

    public NativeAdPresenter(Advertisement advertisement2, Placement placement2, Repository repository2, Scheduler scheduler2, AdAnalytics adAnalytics, OptionsState optionsState, String[] strArr) {
        this.advertisement = advertisement2;
        this.placement = placement2;
        this.repository = repository2;
        this.scheduler = scheduler2;
        this.analytics = adAnalytics;
        this.impressionUrls = strArr;
        if (advertisement2.getCheckpoints() != null) {
            this.checkpointList.addAll(advertisement2.getCheckpoints());
        }
        loadData(optionsState);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067 A[Catch:{ ActivityNotFoundException -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDownload() {
        /*
            r6 = this;
            java.lang.String r0 = "mraidOpen"
            java.lang.String r1 = ""
            r6.reportAction(r0, r1)
            com.vungle.warren.analytics.AdAnalytics r0 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x0077 }
            com.vungle.warren.model.Advertisement r1 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x0077 }
            java.lang.String r2 = "clickUrl"
            java.lang.String[] r1 = r1.getTpatUrls(r2)     // Catch:{ ActivityNotFoundException -> 0x0077 }
            r0.ping(r1)     // Catch:{ ActivityNotFoundException -> 0x0077 }
            com.vungle.warren.analytics.AdAnalytics r0 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x0077 }
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ ActivityNotFoundException -> 0x0077 }
            com.vungle.warren.model.Advertisement r3 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x0077 }
            java.lang.String r1 = r3.getCTAURL(r1)     // Catch:{ ActivityNotFoundException -> 0x0077 }
            r3 = 0
            r2[r3] = r1     // Catch:{ ActivityNotFoundException -> 0x0077 }
            r0.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x0077 }
            java.lang.String r0 = "download"
            r1 = 0
            r6.reportAction(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x0077 }
            com.vungle.warren.model.Advertisement r0 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x0077 }
            java.lang.String r0 = r0.getCTAURL(r3)     // Catch:{ ActivityNotFoundException -> 0x0077 }
            com.vungle.warren.model.Advertisement r1 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x0077 }
            java.lang.String r1 = r1.getDeeplinkUrl()     // Catch:{ ActivityNotFoundException -> 0x0077 }
            if (r1 == 0) goto L_0x003f
            boolean r2 = r1.isEmpty()     // Catch:{ ActivityNotFoundException -> 0x0077 }
            if (r2 == 0) goto L_0x0048
        L_0x003f:
            if (r0 == 0) goto L_0x005c
            boolean r2 = r0.isEmpty()     // Catch:{ ActivityNotFoundException -> 0x0077 }
            if (r2 == 0) goto L_0x0048
            goto L_0x005c
        L_0x0048:
            com.vungle.warren.ui.contract.NativeAdContract$NativeView r2 = r6.adView     // Catch:{ ActivityNotFoundException -> 0x0077 }
            com.vungle.warren.ui.PresenterAppLeftCallback r3 = new com.vungle.warren.ui.PresenterAppLeftCallback     // Catch:{ ActivityNotFoundException -> 0x0077 }
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r6.bus     // Catch:{ ActivityNotFoundException -> 0x0077 }
            com.vungle.warren.model.Placement r5 = r6.placement     // Catch:{ ActivityNotFoundException -> 0x0077 }
            r3.<init>(r4, r5)     // Catch:{ ActivityNotFoundException -> 0x0077 }
            com.vungle.warren.ui.presenter.NativeAdPresenter$2 r4 = new com.vungle.warren.ui.presenter.NativeAdPresenter$2     // Catch:{ ActivityNotFoundException -> 0x0077 }
            r4.<init>()     // Catch:{ ActivityNotFoundException -> 0x0077 }
            r2.open(r1, r0, r3, r4)     // Catch:{ ActivityNotFoundException -> 0x0077 }
            goto L_0x0063
        L_0x005c:
            java.lang.String r0 = TAG     // Catch:{ ActivityNotFoundException -> 0x0077 }
            java.lang.String r1 = "CTA destination URL is not configured properly"
            android.util.Log.e(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x0077 }
        L_0x0063:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r0 = r6.bus     // Catch:{ ActivityNotFoundException -> 0x0077 }
            if (r0 == 0) goto L_0x009a
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r0 = r6.bus     // Catch:{ ActivityNotFoundException -> 0x0077 }
            java.lang.String r1 = "open"
            java.lang.String r2 = "adClick"
            com.vungle.warren.model.Placement r3 = r6.placement     // Catch:{ ActivityNotFoundException -> 0x0077 }
            java.lang.String r3 = r3.getId()     // Catch:{ ActivityNotFoundException -> 0x0077 }
            r0.onNext(r1, r2, r3)     // Catch:{ ActivityNotFoundException -> 0x0077 }
            goto L_0x009a
        L_0x0077:
            java.lang.String r0 = TAG
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
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.ui.presenter.NativeAdPresenter.onDownload():void");
    }

    public void onPrivacy() {
        this.adView.open((String) null, this.advertisement.getPrivacyUrl(), new PresenterAppLeftCallback(this.bus, this.placement), (PresenterAdOpenCallback) null);
    }

    public void setAdVisibility(boolean z) {
        String str = TAG;
        Log.d(str, "isViewable=" + z + " " + this.placement + " " + hashCode());
        if (z) {
            this.durationRecorder.start();
        } else {
            this.durationRecorder.stop();
        }
    }

    public void attach(NativeAdContract.NativeView nativeView, OptionsState optionsState) {
        Log.d(TAG, "attach() " + this.placement + " " + hashCode());
        this.isDestroying.set(false);
        this.adView = nativeView;
        nativeView.setPresenter(this);
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext(Constants.ATTACH, this.advertisement.getCreativeId(), this.placement.getId());
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
                nativeView.setOrientation(i);
                prepare(optionsState);
            }
        } else if (adOrientation != 0) {
            if (adOrientation != 1) {
                i = 4;
            }
            Log.d(TAG, "Requested Orientation " + i);
            nativeView.setOrientation(i);
            prepare(optionsState);
        }
        i = 7;
        Log.d(TAG, "Requested Orientation " + i);
        nativeView.setOrientation(i);
        prepare(optionsState);
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
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext("start", (String) null, this.placement.getId());
        }
    }

    public void detach(int i) {
        String str = TAG;
        Log.d(str, "detach() " + this.placement + " " + hashCode());
        stop(i);
        this.adView.destroyAdView(0);
    }

    public boolean handleExit() {
        closeView();
        return true;
    }

    public void start() {
        String str = TAG;
        Log.d(str, "start() " + this.placement + " " + hashCode());
        this.durationRecorder.start();
        Cookie cookie = this.cookies.get(Cookie.CONSENT_COOKIE);
        if (needShowGDPR(cookie)) {
            showGDPR(cookie);
        }
    }

    public void stop(int i) {
        Log.d(TAG, "stop() " + this.placement + " " + hashCode());
        this.durationRecorder.stop();
        boolean z = false;
        boolean z2 = (i & 1) != 0;
        boolean z3 = (i & 2) != 0;
        if ((i & 4) != 0) {
            z = true;
        }
        if (!z2 && z3 && !this.isDestroying.getAndSet(true)) {
            String str = null;
            if (z) {
                reportAction("mraidCloseByApi", (String) null);
            }
            this.repository.save(this.report, this.repoCallback);
            closeView();
            AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext(TtmlNode.END, str, this.placement.getId());
            }
        }
    }

    public void generateSaveState(OptionsState optionsState) {
        if (optionsState != null) {
            this.repository.save(this.report, this.repoCallback);
            Report report2 = this.report;
            optionsState.put(EXTRA_REPORT, report2 == null ? null : report2.getId());
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

    public void setEventListener(AdContract.AdvertisementPresenter.EventListener eventListener) {
        this.bus = eventListener;
    }

    public void onViewConfigurationChanged() {
        this.adView.refreshDialogIfVisible();
    }

    public void onProgressUpdate(int i, float f) {
        String str = TAG;
        Log.d(str, "onProgressUpdate() " + this.placement + " " + hashCode());
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null && i > 0 && !this.adViewed) {
            this.adViewed = true;
            eventListener.onNext("adViewed", (String) null, this.placement.getId());
            String[] strArr = this.impressionUrls;
            if (strArr != null) {
                this.analytics.ping(strArr);
            }
        }
        AdContract.AdvertisementPresenter.EventListener eventListener2 = this.bus;
        if (eventListener2 != null) {
            eventListener2.onNext("percentViewed:100", (String) null, this.placement.getId());
        }
        reportVideoLength(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        reportAction("videoLength", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS)}));
        reportAction(ReportDBAdapter.ReportColumns.COLUMN_VIDEO_VIEWED, String.format(Locale.ENGLISH, "%d", new Object[]{100}));
        Advertisement.Checkpoint pollFirst = this.checkpointList.pollFirst();
        if (pollFirst != null) {
            this.analytics.ping(pollFirst.getUrls());
        }
        this.durationRecorder.update();
    }

    private void reportVideoLength(long j) {
        this.report.setVideoLength(j);
        this.repository.save(this.report, this.repoCallback);
    }

    /* access modifiers changed from: private */
    public void reportAction(String str, String str2) {
        this.report.recordAction(str, str2, System.currentTimeMillis());
        this.repository.save(this.report, this.repoCallback);
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

    private boolean needShowGDPR(Cookie cookie) {
        return cookie != null && cookie.getBoolean("is_country_data_protected").booleanValue() && "unknown".equals(cookie.getString("consent_status"));
    }

    private void showGDPR(final Cookie cookie) {
        AnonymousClass3 r5 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                cookie.putValue("consent_status", i == -2 ? "opted_out" : i == -1 ? "opted_in" : Gdpr.OPTED_OUT_BY_TIMEOUT);
                cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie.putValue("consent_source", "vungle_modal");
                NativeAdPresenter.this.repository.save(cookie, (Repository.SaveCallback) null);
                NativeAdPresenter.this.start();
            }
        };
        cookie.putValue("consent_status", Gdpr.OPTED_OUT_BY_TIMEOUT);
        cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        cookie.putValue("consent_source", "vungle_modal");
        this.repository.save(cookie, this.repoCallback);
        showDialog(cookie.getString("consent_title"), cookie.getString("consent_message"), cookie.getString("button_accept"), cookie.getString("button_deny"), r5);
    }

    private void showDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        this.adView.showDialog(str, str2, str3, str4, onClickListener);
    }

    /* access modifiers changed from: private */
    public void makeBusError(int i) {
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onError(new VungleException(i), this.placement.getId());
        }
    }

    /* access modifiers changed from: private */
    public void closeView() {
        this.adView.close();
        this.scheduler.cancelAll();
    }
}
