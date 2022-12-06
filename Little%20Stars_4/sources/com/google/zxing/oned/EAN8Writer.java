package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class EAN8Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 67;

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    public byte[] encode(String str) {
        if (str.length() == 8) {
            byte[] bArr = new byte[CODE_WIDTH];
            int appendPattern = appendPattern(bArr, 0, UPCEANReader.START_END_PATTERN, 1) + 0;
            int i = 0;
            while (i <= 3) {
                int i2 = i + 1;
                appendPattern += appendPattern(bArr, appendPattern, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i, i2))], 0);
                i = i2;
            }
            int appendPattern2 = appendPattern + appendPattern(bArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, 0);
            int i3 = 4;
            while (i3 <= 7) {
                int i4 = i3 + 1;
                appendPattern2 += appendPattern(bArr, appendPattern2, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i3, i4))], 1);
                i3 = i4;
            }
            appendPattern(bArr, appendPattern2, UPCEANReader.START_END_PATTERN, 1);
            return bArr;
        }
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
    }
}
