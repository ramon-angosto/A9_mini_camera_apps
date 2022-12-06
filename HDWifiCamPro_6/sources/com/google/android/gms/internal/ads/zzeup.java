package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeup implements zzeve {
    private final zzceu zza;
    private final zzfzq zzb;
    private final Context zzc;

    public zzeup(zzceu zzceu, zzfzq zzfzq, Context context) {
        this.zza = zzceu;
        this.zzb = zzfzq;
        this.zzc = context;
    }

    public final int zza() {
        return 34;
    }

    public final zzfzp zzb() {
        return this.zzb.zzb(new zzeuo(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeuq zzc() throws Exception {
        String str;
        String str2;
        String str3;
        if (!this.zza.zzu(this.zzc)) {
            return new zzeuq((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zze = this.zza.zze(this.zzc);
        String str4 = zze == null ? "" : zze;
        String zzc2 = this.zza.zzc(this.zzc);
        if (zzc2 == null) {
            str = "";
        } else {
            str = zzc2;
        }
        String zza2 = this.zza.zza(this.zzc);
        if (zza2 == null) {
            str2 = "";
        } else {
            str2 = zza2;
        }
        String zzb2 = this.zza.zzb(this.zzc);
        if (zzb2 == null) {
            str3 = "";
        } else {
            str3 = zzb2;
        }
        return new zzeuq(str4, str, str2, str3, "TIME_OUT".equals(str) ? (Long) zzay.zzc().zzb(zzbjc.zzad) : null);
    }
}
