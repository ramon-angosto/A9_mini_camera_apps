package com.google.android.gms.internal.ads;

import com.vungle.warren.utility.platform.Platform;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzps {
    public static final boolean zza;

    static {
        boolean z = true;
        if (!Platform.MANUFACTURER_AMAZON.equals(zzen.zzc) || (!"AFTM".equals(zzen.zzd) && !"AFTB".equals(zzen.zzd))) {
            z = false;
        }
        zza = z;
    }
}
