package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaju {
    private final Executor zza;

    public zzaju(Handler handler) {
        this.zza = new zzajs(this, handler);
    }

    public final void zza(zzakd zzakd, zzakm zzakm) {
        zzakd.zzm("post-error");
        zzakj zza2 = zzakj.zza(zzakm);
        Executor executor = this.zza;
        ((zzajs) executor).zza.post(new zzajt(zzakd, zza2, (Runnable) null));
    }

    public final void zzb(zzakd zzakd, zzakj zzakj, Runnable runnable) {
        zzakd.zzq();
        zzakd.zzm("post-response");
        Executor executor = this.zza;
        ((zzajs) executor).zza.post(new zzajt(zzakd, zzakj, runnable));
    }
}
