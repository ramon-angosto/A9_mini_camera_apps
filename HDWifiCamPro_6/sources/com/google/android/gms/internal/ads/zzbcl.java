package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbcl implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzbcp zzb;

    zzbcl(zzbcp zzbcp, View view) {
        this.zzb = zzbcp;
        this.zza = view;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
