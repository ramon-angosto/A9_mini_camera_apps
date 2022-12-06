package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbnj extends zzarz implements zzbnl {
    zzbnj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zze(zzbmy zzbmy) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbmy);
        zzbl(1, zza);
    }
}
