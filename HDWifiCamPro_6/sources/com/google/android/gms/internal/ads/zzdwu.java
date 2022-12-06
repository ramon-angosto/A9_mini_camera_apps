package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdwu implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;

    public zzdwu(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        String zza2 = ((zzexn) this.zza).zza();
        Context zza3 = ((zzcos) this.zzb).zza();
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        Map zzd2 = ((zzgxm) this.zzd).zzb();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzea)).booleanValue()) {
            zzbep zzbep = new zzbep(new zzbev(zza3));
            zzbep.zzb(new zzdwv(zza2));
            set = Collections.singleton(new zzdkg(new zzdwx(zzbep, zzd2), zzfzq));
        } else {
            set = Collections.emptySet();
        }
        zzgxq.zzb(set);
        return set;
    }
}
