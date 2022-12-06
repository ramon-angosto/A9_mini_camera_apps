package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzev implements Runnable {
    public final /* synthetic */ zzccs zza;

    public /* synthetic */ zzev(zzccs zzccs) {
        this.zza = zzccs;
    }

    public final void run() {
        zzccs zzccs = this.zza;
        if (zzccs != null) {
            try {
                zzccs.zze(1);
            } catch (RemoteException e) {
                zzcgp.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
