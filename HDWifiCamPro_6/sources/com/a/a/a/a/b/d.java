package com.a.a.a.a.b;

import android.webkit.WebView;
import com.a.a.a.a.e.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class d {
    private final j a;
    private final WebView b;
    private final List<l> c = new ArrayList();
    private final Map<String, l> d = new HashMap();
    private final String e;
    private final String f;
    private final String g;
    private final e h;

    private d(j jVar, WebView webView, String str, List<l> list, String str2, String str3, e eVar) {
        this.a = jVar;
        this.b = webView;
        this.e = str;
        this.h = eVar;
        if (list != null) {
            this.c.addAll(list);
            for (l put : list) {
                String uuid = UUID.randomUUID().toString();
                this.d.put(uuid, put);
            }
        }
        this.g = str2;
        this.f = str3;
    }

    public static d a(j jVar, WebView webView, String str, String str2) {
        e.a((Object) jVar, "Partner is null");
        e.a((Object) webView, "WebView is null");
        if (str2 != null) {
            e.a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(jVar, webView, (String) null, (List<l>) null, str, str2, e.HTML);
    }

    public static d a(j jVar, String str, List<l> list, String str2, String str3) {
        e.a((Object) jVar, "Partner is null");
        e.a((Object) str, "OM SDK JS script content is null");
        e.a((Object) list, "VerificationScriptResources is null");
        if (str3 != null) {
            e.a(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(jVar, (WebView) null, str, list, str2, str3, e.NATIVE);
    }

    public j a() {
        return this.a;
    }

    public List<l> b() {
        return Collections.unmodifiableList(this.c);
    }

    public Map<String, l> c() {
        return Collections.unmodifiableMap(this.d);
    }

    public WebView d() {
        return this.b;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.e;
    }

    public e h() {
        return this.h;
    }
}
