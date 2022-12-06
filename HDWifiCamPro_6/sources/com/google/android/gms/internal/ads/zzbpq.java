package com.google.android.gms.internal.ads;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbpq implements zzbpu {
    zzbpq() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        String str = (String) map.get("action");
        if (CampaignEx.JSON_NATIVE_VIDEO_PAUSE.equals(str)) {
            zzcmp.zzbn();
        } else if (CampaignEx.JSON_NATIVE_VIDEO_RESUME.equals(str)) {
            zzcmp.zzbo();
        }
    }
}
