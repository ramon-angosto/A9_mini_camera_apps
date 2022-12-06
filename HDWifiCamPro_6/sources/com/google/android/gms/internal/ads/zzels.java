package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzels implements zzehj {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzduh zzc;

    public zzels(Context context, Executor executor, zzduh zzduh) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzduh;
    }

    /* access modifiers changed from: private */
    public static final void zze(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) {
        try {
            ((zzffa) zzehf.zzb).zzk(zzfdw.zza.zza.zzd, zzfdk.zzw.toString());
        } catch (Exception e) {
            zze.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzehf.zza)), e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek, zzekr {
        zzdud zze = this.zzc.zze(new zzczt(zzfdw, zzfdk, zzehf.zza), new zzdue(new zzelo(zzehf)));
        zze.zzd().zzj(new zzcuq((zzffa) zzehf.zzb), this.zzb);
        zzdeh zze2 = zze.zze();
        zzdcy zzb2 = zze.zzb();
        ((zzeiy) zzehf.zzc).zzc(new zzelr(this, zze.zza(), zzb2, zze2, zze.zzg()));
        return zze.zzk();
    }

    public final void zzb(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek {
        if (!((zzffa) zzehf.zzb).zzA()) {
            ((zzeiy) zzehf.zzc).zzd(new zzelq(this, zzfdw, zzfdk, zzehf));
            ((zzffa) zzehf.zzb).zzh(this.zza, zzfdw.zza.zza.zzd, (String) null, (zzccd) zzehf.zzc, zzfdk.zzw.toString());
            return;
        }
        zze(zzfdw, zzfdk, zzehf);
    }
}
