package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzci<T> implements zzch<T> {
    private static final zzci<Object> zza = new zzci<>((Object) null);
    private final T zzb;

    private zzci(T t) {
        this.zzb = t;
    }

    public static <T> zzch<T> zza(T t) {
        if (t != null) {
            return new zzci(t);
        }
        throw new NullPointerException("instance cannot be null");
    }

    public final T zzb() {
        return this.zzb;
    }
}
