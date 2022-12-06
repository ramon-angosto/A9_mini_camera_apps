package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzww {
    public static final zzwq zza = new zzwq(0, C.TIME_UNSET, (zzwp) null);
    public static final zzwq zzb = new zzwq(1, C.TIME_UNSET, (zzwp) null);
    public static final zzwq zzc = new zzwq(2, C.TIME_UNSET, (zzwp) null);
    public static final zzwq zzd = new zzwq(3, C.TIME_UNSET, (zzwp) null);
    /* access modifiers changed from: private */
    public final ExecutorService zze = zzen.zzQ("ExoPlayer:Loader:ProgressiveMediaPeriod");
    /* access modifiers changed from: private */
    public zzwr zzf;
    /* access modifiers changed from: private */
    public IOException zzg;

    public zzww(String str) {
    }

    public static zzwq zzb(boolean z, long j) {
        return new zzwq(z ? 1 : 0, j, (zzwp) null);
    }

    public final long zza(zzws zzws, zzwo zzwo, int i) {
        Looper myLooper = Looper.myLooper();
        zzdd.zzb(myLooper);
        this.zzg = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzwr(this, myLooper, zzws, zzwo, i, elapsedRealtime).zzc(0);
        return elapsedRealtime;
    }

    public final void zzg() {
        zzwr zzwr = this.zzf;
        zzdd.zzb(zzwr);
        zzwr.zza(false);
    }

    public final void zzh() {
        this.zzg = null;
    }

    public final void zzi(int i) throws IOException {
        IOException iOException = this.zzg;
        if (iOException == null) {
            zzwr zzwr = this.zzf;
            if (zzwr != null) {
                zzwr.zzb(i);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzj(zzwt zzwt) {
        zzwr zzwr = this.zzf;
        if (zzwr != null) {
            zzwr.zza(true);
        }
        this.zze.execute(new zzwu(zzwt));
        this.zze.shutdown();
    }

    public final boolean zzk() {
        return this.zzg != null;
    }

    public final boolean zzl() {
        return this.zzf != null;
    }
}
