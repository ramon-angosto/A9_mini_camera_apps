package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzboy implements zzbpu {
    public static final /* synthetic */ zzboy zza = new zzboy();

    private /* synthetic */ zzboy() {
    }

    public final void zza(Object obj, Map map) {
        zzcnx zzcnx = (zzcnx) obj;
        zzbpu zzbpu = zzbpt.zza;
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzape zzK = zzcnx.zzK();
            if (zzK != null) {
                zzK.zzc().zzl(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zze.zzj("Could not parse touch parameters from gmsg.");
        }
    }
}
