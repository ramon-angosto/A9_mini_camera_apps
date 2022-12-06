package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzadq implements zzbp {
    public static final Parcelable.Creator<zzadq> CREATOR = new zzado();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* synthetic */ zzadq(Parcel parcel, zzadp zzadp) {
        String readString = parcel.readString();
        int i = zzen.zza;
        this.zza = readString;
        this.zzb = (byte[]) zzen.zzH(parcel.createByteArray());
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public zzadq(String str, byte[] bArr, int i, int i2) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzadq zzadq = (zzadq) obj;
            return this.zza.equals(zzadq.zza) && Arrays.equals(this.zzb, zzadq.zzb) && this.zzc == zzadq.zzc && this.zzd == zzadq.zzd;
        }
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final String toString() {
        return "mdta: key=".concat(String.valueOf(this.zza));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    public final /* synthetic */ void zza(zzbk zzbk) {
    }
}
