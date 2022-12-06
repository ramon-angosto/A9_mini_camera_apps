package com.mbridge.msdk.video.dynview;

import com.mbridge.msdk.video.dynview.d.c;
import java.util.Map;

/* compiled from: MBUIController */
public class a {
    private static volatile a a;

    private a() {
    }

    public static a a() {
        a aVar;
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public final void a(b bVar, c cVar) {
        new com.mbridge.msdk.video.dynview.h.a(bVar, cVar, (Map<String, Object>) null);
    }
}
