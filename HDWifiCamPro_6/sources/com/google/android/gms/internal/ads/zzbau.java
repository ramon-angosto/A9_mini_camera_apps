package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbau implements Parcelable {
    public static final Parcelable.Creator<zzbau> CREATOR = new zzbat();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final byte[] zzd;
    private int zze;

    public zzbau(int i, int i2, int i3, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = bArr;
    }

    zzbau(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbau zzbau = (zzbau) obj;
            return this.zza == zzbau.zza && this.zzb == zzbau.zzb && this.zzc == zzbau.zzc && Arrays.equals(this.zzd, zzbau.zzd);
        }
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((this.zza + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb) * 31) + this.zzc) * 31) + Arrays.hashCode(this.zzd);
        this.zze = hashCode;
        return hashCode;
    }

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        boolean z = this.zzd != null;
        return "ColorInfo(" + i + ", " + i2 + ", " + i3 + ", " + z + ")";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd != null ? 1 : 0);
        byte[] bArr = this.zzd;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
