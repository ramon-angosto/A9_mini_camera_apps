package sg.bigo.ads.ad.interstitial.a;

import android.content.Context;
import android.view.View;
import java.util.Iterator;
import sg.bigo.ads.ad.interstitial.a.b.a;
import sg.bigo.ads.ad.interstitial.a.b.b;
import sg.bigo.ads.ad.interstitial.a.b.c;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.core.f.a.a;
import sg.bigo.ads.core.f.a.p;

public final class a implements sg.bigo.ads.ad.interstitial.a.b.b, c {
    public boolean a;
    public sg.bigo.ads.ad.interstitial.a.b.a b;
    final a.C0117a c = new a.C0117a();

    /* renamed from: sg.bigo.ads.ad.interstitial.a.a$a  reason: collision with other inner class name */
    final class C0115a implements b.a {
        private C0115a() {
        }

        /* synthetic */ C0115a(a aVar, byte b) {
            this();
        }

        public final void a() {
        }

        public final void a(sg.bigo.ads.api.core.c cVar) {
            a.this.c.a(cVar, 6, 0);
        }

        public final void a(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 0, j);
        }

        public final void b() {
        }

        public final void b(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 2, j);
        }

        public final void c(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 1, j);
        }

        public final boolean c() {
            return true;
        }

        public final void d(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 5, j);
        }
    }

    final class b implements c.b {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        public final void a(sg.bigo.ads.api.core.c cVar) {
            a.this.c.a(cVar, 6, 0);
        }

        public final void a(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 5, j);
        }

        public final void a(sg.bigo.ads.api.core.c cVar, long j, String str, int i, String str2) {
            a.this.c.a(cVar, 3, j, str, i, str2, (String) null);
        }

        public final void a(sg.bigo.ads.api.core.c cVar, long j, String str, int i, String str2, String str3) {
            a.this.c.a(cVar, 4, j, str, i, str2, str3);
        }
    }

    public a(boolean z, Ad ad, g gVar, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.core.player.c cVar2, p pVar) {
        a.C0139a aVar;
        String str;
        p pVar2 = pVar;
        if (!gVar.s()) {
            str = "render companion disable due to slot switch off";
        } else if (z) {
            str = "render companion disable due to playable";
        } else if (cVar.m() == 3 || cVar.m() == 4) {
            a.C0139a aVar2 = null;
            if (pVar2 != null) {
                Iterator<sg.bigo.ads.core.f.a.a> it = pVar2.z.iterator();
                a.C0139a aVar3 = null;
                while (it.hasNext() && ((r4 = it.next()) == null || (((aVar2 = sg.bigo.ads.core.f.a.a.a(r4.b)) == null || !aVar2.a()) && ((aVar3 = r4.a()) == null || !aVar3.a())))) {
                }
                aVar = aVar3;
            } else {
                aVar = null;
            }
            if (aVar2 != null && aVar2.a()) {
                sg.bigo.ads.common.k.a.a(0, 3, "EndPageVastCompanion", "render companion init with image.");
                this.b = new sg.bigo.ads.ad.interstitial.a.a.c(ad, cVar, cVar2, pVar, new b(this, (byte) 0));
            }
            if (this.b == null && aVar != null && aVar.a()) {
                sg.bigo.ads.common.k.a.a(0, 3, "EndPageVastCompanion", "render companion init with html.");
                this.b = new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, cVar2, pVar, aVar, new C0115a(this, (byte) 0));
            }
            this.a = this.b != null;
            str = "The ad with slot: " + gVar.k() + ", pid: " + gVar.m() + " isRenderable: " + this.a;
        } else {
            str = "render companion disable due to invalid type";
        }
        sg.bigo.ads.common.k.a.a(0, 3, "EndPageVastCompanion", str);
    }

    public final View a() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar;
        if (this.a && (aVar = this.b) != null) {
            return aVar.a();
        }
        return null;
    }

    public final void a(int i) {
        sg.bigo.ads.ad.interstitial.a.b.a aVar;
        if (this.a && (aVar = this.b) != null) {
            aVar.a(i);
        }
    }

    public final boolean a(Context context) {
        sg.bigo.ads.common.k.a.a(0, 3, "EndPageVastCompanion", "tyr to start preload end page resource.");
        if (!this.a) {
            sg.bigo.ads.common.k.a.a(0, 3, "EndPageVastCompanion", "end page resource is unavailable.");
            return false;
        }
        sg.bigo.ads.ad.interstitial.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.a(context);
        }
        return false;
    }

    public final boolean b() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar;
        if (this.a && (aVar = this.b) != null) {
            return aVar.b();
        }
        return false;
    }

    public final void c() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void d() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }
}
