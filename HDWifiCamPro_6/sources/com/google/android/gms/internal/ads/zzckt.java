package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzckt extends zzb {
    final zzciy zza;
    final zzclb zzb;
    private final String zzc;
    private final String[] zzd;

    zzckt(zzciy zzciy, zzclb zzclb, String str, String[] strArr) {
        this.zza = zzciy;
        this.zzb = zzclb;
        this.zzc = str;
        this.zzd = strArr;
        zzt.zzy().zzb(this);
    }

    public final void zza() {
        try {
            this.zzb.zzr(this.zzc, this.zzd);
        } finally {
            zzs.zza.post(new zzcks(this));
        }
    }

    public final zzfzp zzb() {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzbK)).booleanValue() || !(this.zzb instanceof zzclk)) {
            return super.zzb();
        }
        return zzchc.zze.zzb(new zzckr(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzs(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
