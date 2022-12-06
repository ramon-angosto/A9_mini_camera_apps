package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfra {
    /* access modifiers changed from: private */
    public static final zzfrn zzb = new zzfrn("OverlayDisplayService");
    private static final Intent zzc = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");
    final zzfry zza;
    /* access modifiers changed from: private */
    public final String zzd;

    zzfra(Context context) {
        if (zzfsb.zza(context)) {
            this.zza = new zzfry(context.getApplicationContext(), zzb, "OverlayDisplayService", zzc, zzfqv.zza, (zzfrt) null, (byte[]) null);
        } else {
            this.zza = null;
        }
        this.zzd = context.getPackageName();
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (this.zza != null) {
            zzb.zzd("unbind LMD display overlay service", new Object[0]);
            this.zza.zzr();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzfqr zzfqr, zzfrf zzfrf) {
        if (this.zza == null) {
            zzb.zzb("error: %s", "Play Store not found.");
            return;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzp(new zzfqx(this, taskCompletionSource, zzfqr, zzfrf, taskCompletionSource), taskCompletionSource);
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzfrc zzfrc, zzfrf zzfrf) {
        if (this.zza == null) {
            zzb.zzb("error: %s", "Play Store not found.");
        } else if (zzfrc.zzg() == null) {
            zzb.zzb("Failed to convert OverlayDisplayShowRequest when to create a new session: appId cannot be null.", new Object[0]);
            zzfrd zzc2 = zzfre.zzc();
            zzc2.zzb(8160);
            zzfrf.zza(zzc2.zzc());
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzp(new zzfqw(this, taskCompletionSource, zzfrc, zzfrf, taskCompletionSource), taskCompletionSource);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(zzfrh zzfrh, zzfrf zzfrf, int i) {
        if (this.zza == null) {
            zzb.zzb("error: %s", "Play Store not found.");
            return;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzp(new zzfqy(this, taskCompletionSource, zzfrh, i, zzfrf, taskCompletionSource), taskCompletionSource);
    }
}
