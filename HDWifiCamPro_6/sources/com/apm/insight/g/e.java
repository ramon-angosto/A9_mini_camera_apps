package com.apm.insight.g;

import com.apm.insight.h;
import com.apm.insight.l.r;
import com.apm.insight.runtime.a.b;

public class e {
    public static boolean a(long j) {
        if (r.a(2)) {
            return true;
        }
        if (r.a(1024)) {
            return false;
        }
        return (b.c() == -1 || j - b.c() <= h.i().getLaunchCrashInterval()) && (!h.m() || h.p() != 0);
    }
}
