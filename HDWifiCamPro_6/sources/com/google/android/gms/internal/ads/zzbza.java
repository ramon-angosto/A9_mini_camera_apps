package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbza extends zzarz implements zzbzc {
    zzbza(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final boolean zzE() throws RemoteException {
        Parcel zzbk = zzbk(11, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    public final void zzg(int i, int i2, Intent intent) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zzasb.zze(zza, intent);
        zzbl(12, zza);
    }

    public final void zzh() throws RemoteException {
        zzbl(10, zza());
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(13, zza);
    }

    public final void zzk(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, bundle);
        zzbl(1, zza);
    }

    public final void zzl() throws RemoteException {
        zzbl(8, zza());
    }

    public final void zzn() throws RemoteException {
        zzbl(5, zza());
    }

    public final void zzo() throws RemoteException {
        zzbl(2, zza());
    }

    public final void zzp() throws RemoteException {
        zzbl(4, zza());
    }

    public final void zzq(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, bundle);
        Parcel zzbk = zzbk(6, zza);
        if (zzbk.readInt() != 0) {
            bundle.readFromParcel(zzbk);
        }
        zzbk.recycle();
    }

    public final void zzr() throws RemoteException {
        zzbl(3, zza());
    }

    public final void zzs() throws RemoteException {
        zzbl(7, zza());
    }

    public final void zzt() throws RemoteException {
        zzbl(14, zza());
    }

    public final void zzv() throws RemoteException {
        zzbl(9, zza());
    }
}
