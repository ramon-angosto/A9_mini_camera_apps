package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbpg implements zzbpu {
    zzbpg() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        if (TextUtils.isEmpty((CharSequence) map.get("appId"))) {
            zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzfrb zzj = zzfrc.zzj();
        zzj.zzb((String) map.get("appId"));
        zzj.zzh(zzcmp.getWidth());
        zzj.zzg(zzcmp.zzH().getWindowToken());
        if (!map.containsKey("gravityX") || !map.containsKey("gravityY")) {
            zzj.zzd(81);
        } else {
            zzj.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        }
        if (map.containsKey("verticalMargin")) {
            zzj.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzj.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzj.zza((String) map.get("enifd"));
        }
        try {
            zzt.zzj().zzj(zzcmp, zzj.zzi());
        } catch (NullPointerException e) {
            zzt.zzo().zzt(e, "DefaultGmsgHandlers.ShowLMDOverlay");
            zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
