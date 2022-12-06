package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdmw implements zzczh {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzgxv zzd;
    private final zzdpb zze;

    zzdmw(Map map, Map map2, Map map3, zzgxv zzgxv, zzdpb zzdpb) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzgxv;
        this.zze = zzdpb;
    }

    public final zzehc zza(int i, String str) {
        zzehc zza2;
        zzehc zzehc = (zzehc) this.zza.get(str);
        if (zzehc != null) {
            return zzehc;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzejp zzejp = (zzejp) this.zzc.get(str);
            if (zzejp != null) {
                return new zzehd(zzejp, zzczj.zza);
            }
            zzehc zzehc2 = (zzehc) this.zzb.get(str);
            if (zzehc2 == null) {
                return null;
            }
            return zzczl.zza(zzehc2);
        } else if (this.zze.zze() == null || (zza2 = ((zzczh) this.zzd.zzb()).zza(i, str)) == null) {
            return null;
        } else {
            return zzczl.zza(zza2);
        }
    }
}
