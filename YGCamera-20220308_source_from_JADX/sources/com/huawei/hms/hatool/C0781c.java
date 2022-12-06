package com.huawei.hms.hatool;

import java.util.Map;

/* renamed from: com.huawei.hms.hatool.c */
public abstract class C0781c {
    /* renamed from: a */
    public static void m740a(String str, String str2, long j) {
        C0807k h = m748h(str, str2);
        if (h != null) {
            h.mo14000a(j);
        }
    }

    /* renamed from: a */
    public static boolean m741a(String str, String str2) {
        C0807k h = m748h(str, str2);
        if (h != null) {
            return h.mo14004a();
        }
        return true;
    }

    /* renamed from: b */
    public static int m742b(String str, String str2) {
        C0807k h = m748h(str, str2);
        if (h != null) {
            return h.mo14012d();
        }
        return 7;
    }

    /* renamed from: c */
    public static boolean m743c(String str, String str2) {
        C0807k h = m748h(str, str2);
        if (h != null) {
            return h.mo14021g();
        }
        return true;
    }

    /* renamed from: d */
    public static String m744d(String str, String str2) {
        C0807k h = m748h(str, str2);
        return h != null ? h.mo14018f() : "";
    }

    /* renamed from: e */
    public static boolean m745e(String str, String str2) {
        C0807k h = m748h(str, str2);
        if (h != null) {
            return h.mo14023i();
        }
        return false;
    }

    /* renamed from: f */
    public static String m746f(String str, String str2) {
        C0807k h = m748h(str, str2);
        return h != null ? h.mo14022h() : "";
    }

    /* renamed from: g */
    public static String m747g(String str, String str2) {
        C0807k h = m748h(str, str2);
        return h != null ? h.mo14028n() : "";
    }

    /* renamed from: h */
    public static C0807k m748h(String str, String str2) {
        C0813m a = C0801i.m860c().mo13979a(str);
        if (a == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return a.mo14072a(str2);
        }
        C0807k a2 = a.mo14072a("oper");
        return a2 == null ? a.mo14072a("maint") : a2;
    }

    /* renamed from: i */
    public static Map<String, String> m749i(String str, String str2) {
        C0807k h = m748h(str, str2);
        if (h != null) {
            return h.mo14025k();
        }
        return null;
    }

    /* renamed from: j */
    public static long m750j(String str, String str2) {
        C0807k h = m748h(str, str2);
        if (h != null) {
            return h.mo14026l();
        }
        return 0;
    }

    /* renamed from: k */
    public static int m751k(String str, String str2) {
        C0807k h = m748h(str, str2);
        if (h != null) {
            return h.mo14005b();
        }
        return 10;
    }

    /* renamed from: l */
    public static String m752l(String str, String str2) {
        C0807k h = m748h(str, str2);
        return h != null ? h.mo14029o() : "";
    }

    /* renamed from: m */
    public static String m753m(String str, String str2) {
        C0807k h = m748h(str, str2);
        return h != null ? h.mo14031q() : "";
    }

    /* renamed from: n */
    public static String m754n(String str, String str2) {
        C0807k h = m748h(str, str2);
        return h != null ? h.mo14027m() : "";
    }

    /* renamed from: o */
    public static String m755o(String str, String str2) {
        C0807k h = m748h(str, str2);
        return h != null ? h.mo14030p() : "";
    }
}
