package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.CommentFrame;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaxl extends zzaxn {
    public static final Parcelable.Creator<zzaxl> CREATOR = new zzaxk();
    public final String zza;
    public final String zzb;
    public final String zzc;

    zzaxl(Parcel parcel) {
        super(CommentFrame.ID);
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaxl zzaxl = (zzaxl) obj;
            return zzbar.zzo(this.zzb, zzaxl.zzb) && zzbar.zzo(this.zza, zzaxl.zza) && zzbar.zzo(this.zzc, zzaxl.zzc);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str2 = this.zzb;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzc;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zze);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }

    public zzaxl(String str, String str2, String str3) {
        super(CommentFrame.ID);
        this.zza = C.LANGUAGE_UNDETERMINED;
        this.zzb = str2;
        this.zzc = str3;
    }
}
