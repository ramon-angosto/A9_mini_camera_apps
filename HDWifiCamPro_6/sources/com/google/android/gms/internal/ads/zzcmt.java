package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcmt implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzcdq zza;
    final /* synthetic */ zzcmw zzb;

    zzcmt(zzcmw zzcmw, zzcdq zzcdq) {
        this.zzb = zzcmw;
        this.zza = zzcdq;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzQ(view, this.zza, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
