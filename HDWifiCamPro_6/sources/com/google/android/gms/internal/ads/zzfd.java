package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfd implements zzew {
    private final Context zza;
    private final zzew zzb;

    public zzfd(Context context) {
        zzff zzff = new zzff();
        this.zza = context.getApplicationContext();
        this.zzb = zzff;
    }

    public final /* bridge */ /* synthetic */ zzex zza() {
        return new zzfe(this.zza, ((zzff) this.zzb).zza());
    }
}
