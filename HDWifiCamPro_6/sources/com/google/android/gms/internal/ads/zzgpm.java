package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgpm extends zzgpo {
    final /* synthetic */ zzgpw zza;
    private int zzb = 0;
    private final int zzc = this.zza.zzd();

    zzgpm(zzgpw zzgpw) {
        this.zza = zzgpw;
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
