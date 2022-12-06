package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzbd {
    final Intent zza;
    private final BroadcastReceiver.PendingResult zzb;
    private boolean zzc = false;
    private final ScheduledFuture<?> zzd;

    zzbd(Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.zza = intent;
        this.zzb = pendingResult;
        this.zzd = scheduledExecutorService.schedule(new zzbc(this, intent), 9000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza() {
        if (!this.zzc) {
            this.zzb.finish();
            this.zzd.cancel(false);
            this.zzc = true;
        }
    }
}
