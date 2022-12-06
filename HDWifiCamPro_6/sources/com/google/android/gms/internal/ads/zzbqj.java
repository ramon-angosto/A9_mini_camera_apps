package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbqj implements zzbpu {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    public final void zza(Object obj, Map map) {
        String str;
        String str2 = (String) map.get("id");
        String str3 = (String) map.get("fail");
        String str4 = (String) map.get("fail_reason");
        String str5 = (String) map.get("fail_stack");
        String str6 = (String) map.get(IronSourceConstants.EVENTS_RESULT);
        if (true == TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            str = "\n".concat(String.valueOf(str5));
        }
        synchronized (this.zza) {
            zzbqi zzbqi = (zzbqi) this.zzb.remove(str2);
            if (zzbqi == null) {
                zze.zzj("Received result for unexpected method invocation: " + str2);
            } else if (!TextUtils.isEmpty(str3)) {
                zzbqi.zza(str4 + str);
            } else if (str6 == null) {
                zzbqi.zzb((JSONObject) null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zze.zzc()) {
                        String jSONObject2 = jSONObject.toString(2);
                        zze.zza("Result GMSG: " + jSONObject2);
                    }
                    zzbqi.zzb(jSONObject);
                } catch (JSONException e) {
                    zzbqi.zza(e.getMessage());
                }
            }
        }
    }

    public final zzfzp zzb(zzbta zzbta, String str, JSONObject jSONObject) {
        zzchh zzchh = new zzchh();
        zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        zzc(uuid, new zzbqh(this, zzchh));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", uuid);
            jSONObject2.put("args", jSONObject);
            zzbta.zzl(str, jSONObject2);
        } catch (Exception e) {
            zzchh.zze(e);
        }
        return zzchh;
    }

    public final void zzc(String str, zzbqi zzbqi) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbqi);
        }
    }
}
