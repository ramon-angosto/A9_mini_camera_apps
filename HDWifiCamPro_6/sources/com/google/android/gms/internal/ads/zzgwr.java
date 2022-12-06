package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgwr extends zzgwp implements zzalq {
    private int zza;

    protected zzgwr(String str) {
        super("mvhd");
    }

    public final int zzh() {
        if (!this.zzc) {
            zzg();
        }
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzalp.zzc(byteBuffer.get());
        zzalp.zzd(byteBuffer);
        byteBuffer.get();
        return 4;
    }
}
