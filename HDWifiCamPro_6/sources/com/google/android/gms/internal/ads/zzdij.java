package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzdij {
    protected final Map zza = new HashMap();

    protected zzdij(Set set) {
        zzm(set);
    }

    public final synchronized void zzg(zzdkg zzdkg) {
        zzj(zzdkg.zza, zzdkg.zzb);
    }

    public final synchronized void zzj(Object obj, Executor executor) {
        this.zza.put(obj, executor);
    }

    public final synchronized void zzm(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzg((zzdkg) it.next());
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzo(zzdii zzdii) {
        for (Map.Entry entry : this.zza.entrySet()) {
            ((Executor) entry.getValue()).execute(new zzdih(zzdii, entry.getKey()));
        }
    }
}
