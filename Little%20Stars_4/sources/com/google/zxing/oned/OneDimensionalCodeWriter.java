package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public abstract class OneDimensionalCodeWriter implements Writer {
    private final int sidesMargin;

    public abstract byte[] encode(String str);

    protected OneDimensionalCodeWriter(int i) {
        this.sidesMargin = i;
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, (Map<EncodeHintType, ?>) null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i >= 0 && i2 >= 0) {
            return renderResult(encode(str), i, i2);
        } else {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        }
    }

    private BitMatrix renderResult(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int i3 = this.sidesMargin + length;
        int max = Math.max(i, i3);
        int max2 = Math.max(1, i2);
        int i4 = max / i3;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i5 = (max - (length * i4)) / 2;
        int i6 = 0;
        while (i6 < length) {
            if (bArr[i6] == 1) {
                bitMatrix.setRegion(i5, 0, i4, max2);
            }
            i6++;
            i5 += i4;
        }
        return bitMatrix;
    }

    protected static int appendPattern(byte[] bArr, int i, int[] iArr, int i2) {
        if (i2 == 0 || i2 == 1) {
            int length = iArr.length;
            int i3 = i;
            byte b = (byte) i2;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int i6 = iArr[i4];
                int i7 = i3;
                int i8 = i5;
                for (int i9 = 0; i9 < i6; i9++) {
                    bArr[i7] = b;
                    i7++;
                    i8++;
                }
                b = (byte) (b ^ 1);
                i4++;
                i5 = i8;
                i3 = i7;
            }
            return i5;
        }
        throw new IllegalArgumentException("startColor must be either 0 or 1, but got: " + i2);
    }
}
