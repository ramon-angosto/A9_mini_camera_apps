package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaxh implements Parcelable {
    public static final Parcelable.Creator<zzaxh> CREATOR = new zzaxf();
    private final zzaxg[] zza;

    zzaxh(Parcel parcel) {
        this.zza = new zzaxg[parcel.readInt()];
        int i = 0;
        while (true) {
            zzaxg[] zzaxgArr = this.zza;
            if (i < zzaxgArr.length) {
                zzaxgArr[i] = (zzaxg) parcel.readParcelable(zzaxg.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzaxh) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza.length);
        for (zzaxg writeParcelable : this.zza) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzaxg zzb(int i) {
        return this.zza[i];
    }

    public zzaxh(List list) {
        this.zza = new zzaxg[list.size()];
        list.toArray(this.zza);
    }
}
