package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcdj implements Runnable {
    public final /* synthetic */ zzcdl zza;
    public final /* synthetic */ Bitmap zzb;

    public /* synthetic */ zzcdj(zzcdl zzcdl, Bitmap bitmap) {
        this.zza = zzcdl;
        this.zzb = bitmap;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
