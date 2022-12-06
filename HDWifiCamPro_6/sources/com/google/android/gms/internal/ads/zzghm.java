package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzghm {
    public static final zzghm zza = new zzghk().zza();
    private final Map zzb;

    /* synthetic */ zzghm(Map map, zzghl zzghl) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghm)) {
            return false;
        }
        return this.zzb.equals(((zzghm) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }
}
