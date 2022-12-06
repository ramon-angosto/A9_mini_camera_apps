package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbxt implements Runnable {
    final /* synthetic */ AdOverlayInfoParcel zza;
    final /* synthetic */ zzbxu zzb;

    zzbxt(zzbxu zzbxu, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzb = zzbxu;
        this.zza = adOverlayInfoParcel;
    }

    public final void run() {
        zzt.zzi();
        zzm.zza(this.zzb.zza, this.zza, true);
    }
}
