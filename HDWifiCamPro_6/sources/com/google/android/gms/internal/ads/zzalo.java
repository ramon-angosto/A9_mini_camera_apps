package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzalo extends zzgwt implements Closeable {
    private static final zzgxa zza = zzgxa.zzb(zzalo.class);

    public zzalo(zzgwu zzgwu, zzaln zzaln) throws IOException {
        zzf(zzgwu, zzgwu.zzc(), zzaln);
    }

    public final void close() throws IOException {
    }

    public final String toString() {
        String obj = this.zzd.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
