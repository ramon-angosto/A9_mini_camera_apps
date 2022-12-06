package com.vungle.warren.ui;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class JavascriptBridge {
    private MraidHandler handler;

    public interface MraidHandler {
        public static final String CLOSE_ACTION = "close";
        public static final String DOWNLOAD_ACTION = "download";
        public static final String PRIVACY_ACTION = "privacy";

        void onMraidAction(String str);
    }

    public JavascriptBridge(MraidHandler mraidHandler) {
        this.handler = mraidHandler;
    }

    @JavascriptInterface
    public void performAction(String str) {
        Log.d("JavascriptBridge", "actionClicked(" + str + ")");
        this.handler.onMraidAction(str);
    }
}
