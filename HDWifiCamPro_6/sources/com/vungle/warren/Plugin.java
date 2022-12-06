package com.vungle.warren;

import android.util.Log;
import com.vungle.warren.VungleApiClient;
import java.util.Arrays;
import java.util.HashSet;

public class Plugin {
    private static final String TAG = Plugin.class.getSimpleName();

    public static void addWrapperInfo(VungleApiClient.WrapperFramework wrapperFramework, String str) {
        String str2;
        if (wrapperFramework == null || wrapperFramework == VungleApiClient.WrapperFramework.none) {
            Log.e(TAG, "Wrapper is null or is none");
        } else {
            VungleApiClient.WRAPPER_FRAMEWORK_SELECTED = wrapperFramework;
            String headerUa = VungleApiClient.getHeaderUa();
            if (str == null || str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "/" + str;
            }
            String str3 = wrapperFramework + str2;
            if (new HashSet(Arrays.asList(headerUa.split(";"))).add(str3)) {
                VungleApiClient.setHeaderUa(headerUa + ";" + str3);
            }
        }
        if (Vungle.isInitialized()) {
            Log.w(TAG, "VUNGLE WARNING: SDK already initialized, you should've set wrapper info before");
        }
    }
}
