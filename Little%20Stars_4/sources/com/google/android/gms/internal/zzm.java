package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;

public class zzm<T> {
    public final T result;
    public final zzb.zza zzaf;
    public final zzr zzag;
    public boolean zzah;

    public interface zza {
        void zze(zzr zzr);
    }

    public interface zzb<T> {
        void zzb(T t);
    }

    private zzm(zzr zzr) {
        this.zzah = false;
        this.result = null;
        this.zzaf = null;
        this.zzag = zzr;
    }

    private zzm(T t, zzb.zza zza2) {
        this.zzah = false;
        this.result = t;
        this.zzaf = zza2;
        this.zzag = null;
    }

    public static <T> zzm<T> zza(T t, zzb.zza zza2) {
        return new zzm<>(t, zza2);
    }

    public static <T> zzm<T> zzd(zzr zzr) {
        return new zzm<>(zzr);
    }

    public boolean isSuccess() {
        return this.zzag == null;
    }
}
