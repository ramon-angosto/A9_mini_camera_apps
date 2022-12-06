package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzen extends zzbk {
    final /* synthetic */ zzeo zza;

    /* synthetic */ zzen(zzeo zzeo, zzem zzem) {
        this.zza = zzeo;
    }

    public final String zze() throws RemoteException {
        return null;
    }

    public final String zzf() throws RemoteException {
        return null;
    }

    public final void zzg(zzl zzl) throws RemoteException {
        zzh(zzl, 1);
    }

    public final void zzh(zzl zzl, int i) throws RemoteException {
        zzcgp.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzcgi.zza.post(new zzel(this));
    }

    public final boolean zzi() throws RemoteException {
        return false;
    }
}
