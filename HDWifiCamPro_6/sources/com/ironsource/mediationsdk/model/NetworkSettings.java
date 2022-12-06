package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkSettings {
    private String a;
    private String b;
    private JSONObject c;
    private JSONObject d;
    private JSONObject e;
    private JSONObject f;
    private String g;
    private String h;
    private boolean i;
    private String j;
    private int k;
    private int l;
    private int m;
    private String n;

    public NetworkSettings(NetworkSettings networkSettings) {
        this.a = networkSettings.getProviderName();
        this.j = networkSettings.getProviderName();
        this.b = networkSettings.getProviderTypeForReflection();
        this.d = networkSettings.getRewardedVideoSettings();
        this.e = networkSettings.getInterstitialSettings();
        this.f = networkSettings.getBannerSettings();
        this.c = networkSettings.getApplicationSettings();
        this.k = networkSettings.getRewardedVideoPriority();
        this.l = networkSettings.getInterstitialPriority();
        this.m = networkSettings.getBannerPriority();
        this.n = networkSettings.getProviderDefaultInstance();
    }

    public NetworkSettings(String str) {
        this.a = str;
        this.j = str;
        this.b = str;
        this.n = str;
        this.d = new JSONObject();
        this.e = new JSONObject();
        this.f = new JSONObject();
        this.c = new JSONObject();
        this.k = -1;
        this.l = -1;
        this.m = -1;
    }

    public NetworkSettings(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.a = str;
        this.j = str;
        this.b = str2;
        this.n = str3;
        this.d = jSONObject2;
        this.e = jSONObject3;
        this.f = jSONObject4;
        this.c = jSONObject;
        this.k = -1;
        this.l = -1;
        this.m = -1;
    }

    public String getAdSourceNameForEvents() {
        return this.h;
    }

    public JSONObject getApplicationSettings() {
        return this.c;
    }

    public int getBannerPriority() {
        return this.m;
    }

    public JSONObject getBannerSettings() {
        return this.f;
    }

    public String getCustomNetwork() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optString(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD);
        }
        return null;
    }

    public String getCustomNetworkAdapterName(IronSource.AD_UNIT ad_unit) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if ((ad_unit == null && (jSONObject2 = this.c) != null) || ((ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) && (jSONObject2 = this.d) != null) || (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL) && (jSONObject2 = this.e) != null))) {
            return jSONObject2.optString("customNetworkAdapterName");
        }
        if (!ad_unit.equals(IronSource.AD_UNIT.BANNER) || (jSONObject = this.f) == null) {
            return null;
        }
        return jSONObject.optString("customNetworkAdapterName");
    }

    public String getCustomNetworkPackage() {
        JSONObject jSONObject = this.c;
        return jSONObject != null ? jSONObject.optString("customNetworkPackage", "") : "";
    }

    public int getInstanceType(IronSource.AD_UNIT ad_unit) {
        JSONObject bannerSettings;
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            bannerSettings = getInterstitialSettings();
        } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            bannerSettings = getRewardedVideoSettings();
        } else if (ad_unit != IronSource.AD_UNIT.BANNER) {
            return 1;
        } else {
            bannerSettings = getBannerSettings();
        }
        return bannerSettings.optInt("instanceType");
    }

    public int getInterstitialPriority() {
        return this.l;
    }

    public JSONObject getInterstitialSettings() {
        return this.e;
    }

    public int getMaxAdsPerSession(IronSource.AD_UNIT ad_unit) {
        JSONObject bannerSettings;
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            bannerSettings = getInterstitialSettings();
        } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            bannerSettings = getRewardedVideoSettings();
        } else if (ad_unit != IronSource.AD_UNIT.BANNER) {
            return 99;
        } else {
            bannerSettings = getBannerSettings();
        }
        return bannerSettings.optInt("maxAdsPerSession", 99);
    }

    public String getProviderDefaultInstance() {
        return this.n;
    }

    public String getProviderInstanceName() {
        return this.j;
    }

    public String getProviderName() {
        return this.a;
    }

    public String getProviderTypeForReflection() {
        return this.b;
    }

    public int getRewardedVideoPriority() {
        return this.k;
    }

    public JSONObject getRewardedVideoSettings() {
        return this.d;
    }

    public String getSubProviderId() {
        return this.g;
    }

    public boolean isBidder(IronSource.AD_UNIT ad_unit) {
        return !isCustomNetwork() && getInstanceType(ad_unit) == 2;
    }

    public boolean isCustomNetwork() {
        return !TextUtils.isEmpty(getCustomNetwork());
    }

    public boolean isIronSource() {
        return getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) || getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME);
    }

    public boolean isMultipleInstances() {
        return this.i;
    }

    public void setAdSourceNameForEvents(String str) {
        this.h = str;
    }

    public void setApplicationSettings(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void setBannerPriority(int i2) {
        this.m = i2;
    }

    public void setBannerSettings(String str, Object obj) {
        try {
            this.f.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setBannerSettings(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    public void setInterstitialPriority(int i2) {
        this.l = i2;
    }

    public void setInterstitialSettings(String str, Object obj) {
        try {
            this.e.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setInterstitialSettings(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public void setIsMultipleInstances(boolean z) {
        this.i = z;
    }

    public void setRewardedVideoPriority(int i2) {
        this.k = i2;
    }

    public void setRewardedVideoSettings(String str, Object obj) {
        try {
            this.d.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setRewardedVideoSettings(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void setSubProviderId(String str) {
        this.g = str;
    }
}
