package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import com.mbridge.msdk.foundation.same.net.d.b;

/* compiled from: VolleyManager */
public final class n {
    private static n c;
    private j a;
    private b b;

    private n() {
    }

    public static void a(Context context) {
        if (c == null) {
            c = new n();
            c.a = new j(context.getApplicationContext());
            c.b = new b(b(), 3);
        }
    }

    public static void a(i iVar) {
        b().a(iVar);
    }

    private static j b() {
        j jVar = c.a;
        if (jVar != null) {
            return jVar;
        }
        throw new IllegalStateException("RequestQueue not initialized");
    }

    public static b a() {
        b bVar = c.b;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("FileDownloader not initialized");
    }
}
