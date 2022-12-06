package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzacf implements zzbp {
    public static final Parcelable.Creator<zzacf> CREATOR = new zzace();
    private static final zzaf zzf;
    private static final zzaf zzg;
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzh;

    static {
        zzad zzad = new zzad();
        zzad.zzS(MimeTypes.APPLICATION_ID3);
        zzf = zzad.zzY();
        zzad zzad2 = new zzad();
        zzad2.zzS(MimeTypes.APPLICATION_SCTE35);
        zzg = zzad2.zzY();
    }

    zzacf(Parcel parcel) {
        String readString = parcel.readString();
        int i = zzen.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = (byte[]) zzen.zzH(parcel.createByteArray());
    }

    public zzacf(String str, String str2, long j, long j2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzacf zzacf = (zzacf) obj;
            return this.zzc == zzacf.zzc && this.zzd == zzacf.zzd && zzen.zzT(this.zza, zzacf.zza) && zzen.zzT(this.zzb, zzacf.zzb) && Arrays.equals(this.zze, zzacf.zze);
        }
    }

    public final int hashCode() {
        int i = this.zzh;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int i2 = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        long j = this.zzc;
        long j2 = this.zzd;
        int hashCode2 = ((((((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + Arrays.hashCode(this.zze);
        this.zzh = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        String str = this.zza;
        long j = this.zzd;
        long j2 = this.zzc;
        String str2 = this.zzb;
        return "EMSG: scheme=" + str + ", id=" + j + ", durationMs=" + j2 + ", value=" + str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeByteArray(this.zze);
    }

    public final /* synthetic */ void zza(zzbk zzbk) {
    }
}
