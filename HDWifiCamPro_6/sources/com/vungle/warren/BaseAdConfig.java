package com.vungle.warren;

import com.google.gson.annotations.SerializedName;
import com.vungle.warren.AdConfig;

class BaseAdConfig {
    public static final int MUTED = 1;
    @SerializedName("adSize")
    private AdConfig.AdSize adSize;
    protected boolean muteChangedByApi;
    @SerializedName("settings")
    protected int settings;

    public BaseAdConfig() {
    }

    public BaseAdConfig(AdConfig.AdSize adSize2) {
        this.adSize = adSize2;
    }

    public BaseAdConfig(BaseAdConfig baseAdConfig) {
        this(baseAdConfig.getAdSize());
        this.settings = baseAdConfig.getSettings();
    }

    public void setMuted(boolean z) {
        if (z) {
            this.settings |= 1;
        } else {
            this.settings &= -2;
        }
        this.muteChangedByApi = true;
    }

    public AdConfig.AdSize getAdSize() {
        AdConfig.AdSize adSize2 = this.adSize;
        return adSize2 == null ? AdConfig.AdSize.VUNGLE_DEFAULT : adSize2;
    }

    public void setAdSize(AdConfig.AdSize adSize2) {
        this.adSize = adSize2;
    }

    public int getSettings() {
        return this.settings;
    }
}
