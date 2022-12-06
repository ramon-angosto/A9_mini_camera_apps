package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdsy implements zzbpu {
    private final zzbni zza;
    private final zzdtn zzb;
    private final zzgxc zzc;

    public zzdsy(zzdpb zzdpb, zzdoq zzdoq, zzdtn zzdtn, zzgxc zzgxc) {
        this.zza = zzdpb.zzc(zzdoq.zzy());
        this.zzb = zzdtn;
        this.zzc = zzgxc;
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbmy) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            zze.zzk("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    public final void zzb() {
        if (this.zza != null) {
            this.zzb.zzi("/nativeAdCustomClick", this);
        }
    }
}
