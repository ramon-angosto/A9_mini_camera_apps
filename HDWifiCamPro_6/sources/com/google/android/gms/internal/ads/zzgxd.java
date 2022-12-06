package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzgxd {
    final LinkedHashMap zza;

    zzgxd(int i) {
        this.zza = zzgxf.zzb(i);
    }

    /* access modifiers changed from: package-private */
    public final zzgxd zza(Object obj, zzgxv zzgxv) {
        LinkedHashMap linkedHashMap = this.zza;
        zzgxq.zza(obj, "key");
        zzgxq.zza(zzgxv, IronSourceConstants.EVENTS_PROVIDER);
        linkedHashMap.put(obj, zzgxv);
        return this;
    }
}
