package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.p005ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    private static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    private PDF417ScanningDecoder() {
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException, FormatException, ChecksumException {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn;
        DetectionResult merge;
        DetectionResultColumn detectionResultRowIndicatorColumn2;
        DetectionResultColumn detectionResultColumn;
        int i3;
        int i4;
        int i5;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn3 = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn4 = null;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        boolean z = true;
        while (true) {
            if (resultPoint != null) {
                detectionResultRowIndicatorColumn3 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i, i2);
            }
            detectionResultRowIndicatorColumn = detectionResultRowIndicatorColumn3;
            if (resultPoint3 != null) {
                detectionResultRowIndicatorColumn4 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i, i2);
            }
            merge = merge(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn4);
            if (merge != null) {
                BoundingBox boundingBox2 = merge.getBoundingBox();
                if (!z || boundingBox2 == null || (boundingBox2.getMinY() >= boundingBox.getMinY() && boundingBox2.getMaxY() <= boundingBox.getMaxY())) {
                    merge.setBoundingBox(boundingBox);
                    int barcodeColumnCount = merge.getBarcodeColumnCount() + 1;
                    merge.setDetectionResultColumn(0, detectionResultRowIndicatorColumn);
                    merge.setDetectionResultColumn(barcodeColumnCount, detectionResultRowIndicatorColumn4);
                } else {
                    boundingBox = boundingBox2;
                    detectionResultRowIndicatorColumn3 = detectionResultRowIndicatorColumn;
                    z = false;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        merge.setBoundingBox(boundingBox);
        int barcodeColumnCount2 = merge.getBarcodeColumnCount() + 1;
        merge.setDetectionResultColumn(0, detectionResultRowIndicatorColumn);
        merge.setDetectionResultColumn(barcodeColumnCount2, detectionResultRowIndicatorColumn4);
        boolean z2 = detectionResultRowIndicatorColumn != null;
        int i6 = i;
        int i7 = i2;
        for (int i8 = 1; i8 <= barcodeColumnCount2; i8++) {
            int i9 = z2 ? i8 : barcodeColumnCount2 - i8;
            if (merge.getDetectionResultColumn(i9) == null) {
                if (i9 == 0 || i9 == barcodeColumnCount2) {
                    detectionResultRowIndicatorColumn2 = new DetectionResultRowIndicatorColumn(boundingBox, i9 == 0);
                } else {
                    detectionResultRowIndicatorColumn2 = new DetectionResultColumn(boundingBox);
                }
                DetectionResultColumn detectionResultColumn2 = detectionResultRowIndicatorColumn2;
                merge.setDetectionResultColumn(i9, detectionResultColumn2);
                int i10 = -1;
                int i11 = i7;
                int i12 = -1;
                int i13 = i6;
                int minY = boundingBox.getMinY();
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(merge, i9, minY, z2);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        i5 = startColumn;
                    } else if (i12 == i10) {
                        i3 = i12;
                        i4 = i11;
                        detectionResultColumn = detectionResultColumn2;
                        i11 = i4;
                        i12 = i3;
                        minY++;
                        detectionResultColumn2 = detectionResultColumn;
                        i10 = -1;
                    } else {
                        i5 = i12;
                    }
                    i3 = i12;
                    int i14 = i11;
                    detectionResultColumn = detectionResultColumn2;
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z2, i5, minY, i13, i14);
                    if (detectCodeword != null) {
                        detectionResultColumn.setCodeword(minY, detectCodeword);
                        i13 = Math.min(i13, detectCodeword.getWidth());
                        i11 = Math.max(i14, detectCodeword.getWidth());
                        i12 = i5;
                        minY++;
                        detectionResultColumn2 = detectionResultColumn;
                        i10 = -1;
                    } else {
                        i4 = i14;
                        i11 = i4;
                        i12 = i3;
                        minY++;
                        detectionResultColumn2 = detectionResultColumn;
                        i10 = -1;
                    }
                }
                i6 = i13;
                i7 = i11;
            }
        }
        return createDecoderResult(merge);
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i = 0;
        int i2 = 0;
        for (int i3 : rowHeights) {
            i2 += max - i3;
            if (i3 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        int i4 = i2;
        int i5 = 0;
        while (i4 > 0 && codewords[i5] == null) {
            i4--;
            i5++;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        int length2 = codewords.length - 1;
        while (i > 0 && codewords[length2] == null) {
            i--;
            length2--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i4, i, detectionResultRowIndicatorColumn.isLeft());
    }

    private static int getMax(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        } else if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
            return barcodeMetadata;
        } else {
            return null;
        }
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i, int i2) {
        boolean z2 = z;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            while (y <= boundingBox.getMaxY() && y >= boundingBox.getMinY()) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y, detectCodeword);
                    if (z2) {
                        x = detectCodeword.getStartX();
                    } else {
                        x = detectCodeword.getEndX();
                    }
                }
                y += i4;
            }
            i3++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        BarcodeValue barcodeValue = barcodeValueArr[0][1];
        int[] value = barcodeValue.getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length == 0) {
            if (barcodeColumnCount < 1 || barcodeColumnCount > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValue.setValue(barcodeColumnCount);
        } else if (value[0] != barcodeColumnCount) {
            barcodeValue.setValue(barcodeColumnCount);
        }
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[(detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount())];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < detectionResult.getBarcodeRowCount(); i++) {
            int i2 = 0;
            while (i2 < detectionResult.getBarcodeColumnCount()) {
                int i3 = i2 + 1;
                int[] value = createBarcodeMatrix[i][i3].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i) + i2;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i2 = i3;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < iArr5.length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return decodeCodewords(iArr, i, iArr2);
                } catch (ChecksumException unused) {
                    if (iArr5.length != 0) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= iArr5.length) {
                                break;
                            } else if (iArr5[i5] < iArr4[i5].length - 1) {
                                iArr5[i5] = iArr5[i5] + 1;
                                break;
                            } else {
                                iArr5[i5] = 0;
                                if (i5 != iArr5.length - 1) {
                                    i5++;
                                } else {
                                    throw ChecksumException.getChecksumInstance();
                                }
                            }
                        }
                        i2 = i3;
                    } else {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        int rowNumber;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, new int[]{detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2});
        for (int i = 0; i < barcodeValueArr.length; i++) {
            for (int i2 = 0; i2 < barcodeValueArr[i].length; i2++) {
                barcodeValueArr[i][i2] = new BarcodeValue();
            }
        }
        int i3 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i3].setValue(codeword.getValue());
                    }
                }
            }
            i3++;
        }
        return barcodeValueArr;
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        Codeword codeword = null;
        int i4 = i - i3;
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codeword = detectionResult.getDetectionResultColumn(i4).getCodeword(i2);
        }
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i).getCodewordNearby(i2);
        if (codewordNearby != null) {
            return z ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i4).getCodewordNearby(i2);
        }
        if (codewordNearby != null) {
            return z ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!isValidBarcodeColumn(detectionResult, i)) {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
            for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i).getCodewords()) {
                if (codeword2 != null) {
                    return (z ? codeword2.getEndX() : codeword2.getStartX()) + (i3 * i5 * (codeword2.getEndX() - codeword2.getStartX()));
                }
            }
            i5++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r7 = com.google.zxing.pdf417.decoder.PDF417CodewordDecoder.getDecodedValue(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.zxing.pdf417.decoder.Codeword detectCodeword(com.google.zxing.common.BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12, int r13, int r14) {
        /*
            int r11 = adjustCodewordStartColumn(r7, r8, r9, r10, r11, r12)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            int[] r7 = getModuleBitCount(r0, r1, r2, r3, r4, r5)
            r8 = 0
            if (r7 != 0) goto L_0x0012
            return r8
        L_0x0012:
            int r9 = com.google.zxing.common.detector.MathUtils.sum(r7)
            if (r10 == 0) goto L_0x001e
            int r10 = r11 + r9
            r6 = r11
            r11 = r10
            r10 = r6
            goto L_0x0026
        L_0x001e:
            r10 = 0
        L_0x001f:
            int r12 = r7.length
            int r12 = r12 / 2
            if (r10 < r12) goto L_0x0043
            int r10 = r11 - r9
        L_0x0026:
            boolean r9 = checkCodewordSkew(r9, r13, r14)
            if (r9 != 0) goto L_0x002d
            return r8
        L_0x002d:
            int r7 = com.google.zxing.pdf417.decoder.PDF417CodewordDecoder.getDecodedValue(r7)
            int r9 = com.google.zxing.pdf417.PDF417Common.getCodeword(r7)
            r12 = -1
            if (r9 != r12) goto L_0x0039
            return r8
        L_0x0039:
            com.google.zxing.pdf417.decoder.Codeword r8 = new com.google.zxing.pdf417.decoder.Codeword
            int r7 = getCodewordBucketNumber((int) r7)
            r8.<init>(r10, r11, r7, r9)
            return r8
        L_0x0043:
            r12 = r7[r10]
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r0 = r7[r0]
            r7[r10] = r0
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r7[r0] = r12
            int r10 = r10 + 1
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.detectCodeword(com.google.zxing.common.BitMatrix, int, int, boolean, int, int, int, int):com.google.zxing.pdf417.decoder.Codeword");
    }

    private static int[] getModuleBitCount(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
            } else if (i3 >= i2) {
                break;
            }
            if (i6 >= iArr.length) {
                break;
            } else if (bitMatrix.get(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 != iArr.length) {
            if (z) {
                i = i2;
            }
            if (!(i3 == i && i6 == iArr.length - 1)) {
                return null;
            }
        }
        return iArr;
    }

    private static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        boolean z2 = z;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z2) {
                    if (i6 >= i2) {
                        continue;
                        break;
                    }
                } else if (i6 < i) {
                    continue;
                    break;
                }
                if (z2 != bitMatrix.get(i6, i4)) {
                    continue;
                    break;
                } else if (Math.abs(i3 - i6) > 2) {
                    return i3;
                } else {
                    i6 += i5;
                }
            }
            i5 = -i5;
            z2 = !z2;
        }
        return i6;
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int correctErrors = correctErrors(iArr, iArr2, i2);
            verifyCodewordCount(iArr, i2);
            DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i));
            decode.setErrorsCorrected(Integer.valueOf(correctErrors));
            decode.setErasures(Integer.valueOf(iArr2.length));
            return decode;
        }
        throw FormatException.getFormatInstance();
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return errorCorrection.decode(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static void verifyCodewordCount(int[] iArr, int i) throws FormatException {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw FormatException.getFormatInstance();
            } else if (i2 != 0) {
            } else {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int length = iArr.length - 1;
        int i2 = 0;
        while (true) {
            int i3 = i & 1;
            if (i3 != i2) {
                length--;
                if (length < 0) {
                    return iArr;
                }
                i2 = i3;
            }
            iArr[length] = iArr[length] + 1;
            i >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        Formatter formatter;
        Throwable th = null;
        try {
            formatter = new Formatter();
            for (int i = 0; i < barcodeValueArr.length; i++) {
                formatter.format("Row %2d: ", new Object[]{Integer.valueOf(i)});
                for (BarcodeValue barcodeValue : barcodeValueArr[i]) {
                    if (barcodeValue.getValue().length == 0) {
                        formatter.format("        ", (Object[]) null);
                    } else {
                        formatter.format("%4d(%2d)", new Object[]{Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0])});
                    }
                }
                formatter.format("%n", new Object[0]);
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th2) {
            th = th2;
            if (th != null) {
                if (th != th) {
                    th.addSuppressed(th);
                }
                th = th;
            }
            throw th;
        }
    }
}
