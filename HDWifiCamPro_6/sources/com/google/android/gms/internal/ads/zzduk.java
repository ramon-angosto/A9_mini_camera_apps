package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzduk implements zzgxi {
    private final zzgxv zza;

    public zzduk(zzgxv zzgxv) {
        this.zza = zzgxv;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbez zzbez;
        if (((zzdcr) this.zza).zza().zzo.zza == 3) {
            zzbez = zzbez.REWARDED_INTERSTITIAL;
        } else {
            zzbez = zzbez.REWARD_BASED_VIDEO_AD;
        }
        zzgxq.zzb(zzbez);
        return zzbez;
    }
}
