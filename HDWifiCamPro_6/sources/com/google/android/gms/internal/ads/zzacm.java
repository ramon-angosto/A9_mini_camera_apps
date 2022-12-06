package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzacm implements zzbp {
    public static final Parcelable.Creator<zzacm> CREATOR = new zzacl();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzacm(int i, String str, String str2, String str3, boolean z, int i2) {
        boolean z2 = true;
        if (i2 != -1 && i2 <= 0) {
            z2 = false;
        }
        zzdd.zzd(z2);
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzacm zzacm = (zzacm) obj;
            return this.zza == zzacm.zza && zzen.zzT(this.zzb, zzacm.zzb) && zzen.zzT(this.zzc, zzacm.zzc) && zzen.zzT(this.zzd, zzacm.zzd) && this.zze == zzacm.zze && this.zzf == zzacm.zzf;
        }
    }

    public final int hashCode() {
        int i = (this.zza + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str = this.zzb;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.zzc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzd;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((((hashCode2 + i2) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zzb;
        int i = this.zza;
        int i2 = this.zzf;
        return "IcyHeaders: name=\"" + str + "\", genre=\"" + str2 + "\", bitrate=" + i + ", metadataInterval=" + i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeString(this.zzd);
        zzen.zzS(parcel, this.zze);
        parcel.writeInt(this.zzf);
    }

    public final void zza(zzbk zzbk) {
        String str = this.zzc;
        if (str != null) {
            zzbk.zzq(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zzbk.zzj(str2);
        }
    }

    zzacm(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.readString();
        this.zze = zzen.zzZ(parcel);
        this.zzf = parcel.readInt();
    }
}
