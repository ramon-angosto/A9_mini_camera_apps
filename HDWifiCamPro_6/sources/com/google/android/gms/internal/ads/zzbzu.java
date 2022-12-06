package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbzu extends zzbzq {
    final /* synthetic */ UpdateImpressionUrlsCallback zza;

    zzbzu(zzbzz zzbzz, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza = updateImpressionUrlsCallback;
    }

    public final void zze(String str) {
        this.zza.onFailure(str);
    }

    public final void zzf(List list) {
        this.zza.onSuccess(list);
    }
}
