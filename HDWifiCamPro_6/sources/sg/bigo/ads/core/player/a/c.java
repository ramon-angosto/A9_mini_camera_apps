package sg.bigo.ads.core.player.a;

import java.io.OutputStream;
import java.util.Locale;
import sg.bigo.ads.core.player.a.a.a;

final class c extends i {
    a a;

    public c(sg.bigo.ads.common.d.a aVar) {
        this.e = aVar;
        this.a = new a(aVar);
        this.b = this.a;
    }

    static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* access modifiers changed from: package-private */
    public final void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "responseWithCache start thread=" + Thread.currentThread().getName());
        while (true) {
            int a2 = a(bArr, j);
            if (a2 != -1) {
                outputStream.write(bArr, 0, a2);
                j += (long) a2;
            } else {
                sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "responseWithCache end thread=" + Thread.currentThread().getName() + ",offset=" + j);
                outputStream.flush();
                return;
            }
        }
    }
}
