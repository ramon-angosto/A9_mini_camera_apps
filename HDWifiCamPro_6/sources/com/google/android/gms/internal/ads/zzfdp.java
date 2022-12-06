package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbu;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfdp {
    public final String zza = this.zzd.optString(CampaignEx.JSON_KEY_AD_HTML, (String) null);
    public final String zzb = this.zzd.optString("ad_base_url", (String) null);
    public final JSONObject zzc = this.zzd.optJSONObject("ad_json");
    public final JSONObject zzd;

    zzfdp(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        this.zzd = zzbu.zzh(jsonReader);
    }
}
