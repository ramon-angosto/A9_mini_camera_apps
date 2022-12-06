package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgqq {
    static final zzgqq zza = new zzgqq(true);
    private static volatile boolean zzb = false;
    private static volatile zzgqq zzc;
    private static volatile zzgqq zzd;
    private final Map zze;

    zzgqq() {
        this.zze = new HashMap();
    }

    public static zzgqq zza() {
        zzgqq zzgqq = zzc;
        if (zzgqq == null) {
            synchronized (zzgqq.class) {
                zzgqq = zzc;
                if (zzgqq == null) {
                    zzgqq = zza;
                    zzc = zzgqq;
                }
            }
        }
        return zzgqq;
    }

    public final zzgrc zzc(zzgso zzgso, int i) {
        return (zzgrc) this.zze.get(new zzgqp(zzgso, i));
    }

    zzgqq(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzgqq zzb() {
        Class<zzgqq> cls = zzgqq.class;
        zzgqq zzgqq = zzd;
        if (zzgqq != null) {
            return zzgqq;
        }
        synchronized (cls) {
            zzgqq zzgqq2 = zzd;
            if (zzgqq2 != null) {
                return zzgqq2;
            }
            zzgqq zzb2 = zzgqy.zzb(cls);
            zzd = zzb2;
            return zzb2;
        }
    }
}
