package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import java.util.Map;

/* compiled from: UIEnergize */
public class b {
    private static volatile b a;

    private b() {
    }

    public static b a() {
        b bVar;
        if (a != null) {
            return a;
        }
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public final void a(View view, com.mbridge.msdk.video.dynview.b bVar, Map<String, Object> map) {
        if (bVar != null) {
            int h = bVar.h();
            if (h == 1) {
                new com.mbridge.msdk.video.dynview.j.b().a(view);
            } else if (h == 102 || h == 202 || h == 302 || h == 802 || h == 904) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, bVar);
            } else if (h == 3) {
                new com.mbridge.msdk.video.dynview.j.b().b(view, bVar);
            } else if (h == 4) {
                new com.mbridge.msdk.video.dynview.j.b().c(view, bVar);
            }
        }
    }
}
