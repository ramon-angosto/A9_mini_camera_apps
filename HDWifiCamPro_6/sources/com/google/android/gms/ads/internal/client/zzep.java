package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzep implements Runnable {
    final /* synthetic */ zzeq zza;

    zzep(zzeq zzeq) {
        this.zza = zzeq;
    }

    public final void run() {
        zzeq zzeq = this.zza;
        if (zzeq.zza != null) {
            try {
                zzeq.zza.zze(1);
            } catch (RemoteException e) {
                zzcgp.zzk("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
