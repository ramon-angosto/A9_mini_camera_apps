package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzcf<T> implements zzch<T> {
    private zzcl<T> zza;

    public static <T> void zza(zzcl<T> zzcl, zzcl<T> zzcl2) {
        zzcf zzcf = (zzcf) zzcl;
        if (zzcf.zza == null) {
            zzcf.zza = zzcl2;
            return;
        }
        throw new IllegalStateException();
    }

    public final T zzb() {
        zzcl<T> zzcl = this.zza;
        if (zzcl != null) {
            return zzcl.zzb();
        }
        throw new IllegalStateException();
    }
}
