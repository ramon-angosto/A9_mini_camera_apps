package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzqf extends zzgi {
    private long zzf;
    private int zzg;
    private int zzh = 32;

    public zzqf() {
        super(2, 0);
    }

    public final void zzb() {
        super.zzb();
        this.zzg = 0;
    }

    public final int zzl() {
        return this.zzg;
    }

    public final long zzm() {
        return this.zzf;
    }

    public final void zzn(int i) {
        this.zzh = i;
    }

    public final boolean zzo(zzgi zzgi) {
        ByteBuffer byteBuffer;
        zzdd.zzd(!zzgi.zzd(1073741824));
        zzdd.zzd(!zzgi.zzd(268435456));
        zzdd.zzd(!zzgi.zzd(4));
        if (zzp()) {
            if (this.zzg >= this.zzh || zzgi.zzd(Integer.MIN_VALUE) != zzd(Integer.MIN_VALUE)) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzgi.zzb;
            if (!(byteBuffer2 == null || (byteBuffer = this.zzb) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000)) {
                return false;
            }
        }
        int i = this.zzg;
        this.zzg = i + 1;
        if (i == 0) {
            this.zzd = zzgi.zzd;
            if (zzgi.zzd(1)) {
                zzc(1);
            }
        }
        if (zzgi.zzd(Integer.MIN_VALUE)) {
            zzc(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer3 = zzgi.zzb;
        if (byteBuffer3 != null) {
            zzi(byteBuffer3.remaining());
            this.zzb.put(byteBuffer3);
        }
        this.zzf = zzgi.zzd;
        return true;
    }

    public final boolean zzp() {
        return this.zzg > 0;
    }
}
