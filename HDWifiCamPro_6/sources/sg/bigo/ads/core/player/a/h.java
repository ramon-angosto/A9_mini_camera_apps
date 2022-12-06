package sg.bigo.ads.core.player.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import sg.bigo.ads.common.f.b;
import sg.bigo.ads.common.g;

public final class h {
    private final ExecutorService a = Executors.newSingleThreadExecutor(new b("Ping"));
    private final String b;
    private final int c;

    class a implements Callable<Boolean> {
        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final /* synthetic */ Object call() {
            return Boolean.valueOf(h.this.b());
        }
    }

    h(String str, int i) {
        this.b = (String) g.a(str);
        this.c = i;
    }

    private List<Proxy> c() {
        ArrayList arrayList = new ArrayList();
        try {
            return ProxySelector.getDefault().select(new URI(d()));
        } catch (URISyntaxException e) {
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Pinger#getDefaultProxies, error message is : " + e.toString());
            return arrayList;
        }
    }

    private String d() {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{this.b, Integer.valueOf(this.c), "ping"});
    }

    public final boolean a() {
        String str;
        int i = 70;
        int i2 = 0;
        while (i2 < 3) {
            try {
                if (((Boolean) this.a.submit(new a(this, (byte) 0)).get((long) i, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i2++;
                i *= 2;
            } catch (TimeoutException unused) {
                str = "Error pinging server (attempt: " + i2 + ", timeout: " + i + "). ";
                sg.bigo.ads.common.k.a.a(0, "ProxyCache", str);
                i2++;
                i *= 2;
            } catch (InterruptedException | ExecutionException unused2) {
                str = "Error pinging server due to unexpected error";
                sg.bigo.ads.common.k.a.a(0, "ProxyCache", str);
                i2++;
                i *= 2;
            }
        }
        sg.bigo.ads.common.k.a.a(0, "ProxyCache", String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i / 2), c()}));
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        byte[] bytes;
        g gVar = new g(d());
        try {
            bytes = "ping ok".getBytes();
            gVar.a = gVar.b();
            if (gVar.a != null) {
                gVar.b = new BufferedInputStream(gVar.a.getInputStream(), 8192);
            }
        } catch (IOException e) {
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Error opening connection for " + gVar.c + " with offset 0, error message is : " + e.toString());
        } catch (Throwable th) {
            gVar.a();
            throw th;
        }
        byte[] bArr = new byte[bytes.length];
        gVar.a(bArr);
        boolean equals = Arrays.equals(bytes, bArr);
        sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
        gVar.a();
        return equals;
    }
}
