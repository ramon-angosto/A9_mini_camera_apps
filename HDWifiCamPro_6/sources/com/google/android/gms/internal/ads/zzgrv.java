package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgrv extends zzgpg implements RandomAccess, zzgrw {
    public static final zzgrw zza = zzb;
    private static final zzgrv zzb = new zzgrv(10);
    private final List zzc;

    static {
        zzb.zzb();
    }

    public zzgrv() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgpw) {
            return ((zzgpw) obj).zzA(zzgro.zzb);
        }
        return zzgro.zzh((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzbM();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zzbM();
        if (collection instanceof zzgrw) {
            collection = ((zzgrw) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzbM();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzbM();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzbM();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzgrn zzd(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzgrv(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzgrw zze() {
        return zzc() ? new zzgud(this) : this;
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
        if (obj instanceof zzgpw) {
            zzgpw zzgpw = (zzgpw) obj;
            String zzA = zzgpw.zzA(zzgro.zzb);
            if (zzgpw.zzp()) {
                this.zzc.set(i, zzA);
            }
            return zzA;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzgro.zzh(bArr);
        if (zzgro.zzi(bArr)) {
            this.zzc.set(i, zzh);
        }
        return zzh;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzgpw zzgpw) {
        zzbM();
        this.zzc.add(zzgpw);
        this.modCount++;
    }

    public zzgrv(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzgrv(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
