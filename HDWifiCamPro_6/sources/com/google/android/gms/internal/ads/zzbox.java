package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbox implements zzbpu {
    public final /* synthetic */ zzdkn zza;

    public /* synthetic */ zzbox(zzdkn zzdkn) {
        this.zza = zzdkn;
    }

    public final void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        zzbpt.zzd(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zze.zzj("URL missing from click GMSG.");
        } else {
            zzfzg.zzr(zzbpt.zzb(zzcmp, str), new zzbpk(zzcmp), zzchc.zza);
        }
    }
}
