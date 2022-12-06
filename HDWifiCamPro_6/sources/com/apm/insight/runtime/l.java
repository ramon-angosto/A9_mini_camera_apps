package com.apm.insight.runtime;

import android.os.SystemClock;
import android.util.Printer;
import com.apm.insight.b.f;
import com.apm.insight.l.q;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import java.util.ArrayList;
import java.util.List;

public class l {
    /* access modifiers changed from: private */
    public static Printer a;
    private static l b;
    /* access modifiers changed from: private */
    public static final Printer f = new Printer() {
        public void println(String str) {
            if (str != null) {
                if (str.charAt(0) == '>') {
                    l.a().a(str);
                } else if (str.charAt(0) == '<') {
                    l.a().b(str);
                }
                if (l.a != null && l.a != l.f) {
                    l.a.println(str);
                }
            }
        }
    };
    private long c = -1;
    private final List<Printer> d = new ArrayList();
    private final List<Printer> e = new ArrayList();
    private boolean g = false;

    private l() {
    }

    public static l a() {
        if (b == null) {
            synchronized (l.class) {
                if (b == null) {
                    b = new l();
                }
            }
        }
        return b;
    }

    private static void a(List<? extends Printer> list, String str) {
        if (list != null && !list.isEmpty()) {
            try {
                int size = list.size();
                int i = 0;
                while (i < size) {
                    Printer printer = (Printer) list.get(i);
                    if (printer != null) {
                        printer.println(str);
                        i++;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                q.a(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        f.a(false);
        this.c = -1;
        try {
            a(this.d, str);
        } catch (Exception e2) {
            q.a((Throwable) e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.c = SystemClock.uptimeMillis();
        try {
            a(this.e, str);
        } catch (Exception e2) {
            q.b((Throwable) e2);
        }
    }

    public boolean b() {
        return this.c != -1 && SystemClock.uptimeMillis() - this.c > DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    }
}
