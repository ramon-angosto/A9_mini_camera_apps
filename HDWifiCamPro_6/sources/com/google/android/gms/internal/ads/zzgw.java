package com.google.android.gms.internal.ads;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgw implements zzjh {
    private final zzwi zza;
    private final long zzb = zzen.zzv(50000);
    private final long zzc = zzen.zzv(50000);
    private final long zzd = zzen.zzv(2500);
    private final long zze = zzen.zzv(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    private final long zzf = zzen.zzv(0);
    private int zzg = C.DEFAULT_VIDEO_BUFFER_SIZE;
    private boolean zzh;

    public zzgw() {
        zzwi zzwi = new zzwi(true, 65536);
        zzj(2500, 0, "bufferForPlaybackMs", MBridgeConstans.ENDCARD_URL_TYPE_PL);
        zzj(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS, 0, "bufferForPlaybackAfterRebufferMs", MBridgeConstans.ENDCARD_URL_TYPE_PL);
        zzj(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzj(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzj(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, "maxBufferMs", "minBufferMs");
        zzj(0, 0, "backBufferDurationMs", MBridgeConstans.ENDCARD_URL_TYPE_PL);
        this.zza = zzwi;
    }

    private static void zzj(int i, int i2, String str, String str2) {
        boolean z = i >= i2;
        zzdd.zze(z, str + " cannot be less than " + str2);
    }

    private final void zzk(boolean z) {
        this.zzg = C.DEFAULT_VIDEO_BUFFER_SIZE;
        this.zzh = false;
        if (z) {
            this.zza.zze();
        }
    }

    public final long zza() {
        return this.zzf;
    }

    public final void zzb() {
        zzk(false);
    }

    public final void zzc() {
        zzk(true);
    }

    public final void zzd() {
        zzk(true);
    }

    public final void zze(zzka[] zzkaArr, zzuh zzuh, zzvt[] zzvtArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = zzkaArr.length;
            int i3 = C.DEFAULT_VIDEO_BUFFER_SIZE;
            if (i < 2) {
                if (zzvtArr[i] != null) {
                    if (zzkaArr[i].zzb() != 1) {
                        i3 = 131072000;
                    }
                    i2 += i3;
                }
                i++;
            } else {
                int max = Math.max(C.DEFAULT_VIDEO_BUFFER_SIZE, i2);
                this.zzg = max;
                this.zza.zzf(max);
                return;
            }
        }
    }

    public final boolean zzf() {
        return false;
    }

    public final boolean zzg(long j, long j2, float f) {
        int zza2 = this.zza.zza();
        int i = this.zzg;
        long j3 = this.zzb;
        if (f > 1.0f) {
            j3 = Math.min(zzen.zzs(j3, f), this.zzc);
        }
        int i2 = (j2 > Math.max(j3, 500000) ? 1 : (j2 == Math.max(j3, 500000) ? 0 : -1));
        boolean z = false;
        if (i2 < 0) {
            if (zza2 < i) {
                z = true;
            }
            this.zzh = z;
            if (!z && j2 < 500000) {
                zzdw.zze("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.zzc || zza2 >= i) {
            this.zzh = false;
        }
        return this.zzh;
    }

    public final boolean zzh(long j, float f, boolean z, long j2) {
        long j3;
        long zzu = zzen.zzu(j, f);
        if (z) {
            j3 = this.zze;
        } else {
            j3 = this.zzd;
        }
        if (j2 != C.TIME_UNSET) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || zzu >= j3 || this.zza.zza() >= this.zzg;
    }

    public final zzwi zzi() {
        return this.zza;
    }
}
