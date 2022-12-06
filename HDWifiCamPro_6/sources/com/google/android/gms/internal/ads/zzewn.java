package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzewn implements zzeve {
    private final Context zza;
    private final zzcfy zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final String zze;
    private final zzcfp zzf;

    public zzewn(zzcfp zzcfp, int i, Context context, zzcfy zzcfy, ScheduledExecutorService scheduledExecutorService, Executor executor, String str, byte[] bArr) {
        this.zzf = zzcfp;
        this.zza = context;
        this.zzb = zzcfy;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zze = str;
    }

    public final int zza() {
        return 44;
    }

    public final zzfzp zzb() {
        return zzfzg.zzf((zzfyx) zzfzg.zzo(zzfzg.zzm(zzfyx.zzv(zzfzg.zzl(new zzewk(this), this.zzd)), zzewl.zza, this.zzd), ((Long) zzay.zzc().zzb(zzbjc.zzaP)).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzewm(this), zzfzw.zzb());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzewo zzc(Exception exc) {
        this.zzb.zzt(exc, "AttestationTokenSignal");
        return null;
    }
}
