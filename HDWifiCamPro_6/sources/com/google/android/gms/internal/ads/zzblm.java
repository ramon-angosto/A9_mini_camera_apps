package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzblm extends zzarz implements IInterface {
    zzblm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzcam zzcam) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzcam);
        zzbl(1, zza);
    }
}
