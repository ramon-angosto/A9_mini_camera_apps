package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbmc extends zzarz implements zzbme {
    zzbmc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final double zzb() throws RemoteException {
        Parcel zzbk = zzbk(3, zza());
        double readDouble = zzbk.readDouble();
        zzbk.recycle();
        return readDouble;
    }

    public final int zzc() throws RemoteException {
        Parcel zzbk = zzbk(5, zza());
        int readInt = zzbk.readInt();
        zzbk.recycle();
        return readInt;
    }

    public final int zzd() throws RemoteException {
        Parcel zzbk = zzbk(4, zza());
        int readInt = zzbk.readInt();
        zzbk.recycle();
        return readInt;
    }

    public final Uri zze() throws RemoteException {
        Parcel zzbk = zzbk(2, zza());
        Uri uri = (Uri) zzasb.zza(zzbk, Uri.CREATOR);
        zzbk.recycle();
        return uri;
    }

    public final IObjectWrapper zzf() throws RemoteException {
        Parcel zzbk = zzbk(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbk.readStrongBinder());
        zzbk.recycle();
        return asInterface;
    }
}
