package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzadw implements zzbp {
    public static final Parcelable.Creator<zzadw> CREATOR = new zzadu();
    public final float zza;
    public final int zzb;

    public zzadw(float f, int i) {
        this.zza = f;
        this.zzb = i;
    }

    /* synthetic */ zzadw(Parcel parcel, zzadv zzadv) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzadw zzadw = (zzadw) obj;
            return this.zza == zzadw.zza && this.zzb == zzadw.zzb;
        }
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb;
    }

    public final String toString() {
        float f = this.zza;
        int i = this.zzb;
        return "smta: captureFrameRate=" + f + ", svcTemporalLayerCount=" + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.zza);
        parcel.writeInt(this.zzb);
    }

    public final /* synthetic */ void zza(zzbk zzbk) {
    }
}
