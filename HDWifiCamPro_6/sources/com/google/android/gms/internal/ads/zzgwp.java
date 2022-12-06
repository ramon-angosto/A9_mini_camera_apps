package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgwp implements zzalq {
    private static final zzgxa zza = zzgxa.zzb(zzgwp.class);
    protected final String zzb;
    boolean zzc;
    boolean zzd;
    long zze;
    long zzf = -1;
    zzgwu zzg;
    private zzalr zzh;
    private ByteBuffer zzi;
    private ByteBuffer zzj = null;

    protected zzgwp(String str) {
        this.zzb = str;
        this.zzd = true;
        this.zzc = true;
    }

    private final synchronized void zzd() {
        if (!this.zzd) {
            try {
                zzgxa zzgxa = zza;
                String str = this.zzb;
                zzgxa.zza(str.length() != 0 ? "mem mapping ".concat(str) : new String("mem mapping "));
                this.zzi = this.zzg.zzd(this.zze, this.zzf);
                this.zzd = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final void zzb(zzgwu zzgwu, ByteBuffer byteBuffer, long j, zzaln zzaln) throws IOException {
        this.zze = zzgwu.zzb();
        byteBuffer.remaining();
        this.zzf = j;
        this.zzg = zzgwu;
        zzgwu.zze(zzgwu.zzb() + j);
        this.zzd = false;
        this.zzc = false;
        zzg();
    }

    public final void zzc(zzalr zzalr) {
        this.zzh = zzalr;
    }

    /* access modifiers changed from: protected */
    public abstract void zzf(ByteBuffer byteBuffer);

    public final synchronized void zzg() {
        zzd();
        zzgxa zzgxa = zza;
        String str = this.zzb;
        zzgxa.zza(str.length() != 0 ? "parsing details of ".concat(str) : new String("parsing details of "));
        ByteBuffer byteBuffer = this.zzi;
        if (byteBuffer != null) {
            this.zzc = true;
            byteBuffer.rewind();
            zzf(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzj = byteBuffer.slice();
            }
            this.zzi = null;
        }
    }
}
