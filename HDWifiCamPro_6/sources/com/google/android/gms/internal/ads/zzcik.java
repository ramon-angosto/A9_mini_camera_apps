package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcik implements Runnable {
    final /* synthetic */ zzcim zza;

    zzcik(zzcim zzcim) {
        this.zza = zzcim;
    }

    public final void run() {
        this.zza.zzK("surfaceDestroyed", new String[0]);
    }
}
