package com.bytedance.sdk.openadsdk.component.h;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.c.c;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.c.c.b.o;
import com.bytedance.sdk.openadsdk.component.g.a;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: TTAppOpenVideoManager */
public class d {
    private Context a;
    private FrameLayout b;
    private n c;
    private c d;

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    public void a(FrameLayout frameLayout, n nVar) {
        this.b = frameLayout;
        this.c = nVar;
        this.d = new c(this.a, this.b, this.c);
    }

    public boolean a() {
        String str;
        if (Build.VERSION.SDK_INT >= 23) {
            str = CacheDirFactory.getICacheDir(0).b();
        } else {
            try {
                str = a.a();
            } catch (Throwable unused) {
                str = "";
            }
        }
        c a2 = n.a(str, this.c);
        a2.b(this.c.Y());
        a2.a(this.b.getWidth());
        a2.b(this.b.getHeight());
        a2.c(this.c.ac());
        a2.a(0);
        a2.a(true);
        return this.d.a(a2);
    }

    public boolean b() {
        c cVar = this.d;
        return (cVar == null || cVar.n() == null || !this.d.n().l()) ? false : true;
    }

    public boolean c() {
        c cVar = this.d;
        return (cVar == null || cVar.n() == null || !this.d.n().m()) ? false : true;
    }

    public void a(c.a aVar) {
        c cVar = this.d;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void d() {
        try {
            if (b()) {
                this.d.b();
            }
        } catch (Throwable th) {
            l.c("TTAppOpenVideoManager", "open_ad", "AppOpenVideoManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void e() {
        c cVar = this.d;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void f() {
        c cVar = this.d;
        if (cVar != null) {
            this.a = null;
            cVar.e();
            this.d = null;
        }
    }

    public long g() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.g();
        }
        return 0;
    }

    public long h() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.h();
        }
        return 0;
    }

    public long i() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.j() + this.d.h();
        }
        return 0;
    }

    public void a(int i) {
        if (this.d != null) {
            o.a aVar = new o.a();
            aVar.a(g());
            aVar.c(i());
            aVar.b(h());
            aVar.e(i);
            aVar.f(this.d.i());
            this.d.a(aVar);
        }
    }
}
