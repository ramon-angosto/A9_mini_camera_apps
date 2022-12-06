package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgo implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ zzgq zza;
    private final Handler zzb;

    public zzgo(zzgq zzgq, Handler handler) {
        this.zza = zzgq;
        this.zzb = handler;
    }

    public final void onAudioFocusChange(int i) {
        this.zzb.post(new zzgn(this, i));
    }
}
