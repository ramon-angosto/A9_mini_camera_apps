package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfio {
    private final Executor zza;
    private final zzcgu zzb;

    public zzfio(Executor executor, zzcgu zzcgu) {
        this.zza = executor;
        this.zzb = zzcgu;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zzb.zza(str);
    }

    public final void zzb(String str) {
        this.zza.execute(new zzfin(this, str));
    }
}
