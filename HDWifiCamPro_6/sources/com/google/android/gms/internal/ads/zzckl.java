package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzckl implements zzgwu {
    private final ByteBuffer zza;

    zzckl(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.duplicate();
    }

    public final void close() throws IOException {
    }

    public final int zza(ByteBuffer byteBuffer) throws IOException {
        if (this.zza.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        byte[] bArr = new byte[Math.min(byteBuffer.remaining(), this.zza.remaining())];
        this.zza.get(bArr);
        byteBuffer.put(bArr);
        return bArr.length;
    }

    public final long zzb() throws IOException {
        return (long) this.zza.position();
    }

    public final long zzc() throws IOException {
        return (long) this.zza.limit();
    }

    public final ByteBuffer zzd(long j, long j2) throws IOException {
        int position = this.zza.position();
        this.zza.position((int) j);
        ByteBuffer slice = this.zza.slice();
        slice.limit((int) j2);
        this.zza.position(position);
        return slice;
    }

    public final void zze(long j) throws IOException {
        this.zza.position((int) j);
    }
}
