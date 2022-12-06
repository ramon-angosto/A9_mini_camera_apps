package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdk;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeij implements zzczc {
    public final /* synthetic */ zzehf zza;

    public /* synthetic */ zzeij(zzehf zzehf) {
        this.zza = zzehf;
    }

    public final zzdk zza() {
        try {
            return ((zzbxd) this.zza.zzb).zze();
        } catch (RemoteException e) {
            throw new zzfek(e);
        }
    }
}
