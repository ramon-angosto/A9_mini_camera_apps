package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbdb implements Comparator {
    public zzbdb(zzbdc zzbdc) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbcq zzbcq = (zzbcq) obj;
        zzbcq zzbcq2 = (zzbcq) obj2;
        if (zzbcq.zzd() >= zzbcq2.zzd()) {
            if (zzbcq.zzd() > zzbcq2.zzd()) {
                return 1;
            }
            if (zzbcq.zzb() >= zzbcq2.zzb()) {
                if (zzbcq.zzb() > zzbcq2.zzb()) {
                    return 1;
                }
                float zza = (zzbcq.zza() - zzbcq.zzd()) * (zzbcq.zzc() - zzbcq.zzb());
                float zza2 = (zzbcq2.zza() - zzbcq2.zzd()) * (zzbcq2.zzc() - zzbcq2.zzb());
                if (zza <= zza2) {
                    if (zza < zza2) {
                        return 1;
                    }
                    return 0;
                }
            }
        }
        return -1;
    }
}
