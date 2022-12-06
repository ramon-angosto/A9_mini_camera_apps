package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcuo implements zzctw {
    private final zzeak zza;

    zzcuo(zzeak zzeak) {
        this.zza = zzeak;
    }

    public final void zza(Map map) {
        String str = (String) map.get("test_mode_enabled");
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzm(str.equals("true"));
        }
    }
}
