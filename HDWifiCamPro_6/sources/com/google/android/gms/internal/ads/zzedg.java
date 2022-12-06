package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzedg implements zzedi {
    private final Map zza;
    private final zzfzq zzb;
    /* access modifiers changed from: private */
    public final zzdft zzc;

    public zzedg(Map map, zzfzq zzfzq, zzdft zzdft) {
        this.zza = map;
        this.zzb = zzfzq;
        this.zzc = zzdft;
    }

    public final zzfzp zzb(zzcbc zzcbc) {
        this.zzc.zzbE(zzcbc);
        zzfzp zzh = zzfzg.zzh(new zzebh(3));
        for (String trim : ((String) zzay.zzc().zzb(zzbjc.zzhb)).split(",")) {
            zzgxv zzgxv = (zzgxv) this.zza.get(trim.trim());
            if (zzgxv != null) {
                zzh = zzfzg.zzg(zzh, zzebh.class, new zzede(zzgxv, zzcbc), this.zzb);
            }
        }
        zzfzg.zzr(zzh, new zzedf(this), zzchc.zzf);
        return zzh;
    }
}
