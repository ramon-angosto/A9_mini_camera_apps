package sg.bigo.ads.core.d.b;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sg.bigo.ads.common.utils.o;

public final class d {
    public final Map<String, String> a = new ConcurrentHashMap();
    public final String b;

    public d(String str) {
        this.b = str;
    }

    public final void a(String str, int i) {
        this.a.put(str, String.valueOf(i));
    }

    public final void a(String str, long j) {
        this.a.put(str, String.valueOf(j));
    }

    public final void a(String str, String str2) {
        if (!o.b(str) && !o.b(str2)) {
            this.a.put(str, str2);
        }
    }

    public final void a(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                this.a.put(next.getKey(), next.getValue());
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("eventId = ");
        sb.append(this.b);
        sb.append(":");
        for (Map.Entry next : this.a.entrySet()) {
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
            sb.append(",");
        }
        return sb.toString();
    }
}
