package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzq;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzehu implements zzehc {
    private final zzcwf zza;
    private final Context zzb;
    private final zzduy zzc;
    private final Executor zzd;

    public zzehu(zzcwf zzcwf, Context context, Executor executor, zzduy zzduy) {
        this.zzb = context;
        this.zza = zzcwf;
        this.zzd = executor;
        this.zzc = zzduy;
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        return zzfzg.zzn(zzfzg.zzi((Object) null), new zzehr(this, zzfdw, zzfdk), this.zzd);
    }

    public final boolean zzb(zzfdw zzfdw, zzfdk zzfdk) {
        zzfdp zzfdp = zzfdk.zzt;
        return (zzfdp == null || zzfdp.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(zzfdw zzfdw, zzfdk zzfdk, Object obj) throws Exception {
        zzq zza2 = zzfej.zza(this.zzb, zzfdk.zzv);
        zzcmp zza3 = this.zzc.zza(zza2, zzfdk, zzfdw.zzb.zzb);
        zzcvx zza4 = this.zza.zza(new zzczt(zzfdw, zzfdk, (String) null), new zzcvy((View) zza3, zza3, zzfej.zzc(zza2), zzfdk.zzab, zzfdk.zzaf, zzfdk.zzP));
        zza4.zzg().zzi(zza3, false, (zzbpx) null);
        zza4.zzc().zzj(new zzehs(zza3), zzchc.zzf);
        zza4.zzg();
        zzfdp zzfdp = zzfdk.zzt;
        return zzfzg.zzm(zzdux.zzj(zza3, zzfdp.zzb, zzfdp.zza), new zzeht(zza4), zzchc.zzf);
    }
}
