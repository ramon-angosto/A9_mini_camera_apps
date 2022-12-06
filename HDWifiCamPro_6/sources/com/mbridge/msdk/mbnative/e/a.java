package com.mbridge.msdk.mbnative.e;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbnative.controller.NativeController;
import com.mbridge.msdk.mbnative.controller.b;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;
import java.util.Map;

/* compiled from: NativeProvider */
public class a {
    private NativeController a;
    private Handler b = new Handler(Looper.getMainLooper());
    private com.mbridge.msdk.mbnative.c.a c;
    private NativeListener.NativeTrackingListener d;

    public final void a(com.mbridge.msdk.mbnative.c.a aVar) {
        this.c = aVar;
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.d = nativeTrackingListener;
    }

    public a() {
    }

    public a(com.mbridge.msdk.mbnative.c.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.c = aVar;
        this.d = nativeTrackingListener;
    }

    public final void a(Context context, Resources resources, Map<String, Object> map) {
        this.a = new NativeController(this.c, this.d, map, context);
    }

    public final void a() {
        a(0, "");
    }

    public final void a(String str) {
        a(0, str);
    }

    public final void b() {
        a(1, "");
    }

    public final void c() {
        try {
            NativeController nativeController = this.a;
            o.a();
        } catch (Exception unused) {
            q.d("NativeProvider", "clear cache failed");
        }
    }

    public final void d() {
        try {
            this.a.a();
        } catch (Exception unused) {
            q.d("NativeProvider", "release failed");
        }
    }

    public final void a(View view, List<View> list, Campaign campaign) {
        NativeController nativeController = this.a;
        if (nativeController != null) {
            nativeController.a(campaign, view, list);
        }
    }

    public final void a(View view, Campaign campaign) {
        q.b("NativeProvider", "native provider registerView");
        NativeController nativeController = this.a;
        if (nativeController != null) {
            nativeController.a(campaign, view);
        }
    }

    public final void b(View view, Campaign campaign) {
        q.b("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.a;
        if (nativeController != null) {
            nativeController.b(campaign, view);
        }
    }

    public final void b(View view, List<View> list, Campaign campaign) {
        q.b("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.a;
        if (nativeController != null) {
            nativeController.b(campaign, view, list);
        }
    }

    public static void preload(Map<String, Object> map, int i) {
        q.b("NativeProvider", "native provider preload");
        new b().a(map, i);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.c.onAdLoadError("current request is loading");
        this.c.b();
    }

    private void a(int i, String str) {
        if (this.a != null) {
            com.mbridge.msdk.mbnative.c.a aVar = this.c;
            if (aVar == null || !aVar.a()) {
                com.mbridge.msdk.mbnative.c.a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.b();
                }
                this.a.a(i, str);
            } else if (u.b()) {
                f();
            } else {
                this.b.post(new Runnable() {
                    public final void run() {
                        a.this.f();
                    }
                });
            }
        }
    }

    public final String e() {
        NativeController nativeController = this.a;
        return nativeController != null ? nativeController.b() : "";
    }
}
