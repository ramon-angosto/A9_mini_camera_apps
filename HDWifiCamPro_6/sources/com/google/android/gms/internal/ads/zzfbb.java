package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfbb {
    static zzfaz zza(Context context, zzffm zzffm, zzfge zzfge) {
        return zzc(context, zzffm, zzfge);
    }

    static zzfaz zzb(Context context, zzffm zzffm, zzfge zzfge) {
        return zzc(context, zzffm, zzfge);
    }

    private static zzfaz zzc(Context context, zzffm zzffm, zzfge zzfge) {
        zzcfs zzcfs;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfu)).booleanValue()) {
            zzcfs = zzt.zzo().zzh().zzh();
        } else {
            zzcfs = zzt.zzo().zzh().zzi();
        }
        boolean z = false;
        if (zzcfs != null && zzcfs.zzh()) {
            z = true;
        }
        if (((Integer) zzay.zzc().zzb(zzbjc.zzfK)).intValue() > 0) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzft)).booleanValue() || z) {
                zzfgd zza = zzfge.zza(zzffu.AppOpen, context, zzffm, new zzfad(new zzfaa()));
                return new zzfaf(new zzfap(new zzfao()), new zzfal(zza.zza, zzchc.zza), zza.zzb, zza.zza.zza().zzf, zzchc.zza);
            }
        }
        return new zzfao();
    }
}
