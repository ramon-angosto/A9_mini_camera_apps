package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzffe;
import com.google.android.gms.internal.ads.zzftm;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaz> CREATOR = new zzba();
    public final String zza;
    public final int zzb;

    zzaz(String str, int i) {
        this.zza = str == null ? "" : str;
        this.zzb = i;
    }

    public static zzaz zza(Throwable th) {
        String str;
        zze zza2 = zzffe.zza(th);
        if (zzftm.zzd(th.getMessage())) {
            str = zza2.zzb;
        } else {
            str = th.getMessage();
        }
        return new zzaz(str, zza2.zza);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
