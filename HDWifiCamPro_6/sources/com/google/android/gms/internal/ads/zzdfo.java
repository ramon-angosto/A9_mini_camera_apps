package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdfo implements Runnable {
    private final WeakReference zza;

    /* synthetic */ zzdfo(zzdfp zzdfp, zzdfn zzdfn) {
        this.zza = new WeakReference(zzdfp);
    }

    public final void run() {
        zzdfp zzdfp = (zzdfp) this.zza.get();
        if (zzdfp != null) {
            zzdfp.zzo(zzdfm.zza);
        }
    }
}
