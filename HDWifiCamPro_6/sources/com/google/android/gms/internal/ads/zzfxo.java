package com.google.android.gms.internal.ads;

import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfxo extends OutputStream {
    zzfxo() {
    }

    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    public final void write(int i) {
    }

    public final void write(byte[] bArr) {
        if (bArr == null) {
            throw null;
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            zzfsx.zzg(i, i2 + i, bArr.length);
            return;
        }
        throw null;
    }
}
