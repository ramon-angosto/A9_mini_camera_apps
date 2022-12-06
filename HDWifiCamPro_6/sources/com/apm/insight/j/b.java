package com.apm.insight.j;

import android.content.Context;
import android.os.Handler;
import androidx.work.WorkRequest;
import com.apm.insight.h;
import com.apm.insight.runtime.d;
import com.apm.insight.runtime.p;
import com.apm.insight.runtime.s;
import java.util.Map;

public class b extends a {
    private static Runnable b = new Runnable() {
        public void run() {
            p.b().a().removeCallbacks(this);
            p.b().a((Runnable) new b(p.b().a(), 0, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, h.g()));
        }
    };
    private Context a;

    public b(Handler handler, long j, long j2, Context context) {
        super(handler, j, j2);
        this.a = context;
    }

    public static void d() {
        p.b().a(b, 100);
    }

    public void run() {
        Map<String, Object> map;
        try {
            map = h.a().c().getCommonParams();
        } catch (Throwable unused) {
            map = null;
        }
        if (map != null) {
            try {
                if (d.a(map)) {
                    a(c());
                    return;
                }
            } catch (Throwable unused2) {
                return;
            }
        }
        s.a().a(map, com.apm.insight.entity.b.b());
    }
}
