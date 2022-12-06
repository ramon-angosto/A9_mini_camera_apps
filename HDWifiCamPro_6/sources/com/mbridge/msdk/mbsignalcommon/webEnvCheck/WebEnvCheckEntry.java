package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import com.mbridge.msdk.b.b.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

public class WebEnvCheckEntry {
    public void check(Context context) {
        WindVaneWebView windVaneWebView = new WindVaneWebView(context);
        windVaneWebView.loadDataWithBaseURL((String) null, "<html><script>" + b.a().b() + "</script></html>", "text/html", "utf-8", (String) null);
    }
}
