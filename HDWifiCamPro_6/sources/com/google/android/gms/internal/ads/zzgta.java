package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgta extends zzgpo {
    final zzgte zza = new zzgte(this.zzc, (zzgtd) null);
    zzgpq zzb = zzb();
    final /* synthetic */ zzgtg zzc;

    zzgta(zzgtg zzgtg) {
        this.zzc = zzgtg;
    }

    private final zzgpq zzb() {
        zzgte zzgte = this.zza;
        if (zzgte.hasNext()) {
            return zzgte.next().iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final byte zza() {
        zzgpq zzgpq = this.zzb;
        if (zzgpq != null) {
            byte zza2 = zzgpq.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza2;
        }
        throw new NoSuchElementException();
    }
}
