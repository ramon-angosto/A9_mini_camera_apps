package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdah {
    private final zzecp zza;
    private final zzfef zzb;
    private final zzfih zzc;
    private final zzctu zzd;
    private final zzekt zze;
    /* access modifiers changed from: private */
    public final zzdie zzf;
    private zzfdw zzg;
    private final zzedt zzh;
    private final zzdcg zzi;
    private final Executor zzj;
    private final zzedg zzk;
    private final zzehh zzl;

    zzdah(zzecp zzecp, zzfef zzfef, zzfih zzfih, zzctu zzctu, zzekt zzekt, zzdie zzdie, zzfdw zzfdw, zzedt zzedt, zzdcg zzdcg, Executor executor, zzedg zzedg, zzehh zzehh) {
        this.zza = zzecp;
        this.zzb = zzfef;
        this.zzc = zzfih;
        this.zzd = zzctu;
        this.zze = zzekt;
        this.zzf = zzdie;
        this.zzg = zzfdw;
        this.zzh = zzedt;
        this.zzi = zzdcg;
        this.zzj = executor;
        this.zzk = zzedg;
        this.zzl = zzehh;
    }

    public final zze zza(Throwable th) {
        return zzffe.zzb(th, this.zzl);
    }

    public final zzdie zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfdw zzd(zzfdw zzfdw) throws Exception {
        this.zzd.zza(zzfdw);
        return zzfdw;
    }

    public final zzfzp zze(zzffx zzffx) {
        zzfhm zza2 = this.zzc.zzb(zzfib.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzdae(this, zzffx)).zza();
        zzfzg.zzr(zza2, new zzdaf(this), this.zzj);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzf(zzffx zzffx, zzcbc zzcbc) throws Exception {
        zzcbc.zzi = zzffx;
        return this.zzh.zza(zzcbc);
    }

    public final zzfzp zzg(zzcbc zzcbc) {
        zzfhm zza2 = this.zzc.zzb(zzfib.NOTIFY_CACHE_HIT, this.zzh.zzf(zzcbc)).zza();
        zzfzg.zzr(zza2, new zzdag(this), this.zzj);
        return zza2;
    }

    public final zzfzp zzh(zzfzp zzfzp) {
        zzfhy zzf2 = this.zzc.zzb(zzfib.RENDERER, zzfzp).zze(new zzdad(this)).zzf(this.zze);
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzeD)).booleanValue()) {
            zzf2 = zzf2.zzi((long) ((Integer) zzay.zzc().zzb(zzbjc.zzeE)).intValue(), TimeUnit.SECONDS);
        }
        return zzf2.zza();
    }

    public final zzfzp zzi() {
        zzl zzl2 = this.zzb.zzd;
        if (zzl2.zzx == null && zzl2.zzs == null) {
            return zzj(this.zzi.zzc());
        }
        zzfih zzfih = this.zzc;
        return zzfhr.zzc(this.zza.zza(), zzfib.PRELOADED_LOADER, zzfih).zza();
    }

    public final zzfzp zzj(zzfzp zzfzp) {
        if (this.zzg != null) {
            zzfih zzfih = this.zzc;
            return zzfhr.zzc(zzfzg.zzi(this.zzg), zzfib.SERVER_TRANSACTION, zzfih).zza();
        }
        zzt.zzc().zzj();
        return this.zzc.zzb(zzfib.SERVER_TRANSACTION, zzfzp).zzf(new zzdac(this.zzk)).zza();
    }

    public final void zzk(zzfdw zzfdw) {
        this.zzg = zzfdw;
    }
}
