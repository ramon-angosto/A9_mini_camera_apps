package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzeqb implements zzeve {
    private final Set zza;

    zzeqb(Set set) {
        this.zza = set;
    }

    public final int zza() {
        return 8;
    }

    public final zzfzp zzb() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zza) {
            arrayList.add(add);
        }
        return zzfzg.zzi(new zzeqa(arrayList));
    }
}
