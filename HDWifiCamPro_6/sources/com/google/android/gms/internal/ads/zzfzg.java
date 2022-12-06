package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfzg extends zzfzi {
    public static zzfzf zza(Iterable iterable) {
        return new zzfzf(false, zzfvn.zzl(iterable), (zzfzd) null);
    }

    @SafeVarargs
    public static zzfzf zzb(zzfzp... zzfzpArr) {
        return new zzfzf(false, zzfvn.zzn(zzfzpArr), (zzfzd) null);
    }

    public static zzfzf zzc(Iterable iterable) {
        return new zzfzf(true, zzfvn.zzl(iterable), (zzfzd) null);
    }

    @SafeVarargs
    public static zzfzf zzd(zzfzp... zzfzpArr) {
        return new zzfzf(true, zzfvn.zzn(zzfzpArr), (zzfzd) null);
    }

    public static zzfzp zze(Iterable iterable) {
        return new zzfyo(zzfvn.zzl(iterable), true);
    }

    public static zzfzp zzf(zzfzp zzfzp, Class cls, zzfsm zzfsm, Executor executor) {
        zzfxv zzfxv = new zzfxv(zzfzp, cls, zzfsm);
        zzfzp.zzc(zzfxv, zzfzw.zzc(executor, zzfxv));
        return zzfxv;
    }

    public static zzfzp zzg(zzfzp zzfzp, Class cls, zzfyn zzfyn, Executor executor) {
        zzfxu zzfxu = new zzfxu(zzfzp, cls, zzfyn);
        zzfzp.zzc(zzfxu, zzfzw.zzc(executor, zzfxu));
        return zzfxu;
    }

    public static zzfzp zzh(Throwable th) {
        if (th != null) {
            return new zzfzj(th);
        }
        throw null;
    }

    public static zzfzp zzi(Object obj) {
        if (obj == null) {
            return zzfzk.zza;
        }
        return new zzfzk(obj);
    }

    public static zzfzp zzj() {
        return zzfzk.zza;
    }

    public static zzfzp zzk(Callable callable, Executor executor) {
        zzgaf zzgaf = new zzgaf(callable);
        executor.execute(zzgaf);
        return zzgaf;
    }

    public static zzfzp zzl(zzfym zzfym, Executor executor) {
        zzgaf zzgaf = new zzgaf(zzfym);
        executor.execute(zzgaf);
        return zzgaf;
    }

    public static zzfzp zzm(zzfzp zzfzp, zzfsm zzfsm, Executor executor) {
        int i = zzfyd.zzc;
        if (zzfsm != null) {
            zzfyc zzfyc = new zzfyc(zzfzp, zzfsm);
            zzfzp.zzc(zzfyc, zzfzw.zzc(executor, zzfyc));
            return zzfyc;
        }
        throw null;
    }

    public static zzfzp zzn(zzfzp zzfzp, zzfyn zzfyn, Executor executor) {
        int i = zzfyd.zzc;
        if (executor != null) {
            zzfyb zzfyb = new zzfyb(zzfzp, zzfyn);
            zzfzp.zzc(zzfyb, zzfzw.zzc(executor, zzfyb));
            return zzfyb;
        }
        throw null;
    }

    public static zzfzp zzo(zzfzp zzfzp, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzfzp.isDone()) {
            return zzfzp;
        }
        return zzgac.zzg(zzfzp, j, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgah.zza(future);
        }
        throw new IllegalStateException(zzftm.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgah.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzfyv((Error) cause);
            }
            throw new zzgag(cause);
        }
    }

    public static void zzr(zzfzp zzfzp, zzfzc zzfzc, Executor executor) {
        if (zzfzc != null) {
            zzfzp.zzc(new zzfze(zzfzp, zzfzc), executor);
            return;
        }
        throw null;
    }
}
