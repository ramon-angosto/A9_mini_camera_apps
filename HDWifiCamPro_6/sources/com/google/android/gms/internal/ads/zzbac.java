package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbac {
    public static int zza(int i, int i2, int i3) {
        if (i >= 0 && i < i3) {
            return 0;
        }
        throw new IndexOutOfBoundsException();
    }

    public static String zzb(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    public static void zzc(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzd(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zze(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zzf(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }
}
