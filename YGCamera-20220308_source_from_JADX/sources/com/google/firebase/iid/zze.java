package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zze implements Parcelable.Creator<zzf> {
    zze() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzf[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new zzf(readStrongBinder);
        }
        return null;
    }
}
