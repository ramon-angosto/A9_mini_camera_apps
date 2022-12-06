package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeje implements zzehc {
    private final Context zza;
    private final zzduy zzb;
    private final zzdmh zzc;
    private final zzfef zzd;
    private final Executor zze;
    private final zzcgv zzf;
    private final zzbpx zzg;
    private final boolean zzh = ((Boolean) zzay.zzc().zzb(zzbjc.zzhD)).booleanValue();

    public zzeje(Context context, zzcgv zzcgv, zzfef zzfef, Executor executor, zzdmh zzdmh, zzduy zzduy, zzbpx zzbpx) {
        this.zza = context;
        this.zzd = zzfef;
        this.zzc = zzdmh;
        this.zze = executor;
        this.zzf = zzcgv;
        this.zzb = zzduy;
        this.zzg = zzbpx;
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        zzdvc zzdvc = new zzdvc();
        zzfzp zzn = zzfzg.zzn(zzfzg.zzi((Object) null), new zzeiz(this, zzfdk, zzfdw, zzdvc), this.zze);
        zzn.zzc(new zzeja(zzdvc), this.zze);
        return zzn;
    }

    public final boolean zzb(zzfdw zzfdw, zzfdk zzfdk) {
        zzfdp zzfdp = zzfdk.zzt;
        return (zzfdp == null || zzfdp.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(zzfdk zzfdk, zzfdw zzfdw, zzdvc zzdvc, Object obj) throws Exception {
        zzfdk zzfdk2 = zzfdk;
        zzfdw zzfdw2 = zzfdw;
        zzcmp zza2 = this.zzb.zza(this.zzd.zze, zzfdk2, zzfdw2.zzb.zzb);
        zza2.zzab(zzfdk2.zzX);
        zzdvc.zza(this.zza, (View) zza2);
        zzchh zzchh = new zzchh();
        zzdmh zzdmh = this.zzc;
        zzczt zzczt = new zzczt(zzfdw2, zzfdk2, (String) null);
        zzejd zzejd = r1;
        zzejd zzejd2 = new zzejd(this.zza, this.zzf, zzchh, zzfdk, zza2, this.zzd, this.zzh, this.zzg);
        zzdlh zze2 = zzdmh.zze(zzczt, new zzdlk(zzejd, zza2));
        zzchh.zzd(zze2);
        zze2.zzc().zzj(new zzejb(zza2), zzchc.zzf);
        zze2.zzk().zzi(zza2, true, this.zzh ? this.zzg : null);
        zze2.zzk();
        zzfdk zzfdk3 = zzfdk;
        zzfdp zzfdp = zzfdk3.zzt;
        return zzfzg.zzm(zzdux.zzj(zza2, zzfdp.zzb, zzfdp.zza), new zzejc(this, zza2, zzfdk3, zze2), this.zze);
    }
}
