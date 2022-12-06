package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzerd implements zzeve {
    private final zzfzq zza;
    private final Context zzb;

    public zzerd(zzfzq zzfzq, Context context) {
        this.zza = zzfzq;
        this.zzb = context;
    }

    public final int zza() {
        return 13;
    }

    public final zzfzp zzb() {
        return this.zza.zzb(new zzerc(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzere zzc() throws Exception {
        int i;
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        int mode = audioManager.getMode();
        boolean isMusicActive = audioManager.isMusicActive();
        boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        int i2 = -1;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziD)).booleanValue()) {
            i = zzt.zzq().zzi(audioManager);
            i2 = audioManager.getStreamMaxVolume(3);
        } else {
            i = -1;
        }
        return new zzere(mode, isMusicActive, isSpeakerphoneOn, streamVolume, i, i2, audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzt.zzr().zza(), zzt.zzr().zze());
    }
}
