package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbs;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbdh extends zzarz implements zzbdj {
    zzbdh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzbs zze() throws RemoteException {
        throw null;
    }

    public final zzdh zzf() throws RemoteException {
        Parcel zzbk = zzbk(5, zza());
        zzdh zzb = zzdg.zzb(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzb;
    }

    public final void zzg(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzd(zza, z);
        zzbl(6, zza);
    }

    public final void zzh(zzde zzde) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzde);
        zzbl(7, zza);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbdq zzbdq) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbdq);
        zzbl(4, zza);
    }

    public final void zzj(zzbdn zzbdn) throws RemoteException {
        throw null;
    }
}
