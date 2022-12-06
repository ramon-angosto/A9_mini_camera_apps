package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgm {
    private final Context zza;
    private final zzgk zzb;

    public zzgm(Context context, Handler handler, zzgl zzgl) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzgk(this, handler, zzgl);
    }
}
