package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgfy {
    private static final zzgfy zza = new zzgfy();
    private final AtomicReference zzb = new AtomicReference(new zzggp(new zzggj(), (zzggo) null));

    public static zzgfy zza() {
        return zza;
    }

    public final synchronized void zzb(zzgfl zzgfl) throws GeneralSecurityException {
        zzggj zzggj = new zzggj((zzggp) this.zzb.get());
        zzggj.zza(zzgfl);
        this.zzb.set(new zzggp(zzggj, (zzggo) null));
    }

    public final synchronized void zzc(zzgfo zzgfo) throws GeneralSecurityException {
        zzggj zzggj = new zzggj((zzggp) this.zzb.get());
        zzggj.zzb(zzgfo);
        this.zzb.set(new zzggp(zzggj, (zzggo) null));
    }

    public final synchronized void zzd(zzggb zzggb) throws GeneralSecurityException {
        zzggj zzggj = new zzggj((zzggp) this.zzb.get());
        zzggj.zzc(zzggb);
        this.zzb.set(new zzggp(zzggj, (zzggo) null));
    }

    public final synchronized void zze(zzgge zzgge) throws GeneralSecurityException {
        zzggj zzggj = new zzggj((zzggp) this.zzb.get());
        zzggj.zzd(zzgge);
        this.zzb.set(new zzggp(zzggj, (zzggo) null));
    }
}
