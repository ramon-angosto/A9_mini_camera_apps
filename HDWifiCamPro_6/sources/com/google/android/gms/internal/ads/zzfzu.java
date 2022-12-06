package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxx;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfzu extends zzfxx.zzi implements Runnable {
    private final Runnable zza;

    public zzfzu(Runnable runnable) {
        if (runnable != null) {
            this.zza = runnable;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final String zza() {
        return "task=[" + this.zza + "]";
    }

    public final void run() {
        try {
            this.zza.run();
        } catch (Error | RuntimeException e) {
            zze(e);
            throw e;
        }
    }
}
