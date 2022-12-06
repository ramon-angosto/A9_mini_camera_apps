package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfri extends zzarz implements zzfrk {
    zzfri(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    public final void zze(Bundle bundle, zzfrm zzfrm) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, bundle);
        zzasb.zzg(zza, zzfrm);
        zzbm(2, zza);
    }

    public final void zzf(String str, Bundle bundle, zzfrm zzfrm) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzasb.zze(zza, bundle);
        zzasb.zzg(zza, zzfrm);
        zzbm(1, zza);
    }

    public final void zzg(Bundle bundle, zzfrm zzfrm) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, bundle);
        zzasb.zzg(zza, zzfrm);
        zzbm(3, zza);
    }
}
