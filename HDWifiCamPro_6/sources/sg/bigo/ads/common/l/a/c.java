package sg.bigo.ads.common.l.a;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import sg.bigo.ads.common.l.a;
import sg.bigo.ads.common.utils.j;

public final class c {
    final sg.bigo.ads.common.l.b.c a;
    final a b;
    final URL c;
    HttpURLConnection d;
    boolean e;
    private final b f;

    private c(sg.bigo.ads.common.l.b.c cVar, a aVar, URL url, b bVar) {
        this.e = false;
        this.a = cVar;
        this.b = aVar;
        this.c = url;
        this.f = bVar;
        sg.bigo.ads.common.k.a.a(0, 3, "HttpRequest", "request, " + cVar + ", redirectURL= " + url + ", content=" + cVar.d());
    }

    public c(sg.bigo.ads.common.l.b.c cVar, a aVar, b bVar) {
        this(cVar, aVar, (URL) null, bVar);
    }

    public final URL a() {
        return new URL(this.a.f());
    }

    public final c a(URL url) {
        return new c(this.a, this.b, url, this.f);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        Map<String, Set<String>> map = this.a.g;
        if (!map.containsKey("Connection")) {
            map.put("Connection", new HashSet(Arrays.asList(new String[]{"Keep-Alive"})));
        }
        Set set = map.get("Accept-Encoding");
        if (j.a(map.get("Range")) && j.a(set)) {
            this.e = true;
            map.put("Accept-Encoding", new HashSet(Arrays.asList(new String[]{"gzip"})));
        }
        String str = null;
        try {
            b bVar = this.f;
            String host = this.d.getURL().getHost();
            str = TextUtils.isEmpty(host) ? "" : bVar.a.get(host);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(str)) {
            map.put(HttpHeaders.HOST, new HashSet(Arrays.asList(new String[]{str})));
        }
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            Set<String> set2 = (Set) next.getValue();
            if (!TextUtils.isEmpty(str2) && !j.a(set2)) {
                for (String str3 : set2) {
                    if (!TextUtils.isEmpty(str3)) {
                        this.d.addRequestProperty(str2, str3);
                    }
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.c != null) {
            sb.append("originUrl=");
            sb.append(this.a.f());
            sb.append(", redirectURL=");
            sb.append(this.c);
        } else {
            sb.append("requestUrl=");
            sb.append(this.a.f());
        }
        return sb.toString();
    }
}
