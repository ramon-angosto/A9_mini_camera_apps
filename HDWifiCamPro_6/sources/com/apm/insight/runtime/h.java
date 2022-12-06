package com.apm.insight.runtime;

import android.content.Context;
import com.apm.insight.b;
import com.apm.insight.l.i;
import com.apm.insight.l.l;
import com.apm.insight.l.o;
import com.apm.insight.l.r;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class h {
    private Context a;
    private HashMap<String, Long> b = null;
    private int c = 50;
    private int d = 100;

    public h(Context context) {
        this.a = context;
        this.b = c();
        b();
    }

    private void a(File file) {
        File g = o.g(this.a);
        file.renameTo(new File(g, String.valueOf(System.currentTimeMillis())));
        String[] list = g.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            new File(g, list[0]).delete();
        }
    }

    private void b() {
        this.c = a.a(this.c, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        this.d = a.a(this.d, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
    }

    private HashMap<String, Long> c() {
        File h = o.h(this.a);
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
        try {
            JSONArray b2 = i.b(h.getAbsolutePath());
            if (l.a(b2)) {
                return hashMap;
            }
            Long decode = Long.decode(b2.optString(0, (String) null));
            if (System.currentTimeMillis() - decode.longValue() > 86400000) {
                a(h);
                return hashMap;
            }
            hashMap.put("time", decode);
            for (int i = 1; i < b2.length(); i++) {
                String[] split = b2.optString(i, "").split(" ");
                if (split.length == 2) {
                    hashMap.put(split[0], Long.decode(split[1]));
                }
            }
            return hashMap;
        } catch (IOException unused) {
        } catch (Throwable th) {
            b.a().a("NPTH_CATCH", th);
        }
    }

    public void a() {
        HashMap<String, Long> hashMap = this.b;
        Long remove = hashMap.remove("time");
        if (remove == null) {
            b.a().a("NPTH_CATCH", (Throwable) new RuntimeException("err times, no time"));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(remove);
        sb.append(10);
        for (Map.Entry next : hashMap.entrySet()) {
            sb.append((String) next.getKey());
            sb.append(' ');
            sb.append(next.getValue());
            sb.append(10);
        }
        try {
            i.a(o.h(this.a), sb.toString(), false);
        } catch (IOException unused) {
        }
    }

    public boolean a(String str) {
        if (str == null) {
            str = "default";
        }
        return r.a(this.b, str, 1L).longValue() < ((long) this.c) && r.a(this.b, "all", 1L).longValue() < ((long) this.d);
    }
}
