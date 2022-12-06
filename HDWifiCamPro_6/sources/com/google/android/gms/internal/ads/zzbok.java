package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.internal.client.zzbs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbok implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ zzbs zzb;
    final /* synthetic */ zzbol zzc;

    zzbok(zzbol zzbol, AdManagerAdView adManagerAdView, zzbs zzbs) {
        this.zzc = zzbol;
        this.zza = adManagerAdView;
        this.zzb = zzbs;
    }

    public final void run() {
        if (this.zza.zzb(this.zzb)) {
            this.zzc.zza.onAdManagerAdViewLoaded(this.zza);
        } else {
            zzcgp.zzj("Could not bind.");
        }
    }
}
