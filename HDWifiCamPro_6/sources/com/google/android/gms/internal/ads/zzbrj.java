package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbrj extends zzarz implements IInterface {
    zzbrj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbrd zzbrd, zzbri zzbri) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzbrd);
        zzasb.zzg(zza, zzbri);
        zzbm(2, zza);
    }
}
