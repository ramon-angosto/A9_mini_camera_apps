package com.vungle.warren.session;

public enum SessionEvent {
    INIT,
    INIT_END,
    PLAY_AD,
    APP_FOREGROUND,
    APP_BACKGROUND,
    AD_EXPIRED,
    LOAD_AD,
    LOAD_AD_END,
    AD_AVAILABLE,
    ANDROID_ID,
    ADS_CACHED,
    ORIENTATION,
    MUTE,
    REWARDED,
    OM_SDK,
    DID_CLOSE,
    DISMISS_AD,
    TPAT;

    public String toString() {
        return super.toString().toLowerCase();
    }
}
