package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfhy {
    final /* synthetic */ zzfhz zza;
    private final Object zzb;
    private final String zzc;
    private final zzfzp zzd;
    private final List zze;
    private final zzfzp zzf;

    private zzfhy(zzfhz zzfhz, Object obj, String str, zzfzp zzfzp, List list, zzfzp zzfzp2) {
        this.zza = zzfhz;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = zzfzp;
        this.zze = list;
        this.zzf = zzfzp2;
    }

    /* synthetic */ zzfhy(zzfhz zzfhz, Object obj, String str, zzfzp zzfzp, List list, zzfzp zzfzp2, zzfhx zzfhx) {
        this(zzfhz, obj, (String) null, zzfzp, list, zzfzp2);
    }

    public final zzfhm zza() {
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzf(obj);
        }
        zzfhm zzfhm = new zzfhm(obj, str, this.zzf);
        this.zza.zzd.zza(zzfhm);
        this.zzd.zzc(new zzfhs(this, zzfhm), zzchc.zzf);
        zzfzg.zzr(zzfhm, new zzfhw(this, zzfhm), zzchc.zzf);
        return zzfhm;
    }

    public final zzfhy zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfhy zzc(Class cls, zzfyn zzfyn) {
        zzfhz zzfhz = this.zza;
        return new zzfhy(zzfhz, this.zzb, this.zzc, this.zzd, this.zze, zzfzg.zzg(this.zzf, cls, zzfyn, zzfhz.zzb));
    }

    public final zzfhy zzd(zzfzp zzfzp) {
        return zzg(new zzfht(zzfzp), zzchc.zzf);
    }

    public final zzfhy zze(zzfhk zzfhk) {
        return zzf(new zzfhv(zzfhk));
    }

    public final zzfhy zzf(zzfyn zzfyn) {
        return zzg(zzfyn, this.zza.zzb);
    }

    public final zzfhy zzg(zzfyn zzfyn, Executor executor) {
        return new zzfhy(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzfzg.zzn(this.zzf, zzfyn, executor));
    }

    public final zzfhy zzh(String str) {
        return new zzfhy(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfhy zzi(long j, TimeUnit timeUnit) {
        zzfhz zzfhz = this.zza;
        return new zzfhy(zzfhz, this.zzb, this.zzc, this.zzd, this.zze, zzfzg.zzo(this.zzf, j, timeUnit, zzfhz.zzc));
    }
}
