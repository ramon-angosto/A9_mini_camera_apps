package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeiv implements zzehc {
    /* access modifiers changed from: private */
    public final zzcxz zza;
    private final zzeic zzb;
    private final zzfzq zzc;
    /* access modifiers changed from: private */
    public final zzddc zzd;
    private final ScheduledExecutorService zze;

    public zzeiv(zzcxz zzcxz, zzeic zzeic, zzddc zzddc, ScheduledExecutorService scheduledExecutorService, zzfzq zzfzq) {
        this.zza = zzcxz;
        this.zzb = zzeic;
        this.zzd = zzddc;
        this.zze = scheduledExecutorService;
        this.zzc = zzfzq;
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        return this.zzc.zzb(new zzeis(this, zzfdw, zzfdk));
    }

    public final boolean zzb(zzfdw zzfdw, zzfdk zzfdk) {
        return zzfdw.zza.zza.zza() != null && this.zzb.zzb(zzfdw, zzfdk);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcxc zzc(zzfdw zzfdw, zzfdk zzfdk) throws Exception {
        return this.zza.zzb(new zzczt(zzfdw, zzfdk, (String) null), new zzcym(zzfdw.zza.zza.zza(), new zzeit(this, zzfdw, zzfdk))).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzfdw zzfdw, zzfdk zzfdk) {
        zzfzg.zzr(zzfzg.zzo(this.zzb.zza(zzfdw, zzfdk), (long) zzfdk.zzS, TimeUnit.SECONDS, this.zze), new zzeiu(this), this.zzc);
    }
}
