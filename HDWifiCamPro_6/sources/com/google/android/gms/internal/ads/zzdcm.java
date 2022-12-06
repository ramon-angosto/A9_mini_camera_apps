package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdcm {
    private final Context zza;
    private final zzfef zzb;
    private final Bundle zzc;
    private final zzfdx zzd;

    /* synthetic */ zzdcm(zzdck zzdck, zzdcl zzdcl) {
        this.zza = zzdck.zza;
        this.zzb = zzdck.zzb;
        this.zzc = zzdck.zzc;
        this.zzd = zzdck.zzd;
    }

    /* access modifiers changed from: package-private */
    public final Context zza(Context context) {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzdck zzc() {
        zzdck zzdck = new zzdck();
        zzdck.zzc(this.zza);
        zzdck.zzf(this.zzb);
        zzdck.zzd(this.zzc);
        return zzdck;
    }

    /* access modifiers changed from: package-private */
    public final zzfdx zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzfef zze() {
        return this.zzb;
    }
}
