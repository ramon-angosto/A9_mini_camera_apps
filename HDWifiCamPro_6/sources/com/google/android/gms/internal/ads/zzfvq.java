package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfvq implements Map, Serializable {
    @CheckForNull
    private transient zzfvs zza;
    @CheckForNull
    private transient zzfvs zzb;
    @CheckForNull
    private transient zzfvi zzc;

    zzfvq() {
    }

    public static zzfvq zzc(Map map) {
        Set entrySet = map.entrySet();
        zzfvp zzfvp = new zzfvp(entrySet instanceof Collection ? entrySet.size() : 4);
        zzfvp.zzb(entrySet);
        return zzfvp.zzc();
    }

    public static zzfvq zzd() {
        return zzfxb.zza;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        return zzfwi.zzb(this, obj);
    }

    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzfxi.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzfum.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract zzfvi zza();

    /* renamed from: zzb */
    public final zzfvi values() {
        zzfvi zzfvi = this.zzc;
        if (zzfvi != null) {
            return zzfvi;
        }
        zzfvi zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzfvs zze();

    /* access modifiers changed from: package-private */
    public abstract zzfvs zzf();

    /* renamed from: zzg */
    public final zzfvs entrySet() {
        zzfvs zzfvs = this.zza;
        if (zzfvs != null) {
            return zzfvs;
        }
        zzfvs zze = zze();
        this.zza = zze;
        return zze;
    }

    /* renamed from: zzh */
    public final zzfvs keySet() {
        zzfvs zzfvs = this.zzb;
        if (zzfvs != null) {
            return zzfvs;
        }
        zzfvs zzf = zzf();
        this.zzb = zzf;
        return zzf;
    }
}
