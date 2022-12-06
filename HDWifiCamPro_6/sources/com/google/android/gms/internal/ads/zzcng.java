package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcng implements zzbpu {
    final /* synthetic */ zzcni zza;

    zzcng(zzcni zzcni) {
        this.zza = zzcni;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        zzcni zzcni = this.zza;
                        if (zzcni.zzG != parseInt) {
                            zzcni.zzG = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zze.zzk("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
