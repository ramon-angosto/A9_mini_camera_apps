package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzasb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbj extends zzarz implements zzbl {
    zzbj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final String zzf() throws RemoteException {
        throw null;
    }

    public final void zzg(zzl zzl) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzl);
        zzbl(1, zza);
    }

    public final void zzh(zzl zzl, int i) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzl);
        zza.writeInt(i);
        zzbl(5, zza);
    }

    public final boolean zzi() throws RemoteException {
        Parcel zzbk = zzbk(3, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }
}
