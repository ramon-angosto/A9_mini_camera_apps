package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzcfc extends zzasa implements zzcfd {
    public zzcfc() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.readString();
            parcel.readString();
            zzasb.zzc(parcel);
        } else if (i == 2) {
            String readString = parcel.readString();
            zzasb.zzc(parcel);
            zzb(readString);
        } else if (i != 3) {
            return false;
        } else {
            zzasb.zzc(parcel);
            zzc(parcel.readString(), parcel.readString(), (Bundle) zzasb.zza(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
