package com.ironsource.mediationsdk.a;

import com.ironsource.mediationsdk.a.b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.o;

public final class h extends b {
    private static h w;
    private String x = "";

    private h() {
        this.r = "outcome";
        this.q = 3;
        this.s = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
    }

    public static synchronized h e() {
        h hVar;
        synchronized (h.class) {
            if (w == null) {
                h hVar2 = new h();
                w = hVar2;
                hVar2.a();
            }
            hVar = w;
        }
        return hVar;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.t.add(1000);
        this.t.add(1001);
        this.t.add(1002);
        this.t.add(1003);
        this.t.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_LOAD_FAILED));
        this.t.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.t.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_READY_TRUE));
        this.t.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_READY_FALSE));
        this.t.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.t.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL));
        this.t.add(Integer.valueOf(IronSourceConstants.RV_MEDIATION_LOAD_ERROR));
    }

    /* access modifiers changed from: protected */
    public final boolean c(c cVar) {
        return cVar.a() == 305;
    }

    /* access modifiers changed from: protected */
    public final String d(int i) {
        return (i == 15 || (i >= 300 && i < 400)) ? this.x : "";
    }

    /* access modifiers changed from: protected */
    public final boolean d(c cVar) {
        int a = cVar.a();
        return a == 14 || a == 514 || a == 305 || a == 1003 || a == 1005 || a == 1203 || a == 1010 || a == 1301 || a == 1302;
    }

    /* access modifiers changed from: protected */
    public final int e(c cVar) {
        return o.a().b((e(cVar.a()) == b.a.OFFERWALL.f ? 1 : 0) ^ 1);
    }
}
