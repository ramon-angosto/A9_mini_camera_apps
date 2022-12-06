package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdne implements zzgxi {
    private final zzgxv zza;

    public zzdne(zzgxv zzgxv) {
        this.zza = zzgxv;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        if (((zzdnb) this.zza).zza().zze() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        zzgxq.zzb(set);
        return set;
    }
}
