package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbxs implements zzo {
    final /* synthetic */ zzbxu zza;

    zzbxs(zzbxu zzbxu) {
        this.zza = zzbxu;
    }

    public final void zzb() {
        zzcgp.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbxu zzbxu = this.zza;
        zzbxu.zzb.onAdOpened(zzbxu);
    }

    public final void zzbC() {
        zzcgp.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    public final void zzbK() {
        zzcgp.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzbr() {
        zzcgp.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zze() {
    }

    public final void zzf(int i) {
        zzcgp.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbxu zzbxu = this.zza;
        zzbxu.zzb.onAdClosed(zzbxu);
    }
}
