package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbtq extends zzcho {
    private final Object zza = new Object();
    /* access modifiers changed from: private */
    public final zzbtv zzb;
    private boolean zzc;

    public zzbtq(zzbtv zzbtv) {
        this.zzb = zzbtv;
    }

    public final void zzb() {
        synchronized (this.zza) {
            if (!this.zzc) {
                this.zzc = true;
                zzi(new zzbtn(this), new zzchk());
                zzi(new zzbto(this), new zzbtp(this));
            }
        }
    }
}
