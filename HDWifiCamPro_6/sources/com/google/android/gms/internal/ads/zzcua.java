package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcua implements zzctw {
    private final zzg zza;

    public zzcua(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map map) {
        this.zza.zzz(Boolean.parseBoolean((String) map.get("content_vertical_opted_out")));
    }
}
