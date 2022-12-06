package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzclg {
    private final ArrayList zza = new ArrayList();
    private long zzb;

    zzclg() {
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            Map zze = ((zzazq) it.next()).zze();
            if (zze != null) {
                for (Map.Entry entry : zze.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) entry.getKey())) {
                            this.zzb = Math.max(this.zzb, Long.parseLong((String) ((List) entry.getValue()).get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzazq zzazq) {
        this.zza.add(zzazq);
    }
}
