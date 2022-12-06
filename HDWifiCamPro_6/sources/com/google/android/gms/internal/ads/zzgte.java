package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgte implements Iterator {
    private final ArrayDeque zza;
    private zzgpr zzb;

    /* synthetic */ zzgte(zzgpw zzgpw, zzgtd zzgtd) {
        if (zzgpw instanceof zzgtg) {
            zzgtg zzgtg = (zzgtg) zzgpw;
            this.zza = new ArrayDeque(zzgtg.zzf());
            this.zza.push(zzgtg);
            this.zzb = zzb(zzgtg.zzd);
            return;
        }
        this.zza = null;
        this.zzb = (zzgpr) zzgpw;
    }

    private final zzgpr zzb(zzgpw zzgpw) {
        while (zzgpw instanceof zzgtg) {
            zzgtg zzgtg = (zzgtg) zzgpw;
            this.zza.push(zzgtg);
            zzgpw = zzgtg.zzd;
        }
        return (zzgpr) zzgpw;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: zza */
    public final zzgpr next() {
        zzgpr zzgpr;
        zzgpr zzgpr2 = this.zzb;
        if (zzgpr2 != null) {
            do {
                ArrayDeque arrayDeque = this.zza;
                zzgpr = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    this.zzb = zzgpr;
                } else {
                    zzgpr = zzb(((zzgtg) this.zza.pop()).zze);
                }
            } while (zzgpr.zzD());
            this.zzb = zzgpr;
            return zzgpr2;
        }
        throw new NoSuchElementException();
    }
}
