package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzggl {
    private final Class zza;
    private final zzgpc zzb;

    /* synthetic */ zzggl(Class cls, zzgpc zzgpc, zzggk zzggk) {
        this.zza = cls;
        this.zzb = zzgpc;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzggl)) {
            return false;
        }
        zzggl zzggl = (zzggl) obj;
        if (!zzggl.zza.equals(this.zza) || !zzggl.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(this.zzb);
        return simpleName + ", object identifier: " + valueOf;
    }
}
