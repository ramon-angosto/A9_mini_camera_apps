package com.google.android.gms.internal;

import java.io.IOException;

final class zzakq<T> extends zzakr<T> {
    private final zzalv<T> zzbWA;
    private final zzaks zzbWB;
    private zzakr<T> zzbWi;
    private final zzakn<T> zzbWx;
    private final zzake<T> zzbWy;
    private final zzajz zzbWz;

    private static class zza implements zzaks {
        private final zzalv<?> zzbWC;
        private final boolean zzbWD;
        private final Class<?> zzbWE;
        private final zzakn<?> zzbWx;
        private final zzake<?> zzbWy;

        private zza(Object obj, zzalv<?> zzalv, boolean z, Class<?> cls) {
            zzake<?> zzake = null;
            this.zzbWx = obj instanceof zzakn ? (zzakn) obj : null;
            this.zzbWy = obj instanceof zzake ? (zzake) obj : zzake;
            zzakx.zzaj((this.zzbWx == null && this.zzbWy == null) ? false : true);
            this.zzbWC = zzalv;
            this.zzbWD = z;
            this.zzbWE = cls;
        }

        public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
            zzalv<?> zzalv2 = this.zzbWC;
            if (zzalv2 != null ? zzalv2.equals(zzalv) || (this.zzbWD && this.zzbWC.zzWm() == zzalv.zzWl()) : this.zzbWE.isAssignableFrom(zzalv.zzWl())) {
                return new zzakq(this.zzbWx, this.zzbWy, zzajz, zzalv, this);
            }
            return null;
        }
    }

    private zzakq(zzakn<T> zzakn, zzake<T> zzake, zzajz zzajz, zzalv<T> zzalv, zzaks zzaks) {
        this.zzbWx = zzakn;
        this.zzbWy = zzake;
        this.zzbWz = zzajz;
        this.zzbWA = zzalv;
        this.zzbWB = zzaks;
    }

    private zzakr<T> zzVQ() {
        zzakr<T> zzakr = this.zzbWi;
        if (zzakr != null) {
            return zzakr;
        }
        zzakr<T> zza2 = this.zzbWz.zza(this.zzbWB, this.zzbWA);
        this.zzbWi = zza2;
        return zza2;
    }

    public static zzaks zza(zzalv<?> zzalv, Object obj) {
        return new zza(obj, zzalv, false, (Class) null);
    }

    public static zzaks zzb(zzalv<?> zzalv, Object obj) {
        return new zza(obj, zzalv, zzalv.zzWm() == zzalv.zzWl(), (Class) null);
    }

    public void zza(zzaly zzaly, T t) throws IOException {
        zzakn<T> zzakn = this.zzbWx;
        if (zzakn == null) {
            zzVQ().zza(zzaly, t);
        } else if (t == null) {
            zzaly.zzWk();
        } else {
            zzalg.zzb(zzakn.zza(t, this.zzbWA.zzWm(), this.zzbWz.zzbWg), zzaly);
        }
    }

    public T zzb(zzalw zzalw) throws IOException {
        if (this.zzbWy == null) {
            return zzVQ().zzb(zzalw);
        }
        zzakf zzh = zzalg.zzh(zzalw);
        if (zzh.zzVI()) {
            return null;
        }
        try {
            return this.zzbWy.zzb(zzh, this.zzbWA.zzWm(), this.zzbWz.zzbWf);
        } catch (zzakj e) {
            throw e;
        } catch (Exception e2) {
            throw new zzakj((Throwable) e2);
        }
    }
}
