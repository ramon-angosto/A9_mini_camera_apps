package com.vungle.mediation;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.vungle.warren.AdConfig;
import java.util.UUID;

public final class VungleExtrasBuilder {
    static final String EXTRA_ALL_PLACEMENTS = "allPlacements";
    private static final String EXTRA_ORDINAL_VIEW_COUNT = "ordinalViewCount";
    private static final String EXTRA_ORIENTATION = "adOrientation";
    static final String EXTRA_PLAY_PLACEMENT = "playPlacement";
    private static final String EXTRA_START_MUTED = "startMuted";
    public static final String EXTRA_USER_ID = "userId";
    static final String UUID_KEY = "uniqueVungleRequestKey";
    private final Bundle mBundle = new Bundle();

    public VungleExtrasBuilder(String[] strArr) {
        this.mBundle.putStringArray(EXTRA_ALL_PLACEMENTS, strArr);
    }

    public VungleExtrasBuilder setPlayingPlacement(String str) {
        this.mBundle.putString(EXTRA_PLAY_PLACEMENT, str);
        return this;
    }

    @Deprecated
    public VungleExtrasBuilder setSoundEnabled(boolean z) {
        return setStartMuted(!z);
    }

    public VungleExtrasBuilder setStartMuted(boolean z) {
        this.mBundle.putBoolean(EXTRA_START_MUTED, z);
        return this;
    }

    public VungleExtrasBuilder setUserId(String str) {
        this.mBundle.putString("userId", str);
        return this;
    }

    public VungleExtrasBuilder setOrdinalViewCount(int i) {
        this.mBundle.putInt(EXTRA_ORDINAL_VIEW_COUNT, i);
        return this;
    }

    public VungleExtrasBuilder setAdOrientation(int i) {
        this.mBundle.putInt(EXTRA_ORIENTATION, i);
        return this;
    }

    public VungleExtrasBuilder setBannerUniqueRequestID(String str) {
        this.mBundle.putString(UUID_KEY, str);
        return this;
    }

    public Bundle build() {
        if (TextUtils.isEmpty(this.mBundle.getString(UUID_KEY, (String) null))) {
            this.mBundle.putString(UUID_KEY, UUID.randomUUID().toString());
        }
        return this.mBundle;
    }

    public static AdConfig adConfigWithNetworkExtras(Bundle bundle, boolean z) {
        AdConfig adConfig = new AdConfig();
        adConfig.setMuted(z);
        if (bundle != null) {
            adConfig.setMuted(bundle.getBoolean(EXTRA_START_MUTED, z));
            adConfig.setOrdinal(bundle.getInt(EXTRA_ORDINAL_VIEW_COUNT, 0));
            adConfig.setAdOrientation(bundle.getInt(EXTRA_ORIENTATION, 2));
        }
        return adConfig;
    }

    public static AdConfig adConfigWithNetworkExtras(Bundle bundle, NativeAdOptions nativeAdOptions, boolean z) {
        int i;
        AdConfig adConfigWithNetworkExtras = adConfigWithNetworkExtras(bundle, z);
        int i2 = 1;
        if (nativeAdOptions != null) {
            i = nativeAdOptions.getAdChoicesPlacement();
        } else {
            i = 1;
        }
        if (i == 0) {
            i2 = 0;
        } else if (i == 2) {
            i2 = 3;
        } else if (i == 3) {
            i2 = 2;
        }
        adConfigWithNetworkExtras.setAdOptionsPosition(i2);
        return adConfigWithNetworkExtras;
    }
}
