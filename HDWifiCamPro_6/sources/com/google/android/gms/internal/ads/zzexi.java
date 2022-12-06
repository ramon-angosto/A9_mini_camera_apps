package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzexi {
    private final zzcbc zza;
    private final int zzb;

    public zzexi(zzcbc zzcbc, int i) {
        this.zza = zzcbc;
        this.zzb = i;
    }

    public final int zza() {
        return this.zzb;
    }

    public final PackageInfo zzb() {
        return this.zza.zzf;
    }

    public final String zzc() {
        return this.zza.zzd;
    }

    public final String zzd() {
        return this.zza.zza.getString("ms");
    }

    public final String zze() {
        return this.zza.zzh;
    }

    public final List zzf() {
        return this.zza.zze;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return this.zza.zza.getBoolean("is_gbid");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh() {
        return this.zza.zzk;
    }
}
