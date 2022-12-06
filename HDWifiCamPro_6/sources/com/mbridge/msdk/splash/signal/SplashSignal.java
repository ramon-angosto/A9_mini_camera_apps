package com.mbridge.msdk.splash.signal;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashSignal extends AbsFeedBackForH5 {
    private static String d = "SplashSignal";
    private b e;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.e = (b) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            q.a(d, "initialize", th);
        }
    }

    public void init(Object obj, String str) {
        String str2 = d;
        q.d(str2, "initialize" + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(obj, str);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        String str2 = d;
        q.d(str2, "toggleCloseBtn" + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.b(obj, str);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        String str2 = d;
        q.d(str2, "triggerCloseBtn" + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.c(obj, str);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                a aVar = (a) obj;
                int optInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().a((WebView) windVaneWebView, optInt);
                    }
                }
            } catch (Throwable th) {
                q.a(d, "readyStatus", th);
            }
        }
    }

    public void install(Object obj, String str) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.d(obj, str);
        }
    }

    public void resetCountdown(Object obj, String str) {
        String str2 = d;
        q.d(str2, "resetCountdown" + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.f(obj, str);
        }
    }

    public void openURL(Object obj, String str) {
        String str2 = d;
        q.d(str2, "openURL" + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.e(obj, str);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        if (obj != null) {
            try {
                a aVar = (a) obj;
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().a(windVaneWebView, 0, str.toString(), windVaneWebView.getUrl());
                    }
                }
            } catch (Throwable th) {
                q.a(d, "handlerH5Exception", th);
            }
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                c.a(obj, new JSONObject(str));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            q.d(d, "sendImpressions");
            if (this.e != null) {
                this.e.g(obj, str);
            }
        } catch (Throwable th) {
            q.a(d, "sendImpressions", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            q.d(d, "reportUrls");
            if (this.e != null) {
                this.e.h(obj, str);
            }
        } catch (Throwable th) {
            q.a(d, "reportUrls", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            c.b(obj, new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            q.d(d, "onSignalCommunication");
            if (this.e != null) {
                this.e.i(obj, str);
            }
        } catch (Throwable th) {
            q.a(d, "onSignalCommunication", th);
        }
    }
}
