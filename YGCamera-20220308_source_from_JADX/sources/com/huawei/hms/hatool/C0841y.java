package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.y */
public class C0841y {

    /* renamed from: a */
    public static C0843z f774a = new C0843z();

    /* renamed from: a */
    public static void m1080a(int i) {
        f774a.mo14153a(i);
    }

    /* renamed from: a */
    public static void m1081a(String str, String str2) {
        if (m1083a() && str != null && str2 != null) {
            f774a.mo14155b(3, str, str2);
        }
    }

    /* renamed from: a */
    public static void m1082a(String str, String str2, Object... objArr) {
        if (m1088c() && str != null && str2 != null) {
            f774a.mo14155b(4, str, String.format(str2, objArr));
        }
    }

    /* renamed from: a */
    public static boolean m1083a() {
        return f774a.mo14156b(3);
    }

    /* renamed from: b */
    public static void m1084b(String str, String str2) {
        if (m1086b() && str != null && str2 != null) {
            f774a.mo14155b(6, str, str2);
        }
    }

    /* renamed from: b */
    public static void m1085b(String str, String str2, Object... objArr) {
        m1089d(str, String.format(str2, objArr));
    }

    /* renamed from: b */
    public static boolean m1086b() {
        return f774a.mo14156b(6);
    }

    /* renamed from: c */
    public static void m1087c(String str, String str2) {
        if (m1088c() && str != null && str2 != null) {
            f774a.mo14155b(4, str, str2);
        }
    }

    /* renamed from: c */
    public static boolean m1088c() {
        return f774a.mo14156b(4);
    }

    /* renamed from: d */
    public static void m1089d(String str, String str2) {
        if (str != null && str2 != null) {
            f774a.mo14155b(4, str, str2);
        }
    }

    /* renamed from: d */
    public static boolean m1090d() {
        return f774a.mo14156b(5);
    }

    /* renamed from: e */
    public static void m1091e(String str, String str2) {
        if (str != null && str2 != null) {
            f774a.mo14155b(5, str, str2);
        }
    }

    /* renamed from: f */
    public static void m1092f(String str, String str2) {
        if (m1090d() && str != null && str2 != null) {
            f774a.mo14155b(5, str, str2);
        }
    }
}
