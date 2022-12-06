package com.mbridge.msdk.splash.view;

import android.content.Context;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

public class MBSplashWebview extends WindVaneWebView {
    private static final String e = MBSplashWebview.class.getSimpleName();
    private String f;

    public MBSplashWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public String getRequestId() {
        return this.f;
    }

    public void setRequestId(String str) {
        this.f = str;
    }
}
