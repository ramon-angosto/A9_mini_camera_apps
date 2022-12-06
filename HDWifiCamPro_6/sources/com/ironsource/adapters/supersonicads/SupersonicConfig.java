package com.ironsource.adapters.supersonicads;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SupersonicConfig {
    private static SupersonicConfig mInstance;
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String CAMPAIGN_ID = "campaignId";
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String ITEM_COUNT = "itemCount";
    private final String ITEM_NAME = "itemName";
    private final String LANGUAGE = "language";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private Map<String, String> mOfferwallCustomParams;
    NetworkSettings mProviderSettings = new NetworkSettings(n.a().a("Mediation"));
    private Map<String, String> mRewardedVideoCustomParams;

    private SupersonicConfig() {
    }

    private Map<String, String> convertCustomParams(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            try {
                Set<String> keySet = map.keySet();
                if (keySet != null) {
                    for (String next : keySet) {
                        if (!TextUtils.isEmpty(next)) {
                            String str = map.get(next);
                            if (!TextUtils.isEmpty(str)) {
                                hashMap.put("custom_" + next, str);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, ":convertCustomParams()", e);
            }
        }
        return hashMap;
    }

    public static SupersonicConfig getConfigObj() {
        if (mInstance == null) {
            mInstance = new SupersonicConfig();
        }
        return mInstance;
    }

    public boolean getClientSideCallbacks() {
        NetworkSettings networkSettings = this.mProviderSettings;
        if (networkSettings == null || networkSettings.getRewardedVideoSettings() == null || !this.mProviderSettings.getRewardedVideoSettings().has("useClientSideCallbacks")) {
            return false;
        }
        return this.mProviderSettings.getRewardedVideoSettings().optBoolean("useClientSideCallbacks", false);
    }

    public Map<String, String> getOfferwallCustomParams() {
        return this.mOfferwallCustomParams;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getRewardedVideoCustomParams() {
        return this.mRewardedVideoCustomParams;
    }

    public void setCampaignId(String str) {
        this.mProviderSettings.setRewardedVideoSettings("campaignId", str);
    }

    public void setClientSideCallbacks(boolean z) {
        this.mProviderSettings.setRewardedVideoSettings("useClientSideCallbacks", String.valueOf(z));
    }

    public void setCustomControllerUrl(String str) {
        this.mProviderSettings.setRewardedVideoSettings("controllerUrl", str);
        this.mProviderSettings.setInterstitialSettings("controllerUrl", str);
        this.mProviderSettings.setBannerSettings("controllerUrl", str);
    }

    public void setDebugMode(int i) {
        this.mProviderSettings.setRewardedVideoSettings("debugMode", Integer.valueOf(i));
        this.mProviderSettings.setInterstitialSettings("debugMode", Integer.valueOf(i));
        this.mProviderSettings.setBannerSettings("debugMode", Integer.valueOf(i));
    }

    public void setLanguage(String str) {
        this.mProviderSettings.setRewardedVideoSettings("language", str);
        this.mProviderSettings.setInterstitialSettings("language", str);
    }

    public void setOfferwallCustomParams(Map<String, String> map) {
        this.mOfferwallCustomParams = convertCustomParams(map);
    }

    public void setRewardedVideoCustomParams(Map<String, String> map) {
        this.mRewardedVideoCustomParams = convertCustomParams(map);
    }
}
