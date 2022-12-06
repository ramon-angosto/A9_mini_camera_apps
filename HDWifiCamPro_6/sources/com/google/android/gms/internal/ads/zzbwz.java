package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbwz extends zzasa implements zzbxa {
    public zzbwz() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzg();
        } else if (i == 3) {
            String readString = parcel.readString();
            zzasb.zzc(parcel);
            zze(readString);
        } else if (i != 4) {
            return false;
        } else {
            zzasb.zzc(parcel);
            zzf((zze) zzasb.zza(parcel, zze.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
