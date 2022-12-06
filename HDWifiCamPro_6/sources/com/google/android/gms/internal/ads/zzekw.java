package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzekw implements zzehj {
    private final Context zza;
    private final Executor zzb;
    private final zzduh zzc;

    public zzekw(Context context, Executor executor, zzduh zzduh) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzduh;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek, zzekr {
        zzdud zze = this.zzc.zze(new zzczt(zzfdw, zzfdk, zzehf.zza), new zzdue(new zzekv(zzehf)));
        zze.zzd().zzj(new zzcuq((zzffa) zzehf.zzb), this.zzb);
        ((zzeix) zzehf.zzc).zzc(zze.zzm());
        return zze.zzk();
    }

    public final void zzb(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek {
        try {
            zzfef zzfef = zzfdw.zza.zza;
            if (zzfef.zzo.zza == 3) {
                ((zzffa) zzehf.zzb).zzq(this.zza, zzfef.zzd, zzfdk.zzw.toString(), (zzbvq) zzehf.zzc);
            } else {
                ((zzffa) zzehf.zzb).zzp(this.zza, zzfef.zzd, zzfdk.zzw.toString(), (zzbvq) zzehf.zzc);
            }
        } catch (Exception e) {
            zze.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzehf.zza)), e);
        }
    }
}
