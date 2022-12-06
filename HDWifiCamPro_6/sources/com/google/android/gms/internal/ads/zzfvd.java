package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfvd extends zzfve implements Map {
    protected zzfvd() {
    }

    public final void clear() {
        zzb().clear();
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return zzb().containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return zzb().containsValue(obj);
    }

    public Set entrySet() {
        return zzb().entrySet();
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || zzb().equals(obj);
    }

    @CheckForNull
    public Object get(@CheckForNull Object obj) {
        return zzb().get(obj);
    }

    public int hashCode() {
        return zzb().hashCode();
    }

    public boolean isEmpty() {
        return zzb().isEmpty();
    }

    public Set keySet() {
        return zzb().keySet();
    }

    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        return zzb().put(obj, obj2);
    }

    public final void putAll(Map map) {
        zzb().putAll(map);
    }

    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        return zzb().remove(obj);
    }

    public int size() {
        return zzb().size();
    }

    public final Collection values() {
        return zzb().values();
    }

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract Map zzb();

    /* access modifiers changed from: protected */
    public final int zzc() {
        return zzfxi.zza(entrySet());
    }

    /* access modifiers changed from: protected */
    public final boolean zzd(@CheckForNull Object obj) {
        zzfwd zzfwd = new zzfwd(entrySet().iterator());
        if (obj == null) {
            while (zzfwd.hasNext()) {
                if (zzfwd.next() == null) {
                    return true;
                }
            }
        } else {
            while (zzfwd.hasNext()) {
                if (obj.equals(zzfwd.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean zze(@CheckForNull Object obj) {
        return zzfwi.zzb(this, obj);
    }
}
