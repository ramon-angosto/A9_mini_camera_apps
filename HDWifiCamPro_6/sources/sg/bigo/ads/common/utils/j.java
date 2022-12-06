package sg.bigo.ads.common.utils;

import java.util.Collection;
import java.util.Map;

public final class j {
    public static <K, V> String a(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(next.getKey());
            sb.append("->");
            sb.append(next.getValue());
            i++;
        }
        sb.append("}");
        return sb.toString();
    }

    public static <T> boolean a(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean a(T... tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> String b(Collection<T> collection) {
        if (collection == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int size = collection.size();
        int i = 0;
        for (T append : collection) {
            sb.append(append);
            if (i != size - 1) {
                sb.append(',');
            }
            i++;
        }
        sb.append(']');
        return sb.toString();
    }
}
