package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbvj extends zzasa implements zzbvk {
    public zzbvj() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbvk zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzbvk ? (zzbvk) queryLocalInterface : new zzbvi(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String readString = parcel.readString();
            zzasb.zzc(parcel);
            zzbvn zzb = zzb(readString);
            parcel2.writeNoException();
            zzasb.zzg(parcel2, zzb);
        } else if (i == 2) {
            String readString2 = parcel.readString();
            zzasb.zzc(parcel);
            boolean zze = zze(readString2);
            parcel2.writeNoException();
            zzasb.zzd(parcel2, zze);
        } else if (i == 3) {
            String readString3 = parcel.readString();
            zzasb.zzc(parcel);
            zzbxd zzc = zzc(readString3);
            parcel2.writeNoException();
            zzasb.zzg(parcel2, zzc);
        } else if (i != 4) {
            return false;
        } else {
            String readString4 = parcel.readString();
            zzasb.zzc(parcel);
            boolean zzd = zzd(readString4);
            parcel2.writeNoException();
            zzasb.zzd(parcel2, zzd);
        }
        return true;
    }
}
