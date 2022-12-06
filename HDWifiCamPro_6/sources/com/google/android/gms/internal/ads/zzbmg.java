package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbmg extends zzarz implements zzbmi {
    zzbmg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbk = zzbk(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbk.readStrongBinder());
        zzbk.recycle();
        return asInterface;
    }

    public final void zzbA(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(3, zza);
    }

    public final void zzbw(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(1, zza);
    }

    public final void zzbx(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(6, zza);
    }

    public final void zzby(zzbmb zzbmb) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbmb);
        zzbl(8, zza);
    }

    public final void zzbz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(9, zza);
    }

    public final void zzc() throws RemoteException {
        zzbl(4, zza());
    }

    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(7, zza);
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zza.writeInt(i);
        zzbl(5, zza);
    }
}
