package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcrs implements zzfbp {
    private final zzcpw zza;
    private Context zzb;
    private String zzc;
    private zzq zzd;

    /* synthetic */ zzcrs(zzcpw zzcpw, zzcrr zzcrr) {
        this.zza = zzcpw;
    }

    public final /* synthetic */ zzfbp zza(zzq zzq) {
        if (zzq != null) {
            this.zzd = zzq;
            return this;
        }
        throw null;
    }

    public final /* synthetic */ zzfbp zzb(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw null;
    }

    public final /* synthetic */ zzfbp zzc(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }

    public final zzfbq zzd() {
        zzgxq.zzc(this.zzb, Context.class);
        zzgxq.zzc(this.zzc, String.class);
        zzgxq.zzc(this.zzd, zzq.class);
        return new zzcru(this.zza, this.zzb, this.zzc, this.zzd, (zzcrt) null);
    }
}
