package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgbu {
    private final ConcurrentMap zza;
    private final zzgbo zzb;
    private final Class zzc;
    private final zzghm zzd;

    /* synthetic */ zzgbu(ConcurrentMap concurrentMap, zzgbo zzgbo, zzghm zzghm, Class cls, zzgbt zzgbt) {
        this.zza = concurrentMap;
        this.zzb = zzgbo;
        this.zzc = cls;
        this.zzd = zzghm;
    }

    @Nullable
    public final zzgbo zza() {
        return this.zzb;
    }

    public final zzghm zzb() {
        return this.zzd;
    }

    public final Class zzc() {
        return this.zzc;
    }

    public final Collection zzd() {
        return this.zza.values();
    }

    public final List zze(byte[] bArr) {
        List list = (List) this.zza.get(new zzgbq(bArr, (zzgbp) null));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final boolean zzf() {
        return !this.zzd.zza().isEmpty();
    }
}
