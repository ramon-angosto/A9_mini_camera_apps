package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzjn {
    private final Object zza;
    private final int zzb;

    zzjn(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjn)) {
            return false;
        }
        zzjn zzjn = (zzjn) obj;
        if (this.zza == zzjn.zza && this.zzb == zzjn.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
