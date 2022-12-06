package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzxq implements Choreographer.FrameCallback, Handler.Callback {
    private static final zzxq zzb = new zzxq();
    public volatile long zza = C.TIME_UNSET;
    private final Handler zzc;
    private final HandlerThread zzd = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
    private Choreographer zze;
    private int zzf;

    private zzxq() {
        this.zzd.start();
        this.zzc = zzen.zzC(this.zzd.getLooper(), this);
        this.zzc.sendEmptyMessage(0);
    }

    public static zzxq zza() {
        return zzb;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            try {
                this.zze = Choreographer.getInstance();
            } catch (RuntimeException e) {
                zzdw.zzf("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e);
            }
            return true;
        } else if (i == 1) {
            Choreographer choreographer = this.zze;
            if (choreographer != null) {
                int i2 = this.zzf + 1;
                this.zzf = i2;
                if (i2 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            Choreographer choreographer2 = this.zze;
            if (choreographer2 != null) {
                int i3 = this.zzf - 1;
                this.zzf = i3;
                if (i3 == 0) {
                    choreographer2.removeFrameCallback(this);
                    this.zza = C.TIME_UNSET;
                }
            }
            return true;
        }
    }

    public final void zzb() {
        this.zzc.sendEmptyMessage(1);
    }

    public final void zzc() {
        this.zzc.sendEmptyMessage(2);
    }

    public final void doFrame(long j) {
        this.zza = j;
        Choreographer choreographer = this.zze;
        if (choreographer != null) {
            choreographer.postFrameCallbackDelayed(this, 500);
            return;
        }
        throw null;
    }
}
