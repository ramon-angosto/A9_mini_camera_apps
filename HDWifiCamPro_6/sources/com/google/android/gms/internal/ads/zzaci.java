package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaci implements zzbp {
    public static final Parcelable.Creator<zzaci> CREATOR = new zzach();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzaci(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    zzaci(Parcel parcel) {
        this.zza = parcel.readInt();
        String readString = parcel.readString();
        int i = zzen.zza;
        this.zzb = readString;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = (byte[]) zzen.zzH(parcel.createByteArray());
    }

    public static zzaci zzb(zzef zzef) {
        int zze2 = zzef.zze();
        String zzx = zzef.zzx(zzef.zze(), zzfsk.zza);
        String zzx2 = zzef.zzx(zzef.zze(), zzfsk.zzc);
        int zze3 = zzef.zze();
        int zze4 = zzef.zze();
        int zze5 = zzef.zze();
        int zze6 = zzef.zze();
        int zze7 = zzef.zze();
        byte[] bArr = new byte[zze7];
        zzef.zzB(bArr, 0, zze7);
        return new zzaci(zze2, zzx, zzx2, zze3, zze4, zze5, zze6, bArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaci zzaci = (zzaci) obj;
            return this.zza == zzaci.zza && this.zzb.equals(zzaci.zzb) && this.zzc.equals(zzaci.zzc) && this.zzd == zzaci.zzd && this.zze == zzaci.zze && this.zzf == zzaci.zzf && this.zzg == zzaci.zzg && Arrays.equals(this.zzh, zzaci.zzh);
        }
    }

    public final int hashCode() {
        return ((((((((((((((this.zza + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzc;
        return "Picture: mimeType=" + str + ", description=" + str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    public final void zza(zzbk zzbk) {
        zzbk.zza(this.zzh, this.zza);
    }
}
