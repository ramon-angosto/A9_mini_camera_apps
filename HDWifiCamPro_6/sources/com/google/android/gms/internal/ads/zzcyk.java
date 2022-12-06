package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcyk extends zzcxc {
    private final zzbnv zzc;
    private final Runnable zzd;
    private final Executor zze;

    public zzcyk(zzczd zzczd, zzbnv zzbnv, Runnable runnable, Executor executor) {
        super(zzczd);
        this.zzc = zzbnv;
        this.zzd = runnable;
        this.zze = executor;
    }

    static /* synthetic */ void zzi(AtomicReference atomicReference) {
        Runnable runnable = (Runnable) atomicReference.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void zzW() {
        this.zze.execute(new zzcyj(this, new zzcyi(new AtomicReference(this.zzd))));
    }

    public final int zza() {
        return 0;
    }

    public final View zzc() {
        return null;
    }

    public final zzdk zzd() {
        return null;
    }

    public final zzfdl zze() {
        return null;
    }

    public final zzfdl zzf() {
        return null;
    }

    public final void zzg() {
    }

    public final void zzh(ViewGroup viewGroup, zzq zzq) {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Runnable runnable) {
        try {
            if (!this.zzc.zzb(ObjectWrapper.wrap(runnable))) {
                zzi(((zzcyi) runnable).zza);
            }
        } catch (RemoteException unused) {
            zzi(((zzcyi) runnable).zza);
        }
    }
}
