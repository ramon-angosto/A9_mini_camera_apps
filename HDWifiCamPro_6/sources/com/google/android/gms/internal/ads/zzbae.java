package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbae {
    private boolean zza;

    public final synchronized void zza() throws InterruptedException {
        while (!this.zza) {
            wait();
        }
    }

    public final synchronized boolean zzb() {
        boolean z;
        z = this.zza;
        this.zza = false;
        return z;
    }

    public final synchronized boolean zzc() {
        if (this.zza) {
            return false;
        }
        this.zza = true;
        notifyAll();
        return true;
    }
}
