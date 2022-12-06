package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzis extends zziu {
    final /* synthetic */ zzjb zza;
    private int zzb = 0;
    private final int zzc = this.zza.zzd();

    zzis(zzjb zzjb) {
        this.zza = zzjb;
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
