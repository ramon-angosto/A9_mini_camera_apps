package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzebl {
    private final zzfzq zza;
    private final zzfzq zzb;
    private final zzecs zzc;
    private final zzgxc zzd;

    public zzebl(zzfzq zzfzq, zzfzq zzfzq2, zzecs zzecs, zzgxc zzgxc) {
        this.zza = zzfzq;
        this.zzb = zzfzq2;
        this.zzc = zzecs;
        this.zzd = zzgxc;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zza(zzcbc zzcbc, int i, zzedj zzedj) throws Exception {
        return ((zzeek) this.zzd.zzb()).zzc(zzcbc, i);
    }

    public final zzfzp zzb(zzcbc zzcbc) {
        zzfzp zzfzp;
        String str = zzcbc.zzd;
        zzt.zzp();
        if (zzs.zzy(str)) {
            zzfzp = zzfzg.zzh(new zzedj(1));
        } else {
            zzfzp = zzfzg.zzg(this.zza.zzb(new zzebi(this, zzcbc)), ExecutionException.class, zzebj.zza, this.zzb);
        }
        return zzfzg.zzg(zzfzp, zzedj.class, new zzebk(this, zzcbc, Binder.getCallingUid()), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzc(zzcbc zzcbc) throws Exception {
        zzchh zzchh;
        zzecs zzecs = this.zzc;
        synchronized (zzecs.zzb) {
            if (zzecs.zzc) {
                zzchh = zzecs.zza;
            } else {
                zzecs.zzc = true;
                zzecs.zze = zzcbc;
                zzecs.zzf.checkAvailabilityAndConnect();
                zzecs.zza.zzc(new zzecr(zzecs), zzchc.zzf);
                zzchh = zzecs.zza;
            }
        }
        return (InputStream) zzchh.get((long) ((Integer) zzay.zzc().zzb(zzbjc.zzeE)).intValue(), TimeUnit.SECONDS);
    }
}
