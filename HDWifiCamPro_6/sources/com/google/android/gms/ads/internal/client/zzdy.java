package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzdy implements AdapterStatus {
    zzdy(zzed zzed) {
    }

    public final String getDescription() {
        return "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.";
    }

    public final AdapterStatus.State getInitializationState() {
        return AdapterStatus.State.READY;
    }

    public final int getLatency() {
        return 0;
    }
}
