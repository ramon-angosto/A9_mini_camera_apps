package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbqg implements zzbpu {
    private final zzebe zza;

    public zzbqg(zzebe zzebe) {
        this.zza = zzebe;
    }

    public final void zza(Object obj, Map map) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzia)).booleanValue()) {
            String str = (String) map.get("action");
            String str2 = (String) map.get("adUnitId");
            String str3 = (String) map.get("redirectUrl");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                String str4 = (String) map.get("format");
                if (str.equals("load") && !TextUtils.isEmpty(str4)) {
                    this.zza.zzf(str2, str4, str3);
                } else if (str.equals("show")) {
                    this.zza.zzg(str2, str3);
                }
            }
        }
    }
}
