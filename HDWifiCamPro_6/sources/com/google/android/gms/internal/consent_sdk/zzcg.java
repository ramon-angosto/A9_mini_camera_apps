package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzcg<T> implements zzcl<T> {
    private static final Object zza = new Object();
    private volatile zzcl<T> zzb;
    private volatile Object zzc = zza;

    private zzcg(zzcl<T> zzcl) {
        this.zzb = zzcl;
    }

    public static <P extends zzcl<T>, T> zzcl<T> zza(P p) {
        if (p == null) {
            throw null;
        } else if (p instanceof zzcg) {
            return p;
        } else {
            return new zzcg(p);
        }
    }

    public final T zzb() {
        T t = this.zzc;
        if (t == zza) {
            synchronized (this) {
                t = this.zzc;
                if (t == zza) {
                    t = this.zzb.zzb();
                    T t2 = this.zzc;
                    if (t2 != zza && !(t2 instanceof zzcj)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzc = t;
                    this.zzb = null;
                }
            }
        }
        return t;
    }
}
