package com.google.ads.mediation.pangle;

import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;

public class PangleAdapterUtils {
    private static int coppa = -1;

    public static void setCoppa(int i) {
        if (i == 0) {
            if (PAGSdk.isInitSuccess()) {
                PAGConfig.setChildDirected(0);
            }
            coppa = 0;
        } else if (i != 1) {
            if (PAGSdk.isInitSuccess()) {
                PAGConfig.setChildDirected(-1);
            }
            coppa = -1;
        } else {
            if (PAGSdk.isInitSuccess()) {
                PAGConfig.setChildDirected(1);
            }
            coppa = 1;
        }
    }

    public static int getCoppa() {
        return coppa;
    }
}
