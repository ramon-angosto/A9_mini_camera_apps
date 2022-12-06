package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzadt implements zzbp {
    public static final Parcelable.Creator<zzadt> CREATOR = new zzadr();
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzadt(long j, long j2, long j3, long j4, long j5) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
    }

    /* synthetic */ zzadt(Parcel parcel, zzads zzads) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzadt zzadt = (zzadt) obj;
            return this.zza == zzadt.zza && this.zzb == zzadt.zzb && this.zzc == zzadt.zzc && this.zzd == zzadt.zzd && this.zze == zzadt.zze;
        }
    }

    public final int hashCode() {
        long j = this.zza;
        long j2 = this.zzb;
        long j3 = this.zzc;
        long j4 = this.zzd;
        long j5 = this.zze;
        return ((((((((((int) (j ^ (j >>> 32))) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + ((int) ((j4 >>> 32) ^ j4))) * 31) + ((int) ((j5 >>> 32) ^ j5));
    }

    public final String toString() {
        long j = this.zza;
        long j2 = this.zzb;
        long j3 = this.zzc;
        long j4 = this.zzd;
        long j5 = this.zze;
        return "Motion photo metadata: photoStartPosition=" + j + ", photoSize=" + j2 + ", photoPresentationTimestampUs=" + j3 + ", videoStartPosition=" + j4 + ", videoSize=" + j5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
    }

    public final /* synthetic */ void zza(zzbk zzbk) {
    }
}
