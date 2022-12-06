package com.vungle.warren;

import com.google.gson.annotations.SerializedName;
import ms.bd.o.Pgl.c;

public class AdConfig extends BaseAdConfig {
    public static final int AUTO_ROTATE = 2;
    public static final int BOTTOM_LEFT = 2;
    public static final int BOTTOM_RIGHT = 3;
    public static final int IMMEDIATE_BACK = 2;
    public static final int IMMERSIVE = 4;
    public static final int LANDSCAPE = 1;
    public static final int MATCH_VIDEO = 3;
    public static final int PORTRAIT = 0;
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 1;
    public static final int TRANSITION_ANIMATE = 8;
    private int adOptionsPosition = 1;
    @SerializedName("adOrientation")
    private int adOrientation = 2;
    @SerializedName("ordinal")
    private int ordinal;
    protected boolean orientationChangedByApi;

    public @interface AdOptionsPosition {
    }

    public @interface Orientation {
    }

    public @interface Settings {
    }

    public /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    public /* bridge */ /* synthetic */ int getSettings() {
        return super.getSettings();
    }

    public /* bridge */ /* synthetic */ void setAdSize(AdSize adSize) {
        super.setAdSize(adSize);
    }

    public /* bridge */ /* synthetic */ void setMuted(boolean z) {
        super.setMuted(z);
    }

    public enum AdSize {
        VUNGLE_MREC("mrec", c.COLLECT_MODE_FINANCE, 250),
        VUNGLE_DEFAULT("default", -1, -1),
        BANNER("banner", 320, 50),
        BANNER_SHORT("banner_short", c.COLLECT_MODE_FINANCE, 50),
        BANNER_LEADERBOARD("banner_leaderboard", 728, 90);
        
        private final int height;
        private final String name;
        private final int width;

        private AdSize(String str, int i, int i2) {
            this.width = i;
            this.height = i2;
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public static AdSize fromName(String str) {
            for (AdSize adSize : values()) {
                if (adSize.name.equals(str)) {
                    return adSize;
                }
            }
            return VUNGLE_DEFAULT;
        }

        public static boolean isDefaultAdSize(AdSize adSize) {
            return adSize == VUNGLE_DEFAULT || adSize == VUNGLE_MREC;
        }

        public static boolean isBannerAdSize(AdSize adSize) {
            return adSize == BANNER || adSize == BANNER_LEADERBOARD || adSize == BANNER_SHORT || adSize == VUNGLE_MREC;
        }

        public static boolean isNonMrecBannerAdSize(AdSize adSize) {
            return adSize != VUNGLE_MREC && isBannerAdSize(adSize);
        }
    }

    public AdConfig() {
    }

    public AdConfig(AdSize adSize) {
        super(adSize);
    }

    public AdConfig(BaseAdConfig baseAdConfig) {
        super(baseAdConfig);
    }

    public void setBackButtonImmediatelyEnabled(boolean z) {
        if (z) {
            this.settings |= 2;
        } else {
            this.settings &= -3;
        }
    }

    public void setImmersiveMode(boolean z) {
        if (z) {
            this.settings |= 4;
        } else {
            this.settings &= -5;
        }
    }

    public void setTransitionAnimationEnabled(boolean z) {
        if (z) {
            this.settings |= 8;
        } else {
            this.settings &= -9;
        }
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public void setOrdinal(int i) {
        this.ordinal = i;
    }

    public int getAdOrientation() {
        return this.adOrientation;
    }

    public void setAdOrientation(int i) {
        this.adOrientation = i;
        this.orientationChangedByApi = true;
    }

    public void setAdOptionsPosition(int i) {
        this.adOptionsPosition = i;
    }

    public int getAdOptionsPosition() {
        return this.adOptionsPosition;
    }
}
