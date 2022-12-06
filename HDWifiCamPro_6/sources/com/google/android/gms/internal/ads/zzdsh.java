package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdsh {
    private final Executor zza;
    private final zzcvu zzb;
    private final zzdki zzc;

    zzdsh(Executor executor, zzcvu zzcvu, zzdki zzdki) {
        this.zza = executor;
        this.zzc = zzdki;
        this.zzb = zzcvu;
    }

    public final void zza(zzcmp zzcmp) {
        if (zzcmp != null) {
            this.zzc.zza(zzcmp.zzH());
            this.zzc.zzj(new zzdsd(zzcmp), this.zza);
            this.zzc.zzj(new zzdse(zzcmp), this.zza);
            this.zzc.zzj(this.zzb, this.zza);
            this.zzb.zzf(zzcmp);
            zzcmp.zzaf("/trackActiveViewUnit", new zzdsf(this));
            zzcmp.zzaf("/untrackActiveViewUnit", new zzdsg(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcmp zzcmp, Map map) {
        this.zzb.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcmp zzcmp, Map map) {
        this.zzb.zza();
    }
}
