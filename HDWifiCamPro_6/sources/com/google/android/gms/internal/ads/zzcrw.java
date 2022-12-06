package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcrw implements zzfdd {
    private final zzcpw zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcrw(zzcpw zzcpw, zzcrv zzcrv) {
        this.zza = zzcpw;
    }

    public final /* synthetic */ zzfdd zza(String str) {
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfdd zzb(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }

    public final zzfde zzc() {
        zzgxq.zzc(this.zzb, Context.class);
        return new zzcry(this.zza, this.zzb, this.zzc, (zzcrx) null);
    }
}
