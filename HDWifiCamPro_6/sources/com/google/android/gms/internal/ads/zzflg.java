package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzflg {
    private static final zzflg zza = new zzflg();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzflg() {
    }

    public static zzflg zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzfkv zzfkv) {
        this.zzb.add(zzfkv);
    }

    public final void zze(zzfkv zzfkv) {
        boolean zzg = zzg();
        this.zzb.remove(zzfkv);
        this.zzc.remove(zzfkv);
        if (zzg && !zzg()) {
            zzflm.zzb().zzf();
        }
    }

    public final void zzf(zzfkv zzfkv) {
        boolean zzg = zzg();
        this.zzc.add(zzfkv);
        if (!zzg) {
            zzflm.zzb().zze();
        }
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
