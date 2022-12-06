package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zak();
    final int zaa;
    final String zab;
    final FastJsonResponse.Field<?, ?> zac;

    zam(int i, String str, FastJsonResponse.Field<?, ?> field) {
        this.zaa = i;
        this.zab = str;
        this.zac = field;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeString(parcel, 2, this.zab, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.zaa = 1;
        this.zab = str;
        this.zac = field;
    }
}
