package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfis implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzfis(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Object obj;
        zzgxc zza2 = zzgxh.zza(this.zza);
        zzgxc zza3 = zzgxh.zza(this.zzb);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzc.zzb();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzht)).booleanValue()) {
            obj = new zzfiu((zzfir) zza2.zzb(), scheduledExecutorService);
        } else {
            obj = (zzfir) zza3.zzb();
        }
        zzgxq.zzb(obj);
        return obj;
    }
}
