package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfem implements zzbpu {
    public final /* synthetic */ zzdkn zza;
    public final /* synthetic */ zzfkm zzb;
    public final /* synthetic */ zzego zzc;

    public /* synthetic */ zzfem(zzdkn zzdkn, zzfkm zzfkm, zzego zzego) {
        this.zza = zzdkn;
        this.zzb = zzfkm;
        this.zzc = zzego;
    }

    public final void zza(Object obj, Map map) {
        zzdkn zzdkn = this.zza;
        zzfkm zzfkm = this.zzb;
        zzego zzego = this.zzc;
        zzcmp zzcmp = (zzcmp) obj;
        zzbpt.zzd(map, zzdkn);
        String str = (String) map.get("u");
        if (str == null) {
            zze.zzj("URL missing from click GMSG.");
        } else {
            zzfzg.zzr(zzbpt.zzb(zzcmp, str), new zzfen(zzcmp, zzfkm, zzego), zzchc.zza);
        }
    }
}
