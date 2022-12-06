package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
class zzgaw implements zzgau {
    private final zzgfr zza;
    private final Class zzb;

    public zzgaw(zzgfr zzgfr, Class cls) {
        if (zzgfr.zzl().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzgfr;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzgfr.toString(), cls.getName()}));
    }

    private final zzgav zzg() {
        return new zzgav(this.zza.zza());
    }

    private final Object zzh(zzgso zzgso) throws GeneralSecurityException {
        if (!Void.class.equals(this.zzb)) {
            this.zza.zzd(zzgso);
            return this.zza.zzk(zzgso, this.zzb);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    public final zzglx zza(zzgpw zzgpw) throws GeneralSecurityException {
        try {
            zzgso zza2 = zzg().zza(zzgpw);
            zzglw zza3 = zzglx.zza();
            zza3.zza(this.zza.zzc());
            zza3.zzb(zza2.zzat());
            zza3.zzc(this.zza.zzf());
            return (zzglx) zza3.zzam();
        } catch (zzgrq e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    public final zzgso zzb(zzgpw zzgpw) throws GeneralSecurityException {
        try {
            return zzg().zza(zzgpw);
        } catch (zzgrq e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(String.valueOf(this.zza.zza().zzg().getName())), e);
        }
    }

    public final Class zzc() {
        return this.zzb;
    }

    public final Object zzd(zzgpw zzgpw) throws GeneralSecurityException {
        try {
            return zzh(this.zza.zzb(zzgpw));
        } catch (zzgrq e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(String.valueOf(this.zza.zzj().getName())), e);
        }
    }

    public final Object zze(zzgso zzgso) throws GeneralSecurityException {
        String concat = "Expected proto of type ".concat(String.valueOf(this.zza.zzj().getName()));
        if (this.zza.zzj().isInstance(zzgso)) {
            return zzh(zzgso);
        }
        throw new GeneralSecurityException(concat);
    }

    public final String zzf() {
        return this.zza.zzc();
    }
}
