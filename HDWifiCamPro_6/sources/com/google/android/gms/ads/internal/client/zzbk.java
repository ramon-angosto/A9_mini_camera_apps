package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzasa;
import com.google.android.gms.internal.ads.zzasb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbk extends zzasa implements zzbl {
    public zzbk() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzasb.zzc(parcel);
            zzg((zzl) zzasb.zza(parcel, zzl.CREATOR));
            parcel2.writeNoException();
        } else if (i == 2) {
            String zze = zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        } else if (i == 3) {
            boolean zzi = zzi();
            parcel2.writeNoException();
            zzasb.zzd(parcel2, zzi);
        } else if (i == 4) {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        } else if (i != 5) {
            return false;
        } else {
            int readInt = parcel.readInt();
            zzasb.zzc(parcel);
            zzh((zzl) zzasb.zza(parcel, zzl.CREATOR), readInt);
            parcel2.writeNoException();
        }
        return true;
    }
}
