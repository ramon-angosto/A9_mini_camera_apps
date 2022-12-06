package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1885ie;
import com.xiaomi.push.C1886if;
import com.xiaomi.push.C1890ij;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1896ip;
import com.xiaomi.push.C1897iq;
import com.xiaomi.push.C1898ir;
import com.xiaomi.push.C1900it;
import com.xiaomi.push.C1902iv;
import com.xiaomi.push.C1904ix;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1906iz;

/* renamed from: com.xiaomi.push.service.bv */
public class C2036bv {
    /* renamed from: a */
    public static C1906iz m5187a(Context context, C1891ik ikVar) {
        if (ikVar.mo18052b()) {
            return null;
        }
        byte[] a = ikVar.mo18043a();
        C1906iz a2 = m5188a(ikVar.mo18043a(), ikVar.f3196b);
        if (a2 != null) {
            C1905iy.m4542a(a2, a);
        }
        return a2;
    }

    /* renamed from: a */
    private static C1906iz m5188a(C1868ho hoVar, boolean z) {
        switch (C2037bw.f3853a[hoVar.ordinal()]) {
            case 1:
                return new C1896ip();
            case 2:
                return new C1902iv();
            case 3:
                return new C1900it();
            case 4:
                return new C1904ix();
            case 5:
                return new C1898ir();
            case 6:
                return new C1885ie();
            case 7:
                return new C1890ij();
            case 8:
                return new C1897iq();
            case 9:
                if (z) {
                    return new C1894in();
                }
                C1886if ifVar = new C1886if();
                ifVar.mo17965a(true);
                return ifVar;
            case 10:
                return new C1890ij();
            default:
                return null;
        }
    }
}
