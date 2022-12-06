package com.ironsource.adapters.facebook;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BidderTokenProvider;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import ms.bd.o.Pgl.c;
import org.json.JSONObject;

public class FacebookAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    public static int BN_FAILED_TO_RELOAD_ERROR_CODE = 103;
    private static final String GitHash = "3f62a6f15";
    private static final String MEDIATION_SERVICE_NAME = "ironSource";
    private static final String VERSION = "4.3.34";
    protected static HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();
    protected static AtomicBoolean mDidCallInit = new AtomicBoolean(false);
    protected static Boolean mDidInitSuccess = null;
    protected static EnumSet<CacheFlag> mInterstitialFacebookFlags = EnumSet.allOf(CacheFlag.class);
    protected final String ALL_PLACEMENT_IDS = "placementIds";
    protected final String FACEBOOK_BN_CACHE_FLAG = "facebook_bn_cacheflag";
    protected final String FACEBOOK_IS_CACHE_FLAG = "facebook_is_cacheflag";
    protected final String FACEBOOK_RV_CACHE_FLAG = "facebook_rv_cacheflag";
    protected final String PLACEMENT_ID = ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID;
    protected ConcurrentHashMap<String, AdView> mBNPlacementToAdMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, BannerSmashListener> mBNPlacementToListenerMap = new ConcurrentHashMap<>();
    protected boolean mDidCallClosed;
    protected ConcurrentHashMap<String, InterstitialAd> mISPlacementToAdMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, FacebookInterstitialAdListener> mISPlacementToFBListener = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, InterstitialSmashListener> mISPlacementToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, Boolean> mInterstitialAdsAvailability = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, Boolean> mInterstitialPlacementIdShowCalled = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, RewardedVideoAd> mRVPlacementToAdMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, FacebookRewardedVideoAdListener> mRVPlacementToFBListener = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, RewardedVideoSmashListener> mRVPlacementToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, Boolean> mRewardedVideoPlacementIdShowCalled = new ConcurrentHashMap<>();
    protected CopyOnWriteArraySet<String> mRewardedVideoPlacementsForInitCallbacks = new CopyOnWriteArraySet<>();
    protected ConcurrentHashMap<String, Boolean> mRvAdsAvailability = new ConcurrentHashMap<>();

    public static String getAdapterSDKVersion() {
        return "6.8.0";
    }

    public String getVersion() {
        return "4.3.34";
    }

    public void onNetworkInitCallbackLoadSuccess(String str) {
    }

    public static FacebookAdapter startAdapter(String str) {
        return new FacebookAdapter(str);
    }

    public static IntegrationData getIntegrationData(Activity activity) {
        IntegrationData integrationData = new IntegrationData("Facebook", "4.3.34");
        integrationData.activities = new String[]{"com.facebook.ads.AudienceNetworkActivity"};
        return integrationData;
    }

    private FacebookAdapter(String str) {
        super(str);
        AdSettings.setMediationService(getMediationServiceName());
        this.mDidCallClosed = false;
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    private String getMediationServiceName() {
        String format = String.format("%s_%s:%s", new Object[]{"ironSource", "7.1.13", "4.3.34"});
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("mediationServiceName = " + format);
        return format;
    }

    public String getCoreSDKVersion() {
        return getAdapterSDKVersion();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMetaData(java.lang.String r5, java.util.List<java.lang.String> r6) {
        /*
            r4 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.ADAPTER_API
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "key = "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ", values = "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.verbose(r1)
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r5 = r5.toLowerCase(r0)
            int r0 = r5.hashCode()
            r1 = -503171436(0xffffffffe2023694, float:-6.005024E20)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x004e
            r1 = 5585394(0x5539f2, float:7.826804E-39)
            if (r0 == r1) goto L_0x0044
            r1 = 71443084(0x442228c, float:2.2820454E-36)
            if (r0 == r1) goto L_0x003a
            goto L_0x0058
        L_0x003a:
            java.lang.String r0 = "facebook_rv_cacheflag"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0058
            r5 = 0
            goto L_0x0059
        L_0x0044:
            java.lang.String r0 = "facebook_is_cacheflag"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0058
            r5 = r2
            goto L_0x0059
        L_0x004e:
            java.lang.String r0 = "facebook_bn_cacheflag"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0058
            r5 = r3
            goto L_0x0059
        L_0x0058:
            r5 = -1
        L_0x0059:
            if (r5 == 0) goto L_0x00a6
            if (r5 == r3) goto L_0x00a6
            if (r5 == r2) goto L_0x0060
            goto L_0x00a6
        L_0x0060:
            java.util.EnumSet<com.facebook.ads.CacheFlag> r5 = mInterstitialFacebookFlags
            r5.clear()
            java.util.Iterator r5 = r6.iterator()     // Catch:{ Exception -> 0x0099 }
        L_0x0069:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x0099 }
            if (r6 == 0) goto L_0x00a6
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0099 }
            com.facebook.ads.CacheFlag r6 = r4.getFacebookCacheFlag(r6)     // Catch:{ Exception -> 0x0099 }
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.ADAPTER_API     // Catch:{ Exception -> 0x0099 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r1.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r2 = "flag = "
            r1.append(r2)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r2 = r6.name()     // Catch:{ Exception -> 0x0099 }
            r1.append(r2)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0099 }
            r0.verbose(r1)     // Catch:{ Exception -> 0x0099 }
            java.util.EnumSet<com.facebook.ads.CacheFlag> r0 = mInterstitialFacebookFlags     // Catch:{ Exception -> 0x0099 }
            r0.add(r6)     // Catch:{ Exception -> 0x0099 }
            goto L_0x0069
        L_0x0099:
            com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r6 = "flag is unknown or all, set all as default"
            r5.error(r6)
            java.util.EnumSet r5 = r4.getFacebookAllCacheFlags()
            mInterstitialFacebookFlags = r5
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.facebook.FacebookAdapter.setMetaData(java.lang.String, java.util.List):void");
    }

    private CacheFlag getFacebookCacheFlag(String str) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("value = " + str);
        return CacheFlag.valueOf(str.toUpperCase(Locale.ENGLISH));
    }

    private EnumSet<CacheFlag> getFacebookAllCacheFlags() {
        IronLog.ADAPTER_API.verbose("");
        return EnumSet.allOf(CacheFlag.class);
    }

    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("placement is empty");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing placementId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placement = " + optString);
        this.mRVPlacementToFBListener.put(optString, new FacebookRewardedVideoAdListener(this, rewardedVideoSmashListener, optString));
        this.mRVPlacementToListenerMap.put(optString, rewardedVideoSmashListener);
        this.mRewardedVideoPlacementsForInitCallbacks.add(optString);
        initSdk(jSONObject);
        if (mDidInitSuccess != null) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose("mDidInitSuccess = " + mDidInitSuccess);
            if (mDidInitSuccess.booleanValue()) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("FAN Sdk failed to initiate", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
        }
    }

    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("placement is empty");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placement = " + optString);
        this.mRVPlacementToFBListener.put(optString, new FacebookRewardedVideoAdListener(this, rewardedVideoSmashListener, optString));
        this.mRVPlacementToListenerMap.put(optString, rewardedVideoSmashListener);
        initSdk(jSONObject);
        if (mDidInitSuccess != null) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose("mDidInitSuccess = " + mDidInitSuccess);
            if (mDidInitSuccess.booleanValue()) {
                loadRewardedVideo(optString, (String) null);
            } else {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    public void loadRewardedVideoForBidding(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener, String str) {
        IronLog.ADAPTER_API.verbose("");
        loadRewardedVideo(jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID), str);
    }

    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        loadRewardedVideo(jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID), (String) null);
    }

    private void loadRewardedVideo(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            IronLog.INTERNAL.error("placement is empty");
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placement = " + str);
        this.mRvAdsAvailability.put(str, false);
        this.mRewardedVideoPlacementIdShowCalled.put(str, false);
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    if (FacebookAdapter.this.mRVPlacementToAdMap.containsKey(str)) {
                        IronLog ironLog = IronLog.ADAPTER_API;
                        ironLog.verbose("destroying old placement = " + str);
                        FacebookAdapter.this.mRVPlacementToAdMap.get(str).destroy();
                        FacebookAdapter.this.mRVPlacementToAdMap.remove(str);
                    }
                    RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(ContextProvider.getInstance().getApplicationContext(), str);
                    RewardedVideoAd.RewardedVideoAdLoadConfigBuilder buildLoadAdConfig = rewardedVideoAd.buildLoadAdConfig();
                    buildLoadAdConfig.withAdListener(FacebookAdapter.this.mRVPlacementToFBListener.get(str));
                    if (str2 != null) {
                        buildLoadAdConfig.withBid(str2);
                    }
                    if (!TextUtils.isEmpty(FacebookAdapter.this.getDynamicUserId())) {
                        buildLoadAdConfig.withRewardData(new RewardData(FacebookAdapter.this.getDynamicUserId(), "1"));
                    }
                    rewardedVideoAd.loadAd(buildLoadAdConfig.build());
                    FacebookAdapter.this.mRVPlacementToAdMap.put(str, rewardedVideoAd);
                } catch (Exception unused) {
                    if (FacebookAdapter.this.mRVPlacementToListenerMap.containsKey(str)) {
                        FacebookAdapter.this.mRVPlacementToListenerMap.get(str).onRewardedVideoAvailabilityChanged(false);
                    }
                }
            }
        });
    }

    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        return this.mRvAdsAvailability.containsKey(optString) && this.mRvAdsAvailability.get(optString).booleanValue();
    }

    public void showRewardedVideo(JSONObject jSONObject, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        final String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        this.mRvAdsAvailability.put(optString, false);
        postOnUIThread(new Runnable() {
            public void run() {
                String str;
                try {
                    RewardedVideoAd rewardedVideoAd = FacebookAdapter.this.mRVPlacementToAdMap.get(optString);
                    if (rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded() || rewardedVideoAd.isAdInvalidated()) {
                        if (rewardedVideoAd != null) {
                            str = "videoAd.isAdInvalidated() = " + rewardedVideoAd.isAdInvalidated();
                        } else {
                            str = "no ads to show";
                        }
                        IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str);
                        IronLog.INTERNAL.error("error = " + buildShowFailedError.getErrorMessage());
                        rewardedVideoSmashListener.onRewardedVideoAdShowFailed(buildShowFailedError);
                        rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                    }
                    FacebookAdapter.this.mRewardedVideoPlacementIdShowCalled.put(optString, true);
                    rewardedVideoAd.show();
                    rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                } catch (Exception e) {
                    IronLog.INTERNAL.error("ex.getMessage() = " + e.getMessage());
                    rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, e.getMessage()));
                }
            }
        });
    }

    public void onNetworkInitCallbackSuccess() {
        IronLog.ADAPTER_API.verbose("");
        for (BannerSmashListener onBannerInitSuccess : this.mBNPlacementToListenerMap.values()) {
            onBannerInitSuccess.onBannerInitSuccess();
        }
        for (InterstitialSmashListener onInterstitialInitSuccess : this.mISPlacementToListenerMap.values()) {
            onInterstitialInitSuccess.onInterstitialInitSuccess();
        }
        for (String next : this.mRVPlacementToListenerMap.keySet()) {
            if (this.mRewardedVideoPlacementsForInitCallbacks.contains(next)) {
                this.mRVPlacementToListenerMap.get(next).onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideo(next, (String) null);
            }
        }
    }

    public void onNetworkInitCallbackFailed(String str) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("error: " + str);
        for (BannerSmashListener onBannerInitFailed : this.mBNPlacementToListenerMap.values()) {
            onBannerInitFailed.onBannerInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.BANNER_AD_UNIT));
        }
        for (InterstitialSmashListener onInterstitialInitFailed : this.mISPlacementToListenerMap.values()) {
            onInterstitialInitFailed.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.INTERSTITIAL_AD_UNIT));
        }
        for (String next : this.mRVPlacementToListenerMap.keySet()) {
            if (this.mRewardedVideoPlacementsForInitCallbacks.contains(next)) {
                this.mRVPlacementToListenerMap.get(next).onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                this.mRVPlacementToListenerMap.get(next).onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        initInterstitial(str, str2, jSONObject, interstitialSmashListener);
    }

    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("placement is empty");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params: placementId", IronSourceConstants.INTERSTITIAL_AD_UNIT));
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placement = " + optString);
        FacebookInterstitialAdListener facebookInterstitialAdListener = new FacebookInterstitialAdListener(this, interstitialSmashListener, optString);
        this.mISPlacementToListenerMap.put(optString, interstitialSmashListener);
        this.mISPlacementToFBListener.put(optString, facebookInterstitialAdListener);
        initSdk(jSONObject);
        Boolean bool = mDidInitSuccess;
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            interstitialSmashListener.onInterstitialInitSuccess();
        } else {
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("init failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
        }
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener, String str) {
        IronLog.ADAPTER_API.verbose("");
        loadInterstitialInternal(interstitialSmashListener, jSONObject, str);
    }

    public void loadInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        loadInterstitialInternal(interstitialSmashListener, jSONObject, (String) null);
    }

    private void loadInterstitialInternal(final InterstitialSmashListener interstitialSmashListener, JSONObject jSONObject, final String str) {
        final String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("placement is empty");
            interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Empty placementId"));
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        this.mInterstitialPlacementIdShowCalled.put(optString, false);
        this.mInterstitialAdsAvailability.put(optString, false);
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    if (FacebookAdapter.this.mISPlacementToAdMap.containsKey(optString)) {
                        IronLog ironLog = IronLog.ADAPTER_API;
                        ironLog.verbose("destroying old placement = " + optString);
                        FacebookAdapter.this.mISPlacementToAdMap.get(optString).destroy();
                        FacebookAdapter.this.mISPlacementToAdMap.remove(optString);
                    }
                    InterstitialAd interstitialAd = new InterstitialAd(ContextProvider.getInstance().getApplicationContext(), optString);
                    InterstitialAd.InterstitialAdLoadConfigBuilder buildLoadAdConfig = interstitialAd.buildLoadAdConfig();
                    buildLoadAdConfig.withCacheFlags(FacebookAdapter.mInterstitialFacebookFlags);
                    buildLoadAdConfig.withAdListener(FacebookAdapter.this.mISPlacementToFBListener.get(optString));
                    if (str != null) {
                        buildLoadAdConfig.withBid(str);
                    }
                    IronLog ironLog2 = IronLog.ADAPTER_API;
                    ironLog2.verbose("loading placement = " + optString + " with facebook flags = " + FacebookAdapter.mInterstitialFacebookFlags.toString());
                    interstitialAd.loadAd(buildLoadAdConfig.build());
                    FacebookAdapter.this.mISPlacementToAdMap.put(optString, interstitialAd);
                } catch (Exception e) {
                    interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError(e.getLocalizedMessage()));
                }
            }
        });
    }

    public void showInterstitial(JSONObject jSONObject, final InterstitialSmashListener interstitialSmashListener) {
        final String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        this.mInterstitialAdsAvailability.put(optString, false);
        postOnUIThread(new Runnable() {
            public void run() {
                String str;
                try {
                    InterstitialAd interstitialAd = FacebookAdapter.this.mISPlacementToAdMap.get(optString);
                    if (interstitialAd == null || !interstitialAd.isAdLoaded() || interstitialAd.isAdInvalidated()) {
                        if (interstitialAd != null) {
                            str = "interstitialAd.isAdInvalidated() = " + interstitialAd.isAdInvalidated();
                        } else {
                            str = "no ads to show";
                        }
                        IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.INTERSTITIAL_AD_UNIT, str);
                        IronLog.INTERNAL.error("error = " + buildShowFailedError.getErrorMessage());
                        interstitialSmashListener.onInterstitialAdShowFailed(buildShowFailedError);
                        return;
                    }
                    FacebookAdapter.this.mInterstitialPlacementIdShowCalled.put(optString, true);
                    interstitialAd.show();
                } catch (Exception e) {
                    IronLog.INTERNAL.error("ex.getMessage() = " + e.getMessage());
                    interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.INTERSTITIAL_AD_UNIT, e.getMessage()));
                }
            }
        });
    }

    public boolean isInterstitialReady(JSONObject jSONObject) {
        String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        return this.mInterstitialAdsAvailability.containsKey(optString) && this.mInterstitialAdsAvailability.get(optString).booleanValue();
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        initBannersInternal(jSONObject, bannerSmashListener);
    }

    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        initBannersInternal(jSONObject, bannerSmashListener);
    }

    private void initBannersInternal(JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("placement is empty");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing placementId", IronSourceConstants.BANNER_AD_UNIT));
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placement = " + optString);
        this.mBNPlacementToListenerMap.put(optString, bannerSmashListener);
        initSdk(jSONObject);
        Boolean bool = mDidInitSuccess;
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            bannerSmashListener.onBannerInitSuccess();
        } else {
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("init failed", IronSourceConstants.BANNER_AD_UNIT));
        }
    }

    public void loadBannerForBidding(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, BannerSmashListener bannerSmashListener, String str) {
        IronLog.ADAPTER_API.verbose("");
        loadBannerInternal(ironSourceBannerLayout, jSONObject, bannerSmashListener, str);
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        IronLog.ADAPTER_API.verbose("");
        loadBannerInternal(ironSourceBannerLayout, jSONObject, bannerSmashListener, (String) null);
    }

    private void loadBannerInternal(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, BannerSmashListener bannerSmashListener, String str) {
        final String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
        if (ironSourceBannerLayout == null) {
            IronLog.INTERNAL.error("banner is null");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("banner layout is null"));
        } else if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("placement is empty");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("FacebookAdapter loadBanner placementId is empty"));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("placementId = " + optString);
            final AdSize calculateBannerSize = calculateBannerSize(ironSourceBannerLayout.getSize(), AdapterUtils.isLargeScreen(ironSourceBannerLayout.getActivity()));
            if (calculateBannerSize == null) {
                IronLog.INTERNAL.error("adSize is null");
                bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize("Facebook"));
                return;
            }
            final IronSourceBannerLayout ironSourceBannerLayout2 = ironSourceBannerLayout;
            final BannerSmashListener bannerSmashListener2 = bannerSmashListener;
            final String str2 = str;
            postOnUIThread(new Runnable() {
                public void run() {
                    try {
                        AdView adView = new AdView((Context) ironSourceBannerLayout2.getActivity(), optString, calculateBannerSize);
                        FacebookBannerAdListener facebookBannerAdListener = new FacebookBannerAdListener(FacebookAdapter.this, bannerSmashListener2, optString, FacebookAdapter.this.calcLayoutParams(ironSourceBannerLayout2.getSize(), ironSourceBannerLayout2.getActivity()));
                        AdView.AdViewLoadConfigBuilder buildLoadAdConfig = adView.buildLoadAdConfig();
                        buildLoadAdConfig.withAdListener(facebookBannerAdListener);
                        if (str2 != null) {
                            buildLoadAdConfig.withBid(str2);
                        }
                        FacebookAdapter.this.mBNPlacementToAdMap.put(optString, adView);
                        adView.loadAd(buildLoadAdConfig.build());
                    } catch (Exception e) {
                        bannerSmashListener2.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("FacebookAdapter loadBanner exception " + e.getMessage()));
                    }
                }
            });
        }
    }

    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, final JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID));
        postOnUIThread(new Runnable() {
            public void run() {
                String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
                if (FacebookAdapter.this.mBNPlacementToAdMap.containsKey(optString)) {
                    FacebookAdapter.this.mBNPlacementToAdMap.get(optString).loadAd();
                } else if (FacebookAdapter.this.mBNPlacementToListenerMap.containsKey(optString)) {
                    int i = FacebookAdapter.BN_FAILED_TO_RELOAD_ERROR_CODE;
                    FacebookAdapter.this.mBNPlacementToListenerMap.get(optString).onBannerAdLoadFailed(new IronSourceError(i, FacebookAdapter.this.getProviderName() + "reloadBanner missing banner " + optString));
                }
            }
        });
    }

    public void destroyBanner(final JSONObject jSONObject) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID));
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
                    if (FacebookAdapter.this.mBNPlacementToAdMap.containsKey(optString)) {
                        IronLog ironLog = IronLog.ADAPTER_API;
                        ironLog.verbose("destroying old placement = " + optString);
                        FacebookAdapter.this.mBNPlacementToAdMap.get(optString).destroy();
                        FacebookAdapter.this.mBNPlacementToAdMap.remove(optString);
                    }
                } catch (Exception e) {
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.error("destroyBanner failed with an exception = " + e);
                }
            }
        });
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.ads.AdSize calculateBannerSize(com.ironsource.mediationsdk.ISBannerSize r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getDescription()
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -387072689: goto L_0x0038;
                case 72205083: goto L_0x002e;
                case 79011241: goto L_0x0024;
                case 1951953708: goto L_0x001a;
                case 1999208305: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0042
        L_0x0010:
            java.lang.String r1 = "CUSTOM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = r2
            goto L_0x0043
        L_0x001a:
            java.lang.String r1 = "BANNER"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 0
            goto L_0x0043
        L_0x0024:
            java.lang.String r1 = "SMART"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = r3
            goto L_0x0043
        L_0x002e:
            java.lang.String r1 = "LARGE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = r5
            goto L_0x0043
        L_0x0038:
            java.lang.String r1 = "RECTANGLE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = r4
            goto L_0x0043
        L_0x0042:
            r0 = -1
        L_0x0043:
            if (r0 == 0) goto L_0x007f
            if (r0 == r5) goto L_0x007c
            if (r0 == r4) goto L_0x0079
            if (r0 == r3) goto L_0x0071
            if (r0 == r2) goto L_0x004e
            goto L_0x006f
        L_0x004e:
            int r8 = r7.getHeight()
            r0 = 50
            if (r8 != r0) goto L_0x0059
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_50
            return r7
        L_0x0059:
            int r8 = r7.getHeight()
            r0 = 90
            if (r8 != r0) goto L_0x0064
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_90
            return r7
        L_0x0064:
            int r7 = r7.getHeight()
            r8 = 250(0xfa, float:3.5E-43)
            if (r7 != r8) goto L_0x006f
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250
            return r7
        L_0x006f:
            r7 = 0
            return r7
        L_0x0071:
            if (r8 == 0) goto L_0x0076
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_90
            goto L_0x0078
        L_0x0076:
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_50
        L_0x0078:
            return r7
        L_0x0079:
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250
            return r7
        L_0x007c:
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_90
            return r7
        L_0x007f:
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_50
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.facebook.FacebookAdapter.calculateBannerSize(com.ironsource.mediationsdk.ISBannerSize, boolean):com.facebook.ads.AdSize");
    }

    /* access modifiers changed from: private */
    public FrameLayout.LayoutParams calcLayoutParams(ISBannerSize iSBannerSize, Activity activity) {
        int i;
        if (iSBannerSize.getDescription().equals("RECTANGLE")) {
            i = c.COLLECT_MODE_FINANCE;
        } else {
            i = (!iSBannerSize.getDescription().equals("SMART") || !AdapterUtils.isLargeScreen(activity)) ? 320 : 728;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(activity, i), -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private Map<String, Object> getBiddingData() {
        Boolean bool = mDidInitSuccess;
        if (bool == null || !bool.booleanValue()) {
            IronLog.INTERNAL.verbose("returning null as token since init failed");
            return null;
        }
        String bidderToken = BidderTokenProvider.getBidderToken(ContextProvider.getInstance().getApplicationContext());
        if (TextUtils.isEmpty(bidderToken)) {
            bidderToken = "";
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("token = " + bidderToken);
        HashMap hashMap = new HashMap();
        hashMap.put("token", bidderToken);
        return hashMap;
    }

    private void initSdk(JSONObject jSONObject) {
        if (mDidCallInit.compareAndSet(false, true)) {
            IronLog.ADAPTER_API.verbose("");
            if (AudienceNetworkAds.isInitialized(ContextProvider.getInstance().getApplicationContext())) {
                IronLog.ADAPTER_API.verbose("SDK is already initialized");
                mDidInitSuccess = true;
                return;
            }
            initCallbackListeners.add(this);
            FacebookInitListener facebookInitListener = new FacebookInitListener(this);
            String optString = jSONObject.optString("placementIds");
            if (TextUtils.isEmpty(optString)) {
                IronLog.ADAPTER_API.verbose("Initialize Facebook without placement ids");
                AudienceNetworkAds.buildInitSettings(ContextProvider.getInstance().getApplicationContext()).withInitListener(facebookInitListener).initialize();
                return;
            }
            List asList = Arrays.asList(optString.split(","));
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("Initialize Facebook with placement ids = " + asList.toString());
            AudienceNetworkAds.buildInitSettings(ContextProvider.getInstance().getApplicationContext()).withInitListener(facebookInitListener).withPlacementIds(asList).initialize();
        } else if (mDidInitSuccess == null) {
            initCallbackListeners.add(this);
        }
    }

    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + ad_unit);
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            for (RewardedVideoAd destroy : this.mRVPlacementToAdMap.values()) {
                destroy.destroy();
            }
            this.mRVPlacementToAdMap.clear();
            this.mRVPlacementToFBListener.clear();
            this.mRVPlacementToListenerMap.clear();
            this.mRvAdsAvailability.clear();
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            for (InterstitialAd destroy2 : this.mISPlacementToAdMap.values()) {
                destroy2.destroy();
            }
            this.mISPlacementToAdMap.clear();
            this.mISPlacementToFBListener.clear();
            this.mISPlacementToListenerMap.clear();
            this.mInterstitialAdsAvailability.clear();
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            for (AdView destroy3 : this.mBNPlacementToAdMap.values()) {
                destroy3.destroy();
            }
            this.mBNPlacementToAdMap.clear();
            this.mBNPlacementToListenerMap.clear();
        }
    }
}
