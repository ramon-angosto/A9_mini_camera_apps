package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbnq extends zzarz implements zzbns {
    zzbnq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zze(zzbob zzbob) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbob);
        zzbl(1, zza);
    }
}
