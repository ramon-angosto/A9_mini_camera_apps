package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzghr {
    private final zzgbc zza;
    private final int zzb;
    private final zzgbl zzc;

    /* synthetic */ zzghr(zzgbc zzgbc, int i, zzgbl zzgbl, zzghq zzghq) {
        this.zza = zzgbc;
        this.zzb = i;
        this.zzc = zzgbl;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghr)) {
            return false;
        }
        zzghr zzghr = (zzghr) obj;
        if (this.zza == zzghr.zza && this.zzb == zzghr.zzb && this.zzc.equals(zzghr.zzc)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc.hashCode())});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, parameters='%s')", new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc});
    }

    public final int zza() {
        return this.zzb;
    }
}
