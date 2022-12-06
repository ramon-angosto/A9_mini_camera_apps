package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeho implements zzehc {
    private final zzcwq zza;
    private final Context zzb;
    private final zzduy zzc;
    private final zzfef zzd;
    private final Executor zze;
    private final zzcgv zzf;
    private final zzbpx zzg;
    private final boolean zzh = ((Boolean) zzay.zzc().zzb(zzbjc.zzhD)).booleanValue();

    public zzeho(zzcwq zzcwq, Context context, Executor executor, zzduy zzduy, zzfef zzfef, zzcgv zzcgv, zzbpx zzbpx) {
        this.zzb = context;
        this.zza = zzcwq;
        this.zze = executor;
        this.zzc = zzduy;
        this.zzd = zzfef;
        this.zzf = zzcgv;
        this.zzg = zzbpx;
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        zzdvc zzdvc = new zzdvc();
        zzfzp zzn = zzfzg.zzn(zzfzg.zzi((Object) null), new zzehm(this, zzfdk, zzfdw, zzdvc), this.zze);
        zzn.zzc(new zzehn(zzdvc), this.zze);
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
        zzcmp zza2 = this.zzc.zza(this.zzd.zze, zzfdk2, zzfdw2.zzb.zzb);
        zza2.zzab(zzfdk2.zzX);
        zzdvc.zza(this.zzb, (View) zza2);
        zzchh zzchh = new zzchh();
        zzcwq zzcwq = this.zza;
        zzczt zzczt = new zzczt(zzfdw2, zzfdk2, (String) null);
        zzehq zzehq = r1;
        zzehq zzehq2 = new zzehq(this.zzf, zzchh, zzfdk, zza2, this.zzd, this.zzh, this.zzg);
        zzcwn zza3 = zzcwq.zza(zzczt, new zzdlk(zzehq, zza2), new zzcwo(zzfdk2.zzab));
        zza3.zzj().zzi(zza2, false, this.zzh ? this.zzg : null);
        zzchh.zzd(zza3);
        zza3.zzc().zzj(new zzehk(zza2), zzchc.zzf);
        zza3.zzj();
        zzfdp zzfdp = zzfdk2.zzt;
        return zzfzg.zzm(zzdux.zzj(zza2, zzfdp.zzb, zzfdp.zza), new zzehl(this, zza2, zzfdk2, zza3), this.zze);
    }
}
