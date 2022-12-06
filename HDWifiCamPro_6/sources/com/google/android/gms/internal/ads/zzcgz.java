package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcgz implements Executor {
    private final Handler zza = new zzf(Looper.getMainLooper());

    zzcgz() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzt.zzp();
                zzs.zzI(zzt.zzo().zzc(), th);
                throw th;
            }
        } else {
            this.zza.post(runnable);
        }
    }
}
