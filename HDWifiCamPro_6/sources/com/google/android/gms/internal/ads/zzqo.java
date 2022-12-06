package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzqo {
    public static void zza(zzqj zzqj, zznb zznb) {
        LogSessionId zza = zznb.zza();
        if (!zza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            zzqj.zzb.setString("log-session-id", zza.getStringId());
        }
    }
}
