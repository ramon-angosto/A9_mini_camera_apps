package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzw implements Parcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzv();
    public final UUID zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;
    private int zze;

    zzw(Parcel parcel) {
        this.zza = new UUID(parcel.readLong(), parcel.readLong());
        this.zzb = parcel.readString();
        String readString = parcel.readString();
        int i = zzen.zza;
        this.zzc = readString;
        this.zzd = parcel.createByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzw)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzw zzw = (zzw) obj;
        return zzen.zzT(this.zzb, zzw.zzb) && zzen.zzT(this.zzc, zzw.zzc) && zzen.zzT(this.zza, zzw.zza) && Arrays.equals(this.zzd, zzw.zzd);
    }

    public final int hashCode() {
        int i;
        int i2 = this.zze;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.zza.hashCode() * 31;
        String str = this.zzb;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int hashCode2 = ((((hashCode + i) * 31) + this.zzc.hashCode()) * 31) + Arrays.hashCode(this.zzd);
        this.zze = hashCode2;
        return hashCode2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza.getMostSignificantBits());
        parcel.writeLong(this.zza.getLeastSignificantBits());
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzw(UUID uuid, String str, String str2, byte[] bArr) {
        if (uuid != null) {
            this.zza = uuid;
            this.zzb = null;
            this.zzc = str2;
            this.zzd = bArr;
            return;
        }
        throw null;
    }
}
