package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzfui extends zzful implements Serializable {
    /* access modifiers changed from: private */
    public final transient Map zza;
    private transient int zzb;

    protected zzfui(Map map) {
        zzfsx.zze(map.isEmpty());
        this.zza = map;
    }

    static /* synthetic */ int zzd(zzfui zzfui) {
        int i = zzfui.zzb;
        zzfui.zzb = i + 1;
        return i;
    }

    static /* synthetic */ int zze(zzfui zzfui) {
        int i = zzfui.zzb;
        zzfui.zzb = i - 1;
        return i;
    }

    static /* synthetic */ int zzf(zzfui zzfui, int i) {
        int i2 = zzfui.zzb + i;
        zzfui.zzb = i2;
        return i2;
    }

    static /* synthetic */ int zzg(zzfui zzfui, int i) {
        int i2 = zzfui.zzb - i;
        zzfui.zzb = i2;
        return i2;
    }

    static /* synthetic */ void zzq(zzfui zzfui, Object obj) {
        Object obj2;
        try {
            obj2 = zzfui.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzfui.zzb -= size;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract Collection zza();

    /* access modifiers changed from: package-private */
    public Collection zzb(Collection collection) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public Collection zzc(Object obj, Collection collection) {
        throw null;
    }

    public final int zzh() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Collection zzi() {
        return new zzfuk(this);
    }

    /* access modifiers changed from: package-private */
    public final Iterator zzj() {
        return new zzfts(this);
    }

    /* access modifiers changed from: package-private */
    public final List zzk(Object obj, List list, @CheckForNull zzfuf zzfuf) {
        if (list instanceof RandomAccess) {
            return new zzfub(this, obj, list, zzfuf);
        }
        return new zzfuh(this, obj, list, zzfuf);
    }

    /* access modifiers changed from: package-private */
    public Map zzm() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final Map zzn() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzftz(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzfuc(this, (SortedMap) map);
        }
        return new zzftv(this, map);
    }

    /* access modifiers changed from: package-private */
    public Set zzo() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final Set zzp() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfua(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzfud(this, (SortedMap) map);
        }
        return new zzfty(this, map);
    }

    public final void zzr() {
        for (Collection clear : this.zza.values()) {
            clear.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final boolean zzs(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection == null) {
            Collection zza2 = zza();
            if (zza2.add(obj2)) {
                this.zzb++;
                this.zza.put(obj, zza2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(obj2)) {
            return false;
        } else {
            this.zzb++;
            return true;
        }
    }
}
