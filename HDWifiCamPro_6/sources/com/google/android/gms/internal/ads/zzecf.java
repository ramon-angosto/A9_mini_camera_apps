package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzecf {
    private final ScheduledExecutorService zza;
    private final zzfzq zzb;
    private final zzecw zzc;
    private final zzgxc zzd;

    public zzecf(ScheduledExecutorService scheduledExecutorService, zzfzq zzfzq, zzecw zzecw, zzgxc zzgxc) {
        this.zza = scheduledExecutorService;
        this.zzb = zzfzq;
        this.zzc = zzecw;
        this.zzd = zzgxc;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zza(zzcbc zzcbc, int i, Throwable th) throws Exception {
        return ((zzeek) this.zzd.zzb()).zzd(zzcbc, i);
    }

    public final zzfzp zzb(zzcbc zzcbc) {
        zzfzp zzfzp;
        String str = zzcbc.zzd;
        zzt.zzp();
        if (zzs.zzy(str)) {
            zzfzp = zzfzg.zzh(new zzedj(1));
        } else {
            zzecw zzecw = this.zzc;
            synchronized (zzecw.zzb) {
                if (zzecw.zzc) {
                    zzfzp = zzecw.zza;
                } else {
                    zzecw.zzc = true;
                    zzecw.zze = zzcbc;
                    zzecw.zzf.checkAvailabilityAndConnect();
                    zzecw.zza.zzc(new zzecv(zzecw), zzchc.zzf);
                    zzfzp = zzecw.zza;
                }
            }
        }
        int callingUid = Binder.getCallingUid();
        zzfyx zzv = zzfyx.zzv(zzfzp);
        long intValue = (long) ((Integer) zzay.zzc().zzb(zzbjc.zzeE)).intValue();
        return zzfzg.zzg((zzfyx) zzfzg.zzo(zzv, intValue, TimeUnit.SECONDS, this.zza), Throwable.class, new zzece(this, zzcbc, callingUid), this.zzb);
    }
}
