package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxg implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzdxg(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdxt zzdxt = (zzdxt) this.zza.zzb();
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        return ((Boolean) zzay.zzc().zzb(zzbjc.zzhs)).booleanValue() ? new zzdkg((zzefb) this.zzc.zzb(), zzfzq) : new zzdkg(zzdxt, zzfzq);
    }
}
