package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzevu implements zzevd {
    private final AdvertisingIdClient.Info zza;
    private final String zzb;

    public zzevu(AdvertisingIdClient.Info info, String str) {
        this.zza = info;
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        try {
            JSONObject zzf = zzbu.zzf((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                zzf.put("pdid", this.zzb);
                zzf.put("pdidtype", "ssaid");
                return;
            }
            zzf.put("rdid", this.zza.getId());
            zzf.put("is_lat", this.zza.isLimitAdTrackingEnabled());
            zzf.put("idtype", "adid");
        } catch (JSONException e) {
            zze.zzb("Failed putting Ad ID.", e);
        }
    }
}
