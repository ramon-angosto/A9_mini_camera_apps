package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbpv implements zzbpu {
    private final zzeak zza;

    public zzbpv(zzeak zzeak) {
        Preconditions.checkNotNull(zzeak, "The Inspector Manager must not be null");
        this.zza = zzeak;
    }

    public final void zza(Object obj, Map map) {
        if (map != null && map.containsKey("extras")) {
            long j = Long.MAX_VALUE;
            if (map.containsKey("expires")) {
                try {
                    j = Long.parseLong((String) map.get("expires"));
                } catch (NumberFormatException unused) {
                }
            }
            this.zza.zzi((String) map.get("extras"), j);
        }
    }
}
