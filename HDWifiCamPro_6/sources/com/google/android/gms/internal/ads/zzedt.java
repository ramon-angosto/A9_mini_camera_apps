package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzedt {
    private final zzfzq zza;
    private final zzeda zzb;
    private final zzgxc zzc;

    public zzedt(zzfzq zzfzq, zzeda zzeda, zzgxc zzgxc) {
        this.zza = zzfzq;
        this.zzb = zzeda;
        this.zzc = zzgxc;
    }

    private final zzfzp zzg(zzcbc zzcbc, zzeds zzeds, zzeds zzeds2, zzfyn zzfyn) {
        zzfzp zzfzp;
        String str = zzcbc.zzd;
        zzt.zzp();
        if (zzs.zzy(str)) {
            zzfzp = zzfzg.zzh(new zzedj(1));
        } else {
            zzfzp = zzfzg.zzg(zzeds.zza(zzcbc), ExecutionException.class, zzedk.zza, this.zza);
        }
        return zzfzg.zzg(zzfzg.zzn(zzfyx.zzv(zzfzp), zzfyn, this.zza), zzedj.class, new zzedr(this, zzeds2, zzcbc, zzfyn), this.zza);
    }

    public final zzfzp zza(zzcbc zzcbc) {
        return zzg(zzcbc, new zzedp(this.zzb), new zzedq(this), new zzedo(zzcbc));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzb(zzeds zzeds, zzcbc zzcbc, zzfyn zzfyn, zzedj zzedj) throws Exception {
        return zzfzg.zzn(zzeds.zza(zzcbc), zzfyn, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(zzcbc zzcbc) {
        return ((zzeek) this.zzc.zzb()).zzb(zzcbc, Binder.getCallingUid());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzd(zzcbc zzcbc) {
        String str;
        zzeda zzeda = this.zzb;
        if (((Boolean) zzbky.zzd.zze()).booleanValue()) {
            str = zzcbc.zzh;
        } else {
            str = zzcbc.zzj;
        }
        return zzeda.zzc(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zze(zzcbc zzcbc) {
        String str;
        zzeek zzeek = (zzeek) this.zzc.zzb();
        if (((Boolean) zzbky.zzd.zze()).booleanValue()) {
            str = zzcbc.zzh;
        } else {
            str = zzcbc.zzj;
        }
        return zzeek.zzi(str);
    }

    public final zzfzp zzf(zzcbc zzcbc) {
        if (zzaqh.zzg(zzcbc.zzj)) {
            return zzfzg.zzh(new zzebh(2, "Pool key missing from removeUrl call."));
        }
        return zzg(zzcbc, new zzedm(this), new zzedn(this), zzedl.zza);
    }
}
