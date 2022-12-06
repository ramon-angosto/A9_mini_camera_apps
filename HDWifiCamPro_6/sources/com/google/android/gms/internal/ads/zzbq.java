package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbq implements Parcelable {
    public static final Parcelable.Creator<zzbq> CREATOR = new zzbo();
    public final long zza;
    private final zzbp[] zzb;

    public zzbq(long j, zzbp... zzbpArr) {
        this.zza = j;
        this.zzb = zzbpArr;
    }

    zzbq(Parcel parcel) {
        this.zzb = new zzbp[parcel.readInt()];
        int i = 0;
        while (true) {
            zzbp[] zzbpArr = this.zzb;
            if (i < zzbpArr.length) {
                zzbpArr[i] = (zzbp) parcel.readParcelable(zzbp.class.getClassLoader());
                i++;
            } else {
                this.zza = parcel.readLong();
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
        if (obj != null && getClass() == obj.getClass()) {
            zzbq zzbq = (zzbq) obj;
            return Arrays.equals(this.zzb, zzbq.zzb) && this.zza == zzbq.zza;
        }
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.zzb);
        long j = this.zza;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str;
        String arrays = Arrays.toString(this.zzb);
        long j = this.zza;
        if (j == C.TIME_UNSET) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j;
        }
        return "entries=" + arrays + str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzb.length);
        for (zzbp writeParcelable : this.zzb) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.zza);
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final zzbp zzb(int i) {
        return this.zzb[i];
    }

    public final zzbq zzc(zzbp... zzbpArr) {
        if (zzbpArr.length == 0) {
            return this;
        }
        return new zzbq(this.zza, (zzbp[]) zzen.zzad(this.zzb, zzbpArr));
    }

    public final zzbq zzd(zzbq zzbq) {
        return zzbq == null ? this : zzc(zzbq.zzb);
    }

    public zzbq(List list) {
        this(C.TIME_UNSET, (zzbp[]) list.toArray(new zzbp[0]));
    }
}
