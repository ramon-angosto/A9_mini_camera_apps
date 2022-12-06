package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbna extends zzarz implements zzbnc {
    zzbna(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zze(zzbmt zzbmt) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbmt);
        zzbl(1, zza);
    }
}
