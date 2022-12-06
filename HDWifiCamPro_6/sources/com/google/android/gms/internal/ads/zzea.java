package com.google.android.gms.internal.ads;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzea extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    private final zzed zza;

    public zzea(zzed zzed) {
        this.zza = zzed;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        int i = 5;
        boolean z = overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5;
        zzed zzed = this.zza;
        if (true == z) {
            i = 10;
        }
        zzed.zzc(zzed, i);
    }
}
