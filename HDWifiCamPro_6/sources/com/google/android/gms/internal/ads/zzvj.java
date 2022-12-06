package com.google.android.gms.internal.ads;

import android.media.Spatializer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzvj implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzvr zza;

    zzvj(zzvk zzvk, zzvr zzvr) {
        this.zza = zzvr;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.zzt();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.zzt();
    }
}
