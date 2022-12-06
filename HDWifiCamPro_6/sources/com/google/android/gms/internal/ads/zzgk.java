package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgk extends BroadcastReceiver implements Runnable {
    final /* synthetic */ zzgm zza;
    private final zzgl zzb;
    private final Handler zzc;

    public zzgk(zzgm zzgm, Handler handler, zzgl zzgl) {
        this.zza = zzgm;
        this.zzc = handler;
        this.zzb = zzgl;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zzc.post(this);
        }
    }

    public final void run() {
    }
}
