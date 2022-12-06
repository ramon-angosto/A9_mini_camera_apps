package com.apm.insight;

import com.apm.insight.f.a;
import com.apm.insight.f.b;
import com.apm.insight.l.j;
import com.apm.insight.runtime.m;
import java.util.Map;

public class c {
    public c() {
        a.a();
    }

    public void a(String str) {
        a(str, "EnsureNotReachHere", (Map<String, String>) null);
    }

    public void a(String str, String str2, Map<String, String> map) {
        if (h.i().isEnsureEnable()) {
            b.a(Thread.currentThread().getStackTrace(), 5, str, str2, map);
        }
    }

    public void a(String str, Throwable th) {
        m.a(th, str);
    }

    public void a(Throwable th, String str) {
        if (a(th)) {
            b.a(th, str, true);
        }
    }

    public boolean a(Throwable th) {
        return h.i().isEnsureEnable() && !j.a(th);
    }
}
