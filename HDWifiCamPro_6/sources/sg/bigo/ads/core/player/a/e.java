package sg.bigo.ads.core.player.a;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import sg.bigo.ads.common.d.a;
import sg.bigo.ads.common.g;

final class e {
    final AtomicInteger a = new AtomicInteger(0);
    volatile c b;
    volatile a c;
    volatile long d = 0;
    volatile long e = SystemClock.elapsedRealtime();
    final AtomicInteger f = new AtomicInteger(0);
    private final String g;

    public e(String str) {
        this.g = (String) g.a(str);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a() {
        c cVar;
        if (this.b == null) {
            String str = this.g;
            HashMap hashMap = new HashMap();
            for (String split : str.substring(str.indexOf("?") + 1).split("&")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            this.c = sg.bigo.ads.core.player.a.a().e.a((String) hashMap.get("path"), (String) hashMap.get("name"));
            if (this.c == null) {
                sg.bigo.ads.common.k.a.a(0, "ProxyCache", "downloadInfo = null");
                cVar = null;
            } else {
                cVar = new c(this.c);
            }
        } else {
            cVar = this.b;
        }
        this.b = cVar;
        return this.b != null;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b() {
        if (this.a.decrementAndGet() <= 0) {
            c cVar = this.b;
            synchronized (cVar.c) {
                sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "Shutdown proxy for ");
                cVar.d = true;
                cVar.b.b();
            }
            this.b = null;
        }
    }
}
