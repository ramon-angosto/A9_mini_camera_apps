package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzext implements zzeve {
    private final zzcfy zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzfzq zze;
    private final String zzf;
    private final zzcfn zzg;

    zzext(zzcfy zzcfy, boolean z, boolean z2, zzcfn zzcfn, zzfzq zzfzq, String str, ScheduledExecutorService scheduledExecutorService, byte[] bArr) {
        this.zza = zzcfy;
        this.zzb = z;
        this.zzc = z2;
        this.zzg = zzcfn;
        this.zze = zzfzq;
        this.zzf = str;
        this.zzd = scheduledExecutorService;
    }

    public final int zza() {
        return 50;
    }

    public final zzfzp zzb() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgm)).booleanValue() && this.zzc) {
            return zzfzg.zzi((Object) null);
        }
        if (!this.zzb) {
            return zzfzg.zzi((Object) null);
        }
        return zzfzg.zzf(zzfzg.zzo(zzfzg.zzm(zzfzg.zzi((Object) null), zzexr.zza, this.zze), ((Long) zzblf.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzexs(this), this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzexu zzc(Exception exc) {
        this.zza.zzt(exc, "TrustlessTokenSignal");
        return null;
    }
}
