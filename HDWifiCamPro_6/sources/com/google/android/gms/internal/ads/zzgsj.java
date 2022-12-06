package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgsj {
    zzgsj() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzgsi zzgsi = (zzgsi) obj;
        zzgsh zzgsh = (zzgsh) obj2;
        if (zzgsi.isEmpty()) {
            return 0;
        }
        Iterator it = zzgsi.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzgsi) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzgsi zzgsi = (zzgsi) obj;
        zzgsi zzgsi2 = (zzgsi) obj2;
        if (!zzgsi2.isEmpty()) {
            if (!zzgsi.zze()) {
                zzgsi = zzgsi.zzb();
            }
            zzgsi.zzd(zzgsi2);
        }
        return zzgsi;
    }
}
