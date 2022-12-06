package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbwp extends zzarz implements zzbwr {
    zzbwp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzbl(2, zza);
    }

    public final void zzf(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zze);
        zzbl(3, zza);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(1, zza);
    }

    public final void zzh(zzbvt zzbvt) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbvt);
        zzbl(4, zza);
    }
}
