package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgsu {
    private static final zzgst zza;
    private static final zzgst zzb = new zzgst();

    static {
        zzgst zzgst;
        try {
            zzgst = (zzgst) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgst = null;
        }
        zza = zzgst;
    }

    static zzgst zza() {
        return zza;
    }

    static zzgst zzb() {
        return zzb;
    }
}
