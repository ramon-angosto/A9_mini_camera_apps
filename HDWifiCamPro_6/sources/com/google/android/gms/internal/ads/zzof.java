package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzof implements Runnable {
    public final /* synthetic */ AudioTrack zza;
    public final /* synthetic */ zzdg zzb;

    public /* synthetic */ zzof(AudioTrack audioTrack, zzdg zzdg) {
        this.zza = audioTrack;
        this.zzb = zzdg;
    }

    public final void run() {
        zzou.zzC(this.zza, this.zzb);
    }
}
