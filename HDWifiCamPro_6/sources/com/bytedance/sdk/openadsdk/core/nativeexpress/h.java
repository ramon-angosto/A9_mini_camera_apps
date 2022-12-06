package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.c.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.w;
import java.util.Map;

/* compiled from: ExpressRenderEventMonitor */
public class h implements com.bytedance.sdk.component.adexpress.b.h {
    private final m a;
    /* access modifiers changed from: private */
    public final String b;
    /* access modifiers changed from: private */
    public final n c;
    /* access modifiers changed from: private */
    public final String d;
    private long e;

    public h(m mVar, String str, n nVar, String str2) {
        this.a = mVar;
        this.b = str;
        this.d = str2;
        this.c = nVar;
    }

    public void a() {
        this.a.a();
        l.b("ExpressRenderEventMonitor", "start render ");
    }

    public void a(boolean z) {
        this.a.b(z ? 1 : 0);
        l.b("ExpressRenderEventMonitor", "webview start request");
    }

    public void b() {
        l.b("ExpressRenderEventMonitor", "WebView start load");
    }

    public void c() {
        l.b("ExpressRenderEventMonitor", "webview render success");
        this.a.b();
    }

    public void a(int i) {
        this.a.a(i);
        g.a(i, this.b, this.d, this.c);
        l.b("ExpressRenderEventMonitor", "onWebViewFail() called with: errorCode = [" + i + "]");
    }

    public void b(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicStart() called with: renderType = [" + i + "]");
        this.e = System.currentTimeMillis();
        if (i == 3) {
            this.a.c("dynamic_render2_start");
        } else {
            this.a.c("dynamic_render_start");
        }
    }

    public void c(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicParseStart() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.d("dynamic_sub_analysis2_start");
        } else {
            this.a.d("dynamic_sub_analysis_start");
        }
    }

    public void d(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicParseEnd() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.d("dynamic_sub_analysis2_end");
        } else {
            this.a.d("dynamic_sub_analysis_end");
        }
    }

    public void e(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicRealRenderStart() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.d("dynamic_sub_render2_start");
        } else {
            this.a.d("dynamic_sub_render_start");
        }
    }

    public void f(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicRealRenderEnd() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.d("dynamic_sub_render2_end");
        } else {
            this.a.d("dynamic_sub_render_end");
        }
    }

    public void g(int i) {
        final String str;
        long currentTimeMillis = System.currentTimeMillis();
        l.b("ExpressRenderEventMonitor", "dynamic render success render type: " + i + "; ****cost time(ms): " + (currentTimeMillis - this.e) + "****");
        if (i == 3) {
            this.a.e("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.a.e("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.a.a(true);
        w.b(new g("dynamic_success") {
            public void run() {
                c.c(com.bytedance.sdk.openadsdk.core.m.a(), h.this.c, h.this.b, str, (Map<String, Object>) null);
            }
        });
    }

    public void a(int i, int i2, boolean z) {
        l.b("ExpressRenderEventMonitor", "onDynamicFail() called with: renderType = [" + i + "], errorCode = [" + i2 + "], hasNext = [" + z + "]");
        if (!z) {
            this.a.a(true);
        }
        if (i == 3) {
            this.a.b(i2, "dynamic_render2_error");
        } else {
            this.a.b(i2, "dynamic_render_error");
        }
        g.a(i2, this.b, this.d, this.c);
    }

    public void d() {
        l.b("ExpressRenderEventMonitor", "native render start");
        this.a.c();
    }

    public void e() {
        l.b("ExpressRenderEventMonitor", "native success");
        this.a.a(true);
        this.a.n();
        w.b(new g("native_success") {
            public void run() {
                g.a(h.this.b, h.this.d, h.this.c);
                c.c(com.bytedance.sdk.openadsdk.core.m.a(), h.this.c, h.this.b, "dynamic_backup_render", (Map<String, Object>) null);
            }
        });
    }

    public void f() {
        l.b("ExpressRenderEventMonitor", "no native render");
        this.a.o();
    }

    public void g() {
        l.b("ExpressRenderEventMonitor", "render fail");
        this.a.p();
    }

    public void h() {
        l.b("ExpressRenderEventMonitor", "render success");
        this.a.b();
    }

    public void i() {
        this.a.l();
        this.a.m();
    }
}
