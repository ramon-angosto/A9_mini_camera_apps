package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class ITFWriter extends UPCEANWriter {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    public byte[] encode(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        } else if (length <= 80) {
            byte[] bArr = new byte[((length * 9) + 9)];
            int appendPattern = appendPattern(bArr, 0, new int[]{1, 1, 1, 1}, 1);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 << 1;
                    iArr[i3] = ITFReader.PATTERNS[digit][i2];
                    iArr[i3 + 1] = ITFReader.PATTERNS[digit2][i2];
                }
                appendPattern += appendPattern(bArr, appendPattern, iArr, 1);
            }
            appendPattern(bArr, appendPattern, new int[]{3, 1, 1}, 1);
            return bArr;
        } else {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
    }
}
