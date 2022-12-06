package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdpn implements Runnable {
    public final /* synthetic */ zzdpq zza;
    public final /* synthetic */ ViewGroup zzb;

    public /* synthetic */ zzdpn(zzdpq zzdpq, ViewGroup viewGroup) {
        this.zza = zzdpq;
        this.zzb = viewGroup;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
