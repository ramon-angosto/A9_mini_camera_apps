package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbei extends PushbackInputStream {
    final /* synthetic */ zzbej zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbei(zzbej zzbej, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zza = zzbej;
    }

    public final synchronized void close() throws IOException {
        zzbel.zze(this.zza.zzc);
        super.close();
    }
}
