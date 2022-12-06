package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbpl implements zzbpu {
    zzbpl() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        if (zzcmp.zzL() != null) {
            zzcmp.zzL().zza();
        }
        zzl zzN = zzcmp.zzN();
        if (zzN != null) {
            zzN.zzb();
            return;
        }
        zzl zzO = zzcmp.zzO();
        if (zzO != null) {
            zzO.zzb();
        } else {
            zze.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
