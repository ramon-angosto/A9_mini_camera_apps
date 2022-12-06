package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzkq extends zzim implements RandomAccess, zzkr {
    public static final zzkr zza = zzb;
    private static final zzkq zzb = new zzkq(10);
    private final List zzc;

    static {
        zzb.zzb();
    }

    public zzkq() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzjb) {
            return ((zzjb) obj).zzn(zzkk.zzb);
        }
        return zzkk.zzh((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzbS();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zzbS();
        if (collection instanceof zzkr) {
            collection = ((zzkr) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzbS();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzbS();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzbS();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzkj zzd(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzkq(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzkr zze() {
        return zzc() ? new zzmq(this) : this;
    }

    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    /* renamed from: zzg */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzjb) {
            zzjb zzjb = (zzjb) obj;
            String zzn = zzjb.zzn(zzkk.zzb);
            if (zzjb.zzi()) {
                this.zzc.set(i, zzn);
            }
            return zzn;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzkk.zzh(bArr);
        if (zzkk.zzi(bArr)) {
            this.zzc.set(i, zzh);
        }
        return zzh;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzjb zzjb) {
        zzbS();
        this.zzc.add(zzjb);
        this.modCount++;
    }

    public zzkq(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzkq(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
