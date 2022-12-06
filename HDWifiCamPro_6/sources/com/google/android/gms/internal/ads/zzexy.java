package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzexy implements zzevd {
    private final Map zza;

    public zzexy(Map map) {
        this.zza = map;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzaw.zzb().zzi(this.zza));
        } catch (JSONException e) {
            zze.zza("Could not encode video decoder properties: ".concat(String.valueOf(e.getMessage())));
        }
    }
}
