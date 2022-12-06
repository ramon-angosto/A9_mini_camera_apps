package com.bytedance.sdk.component.adexpress.dynamic.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.f;
import com.bytedance.sdk.component.adexpress.b.j;
import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.c;
import com.bytedance.sdk.component.adexpress.dynamic.c.g;
import com.bytedance.sdk.component.adexpress.dynamic.d.b;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.utils.h;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DynamicRender */
public class a implements d<DynamicRootView>, j {
    /* access modifiers changed from: private */
    public DynamicRootView a;
    /* access modifiers changed from: private */
    public g b;
    private Context c;
    private f d;
    private com.bytedance.sdk.component.adexpress.b.g e;
    /* access modifiers changed from: private */
    public l f;
    private ScheduledFuture<?> g;
    private AtomicBoolean h = new AtomicBoolean(false);

    public a(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, g gVar, l lVar, com.bytedance.sdk.component.adexpress.dynamic.d.a aVar) {
        this.c = context;
        this.a = new DynamicRootView(context, themeStatusBroadcastReceiver, z, lVar, aVar);
        this.b = gVar;
        this.f = lVar;
        this.a.setRenderListener(this);
        this.f = lVar;
    }

    public void a(f fVar) {
        this.d = fVar;
        int d2 = this.f.d();
        if (d2 < 0) {
            this.a.a(this.b instanceof com.bytedance.sdk.component.adexpress.dynamic.c.f ? 127 : 117);
            return;
        }
        this.g = e.d().schedule(new C0026a(2), (long) d2, TimeUnit.MILLISECONDS);
        h.b().postDelayed(new Runnable() {
            public void run() {
                a.this.f();
            }
        }, this.f.f());
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f.c().c(c());
        if (!com.bytedance.sdk.component.adexpress.a.b.a.a(this.f.a())) {
            this.a.a(this.b instanceof com.bytedance.sdk.component.adexpress.dynamic.c.f ? 123 : 113);
            return;
        }
        this.b.a((b) new b() {
            public void a(final com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
                a.this.h();
                a.this.f.c().d(a.this.c());
                a.this.a(hVar);
                a.this.b(hVar);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        a.this.c(hVar);
                    }
                });
                if (a.this.a != null && hVar != null) {
                    a.this.a.setBgColor(hVar.a());
                }
            }
        });
        this.b.a(this.f);
    }

    /* access modifiers changed from: private */
    public void a(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.b.h> j;
        if (hVar != null && (j = hVar.j()) != null && j.size() > 0) {
            Collections.sort(j, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.b.h>() {
                /* renamed from: a */
                public int compare(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar2) {
                    com.bytedance.sdk.component.adexpress.dynamic.b.f e = hVar.i().e();
                    com.bytedance.sdk.component.adexpress.dynamic.b.f e2 = hVar2.i().e();
                    if (e == null || e2 == null) {
                        return 0;
                    }
                    return e.ac() >= e2.ac() ? 1 : -1;
                }
            });
            for (com.bytedance.sdk.component.adexpress.dynamic.b.h next : j) {
                if (next != null) {
                    a(next);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        if (hVar != null) {
            List<com.bytedance.sdk.component.adexpress.dynamic.b.h> j = hVar.j();
            if (j != null && j.size() > 0) {
                for (com.bytedance.sdk.component.adexpress.dynamic.b.h b2 : j) {
                    b(b2);
                }
            }
            com.bytedance.sdk.component.adexpress.dynamic.b.h k = hVar.k();
            if (k != null) {
                hVar.c(hVar.e() - k.e());
                hVar.d(hVar.f() - k.f());
            }
        }
    }

    /* renamed from: a */
    public DynamicRootView e() {
        return d();
    }

    public void b() {
        a((View) e());
    }

    private void a(View view) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    }
                    a(viewGroup.getChildAt(i));
                    i++;
                }
            }
            if (view instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d) {
                ((com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d) view).b();
            }
        }
    }

    public int c() {
        return this.b instanceof com.bytedance.sdk.component.adexpress.dynamic.c.f ? 3 : 2;
    }

    /* access modifiers changed from: private */
    public void c(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        if (hVar == null) {
            this.a.a(this.b instanceof com.bytedance.sdk.component.adexpress.dynamic.c.f ? 123 : 113);
            return;
        }
        this.f.c().e(c());
        try {
            this.a.a(hVar, c());
        } catch (Exception unused) {
            this.a.a(this.b instanceof com.bytedance.sdk.component.adexpress.dynamic.c.f ? 128 : 118);
        }
    }

    public DynamicRootView d() {
        return this.a;
    }

    public void a(com.bytedance.sdk.component.adexpress.b.g gVar) {
        this.e = gVar;
    }

    private boolean g() {
        DynamicRootView dynamicRootView = this.a;
        if (dynamicRootView == null || dynamicRootView.getChildCount() == 0) {
            return false;
        }
        return true;
    }

    public void a(m mVar) {
        if (!this.h.get()) {
            this.h.set(true);
            if (!mVar.a() || !g()) {
                this.d.a(mVar.h());
                return;
            }
            this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.d.a(e(), mVar);
        }
    }

    public void a(View view, int i, c cVar) {
        com.bytedance.sdk.component.adexpress.b.g gVar = this.e;
        if (gVar != null) {
            gVar.a(view, i, cVar);
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.a.a$a  reason: collision with other inner class name */
    /* compiled from: DynamicRender */
    private class C0026a implements Runnable {
        private int b;

        public C0026a(int i) {
            this.b = i;
        }

        public void run() {
            if (this.b == 2) {
                com.bytedance.sdk.component.utils.l.b("DynamicRender", "Dynamic parse time out");
                a.this.a.a(a.this.b instanceof com.bytedance.sdk.component.adexpress.dynamic.c.f ? 127 : 117);
            }
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        try {
            if (this.g != null && !this.g.isCancelled()) {
                this.g.cancel(false);
                this.g = null;
            }
            com.bytedance.sdk.component.utils.l.b("DynamicRender", "WebView Render cancel timeout timer");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
