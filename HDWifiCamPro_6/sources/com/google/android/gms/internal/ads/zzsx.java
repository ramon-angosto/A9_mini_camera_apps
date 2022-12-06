package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzsx implements zztz {
    private final zztz zza;
    private final long zzb;

    public zzsx(zztz zztz, long j) {
        this.zza = zztz;
        this.zzb = j;
    }

    public final int zza(zzjg zzjg, zzgi zzgi, int i) {
        int zza2 = this.zza.zza(zzjg, zzgi, i);
        if (zza2 != -4) {
            return zza2;
        }
        zzgi.zzd = Math.max(0, zzgi.zzd + this.zzb);
        return -4;
    }

    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zztz zzc() {
        return this.zza;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return this.zza.zze();
    }
}
