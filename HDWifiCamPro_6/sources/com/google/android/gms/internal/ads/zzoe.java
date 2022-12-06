package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzoe extends zzod {
    private int[] zzd;
    private int[] zze;

    zzoe() {
    }

    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        if (iArr != null) {
            int[] iArr2 = iArr;
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            ByteBuffer zzj = zzj(((limit - position) / this.zzb.zze) * this.zzc.zze);
            while (position < limit) {
                for (int i : iArr2) {
                    zzj.putShort(byteBuffer.getShort(i + i + position));
                }
                position += this.zzb.zze;
            }
            byteBuffer.position(limit);
            zzj.flip();
            return;
        }
        throw null;
    }

    public final zzne zzi(zzne zzne) throws zznf {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzne.zza;
        }
        if (zzne.zzd == 2) {
            boolean z = zzne.zzc != iArr.length;
            int i = 0;
            while (true) {
                int length = iArr.length;
                if (i >= length) {
                    return z ? new zzne(zzne.zzb, length, 2) : zzne.zza;
                }
                int i2 = iArr[i];
                if (i2 < zzne.zzc) {
                    z |= i2 != i;
                    i++;
                } else {
                    throw new zznf(zzne);
                }
            }
        } else {
            throw new zznf(zzne);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zze = this.zzd;
    }

    /* access modifiers changed from: protected */
    public final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] iArr) {
        this.zzd = iArr;
    }
}
