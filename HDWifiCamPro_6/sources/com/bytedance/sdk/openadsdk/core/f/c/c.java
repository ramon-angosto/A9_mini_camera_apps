package com.bytedance.sdk.openadsdk.core.f.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.f.a.a;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: VastMacroHelper */
public class c {
    private final List<String> a;
    private final Map<b, String> b = new HashMap();

    public c(List<String> list) {
        this.a = list;
        this.b.put(b.CACHEBUSTING, b());
    }

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.a) {
            if (!TextUtils.isEmpty(next)) {
                for (b bVar : b.values()) {
                    String str = this.b.get(bVar);
                    if (str == null) {
                        str = "";
                    }
                    next = next.replaceAll("\\[" + bVar.name() + "\\]", str);
                }
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public c a(a aVar) {
        if (aVar != null) {
            this.b.put(b.ERRORCODE, aVar.a());
        }
        return this;
    }

    public c a(long j) {
        if (j >= 0) {
            String b2 = b(j);
            if (!TextUtils.isEmpty(b2)) {
                this.b.put(b.CONTENTPLAYHEAD, b2);
            }
        }
        return this;
    }

    public c a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (Throwable unused) {
            }
            this.b.put(b.ASSETURI, str);
        }
        return this;
    }

    private String b() {
        return String.format(Locale.US, "%08d", new Object[]{Long.valueOf(Math.round(Math.random() * 1.0E8d))});
    }

    private String b(long j) {
        return String.format("%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) % TimeUnit.HOURS.toMinutes(1)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1)), Long.valueOf(j % 1000)});
    }
}
