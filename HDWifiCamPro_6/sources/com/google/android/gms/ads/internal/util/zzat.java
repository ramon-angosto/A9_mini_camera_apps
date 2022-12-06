package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzcx;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzat extends zzcx {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzaw zzb;

    zzat(zzaw zzaw, Context context) {
        this.zzb = zzaw;
        this.zza = context;
    }

    public final void zze(zze zze) {
        if (zze != null) {
            this.zzb.zzi(this.zza, zze.zzb, true, true);
        }
    }
}
