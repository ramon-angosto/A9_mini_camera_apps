package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdwf implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzdwf(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        zzdwx zza2 = ((zzdwy) this.zzb).zzb();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzea)).booleanValue()) {
            set = Collections.singleton(new zzdkg(zza2, zzfzq));
        } else {
            set = Collections.emptySet();
        }
        zzgxq.zzb(set);
        return set;
    }
}
