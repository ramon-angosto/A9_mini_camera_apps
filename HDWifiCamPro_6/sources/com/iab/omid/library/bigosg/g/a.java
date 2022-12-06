package com.iab.omid.library.bigosg.g;

import android.webkit.WebView;
import com.iab.omid.library.bigosg.b.d;
import com.iab.omid.library.bigosg.b.l;
import com.iab.omid.library.bigosg.c.e;
import com.iab.omid.library.bigosg.f.b;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    public b a = new b((WebView) null);
    public com.iab.omid.library.bigosg.b.a b;
    public com.iab.omid.library.bigosg.b.a.b c;
    public int d;
    public long e;

    /* renamed from: com.iab.omid.library.bigosg.g.a$a  reason: collision with other inner class name */
    public enum C0077a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        static {
            d = new int[]{a, b, c};
        }
    }

    public a() {
        d();
    }

    public void a() {
    }

    public final void a(float f) {
        e.a().a(c(), f);
    }

    /* access modifiers changed from: package-private */
    public final void a(WebView webView) {
        this.a = new b(webView);
    }

    public void a(l lVar, d dVar) {
        a(lVar, dVar, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public final void a(l lVar, d dVar, JSONObject jSONObject) {
        String str = lVar.f;
        JSONObject jSONObject2 = new JSONObject();
        com.iab.omid.library.bigosg.e.b.a(jSONObject2, "environment", "app");
        com.iab.omid.library.bigosg.e.b.a(jSONObject2, "adSessionType", dVar.h);
        com.iab.omid.library.bigosg.e.b.a(jSONObject2, "deviceInfo", com.iab.omid.library.bigosg.e.a.a());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        com.iab.omid.library.bigosg.e.b.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        com.iab.omid.library.bigosg.e.b.a(jSONObject3, "partnerName", dVar.a.a);
        com.iab.omid.library.bigosg.e.b.a(jSONObject3, "partnerVersion", dVar.a.b);
        com.iab.omid.library.bigosg.e.b.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        com.iab.omid.library.bigosg.e.b.a(jSONObject4, "libraryVersion", "1.3.0-Bigosg");
        com.iab.omid.library.bigosg.e.b.a(jSONObject4, "appId", com.iab.omid.library.bigosg.c.d.a().a.getApplicationContext().getPackageName());
        com.iab.omid.library.bigosg.e.b.a(jSONObject2, "app", jSONObject4);
        if (dVar.g != null) {
            com.iab.omid.library.bigosg.e.b.a(jSONObject2, "contentUrl", dVar.g);
        }
        if (dVar.f != null) {
            com.iab.omid.library.bigosg.e.b.a(jSONObject2, "customReferenceData", dVar.f);
        }
        JSONObject jSONObject5 = new JSONObject();
        for (T t : Collections.unmodifiableList(dVar.c)) {
            com.iab.omid.library.bigosg.e.b.a(jSONObject5, t.a, t.c);
        }
        e.a().a(c(), str, jSONObject2, jSONObject5, jSONObject);
    }

    public final void a(String str) {
        e.a().a(c(), str, (JSONObject) null);
    }

    public final void a(String str, JSONObject jSONObject) {
        e.a().a(c(), str, jSONObject);
    }

    public void b() {
        this.a.clear();
    }

    public final WebView c() {
        return (WebView) this.a.get();
    }

    public final void d() {
        this.e = System.nanoTime();
        this.d = C0077a.a;
    }
}
