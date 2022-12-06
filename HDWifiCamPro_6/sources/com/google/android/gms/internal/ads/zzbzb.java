package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbzb extends zzasa implements zzbzc {
    public zzbzb() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzbzc zzF(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        return queryLocalInterface instanceof zzbzc ? (zzbzc) queryLocalInterface : new zzbza(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzasb.zzc(parcel);
                zzk((Bundle) zzasb.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel2.writeNoException();
                return true;
            case 3:
                zzr();
                parcel2.writeNoException();
                return true;
            case 4:
                zzp();
                parcel2.writeNoException();
                return true;
            case 5:
                zzn();
                parcel2.writeNoException();
                return true;
            case 6:
                Bundle bundle = (Bundle) zzasb.zza(parcel, Bundle.CREATOR);
                zzasb.zzc(parcel);
                zzq(bundle);
                parcel2.writeNoException();
                zzasb.zzf(parcel2, bundle);
                return true;
            case 7:
                zzs();
                parcel2.writeNoException();
                return true;
            case 8:
                zzl();
                parcel2.writeNoException();
                return true;
            case 9:
                zzv();
                parcel2.writeNoException();
                return true;
            case 10:
                zzh();
                parcel2.writeNoException();
                return true;
            case 11:
                boolean zzE = zzE();
                parcel2.writeNoException();
                zzasb.zzd(parcel2, zzE);
                return true;
            case 12:
                parcel.readInt();
                parcel.readInt();
                Intent intent = (Intent) zzasb.zza(parcel, Intent.CREATOR);
                zzasb.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 13:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzasb.zzc(parcel);
                zzj(asInterface);
                parcel2.writeNoException();
                return true;
            case 14:
                zzt();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
