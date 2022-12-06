package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeqw implements zzeve {
    final zzcfy zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzfzq zzd;
    private final Context zze;

    zzeqw(Context context, zzcfy zzcfy, ScheduledExecutorService scheduledExecutorService, zzfzq zzfzq) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzcq)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzcfy;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfzq;
    }

    public final int zza() {
        return 11;
    }

    public final zzfzp zzb() {
        Task<AppSetIdInfo> task;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcm)).booleanValue()) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzcr)).booleanValue()) {
                if (!((Boolean) zzay.zzc().zzb(zzbjc.zzcn)).booleanValue()) {
                    return zzfzg.zzm(zzfqc.zza(this.zzb.getAppSetIdInfo()), zzeqt.zza, zzchc.zzf);
                }
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzcq)).booleanValue()) {
                    task = zzffh.zza(this.zze);
                } else {
                    task = this.zzb.getAppSetIdInfo();
                }
                if (task == null) {
                    return zzfzg.zzi(new zzeqx((String) null, -1));
                }
                zzfzp zzn = zzfzg.zzn(zzfqc.zza(task), zzequ.zza, zzchc.zzf);
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzco)).booleanValue()) {
                    zzn = zzfzg.zzo(zzn, ((Long) zzay.zzc().zzb(zzbjc.zzcp)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzfzg.zzf(zzn, Exception.class, new zzeqv(this), this.zzd);
            }
        }
        return zzfzg.zzi(new zzeqx((String) null, -1));
    }
}
