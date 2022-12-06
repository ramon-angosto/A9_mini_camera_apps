package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgxh implements zzgxv, zzgxc {
    private static final Object zza = new Object();
    private volatile zzgxv zzb;
    private volatile Object zzc = zza;

    private zzgxh(zzgxv zzgxv) {
        this.zzb = zzgxv;
    }

    public static zzgxc zza(zzgxv zzgxv) {
        if (zzgxv instanceof zzgxc) {
            return (zzgxc) zzgxv;
        }
        if (zzgxv != null) {
            return new zzgxh(zzgxv);
        }
        throw null;
    }

    public static zzgxv zzc(zzgxv zzgxv) {
        if (zzgxv == null) {
            throw null;
        } else if (zzgxv instanceof zzgxh) {
            return zzgxv;
        } else {
            return new zzgxh(zzgxv);
        }
    }

    public final Object zzb() {
        Object obj = this.zzc;
        if (obj == zza) {
            synchronized (this) {
                obj = this.zzc;
                if (obj == zza) {
                    obj = this.zzb.zzb();
                    Object obj2 = this.zzc;
                    if (obj2 != zza) {
                        if (obj2 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.zzc = obj;
                    this.zzb = null;
                }
            }
        }
        return obj;
    }
}
