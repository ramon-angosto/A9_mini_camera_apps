package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdcw implements zzgxi {
    private final zzdcv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;

    public zzdcw(zzdcv zzdcv, zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4) {
        this.zza = zzdcv;
        this.zzb = zzgxv;
        this.zzc = zzgxv2;
        this.zzd = zzgxv3;
        this.zze = zzgxv4;
    }

    public final /* synthetic */ Object zzb() {
        Context context = (Context) this.zzb.zzb();
        zzcgv zza2 = ((zzcpc) this.zzc).zza();
        zzfdk zza3 = ((zzczu) this.zzd).zza();
        zzcdm zzcdm = new zzcdm();
        if (zza3.zzB != null) {
            return new zzcdl(context, zza2, zza3.zzB, zza3.zzt.zzb, zzcdm, (byte[]) null);
        }
        return null;
    }
}
