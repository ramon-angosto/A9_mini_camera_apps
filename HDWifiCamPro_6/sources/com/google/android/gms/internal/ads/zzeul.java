package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.nonagon.signalgeneration.zzac;
import com.google.android.gms.ads.nonagon.signalgeneration.zzg;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeul implements zzeve {
    private final String zza;
    private final zzfzq zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzfef zze;
    private final zzcom zzf;

    zzeul(zzfzq zzfzq, ScheduledExecutorService scheduledExecutorService, String str, Context context, zzfef zzfef, zzcom zzcom) {
        this.zzb = zzfzq;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = context;
        this.zze = zzfef;
        this.zzf = zzcom;
    }

    public static /* synthetic */ zzfzp zzc(zzeul zzeul) {
        String str = zzeul.zza;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgj)).booleanValue()) {
            str = AdFormat.UNKNOWN.name();
        }
        zzg zzn = zzeul.zzf.zzn();
        zzdck zzdck = new zzdck();
        zzdck.zzc(zzeul.zzd);
        zzfed zzfed = new zzfed();
        zzfed.zzs("adUnitId");
        zzfed.zzE(zzeul.zze.zzd);
        zzfed.zzr(new zzq());
        zzdck.zzf(zzfed.zzG());
        zzn.zza(zzdck.zzg());
        zzac zzac = new zzac();
        zzac.zza(str);
        zzn.zzb(zzac.zzb());
        new zzdik();
        return zzfzg.zzf(zzfzg.zzm((zzfyx) zzfzg.zzo(zzfyx.zzv(zzn.zzc().zzc()), ((Long) zzay.zzc().zzb(zzbjc.zzgk)).longValue(), TimeUnit.MILLISECONDS, zzeul.zzc), zzeuj.zza, zzeul.zzb), Exception.class, zzeuk.zza, zzeul.zzb);
    }

    public final int zza() {
        return 33;
    }

    public final zzfzp zzb() {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgi)).booleanValue() || "adUnitId".equals(this.zze.zzf)) {
            return this.zzb.zzb(zzeuh.zza);
        }
        return zzfzg.zzl(new zzeui(this), this.zzb);
    }
}
