package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzchu implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcic zzb;

    zzchu(zzcic zzcic, MediaPlayer mediaPlayer) {
        this.zzb = zzcic;
        this.zza = mediaPlayer;
    }

    public final void run() {
        zzcic.zzl(this.zzb, this.zza);
        zzcic zzcic = this.zzb;
        if (zzcic.zzr != null) {
            zzcic.zzr.zzf();
        }
    }
}
