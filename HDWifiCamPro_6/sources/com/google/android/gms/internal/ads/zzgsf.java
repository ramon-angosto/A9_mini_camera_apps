package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgsf implements zzgsm {
    private final zzgsm[] zza;

    zzgsf(zzgsm... zzgsmArr) {
        this.zza = zzgsmArr;
    }

    public final zzgsl zzb(Class cls) {
        zzgsm[] zzgsmArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzgsm zzgsm = zzgsmArr[i];
            if (zzgsm.zzc(cls)) {
                return zzgsm.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        zzgsm[] zzgsmArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzgsmArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
