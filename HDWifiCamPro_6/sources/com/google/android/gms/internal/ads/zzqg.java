package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzqg {
    private long zza;
    private long zzb;
    private boolean zzc;

    zzqg() {
    }

    private final long zzd(long j) {
        return this.zza + Math.max(0, ((this.zzb - 529) * 1000000) / j);
    }

    public final long zza(zzaf zzaf) {
        return zzd((long) zzaf.zzA);
    }

    public final long zzb(zzaf zzaf, zzgi zzgi) {
        if (this.zzb == 0) {
            this.zza = zzgi.zzd;
        }
        if (this.zzc) {
            return zzgi.zzd;
        }
        ByteBuffer byteBuffer = zzgi.zzb;
        if (byteBuffer != null) {
            byte b = 0;
            for (int i = 0; i < 4; i++) {
                b = (b << 8) | (byteBuffer.get(i) & UByte.MAX_VALUE);
            }
            int zzc2 = zzaac.zzc(b);
            if (zzc2 == -1) {
                this.zzc = true;
                this.zzb = 0;
                this.zza = zzgi.zzd;
                zzdw.zze("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
                return zzgi.zzd;
            }
            long zzd = zzd((long) zzaf.zzA);
            this.zzb += (long) zzc2;
            return zzd;
        }
        throw null;
    }

    public final void zzc() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = false;
    }
}
