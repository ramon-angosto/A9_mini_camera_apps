package sg.bigo.ads.core.player.a;

import sg.bigo.ads.common.d.a;

public class i {
    private final Object a = new Object();
    a b;
    final Object c = new Object();
    volatile boolean d;
    public a e;

    public final int a(byte[] bArr, long j) {
        if (j < 0) {
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "buffer or offset or length is wrong");
            return 0;
        }
        int i = 0;
        while (!this.b.c() && this.b.a() < 8192 + j && !this.d) {
            i++;
            synchronized (this.a) {
                try {
                    sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "wait for downloading. thread=" + Thread.currentThread().getName() + ",url=" + this.e.b + ",count=" + i);
                    this.a.wait(1000);
                } catch (InterruptedException e2) {
                    sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Waiting source data is interrupted!" + e2.toString());
                }
            }
            if (i >= 15) {
                sg.bigo.ads.common.k.a.a(0, "ProxyCache", "wait for downloading more than 15s.");
                throw new j("Error reading source " + i + " times");
            }
        }
        int a2 = this.b.a(bArr, j);
        if (a2 <= 0) {
            sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "read end, size = ".concat(String.valueOf(a2)));
        }
        return a2;
    }
}
