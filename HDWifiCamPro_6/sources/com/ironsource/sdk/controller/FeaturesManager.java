package com.ironsource.sdk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FeaturesManager {
    private static volatile FeaturesManager a;
    private Map<String, ?> b;
    private ArrayList<String> c = new ArrayList<String>() {
        {
            add("webviewperad-v1");
            add("noPackagesInstallationPolling");
            add("removeViewOnDestroy");
            add("bannerMultipleInstances");
            add("lastUpdateTimeRemoval");
            add("isnFileSystemAPI");
            add("controlActivityLifecycle");
            add("bannersOpenMeasurement");
        }
    };

    private FeaturesManager() {
        if (a == null) {
            this.b = new HashMap();
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
    }

    public static FeaturesManager getInstance() {
        if (a == null) {
            synchronized (FeaturesManager.class) {
                if (a == null) {
                    a = new FeaturesManager();
                }
            }
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    public final ArrayList<String> a() {
        return new ArrayList<>(this.c);
    }

    public int getDebugMode() {
        Integer num = 0;
        try {
            if (this.b.containsKey("debugMode")) {
                num = (Integer) this.b.get("debugMode");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void updateDebugConfigurations(Map<String, Object> map) {
        if (map != null) {
            this.b = map;
        }
    }
}
