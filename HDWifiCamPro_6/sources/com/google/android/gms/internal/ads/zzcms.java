package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcms implements Runnable {
    public final /* synthetic */ zzcmw zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzcdq zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzcms(zzcmw zzcmw, View view, zzcdq zzcdq, int i) {
        this.zza = zzcmw;
        this.zzb = view;
        this.zzc = zzcdq;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc, this.zzd);
    }
}
