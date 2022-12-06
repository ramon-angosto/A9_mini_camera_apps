package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;

/* compiled from: WindVanePlugin */
public abstract class h {
    protected Context a;
    protected Object b;
    protected WindVaneWebView c;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.a = context;
        this.c = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.b = obj;
        this.c = windVaneWebView;
    }
}
