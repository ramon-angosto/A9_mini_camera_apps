package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Map;

public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS = (SHIFT_JIS.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING));
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = System.getProperty("file.encoding");
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        byte b;
        byte b2;
        String str;
        byte[] bArr2 = bArr;
        Map<DecodeHintType, ?> map2 = map;
        if (map2 != null && (str = (String) map2.get(DecodeHintType.CHARACTER_SET)) != null) {
            return str;
        }
        if (bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65) {
            return UTF8;
        }
        int length = bArr2.length;
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        int i = 0;
        boolean z4 = false;
        int i2 = 0;
        int i3 = 0;
        boolean z5 = false;
        boolean z6 = false;
        for (int i4 = 0; i4 < length && (z || z2 || z3); i4++) {
            byte b3 = bArr2[i4] & 255;
            if (b3 < 128 || b3 > 191) {
                if (i > 0) {
                    z3 = false;
                }
                if (b3 >= 192 && b3 <= 253) {
                    for (int i5 = b3; (i5 & 64) != 0; i5 <<= 1) {
                        i++;
                    }
                    z4 = true;
                }
            } else if (i > 0) {
                i--;
            }
            if ((b3 == 194 || b3 == 195) && i4 < length - 1 && (b2 = bArr2[i4 + 1] & 255) <= 191 && ((b3 == 194 && b2 >= 160) || (b3 == 195 && b2 >= 128))) {
                z5 = true;
            }
            if (b3 >= Byte.MAX_VALUE && b3 <= 159) {
                z = false;
            }
            if (b3 >= 161 && b3 <= 223 && !z6) {
                i3++;
            }
            if (!z6 && ((b3 >= 240 && b3 <= 255) || b3 == 128 || b3 == 160)) {
                z2 = false;
            }
            if (((b3 < 129 || b3 > 159) && (b3 < 224 || b3 > 239)) || z6) {
                z6 = false;
            } else {
                if (i4 < bArr2.length - 1 && (b = bArr2[i4 + 1] & 255) >= 64 && b <= 252) {
                    i2++;
                } else {
                    z2 = false;
                }
                z6 = true;
            }
        }
        if (i > 0) {
            z3 = false;
        }
        if (z2 && ASSUME_SHIFT_JIS) {
            return SHIFT_JIS;
        }
        if (z3 && z4) {
            return UTF8;
        }
        if (!z2 || (i2 < 3 && i3 * 20 <= length)) {
            return (z5 || !z) ? PLATFORM_DEFAULT_ENCODING : ISO88591;
        }
        return SHIFT_JIS;
    }
}
