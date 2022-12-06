package com.google.android.gms.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class zzalv<T> {
    final Type zzbYf;
    final Class<? super T> zzbZj;
    final int zzbZk;

    protected zzalv() {
        this.zzbYf = zzq(getClass());
        this.zzbZj = zzaky.zzf(this.zzbYf);
        this.zzbZk = this.zzbYf.hashCode();
    }

    zzalv(Type type) {
        this.zzbYf = zzaky.zze((Type) zzakx.zzz(type));
        this.zzbZj = zzaky.zzf(this.zzbYf);
        this.zzbZk = this.zzbYf.hashCode();
    }

    public static zzalv<?> zzl(Type type) {
        return new zzalv<>(type);
    }

    static Type zzq(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return zzaky.zze(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public static <T> zzalv<T> zzr(Class<T> cls) {
        return new zzalv<>(cls);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzalv) && zzaky.zza(this.zzbYf, ((zzalv) obj).zzbYf);
    }

    public final int hashCode() {
        return this.zzbZk;
    }

    public final String toString() {
        return zzaky.zzg(this.zzbYf);
    }

    public final Class<? super T> zzWl() {
        return this.zzbZj;
    }

    public final Type zzWm() {
        return this.zzbYf;
    }
}
