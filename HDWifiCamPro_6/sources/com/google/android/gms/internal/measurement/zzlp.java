package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzlp {
    private static final zzlo zza;
    private static final zzlo zzb = new zzlo();

    static {
        zzlo zzlo;
        try {
            zzlo = (zzlo) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlo = null;
        }
        zza = zzlo;
    }

    static zzlo zza() {
        return zza;
    }

    static zzlo zzb() {
        return zzb;
    }
}
