package org.apache.thrift.protocol;

import org.apache.thrift.f;

public class h {
    private static int a = Integer.MAX_VALUE;

    public static void a(e eVar, byte b) {
        a(eVar, b, a);
    }

    public static void a(e eVar, byte b, int i) {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    eVar.p();
                    return;
                case 3:
                    eVar.q();
                    return;
                case 4:
                    eVar.u();
                    return;
                case 6:
                    eVar.r();
                    return;
                case 8:
                    eVar.s();
                    return;
                case 10:
                    eVar.t();
                    return;
                case 11:
                    eVar.w();
                    return;
                case 12:
                    eVar.f();
                    while (true) {
                        b h = eVar.h();
                        if (h.b == 0) {
                            eVar.g();
                            return;
                        } else {
                            a(eVar, h.b, i - 1);
                            eVar.i();
                        }
                    }
                case 13:
                    d j = eVar.j();
                    while (i2 < j.c) {
                        int i3 = i - 1;
                        a(eVar, j.a, i3);
                        a(eVar, j.b, i3);
                        i2++;
                    }
                    eVar.k();
                    return;
                case 14:
                    i n = eVar.n();
                    while (i2 < n.b) {
                        a(eVar, n.a, i - 1);
                        i2++;
                    }
                    eVar.o();
                    return;
                case 15:
                    c l = eVar.l();
                    while (i2 < l.b) {
                        a(eVar, l.a, i - 1);
                        i2++;
                    }
                    eVar.m();
                    return;
                default:
                    return;
            }
        } else {
            throw new f("Maximum skip depth exceeded");
        }
    }
}
