package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfhp {
    final /* synthetic */ zzfhz zza;
    private final Object zzb;
    private final List zzc;

    /* synthetic */ zzfhp(zzfhz zzfhz, Object obj, List list, zzfho zzfho) {
        this.zza = zzfhz;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfhy zza(Callable callable) {
        zzfzf zzc2 = zzfzg.zzc(this.zzc);
        zzfzp zza2 = zzc2.zza(zzfhn.zza, zzchc.zzf);
        zzfhz zzfhz = this.zza;
        return new zzfhy(zzfhz, this.zzb, (String) null, zza2, this.zzc, zzc2.zza(callable, zzfhz.zzb), (zzfhx) null);
    }
}
