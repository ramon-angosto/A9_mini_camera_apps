package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzevz implements zzeve {
    private final Executor zza;
    private final String zzb;
    private final PackageInfo zzc;
    private final zzcfp zzd;

    public zzevz(zzcfp zzcfp, Executor executor, String str, PackageInfo packageInfo, int i, byte[] bArr) {
        this.zzd = zzcfp;
        this.zza = executor;
        this.zzb = str;
        this.zzc = packageInfo;
    }

    public final int zza() {
        return 41;
    }

    public final zzfzp zzb() {
        return zzfzg.zzg(zzfzg.zzm(zzfzg.zzi(this.zzb), zzevx.zza, this.zza), Throwable.class, new zzevy(this), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(Throwable th) throws Exception {
        return zzfzg.zzi(new zzewa(this.zzb));
    }
}
