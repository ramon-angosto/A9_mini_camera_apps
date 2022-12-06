package com.bytedance.sdk.openadsdk.i;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.openadsdk.core.g;

/* compiled from: StatsImageListener */
public class b implements o<Bitmap> {
    private boolean a;
    private com.bytedance.sdk.openadsdk.h.a.b b;

    public void a(String str) {
        com.bytedance.sdk.openadsdk.h.a.b bVar;
        if (this.a && (bVar = this.b) != null) {
            bVar.c(str);
        }
    }

    public void a(int i) {
        com.bytedance.sdk.openadsdk.h.a.b bVar;
        if (this.a && (bVar = this.b) != null) {
            bVar.a(i);
        }
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.h.a.b bVar;
        if (this.a && (bVar = this.b) != null) {
            bVar.e(str);
        }
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.h.a.b bVar;
        if (this.a && (bVar = this.b) != null) {
            bVar.d(str);
        }
    }

    public void d(String str) {
        com.bytedance.sdk.openadsdk.h.a.b bVar;
        if (this.a && (bVar = this.b) != null) {
            bVar.g(str);
        }
    }

    public b(boolean z) {
        this.a = z;
        if (this.a) {
            this.b = com.bytedance.sdk.openadsdk.h.a.b.b();
        }
    }

    public void a(k<Bitmap> kVar) {
        if (this.a && this.b != null) {
            if (kVar == null || kVar.b() == null) {
                this.b.b(202).f(g.a(202));
                com.bytedance.sdk.openadsdk.h.b.a().e(this.b);
            }
        }
    }

    public void a(int i, String str, Throwable th) {
        com.bytedance.sdk.openadsdk.h.a.b bVar;
        if (this.a && (bVar = this.b) != null) {
            bVar.b(201).f(g.a(201));
            com.bytedance.sdk.openadsdk.h.b.a().e(this.b);
        }
    }
}
