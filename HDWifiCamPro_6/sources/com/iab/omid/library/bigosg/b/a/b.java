package com.iab.omid.library.bigosg.b.a;

import com.iab.omid.library.bigosg.b.l;
import com.iab.omid.library.bigosg.e.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public final class b {
    public final l a;

    public b(l lVar) {
        this.a = lVar;
    }

    public static void a(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public final void a() {
        d.b(this.a);
        this.a.c.a("firstQuartile");
    }

    public final void b() {
        d.b(this.a);
        this.a.c.a(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
    }

    public final void c() {
        d.b(this.a);
        this.a.c.a("thirdQuartile");
    }

    public final void d() {
        d.b(this.a);
        this.a.c.a(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
    }

    public final void e() {
        d.b(this.a);
        this.a.c.a(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
    }

    public final void f() {
        d.b(this.a);
        this.a.c.a(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
    }

    public final void g() {
        d.b(this.a);
        this.a.c.a("bufferStart");
    }

    public final void h() {
        d.b(this.a);
        this.a.c.a("bufferFinish");
    }

    public final void i() {
        d.b(this.a);
        this.a.c.a("skipped");
    }
}
