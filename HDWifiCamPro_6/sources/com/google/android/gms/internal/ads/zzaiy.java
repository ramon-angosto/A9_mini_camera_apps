package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaiy {
    public final int zza;
    public final long zzb;

    private zzaiy(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzaiy zza(zzzj zzzj, zzef zzef) throws IOException {
        ((zzyy) zzzj).zzm(zzef.zzH(), 0, 8, false);
        zzef.zzF(0);
        return new zzaiy(zzef.zze(), zzef.zzq());
    }
}
