package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzasb;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzdf extends zzarz implements zzdh {
    zzdf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public final Bundle zze() throws RemoteException {
        Parcel zzbk = zzbk(5, zza());
        Bundle bundle = (Bundle) zzasb.zza(zzbk, Bundle.CREATOR);
        zzbk.recycle();
        return bundle;
    }

    public final zzu zzf() throws RemoteException {
        Parcel zzbk = zzbk(4, zza());
        zzu zzu = (zzu) zzasb.zza(zzbk, zzu.CREATOR);
        zzbk.recycle();
        return zzu;
    }

    public final String zzg() throws RemoteException {
        Parcel zzbk = zzbk(1, zza());
        String readString = zzbk.readString();
        zzbk.recycle();
        return readString;
    }

    public final String zzh() throws RemoteException {
        Parcel zzbk = zzbk(6, zza());
        String readString = zzbk.readString();
        zzbk.recycle();
        return readString;
    }

    public final String zzi() throws RemoteException {
        Parcel zzbk = zzbk(2, zza());
        String readString = zzbk.readString();
        zzbk.recycle();
        return readString;
    }

    public final List zzj() throws RemoteException {
        Parcel zzbk = zzbk(3, zza());
        ArrayList<zzu> createTypedArrayList = zzbk.createTypedArrayList(zzu.CREATOR);
        zzbk.recycle();
        return createTypedArrayList;
    }
}
