package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzftc extends zzfst {
    private final Object zza;

    zzftc(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzftc) {
            return this.zza.equals(((zzftc) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.zza + ")";
    }

    public final zzfst zza(zzfsm zzfsm) {
        Object apply = zzfsm.apply(this.zza);
        zzfsx.zzc(apply, "the Function passed to Optional.transform() must not return null.");
        return new zzftc(apply);
    }

    public final Object zzb(Object obj) {
        return this.zza;
    }
}
