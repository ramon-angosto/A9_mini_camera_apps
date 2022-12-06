package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdpb {
    public static final zzdpb zza = new zzdpb(new zzdoz());
    private final zzbnf zzb;
    private final zzbnc zzc;
    private final zzbns zzd;
    private final zzbnp zze;
    private final zzbsl zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdpb(zzdoz zzdoz) {
        this.zzb = zzdoz.zza;
        this.zzc = zzdoz.zzb;
        this.zzd = zzdoz.zzc;
        this.zzg = new SimpleArrayMap(zzdoz.zzf);
        this.zzh = new SimpleArrayMap(zzdoz.zzg);
        this.zze = zzdoz.zzd;
        this.zzf = zzdoz.zze;
    }

    public final zzbnc zza() {
        return this.zzc;
    }

    public final zzbnf zzb() {
        return this.zzb;
    }

    public final zzbni zzc(String str) {
        return (zzbni) this.zzh.get(str);
    }

    public final zzbnl zzd(String str) {
        return (zzbnl) this.zzg.get(str);
    }

    public final zzbnp zze() {
        return this.zze;
    }

    public final zzbns zzf() {
        return this.zzd;
    }

    public final zzbsl zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.size());
        for (int i = 0; i < this.zzg.size(); i++) {
            arrayList.add((String) this.zzg.keyAt(i));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }
}
