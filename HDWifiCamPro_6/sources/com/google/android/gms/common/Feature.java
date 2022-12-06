package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzc();
    private final String zza;
    @Deprecated
    private final int zzb;
    private final long zzc;

    public Feature(String str, int i, long j) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }

    public Feature(String str, long j) {
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() == null || !getName().equals(feature.getName())) && (getName() != null || feature.getName() != null)) || getVersion() != feature.getVersion()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getName() {
        return this.zza;
    }

    public long getVersion() {
        long j = this.zzc;
        return j == -1 ? (long) this.zzb : j;
    }

    public final int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("name", getName());
        stringHelper.add("version", Long.valueOf(getVersion()));
        return stringHelper.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
