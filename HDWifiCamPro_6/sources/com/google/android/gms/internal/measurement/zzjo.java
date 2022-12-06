package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzjo {
    static final zzjo zza = new zzjo(true);
    private static volatile boolean zzb = false;
    private static volatile zzjo zzc;
    private static volatile zzjo zzd;
    private final Map zze;

    zzjo() {
        this.zze = new HashMap();
    }

    public static zzjo zza() {
        zzjo zzjo = zzc;
        if (zzjo == null) {
            synchronized (zzjo.class) {
                zzjo = zzc;
                if (zzjo == null) {
                    zzjo = zza;
                    zzc = zzjo;
                }
            }
        }
        return zzjo;
    }

    public final zzka zzc(zzlj zzlj, int i) {
        return (zzka) this.zze.get(new zzjn(zzlj, i));
    }

    zzjo(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzjo zzb() {
        Class<zzjo> cls = zzjo.class;
        zzjo zzjo = zzd;
        if (zzjo != null) {
            return zzjo;
        }
        synchronized (cls) {
            zzjo zzjo2 = zzd;
            if (zzjo2 != null) {
                return zzjo2;
            }
            zzjo zzb2 = zzjw.zzb(cls);
            zzd = zzb2;
            return zzb2;
        }
    }
}
