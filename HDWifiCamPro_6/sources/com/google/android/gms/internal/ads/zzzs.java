package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzs {
    public static zzzu zzb(zzef zzef) {
        zzef.zzG(1);
        int zzm = zzef.zzm();
        long zzc = ((long) zzef.zzc()) + ((long) zzm);
        int i = zzm / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long zzr = zzef.zzr();
            if (zzr == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = zzr;
            jArr2[i2] = zzef.zzr();
            zzef.zzG(2);
            i2++;
        }
        zzef.zzG((int) (zzc - ((long) zzef.zzc())));
        return new zzzu(jArr, jArr2);
    }

    public static zzbq zza(zzzj zzzj, boolean z) throws IOException {
        zzbq zza = new zzzz().zza(zzzj, z ? null : zzadc.zza);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }
}
