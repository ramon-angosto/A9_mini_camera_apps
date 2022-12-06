package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgqt {
    private static final zzgqr zza = new zzgqs();
    private static final zzgqr zzb;

    static {
        zzgqr zzgqr;
        try {
            zzgqr = (zzgqr) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgqr = null;
        }
        zzb = zzgqr;
    }

    static zzgqr zza() {
        zzgqr zzgqr = zzb;
        if (zzgqr != null) {
            return zzgqr;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzgqr zzb() {
        return zza;
    }
}
