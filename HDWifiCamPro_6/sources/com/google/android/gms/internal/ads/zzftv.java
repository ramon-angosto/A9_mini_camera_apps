package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
class zzftv extends zzfwh {
    final transient Map zza;
    final /* synthetic */ zzfui zzb;

    zzftv(zzfui zzfui, Map map) {
        this.zzb = zzfui;
        this.zza = map;
    }

    public final void clear() {
        Map map = this.zza;
        zzfui zzfui = this.zzb;
        if (map == zzfui.zza) {
            zzfui.zzr();
        } else {
            zzfvx.zzb(new zzftu(this));
        }
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        Map map = this.zza;
        if (map != null) {
            try {
                return map.containsKey(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        } else {
            throw null;
        }
    }

    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @CheckForNull
    public final /* bridge */ /* synthetic */ Object get(@CheckForNull Object obj) {
        Collection collection = (Collection) zzfwi.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzc(obj, collection);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public Set keySet() {
        return this.zzb.zzv();
    }

    @CheckForNull
    public final /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection zza2 = this.zzb.zza();
        zza2.addAll(collection);
        zzfui.zzg(this.zzb, collection.size());
        collection.clear();
        return zza2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final String toString() {
        return this.zza.toString();
    }

    /* access modifiers changed from: package-private */
    public final Map.Entry zza(Map.Entry entry) {
        Object key = entry.getKey();
        return new zzfvj(key, this.zzb.zzc(key, (Collection) entry.getValue()));
    }

    /* access modifiers changed from: protected */
    public final Set zzb() {
        return new zzftt(this);
    }
}
