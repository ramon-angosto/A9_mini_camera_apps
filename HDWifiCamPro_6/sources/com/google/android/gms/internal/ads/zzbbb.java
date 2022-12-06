package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbbb implements Choreographer.FrameCallback, Handler.Callback {
    private static final zzbbb zzb = new zzbbb();
    public volatile long zza;
    private final Handler zzc;
    private final HandlerThread zzd = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer zze;
    private int zzf;

    private zzbbb() {
        this.zzd.start();
        this.zzc = new Handler(this.zzd.getLooper(), this);
        this.zzc.sendEmptyMessage(0);
    }

    public static zzbbb zza() {
        return zzb;
    }

    public final void doFrame(long j) {
        this.zza = j;
        this.zze.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.zze = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            int i2 = this.zzf + 1;
            this.zzf = i2;
            if (i2 == 1) {
                this.zze.postFrameCallback(this);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i3 = this.zzf - 1;
            this.zzf = i3;
            if (i3 == 0) {
                this.zze.removeFrameCallback(this);
                this.zza = 0;
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
}
