package com.bytedance.sdk.component.adexpress.b;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.b.i;
import com.bytedance.sdk.component.adexpress.dynamic.a.a;
import com.bytedance.sdk.component.adexpress.dynamic.c;
import com.bytedance.sdk.component.adexpress.dynamic.c.f;
import com.bytedance.sdk.component.adexpress.dynamic.c.g;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* compiled from: DynamicRenderInterceptor */
public class b implements i {
    private Context a;
    /* access modifiers changed from: private */
    public a b;
    private ThemeStatusBroadcastReceiver c;
    private g d;
    /* access modifiers changed from: private */
    public l e;
    /* access modifiers changed from: private */
    public int f;

    public void b() {
    }

    public void c() {
    }

    public b(Context context, l lVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, g gVar, g gVar2, com.bytedance.sdk.component.adexpress.dynamic.d.a aVar) {
        this.a = context;
        this.e = lVar;
        this.c = themeStatusBroadcastReceiver;
        this.d = gVar2;
        this.b = new a(this.a, this.c, z, gVar, this.e, aVar);
        this.b.a(this.d);
        if (gVar instanceof f) {
            this.f = 3;
        } else {
            this.f = 2;
        }
    }

    public boolean a(final i.a aVar) {
        this.e.c().b(this.f);
        this.b.a((f) new f() {
            public void a(View view, m mVar) {
                if (!aVar.c()) {
                    b.this.e.c().f(b.this.f);
                    b.this.e.c().g(b.this.f);
                    b.this.e.c().h();
                    n b2 = aVar.b();
                    if (b2 != null) {
                        b2.a(b.this.b, mVar);
                        aVar.a(true);
                    }
                }
            }

            public void a(int i) {
                b.this.e.c().a(b.this.f, i, aVar.b(b.this));
                if (aVar.b(b.this)) {
                    aVar.a((i) b.this);
                    return;
                }
                n b2 = aVar.b();
                if (b2 != null) {
                    b2.a_(i);
                }
            }
        });
        return true;
    }

    public void a() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public c d() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }
}
