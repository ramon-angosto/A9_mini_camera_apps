package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.a.b;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.core.k;

@Deprecated
public final class TTAdSdk {

    @Deprecated
    public interface InitCallback extends PAGSdk.PAGInitCallback {
    }

    public static boolean isInitSuccess() {
        return PAGSdk.isInitSuccess();
    }

    public static void init(Context context, TTAdConfig tTAdConfig, InitCallback initCallback) {
        PAGSdk.doInit(context, tTAdConfig, initCallback);
    }

    public static TTAdManager getAdManager() {
        return b.a();
    }

    public static void setCoppa(int i) {
        PAGConfig.setChildDirected(i);
    }

    public static int getCoppa() {
        return PAGConfig.getChildDirected();
    }

    public static void setGdpr(int i) {
        if (i == 1) {
            i = 0;
        } else if (i == 0) {
            i = 1;
        }
        PAGConfig.setGDPRConsent(i);
    }

    public static int getGdpr() {
        return b.a().getGdpr();
    }

    public static void setCCPA(int i) {
        PAGConfig.setDoNotSell(i);
    }

    public static int getCCPA() {
        return PAGConfig.getDoNotSell();
    }

    public static void addInitCallback(InitCallback initCallback) {
        if (initCallback != null && k.e() == 0) {
            k.d.add(initCallback);
        }
    }
}
