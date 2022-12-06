package sg.bigo.ads.common.l.a;

import android.text.TextUtils;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sg.bigo.ads.common.k.a;

public final class b {
    final Map<String, String> a = new ConcurrentHashMap();

    public final boolean a(URL url, URL url2) {
        String str;
        String protocol = url.getProtocol();
        if (TextUtils.isEmpty(protocol)) {
            str = "originURL protocol is empty.";
        } else if (!protocol.equalsIgnoreCase(url2.getProtocol())) {
            str = "protocol is not equal.";
        } else {
            String host = url.getHost();
            String host2 = url2.getHost();
            if (!host.equalsIgnoreCase("www.".concat(String.valueOf(host2))) && !host2.equalsIgnoreCase("www.".concat(String.valueOf(host)))) {
                return false;
            }
            a.a(0, "HostCache", "cache host, originHost=" + host + ", newHost=" + host2);
            this.a.put(host, host2);
            return true;
        }
        a.a(0, "HostCache", str);
        return false;
    }
}
