package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ad */
public class C1611ad {

    /* renamed from: a */
    private static int f1754a;

    /* renamed from: a */
    public static final String f1755a = (C1614ag.f1765b ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@");

    /* renamed from: a */
    public static final boolean f1756a = f1755a.contains("2A2FE0D7");

    /* renamed from: b */
    public static final boolean f1757b = (f1756a || "DEBUG".equalsIgnoreCase(f1755a));

    /* renamed from: c */
    public static final boolean f1758c = "LOGABLE".equalsIgnoreCase(f1755a);

    /* renamed from: d */
    public static final boolean f1759d = f1755a.contains("YY");

    /* renamed from: e */
    public static boolean f1760e = f1755a.equalsIgnoreCase("TEST");

    /* renamed from: f */
    public static final boolean f1761f = "BETA".equalsIgnoreCase(f1755a);

    /* renamed from: g */
    public static final boolean f1762g;

    static {
        int i;
        boolean z = false;
        String str = f1755a;
        if (str != null && str.startsWith("RC")) {
            z = true;
        }
        f1762g = z;
        f1754a = 1;
        if (f1755a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (f1755a.equalsIgnoreCase("ONEBOX")) {
            i = 3;
        } else {
            f1754a = 1;
            return;
        }
        f1754a = i;
    }

    /* renamed from: a */
    public static int m2504a() {
        return f1754a;
    }

    /* renamed from: a */
    public static void m2505a(int i) {
        f1754a = i;
    }

    /* renamed from: a */
    public static boolean m2506a() {
        return f1754a == 2;
    }

    /* renamed from: b */
    public static boolean m2507b() {
        return f1754a == 3;
    }
}
