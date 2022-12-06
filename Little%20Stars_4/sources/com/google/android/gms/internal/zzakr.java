package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzakr<T> {
    public abstract void zza(zzaly zzaly, T t) throws IOException;

    public final zzakf zzaJ(T t) {
        try {
            zzaln zzaln = new zzaln();
            zza(zzaln, t);
            return zzaln.zzWe();
        } catch (IOException e) {
            throw new zzakg((Throwable) e);
        }
    }

    public abstract T zzb(zzalw zzalw) throws IOException;
}
