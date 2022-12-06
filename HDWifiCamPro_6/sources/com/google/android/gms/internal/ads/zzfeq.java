package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfeq {
    public static Bundle zza(Bundle bundle, String str) {
        Bundle bundle2 = bundle.getBundle(str);
        return bundle2 == null ? new Bundle() : bundle2;
    }

    public static void zzb(Bundle bundle, String str, Bundle bundle2) {
        if (bundle2 != null) {
            bundle.putBundle(str, bundle2);
        }
    }

    public static void zzc(Bundle bundle, String str, String str2) {
        if (str2 != null) {
            bundle.putString(str, str2);
        }
    }

    public static void zzd(Bundle bundle, String str, List list) {
        if (list != null) {
            bundle.putStringArrayList(str, new ArrayList(list));
        }
    }

    public static void zze(Bundle bundle, String str, int i, boolean z) {
        if (z) {
            bundle.putInt(str, i);
        }
    }

    public static void zzf(Bundle bundle, String str, String str2, boolean z) {
        if (z) {
            bundle.putString(str, str2);
        }
    }

    public static void zzg(Bundle bundle, String str, boolean z, boolean z2) {
        if (z2) {
            bundle.putBoolean(str, z);
        }
    }
}
