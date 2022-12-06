package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzewh implements zzeve {
    private final zzcfy zza;
    private final String zzb;
    private final ScheduledExecutorService zzc;
    private final zzfzq zzd;
    private final zzbds zze;

    zzewh(String str, zzbds zzbds, zzcfy zzcfy, ScheduledExecutorService scheduledExecutorService, zzfzq zzfzq, byte[] bArr) {
        this.zzb = str;
        this.zze = zzbds;
        this.zza = zzcfy;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfzq;
    }

    public final int zza() {
        return 43;
    }

    public final zzfzp zzb() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcm)).booleanValue()) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzcr)).booleanValue()) {
                zzfzp zzn = zzfzg.zzn(zzfqc.zza(Tasks.forResult(null)), zzewf.zza, this.zzd);
                if (((Boolean) zzbkh.zza.zze()).booleanValue()) {
                    zzn = zzfzg.zzo(zzn, ((Long) zzbkh.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzfzg.zzf(zzn, Exception.class, new zzewg(this), this.zzd);
            }
        }
        return zzfzg.zzi(new zzewi((String) null, -1));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzewi zzc(Exception exc) {
        this.zza.zzt(exc, "AppSetIdInfoGmscoreSignal");
        return new zzewi((String) null, -1);
    }
}
