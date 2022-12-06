package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfbe implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzfbe(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
    }

    /* renamed from: zza */
    public final zzfaz zzb() {
        zzcfs zzcfs;
        Context context = (Context) this.zza.zzb();
        zzffm zzffm = (zzffm) this.zzb.zzb();
        zzfge zzfge = (zzfge) this.zzc.zzb();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfu)).booleanValue()) {
            zzcfs = zzt.zzo().zzh().zzh();
        } else {
            zzcfs = zzt.zzo().zzh().zzi();
        }
        boolean z = false;
        if (zzcfs != null && zzcfs.zzh()) {
            z = true;
        }
        if (((Integer) zzay.zzc().zzb(zzbjc.zzfw)).intValue() > 0) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzft)).booleanValue() || z) {
                zzfgd zza2 = zzfge.zza(zzffu.Rewarded, context, zzffm, new zzfad(new zzfaa()));
                return new zzfaf(new zzfap(new zzfao()), new zzfal(zza2.zza, zzchc.zza), zza2.zzb, zza2.zza.zza().zzf, zzchc.zza);
            }
        }
        return new zzfao();
    }
}
