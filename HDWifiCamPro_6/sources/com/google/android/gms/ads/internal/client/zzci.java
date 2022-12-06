package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzasa;
import com.google.android.gms.internal.ads.zzasb;
import com.google.android.gms.internal.ads.zzbvk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzci extends zzasa implements zzcj {
    public zzci() {
        super("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public static zzcj asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        return queryLocalInterface instanceof zzcj ? (zzcj) queryLocalInterface : new zzch(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzeh liteSdkVersion = getLiteSdkVersion();
            parcel2.writeNoException();
            zzasb.zzf(parcel2, liteSdkVersion);
        } else if (i != 2) {
            return false;
        } else {
            zzbvk adapterCreator = getAdapterCreator();
            parcel2.writeNoException();
            zzasb.zzg(parcel2, adapterCreator);
        }
        return true;
    }
}
