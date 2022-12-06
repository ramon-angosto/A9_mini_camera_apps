package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfva extends zzfvc {
    zzfva() {
        super((zzfva) null);
    }

    static final zzfvc zzf(int i) {
        return i < 0 ? zzfvc.zzb : i > 0 ? zzfvc.zzc : zzfvc.zza;
    }

    public final int zza() {
        return 0;
    }

    public final zzfvc zzb(int i, int i2) {
        return zzf(i < i2 ? -1 : i > i2 ? 1 : 0);
    }

    public final zzfvc zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    public final zzfvc zzd(boolean z, boolean z2) {
        return zzf(zzfxr.zza(z, z2));
    }

    public final zzfvc zze(boolean z, boolean z2) {
        return zzf(zzfxr.zza(false, false));
    }
}
