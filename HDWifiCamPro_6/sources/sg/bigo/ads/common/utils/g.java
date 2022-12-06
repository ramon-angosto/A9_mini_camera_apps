package sg.bigo.ads.common.utils;

import java.util.HashMap;
import java.util.Map;

public final class g<V> {
    private final HashMap<String, V> a = new HashMap<>();

    public final V a(String str) {
        if (str == null) {
            return null;
        }
        return this.a.get(str.toLowerCase());
    }

    public final void a(Map<? extends String, ? extends V> map) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (!(str == null || value == null)) {
                    this.a.put(str.toLowerCase(), value);
                }
            }
        }
    }

    public final V b(String str) {
        return this.a.remove(str.toLowerCase());
    }
}
