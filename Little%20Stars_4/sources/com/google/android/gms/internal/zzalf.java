package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzalf {
    private static final Map<Class<?>, Class<?>> zzbXu;
    private static final Map<Class<?>, Class<?>> zzbXv;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        zza(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        zza(hashMap, hashMap2, Byte.TYPE, Byte.class);
        zza(hashMap, hashMap2, Character.TYPE, Character.class);
        zza(hashMap, hashMap2, Double.TYPE, Double.class);
        zza(hashMap, hashMap2, Float.TYPE, Float.class);
        zza(hashMap, hashMap2, Integer.TYPE, Integer.class);
        zza(hashMap, hashMap2, Long.TYPE, Long.class);
        zza(hashMap, hashMap2, Short.TYPE, Short.class);
        zza(hashMap, hashMap2, Void.TYPE, Void.class);
        zzbXu = Collections.unmodifiableMap(hashMap);
        zzbXv = Collections.unmodifiableMap(hashMap2);
    }

    private static void zza(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean zzk(Type type) {
        return zzbXu.containsKey(type);
    }

    public static <T> Class<T> zzp(Class<T> cls) {
        Class<T> cls2 = zzbXu.get(zzakx.zzz(cls));
        return cls2 == null ? cls : cls2;
    }
}
