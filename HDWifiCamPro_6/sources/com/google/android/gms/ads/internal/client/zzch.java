package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzasb;
import com.google.android.gms.internal.ads.zzbvj;
import com.google.android.gms.internal.ads.zzbvk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzch extends zzarz implements zzcj {
    zzch(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public final zzbvk getAdapterCreator() throws RemoteException {
        Parcel zzbk = zzbk(2, zza());
        zzbvk zzf = zzbvj.zzf(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzf;
    }

    public final zzeh getLiteSdkVersion() throws RemoteException {
        Parcel zzbk = zzbk(1, zza());
        zzeh zzeh = (zzeh) zzasb.zza(zzbk, zzeh.CREATOR);
        zzbk.recycle();
        return zzeh;
    }
}
