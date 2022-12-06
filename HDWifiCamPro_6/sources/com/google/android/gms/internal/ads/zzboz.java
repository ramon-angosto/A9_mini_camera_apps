package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzboz implements zzbpu {
    public static final /* synthetic */ zzboz zza = new zzboz();

    private /* synthetic */ zzboz() {
    }

    public final void zza(Object obj, Map map) {
        zzcnq zzcnq = (zzcnq) obj;
        zzbpu zzbpu = zzbpt.zza;
        String str = (String) map.get("u");
        if (str == null) {
            zze.zzj("URL missing from httpTrack GMSG.");
        } else {
            new zzby(zzcnq.getContext(), ((zzcny) zzcnq).zzp().zza, str).zzb();
        }
    }
}
