package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcow implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzcow(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzeew zzeew = (zzeew) this.zza.zzb();
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbN)).booleanValue()) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzhs)).booleanValue()) {
                set = Collections.singleton(new zzdkg(zzeew, zzfzq));
                zzgxq.zzb(set);
                return set;
            }
        }
        set = Collections.emptySet();
        zzgxq.zzb(set);
        return set;
    }
}
