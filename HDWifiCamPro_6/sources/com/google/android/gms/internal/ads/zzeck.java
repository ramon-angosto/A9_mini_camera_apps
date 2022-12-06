package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeck implements zzedi {
    /* access modifiers changed from: private */
    public static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzebl zzb;
    private final zzfzq zzc;
    private final zzfef zzd;
    private final ScheduledExecutorService zze;
    /* access modifiers changed from: private */
    public final zzefo zzf;
    private final zzfju zzg;
    private final Context zzh;

    zzeck(Context context, zzfef zzfef, zzebl zzebl, zzfzq zzfzq, ScheduledExecutorService scheduledExecutorService, zzefo zzefo, zzfju zzfju) {
        this.zzh = context;
        this.zzd = zzfef;
        this.zzb = zzebl;
        this.zzc = zzfzq;
        this.zze = scheduledExecutorService;
        this.zzf = zzefo;
        this.zzg = zzfju;
    }

    public final zzfzp zzb(zzcbc zzcbc) {
        zzfzp zzb2 = this.zzb.zzb(zzcbc);
        zzfjj zza2 = zzfji.zza(this.zzh, 11);
        zzfjt.zzd(zzb2, zza2);
        zzfzp zzn = zzfzg.zzn(zzb2, new zzech(this), this.zzc);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeD)).booleanValue()) {
            zzn = zzfzg.zzg(zzfzg.zzo(zzn, (long) ((Integer) zzay.zzc().zzb(zzbjc.zzeE)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, zzeci.zza, zzchc.zzf);
        }
        zzfjt.zza(zzn, this.zzg, zza2);
        zzfzg.zzr(zzn, new zzecj(this), zzchc.zzf);
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(InputStream inputStream) throws Exception {
        return zzfzg.zzi(new zzfdw(new zzfdt(this.zzd), zzfdv.zza(new InputStreamReader(inputStream))));
    }
}
