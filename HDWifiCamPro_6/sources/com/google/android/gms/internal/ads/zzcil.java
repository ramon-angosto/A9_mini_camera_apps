package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcil implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcim zzb;

    zzcil(zzcim zzcim, boolean z) {
        this.zzb = zzcim;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
