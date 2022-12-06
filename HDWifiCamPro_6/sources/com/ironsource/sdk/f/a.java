package com.ironsource.sdk.f;

import com.ironsource.mediationsdk.model.c;
import com.ironsource.mediationsdk.model.d;
import com.ironsource.mediationsdk.model.p;
import com.ironsource.mediationsdk.utils.b;
import com.ironsource.mediationsdk.utils.j;
import com.ironsource.sdk.controller.u;
import com.ironsource.sdk.g.d;

public class a {
    private d a;
    private p b;
    private com.ironsource.mediationsdk.utils.p c;
    private boolean d;
    private u e;
    private b f;
    private c g;
    private j h;
    private com.ironsource.mediationsdk.model.b i;

    /* renamed from: com.ironsource.sdk.f.a$a  reason: collision with other inner class name */
    public static class C0095a {
        public String a;
        public String b;
        public String c;

        public static C0095a a(d.e eVar) {
            String str;
            C0095a aVar = new C0095a();
            if (eVar == d.e.RewardedVideo) {
                aVar.a = "showRewardedVideo";
                aVar.b = "onShowRewardedVideoSuccess";
                str = "onShowRewardedVideoFail";
            } else if (eVar == d.e.Interstitial) {
                aVar.a = "showInterstitial";
                aVar.b = "onShowInterstitialSuccess";
                str = "onShowInterstitialFail";
            } else {
                if (eVar == d.e.OfferWall) {
                    aVar.a = "showOfferWall";
                    aVar.b = "onShowOfferWallSuccess";
                    str = "onInitOfferWallFail";
                }
                return aVar;
            }
            aVar.c = str;
            return aVar;
        }
    }

    public a() {
        this.a = new com.ironsource.mediationsdk.model.d();
    }

    public a(com.ironsource.mediationsdk.model.d dVar, p pVar, com.ironsource.mediationsdk.utils.p pVar2, boolean z, u uVar, b bVar, c cVar, j jVar, com.ironsource.mediationsdk.model.b bVar2) {
        this.a = dVar;
        this.b = pVar;
        this.c = pVar2;
        this.d = z;
        this.e = uVar;
        this.f = bVar;
        this.g = cVar;
        this.h = jVar;
        this.i = bVar2;
    }

    public com.ironsource.mediationsdk.model.d a() {
        return this.a;
    }

    public p b() {
        return this.b;
    }

    public com.ironsource.mediationsdk.utils.p c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public u e() {
        return this.e;
    }

    public b f() {
        return this.f;
    }

    public c g() {
        return this.g;
    }

    public j h() {
        return this.h;
    }

    public com.ironsource.mediationsdk.model.b i() {
        return this.i;
    }
}
