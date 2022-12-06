package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzfsm;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzn implements zzfsm {
    public final /* synthetic */ zzaa zza;
    public final /* synthetic */ List zzb;

    public /* synthetic */ zzn(zzaa zzaa, List list) {
        this.zza = zzaa;
        this.zzb = list;
    }

    public final Object apply(Object obj) {
        return this.zza.zzB(this.zzb, (String) obj);
    }
}
