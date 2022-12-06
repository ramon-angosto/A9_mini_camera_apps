package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import com.mbridge.msdk.mbsignalcommon.base.e;
import java.util.HashMap;

/* compiled from: WindVaneApiManager */
public final class f {
    private static HashMap<String, Class> a = new HashMap<>();
    private Context b;
    private Object c;
    private WindVaneWebView d;

    public f(Context context, WindVaneWebView windVaneWebView) {
        this.b = context;
        this.d = windVaneWebView;
        try {
            a(e.a, Class.forName("com.mbridge.msdk.interstitial.signalcommon.interstitial"));
        } catch (ClassNotFoundException unused) {
        }
        try {
            a(e.b, Class.forName("com.mbridge.msdk.video.signal.communication.RewardSignal"));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            a(e.c, Class.forName("com.mbridge.msdk.video.signal.communication.VideoCommunication"));
        } catch (ClassNotFoundException unused3) {
        }
        try {
            a(e.d, Class.forName("com.mbridge.msdk.interactiveads.signalcommon.Interactive"));
        } catch (ClassNotFoundException unused4) {
        }
        try {
            a(e.e, Class.forName("com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication"));
        } catch (ClassNotFoundException unused5) {
        }
        try {
            a(e.f, Class.forName("com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin"));
        } catch (ClassNotFoundException unused6) {
        }
        try {
            a(e.g, Class.forName("com.mbridge.msdk.splash.signal.SplashSignal"));
        } catch (ClassNotFoundException unused7) {
        }
        try {
            a(e.h, Class.forName("com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal"));
        } catch (ClassNotFoundException unused8) {
        }
    }

    public final void a(Context context) {
        this.b = context;
    }

    public final void a(Object obj) {
        this.c = obj;
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!h.class.isAssignableFrom(cls)) {
                return null;
            }
            h hVar = (h) cls.newInstance();
            hVar.initialize(context, windVaneWebView);
            hVar.initialize(this.c, windVaneWebView);
            return hVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void a(String str, Class cls) {
        if (a == null) {
            a = new HashMap<>();
        }
        a.put(str, cls);
    }

    public final Object a(String str) {
        if (a == null) {
            a = new HashMap<>();
        }
        return a(str, this.d, this.b);
    }
}
