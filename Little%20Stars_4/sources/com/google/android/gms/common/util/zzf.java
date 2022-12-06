package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzf {
    public static <T> List<T> zzA(T t) {
        return Collections.singletonList(t);
    }

    public static <T> Set<T> zzB(T t) {
        return Collections.singleton(t);
    }

    public static <K, V> Map<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        ArrayMap arrayMap = new ArrayMap(6);
        arrayMap.put(k, v);
        arrayMap.put(k2, v2);
        arrayMap.put(k3, v3);
        arrayMap.put(k4, v4);
        arrayMap.put(k5, v5);
        arrayMap.put(k6, v6);
        return Collections.unmodifiableMap(arrayMap);
    }

    public static <T> Set<T> zza(T t, T t2, T t3) {
        zza zza = new zza(3);
        zza.add(t);
        zza.add(t2);
        zza.add(t3);
        return Collections.unmodifiableSet(zza);
    }

    public static <T> Set<T> zza(T t, T t2, T t3, T t4) {
        zza zza = new zza(4);
        zza.add(t);
        zza.add(t2);
        zza.add(t3);
        zza.add(t4);
        return Collections.unmodifiableSet(zza);
    }

    private static <K, V> void zza(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            int length2 = vArr.length;
            StringBuilder sb = new StringBuilder(66);
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static <K, V> Map<K, V> zzb(K[] kArr, V[] vArr) {
        zza(kArr, vArr);
        int length = kArr.length;
        if (length == 0) {
            return zzuV();
        }
        if (length == 1) {
            return zze(kArr[0], vArr[0]);
        }
        Map arrayMap = length <= 32 ? new ArrayMap(length) : new HashMap(length, 1.0f);
        for (int i = 0; i < length; i++) {
            arrayMap.put(kArr[i], vArr[i]);
        }
        return Collections.unmodifiableMap(arrayMap);
    }

    public static <T> List<T> zzc(T t, T t2) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(t);
        arrayList.add(t2);
        return Collections.unmodifiableList(arrayList);
    }

    public static <T> Set<T> zzc(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return zzuU();
        }
        if (length == 1) {
            return zzB(tArr[0]);
        }
        if (length == 2) {
            return zzd(tArr[0], tArr[1]);
        }
        if (length == 3) {
            return zza(tArr[0], tArr[1], tArr[2]);
        }
        if (length == 4) {
            return zza(tArr[0], tArr[1], tArr[2], tArr[3]);
        }
        return Collections.unmodifiableSet(tArr.length <= 32 ? new zza(Arrays.asList(tArr)) : new HashSet(Arrays.asList(tArr)));
    }

    public static <T> Set<T> zzd(T t, T t2) {
        zza zza = new zza(2);
        zza.add(t);
        zza.add(t2);
        return Collections.unmodifiableSet(zza);
    }

    public static <K, V> Map<K, V> zze(K k, V v) {
        return Collections.singletonMap(k, v);
    }

    public static <T> Set<T> zzuU() {
        return Collections.emptySet();
    }

    public static <K, V> Map<K, V> zzuV() {
        return Collections.emptyMap();
    }
}
