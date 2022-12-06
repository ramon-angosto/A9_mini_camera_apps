package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgbo {
    private final Object zza;
    private final byte[] zzb;
    private final int zzc;
    private final zzgbl zzd;
    private final int zze;
    private final int zzf;

    zzgbo(Object obj, byte[] bArr, int i, int i2, int i3, zzgbl zzgbl) {
        this.zza = obj;
        this.zzb = Arrays.copyOf(bArr, bArr.length);
        this.zze = i;
        this.zzf = i2;
        this.zzc = i3;
        this.zzd = zzgbl;
    }

    public final int zza() {
        return this.zzc;
    }

    public final zzgbl zzb() {
        return this.zzd;
    }

    public final Object zzc() {
        return this.zza;
    }

    public final byte[] zzd() {
        byte[] bArr = this.zzb;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int zze() {
        return this.zze;
    }

    public final int zzf() {
        return this.zzf;
    }
}
