package com.bytedance.sdk.openadsdk.l;

import java.security.SecureRandom;
import java.util.UUID;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: PangleUUID */
public class o {
    private static final ThreadLocal<SecureRandom> a = new ThreadLocal<>();

    public static String a() {
        byte[] bArr = new byte[16];
        SecureRandom secureRandom = a.get();
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
            a.set(secureRandom);
        }
        secureRandom.nextBytes(bArr);
        bArr[6] = (byte) (bArr[6] & 15);
        bArr[6] = (byte) (bArr[6] | 64);
        bArr[8] = (byte) (bArr[8] & 63);
        bArr[8] = (byte) (bArr[8] | ByteCompanionObject.MIN_VALUE);
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 << 8) | ((long) (bArr[i] & UByte.MAX_VALUE));
        }
        for (int i2 = 8; i2 < 16; i2++) {
            j = (j << 8) | ((long) (bArr[i2] & UByte.MAX_VALUE));
        }
        return new UUID(j2, j).toString();
    }
}
