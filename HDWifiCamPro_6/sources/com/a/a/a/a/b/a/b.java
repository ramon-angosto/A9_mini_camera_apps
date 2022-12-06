package com.a.a.a.a.b.a;

import com.a.a.a.a.b.m;
import com.a.a.a.a.c.f;
import com.a.a.a.a.e.e;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.model.AdvertisementDBAdapter;
import org.json.JSONObject;

public final class b {
    private final m a;

    private b(m mVar) {
        this.a = mVar;
    }

    public static b a(com.a.a.a.a.b.b bVar) {
        m mVar = (m) bVar;
        e.a((Object) bVar, "AdSession is null");
        e.g(mVar);
        e.a(mVar);
        e.b(mVar);
        e.e(mVar);
        b bVar2 = new b(mVar);
        mVar.i().a(bVar2);
        return bVar2;
    }

    private void b(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void c(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public void a() {
        e.c(this.a);
        this.a.i().a("firstQuartile");
    }

    public void a(float f) {
        c(f);
        e.c(this.a);
        JSONObject jSONObject = new JSONObject();
        com.a.a.a.a.e.b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        com.a.a.a.a.e.b.a(jSONObject, "deviceVolume", Float.valueOf(f.a().d()));
        this.a.i().a("volumeChange", jSONObject);
    }

    public void a(float f, float f2) {
        b(f);
        c(f2);
        e.c(this.a);
        JSONObject jSONObject = new JSONObject();
        com.a.a.a.a.e.b.a(jSONObject, IronSourceConstants.EVENTS_DURATION, Float.valueOf(f));
        com.a.a.a.a.e.b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        com.a.a.a.a.e.b.a(jSONObject, "deviceVolume", Float.valueOf(f.a().d()));
        this.a.i().a("start", jSONObject);
    }

    public void a(a aVar) {
        e.a((Object) aVar, "InteractionType is null");
        e.c(this.a);
        JSONObject jSONObject = new JSONObject();
        com.a.a.a.a.e.b.a(jSONObject, "interactionType", aVar);
        this.a.i().a("adUserInteraction", jSONObject);
    }

    public void a(c cVar) {
        e.a((Object) cVar, "PlayerState is null");
        e.c(this.a);
        JSONObject jSONObject = new JSONObject();
        com.a.a.a.a.e.b.a(jSONObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, cVar);
        this.a.i().a("playerStateChange", jSONObject);
    }

    public void b() {
        e.c(this.a);
        this.a.i().a(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
    }

    public void c() {
        e.c(this.a);
        this.a.i().a("thirdQuartile");
    }

    public void d() {
        e.c(this.a);
        this.a.i().a(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
    }

    public void e() {
        e.c(this.a);
        this.a.i().a(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
    }

    public void f() {
        e.c(this.a);
        this.a.i().a(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
    }

    public void g() {
        e.c(this.a);
        this.a.i().a("bufferStart");
    }

    public void h() {
        e.c(this.a);
        this.a.i().a("bufferFinish");
    }

    public void i() {
        e.c(this.a);
        this.a.i().a("skipped");
    }
}
