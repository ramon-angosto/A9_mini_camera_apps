package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzexf implements zzeve {
    final ScheduledExecutorService zza;
    final Context zzb;
    final zzbzg zzc;

    public zzexf(zzbzg zzbzg, ScheduledExecutorService scheduledExecutorService, Context context, byte[] bArr) {
        this.zzc = zzbzg;
        this.zza = scheduledExecutorService;
        this.zzb = context;
    }

    public final int zza() {
        return 49;
    }

    public final zzfzp zzb() {
        return zzfzg.zzm(zzfzg.zzo(zzfzg.zzi(new Bundle()), ((Long) zzay.zzc().zzb(zzbjc.zzdj)).longValue(), TimeUnit.MILLISECONDS, this.zza), zzexe.zza, zzchc.zza);
    }
}
