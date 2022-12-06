package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzefb implements zzfii {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final zzfiq zzc;

    public zzefb(Set set, zzfiq zzfiq) {
        this.zzc = zzfiq;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzefa zzefa = (zzefa) it.next();
            this.zza.put(zzefa.zzb, zzefa.zza);
            this.zzb.put(zzefa.zzc, zzefa.zza);
        }
    }

    public final void zzbF(zzfib zzfib, String str) {
    }

    public final void zzbG(zzfib zzfib, String str, Throwable th) {
        this.zzc.zze("task.".concat(String.valueOf(str)), "f.");
        if (this.zzb.containsKey(zzfib)) {
            this.zzc.zze("label.".concat(String.valueOf((String) this.zzb.get(zzfib))), "f.");
        }
    }

    public final void zzc(zzfib zzfib, String str) {
        this.zzc.zzd("task.".concat(String.valueOf(str)));
        if (this.zza.containsKey(zzfib)) {
            this.zzc.zzd("label.".concat(String.valueOf((String) this.zza.get(zzfib))));
        }
    }

    public final void zzd(zzfib zzfib, String str) {
        this.zzc.zze("task.".concat(String.valueOf(str)), "s.");
        if (this.zzb.containsKey(zzfib)) {
            this.zzc.zze("label.".concat(String.valueOf((String) this.zzb.get(zzfib))), "s.");
        }
    }
}
