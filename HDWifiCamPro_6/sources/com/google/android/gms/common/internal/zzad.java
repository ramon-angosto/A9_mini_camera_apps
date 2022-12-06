package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class zzad extends zza implements zzaf {
    zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final zzq zze(zzn zzn) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzn);
        Parcel zzB = zzB(6, zza);
        zzq zzq = (zzq) zzc.zza(zzB, zzq.CREATOR);
        zzB.recycle();
        return zzq;
    }

    public final boolean zzf(zzs zzs, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzs);
        zzc.zze(zza, iObjectWrapper);
        Parcel zzB = zzB(5, zza);
        boolean zzf = zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }

    public final boolean zzg() throws RemoteException {
        Parcel zzB = zzB(7, zza());
        boolean zzf = zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }
}
