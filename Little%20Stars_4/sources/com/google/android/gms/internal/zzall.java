package com.google.android.gms.internal;

public final class zzall implements zzaks {
    private final zzakz zzbWa;

    public zzall(zzakz zzakz) {
        this.zzbWa = zzakz;
    }

    static zzakr<?> zza(zzakz zzakz, zzajz zzajz, zzalv<?> zzalv, zzakt zzakt) {
        Class<?> value = zzakt.value();
        if (zzakr.class.isAssignableFrom(value)) {
            return (zzakr) zzakz.zzb(zzalv.zzr(value)).zzVT();
        }
        if (zzaks.class.isAssignableFrom(value)) {
            return ((zzaks) zzakz.zzb(zzalv.zzr(value)).zzVT()).zza(zzajz, zzalv);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
        zzakt zzakt = (zzakt) zzalv.zzWl().getAnnotation(zzakt.class);
        if (zzakt == null) {
            return null;
        }
        return zza(this.zzbWa, zzajz, zzalv, zzakt);
    }
}
