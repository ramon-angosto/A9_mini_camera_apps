package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzccr extends zzasa implements zzccs {
    public zzccr() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzg();
        } else if (i == 2) {
            int readInt = parcel.readInt();
            zzasb.zzc(parcel);
            zze(readInt);
        } else if (i != 3) {
            return false;
        } else {
            zzasb.zzc(parcel);
            zzf((zze) zzasb.zza(parcel, zze.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
