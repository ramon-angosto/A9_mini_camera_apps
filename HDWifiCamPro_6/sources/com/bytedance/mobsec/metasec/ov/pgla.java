package com.bytedance.mobsec.metasec.ov;

import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import ms.bd.o.Pgl.pblb;
import ms.bd.o.Pgl.r0;
import ms.bd.o.Pgl.t0;

public class pgla {

    static class pblb extends pblb.pgla {
        pblb() {
        }

        public Object a(int i, long j, String str, Object obj) throws Throwable {
            return "";
        }
    }

    static class pblc extends pblb.pgla {
        pblc() {
        }

        public Object a(int i, long j, String str, Object obj) throws Throwable {
            return t0.c();
        }
    }

    static class pbld extends pblb.pgla {
        pbld() {
        }

        public Object a(int i, long j, String str, Object obj) throws Throwable {
            return "";
        }
    }

    /* renamed from: com.bytedance.mobsec.metasec.ov.pgla$pgla  reason: collision with other inner class name */
    static class C0023pgla extends pblb.pgla {
        C0023pgla() {
        }

        public Object a(int i, long j, String str, Object obj) throws Throwable {
            int i2;
            try {
                Display defaultDisplay = ((WindowManager) ms.bd.o.Pgl.pgla.a().b().getSystemService("window")).getDefaultDisplay();
                Point point = new Point();
                if (Build.VERSION.SDK_INT >= 17) {
                    defaultDisplay.getRealSize(point);
                } else if (Build.VERSION.SDK_INT >= 13) {
                    defaultDisplay.getSize(point);
                } else {
                    r0.a = defaultDisplay.getWidth();
                    i2 = defaultDisplay.getHeight();
                    r0.b = i2;
                    return r0.a + "*" + r0.b;
                }
                r0.a = point.x;
                i2 = point.y;
                r0.b = i2;
            } catch (Throwable unused) {
            }
            return r0.a + "*" + r0.b;
        }
    }

    public static void a() {
        ms.bd.o.Pgl.pblb.a(268435457, (pblb.pgla) new C0023pgla());
        ms.bd.o.Pgl.pblb.a(268435463, (pblb.pgla) new pblb());
        ms.bd.o.Pgl.pblb.a(268435462, (pblb.pgla) new pblc());
        ms.bd.o.Pgl.pblb.a(268435464, (pblb.pgla) new pbld());
    }
}
