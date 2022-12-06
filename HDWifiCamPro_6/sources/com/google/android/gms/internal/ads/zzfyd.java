package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzfyd extends zzfyw implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    @CheckForNull
    zzfzp zza;
    @CheckForNull
    Object zzb;

    zzfyd(zzfzp zzfzp, Object obj) {
        if (zzfzp != null) {
            this.zza = zzfzp;
            if (obj != null) {
                this.zzb = obj;
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void run() {
        zzfzp zzfzp = this.zza;
        Object obj = this.zzb;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzfzp == null);
        if (obj != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.zza = null;
            if (zzfzp.isCancelled()) {
                zzt(zzfzp);
                return;
            }
            try {
                try {
                    Object zzf = zzf(obj, zzfzg.zzp(zzfzp));
                    this.zzb = null;
                    zzg(zzf);
                } catch (Throwable th) {
                    this.zzb = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                zze(e.getCause());
            } catch (RuntimeException e2) {
                zze(e2);
            } catch (Error e3) {
                zze(e3);
            }
        }
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        String str;
        zzfzp zzfzp = this.zza;
        Object obj = this.zzb;
        String zza2 = super.zza();
        if (zzfzp != null) {
            str = "inputFuture=[" + zzfzp + "], ";
        } else {
            str = "";
        }
        if (obj != null) {
            return str + "function=[" + obj + "]";
        } else if (zza2 != null) {
            return str.concat(zza2);
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzs(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zzf(Object obj, Object obj2) throws Exception;

    /* access modifiers changed from: package-private */
    public abstract void zzg(Object obj);
}
