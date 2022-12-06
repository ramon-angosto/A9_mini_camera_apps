package sg.bigo.ads.core.player.a;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import sg.bigo.ads.common.g;

final class f extends ProxySelector {
    private static final List<Proxy> a = Arrays.asList(new Proxy[]{Proxy.NO_PROXY});
    private final ProxySelector b;
    private final String c;
    private final int d;

    private f(ProxySelector proxySelector, String str, int i) {
        this.b = (ProxySelector) g.a(proxySelector);
        this.c = (String) g.a(str);
        this.d = i;
    }

    static void a(String str, int i) {
        ProxySelector.setDefault(new f(ProxySelector.getDefault(), str, i));
    }

    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    public final List<Proxy> select(URI uri) {
        return this.c.equals(uri.getHost()) && this.d == uri.getPort() ? a : this.b.select(uri);
    }
}
