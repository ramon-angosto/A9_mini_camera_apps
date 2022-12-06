package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfmf implements Runnable {
    zzfmf() {
    }

    public final void run() {
        if (zzfmi.zzc != null) {
            zzfmi.zzc.post(zzfmi.zzd);
            zzfmi.zzc.postDelayed(zzfmi.zze, 200);
        }
    }
}
