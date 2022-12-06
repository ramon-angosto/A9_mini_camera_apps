package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgal {
    private final InputStream zza;

    private zzgal(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzgal zzb(byte[] bArr) {
        return new zzgal(new ByteArrayInputStream(bArr));
    }

    public final zzgmk zza() throws IOException {
        try {
            return zzgmk.zzf(this.zza, zzgqq.zza());
        } finally {
            this.zza.close();
        }
    }
}
