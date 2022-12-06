package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;

final class s {
    private t a;
    private boolean b = false;

    s(t tVar) {
        this.a = tVar;
    }

    @JavascriptInterface
    public final String getTokenForMessaging() {
        if (this.b) {
            return "";
        }
        this.b = true;
        return this.a.a;
    }
}
