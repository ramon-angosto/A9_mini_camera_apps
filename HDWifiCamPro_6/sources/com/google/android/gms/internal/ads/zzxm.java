package com.google.android.gms.internal.ads;

import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzxm {
    public static void zza(Surface surface, float f) {
        try {
            surface.setFrameRate(f, f == 0.0f ? 0 : 1);
        } catch (IllegalStateException e) {
            zzdw.zzc("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
        }
    }
}
