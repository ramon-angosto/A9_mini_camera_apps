package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzakx extends FilterInputStream {
    private final long zza;
    private long zzb;

    zzakx(InputStream inputStream, long j) {
        super(inputStream);
        this.zza = j;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.zzb++;
        }
        return read;
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        return this.zza - this.zzb;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.zzb += (long) read;
        }
        return read;
    }
}
