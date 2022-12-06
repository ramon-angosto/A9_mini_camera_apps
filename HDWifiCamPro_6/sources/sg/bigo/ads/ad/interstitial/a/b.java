package sg.bigo.ads.ad.interstitial.a;

import android.content.Context;
import android.view.View;
import java.util.Iterator;
import sg.bigo.ads.ad.interstitial.a.b.a;
import sg.bigo.ads.ad.interstitial.a.b.b;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.core.f.a.a;
import sg.bigo.ads.core.f.a.p;

public final class b implements sg.bigo.ads.ad.interstitial.a.b.b {
    public final boolean a;
    public Runnable b;
    public C0118b c;
    final a.C0117a d = new a.C0117a();
    public final sg.bigo.ads.ad.interstitial.a.a.b e;

    final class a implements b.a {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void a() {
            if (b.this.b != null) {
                b.this.b.run();
            }
        }

        public final void a(c cVar) {
            b.this.d.a(cVar, 6, 0);
        }

        public final void a(c cVar, long j) {
            b.this.d.a(cVar, 0, j);
        }

        public final void b() {
            if (b.this.c != null) {
                b.this.c.a();
            }
        }

        public final void b(c cVar, long j) {
            b.this.d.a(cVar, 2, j);
        }

        public final void c(c cVar, long j) {
            b.this.d.a(cVar, 1, j);
        }

        public final boolean c() {
            return false;
        }

        public final void d(c cVar, long j) {
            b.this.d.a(cVar, 5, j);
        }
    }

    /* renamed from: sg.bigo.ads.ad.interstitial.a.b$b  reason: collision with other inner class name */
    public interface C0118b {
        void a();
    }

    public b(Ad ad, g gVar, c cVar, sg.bigo.ads.core.player.c cVar2, p pVar) {
        p pVar2 = pVar;
        a.C0139a aVar = null;
        if (pVar2 != null) {
            Iterator<sg.bigo.ads.core.f.a.a> it = pVar2.z.iterator();
            while (it.hasNext() && ((r3 = it.next()) == null || (aVar = r3.a()) == null || !aVar.a())) {
            }
        }
        a.C0139a aVar2 = aVar;
        boolean r = gVar.r();
        boolean H = cVar.H();
        boolean z = true;
        boolean z2 = aVar2 != null && aVar2.a();
        if (!r || !H || !z2 || !(cVar.m() == 3 || cVar.m() == 4)) {
            z = false;
        }
        this.a = z;
        if (this.a) {
            this.e = new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, cVar2, pVar, aVar2, new a(this, (byte) 0));
        } else {
            this.e = new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, (sg.bigo.ads.core.player.c) null, (p) null, (a.C0139a) null, (b.a) null);
        }
        sg.bigo.ads.common.k.a.a(0, 3, "PlayableAdCompanion", "The ad with slot: " + gVar.k() + ", pid: " + gVar.m() + " is playable: " + this.a);
    }

    public static boolean e() {
        return e.a.j().a();
    }

    public static int f() {
        return e.a.j().b();
    }

    public final View a() {
        return this.e.n;
    }

    public final void a(int i) {
        this.e.a(i);
    }

    public final void a(Runnable runnable) {
        if (this.b == runnable) {
            this.b = null;
        }
    }

    public final boolean a(Context context) {
        if (!this.a) {
            return false;
        }
        return this.e.a(context);
    }

    public final boolean b() {
        if (!this.a) {
            return false;
        }
        return this.e.b();
    }

    public final void c() {
        this.e.c();
    }

    public final void d() {
        this.e.d();
    }
}
