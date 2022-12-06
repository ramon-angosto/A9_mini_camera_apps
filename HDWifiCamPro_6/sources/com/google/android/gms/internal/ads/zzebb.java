package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzebb extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzebe zzb;

    zzebb(zzebe zzebe, String str) {
        this.zzb = zzebe;
        this.zza = str;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzj(zzebe.zzi(loadAdError), this.zza);
    }
}
