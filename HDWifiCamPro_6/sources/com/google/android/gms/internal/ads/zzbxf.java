package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbxf extends zzasa implements zzbxg {
    public zzbxf() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String readString = parcel.readString();
            zzasb.zzc(parcel);
            zze(readString);
        } else if (i == 2) {
            String readString2 = parcel.readString();
            zzasb.zzc(parcel);
            zzf(readString2);
        } else if (i != 3) {
            return false;
        } else {
            zzasb.zzc(parcel);
            zzg((zze) zzasb.zza(parcel, zze.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
