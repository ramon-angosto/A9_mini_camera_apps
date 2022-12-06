package com.apm.insight.b;

import android.os.SystemClock;
import com.apm.insight.runtime.b;
import com.apm.insight.runtime.p;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;

public class c {
    /* access modifiers changed from: private */
    public static long b;
    /* access modifiers changed from: private */
    public final b a;
    /* access modifiers changed from: private */
    public boolean c = false;
    /* access modifiers changed from: private */
    public final Runnable d = new Runnable() {
        public void run() {
            if (!c.this.c) {
                c.this.a.d();
                long unused = c.b = SystemClock.uptimeMillis();
                boolean a2 = f.a();
                p.b().a(c.this.d, 500);
                b.a(c.b);
            }
        }
    };

    c(b bVar) {
        this.a = bVar;
        p.b().a(this.d, (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    public static boolean c() {
        return SystemClock.uptimeMillis() - b <= 15000;
    }

    public void a() {
        if (!this.c) {
            p.b().a(this.d, (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
    }

    public void b() {
        this.c = true;
    }
}
