package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdps implements zzbpu {
    public final /* synthetic */ zzdpt zza;
    public final /* synthetic */ zzbny zzb;

    public /* synthetic */ zzdps(zzdpt zzdpt, zzbny zzbny) {
        this.zza = zzdpt;
        this.zzb = zzbny;
    }

    public final void zza(Object obj, Map map) {
        zzdpt zzdpt = this.zza;
        zzbny zzbny = this.zzb;
        try {
            zzdpt.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zze.zzg("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzdpt.zza = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzbny == null) {
            zze.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzbny.zzf(str);
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }
}
