package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
public final class zzc {
    private static final ClassLoader zza = zzc.class.getClassLoader();

    private zzc() {
    }

    public static void zza(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean zzb(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
