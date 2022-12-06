package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzor extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzou zza;
    final /* synthetic */ zzos zzb;

    zzor(zzos zzos, zzou zzou) {
        this.zzb = zzos;
        this.zza = zzou;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzou zzou = this.zzb.zza;
            if (zzou.zzq != null && zzou.zzR) {
                zzou.zzq.zzb();
            }
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzou zzou = this.zzb.zza;
            if (zzou.zzq != null && zzou.zzR) {
                zzou.zzq.zzb();
            }
        }
    }
}
