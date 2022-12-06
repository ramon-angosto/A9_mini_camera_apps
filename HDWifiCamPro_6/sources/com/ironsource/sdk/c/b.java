package com.ironsource.sdk.c;

import android.webkit.JavascriptInterface;

public final class b {
    private c a;

    b(c cVar) {
        this.a = cVar;
    }

    @JavascriptInterface
    public final void receiveMessageFromExternal(String str) {
        this.a.handleMessageFromAd(str);
    }
}
