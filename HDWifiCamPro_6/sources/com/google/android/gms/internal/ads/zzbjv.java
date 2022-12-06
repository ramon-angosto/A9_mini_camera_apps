package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbjv extends zzarz implements zzbjx {
    zzbjv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zze(zzbju zzbju) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbju);
        zzbl(1, zza);
    }
}
