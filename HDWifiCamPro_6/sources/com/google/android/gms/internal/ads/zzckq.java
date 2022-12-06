package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzckq implements zzbpu {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzciy zzciy = (zzciy) obj;
        zzcnl zzs = zzciy.zzs();
        if (zzs == null) {
            try {
                zzcnl zzcnl = new zzcnl(zzciy, Float.parseFloat((String) map.get(IronSourceConstants.EVENTS_DURATION)), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzciy.zzE(zzcnl);
                zzs = zzcnl;
            } catch (NullPointerException e) {
                e = e;
                zze.zzh("Unable to parse videoMeta message.", e);
                zzt.zzo().zzt(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                zze.zzh("Unable to parse videoMeta message.", e);
                zzt.zzo().zzt(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get(IronSourceConstants.EVENTS_DURATION));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        int i = 0;
        if (parseInt >= 0) {
            if (parseInt <= 3) {
                i = parseInt;
            }
        }
        String str = (String) map.get("aspectRatio");
        float parseFloat3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zze.zzm(3)) {
            zze.zze("Video Meta GMSG: currentTime : " + parseFloat2 + " , duration : " + parseFloat + " , isMuted : " + equals + " , playbackState : " + i + " , aspectRatio : " + str);
        }
        zzs.zzc(parseFloat2, parseFloat, i, equals, parseFloat3);
    }
}
