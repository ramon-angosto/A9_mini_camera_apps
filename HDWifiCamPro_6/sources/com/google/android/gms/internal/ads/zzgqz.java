package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgqz implements zzgsm {
    private static final zzgqz zza = new zzgqz();

    private zzgqz() {
    }

    public static zzgqz zza() {
        return zza;
    }

    public final zzgsl zzb(Class cls) {
        if (zzgre.class.isAssignableFrom(cls)) {
            try {
                return (zzgsl) zzgre.zzaB(cls.asSubclass(zzgre.class)).zzb(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzgre.class.isAssignableFrom(cls);
    }
}
