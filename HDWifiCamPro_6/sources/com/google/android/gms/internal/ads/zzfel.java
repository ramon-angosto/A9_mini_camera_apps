package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfel implements zzbpu {
    public final /* synthetic */ zzfkm zza;
    public final /* synthetic */ zzego zzb;

    public /* synthetic */ zzfel(zzfkm zzfkm, zzego zzego) {
        this.zza = zzfkm;
        this.zzb = zzego;
    }

    public final void zza(Object obj, Map map) {
        zzfkm zzfkm = this.zza;
        zzego zzego = this.zzb;
        zzcmg zzcmg = (zzcmg) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zze.zzj("URL missing from httpTrack GMSG.");
        } else if (!zzcmg.zzF().zzak) {
            zzfkm.zzc(str, (zzfju) null);
        } else {
            zzego.zzd(new zzegq(zzt.zzB().currentTimeMillis(), ((zzcnm) zzcmg).zzR().zzb, str, 2));
        }
    }
}
