package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzczs {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzfzp zzc;
    private volatile boolean zzd = true;

    public zzczs(Executor executor, ScheduledExecutorService scheduledExecutorService, zzfzp zzfzp) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzfzp;
    }

    static /* bridge */ /* synthetic */ void zzb(zzczs zzczs, List list, zzfzc zzfzc) {
        if (list == null || list.isEmpty()) {
            zzczs.zza.execute(new zzczm(zzfzc));
            return;
        }
        zzfzp zzi = zzfzg.zzi((Object) null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzi = zzfzg.zzn(zzfzg.zzg(zzi, Throwable.class, new zzczn(zzfzc), zzczs.zza), new zzczo(zzczs, zzfzc, (zzfzp) it.next()), zzczs.zza);
        }
        zzfzg.zzr(zzi, new zzczr(zzczs, zzfzc), zzczs.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zza(zzfzc zzfzc, zzfzp zzfzp, zzcze zzcze) throws Exception {
        if (zzcze != null) {
            zzfzc.zzb(zzcze);
        }
        return zzfzg.zzo(zzfzp, ((Long) zzble.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzfzc zzfzc) {
        zzfzg.zzr(this.zzc, new zzczq(this, zzfzc), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
