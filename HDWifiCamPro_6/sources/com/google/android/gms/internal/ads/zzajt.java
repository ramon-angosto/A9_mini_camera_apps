package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzajt implements Runnable {
    private final zzakd zza;
    private final zzakj zzb;
    private final Runnable zzc;

    public zzajt(zzakd zzakd, zzakj zzakj, Runnable runnable) {
        this.zza = zzakd;
        this.zzb = zzakj;
        this.zzc = runnable;
    }

    public final void run() {
        this.zza.zzw();
        zzakj zzakj = this.zzb;
        if (zzakj.zzc()) {
            this.zza.zzo(zzakj.zza);
        } else {
            this.zza.zzn(zzakj.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzm("intermediate-response");
        } else {
            this.zza.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
