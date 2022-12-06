package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class OneDReader implements Reader {
    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    public void reset() {
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !binaryBitmap.isRotateSupported()) {
                throw e;
            }
            BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
            Result doDecode = doDecode(rotateCounterClockwise, map);
            Map<ResultMetadataType, Object> resultMetadata = doDecode.getResultMetadata();
            int i = 270;
            if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                i = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
            }
            doDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
            ResultPoint[] resultPoints = doDecode.getResultPoints();
            if (resultPoints != null) {
                int height = rotateCounterClockwise.getHeight();
                for (int i2 = 0; i2 < resultPoints.length; i2++) {
                    resultPoints[i2] = new ResultPoint((((float) height) - resultPoints[i2].getY()) - 1.0f, resultPoints[i2].getX());
                }
            }
            return doDecode;
        }
    }

    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i;
        int i2;
        int i3;
        int i4;
        Map<DecodeHintType, ?> map2 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i5 = 0;
        int i6 = 1;
        boolean z = map2 != null && map2.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, height >> (z ? 8 : 5));
        int i7 = z ? height : 15;
        int i8 = height / 2;
        EnumMap enumMap = map2;
        int i9 = 0;
        while (i9 < i7) {
            int i10 = i9 + 1;
            int i11 = i10 / 2;
            if (((i9 & 1) == 0 ? i6 : i5) == 0) {
                i11 = -i11;
            }
            int i12 = (i11 * max) + i8;
            if (i12 < 0 || i12 >= height) {
                break;
            }
            try {
                BitArray blackRow = binaryBitmap.getBlackRow(i12, bitArray);
                int i13 = i5;
                while (i13 < 2) {
                    if (i13 == i6) {
                        blackRow.reverse();
                        if (enumMap != null && enumMap.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap2 = new EnumMap(DecodeHintType.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        Result decodeRow = decodeRow(i12, blackRow, enumMap);
                        if (i13 == i6) {
                            try {
                                decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                ResultPoint[] resultPoints = decodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    float f = (float) width;
                                    i3 = width;
                                    try {
                                        resultPoints[0] = new ResultPoint((f - resultPoints[i5].getX()) - 1.0f, resultPoints[i5].getY());
                                        i4 = 1;
                                        try {
                                            resultPoints[1] = new ResultPoint((f - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                        } catch (ReaderException unused) {
                                            continue;
                                        }
                                    } catch (ReaderException unused2) {
                                        i4 = 1;
                                        i13++;
                                        BinaryBitmap binaryBitmap2 = binaryBitmap;
                                        i6 = i4;
                                        width = i3;
                                        i5 = 0;
                                    }
                                }
                            } catch (ReaderException unused3) {
                                i3 = width;
                                i4 = 1;
                                i13++;
                                BinaryBitmap binaryBitmap22 = binaryBitmap;
                                i6 = i4;
                                width = i3;
                                i5 = 0;
                            }
                        }
                        return decodeRow;
                    } catch (ReaderException unused4) {
                        i3 = width;
                        i4 = i6;
                        i13++;
                        BinaryBitmap binaryBitmap222 = binaryBitmap;
                        i6 = i4;
                        width = i3;
                        i5 = 0;
                    }
                }
                i = width;
                i2 = i6;
                bitArray = blackRow;
            } catch (NotFoundException unused5) {
                i = width;
                i2 = i6;
            }
            i9 = i10;
            i6 = i2;
            width = i;
            i5 = 0;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i < size) {
            boolean z = !bitArray.get(i);
            while (i < size) {
                if (bitArray.get(i) != z) {
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    iArr[i2] = 1;
                    z = !z;
                }
                i++;
            }
            if (i2 == length) {
                return;
            }
            if (i2 != length - 1 || i != size) {
                throw NotFoundException.getNotFoundInstance();
            }
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.get(i) != z) {
                length--;
                z = !z;
            }
        }
        if (length < 0) {
            recordPattern(bitArray, i + 1, iArr);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
