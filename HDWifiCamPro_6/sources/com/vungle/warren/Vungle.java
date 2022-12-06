package com.vungle.warren;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.AdConfig;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.VungleSettings;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.log.LogManager;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.model.admarkup.AdMarkup;
import com.vungle.warren.model.token.Gdpr;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.FutureResult;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.tasks.AnalyticsJob;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.ui.VungleActivity;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.view.VungleBannerView;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.AdMarkupDecoder;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.TimeoutProvider;
import com.vungle.warren.utility.platform.Platform;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Vungle {
    private static final int DEFAULT_SESSION_TIMEOUT = 900;
    /* access modifiers changed from: private */
    public static final String TAG = Vungle.class.getCanonicalName();
    static final Vungle _instance = new Vungle();
    /* access modifiers changed from: private */
    public static CacheManager.Listener cacheListener = new CacheManager.Listener() {
        public void onCacheChanged() {
            if (Vungle._instance.context != null) {
                Vungle.stopPlaying();
                ServiceLocator instance = ServiceLocator.getInstance(Vungle._instance.context);
                CacheManager cacheManager = (CacheManager) instance.getService(CacheManager.class);
                Downloader downloader = (Downloader) instance.getService(Downloader.class);
                if (cacheManager.getCache() != null) {
                    List<DownloadRequest> allRequests = downloader.getAllRequests();
                    String path = cacheManager.getCache().getPath();
                    for (DownloadRequest next : allRequests) {
                        if (!next.path.startsWith(path)) {
                            downloader.cancel(next);
                        }
                    }
                }
                downloader.init();
            }
        }
    };
    private static Gson gson = new GsonBuilder().create();
    /* access modifiers changed from: private */
    public static AtomicBoolean isDepInit = new AtomicBoolean(false);
    private static volatile boolean isInitialized;
    /* access modifiers changed from: private */
    public static AtomicBoolean isInitializing = new AtomicBoolean(false);
    volatile String appID;
    /* access modifiers changed from: private */
    public final AtomicReference<Consent> ccpaStatus = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final AtomicReference<Consent> consent = new AtomicReference<>();
    /* access modifiers changed from: private */
    public volatile String consentVersion;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public AtomicInteger hbpOrdinalViewCount = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public Map<String, Boolean> playOperations = new ConcurrentHashMap();

    public enum Consent {
        OPTED_IN,
        OPTED_OUT
    }

    private Vungle() {
    }

    static Context getAppContext() {
        return _instance.context;
    }

    @Deprecated
    public static void init(Collection<String> collection, String str, Context context2, InitCallback initCallback) throws IllegalArgumentException {
        init(str, context2, initCallback, new VungleSettings.Builder().build());
    }

    public static void init(String str, Context context2, InitCallback initCallback) throws IllegalArgumentException {
        init(str, context2, initCallback, new VungleSettings.Builder().build());
    }

    public static void init(String str, Context context2, final InitCallback initCallback, VungleSettings vungleSettings) throws IllegalArgumentException {
        InitCallback initCallback2;
        VungleLogger.debug("Vungle#init", "init request");
        SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.INIT).build());
        if (initCallback == null) {
            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.INIT_END).addData(SessionAttribute.SUCCESS, false).build());
            throw new IllegalArgumentException("A valid InitCallback required to ensure API calls are being made after initialize is successful");
        } else if (context2 == null) {
            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.INIT_END).addData(SessionAttribute.SUCCESS, false).build());
            initCallback.onError(new VungleException(6));
        } else {
            final ServiceLocator instance = ServiceLocator.getInstance(context2);
            final Platform platform = (Platform) instance.getService(Platform.class);
            if (!platform.isAtLeastMinimumSDK()) {
                Log.e(TAG, "SDK is supported only for API versions 21 and above");
                initCallback.onError(new VungleException(35));
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.INIT_END).addData(SessionAttribute.SUCCESS, false).build());
                return;
            }
            final RuntimeValues runtimeValues = (RuntimeValues) ServiceLocator.getInstance(context2).getService(RuntimeValues.class);
            runtimeValues.settings.set(vungleSettings);
            Executors executors = (Executors) instance.getService(Executors.class);
            if (initCallback instanceof InitCallbackWrapper) {
                initCallback2 = initCallback;
            } else {
                initCallback2 = new InitCallbackWrapper(executors.getUIExecutor(), initCallback);
            }
            if (str == null || str.isEmpty()) {
                initCallback2.onError(new VungleException(6));
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.INIT_END).addData(SessionAttribute.SUCCESS, false).build());
            } else if (!(context2 instanceof Application)) {
                initCallback2.onError(new VungleException(7));
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.INIT_END).addData(SessionAttribute.SUCCESS, false).build());
            } else if (isInitialized()) {
                Log.d(TAG, "init already complete");
                initCallback2.onSuccess();
                VungleLogger.debug("Vungle#init", "init already complete");
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.INIT_END).addData(SessionAttribute.SUCCESS, false).build());
            } else if (isInitializing.getAndSet(true)) {
                Log.d(TAG, "init ongoing");
                onInitError(initCallback2, new VungleException(8));
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.INIT_END).addData(SessionAttribute.SUCCESS, false).build());
            } else if (PermissionChecker.checkCallingOrSelfPermission(context2, "android.permission.ACCESS_NETWORK_STATE") == 0 && PermissionChecker.checkCallingOrSelfPermission(context2, "android.permission.INTERNET") == 0) {
                SessionTracker.getInstance().setInitTimestamp(System.currentTimeMillis());
                runtimeValues.initCallback.set(initCallback2);
                final String str2 = str;
                final Context context3 = context2;
                executors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        Vungle._instance.appID = str2;
                        InitCallback initCallback = runtimeValues.initCallback.get();
                        if (!Vungle.isDepInit.getAndSet(true)) {
                            VungleLogger.setupLoggerWithLogLevel((LogManager) instance.getService(LogManager.class), VungleLogger.LoggerLevel.DEBUG, 100);
                            CacheManager cacheManager = (CacheManager) instance.getService(CacheManager.class);
                            VungleSettings vungleSettings = runtimeValues.settings.get();
                            if (vungleSettings == null || cacheManager.getBytesAvailable() >= vungleSettings.getMinimumSpaceForInit()) {
                                cacheManager.addListener(Vungle.cacheListener);
                                Context unused = Vungle._instance.context = context3;
                                Repository repository = (Repository) instance.getService(Repository.class);
                                try {
                                    repository.init();
                                    PrivacyManager.getInstance().init(((Executors) instance.getService(Executors.class)).getBackgroundExecutor(), repository);
                                    ((VungleApiClient) instance.getService(VungleApiClient.class)).init();
                                    if (vungleSettings != null) {
                                        platform.setAndroidIdFallbackDisabled(vungleSettings.getAndroidIdOptOut());
                                    }
                                    ((AdLoader) instance.getService(AdLoader.class)).init((JobRunner) instance.getService(JobRunner.class));
                                    if (Vungle._instance.consent.get() != null) {
                                        Vungle.saveGDPRConsent(repository, (Consent) Vungle._instance.consent.get(), Vungle._instance.consentVersion);
                                    } else {
                                        Cookie cookie = repository.load(Cookie.CONSENT_COOKIE, Cookie.class).get();
                                        if (cookie == null) {
                                            Vungle._instance.consent.set((Object) null);
                                            String unused2 = Vungle._instance.consentVersion = null;
                                        } else {
                                            Vungle._instance.consent.set(Vungle.getConsent(cookie));
                                            String unused3 = Vungle._instance.consentVersion = Vungle.getConsentMessageVersion(cookie);
                                        }
                                    }
                                    if (Vungle._instance.ccpaStatus.get() != null) {
                                        Vungle.updateCCPAStatus(repository, (Consent) Vungle._instance.ccpaStatus.get());
                                    } else {
                                        Vungle._instance.ccpaStatus.set(Vungle.getCCPAStatus(repository.load(Cookie.CCPA_COOKIE, Cookie.class).get()));
                                    }
                                } catch (DatabaseHelper.DBException unused4) {
                                    Vungle.onInitError(initCallback, new VungleException(26));
                                    Vungle.deInit();
                                    return;
                                }
                            } else {
                                Vungle.onInitError(initCallback, new VungleException(16));
                                Vungle.deInit();
                                return;
                            }
                        }
                        Repository repository2 = (Repository) instance.getService(Repository.class);
                        Cookie cookie2 = repository2.load("appId", Cookie.class).get();
                        if (cookie2 == null) {
                            cookie2 = new Cookie("appId");
                        }
                        cookie2.putValue("appId", str2);
                        try {
                            repository2.save(cookie2);
                            Vungle._instance.configure(initCallback, false);
                            ((JobRunner) instance.getService(JobRunner.class)).execute(AnalyticsJob.makeJob(2, (String) null, (String[]) null, 1));
                        } catch (DatabaseHelper.DBException unused5) {
                            if (initCallback != null) {
                                Vungle.onInitError(initCallback, new VungleException(26));
                            }
                            Vungle.isInitializing.set(false);
                        }
                    }
                }, new Runnable() {
                    public void run() {
                        Vungle.onInitError(InitCallback.this, new VungleException(39));
                    }
                });
            } else {
                Log.e(TAG, "Network permissions not granted");
                onInitError(initCallback2, new VungleException(34));
                isInitializing.set(false);
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.INIT_END).addData(SessionAttribute.SUCCESS, false).build());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void onInitError(InitCallback initCallback, VungleException vungleException) {
        if (initCallback != null) {
            initCallback.onError(vungleException);
        }
        if (vungleException != null) {
            VungleLogger.error("Vungle#init", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    static void reConfigure() {
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            Executors executors = (Executors) instance.getService(Executors.class);
            final RuntimeValues runtimeValues = (RuntimeValues) instance.getService(RuntimeValues.class);
            if (isInitialized()) {
                executors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        Vungle._instance.configure(RuntimeValues.this.initCallback.get(), true);
                    }
                }, new Runnable() {
                    public void run() {
                        Vungle.onInitError(RuntimeValues.this.initCallback.get(), new VungleException(39));
                    }
                });
            } else {
                init(_instance.appID, _instance.context, runtimeValues.initCallback.get());
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:135|136) */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        android.util.Log.e(TAG, "not able to apply vision data config");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:135:0x032a */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x041c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void configure(com.vungle.warren.InitCallback r31, boolean r32) {
        /*
            r30 = this;
            r1 = r30
            r2 = r31
            java.lang.String r0 = "max_send_amount"
            java.lang.String r3 = "collect_filter"
            java.lang.String r4 = "interval"
            java.lang.String r5 = "configSettings"
            java.lang.String r6 = "cache_bust"
            java.lang.String r7 = "crash_report"
            java.lang.String r8 = "logging"
            java.lang.String r9 = "gdpr"
            java.lang.String r10 = "session"
            java.lang.String r11 = "clever_cache"
            android.content.Context r15 = r1.context     // Catch:{ all -> 0x03fa }
            if (r15 == 0) goto L_0x03f2
            android.content.Context r15 = r1.context     // Catch:{ all -> 0x03fa }
            com.vungle.warren.ServiceLocator r15 = com.vungle.warren.ServiceLocator.getInstance(r15)     // Catch:{ all -> 0x03fa }
            java.lang.Class<com.vungle.warren.VungleApiClient> r13 = com.vungle.warren.VungleApiClient.class
            java.lang.Object r13 = r15.getService(r13)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.VungleApiClient r13 = (com.vungle.warren.VungleApiClient) r13     // Catch:{ all -> 0x03fa }
            java.lang.String r14 = r1.appID     // Catch:{ all -> 0x03fa }
            r13.setAppId(r14)     // Catch:{ all -> 0x03fa }
            java.lang.Class<com.vungle.warren.persistence.Repository> r14 = com.vungle.warren.persistence.Repository.class
            java.lang.Object r14 = r15.getService(r14)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.persistence.Repository r14 = (com.vungle.warren.persistence.Repository) r14     // Catch:{ all -> 0x03fa }
            java.lang.Class<com.vungle.warren.tasks.JobRunner> r12 = com.vungle.warren.tasks.JobRunner.class
            java.lang.Object r12 = r15.getService(r12)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.tasks.JobRunner r12 = (com.vungle.warren.tasks.JobRunner) r12     // Catch:{ all -> 0x03fa }
            r16 = r5
            java.lang.Class<com.vungle.warren.RuntimeValues> r5 = com.vungle.warren.RuntimeValues.class
            java.lang.Object r5 = r15.getService(r5)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.RuntimeValues r5 = (com.vungle.warren.RuntimeValues) r5     // Catch:{ all -> 0x03fa }
            r17 = r5
            com.vungle.warren.network.Response r5 = r13.config()     // Catch:{ all -> 0x03fa }
            if (r5 != 0) goto L_0x0065
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x03fa }
            r3 = 2
            r0.<init>(r3)     // Catch:{ all -> 0x03fa }
            onInitError(r2, r0)     // Catch:{ all -> 0x03fa }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x03fa }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x0061 }
            return
        L_0x0061:
            r0 = move-exception
            r2 = r3
            goto L_0x03fc
        L_0x0065:
            boolean r18 = r5.isSuccessful()     // Catch:{ all -> 0x03fa }
            if (r18 != 0) goto L_0x00a5
            long r3 = r13.getRetryAfterHeaderValue(r5)     // Catch:{ all -> 0x03fa }
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0095
            com.vungle.warren.Vungle r0 = _instance     // Catch:{ all -> 0x03fa }
            java.lang.String r0 = r0.appID     // Catch:{ all -> 0x03fa }
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.ReconfigJob.makeJobInfo(r0)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.tasks.JobInfo r0 = r0.setDelay(r3)     // Catch:{ all -> 0x03fa }
            r12.execute(r0)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x03fa }
            r3 = 14
            r0.<init>(r3)     // Catch:{ all -> 0x03fa }
            onInitError(r2, r0)     // Catch:{ all -> 0x03fa }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x03fa }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x0061 }
            return
        L_0x0095:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x03fa }
            r3 = 3
            r0.<init>(r3)     // Catch:{ all -> 0x03fa }
            onInitError(r2, r0)     // Catch:{ all -> 0x03fa }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x03fa }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x0061 }
            return
        L_0x00a5:
            r18 = r13
            java.lang.Class<com.vungle.warren.persistence.FilePreferences> r13 = com.vungle.warren.persistence.FilePreferences.class
            java.lang.Object r13 = r15.getService(r13)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.persistence.FilePreferences r13 = (com.vungle.warren.persistence.FilePreferences) r13     // Catch:{ all -> 0x03fa }
            java.lang.Object r5 = r5.body()     // Catch:{ all -> 0x03fa }
            com.google.gson.JsonObject r5 = (com.google.gson.JsonObject) r5     // Catch:{ all -> 0x03fa }
            r19 = r12
            java.lang.String r12 = "placements"
            com.google.gson.JsonArray r12 = r5.getAsJsonArray(r12)     // Catch:{ all -> 0x03fa }
            if (r12 != 0) goto L_0x00cf
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x03fa }
            r3 = 3
            r0.<init>(r3)     // Catch:{ all -> 0x03fa }
            onInitError(r2, r0)     // Catch:{ all -> 0x03fa }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x03fa }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x0061 }
            return
        L_0x00cf:
            com.vungle.warren.CleverCacheSettings r20 = com.vungle.warren.CleverCacheSettings.fromJson(r5)     // Catch:{ all -> 0x03fa }
            java.lang.Class<com.vungle.warren.downloader.Downloader> r2 = com.vungle.warren.downloader.Downloader.class
            java.lang.Object r2 = r15.getService(r2)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.downloader.Downloader r2 = (com.vungle.warren.downloader.Downloader) r2     // Catch:{ all -> 0x03fa }
            r21 = r4
            if (r20 == 0) goto L_0x0118
            r4 = 0
            java.lang.String r4 = r13.getString(r11, r4)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.CleverCacheSettings r4 = com.vungle.warren.CleverCacheSettings.deserializeFromString(r4)     // Catch:{ all -> 0x03fa }
            if (r4 == 0) goto L_0x00f9
            long r22 = r4.getTimestamp()     // Catch:{ all -> 0x03fa }
            long r24 = r20.getTimestamp()     // Catch:{ all -> 0x03fa }
            int r4 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r4 == 0) goto L_0x00f7
            goto L_0x00f9
        L_0x00f7:
            r4 = 0
            goto L_0x00fa
        L_0x00f9:
            r4 = 1
        L_0x00fa:
            boolean r22 = r20.isEnabled()     // Catch:{ all -> 0x03fa }
            if (r22 == 0) goto L_0x0102
            if (r4 == 0) goto L_0x0105
        L_0x0102:
            r2.clearCache()     // Catch:{ all -> 0x03fa }
        L_0x0105:
            boolean r4 = r20.isEnabled()     // Catch:{ all -> 0x03fa }
            r2.setCacheEnabled(r4)     // Catch:{ all -> 0x03fa }
            java.lang.String r2 = r20.serializeToString()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.persistence.FilePreferences r2 = r13.put((java.lang.String) r11, (java.lang.String) r2)     // Catch:{ all -> 0x03fa }
            r2.apply()     // Catch:{ all -> 0x03fa }
            goto L_0x011c
        L_0x0118:
            r4 = 1
            r2.setCacheEnabled(r4)     // Catch:{ all -> 0x03fa }
        L_0x011c:
            java.lang.Class<com.vungle.warren.AdLoader> r2 = com.vungle.warren.AdLoader.class
            java.lang.Object r2 = r15.getService(r2)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.AdLoader r2 = (com.vungle.warren.AdLoader) r2     // Catch:{ all -> 0x03fa }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x03fa }
            r4.<init>()     // Catch:{ all -> 0x03fa }
            java.util.Iterator r11 = r12.iterator()     // Catch:{ all -> 0x03fa }
        L_0x012d:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x03fa }
            if (r12 == 0) goto L_0x014a
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x03fa }
            com.google.gson.JsonElement r12 = (com.google.gson.JsonElement) r12     // Catch:{ all -> 0x03fa }
            r20 = r11
            com.vungle.warren.model.Placement r11 = new com.vungle.warren.model.Placement     // Catch:{ all -> 0x03fa }
            com.google.gson.JsonObject r12 = r12.getAsJsonObject()     // Catch:{ all -> 0x03fa }
            r11.<init>((com.google.gson.JsonObject) r12)     // Catch:{ all -> 0x03fa }
            r4.add(r11)     // Catch:{ all -> 0x03fa }
            r11 = r20
            goto L_0x012d
        L_0x014a:
            r14.setValidPlacements(r4)     // Catch:{ all -> 0x03fa }
            boolean r4 = r5.has(r10)     // Catch:{ all -> 0x03fa }
            java.lang.String r11 = "enabled"
            if (r4 == 0) goto L_0x01bf
            com.google.gson.JsonObject r4 = r5.getAsJsonObject(r10)     // Catch:{ all -> 0x03fa }
            boolean r10 = com.vungle.warren.model.JsonUtil.hasNonNull(r4, r11)     // Catch:{ all -> 0x03fa }
            if (r10 == 0) goto L_0x016c
            com.google.gson.JsonElement r10 = r4.get(r11)     // Catch:{ all -> 0x03fa }
            boolean r10 = r10.getAsBoolean()     // Catch:{ all -> 0x03fa }
            if (r10 == 0) goto L_0x016c
            r28 = 1
            goto L_0x016e
        L_0x016c:
            r28 = 0
        L_0x016e:
            java.lang.String r10 = "limit"
            r12 = 0
            int r29 = com.vungle.warren.model.JsonUtil.getAsInt(r4, r10, r12)     // Catch:{ all -> 0x01bb }
            com.vungle.warren.SessionTracker r22 = com.vungle.warren.SessionTracker.getInstance()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.Vungle$5 r10 = new com.vungle.warren.Vungle$5     // Catch:{ all -> 0x03fa }
            r10.<init>()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.utility.UtilityResource r24 = new com.vungle.warren.utility.UtilityResource     // Catch:{ all -> 0x03fa }
            r24.<init>()     // Catch:{ all -> 0x03fa }
            java.lang.Class<com.vungle.warren.persistence.Repository> r12 = com.vungle.warren.persistence.Repository.class
            java.lang.Object r12 = r15.getService(r12)     // Catch:{ all -> 0x03fa }
            r25 = r12
            com.vungle.warren.persistence.Repository r25 = (com.vungle.warren.persistence.Repository) r25     // Catch:{ all -> 0x03fa }
            java.lang.Class<com.vungle.warren.utility.SDKExecutors> r12 = com.vungle.warren.utility.SDKExecutors.class
            java.lang.Object r12 = r15.getService(r12)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.utility.SDKExecutors r12 = (com.vungle.warren.utility.SDKExecutors) r12     // Catch:{ all -> 0x03fa }
            com.vungle.warren.utility.VungleThreadPoolExecutor r26 = r12.getSessionDataExecutor()     // Catch:{ all -> 0x03fa }
            java.lang.Class<com.vungle.warren.VungleApiClient> r12 = com.vungle.warren.VungleApiClient.class
            java.lang.Object r12 = r15.getService(r12)     // Catch:{ all -> 0x03fa }
            r27 = r12
            com.vungle.warren.VungleApiClient r27 = (com.vungle.warren.VungleApiClient) r27     // Catch:{ all -> 0x03fa }
            r23 = r10
            r22.init(r23, r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.SessionTracker r10 = com.vungle.warren.SessionTracker.getInstance()     // Catch:{ all -> 0x03fa }
            java.lang.String r12 = "timeout"
            r20 = r13
            r13 = 900(0x384, float:1.261E-42)
            int r4 = com.vungle.warren.model.JsonUtil.getAsInt(r4, r12, r13)     // Catch:{ all -> 0x03fa }
            long r12 = (long) r4     // Catch:{ all -> 0x03fa }
            r10.setAppSessionTimeout(r12)     // Catch:{ all -> 0x03fa }
            goto L_0x01c1
        L_0x01bb:
            r0 = move-exception
            r2 = r12
            goto L_0x03fc
        L_0x01bf:
            r20 = r13
        L_0x01c1:
            boolean r4 = r5.has(r9)     // Catch:{ all -> 0x03fa }
            if (r4 == 0) goto L_0x01db
            java.lang.Class<com.vungle.warren.utility.TimeoutProvider> r4 = com.vungle.warren.utility.TimeoutProvider.class
            java.lang.Object r4 = r15.getService(r4)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.utility.TimeoutProvider r4 = (com.vungle.warren.utility.TimeoutProvider) r4     // Catch:{ all -> 0x03fa }
            com.vungle.warren.model.GdprCookie r10 = new com.vungle.warren.model.GdprCookie     // Catch:{ all -> 0x03fa }
            r10.<init>(r14, r4)     // Catch:{ all -> 0x03fa }
            com.google.gson.JsonObject r4 = r5.getAsJsonObject(r9)     // Catch:{ all -> 0x03fa }
            r10.save(r4)     // Catch:{ all -> 0x03fa }
        L_0x01db:
            boolean r4 = r5.has(r8)     // Catch:{ all -> 0x03fa }
            if (r4 == 0) goto L_0x0200
            java.lang.Class<com.vungle.warren.log.LogManager> r4 = com.vungle.warren.log.LogManager.class
            java.lang.Object r4 = r15.getService(r4)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.log.LogManager r4 = (com.vungle.warren.log.LogManager) r4     // Catch:{ all -> 0x03fa }
            com.google.gson.JsonObject r8 = r5.getAsJsonObject(r8)     // Catch:{ all -> 0x03fa }
            boolean r9 = com.vungle.warren.model.JsonUtil.hasNonNull(r8, r11)     // Catch:{ all -> 0x03fa }
            if (r9 == 0) goto L_0x01fc
            com.google.gson.JsonElement r8 = r8.get(r11)     // Catch:{ all -> 0x03fa }
            boolean r8 = r8.getAsBoolean()     // Catch:{ all -> 0x03fa }
            goto L_0x01fd
        L_0x01fc:
            r8 = 0
        L_0x01fd:
            r4.setLoggingEnabled(r8)     // Catch:{ all -> 0x03fa }
        L_0x0200:
            boolean r4 = r5.has(r7)     // Catch:{ all -> 0x03fa }
            if (r4 == 0) goto L_0x0246
            java.lang.Class<com.vungle.warren.log.LogManager> r4 = com.vungle.warren.log.LogManager.class
            java.lang.Object r4 = r15.getService(r4)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.log.LogManager r4 = (com.vungle.warren.log.LogManager) r4     // Catch:{ all -> 0x03fa }
            com.google.gson.JsonObject r7 = r5.getAsJsonObject(r7)     // Catch:{ all -> 0x03fa }
            boolean r8 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r11)     // Catch:{ all -> 0x03fa }
            if (r8 == 0) goto L_0x0221
            com.google.gson.JsonElement r8 = r7.get(r11)     // Catch:{ all -> 0x03fa }
            boolean r8 = r8.getAsBoolean()     // Catch:{ all -> 0x03fa }
            goto L_0x0222
        L_0x0221:
            r8 = 0
        L_0x0222:
            boolean r9 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r3)     // Catch:{ all -> 0x03fa }
            if (r9 == 0) goto L_0x0231
            com.google.gson.JsonElement r3 = r7.get(r3)     // Catch:{ all -> 0x03fa }
            java.lang.String r3 = r3.getAsString()     // Catch:{ all -> 0x03fa }
            goto L_0x0233
        L_0x0231:
            java.lang.String r3 = com.vungle.warren.log.LogManager.sDefaultCollectFilter     // Catch:{ all -> 0x03fa }
        L_0x0233:
            boolean r9 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r0)     // Catch:{ all -> 0x03fa }
            if (r9 == 0) goto L_0x0242
            com.google.gson.JsonElement r0 = r7.get(r0)     // Catch:{ all -> 0x03fa }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x03fa }
            goto L_0x0243
        L_0x0242:
            r0 = 5
        L_0x0243:
            r4.updateCrashReportConfig(r8, r3, r0)     // Catch:{ all -> 0x03fa }
        L_0x0246:
            boolean r0 = r5.has(r6)     // Catch:{ all -> 0x03fa }
            if (r0 == 0) goto L_0x0275
            com.google.gson.JsonObject r0 = r5.getAsJsonObject(r6)     // Catch:{ all -> 0x03fa }
            boolean r3 = r0.has(r11)     // Catch:{ all -> 0x03fa }
            if (r3 == 0) goto L_0x025f
            com.google.gson.JsonElement r3 = r0.get(r11)     // Catch:{ all -> 0x03fa }
            boolean r3 = r3.getAsBoolean()     // Catch:{ all -> 0x03fa }
            goto L_0x0260
        L_0x025f:
            r3 = 0
        L_0x0260:
            r4 = r21
            boolean r6 = r0.has(r4)     // Catch:{ all -> 0x03fa }
            if (r6 == 0) goto L_0x0273
            com.google.gson.JsonElement r0 = r0.get(r4)     // Catch:{ all -> 0x03fa }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x03fa }
            int r0 = r0 * 1000
            goto L_0x0277
        L_0x0273:
            r0 = 0
            goto L_0x0277
        L_0x0275:
            r0 = 0
            r3 = 0
        L_0x0277:
            java.lang.Class<com.vungle.warren.model.Cookie> r4 = com.vungle.warren.model.Cookie.class
            r6 = r16
            com.vungle.warren.persistence.FutureResult r4 = r14.load(r6, r4)     // Catch:{ all -> 0x03fa }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.model.Cookie r4 = (com.vungle.warren.model.Cookie) r4     // Catch:{ all -> 0x03fa }
            if (r4 != 0) goto L_0x028c
            com.vungle.warren.model.Cookie r4 = new com.vungle.warren.model.Cookie     // Catch:{ all -> 0x03fa }
            r4.<init>(r6)     // Catch:{ all -> 0x03fa }
        L_0x028c:
            java.lang.String r6 = "ad_load_optimization"
            com.google.gson.JsonObject r6 = r5.getAsJsonObject(r6)     // Catch:{ all -> 0x03fa }
            r7 = 0
            boolean r6 = com.vungle.warren.model.JsonUtil.getAsBoolean(r6, r11, r7)     // Catch:{ all -> 0x03ef }
            r2.setAdLoadOptimizationEnabled(r6)     // Catch:{ all -> 0x03fa }
            java.lang.String r7 = "isAdDownloadOptEnabled"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x03fa }
            r4.putValue(r7, r6)     // Catch:{ all -> 0x03fa }
            java.lang.String r6 = "ri"
            boolean r6 = r5.has(r6)     // Catch:{ all -> 0x03fa }
            if (r6 == 0) goto L_0x02c2
            java.lang.String r6 = "ri"
            com.google.gson.JsonObject r6 = r5.getAsJsonObject(r6)     // Catch:{ all -> 0x03fa }
            com.google.gson.JsonElement r6 = r6.get(r11)     // Catch:{ all -> 0x03fa }
            boolean r6 = r6.getAsBoolean()     // Catch:{ all -> 0x03fa }
            java.lang.String r7 = "isReportIncentivizedEnabled"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x03fa }
            r4.putValue(r7, r6)     // Catch:{ all -> 0x03fa }
        L_0x02c2:
            java.lang.String r6 = "disable_ad_id"
            r7 = 1
            boolean r6 = com.vungle.warren.model.JsonUtil.getAsBoolean(r5, r6, r7)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.PrivacyManager r7 = com.vungle.warren.PrivacyManager.getInstance()     // Catch:{ all -> 0x03fa }
            r7.updateDisableAdId(r6)     // Catch:{ all -> 0x03fa }
            r14.save(r4)     // Catch:{ all -> 0x03fa }
            r1.saveConfigExtension(r14, r5)     // Catch:{ all -> 0x03fa }
            java.lang.String r4 = "config"
            boolean r4 = r5.has(r4)     // Catch:{ all -> 0x03fa }
            if (r4 == 0) goto L_0x02fe
            java.lang.String r4 = "config"
            com.google.gson.JsonObject r4 = r5.getAsJsonObject(r4)     // Catch:{ all -> 0x03fa }
            java.lang.String r6 = "refresh_time"
            com.google.gson.JsonElement r4 = r4.get(r6)     // Catch:{ all -> 0x03fa }
            long r6 = r4.getAsLong()     // Catch:{ all -> 0x03fa }
            java.lang.String r4 = r1.appID     // Catch:{ all -> 0x03fa }
            com.vungle.warren.tasks.JobInfo r4 = com.vungle.warren.tasks.ReconfigJob.makeJobInfo(r4)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.tasks.JobInfo r4 = r4.setDelay(r6)     // Catch:{ all -> 0x03fa }
            r12 = r19
            r12.execute(r4)     // Catch:{ all -> 0x03fa }
            goto L_0x0300
        L_0x02fe:
            r12 = r19
        L_0x0300:
            java.lang.Class<com.vungle.warren.VisionController> r4 = com.vungle.warren.VisionController.class
            java.lang.Object r4 = r15.getService(r4)     // Catch:{ DBException -> 0x032a }
            com.vungle.warren.VisionController r4 = (com.vungle.warren.VisionController) r4     // Catch:{ DBException -> 0x032a }
            java.lang.String r6 = "vision"
            boolean r6 = com.vungle.warren.model.JsonUtil.hasNonNull(r5, r6)     // Catch:{ DBException -> 0x032a }
            if (r6 == 0) goto L_0x0321
            com.google.gson.Gson r6 = gson     // Catch:{ DBException -> 0x032a }
            java.lang.String r7 = "vision"
            com.google.gson.JsonObject r5 = r5.getAsJsonObject(r7)     // Catch:{ DBException -> 0x032a }
            java.lang.Class<com.vungle.warren.vision.VisionConfig> r7 = com.vungle.warren.vision.VisionConfig.class
            java.lang.Object r5 = r6.fromJson((com.google.gson.JsonElement) r5, r7)     // Catch:{ DBException -> 0x032a }
            com.vungle.warren.vision.VisionConfig r5 = (com.vungle.warren.vision.VisionConfig) r5     // Catch:{ DBException -> 0x032a }
            goto L_0x0326
        L_0x0321:
            com.vungle.warren.vision.VisionConfig r5 = new com.vungle.warren.vision.VisionConfig     // Catch:{ DBException -> 0x032a }
            r5.<init>()     // Catch:{ DBException -> 0x032a }
        L_0x0326:
            r4.setConfig(r5)     // Catch:{ DBException -> 0x032a }
            goto L_0x0331
        L_0x032a:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x03fa }
            java.lang.String r5 = "not able to apply vision data config"
            android.util.Log.e(r4, r5)     // Catch:{ all -> 0x03fa }
        L_0x0331:
            r4 = 1
            isInitialized = r4     // Catch:{ all -> 0x03fa }
            r31.onSuccess()     // Catch:{ all -> 0x03fa }
            java.lang.String r4 = "Vungle#init"
            java.lang.String r5 = "onSuccess"
            com.vungle.warren.VungleLogger.debug(r4, r5)     // Catch:{ all -> 0x03fa }
            java.util.concurrent.atomic.AtomicBoolean r4 = isInitializing     // Catch:{ all -> 0x03fa }
            r5 = 0
            r4.set(r5)     // Catch:{ all -> 0x03ec }
            com.vungle.warren.SessionTracker r4 = com.vungle.warren.SessionTracker.getInstance()     // Catch:{ all -> 0x03fa }
            r4.observe()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.persistence.FutureResult r4 = r14.loadValidPlacements()     // Catch:{ all -> 0x03fa }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x03fa }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x03fa }
            com.vungle.warren.tasks.JobInfo r5 = com.vungle.warren.tasks.CleanupJob.makeJobInfo()     // Catch:{ all -> 0x03fa }
            r12.execute(r5)     // Catch:{ all -> 0x03fa }
            if (r4 == 0) goto L_0x0390
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x03fa }
            r5.<init>(r4)     // Catch:{ all -> 0x03fa }
            r4 = r17
            java.util.concurrent.atomic.AtomicReference<com.vungle.warren.VungleSettings> r4 = r4.settings     // Catch:{ all -> 0x03fa }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.VungleSettings r4 = (com.vungle.warren.VungleSettings) r4     // Catch:{ all -> 0x03fa }
            com.vungle.warren.Vungle$6 r6 = new com.vungle.warren.Vungle$6     // Catch:{ all -> 0x03fa }
            r6.<init>(r4)     // Catch:{ all -> 0x03fa }
            java.util.Collections.sort(r5, r6)     // Catch:{ all -> 0x03fa }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x03fa }
            java.lang.String r6 = "starting jobs for autocached advs"
            android.util.Log.d(r4, r6)     // Catch:{ all -> 0x03fa }
            java.lang.Class<com.vungle.warren.utility.Executors> r4 = com.vungle.warren.utility.Executors.class
            java.lang.Object r4 = r15.getService(r4)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.utility.Executors r4 = (com.vungle.warren.utility.Executors) r4     // Catch:{ all -> 0x03fa }
            java.util.concurrent.ExecutorService r4 = r4.getUIExecutor()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.Vungle$7 r6 = new com.vungle.warren.Vungle$7     // Catch:{ all -> 0x03fa }
            r6.<init>(r5, r2)     // Catch:{ all -> 0x03fa }
            r4.execute(r6)     // Catch:{ all -> 0x03fa }
        L_0x0390:
            if (r3 == 0) goto L_0x03a1
            java.lang.Class<com.vungle.warren.CacheBustManager> r2 = com.vungle.warren.CacheBustManager.class
            java.lang.Object r2 = r15.getService(r2)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.CacheBustManager r2 = (com.vungle.warren.CacheBustManager) r2     // Catch:{ all -> 0x03fa }
            long r3 = (long) r0     // Catch:{ all -> 0x03fa }
            r2.setRefreshRate(r3)     // Catch:{ all -> 0x03fa }
            r2.startBust()     // Catch:{ all -> 0x03fa }
        L_0x03a1:
            if (r32 != 0) goto L_0x03a5
            r0 = 1
            goto L_0x03a6
        L_0x03a5:
            r0 = 0
        L_0x03a6:
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.SendReportsJob.makeJobInfo(r0)     // Catch:{ all -> 0x03fa }
            r12.execute(r0)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.SendLogsJob.makeJobInfo()     // Catch:{ all -> 0x03fa }
            r12.execute(r0)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.SessionTracker r0 = com.vungle.warren.SessionTracker.getInstance()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.model.SessionData$Builder r2 = new com.vungle.warren.model.SessionData$Builder     // Catch:{ all -> 0x03fa }
            r2.<init>()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.session.SessionEvent r3 = com.vungle.warren.session.SessionEvent.INIT_END     // Catch:{ all -> 0x03fa }
            com.vungle.warren.model.SessionData$Builder r2 = r2.setEvent(r3)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.session.SessionAttribute r3 = com.vungle.warren.session.SessionAttribute.SUCCESS     // Catch:{ all -> 0x03fa }
            r4 = 1
            com.vungle.warren.model.SessionData$Builder r2 = r2.addData((com.vungle.warren.session.SessionAttribute) r3, (boolean) r4)     // Catch:{ all -> 0x03fa }
            com.vungle.warren.model.SessionData r2 = r2.build()     // Catch:{ all -> 0x03fa }
            r0.trackEvent(r2)     // Catch:{ all -> 0x03fa }
            java.lang.String r0 = "reported"
            r13 = r20
            r2 = 0
            boolean r0 = r13.getBoolean(r0, r2)     // Catch:{ all -> 0x03ea }
            if (r0 != 0) goto L_0x0467
            com.vungle.warren.network.Call r0 = r18.reportNew()     // Catch:{ all -> 0x03fa }
            com.vungle.warren.Vungle$8 r2 = new com.vungle.warren.Vungle$8     // Catch:{ all -> 0x03fa }
            r2.<init>(r13)     // Catch:{ all -> 0x03fa }
            r0.enqueue(r2)     // Catch:{ all -> 0x03fa }
            goto L_0x0467
        L_0x03ea:
            r0 = move-exception
            goto L_0x03fc
        L_0x03ec:
            r0 = move-exception
            r2 = r5
            goto L_0x03fc
        L_0x03ef:
            r0 = move-exception
            r2 = r7
            goto L_0x03fc
        L_0x03f2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x03fa }
            java.lang.String r2 = "Context is null"
            r0.<init>(r2)     // Catch:{ all -> 0x03fa }
            throw r0     // Catch:{ all -> 0x03fa }
        L_0x03fa:
            r0 = move-exception
            r2 = 0
        L_0x03fc:
            isInitialized = r2
            java.util.concurrent.atomic.AtomicBoolean r3 = isInitializing
            r3.set(r2)
            java.lang.String r2 = TAG
            java.lang.String r3 = android.util.Log.getStackTraceString(r0)
            android.util.Log.e(r2, r3)
            boolean r2 = r0 instanceof com.vungle.warren.network.HttpException
            if (r2 == 0) goto L_0x041c
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r2 = 3
            r0.<init>(r2)
            r2 = r31
            onInitError(r2, r0)
            goto L_0x044a
        L_0x041c:
            r2 = r31
            boolean r3 = r0 instanceof com.vungle.warren.persistence.DatabaseHelper.DBException
            if (r3 == 0) goto L_0x042d
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r3 = 26
            r0.<init>(r3)
            onInitError(r2, r0)
            goto L_0x044a
        L_0x042d:
            boolean r3 = r0 instanceof java.net.UnknownHostException
            if (r3 != 0) goto L_0x0440
            boolean r0 = r0 instanceof java.lang.SecurityException
            if (r0 == 0) goto L_0x0436
            goto L_0x0440
        L_0x0436:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r3 = 2
            r0.<init>(r3)
            onInitError(r2, r0)
            goto L_0x044a
        L_0x0440:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r3 = 33
            r0.<init>(r3)
            onInitError(r2, r0)
        L_0x044a:
            com.vungle.warren.SessionTracker r0 = com.vungle.warren.SessionTracker.getInstance()
            com.vungle.warren.model.SessionData$Builder r2 = new com.vungle.warren.model.SessionData$Builder
            r2.<init>()
            com.vungle.warren.session.SessionEvent r3 = com.vungle.warren.session.SessionEvent.INIT_END
            com.vungle.warren.model.SessionData$Builder r2 = r2.setEvent(r3)
            com.vungle.warren.session.SessionAttribute r3 = com.vungle.warren.session.SessionAttribute.SUCCESS
            r4 = 0
            com.vungle.warren.model.SessionData$Builder r2 = r2.addData((com.vungle.warren.session.SessionAttribute) r3, (boolean) r4)
            com.vungle.warren.model.SessionData r2 = r2.build()
            r0.trackEvent(r2)
        L_0x0467:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.configure(com.vungle.warren.InitCallback, boolean):void");
    }

    public static boolean isInitialized() {
        return isInitialized && _instance.context != null;
    }

    public static void setIncentivizedFields(String str, String str2, String str3, String str4, String str5) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, context is null");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final String str9 = str5;
        final String str10 = str;
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                if (!Vungle.isInitialized()) {
                    Log.e(Vungle.TAG, "Vungle is not initialized");
                    return;
                }
                Repository repository = (Repository) ServiceLocator.this.getService(Repository.class);
                Cookie cookie = repository.load(Cookie.INCENTIVIZED_TEXT_COOKIE, Cookie.class).get();
                if (cookie == null) {
                    cookie = new Cookie(Cookie.INCENTIVIZED_TEXT_COOKIE);
                }
                String str = "";
                String str2 = TextUtils.isEmpty(str6) ? str : str6;
                String str3 = TextUtils.isEmpty(str7) ? str : str7;
                String str4 = TextUtils.isEmpty(str8) ? str : str8;
                String str5 = TextUtils.isEmpty(str9) ? str : str9;
                if (!TextUtils.isEmpty(str10)) {
                    str = str10;
                }
                cookie.putValue(CampaignEx.JSON_KEY_TITLE, str2);
                cookie.putValue(TtmlNode.TAG_BODY, str3);
                cookie.putValue("continue", str4);
                cookie.putValue("close", str5);
                cookie.putValue("userID", str);
                try {
                    repository.save(cookie);
                } catch (DatabaseHelper.DBException e) {
                    Log.e(Vungle.TAG, "Cannot save incentivized cookie", e);
                }
            }
        });
    }

    public static boolean canPlayAd(String str) {
        return canPlayAd(str, (String) null);
    }

    public static boolean canPlayAd(final String str, final String str2) {
        final Context context2 = _instance.context;
        if (context2 == null) {
            Log.e(TAG, "Context is null");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "AdMarkup/PlacementId is null");
            return false;
        } else {
            AdMarkup decode = AdMarkupDecoder.decode(str2);
            if (str2 == null || decode != null) {
                ServiceLocator instance = ServiceLocator.getInstance(context2);
                return Boolean.TRUE.equals(new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<Boolean>() {
                    public Boolean call() {
                        Advertisement advertisement;
                        if (!Vungle.isInitialized()) {
                            Log.e(Vungle.TAG, "Vungle is not initialized");
                            return false;
                        }
                        Repository repository = (Repository) ServiceLocator.getInstance(context2).getService(Repository.class);
                        AdMarkup decode = AdMarkupDecoder.decode(str2);
                        String eventId = decode != null ? decode.getEventId() : null;
                        Placement placement = repository.load(str, Placement.class).get();
                        if (placement == null || !placement.isValid() || ((placement.isMultipleHBPEnabled() && eventId == null) || (advertisement = repository.findValidAdvertisementForPlacement(str, eventId).get()) == null || placement.getPlacementAdType() == 1 || (!AdConfig.AdSize.isDefaultAdSize(placement.getAdSize()) && !placement.getAdSize().equals(advertisement.getAdConfig().getAdSize())))) {
                            return false;
                        }
                        return Boolean.valueOf(Vungle.canPlayAd(advertisement));
                    }
                })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS));
            }
            Log.e(TAG, "Invalid AdMarkup");
            return false;
        }
    }

    static boolean canPlayAd(Advertisement advertisement) {
        Context context2 = _instance.context;
        if (context2 == null) {
            return false;
        }
        return ((AdLoader) ServiceLocator.getInstance(context2).getService(AdLoader.class)).canPlayAd(advertisement);
    }

    /* access modifiers changed from: private */
    public static void onPlayError(String str, PlayAdCallback playAdCallback, VungleException vungleException) {
        if (playAdCallback != null) {
            playAdCallback.onError(str, vungleException);
        }
        if (vungleException != null) {
            VungleLogger.error("Vungle#playAd", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
        SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, false).build());
    }

    public static void playAd(String str, AdConfig adConfig, PlayAdCallback playAdCallback) {
        playAd(str, (String) null, adConfig, playAdCallback);
    }

    public static void playAd(final String str, String str2, AdConfig adConfig, PlayAdCallback playAdCallback) {
        VungleLogger.debug("Vungle#playAd", "playAd call invoked");
        SessionTracker.getInstance().trackAdConfig(adConfig);
        if (!isInitialized()) {
            Log.e(TAG, "Locator is not initialized");
            if (playAdCallback != null) {
                onPlayError(str, playAdCallback, new VungleException(9));
            }
        } else if (TextUtils.isEmpty(str)) {
            onPlayError(str, playAdCallback, new VungleException(13));
        } else {
            AdMarkup decode = AdMarkupDecoder.decode(str2);
            if (str2 == null || decode != null) {
                ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
                final Executors executors = (Executors) instance.getService(Executors.class);
                final Repository repository = (Repository) instance.getService(Repository.class);
                final AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
                final VungleApiClient vungleApiClient = (VungleApiClient) instance.getService(VungleApiClient.class);
                final PlayAdCallbackWrapper playAdCallbackWrapper = new PlayAdCallbackWrapper(executors.getUIExecutor(), playAdCallback);
                AnonymousClass11 r15 = new Runnable() {
                    public void run() {
                        Vungle.onPlayError(str, playAdCallbackWrapper, new VungleException(39));
                    }
                };
                final String str3 = str2;
                final String str4 = str;
                final AdConfig adConfig2 = adConfig;
                final AnonymousClass11 r11 = r15;
                executors.getBackgroundExecutor().execute(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:36:0x0107  */
                    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r12 = this;
                            java.lang.String r0 = r3
                            com.vungle.warren.model.admarkup.AdMarkup r0 = com.vungle.warren.utility.AdMarkupDecoder.decode(r0)
                            com.vungle.warren.AdRequest r4 = new com.vungle.warren.AdRequest
                            java.lang.String r1 = r4
                            r2 = 0
                            r4.<init>(r1, r0, r2)
                            java.lang.Boolean r0 = java.lang.Boolean.TRUE
                            com.vungle.warren.Vungle r1 = com.vungle.warren.Vungle._instance
                            java.util.Map r1 = r1.playOperations
                            java.lang.String r3 = r4
                            java.lang.Object r1 = r1.get(r3)
                            boolean r0 = r0.equals(r1)
                            if (r0 != 0) goto L_0x0157
                            com.vungle.warren.AdLoader r0 = r5
                            boolean r0 = r0.isLoading(r4)
                            if (r0 == 0) goto L_0x002c
                            goto L_0x0157
                        L_0x002c:
                            com.vungle.warren.persistence.Repository r0 = r7
                            java.lang.String r1 = r4
                            java.lang.Class<com.vungle.warren.model.Placement> r3 = com.vungle.warren.model.Placement.class
                            com.vungle.warren.persistence.FutureResult r0 = r0.load(r1, r3)
                            java.lang.Object r0 = r0.get()
                            com.vungle.warren.model.Placement r0 = (com.vungle.warren.model.Placement) r0
                            if (r0 != 0) goto L_0x004d
                            java.lang.String r0 = r4
                            com.vungle.warren.PlayAdCallback r1 = r6
                            com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                            r3 = 13
                            r2.<init>(r3)
                            com.vungle.warren.Vungle.onPlayError(r0, r1, r2)
                            return
                        L_0x004d:
                            com.vungle.warren.AdConfig$AdSize r1 = r0.getAdSize()
                            boolean r1 = com.vungle.warren.AdConfig.AdSize.isBannerAdSize(r1)
                            if (r1 == 0) goto L_0x006f
                            java.lang.String r0 = com.vungle.warren.Vungle.TAG
                            java.lang.String r1 = "Incorrect API for Banners and MREC"
                            android.util.Log.e(r0, r1)
                            java.lang.String r0 = r4
                            com.vungle.warren.PlayAdCallback r1 = r6
                            com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                            r3 = 28
                            r2.<init>(r3)
                            com.vungle.warren.Vungle.onPlayError(r0, r1, r2)
                            return
                        L_0x006f:
                            com.vungle.warren.persistence.Repository r1 = r7
                            java.lang.String r3 = r4
                            java.lang.String r5 = r4.getEventId()
                            com.vungle.warren.persistence.FutureResult r1 = r1.findPotentiallyExpiredAd(r3, r5)
                            java.lang.Object r1 = r1.get()
                            r11 = r1
                            com.vungle.warren.model.Advertisement r11 = (com.vungle.warren.model.Advertisement) r11
                            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ DBException -> 0x0148 }
                            r7 = 1000(0x3e8, double:4.94E-321)
                            long r5 = r5 / r7
                            r1 = 1
                            if (r11 == 0) goto L_0x0096
                            long r7 = r11.getExpireTime()     // Catch:{ DBException -> 0x0148 }
                            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                            if (r3 >= 0) goto L_0x0096
                            r3 = r1
                            goto L_0x0097
                        L_0x0096:
                            r3 = r2
                        L_0x0097:
                            boolean r5 = com.vungle.warren.Vungle.canPlayAd((com.vungle.warren.model.Advertisement) r11)     // Catch:{ DBException -> 0x0148 }
                            if (r5 == 0) goto L_0x00ac
                            if (r3 == 0) goto L_0x00a0
                            goto L_0x00ac
                        L_0x00a0:
                            com.vungle.warren.AdConfig r3 = r8     // Catch:{ DBException -> 0x0148 }
                            r11.configure(r3)     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.persistence.Repository r3 = r7     // Catch:{ DBException -> 0x0148 }
                            r3.save(r11)     // Catch:{ DBException -> 0x0148 }
                            r3 = r2
                            goto L_0x00ff
                        L_0x00ac:
                            if (r11 == 0) goto L_0x00cb
                            int r2 = r11.getState()     // Catch:{ DBException -> 0x0148 }
                            if (r2 == r1) goto L_0x00b6
                            if (r3 == 0) goto L_0x00cb
                        L_0x00b6:
                            com.vungle.warren.persistence.Repository r2 = r7     // Catch:{ DBException -> 0x0148 }
                            java.lang.String r5 = r4     // Catch:{ DBException -> 0x0148 }
                            r6 = 4
                            r2.saveAndApplyState(r11, r5, r6)     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.AdLoader r5 = r5     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.AdConfig$AdSize r7 = r0.getAdSize()     // Catch:{ DBException -> 0x0148 }
                            r8 = 0
                            r10 = 0
                            r6 = r0
                            r5.loadEndlessIfNeeded(r6, r7, r8, r10)     // Catch:{ DBException -> 0x0148 }
                        L_0x00cb:
                            if (r3 == 0) goto L_0x00fe
                            com.vungle.warren.SessionTracker r0 = com.vungle.warren.SessionTracker.getInstance()     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.model.SessionData$Builder r1 = new com.vungle.warren.model.SessionData$Builder     // Catch:{ DBException -> 0x0148 }
                            r1.<init>()     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.session.SessionEvent r2 = com.vungle.warren.session.SessionEvent.AD_EXPIRED     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.model.SessionData$Builder r1 = r1.setEvent(r2)     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.session.SessionAttribute r2 = com.vungle.warren.session.SessionAttribute.EVENT_ID     // Catch:{ DBException -> 0x0148 }
                            java.lang.String r3 = r11.getId()     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.model.SessionData$Builder r1 = r1.addData((com.vungle.warren.session.SessionAttribute) r2, (java.lang.String) r3)     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.model.SessionData r1 = r1.build()     // Catch:{ DBException -> 0x0148 }
                            r0.trackEvent(r1)     // Catch:{ DBException -> 0x0148 }
                            java.lang.String r0 = r4.getPlacementId()     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.PlayAdCallback r1 = r6     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException     // Catch:{ DBException -> 0x0148 }
                            r3 = 37
                            r2.<init>(r3)     // Catch:{ DBException -> 0x0148 }
                            com.vungle.warren.Vungle.onPlayError(r0, r1, r2)     // Catch:{ DBException -> 0x0148 }
                            return
                        L_0x00fe:
                            r3 = r1
                        L_0x00ff:
                            com.vungle.warren.Vungle r2 = com.vungle.warren.Vungle._instance
                            android.content.Context r2 = r2.context
                            if (r2 == 0) goto L_0x0147
                            com.vungle.warren.VungleApiClient r2 = r9
                            boolean r2 = r2.canCallWillPlayAd()
                            if (r2 == 0) goto L_0x0133
                            com.vungle.warren.VungleApiClient r1 = r9
                            java.lang.String r2 = r0.getId()
                            boolean r5 = r0.isAutoCached()
                            if (r3 == 0) goto L_0x011e
                            java.lang.String r6 = ""
                            goto L_0x0122
                        L_0x011e:
                            java.lang.String r6 = r11.getAdToken()
                        L_0x0122:
                            com.vungle.warren.network.Call r7 = r1.willPlayAd(r2, r5, r6)
                            com.vungle.warren.Vungle$12$1 r8 = new com.vungle.warren.Vungle$12$1
                            r1 = r8
                            r2 = r12
                            r5 = r0
                            r6 = r11
                            r1.<init>(r3, r4, r5, r6)
                            r7.enqueue(r8)
                            goto L_0x0147
                        L_0x0133:
                            if (r3 == 0) goto L_0x0142
                            java.lang.String r0 = r4
                            com.vungle.warren.PlayAdCallback r2 = r6
                            com.vungle.warren.error.VungleException r3 = new com.vungle.warren.error.VungleException
                            r3.<init>(r1)
                            com.vungle.warren.Vungle.onPlayError(r0, r2, r3)
                            goto L_0x0147
                        L_0x0142:
                            com.vungle.warren.PlayAdCallback r1 = r6
                            com.vungle.warren.Vungle.renderAd(r4, r1, r0, r11)
                        L_0x0147:
                            return
                        L_0x0148:
                            java.lang.String r0 = r4
                            com.vungle.warren.PlayAdCallback r1 = r6
                            com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                            r3 = 26
                            r2.<init>(r3)
                            com.vungle.warren.Vungle.onPlayError(r0, r1, r2)
                            return
                        L_0x0157:
                            java.lang.String r0 = r4
                            com.vungle.warren.PlayAdCallback r1 = r6
                            com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                            r3 = 8
                            r2.<init>(r3)
                            com.vungle.warren.Vungle.onPlayError(r0, r1, r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.AnonymousClass12.run():void");
                    }
                }, r15);
                return;
            }
            onPlayError(str, playAdCallback, new VungleException(36));
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void renderAd(AdRequest adRequest, PlayAdCallback playAdCallback, Placement placement, Advertisement advertisement) {
        synchronized (Vungle.class) {
            if (!isInitialized()) {
                Log.e(TAG, "Sdk is not initialized");
                return;
            }
            ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
            VungleActivity.setEventListener(new AdEventListener(adRequest, _instance.playOperations, playAdCallback, (Repository) instance.getService(Repository.class), (AdLoader) instance.getService(AdLoader.class), (JobRunner) instance.getService(JobRunner.class), (VisionController) instance.getService(VisionController.class), placement, advertisement) {
                /* access modifiers changed from: protected */
                public void onFinished() {
                    super.onFinished();
                    VungleActivity.setEventListener((AdContract.AdvertisementPresenter.EventListener) null);
                }
            });
            AdRequest adRequest2 = adRequest;
            ActivityManager.startWhenForeground(_instance.context, (Intent) null, AdActivity.createIntent(_instance.context, adRequest), (ActivityManager.LeftApplicationCallback) null);
        }
    }

    static AdEventListener getEventListener(AdRequest adRequest, PlayAdCallback playAdCallback) {
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        return new AdEventListener(adRequest, _instance.playOperations, playAdCallback, (Repository) instance.getService(Repository.class), (AdLoader) instance.getService(AdLoader.class), (JobRunner) instance.getService(JobRunner.class), (VisionController) instance.getService(VisionController.class), (Placement) null, (Advertisement) null);
    }

    private static void onLoadError(String str, LoadAdCallback loadAdCallback, VungleException vungleException) {
        if (loadAdCallback != null) {
            loadAdCallback.onError(str, vungleException);
        }
        if (vungleException != null) {
            VungleLogger.error("Vungle#loadAd", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    public static void loadAd(String str, LoadAdCallback loadAdCallback) {
        loadAd(str, new AdConfig(), loadAdCallback);
    }

    public static void loadAd(String str, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        loadAd(str, (String) null, adConfig, loadAdCallback);
    }

    public static void loadAd(String str, String str2, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        VungleLogger.debug("Vungle#loadAd", "loadAd API call invoked");
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            onLoadError(str, loadAdCallback, new VungleException(9));
        } else if (adConfig == null || AdConfig.AdSize.isDefaultAdSize(adConfig.getAdSize())) {
            ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
            Placement placement = ((Repository) instance.getService(Repository.class)).load(str, Placement.class).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
            if (placement == null || placement.getPlacementAdType() != 4) {
                loadAdInternal(str, str2, adConfig, loadAdCallback);
            } else {
                onLoadError(str, loadAdCallback, new VungleException(41));
            }
        } else {
            onLoadError(str, loadAdCallback, new VungleException(29));
        }
    }

    static void loadAdInternal(String str, String str2, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        LoadAdCallback loadAdCallback2;
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            onLoadError(str, loadAdCallback, new VungleException(9));
            return;
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        if (loadAdCallback instanceof LoadNativeAdCallback) {
            loadAdCallback2 = new LoadNativeAdCallbackWrapper(((Executors) instance.getService(Executors.class)).getUIExecutor(), (LoadNativeAdCallback) loadAdCallback);
        } else {
            loadAdCallback2 = new LoadAdCallbackWrapper(((Executors) instance.getService(Executors.class)).getUIExecutor(), loadAdCallback);
        }
        AdMarkup decode = AdMarkupDecoder.decode(str2);
        if (TextUtils.isEmpty(str2) || decode != null) {
            AdMarkup decode2 = AdMarkupDecoder.decode(str2);
            AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
            if (adConfig == null) {
                adConfig = new AdConfig();
            }
            adLoader.load(new AdRequest(str, decode2, true), adConfig, loadAdCallback2);
            return;
        }
        onLoadError(str, loadAdCallback, new VungleException(36));
    }

    private static void clearCache() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ((Downloader) ServiceLocator.this.getService(Downloader.class)).cancelAll();
                ((AdLoader) ServiceLocator.this.getService(AdLoader.class)).clear();
                ((Repository) ServiceLocator.this.getService(Repository.class)).clearAllData();
                Vungle._instance.playOperations.clear();
                Vungle._instance.ccpaStatus.set((Object) null);
                Vungle._instance.configure(((RuntimeValues) ServiceLocator.this.getService(RuntimeValues.class)).initCallback.get(), true);
            }
        });
    }

    private static void clearAdvertisements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ((Downloader) ServiceLocator.this.getService(Downloader.class)).cancelAll();
                ((AdLoader) ServiceLocator.this.getService(AdLoader.class)).clear();
                final Repository repository = (Repository) ServiceLocator.this.getService(Repository.class);
                ((Executors) ServiceLocator.this.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        List<Advertisement> list = repository.loadAll(Advertisement.class).get();
                        if (list != null) {
                            for (Advertisement id : list) {
                                try {
                                    repository.deleteAdvertisement(id.getId());
                                } catch (DatabaseHelper.DBException unused) {
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    static VungleBannerView getBannerViewInternal(String str, AdMarkup adMarkup, AdConfig adConfig, PlayAdCallback playAdCallback) {
        String str2 = str;
        PlayAdCallback playAdCallback2 = playAdCallback;
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, returned VungleBannerView = null");
            onPlayError(str2, playAdCallback2, new VungleException(9));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            onPlayError(str2, playAdCallback2, new VungleException(13));
            return null;
        } else {
            ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
            AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
            AdRequest adRequest = new AdRequest(str2, adMarkup, true);
            boolean isLoading = adLoader.isLoading(adRequest);
            if (Boolean.TRUE.equals(_instance.playOperations.get(str2)) || isLoading) {
                String str3 = TAG;
                Log.e(str3, "Playing or Loading operation ongoing. Playing " + _instance.playOperations.get(adRequest.getPlacementId()) + " Loading: " + isLoading);
                onPlayError(str2, playAdCallback2, new VungleException(8));
                return null;
            }
            try {
                AdRequest adRequest2 = adRequest;
                PlayAdCallback playAdCallback3 = playAdCallback;
                AdRequest adRequest3 = adRequest;
                return new VungleBannerView(_instance.context.getApplicationContext(), adRequest3, adConfig, (PresentationFactory) instance.getService(PresentationFactory.class), new AdEventListener(adRequest2, _instance.playOperations, playAdCallback3, (Repository) instance.getService(Repository.class), adLoader, (JobRunner) instance.getService(JobRunner.class), (VisionController) instance.getService(VisionController.class), (Placement) null, (Advertisement) null));
            } catch (Exception e) {
                VungleLogger.error("Vungle#playAd", "Vungle banner ad fail: " + e.getLocalizedMessage());
                if (playAdCallback2 != null) {
                    playAdCallback2.onError(str2, new VungleException(10));
                }
                return null;
            }
        }
    }

    public static Collection<String> getValidPlacements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<String> collection = ((Repository) instance.getService(Repository.class)).getValidPlacementIds().get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    static Collection<Placement> getValidPlacementModels() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<Placement> collection = ((Repository) instance.getService(Repository.class)).loadValidPlacements().get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    static Collection<Advertisement> getValidAdvertisementModels(String str) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<Advertisement> collection = ((Repository) instance.getService(Repository.class)).findValidAdvertisementsForPlacement(str, (String) null).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    public static void updateConsentStatus(Consent consent2, String str) {
        if (consent2 == null) {
            Log.e(TAG, "Cannot set consent with a null consent, please check your code");
            return;
        }
        _instance.consent.set(consent2);
        _instance.consentVersion = str;
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            saveGDPRConsent((Repository) ServiceLocator.getInstance(_instance.context).getService(Repository.class), _instance.consent.get(), _instance.consentVersion);
        }
    }

    /* access modifiers changed from: private */
    public static void saveGDPRConsent(final Repository repository, final Consent consent2, final String str) {
        repository.load(Cookie.CONSENT_COOKIE, Cookie.class, new Repository.LoadCallback<Cookie>() {
            public void onLoaded(Cookie cookie) {
                if (cookie == null) {
                    cookie = new Cookie(Cookie.CONSENT_COOKIE);
                }
                cookie.putValue("consent_status", Consent.this == Consent.OPTED_IN ? "opted_in" : "opted_out");
                cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie.putValue("consent_source", "publisher");
                String str = str;
                if (str == null) {
                    str = "";
                }
                cookie.putValue("consent_message_version", str);
                repository.save(cookie, (Repository.SaveCallback) null, false);
            }
        });
    }

    public static Consent getConsentStatus() {
        if (!isInitialized() || !isDepInit.get()) {
            return _instance.consent.get();
        }
        return getConsentStatus(getGDPRConsent());
    }

    private static Consent getConsentStatus(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        String string = cookie.getString("consent_status");
        char c = 65535;
        int hashCode = string.hashCode();
        if (hashCode != -83053070) {
            if (hashCode != 1230717015) {
                if (hashCode == 1720328225 && string.equals("opted_out")) {
                    c = 1;
                }
            } else if (string.equals(Gdpr.OPTED_OUT_BY_TIMEOUT)) {
                c = 0;
            }
        } else if (string.equals("opted_in")) {
            c = 2;
        }
        if (c == 0 || c == 1) {
            _instance.consent.set(Consent.OPTED_OUT);
            return Consent.OPTED_OUT;
        } else if (c != 2) {
            return null;
        } else {
            _instance.consent.set(Consent.OPTED_IN);
            return Consent.OPTED_IN;
        }
    }

    private static Cookie getGDPRConsent() {
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        return ((Repository) instance.getService(Repository.class)).load(Cookie.CONSENT_COOKIE, Cookie.class).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
    }

    public static String getConsentMessageVersion() {
        return _instance.consentVersion;
    }

    /* access modifiers changed from: private */
    public static Consent getConsent(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return "opted_in".equals(cookie.getString("consent_status")) ? Consent.OPTED_IN : Consent.OPTED_OUT;
    }

    /* access modifiers changed from: private */
    public static String getConsentMessageVersion(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return cookie.getString("consent_message_version");
    }

    private static String getConsentSource(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return cookie.getString("consent_source");
    }

    public static void updateCCPAStatus(Consent consent2) {
        if (consent2 == null) {
            Log.e(TAG, "Unable to update CCPA status, Invalid input parameter.");
            return;
        }
        _instance.ccpaStatus.set(consent2);
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            updateCCPAStatus((Repository) ServiceLocator.getInstance(_instance.context).getService(Repository.class), consent2);
        }
    }

    /* access modifiers changed from: private */
    public static void updateCCPAStatus(final Repository repository, final Consent consent2) {
        repository.load(Cookie.CCPA_COOKIE, Cookie.class, new Repository.LoadCallback<Cookie>() {
            public void onLoaded(Cookie cookie) {
                if (cookie == null) {
                    cookie = new Cookie(Cookie.CCPA_COOKIE);
                }
                cookie.putValue(Cookie.CCPA_CONSENT_STATUS, Consent.this == Consent.OPTED_OUT ? "opted_out" : "opted_in");
                repository.save(cookie, (Repository.SaveCallback) null, false);
            }
        });
    }

    public static Consent getCCPAStatus() {
        return _instance.ccpaStatus.get();
    }

    /* access modifiers changed from: private */
    public static Consent getCCPAStatus(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return "opted_out".equals(cookie.getString(Cookie.CCPA_CONSENT_STATUS)) ? Consent.OPTED_OUT : Consent.OPTED_IN;
    }

    public static void setHeaderBiddingCallback(HeaderBiddingCallback headerBiddingCallback) {
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            ((RuntimeValues) instance.getService(RuntimeValues.class)).headerBiddingCallback.set(new HeaderBiddingCallbackWrapper(((Executors) instance.getService(Executors.class)).getUIExecutor(), headerBiddingCallback));
        }
    }

    public static String getAvailableBidTokens(Context context2) {
        return getAvailableBidTokens(context2, (String) null, 0);
    }

    public static void updateUserCoppaStatus(boolean z) {
        PrivacyManager.getInstance().updateCoppaStatus(Boolean.valueOf(z));
        if (isInitialized()) {
            Log.e(TAG, "COPPA status changes should be passed before SDK initialization, they will ONLY take into effect during future SDK initializations and sessions");
        }
    }

    @Deprecated
    public static String getAvailableBidTokensBySize(Context context2, int i) {
        return getAvailableBidTokens(context2, (String) null, i);
    }

    public static String getAvailableBidTokens(Context context2, final String str, final int i) {
        if (context2 == null) {
            Log.e(TAG, "Context is null");
            return null;
        }
        ServiceLocator instance = ServiceLocator.getInstance(context2);
        final BidTokenEncoder bidTokenEncoder = (BidTokenEncoder) instance.getService(BidTokenEncoder.class);
        return (String) new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<String>() {
            public String call() {
                String encode = BidTokenEncoder.this.encode(str, i, Vungle._instance.hbpOrdinalViewCount.incrementAndGet());
                String access$1500 = Vungle.TAG;
                Log.d(access$1500, "Supertoken is " + encode);
                return encode;
            }
        })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
    }

    private void saveConfigExtension(Repository repository, JsonObject jsonObject) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie(Cookie.CONFIG_EXTENSION);
        String str = "";
        if (jsonObject.has(Cookie.CONFIG_EXTENSION)) {
            str = JsonUtil.getAsString(jsonObject, Cookie.CONFIG_EXTENSION, str);
        }
        cookie.putValue(Cookie.CONFIG_EXTENSION, str);
        repository.save(cookie);
    }

    protected static void deInit() {
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            if (instance.isCreated(CacheManager.class)) {
                ((CacheManager) instance.getService(CacheManager.class)).removeListener(cacheListener);
            }
            if (instance.isCreated(Downloader.class)) {
                ((Downloader) instance.getService(Downloader.class)).cancelAll();
            }
            if (instance.isCreated(AdLoader.class)) {
                ((AdLoader) instance.getService(AdLoader.class)).clear();
            }
            _instance.playOperations.clear();
        }
        ServiceLocator.deInit();
        isInitialized = false;
        isDepInit.set(false);
        isInitializing.set(false);
    }

    /* access modifiers changed from: private */
    public static void stopPlaying() {
        if (_instance.context != null) {
            Intent intent = new Intent(AdContract.AdvertisementBus.ACTION);
            intent.putExtra(AdContract.AdvertisementBus.COMMAND, AdContract.AdvertisementBus.STOP_ALL);
            LocalBroadcastManager.getInstance(_instance.context).sendBroadcast(intent);
        }
    }

    static Context appContext() {
        Vungle vungle = _instance;
        if (vungle != null) {
            return vungle.context;
        }
        return null;
    }
}
