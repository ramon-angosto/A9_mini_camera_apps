package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzog {
    public static void zza(AudioTrack audioTrack, zznb zznb) {
        LogSessionId zza = zznb.zza();
        if (!zza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            audioTrack.setLogSessionId(zza);
        }
    }
}
