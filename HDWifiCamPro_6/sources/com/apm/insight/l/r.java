package com.apm.insight.l;

import java.util.Map;
import org.json.JSONObject;

public class r {
    private static int a;

    public static int a(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt(String.valueOf(obj));
            } catch (Throwable unused) {
            }
        }
        return i;
    }

    public static Float a(Map<? super String, Float> map) {
        float f = 0.0f;
        for (Float next : map.values()) {
            if (next != null) {
                f += next.floatValue();
            }
        }
        return Float.valueOf(f);
    }

    public static Long a(Map<? super String, Long> map, String str, Long l) {
        if (str == null || map == null) {
            return -1L;
        }
        Long l2 = map.get(str);
        if (l2 != null) {
            l = Long.valueOf(l2.longValue() + l.longValue());
        }
        map.put(str, l);
        return l;
    }

    public static void a(JSONObject jSONObject) {
    }

    public static boolean a(int i) {
        return false;
    }

    public static int b(int i) {
        if (i == 0) {
            return 4;
        }
        if (i == 1) {
            return 8;
        }
        if (i == 2) {
            return 16;
        }
        if (i == 3) {
            return 32;
        }
        if (i != 4) {
            return i != 5 ? 0 : 128;
        }
        return 64;
    }
}
