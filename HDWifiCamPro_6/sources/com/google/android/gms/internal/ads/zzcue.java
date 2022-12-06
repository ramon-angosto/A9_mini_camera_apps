package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcue implements zzctw {
    private final zzeak zza;

    zzcue(zzeak zzeak) {
        this.zza = zzeak;
    }

    public final void zza(Map map) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhU)).booleanValue()) {
            String str = (String) map.get("policy_violations");
            if (!TextUtils.isEmpty(str)) {
                this.zza.zzl(str);
            }
        }
    }
}
