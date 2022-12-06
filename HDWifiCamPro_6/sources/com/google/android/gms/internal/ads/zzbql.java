package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbql implements zzbpu {
    private final zzbqk zza;

    public zzbql(zzbqk zzbqk) {
        this.zza = zzbqk;
    }

    public static void zzb(zzcmp zzcmp, zzbqk zzbqk) {
        zzcmp.zzaf("/reward", new zzbql(zzbqk));
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zzcce zzcce = null;
            try {
                int parseInt = Integer.parseInt((String) map.get(RewardPlus.AMOUNT));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzcce = new zzcce(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zze.zzk("Unable to parse reward amount.", e);
            }
            this.zza.zza(zzcce);
        } else if ("video_start".equals(str)) {
            this.zza.zzc();
        } else if ("video_complete".equals(str)) {
            this.zza.zzb();
        }
    }
}
