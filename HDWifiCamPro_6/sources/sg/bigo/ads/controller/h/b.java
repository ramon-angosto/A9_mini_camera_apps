package sg.bigo.ads.controller.h;

import java.util.Map;
import sg.bigo.ads.api.a.d;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.api.b;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.controller.c;
import sg.bigo.ads.controller.e.f;
import sg.bigo.ads.controller.h.a;

public final class b extends a {
    public final sg.bigo.ads.api.b g;
    public final g h;
    private final d i;
    private final c<sg.bigo.ads.api.core.c> j;

    public b(d dVar, e eVar, sg.bigo.ads.api.b bVar, g gVar, c<sg.bigo.ads.api.core.c> cVar) {
        super(eVar, ((long) gVar.c()) * 1000);
        this.i = dVar;
        this.g = bVar;
        this.h = gVar;
        this.j = cVar;
        sg.bigo.ads.api.b bVar2 = this.g;
        String str = this.d;
        String str2 = this.e;
        String str3 = this.f;
        if (bVar2.c != null) {
            b.a aVar = bVar2.c;
            aVar.b = str;
            aVar.c = str2;
            aVar.d = str3;
        }
    }

    /* access modifiers changed from: protected */
    public final StringBuilder a(long j2, String str) {
        StringBuilder a = super.a(j2, str);
        a.append(",");
        a.append(o.a(this.h.k()));
        a.append(",");
        a.append(o.a(this.h.m()));
        return a;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, int i3, String str) {
        c<sg.bigo.ads.api.core.c> cVar = this.j;
        if (cVar != null) {
            cVar.a(a(), i2, i3, str, this.h);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, Map<String, Object> map) {
        if (this.j != null) {
            long j2 = 0;
            Object obj = map.get("logid");
            if (obj instanceof Long) {
                j2 = ((Long) obj).longValue();
            }
            sg.bigo.ads.controller.c.b a = sg.bigo.ads.controller.c.b.a(j2, this.g.c, this.h, str);
            if (a != null) {
                this.j.a(a(), a);
            } else {
                a(1005, 0, "Invalid ad data.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(a.C0132a aVar) {
        aVar.a("slot", o.a(this.h.k()));
        aVar.a("placement_id", o.a(this.h.m()));
        aVar.a("strategy_id", this.h.a());
        aVar.a("support_adx_types", sg.bigo.ads.api.core.b.a(this.g.b()));
        aVar.a("lat_enable", Integer.valueOf(this.b.y() ? 1 : 0));
        aVar.a("hw_lat_enable", Integer.valueOf(this.b.F() ? 1 : 0));
        aVar.a("token", this.i.f());
        aVar.a("slot_abflags", this.h.n());
        aVar.a("global_abflags", this.i.d());
        aVar.a("support_playable_ad", Integer.valueOf(this.h.q()));
        if (f.a().a) {
            f a = f.a();
            aVar.a("algo_info", a.e.a(o.a(this.h.k())));
        }
        aVar.a("auc_mode", Integer.valueOf(this.h.u()));
        if (sg.bigo.ads.api.core.b.c(this.h.b())) {
            aVar.a("orientation", Integer.valueOf(this.h.p().a("splash_orientation")));
        }
        Map<String, Object> c = this.g.c();
        if (c != null) {
            for (Map.Entry next : c.entrySet()) {
                aVar.a((String) next.getKey(), next.getValue());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String c() {
        return sg.bigo.ads.b.c();
    }
}
