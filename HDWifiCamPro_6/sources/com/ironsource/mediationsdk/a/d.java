package com.ironsource.mediationsdk.a;

import com.ironsource.mediationsdk.a.b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.o;

public final class d extends b {
    private static d w;
    private String x = "";

    private d() {
        this.r = "ironbeast";
        this.q = 2;
        this.s = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
    }

    public static synchronized d e() {
        d dVar;
        synchronized (d.class) {
            if (w == null) {
                d dVar2 = new d();
                w = dVar2;
                dVar2.a();
            }
            dVar = w;
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.t.add(2001);
        this.t.add(2002);
        this.t.add(2003);
        this.t.add(2004);
        this.t.add(Integer.valueOf(IronSourceConstants.IS_INSTANCE_LOAD_FAILED));
        this.t.add(Integer.valueOf(IronSourceConstants.IS_INSTANCE_LOAD_NO_FILL));
        this.t.add(Integer.valueOf(IronSourceConstants.IS_INSTANCE_READY_TRUE));
        this.t.add(Integer.valueOf(IronSourceConstants.IS_INSTANCE_READY_FALSE));
        this.t.add(3001);
        this.t.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_LOAD_ERROR));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_RELOAD));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_RELOAD_FAILED));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_LOAD));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_LOAD_SUCCESS));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_LOAD_ERROR));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD_ERROR));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS));
        this.t.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_SHOW));
    }

    /* access modifiers changed from: protected */
    public final boolean c(c cVar) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final String d(int i) {
        return this.x;
    }

    /* access modifiers changed from: protected */
    public final boolean d(c cVar) {
        int a = cVar.a();
        return a == 2204 || a == 2004 || a == 2005 || a == 2301 || a == 2300 || a == 3009;
    }

    /* access modifiers changed from: protected */
    public final int e(c cVar) {
        return o.a().b(e(cVar.a()) == b.a.BANNER.f ? 3 : 2);
    }
}
