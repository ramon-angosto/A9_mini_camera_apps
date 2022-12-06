package com.apm.insight.b;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import java.util.concurrent.CopyOnWriteArrayList;

public class i {
    private static volatile boolean a;
    private static Printer b;
    private static final CopyOnWriteArrayList<e> c = new CopyOnWriteArrayList<>();
    private static e d;
    private static volatile a e;
    private static volatile boolean f = false;
    private static long g = 0;
    private static int h = 0;

    public interface a {
        void a(long j);
    }

    public static void a() {
        if (!a) {
            a = true;
            b = new Printer() {
                public void println(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        boolean z = false;
                        if (str.charAt(0) == '>') {
                            z = true;
                        } else if (str.charAt(0) != '<') {
                            return;
                        }
                        i.a(z, str);
                    }
                }
            };
            j.a();
            j.a(b);
        }
    }

    public static void a(e eVar) {
        synchronized (c) {
            c.add(eVar);
        }
    }

    public static void a(boolean z, String str) {
        e eVar;
        e eVar2;
        long nanoTime = System.nanoTime();
        e.a = nanoTime / 1000000;
        e.b = SystemClock.currentThreadTimeMillis();
        if (z && (eVar2 = d) != null && eVar2.a()) {
            d.a(str);
        }
        CopyOnWriteArrayList<e> copyOnWriteArrayList = c;
        for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
            e eVar3 = copyOnWriteArrayList.get(i);
            if (eVar3 != null && eVar3.a()) {
                boolean z2 = eVar3.c;
                if (z) {
                    if (!z2) {
                        eVar3.a(str);
                    }
                } else if (z2) {
                    eVar3.b(str);
                }
            } else if (!z && eVar3.c) {
                eVar3.b("");
            }
        }
        if (!z && (eVar = d) != null && eVar.a()) {
            d.b("");
        }
        if (f) {
            g += System.nanoTime() - nanoTime;
            int i2 = h;
            h = i2 + 1;
            if (i2 >= 1000) {
                if (e != null) {
                    e.a(g);
                }
                h = 0;
                g = 0;
                f = false;
            }
        }
    }
}
