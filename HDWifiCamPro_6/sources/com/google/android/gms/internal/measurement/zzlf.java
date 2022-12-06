package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzlf {
    private static final zzle zza;
    private static final zzle zzb = new zzle();

    static {
        zzle zzle;
        try {
            zzle = (zzle) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzle = null;
        }
        zza = zzle;
    }

    static zzle zza() {
        return zza;
    }

    static zzle zzb() {
        return zzb;
    }
}
