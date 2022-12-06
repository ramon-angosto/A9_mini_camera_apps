package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgxg implements zzgxi {
    private zzgxv zza;

    public static void zza(zzgxv zzgxv, zzgxv zzgxv2) {
        zzgxg zzgxg = (zzgxg) zzgxv;
        if (zzgxg.zza == null) {
            zzgxg.zza = zzgxv2;
            return;
        }
        throw new IllegalStateException();
    }

    public final Object zzb() {
        zzgxv zzgxv = this.zza;
        if (zzgxv != null) {
            return zzgxv.zzb();
        }
        throw new IllegalStateException();
    }
}
