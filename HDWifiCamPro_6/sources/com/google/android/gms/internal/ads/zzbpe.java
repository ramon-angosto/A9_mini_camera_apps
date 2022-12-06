package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbpe implements zzbpu {
    zzbpe() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzb;
        zzcmp zzcmp = (zzcmp) obj;
        zzblr zzM = zzcmp.zzM();
        if (zzM == null || (zzb = zzM.zzb()) == null) {
            zzcmp.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcmp.zze("nativeClickMetaReady", zzb);
        }
    }
}
