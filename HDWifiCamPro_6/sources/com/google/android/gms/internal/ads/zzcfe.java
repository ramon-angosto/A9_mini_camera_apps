package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcfe extends zzarz implements zzcfg {
    zzcfe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzcfk zzcfk, zzcfd zzcfd) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zze(zza, zzcfk);
        zzasb.zzg(zza, zzcfd);
        zzbl(1, zza);
    }

    public final void zzf(zzcaa zzcaa) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzcaa);
        zzbl(7, zza);
    }

    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbzr);
        zzbl(10, zza);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbzr);
        zzbl(9, zza);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(8, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(2, zza);
    }

    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbzr);
        zzbl(6, zza);
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbzr);
        zzbl(5, zza);
    }
}
