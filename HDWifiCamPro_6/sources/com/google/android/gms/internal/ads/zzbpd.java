package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbpd implements zzbpu {
    zzbpd() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzcmp zzcmp = (zzcmp) obj;
        zzblr zzM = zzcmp.zzM();
        if (zzM == null || (zza = zzM.zza()) == null) {
            zzcmp.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcmp.zze("nativeAdViewSignalsReady", zza);
        }
    }
}
