package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcri implements zzdyy {
    private final zzcpw zza;
    private Context zzb;
    private zzbqr zzc;

    /* synthetic */ zzcri(zzcpw zzcpw, zzcrh zzcrh) {
        this.zza = zzcpw;
    }

    public final /* synthetic */ zzdyy zza(zzbqr zzbqr) {
        if (zzbqr != null) {
            this.zzc = zzbqr;
            return this;
        }
        throw null;
    }

    public final /* synthetic */ zzdyy zzb(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }

    public final zzdyz zzc() {
        zzgxq.zzc(this.zzb, Context.class);
        zzgxq.zzc(this.zzc, zzbqr.class);
        return new zzcrk(this.zza, this.zzb, this.zzc, (zzcrj) null);
    }
}
