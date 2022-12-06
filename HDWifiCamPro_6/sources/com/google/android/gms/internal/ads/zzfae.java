package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzw;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfae implements zzfgl {
    public final zzfay zza;
    public final zzfba zzb;
    public final zzl zzc;
    public final String zzd;
    public final Executor zze;
    public final zzw zzf;
    public final zzfga zzg;

    public zzfae(zzfay zzfay, zzfba zzfba, zzl zzl, String str, Executor executor, zzw zzw, zzfga zzfga) {
        this.zza = zzfay;
        this.zzb = zzfba;
        this.zzc = zzl;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzw;
        this.zzg = zzfga;
    }

    public final zzfga zza() {
        return this.zzg;
    }

    public final Executor zzb() {
        return this.zze;
    }
}
