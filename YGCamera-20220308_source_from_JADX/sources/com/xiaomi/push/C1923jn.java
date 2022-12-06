package com.xiaomi.push;

/* renamed from: com.xiaomi.push.jn */
public class C1923jn {

    /* renamed from: a */
    private static int f3536a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m4681a(C1920jk jkVar, byte b) {
        m4682a(jkVar, b, f3536a);
    }

    /* renamed from: a */
    public static void m4682a(C1920jk jkVar, byte b, int i) {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    jkVar.mo18332a();
                    return;
                case 3:
                    jkVar.mo18332a();
                    return;
                case 4:
                    jkVar.mo18332a();
                    return;
                case 6:
                    jkVar.mo18332a();
                    return;
                case 8:
                    jkVar.mo18332a();
                    return;
                case 10:
                    jkVar.mo18332a();
                    return;
                case 11:
                    jkVar.mo18332a();
                    return;
                case 12:
                    jkVar.mo18332a();
                    while (true) {
                        C1917jh a = jkVar.mo18332a();
                        if (a.f3526a == 0) {
                            jkVar.mo18350f();
                            return;
                        } else {
                            m4682a(jkVar, a.f3526a, i - 1);
                            jkVar.mo18351g();
                        }
                    }
                case 13:
                    C1919jj a2 = jkVar.mo18332a();
                    while (i2 < a2.f3532a) {
                        int i3 = i - 1;
                        m4682a(jkVar, a2.f3531a, i3);
                        m4682a(jkVar, a2.f3533b, i3);
                        i2++;
                    }
                    jkVar.mo18352h();
                    return;
                case 14:
                    C1924jo a3 = jkVar.mo18332a();
                    while (i2 < a3.f3538a) {
                        m4682a(jkVar, a3.f3537a, i - 1);
                        i2++;
                    }
                    jkVar.mo18354j();
                    return;
                case 15:
                    C1918ji a4 = jkVar.mo18332a();
                    while (i2 < a4.f3530a) {
                        m4682a(jkVar, a4.f3529a, i - 1);
                        i2++;
                    }
                    jkVar.mo18353i();
                    return;
                default:
                    return;
            }
        } else {
            throw new C1913je("Maximum skip depth exceeded");
        }
    }
}
