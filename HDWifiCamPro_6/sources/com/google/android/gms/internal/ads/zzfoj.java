package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfoj extends zzarz implements IInterface {
    zzfoj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfoh zze(zzfof zzfof) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzfof);
        Parcel zzbk = zzbk(1, zza);
        zzfoh zzfoh = (zzfoh) zzasb.zza(zzbk, zzfoh.CREATOR);
        zzbk.recycle();
        return zzfoh;
    }

    public final zzfoq zzf(zzfoo zzfoo) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzfoo);
        Parcel zzbk = zzbk(3, zza);
        zzfoq zzfoq = (zzfoq) zzasb.zza(zzbk, zzfoq.CREATOR);
        zzbk.recycle();
        return zzfoq;
    }

    public final void zzg(zzfoc zzfoc) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzfoc);
        zzbl(2, zza);
    }
}
