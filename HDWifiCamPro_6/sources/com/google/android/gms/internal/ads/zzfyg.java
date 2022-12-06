package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzfyg extends zzfyl {
    private static final Logger zza = Logger.getLogger(zzfyg.class.getName());
    @CheckForNull
    private zzfvi zzb;
    private final boolean zzc;
    private final boolean zze;

    zzfyg(zzfvi zzfvi, boolean z, boolean z2) {
        super(zzfvi.size());
        if (zzfvi != null) {
            this.zzb = zzfvi;
            this.zzc = z;
            this.zze = z2;
            return;
        }
        throw null;
    }

    private final void zzG(int i, Future future) {
        try {
            zzg(i, zzfzg.zzp(future));
        } catch (ExecutionException e) {
            zzI(e.getCause());
        } catch (Error | RuntimeException e2) {
            zzI(e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzH */
    public final void zzy(@CheckForNull zzfvi zzfvi) {
        int zzB = zzB();
        int i = 0;
        zzfsx.zzi(zzB >= 0, "Less than 0 remaining futures");
        if (zzB == 0) {
            if (zzfvi != null) {
                zzfxm zze2 = zzfvi.iterator();
                while (zze2.hasNext()) {
                    Future future = (Future) zze2.next();
                    if (!future.isCancelled()) {
                        zzG(i, future);
                    }
                    i++;
                }
            }
            zzF();
            zzv();
            zzz(2);
        }
    }

    private final void zzI(Throwable th) {
        if (th == null) {
            throw null;
        } else if (this.zzc && !zze(th) && zzK(zzE(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }

    private static void zzJ(Throwable th) {
        zza.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private static boolean zzK(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        zzfvi zzfvi = this.zzb;
        if (zzfvi == null) {
            return super.zza();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("futures=");
        sb.append(zzfvi);
        return "futures=".concat(zzfvi.toString());
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzfvi zzfvi = this.zzb;
        boolean z = true;
        zzz(1);
        boolean isCancelled = isCancelled();
        if (zzfvi == null) {
            z = false;
        }
        if (z && isCancelled) {
            boolean zzu = zzu();
            zzfxm zze2 = zzfvi.iterator();
            while (zze2.hasNext()) {
                ((Future) zze2.next()).cancel(zzu);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Set set) {
        if (set == null) {
            throw null;
        } else if (!isCancelled()) {
            Throwable zzp = zzp();
            zzp.getClass();
            zzK(set, zzp);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zzg(int i, Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzv();

    /* access modifiers changed from: package-private */
    public final void zzw() {
        zzfvi zzfvi = this.zzb;
        zzfvi.getClass();
        if (zzfvi.isEmpty()) {
            zzv();
        } else if (this.zzc) {
            zzfxm zze2 = this.zzb.iterator();
            int i = 0;
            while (zze2.hasNext()) {
                zzfzp zzfzp = (zzfzp) zze2.next();
                zzfzp.zzc(new zzfye(this, zzfzp, i), zzfyu.INSTANCE);
                i++;
            }
        } else {
            zzfyf zzfyf = new zzfyf(this, this.zze ? this.zzb : null);
            zzfxm zze3 = this.zzb.iterator();
            while (zze3.hasNext()) {
                ((zzfzp) zze3.next()).zzc(zzfyf, zzfyu.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(zzfzp zzfzp, int i) {
        try {
            if (zzfzp.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i, zzfzp);
            }
        } finally {
            zzy((zzfvi) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzz(int i) {
        this.zzb = null;
    }
}
