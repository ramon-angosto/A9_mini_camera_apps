package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzdlk {
    private final zzdmp zza;
    private final zzcmp zzb;

    public zzdlk(zzdmp zzdmp, zzcmp zzcmp) {
        this.zza = zzdmp;
        this.zzb = zzcmp;
    }

    public static final zzdkg zzh(zzfjg zzfjg) {
        return new zzdkg(zzfjg, zzchc.zzf);
    }

    public static final zzdkg zzi(zzdmu zzdmu) {
        return new zzdkg(zzdmu, zzchc.zzf);
    }

    public final View zza() {
        zzcmp zzcmp = this.zzb;
        if (zzcmp == null) {
            return null;
        }
        return zzcmp.zzI();
    }

    public final View zzb() {
        zzcmp zzcmp = this.zzb;
        if (zzcmp != null) {
            return zzcmp.zzI();
        }
        return null;
    }

    public final zzcmp zzc() {
        return this.zzb;
    }

    public final zzdkg zzd(Executor executor) {
        return new zzdkg(new zzdli(this.zzb), executor);
    }

    public final zzdmp zze() {
        return this.zza;
    }

    public Set zzf(zzdca zzdca) {
        return Collections.singleton(new zzdkg(zzdca, zzchc.zzf));
    }

    public Set zzg(zzdca zzdca) {
        return Collections.singleton(new zzdkg(zzdca, zzchc.zzf));
    }
}
