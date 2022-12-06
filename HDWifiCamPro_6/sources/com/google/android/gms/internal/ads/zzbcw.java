package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbcw extends zzbcr {
    private MessageDigest zzb;

    public final byte[] zzb(String str) {
        byte[] bArr;
        String[] split = str.split(" ");
        int length = split.length;
        int i = 4;
        if (length == 1) {
            int zza = zzbcv.zza(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zza);
            bArr = allocate.array();
        } else if (length < 5) {
            bArr = new byte[(length + length)];
            for (int i2 = 0; i2 < split.length; i2++) {
                int zza2 = zzbcv.zza(split[i2]);
                char c = (zza2 >> 16) ^ ((char) zza2);
                byte[] bArr2 = {(byte) c, (byte) (c >> 8)};
                int i3 = i2 + i2;
                bArr[i3] = bArr2[0];
                bArr[i3 + 1] = bArr2[1];
            }
        } else {
            bArr = new byte[length];
            for (int i4 = 0; i4 < split.length; i4++) {
                int zza3 = zzbcv.zza(split[i4]);
                bArr[i4] = (byte) ((zza3 >> 24) ^ (((zza3 & 255) ^ ((zza3 >> 8) & 255)) ^ ((zza3 >> 16) & 255)));
            }
        }
        this.zzb = zza();
        synchronized (this.zza) {
            MessageDigest messageDigest = this.zzb;
            if (messageDigest == null) {
                byte[] bArr3 = new byte[0];
                return bArr3;
            }
            messageDigest.reset();
            this.zzb.update(bArr);
            byte[] digest = this.zzb.digest();
            int length2 = digest.length;
            if (length2 <= 4) {
                i = length2;
            }
            byte[] bArr4 = new byte[i];
            System.arraycopy(digest, 0, bArr4, 0, bArr4.length);
            return bArr4;
        }
    }
}
