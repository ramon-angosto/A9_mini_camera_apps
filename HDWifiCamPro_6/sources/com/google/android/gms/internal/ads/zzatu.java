package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzatu extends Thread {
    final /* synthetic */ AudioTrack zza;
    final /* synthetic */ zzaue zzb;

    zzatu(zzaue zzaue, AudioTrack audioTrack) {
        this.zzb = zzaue;
        this.zza = audioTrack;
    }

    public final void run() {
        try {
            this.zza.flush();
            this.zza.release();
        } finally {
            this.zzb.zze.open();
        }
    }
}
