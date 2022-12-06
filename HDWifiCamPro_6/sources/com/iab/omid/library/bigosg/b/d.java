package com.iab.omid.library.bigosg.b;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class d {
    public final j a;
    final WebView b;
    public final List<k> c = new ArrayList();
    public final Map<String, k> d = new HashMap();
    final String e;
    public final String f;
    public final String g;
    public final e h;

    public d(j jVar, WebView webView, String str, List<k> list, String str2, e eVar) {
        this.a = jVar;
        this.b = webView;
        this.e = str;
        this.h = eVar;
        if (list != null) {
            this.c.addAll(list);
            for (k put : list) {
                String uuid = UUID.randomUUID().toString();
                this.d.put(uuid, put);
            }
        }
        this.g = null;
        this.f = str2;
    }
}
