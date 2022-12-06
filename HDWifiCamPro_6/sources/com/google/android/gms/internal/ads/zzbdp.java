package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbdp extends zzasa implements zzbdq {
    public zzbdp() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzf();
        } else if (i == 2) {
            zzc();
        } else if (i == 3) {
            zzasb.zzc(parcel);
            zzd((zze) zzasb.zza(parcel, zze.CREATOR));
        } else if (i == 4) {
            zze();
        } else if (i != 5) {
            return false;
        } else {
            zzb();
        }
        parcel2.writeNoException();
        return true;
    }
}
