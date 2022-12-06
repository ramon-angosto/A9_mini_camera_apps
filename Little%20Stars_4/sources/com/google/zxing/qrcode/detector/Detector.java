package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    private static int round(float f) {
        return (int) (f + 0.5f);
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    /* access modifiers changed from: protected */
    public BitMatrix getImage() {
        return this.image;
    }

    /* access modifiers changed from: protected */
    public ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect((Map<DecodeHintType, ?>) null);
    }

    public DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return processFinderPatternInfo(new FinderPatternFinder(this.image, this.resultPointCallback).find(map));
    }

    /* access modifiers changed from: protected */
    public DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float calculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (calculateModuleSize >= 1.0f) {
            int computeDimension = computeDimension(topLeft, topRight, bottomLeft, calculateModuleSize);
            Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(computeDimension);
            int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
            AlignmentPattern alignmentPattern = null;
            if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
                float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
                float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
                float f = 1.0f - (3.0f / ((float) dimensionForVersion));
                int x2 = (int) (topLeft.getX() + ((x - topLeft.getX()) * f));
                int y2 = (int) (topLeft.getY() + (f * (y - topLeft.getY())));
                int i = 4;
                while (true) {
                    if (i > 16) {
                        break;
                    }
                    try {
                        alignmentPattern = findAlignmentInRegion(calculateModuleSize, x2, y2, (float) i);
                        break;
                    } catch (NotFoundException unused) {
                        i <<= 1;
                    }
                }
            }
            BitMatrix sampleGrid = sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPattern, computeDimension), computeDimension);
            if (alignmentPattern == null) {
                resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight};
            } else {
                resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPattern};
            }
            return new DetectorResult(sampleGrid, resultPointArr);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float f;
        float f2;
        float f3;
        float f4 = ((float) i) - 3.5f;
        if (resultPoint4 != null) {
            f2 = resultPoint4.getX();
            f = resultPoint4.getY();
            f3 = f4 - 3.0f;
        } else {
            f2 = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            f = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f3 = f4;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f4, 3.5f, f3, f3, 3.5f, f4, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), f2, f, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i, perspectiveTransform);
    }

    protected static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f) throws NotFoundException {
        int round = ((round(ResultPoint.distance(resultPoint, resultPoint2) / f) + round(ResultPoint.distance(resultPoint, resultPoint3) / f)) >> 1) + 7;
        int i = round & 3;
        if (i == 0) {
            return round + 1;
        }
        if (i == 2) {
            return round - 1;
        }
        if (i != 3) {
            return round;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* access modifiers changed from: protected */
    public float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays)) {
            return sizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        return Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2) ? sizeOfBlackWhiteBlackRunBothWays / 7.0f : (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i, i2, i3, i4);
        int i6 = i - (i3 - i);
        int i7 = 0;
        if (i6 < 0) {
            f = ((float) i) / ((float) (i - i6));
            i5 = 0;
        } else if (i6 >= this.image.getWidth()) {
            f = ((float) ((this.image.getWidth() - 1) - i)) / ((float) (i6 - i));
            i5 = this.image.getWidth() - 1;
        } else {
            i5 = i6;
            f = 1.0f;
        }
        float f3 = (float) i2;
        int i8 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i8 < 0) {
            f2 = f3 / ((float) (i2 - i8));
        } else if (i8 >= this.image.getHeight()) {
            f2 = ((float) ((this.image.getHeight() - 1) - i2)) / ((float) (i8 - i2));
            i7 = this.image.getHeight() - 1;
        } else {
            i7 = i8;
            f2 = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i, i2, (int) (((float) i) + (((float) (i5 - i)) * f2)), i7)) - 1.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        if (r14 != 2) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0097, code lost:
        r1 = r20 - r4;
        r0 = java.lang.Math.sqrt((double) ((r1 * r1) + (r19 * r19)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a4, code lost:
        return Float.NaN;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float sizeOfBlackWhiteBlackRun(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x001d
            r6 = r18
            r4 = r19
            r5 = r20
            r1 = r21
            goto L_0x0025
        L_0x001d:
            r4 = r18
            r6 = r19
            r1 = r20
            r5 = r21
        L_0x0025:
            int r7 = r1 - r4
            int r7 = java.lang.Math.abs(r7)
            int r8 = r5 - r6
            int r9 = java.lang.Math.abs(r8)
            int r10 = -r7
            int r10 = r10 >> r3
            r11 = -1
            if (r4 >= r1) goto L_0x0038
            r12 = 1
            goto L_0x0039
        L_0x0038:
            r12 = -1
        L_0x0039:
            if (r6 >= r5) goto L_0x003c
            r11 = 1
        L_0x003c:
            int r1 = r1 + r12
            r13 = r6
            r15 = r10
            r14 = 0
            r10 = r4
        L_0x0041:
            if (r10 == r1) goto L_0x008e
            if (r0 == 0) goto L_0x0047
            r2 = r13
            goto L_0x0048
        L_0x0047:
            r2 = r10
        L_0x0048:
            if (r0 == 0) goto L_0x004e
            r16 = r0
            r0 = r10
            goto L_0x0051
        L_0x004e:
            r16 = r0
            r0 = r13
        L_0x0051:
            if (r14 != r3) goto L_0x005b
            r3 = r17
            r20 = r1
            r19 = r8
            r8 = 1
            goto L_0x0062
        L_0x005b:
            r3 = r17
            r20 = r1
            r19 = r8
            r8 = 0
        L_0x0062:
            com.google.zxing.common.BitMatrix r1 = r3.image
            boolean r0 = r1.get(r2, r0)
            if (r8 != r0) goto L_0x007d
            r0 = 2
            if (r14 != r0) goto L_0x007b
            int r10 = r10 - r4
            int r13 = r13 - r6
            int r10 = r10 * r10
            int r13 = r13 * r13
            int r10 = r10 + r13
            double r0 = (double) r10
            double r0 = java.lang.Math.sqrt(r0)
        L_0x0079:
            float r0 = (float) r0
            return r0
        L_0x007b:
            int r14 = r14 + 1
        L_0x007d:
            int r15 = r15 + r9
            if (r15 <= 0) goto L_0x0085
            if (r13 != r5) goto L_0x0083
            goto L_0x0094
        L_0x0083:
            int r13 = r13 + r11
            int r15 = r15 - r7
        L_0x0085:
            int r10 = r10 + r12
            r8 = r19
            r1 = r20
            r0 = r16
            r3 = 1
            goto L_0x0041
        L_0x008e:
            r3 = r17
            r20 = r1
            r19 = r8
        L_0x0094:
            r0 = 2
            if (r14 != r0) goto L_0x00a4
            int r1 = r20 - r4
            int r1 = r1 * r1
            int r8 = r19 * r19
            int r1 = r1 + r8
            double r0 = (double) r1
            double r0 = java.lang.Math.sqrt(r0)
            goto L_0x0079
        L_0x00a4:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.Detector.sizeOfBlackWhiteBlackRun(int, int, int, int):float");
    }

    /* access modifiers changed from: protected */
    public AlignmentPattern findAlignmentInRegion(float f, int i, int i2, float f2) throws NotFoundException {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.image.getWidth() - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.image.getHeight() - 1, i2 + i3) - max2;
            if (((float) min2) >= f3) {
                return new AlignmentPatternFinder(this.image, max, max2, min, min2, f, this.resultPointCallback).find();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
