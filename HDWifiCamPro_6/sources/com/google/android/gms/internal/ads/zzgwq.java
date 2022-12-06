package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzgwq extends zzgwt implements zzalq {
    zzalr zza;
    protected final String zzb = "moov";

    public zzgwq(String str) {
    }

    public final String zza() {
        return this.zzb;
    }

    public final void zzb(zzgwu zzgwu, ByteBuffer byteBuffer, long j, zzaln zzaln) throws IOException {
        zzgwu.zzb();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzd = zzgwu;
        this.zzf = zzgwu.zzb();
        zzgwu.zze(zzgwu.zzb() + j);
        this.zzg = zzgwu.zzb();
        this.zzc = zzaln;
    }

    public final void zzc(zzalr zzalr) {
        this.zza = zzalr;
    }
}
