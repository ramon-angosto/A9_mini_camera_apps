package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbjj {
    public static boolean zza(zzbjr zzbjr, zzbjo zzbjo, String... strArr) {
        if (zzbjo == null) {
            return false;
        }
        zzbjr.zze(zzbjo, zzt.zzB().elapsedRealtime(), strArr);
        return true;
    }
}
