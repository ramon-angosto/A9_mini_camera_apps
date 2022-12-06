package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzkl {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Handler zzb;
    private final zzkh zzc;
    private final AudioManager zzd;
    private zzkk zze;
    private int zzf = 3;
    private int zzg = zzg(this.zzd, 3);
    private boolean zzh = zzi(this.zzd, this.zzf);

    public zzkl(Context context, Handler handler, zzkh zzkh) {
        this.zza = context.getApplicationContext();
        this.zzb = handler;
        this.zzc = zzkh;
        AudioManager audioManager = (AudioManager) this.zza.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        zzdd.zzb(audioManager);
        this.zzd = audioManager;
        zzkk zzkk = new zzkk(this, (zzkj) null);
        try {
            zzen.zzA(this.zza, zzkk, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.zze = zzkk;
        } catch (RuntimeException e) {
            zzdw.zzf("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    private static int zzg(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            zzdw.zzf("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i, e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    /* access modifiers changed from: private */
    public final void zzh() {
        int zzg2 = zzg(this.zzd, this.zzf);
        boolean zzi = zzi(this.zzd, this.zzf);
        if (this.zzg != zzg2 || this.zzh != zzi) {
            this.zzg = zzg2;
            this.zzh = zzi;
            zzdt zzz = ((zzip) this.zzc).zza.zzl;
            zzz.zzd(30, new zzik(zzg2, zzi));
            zzz.zzc();
        }
    }

    private static boolean zzi(AudioManager audioManager, int i) {
        if (zzen.zza >= 23) {
            return audioManager.isStreamMute(i);
        }
        return zzg(audioManager, i) == 0;
    }

    public final int zza() {
        return this.zzd.getStreamMaxVolume(this.zzf);
    }

    public final int zzb() {
        if (zzen.zza >= 28) {
            return this.zzd.getStreamMinVolume(this.zzf);
        }
        return 0;
    }

    public final void zze() {
        zzkk zzkk = this.zze;
        if (zzkk != null) {
            try {
                this.zza.unregisterReceiver(zzkk);
            } catch (RuntimeException e) {
                zzdw.zzf("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            this.zze = null;
        }
    }

    public final void zzf(int i) {
        if (this.zzf != 3) {
            this.zzf = 3;
            zzh();
            zzip zzip = (zzip) this.zzc;
            zzt zzy = zzit.zzam(zzip.zza.zzz);
            if (!zzy.equals(zzip.zza.zzac)) {
                zzip.zza.zzac = zzy;
                zzdt zzz = zzip.zza.zzl;
                zzz.zzd(29, new zzil(zzy));
                zzz.zzc();
            }
        }
    }
}
