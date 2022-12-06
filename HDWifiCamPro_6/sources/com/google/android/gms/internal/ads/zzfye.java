package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfye implements Runnable {
    public final /* synthetic */ zzfyg zza;
    public final /* synthetic */ zzfzp zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzfye(zzfyg zzfyg, zzfzp zzfzp, int i) {
        this.zza = zzfyg;
        this.zzb = zzfzp;
        this.zzc = i;
    }

    public final void run() {
        this.zza.zzx(this.zzb, this.zzc);
    }
}
