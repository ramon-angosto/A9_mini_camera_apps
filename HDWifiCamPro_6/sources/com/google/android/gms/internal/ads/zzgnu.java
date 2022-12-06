package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgnu {
    static byte[] zza(byte[] bArr) {
        int length = bArr.length;
        if (length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            copyOf[length] = ByteCompanionObject.MIN_VALUE;
            return copyOf;
        }
        throw new IllegalArgumentException("x must be smaller than a block.");
    }

    static byte[] zzb(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            for (int i = 0; i < 16; i++) {
                byte b = bArr[i];
                byte b2 = (byte) ((b + b) & 254);
                bArr2[i] = b2;
                if (i < 15) {
                    bArr2[i] = (byte) (((bArr[i + 1] >> 7) & 1) | b2);
                }
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & TsExtractor.TS_STREAM_TYPE_E_AC3)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }
}
