package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbaa {
    /* access modifiers changed from: private */
    public final ExecutorService zza = zzbar.zzl("Loader:ExtractorMediaPeriod");
    /* access modifiers changed from: private */
    public zzazx zzb;
    /* access modifiers changed from: private */
    public IOException zzc;

    public zzbaa(String str) {
    }

    public final long zza(zzazy zzazy, zzazw zzazw, int i) {
        Looper myLooper = Looper.myLooper();
        zzbac.zze(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzazx(this, myLooper, zzazy, zzazw, i, elapsedRealtime).zzc(0);
        return elapsedRealtime;
    }

    public final void zzf() {
        this.zzb.zza(false);
    }

    public final void zzg(int i) throws IOException {
        IOException iOException = this.zzc;
        if (iOException == null) {
            zzazx zzazx = this.zzb;
            if (zzazx != null) {
                zzazx.zzb(zzazx.zza);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzh(Runnable runnable) {
        zzazx zzazx = this.zzb;
        if (zzazx != null) {
            zzazx.zza(true);
        }
        this.zza.execute(runnable);
        this.zza.shutdown();
    }

    public final boolean zzi() {
        return this.zzb != null;
    }
}
