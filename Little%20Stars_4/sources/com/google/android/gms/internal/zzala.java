package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzala implements zzaks, Cloneable {
    public static final zzala zzbWT = new zzala();
    private double zzbWU = -1.0d;
    private int zzbWV = 136;
    private boolean zzbWW = true;
    private List<zzajv> zzbWX = Collections.emptyList();
    private List<zzajv> zzbWY = Collections.emptyList();

    private boolean zza(zzakv zzakv) {
        return zzakv == null || zzakv.zzVS() <= this.zzbWU;
    }

    private boolean zza(zzakv zzakv, zzakw zzakw) {
        return zza(zzakv) && zza(zzakw);
    }

    private boolean zza(zzakw zzakw) {
        return zzakw == null || zzakw.zzVS() > this.zzbWU;
    }

    private boolean zzm(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean zzn(Class<?> cls) {
        return cls.isMemberClass() && !zzo(cls);
    }

    private boolean zzo(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzVU */
    public zzala clone() {
        try {
            return (zzala) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
        Class<? super T> zzWl = zzalv.zzWl();
        final boolean zza = zza((Class<?>) zzWl, true);
        final boolean zza2 = zza((Class<?>) zzWl, false);
        if (!zza && !zza2) {
            return null;
        }
        final zzajz zzajz2 = zzajz;
        final zzalv<T> zzalv2 = zzalv;
        return new zzakr<T>() {
            private zzakr<T> zzbWi;

            private zzakr<T> zzVQ() {
                zzakr<T> zzakr = this.zzbWi;
                if (zzakr != null) {
                    return zzakr;
                }
                zzakr<T> zza = zzajz2.zza((zzaks) zzala.this, zzalv2);
                this.zzbWi = zza;
                return zza;
            }

            public void zza(zzaly zzaly, T t) throws IOException {
                if (zza) {
                    zzaly.zzWk();
                } else {
                    zzVQ().zza(zzaly, t);
                }
            }

            public T zzb(zzalw zzalw) throws IOException {
                if (!zza2) {
                    return zzVQ().zzb(zzalw);
                }
                zzalw.skipValue();
                return null;
            }
        };
    }

    public zzala zza(zzajv zzajv, boolean z, boolean z2) {
        zzala zzVU = clone();
        if (z) {
            zzVU.zzbWX = new ArrayList(this.zzbWX);
            zzVU.zzbWX.add(zzajv);
        }
        if (z2) {
            zzVU.zzbWY = new ArrayList(this.zzbWY);
            zzVU.zzbWY.add(zzajv);
        }
        return zzVU;
    }

    public boolean zza(Class<?> cls, boolean z) {
        if (this.zzbWU != -1.0d && !zza((zzakv) cls.getAnnotation(zzakv.class), (zzakw) cls.getAnnotation(zzakw.class))) {
            return true;
        }
        if ((!this.zzbWW && zzn(cls)) || zzm(cls)) {
            return true;
        }
        for (zzajv zzh : z ? this.zzbWX : this.zzbWY) {
            if (zzh.zzh(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(Field field, boolean z) {
        if ((this.zzbWV & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.zzbWU != -1.0d && !zza((zzakv) field.getAnnotation(zzakv.class), (zzakw) field.getAnnotation(zzakw.class))) || field.isSynthetic()) {
            return true;
        }
        if ((!this.zzbWW && zzn(field.getType())) || zzm(field.getType())) {
            return true;
        }
        List<zzajv> list = z ? this.zzbWX : this.zzbWY;
        if (list.isEmpty()) {
            return false;
        }
        zzajw zzajw = new zzajw(field);
        for (zzajv zza : list) {
            if (zza.zza(zzajw)) {
                return true;
            }
        }
        return false;
    }

    public zzala zzd(int... iArr) {
        zzala zzVU = clone();
        zzVU.zzbWV = 0;
        for (int i : iArr) {
            zzVU.zzbWV = i | zzVU.zzbWV;
        }
        return zzVU;
    }
}
