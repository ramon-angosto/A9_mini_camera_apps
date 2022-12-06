package com.huawei.android.pushselfshow.richpush.tools;

import android.webkit.JavascriptInterface;
import com.huawei.android.pushagent.c.a.e;

public class Console {
    private static final String TAG = "[WebView]";

    @JavascriptInterface
    public void log(String str) {
        e.b(TAG, str);
    }

    @JavascriptInterface
    public void logV(String str) {
        e.e(TAG, str);
    }
}
