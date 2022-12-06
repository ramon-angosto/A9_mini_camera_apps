package com.mbridge.msdk.mbbanner.common.b;

import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;

/* compiled from: ProxyBannerShowListener */
public class g implements c {
    private static final String a = g.class.getSimpleName();
    private c b;
    private d c;

    public g(c cVar, d dVar) {
        this.c = dVar;
        this.b = cVar;
    }

    public final void a(List<CampaignEx> list) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(list);
        }
    }

    public final void a(String str) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public final void a() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void b() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void c() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.c();
        }
    }

    public final void d() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void a(CampaignEx campaignEx) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(campaignEx);
        }
    }

    public final void e() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.e();
        }
    }
}
