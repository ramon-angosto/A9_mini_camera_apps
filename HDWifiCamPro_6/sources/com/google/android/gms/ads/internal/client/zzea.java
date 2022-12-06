package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzea extends zzcx {
    private zzea() {
    }

    public final void zze(@Nullable zze zze) {
        AdInspectorError adInspectorError;
        OnAdInspectorClosedListener zzb = zzed.zzf().zzh;
        if (zzb != null) {
            if (zze == null) {
                adInspectorError = null;
            } else {
                adInspectorError = new AdInspectorError(zze.zza, zze.zzb, zze.zzc);
            }
            zzb.onAdInspectorClosed(adInspectorError);
        }
    }

    /* synthetic */ zzea(zzdz zzdz) {
    }
}
