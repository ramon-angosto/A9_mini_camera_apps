package com.google.ads.mediation.pangle;

import com.google.android.gms.ads.AdError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class PangleConstants {
    public static final String APP_ID = "appid";
    public static final int ERROR_BANNER_SIZE_MISMATCH = 102;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.pangle";
    public static final int ERROR_INVALID_BID_RESPONSE = 103;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final String PANGLE_SDK_ERROR_DOMAIN = "com.pangle.ads";
    public static final String PLACEMENT_ID = "placementid";

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterError {
    }

    public static AdError createAdapterError(int i, String str) {
        return new AdError(i, str, "com.google.ads.mediation.pangle");
    }

    public static AdError createSdkError(int i, String str) {
        return new AdError(i, str, PANGLE_SDK_ERROR_DOMAIN);
    }
}
