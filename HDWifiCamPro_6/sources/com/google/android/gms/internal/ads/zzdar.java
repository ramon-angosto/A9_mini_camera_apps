package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdar implements zzdeo, zza, zzdfv, zzddu, zzdda, zzdig {
    private final Clock zza;
    private final zzcfr zzb;

    public zzdar(Clock clock, zzcfr zzcfr) {
        this.zza = clock;
        this.zzb = zzcfr;
    }

    public final void onAdClicked() {
        this.zzb.zzd();
    }

    public final void zzb(zzfdw zzfdw) {
        this.zzb.zzk(this.zza.elapsedRealtime());
    }

    public final void zzbE(zzcbc zzcbc) {
    }

    public final void zzbv() {
    }

    public final String zzc() {
        return this.zzb.zzc();
    }

    public final void zzd() {
    }

    public final void zze(zzbfk zzbfk) {
        this.zzb.zzi();
    }

    public final void zzf(zzbfk zzbfk) {
    }

    public final void zzg(zzl zzl) {
        this.zzb.zzj(zzl);
    }

    public final void zzh(boolean z) {
    }

    public final void zzi(zzbfk zzbfk) {
        this.zzb.zzg();
    }

    public final void zzj() {
        this.zzb.zze();
    }

    public final void zzk(boolean z) {
    }

    public final void zzl() {
        this.zzb.zzf();
    }

    public final void zzm() {
    }

    public final void zzn() {
        this.zzb.zzh(true);
    }

    public final void zzo() {
    }

    public final void zzp(zzcbs zzcbs, String str, String str2) {
    }

    public final void zzr() {
    }
}
