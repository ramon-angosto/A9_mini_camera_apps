package com.a.a.a.a.g;

import android.webkit.WebView;
import com.a.a.a.a.b.c;
import com.a.a.a.a.b.d;
import com.a.a.a.a.b.l;
import com.a.a.a.a.b.m;
import com.a.a.a.a.c.e;
import com.a.a.a.a.f.b;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    private b a = new b((WebView) null);
    private com.a.a.a.a.b.a b;
    private com.a.a.a.a.b.a.b c;
    private C0001a d;
    private long e;

    /* renamed from: com.a.a.a.a.g.a$a  reason: collision with other inner class name */
    enum C0001a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public a() {
        j();
    }

    public void a() {
    }

    public void a(float f) {
        e.a().a(c(), f);
    }

    /* access modifiers changed from: package-private */
    public void a(WebView webView) {
        this.a = new b(webView);
    }

    public void a(com.a.a.a.a.b.a.b bVar) {
        this.c = bVar;
    }

    public void a(com.a.a.a.a.b.a aVar) {
        this.b = aVar;
    }

    public void a(c cVar) {
        e.a().a(c(), cVar.c());
    }

    public void a(m mVar, d dVar) {
        a(mVar, dVar, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public void a(m mVar, d dVar, JSONObject jSONObject) {
        String c2 = mVar.c();
        JSONObject jSONObject2 = new JSONObject();
        com.a.a.a.a.e.b.a(jSONObject2, "environment", "app");
        com.a.a.a.a.e.b.a(jSONObject2, "adSessionType", dVar.h());
        com.a.a.a.a.e.b.a(jSONObject2, "deviceInfo", com.a.a.a.a.e.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        com.a.a.a.a.e.b.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        com.a.a.a.a.e.b.a(jSONObject3, "partnerName", dVar.a().a());
        com.a.a.a.a.e.b.a(jSONObject3, "partnerVersion", dVar.a().b());
        com.a.a.a.a.e.b.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        com.a.a.a.a.e.b.a(jSONObject4, "libraryVersion", "1.3.26-Bytedance2");
        com.a.a.a.a.e.b.a(jSONObject4, "appId", com.a.a.a.a.c.d.a().b().getApplicationContext().getPackageName());
        com.a.a.a.a.e.b.a(jSONObject2, "app", jSONObject4);
        if (dVar.e() != null) {
            com.a.a.a.a.e.b.a(jSONObject2, "contentUrl", dVar.e());
        }
        if (dVar.f() != null) {
            com.a.a.a.a.e.b.a(jSONObject2, "customReferenceData", dVar.f());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (l next : dVar.b()) {
            com.a.a.a.a.e.b.a(jSONObject5, next.a(), next.c());
        }
        e.a().a(c(), c2, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(String str) {
        e.a().a(c(), str, (JSONObject) null);
    }

    public void a(String str, long j) {
        if (j >= this.e) {
            this.d = C0001a.AD_STATE_VISIBLE;
            e.a().b(c(), str);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        e.a().a(c(), str, jSONObject);
    }

    public void a(JSONObject jSONObject) {
        e.a().b(c(), jSONObject);
    }

    public void a(boolean z) {
        if (f()) {
            e.a().c(c(), z ? "foregrounded" : "backgrounded");
        }
    }

    public void b() {
        this.a.clear();
    }

    public void b(String str, long j) {
        if (j >= this.e && this.d != C0001a.AD_STATE_NOTVISIBLE) {
            this.d = C0001a.AD_STATE_NOTVISIBLE;
            e.a().b(c(), str);
        }
    }

    public WebView c() {
        return (WebView) this.a.get();
    }

    public com.a.a.a.a.b.a d() {
        return this.b;
    }

    public com.a.a.a.a.b.a.b e() {
        return this.c;
    }

    public boolean f() {
        return this.a.get() != null;
    }

    public void g() {
        e.a().a(c());
    }

    public void h() {
        e.a().b(c());
    }

    public void i() {
        e.a().c(c());
    }

    public void j() {
        this.e = com.a.a.a.a.e.d.a();
        this.d = C0001a.AD_STATE_IDLE;
    }
}
