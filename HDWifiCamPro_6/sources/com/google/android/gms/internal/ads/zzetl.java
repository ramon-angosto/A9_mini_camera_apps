package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzetl implements zzeve {
    private final zzfzq zza;
    private final Context zzb;
    private final Set zzc;

    public zzetl(zzfzq zzfzq, Context context, Set set) {
        this.zza = zzfzq;
        this.zzb = context;
        this.zzc = set;
    }

    public final int zza() {
        return 27;
    }

    public final zzfzp zzb() {
        return this.zza.zzb(new zzetk(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzetm zzc() throws Exception {
        String str = null;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeg)).booleanValue()) {
            Set set = this.zzc;
            if (set.contains("rewarded") || set.contains(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE) || set.contains("native") || set.contains("banner")) {
                zzt.zzA();
                if (true == ((Boolean) zzay.zzc().zzb(zzbjc.zzeg)).booleanValue()) {
                    str = "a.1.3.31-google_20220407";
                }
                return new zzetm(str);
            }
        }
        return new zzetm((String) null);
    }
}
