package com.google.android.gms.internal.ads;

import android.os.Trace;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbap {
    public static void zza(String str) {
        if (zzbar.zza >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void zzb() {
        if (zzbar.zza >= 18) {
            Trace.endSection();
        }
    }
}
