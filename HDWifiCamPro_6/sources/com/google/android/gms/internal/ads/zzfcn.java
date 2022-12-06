package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfcn extends zzfmr implements zzdeo, zzddd, zzdda, zzddq, zzdfl, zzfaw, zzdkn {
    private final zzffm zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();

    public zzfcn(zzffm zzffm) {
        this.zza = zzffm;
    }

    public final void zza(zze zze2) {
        int i = zze2.zza;
        zzfan.zza(this.zzc, new zzfbt(zze2));
        zzfan.zza(this.zzc, new zzfbu(i));
        zzfan.zza(this.zze, new zzfbv(i));
    }

    public final void zzb(zzfmr zzfmr) {
        this.zzb.set(zzfmr);
    }

    public final void zzbL(zzfaw zzfaw) {
        throw null;
    }

    public final void zzbv() {
        zzfan.zza(this.zze, zzfby.zza);
    }

    public final void zzc(zzde zzde) {
        this.zzh.set(zzde);
    }

    public final void zzd(zzcco zzcco) {
        this.zzd.set(zzcco);
    }

    public final void zze(zzccs zzccs) {
        this.zzc.set(zzccs);
    }

    @Deprecated
    public final void zzf(zzcby zzcby) {
        this.zze.set(zzcby);
    }

    public final void zzg(zzs zzs) {
        zzfan.zza(this.zzh, new zzfbs(zzs));
    }

    @Deprecated
    public final void zzh(zzcbt zzcbt) {
        this.zzg.set(zzcbt);
    }

    public final void zzi(zzcct zzcct) {
        this.zzf.set(zzcct);
    }

    public final void zzj() {
        this.zza.zza();
        zzfan.zza(this.zzd, zzfbz.zza);
        zzfan.zza(this.zze, zzfca.zza);
    }

    public final void zzk(zze zze2) {
        zzfan.zza(this.zzd, new zzfbw(zze2));
        zzfan.zza(this.zzd, new zzfbx(zze2));
    }

    public final void zzm() {
        zzfan.zza(this.zze, zzfci.zza);
    }

    public final void zzn() {
        zzfan.zza(this.zzc, zzfcf.zza);
        zzfan.zza(this.zze, zzfcg.zza);
    }

    public final void zzo() {
        zzfan.zza(this.zzd, zzfcb.zza);
        zzfan.zza(this.zze, zzfcd.zza);
        zzfan.zza(this.zzd, zzfce.zza);
    }

    public final void zzp(zzcbs zzcbs, String str, String str2) {
        zzfan.zza(this.zzd, new zzfcj(zzcbs));
        zzfan.zza(this.zzf, new zzfck(zzcbs, str, str2));
        zzfan.zza(this.zze, new zzfcl(zzcbs));
        zzfan.zza(this.zzg, new zzfcm(zzcbs, str, str2));
    }

    public final void zzq() {
        zzfan.zza(this.zzd, zzfbr.zza);
    }

    public final void zzr() {
        zzfan.zza(this.zze, zzfcc.zza);
    }

    public final void zzv() {
        zzfan.zza(this.zzb, zzfch.zza);
    }
}
