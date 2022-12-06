package com.apm.insight.nativecrash;

import android.text.TextUtils;
import com.apm.insight.l.o;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class a {
    private Map<String, String> a;

    public a(File file) {
        String a2;
        File c = o.c(file);
        if (c.exists() && c.length() != 0 && (a2 = NativeImpl.a(c.getAbsolutePath())) != null) {
            String[] split = a2.split("\n");
            this.a = new HashMap();
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3.length == 2) {
                    this.a.put(split3[0], split3[1]);
                }
            }
        }
    }

    public boolean a() {
        Map<String, String> map = this.a;
        return map != null && !map.isEmpty() && !TextUtils.isEmpty(this.a.get("process_name")) && !TextUtils.isEmpty(this.a.get("crash_thread_name")) && !TextUtils.isEmpty(this.a.get("pid")) && !TextUtils.isEmpty(this.a.get("tid")) && !TextUtils.isEmpty(this.a.get("start_time")) && !TextUtils.isEmpty(this.a.get("crash_time")) && !TextUtils.isEmpty(this.a.get("signal_line"));
    }

    public String b() {
        return this.a.get("signal_line");
    }

    public Map<String, String> c() {
        return this.a;
    }
}
