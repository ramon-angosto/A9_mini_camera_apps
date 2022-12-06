package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.sdk.g.c;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.j.a.b;
import com.ironsource.sdk.j.a.d;
import com.ironsource.sdk.j.e;
import java.util.Map;
import org.json.JSONObject;

public interface m {
    void a(Context context);

    void a(c cVar, Map<String, String> map, b bVar);

    void a(c cVar, Map<String, String> map, com.ironsource.sdk.j.a.c cVar2);

    void a(String str, com.ironsource.sdk.j.a.c cVar);

    void a(String str, String str2, c cVar, b bVar);

    void a(String str, String str2, c cVar, com.ironsource.sdk.j.a.c cVar2);

    void a(String str, String str2, c cVar, d dVar);

    void a(String str, String str2, e eVar);

    void a(String str, String str2, Map<String, String> map, e eVar);

    void a(Map<String, String> map, e eVar);

    void a(JSONObject jSONObject);

    void a(JSONObject jSONObject, com.ironsource.sdk.j.a.c cVar);

    void a(JSONObject jSONObject, d dVar);

    void b(Context context);

    void b(c cVar, Map<String, String> map, com.ironsource.sdk.j.a.c cVar2);

    d.c c();

    boolean c(String str);

    void d();

    void destroy();

    void e();

    void f();

    @Deprecated
    void g();

    void h();
}
