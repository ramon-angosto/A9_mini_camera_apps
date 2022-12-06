package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import android.os.Process;
import com.mbridge.msdk.foundation.same.net.e.a;
import com.mbridge.msdk.foundation.same.net.e.c;
import com.mbridge.msdk.foundation.tools.q;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: NetworkDispatcher */
public class h {
    private static final String a = h.class.getSimpleName();
    private a b = new c();
    private g c;
    private c d;

    public h(Context context, SSLSocketFactory sSLSocketFactory, c cVar) {
        this.c = new com.mbridge.msdk.foundation.same.net.f.a(this.b, cVar);
        this.d = cVar;
    }

    public final void a(i iVar) {
        Process.setThreadPriority(10);
        try {
            this.d.c(iVar);
            if (iVar.c()) {
                iVar.a("network-discard-cancelled");
                this.d.b(iVar);
                this.d.a(iVar);
                return;
            }
            this.d.d(iVar);
            this.d.a((i<?>) iVar, (k<?>) iVar.a(this.c.a(iVar)));
        } catch (com.mbridge.msdk.foundation.same.net.a.a e) {
            this.d.a((i<?>) iVar, e);
        } catch (Exception e2) {
            String str = a;
            q.d(str, "Unhandled exception " + e2.getMessage());
            this.d.a((i<?>) iVar, new com.mbridge.msdk.foundation.same.net.a.a(4, (com.mbridge.msdk.foundation.same.net.f.c) null));
        }
    }
}
