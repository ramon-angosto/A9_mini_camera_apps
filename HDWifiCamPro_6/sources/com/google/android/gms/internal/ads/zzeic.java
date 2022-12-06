package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzas;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeic implements zzehc {
    private final zzcxz zza;
    private final Context zzb;
    private final zzduy zzc;
    private final zzfef zzd;
    private final Executor zze;
    private final zzfsm zzf;

    public zzeic(zzcxz zzcxz, Context context, Executor executor, zzduy zzduy, zzfef zzfef, zzfsm zzfsm) {
        this.zzb = context;
        this.zza = zzcxz;
        this.zze = executor;
        this.zzc = zzduy;
        this.zzd = zzfef;
        this.zzf = zzfsm;
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        return zzfzg.zzn(zzfzg.zzi((Object) null), new zzehw(this, zzfdw, zzfdk), this.zze);
    }

    public final boolean zzb(zzfdw zzfdw, zzfdk zzfdk) {
        zzfdp zzfdp = zzfdk.zzt;
        return (zzfdp == null || zzfdp.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(zzfdw zzfdw, zzfdk zzfdk, Object obj) throws Exception {
        View view;
        zzq zza2 = zzfej.zza(this.zzb, zzfdk.zzv);
        zzcmp zza3 = this.zzc.zza(zza2, zzfdk, zzfdw.zzb.zzb);
        zza3.zzab(zzfdk.zzX);
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgJ)).booleanValue() || !zzfdk.zzai) {
            view = new zzdvb(this.zzb, (View) zza3, (zzas) this.zzf.apply(zzfdk));
        } else {
            view = zzcyq.zza(this.zzb, (View) zza3, zzfdk);
        }
        zzcxd zza4 = this.zza.zza(new zzczt(zzfdw, zzfdk, (String) null), new zzcxj(view, zza3, new zzehx(zza3), zzfej.zzc(zza2)));
        zza4.zzj().zzi(zza3, false, (zzbpx) null);
        zza4.zzc().zzj(new zzehy(zza3), zzchc.zzf);
        zza4.zzj();
        zzfdp zzfdp = zzfdk.zzt;
        zzfzp zzj = zzdux.zzj(zza3, zzfdp.zzb, zzfdp.zza);
        if (zzfdk.zzN) {
            zzj.zzc(new zzehz(zza3), this.zze);
        }
        zzj.zzc(new zzeia(this, zza3), this.zze);
        return zzfzg.zzm(zzj, new zzeib(zza4), zzchc.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzcmp zzcmp) {
        zzcmp.zzaa();
        zzcnl zzs = zzcmp.zzs();
        zzff zzff = this.zzd.zza;
        if (zzff != null && zzs != null) {
            zzs.zzs(zzff);
        }
    }
}
