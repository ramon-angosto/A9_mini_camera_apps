package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbpw implements zzbpu {
    private final zzbpx zza;

    public zzbpw(zzbpx zzbpx, byte[] bArr) {
        this.zza = zzbpx;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            zze.zzh("Fail to parse float", e);
        }
        this.zza.zzc(equals);
        this.zza.zzb(equals2, f);
        zzcmp.zzav(equals);
    }
}
