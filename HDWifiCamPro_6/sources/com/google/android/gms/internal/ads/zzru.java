package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzru {
    private final zzzp zza;
    private final Map zzb = new HashMap();
    private final Set zzc = new HashSet();
    private final Map zzd = new HashMap();
    private zzew zze;

    public zzru(zzzp zzzp) {
        this.zza = zzzp;
    }

    public final void zza(zzew zzew) {
        if (zzew != this.zze) {
            this.zze = zzew;
            this.zzb.clear();
            this.zzd.clear();
        }
    }
}
