package com.bytedance.sdk.openadsdk;

public interface InitConfig {
    int getAppIconId();

    String getAppId();

    int getCcpa();

    int getCoppa();

    String getData();

    int getGdpr();

    String getPackageName();

    int getTitleBarTheme();

    boolean isSupportMultiProcess();

    boolean isUseTextureView();
}
