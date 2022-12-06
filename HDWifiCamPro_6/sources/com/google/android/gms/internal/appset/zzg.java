package com.google.android.gms.internal.appset;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.appset.zza;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final class zzg extends zza implements IInterface {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appset.internal.IAppSetService");
    }

    public final void zzc(zza zza, zzf zzf) throws RemoteException {
        Parcel zza2 = zza();
        zzc.zzb(zza2, zza);
        zzc.zzc(zza2, zzf);
        zzb(1, zza2);
    }
}
