package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcpl implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzcpl(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    /* renamed from: zza */
    public final zzcbn zzb() {
        Context zza2 = ((zzcos) this.zza).zza();
        zzfjw zzfjw = (zzfjw) this.zzb.zzb();
        zzt.zzf().zzb(zza2, zzcgv.zza(), zzfjw).zza("google.afma.request.getAdDictionary", zzbuh.zza, zzbuh.zza);
        zzbuk zzb2 = zzt.zzf().zzb(zza2, zzcgv.zza(), zzfjw);
        zzbue zzbue = zzbuh.zza;
        return new zzcbm(zza2, zzb2.zza("google.afma.sdkConstants.getSdkConstants", zzbue, zzbue));
    }
}
