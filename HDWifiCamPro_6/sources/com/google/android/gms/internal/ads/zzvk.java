package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzvk {
    private final Spatializer zza;
    private final boolean zzb;
    private Handler zzc;
    private Spatializer.OnSpatializerStateChangedListener zzd;

    private zzvk(Spatializer spatializer) {
        this.zza = spatializer;
        this.zzb = spatializer.getImmersiveAudioLevel() != 0;
    }

    public static zzvk zza(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        return new zzvk(audioManager.getSpatializer());
    }

    public final void zzb(zzvr zzvr, Looper looper) {
        if (this.zzd == null && this.zzc == null) {
            this.zzd = new zzvj(this, zzvr);
            this.zzc = new Handler(looper);
            Spatializer spatializer = this.zza;
            Handler handler = this.zzc;
            handler.getClass();
            spatializer.addOnSpatializerStateChangedListener(new zzvi(handler), this.zzd);
        }
    }

    public final void zzc() {
        Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.zzd;
        if (onSpatializerStateChangedListener != null && this.zzc != null) {
            this.zza.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            Handler handler = this.zzc;
            int i = zzen.zza;
            handler.removeCallbacksAndMessages((Object) null);
            this.zzc = null;
            this.zzd = null;
        }
    }

    public final boolean zzd(zzk zzk, zzaf zzaf) {
        int i;
        if (!MimeTypes.AUDIO_E_AC3_JOC.equals(zzaf.zzm) || zzaf.zzz != 16) {
            i = zzaf.zzz;
        } else {
            i = 12;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(zzen.zzj(i));
        int i2 = zzaf.zzA;
        if (i2 != -1) {
            channelMask.setSampleRate(i2);
        }
        return this.zza.canBeSpatialized(zzk.zza().zza, channelMask.build());
    }

    public final boolean zze() {
        return this.zza.isAvailable();
    }

    public final boolean zzf() {
        return this.zza.isEnabled();
    }

    public final boolean zzg() {
        return this.zzb;
    }
}
