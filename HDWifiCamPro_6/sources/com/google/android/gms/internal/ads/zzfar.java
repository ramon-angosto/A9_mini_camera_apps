package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfar implements zzfsm {
    final /* synthetic */ zzfav zza;

    zzfar(zzfav zzfav) {
        this.zza = zzfav;
    }

    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzcgp.zzh("", (zzedj) obj);
        zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfav zzfav = this.zza;
        zzfav.zzd = new zzfau((zzcbc) null, zzfav.zze(), (zzfat) null);
        return this.zza.zzd;
    }
}
