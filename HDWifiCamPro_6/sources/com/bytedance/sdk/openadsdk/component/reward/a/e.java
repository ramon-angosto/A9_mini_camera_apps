package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.b.a;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.c.c.b.o;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.component.reward.d;
import com.bytedance.sdk.openadsdk.component.reward.l;
import com.bytedance.sdk.openadsdk.component.reward.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.c.b;
import com.bytedance.sdk.openadsdk.l.y;
import java.io.File;
import java.util.Map;

/* compiled from: RewardFullVideoPlayerManager */
public class e {
    long a;
    protected boolean b = false;
    boolean c = false;
    String d;
    boolean e;
    protected boolean f = false;
    c g;
    long h;
    private Activity i;
    private n j;
    private FrameLayout k;
    private String l;
    private boolean m = false;
    private f n;

    public f a() {
        return this.n;
    }

    public e(Activity activity) {
        this.i = activity;
    }

    public void a(FrameLayout frameLayout, n nVar, String str, boolean z, f fVar) {
        if (!this.m) {
            this.m = true;
            this.j = nVar;
            this.k = frameLayout;
            this.l = str;
            this.e = z;
            this.n = fVar;
            if (this.e) {
                this.g = new l(this.i, this.k, this.j, fVar);
            } else {
                this.g = new com.bytedance.sdk.openadsdk.component.reward.c(this.i, this.k, this.j, fVar);
            }
        }
    }

    public boolean b() {
        c cVar = this.g;
        return (cVar == null || cVar.n() == null || !this.g.n().l()) ? false : true;
    }

    public a c() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.o();
        }
        return null;
    }

    public boolean d() {
        c cVar = this.g;
        return (cVar == null || cVar.n() == null || !this.g.n().m()) ? false : true;
    }

    public boolean e() {
        c cVar = this.g;
        return cVar != null && cVar.r();
    }

    public void a(long j2) {
        this.h = j2;
    }

    public long f() {
        return this.h;
    }

    public boolean g() {
        return this.b;
    }

    public long h() {
        return this.a;
    }

    public void b(long j2) {
        this.a = j2;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void i() {
        try {
            if (b()) {
                this.g.b();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.d("RewardFullVideoPlayerManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void a(int i2, int i3) {
        if (this.g != null) {
            o.a aVar = new o.a();
            aVar.b(j());
            aVar.c(u());
            aVar.a(s());
            aVar.c(i2);
            aVar.d(i3);
            com.bytedance.sdk.openadsdk.c.c.a.a.d(this.g.o(), aVar);
        }
    }

    public long j() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.h();
        }
        return 0;
    }

    private void H() {
        c cVar = this.g;
        if (cVar != null && cVar.n() != null) {
            this.a = this.g.g();
            if (this.g.n().i() || !this.g.n().h()) {
                this.g.b();
                this.g.e();
                this.b = true;
            }
        }
    }

    public void k() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.e();
            this.g = null;
        }
    }

    public void l() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.c();
            this.g.f();
        }
    }

    public void m() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.f();
        }
    }

    public void n() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void o() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void a(Map<String, Object> map) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(map);
        }
    }

    public void a(c.a aVar) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void b(boolean z) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.b(z);
        }
    }

    public long p() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.j();
        }
        return 0;
    }

    public int q() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.l();
        }
        return 0;
    }

    public int r() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.i();
        }
        return 0;
    }

    public long s() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.g();
        }
        return this.a;
    }

    public void t() {
        c cVar = this.g;
        if (cVar != null && cVar.n() != null) {
            this.g.n().c();
        }
    }

    public long u() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.j() + this.g.h();
        }
        return 0;
    }

    public void a(String str, Map<String, Object> map) {
        c cVar = this.g;
        if (cVar != null) {
            Map<String, Object> a2 = y.a(this.j, cVar.h(), this.g.n());
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    a2.put(next.getKey(), next.getValue());
                }
            }
            com.bytedance.sdk.openadsdk.c.c.a((Context) this.i, this.j, this.l, str, u(), q(), a2, this.n);
            com.bytedance.sdk.component.utils.l.b("TTBaseVideoActivity", "event tag:" + this.l + ", TotalPlayDuration=" + u() + ",mBasevideoController.getPct()=" + q());
        }
        F();
    }

    public long v() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.j();
        }
        return 0;
    }

    public boolean w() {
        c cVar = this.g;
        if (cVar != null) {
            if (cVar.n() != null) {
                com.bykv.vk.openvk.component.video.api.a n2 = this.g.n();
                if (n2.m() || n2.n()) {
                    ((com.bytedance.sdk.openadsdk.core.video.c.a) this.g).I();
                    return true;
                }
            } else if (g()) {
                a(false);
                ((com.bytedance.sdk.openadsdk.core.video.c.a) this.g).I();
                return true;
            }
        }
        return false;
    }

    public boolean x() {
        return this.g != null;
    }

    public boolean y() {
        c cVar = this.g;
        return cVar != null && cVar.n() == null;
    }

    public boolean a(long j2, boolean z) {
        com.bytedance.sdk.component.utils.l.b("TTBaseVideoActivity", "playVideo start");
        if (this.g == null || this.j.J() == null) {
            com.bytedance.sdk.component.utils.l.b("TTBaseVideoActivity", "playVideo controller is Empty");
            return false;
        }
        File file = new File(CacheDirFactory.getICacheDir(this.j.aL()).a(), this.j.J().l());
        if (file.exists() && file.length() > 0) {
            this.c = true;
        }
        com.bykv.vk.openvk.component.video.api.c.c a2 = n.a(CacheDirFactory.getICacheDir(this.j.aL()).a(), this.j);
        a2.b(this.j.Y());
        a2.a(this.k.getWidth());
        a2.b(this.k.getHeight());
        a2.c(this.j.ac());
        a2.a(j2);
        a2.a(z);
        return this.g.a(a2);
    }

    public void a(String str) {
        this.d = str;
    }

    public String z() {
        return this.d;
    }

    public void c(boolean z) {
        k();
        if (!TextUtils.isEmpty(this.d)) {
            return;
        }
        if (z) {
            m.a(com.bytedance.sdk.openadsdk.core.m.a()).a();
        } else {
            d.a(com.bytedance.sdk.openadsdk.core.m.a()).b();
        }
    }

    public void A() {
        try {
            if (b()) {
                this.f = true;
                o();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.e("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public void a(boolean z, b bVar) {
        try {
            this.f = false;
            if (g()) {
                H();
                a(bVar);
            } else if (d()) {
                n();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.e("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void a(boolean z, b bVar, boolean z2) {
        if (z2 && !z && !this.f) {
            if (d()) {
                n();
                Log.i("TTBaseVideoActivity", "resumeOrRestartVideo: continue play");
                return;
            }
            H();
            a(bVar);
            Log.i("TTBaseVideoActivity", "resumeOrRestartVideo: recreate video player & exec play");
        }
    }

    public boolean B() {
        c cVar = this.g;
        if (cVar == null || cVar.n() == null) {
            return false;
        }
        return this.g.n().e();
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        if (w() && bVar != null) {
            bVar.a(h(), true);
        }
    }

    public double C() {
        if (com.bytedance.sdk.openadsdk.core.model.l.c(this.j) && this.j.a() != null) {
            return (double) this.j.a().b();
        }
        n nVar = this.j;
        if (nVar == null || nVar.J() == null) {
            return 0.0d;
        }
        return this.j.J().f();
    }

    public void D() {
        c cVar = this.g;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.video.c.a) {
            ((com.bytedance.sdk.openadsdk.core.video.c.a) cVar).H();
        }
    }

    public View E() {
        c cVar = this.g;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.video.c.a) {
            return (View) ((com.bytedance.sdk.openadsdk.core.video.c.a) cVar).J();
        }
        return null;
    }

    public void F() {
        c cVar = this.g;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.video.c.a) {
            ((com.bytedance.sdk.openadsdk.core.video.c.a) cVar).N();
        }
    }

    public void G() {
        c cVar = this.g;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.video.c.a) {
            ((com.bytedance.sdk.openadsdk.core.video.c.a) cVar).O();
        }
    }
}
