package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgq {
    private final AudioManager zza;
    private final zzgo zzb;
    private zzgp zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzgq(Context context, Handler handler, zzgp zzgp) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            this.zza = audioManager;
            this.zzc = zzgp;
            this.zzb = new zzgo(this, handler);
            this.zzd = 0;
            return;
        }
        throw null;
    }

    private final void zze() {
        if (this.zzd != 0) {
            if (zzen.zza < 26) {
                this.zza.abandonAudioFocus(this.zzb);
            }
            zzg(0);
        }
    }

    private final void zzf(int i) {
        zzgp zzgp = this.zzc;
        if (zzgp != null) {
            zzip zzip = (zzip) zzgp;
            boolean zzq = zzip.zza.zzq();
            zzip.zza.zzau(zzq, i, zzit.zzah(zzq, i));
        }
    }

    private final void zzg(int i) {
        if (this.zzd != i) {
            this.zzd = i;
            float f = i == 3 ? 0.2f : 1.0f;
            if (this.zze != f) {
                this.zze = f;
                zzgp zzgp = this.zzc;
                if (zzgp != null) {
                    ((zzip) zzgp).zza.zzar();
                }
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z, int i) {
        zze();
        return z ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }

    static /* bridge */ /* synthetic */ void zzc(zzgq zzgq, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzgq.zzg(3);
                return;
            }
            zzgq.zzf(0);
            zzgq.zzg(2);
        } else if (i == -1) {
            zzgq.zzf(-1);
            zzgq.zze();
        } else if (i != 1) {
            zzdw.zze("AudioFocusManager", "Unknown focus change type: " + i);
        } else {
            zzgq.zzg(1);
            zzgq.zzf(1);
        }
    }
}
