package com.bytedance.sdk.component.d.c.c;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import kotlin.UByte;

/* compiled from: MD5Util */
public class c {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
                    instance.update(str.getBytes("UTF-8"));
                    return a(instance.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            return a(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        } else if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                byte b = bArr[i5 + i] & UByte.MAX_VALUE;
                int i6 = i4 + 1;
                char[] cArr2 = a;
                cArr[i4] = cArr2[b >> 4];
                i4 = i6 + 1;
                cArr[i6] = cArr2[b & 15];
            }
            return new String(cArr, 0, i3);
        }
    }
}
