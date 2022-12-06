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
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    /* access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.image;
    }

    /* access modifiers changed from: protected */
    public final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect((Map<DecodeHintType, ?>) null);
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return processFinderPatternInfo(new FinderPatternFinder(this.image, this.resultPointCallback).find(map));
    }

    /* access modifiers changed from: protected */
    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
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

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
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

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f) throws NotFoundException {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f)) / 2) + 7;
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
    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
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

    private float sizeOfBlackWhiteBlackRun(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        Detector detector;
        boolean z2;
        boolean z3 = true;
        boolean z4 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z4) {
            i5 = i;
            i7 = i2;
            i6 = i3;
            i8 = i4;
        } else {
            i7 = i;
            i5 = i2;
            i8 = i3;
            i6 = i4;
        }
        int abs = Math.abs(i8 - i7);
        int abs2 = Math.abs(i6 - i5);
        int i11 = 2;
        int i12 = (-abs) / 2;
        int i13 = -1;
        int i14 = i7 < i8 ? 1 : -1;
        if (i5 < i6) {
            i13 = 1;
        }
        int i15 = i8 + i14;
        int i16 = i5;
        int i17 = i12;
        int i18 = 0;
        int i19 = i7;
        while (true) {
            if (i19 == i15) {
                i9 = i11;
                break;
            }
            int i20 = z4 ? i16 : i19;
            int i21 = z4 ? i19 : i16;
            if (i18 == z3) {
                z = z4;
                z2 = z3;
                i10 = i14;
                detector = this;
            } else {
                detector = this;
                z = z4;
                i10 = i14;
                z2 = false;
            }
            if (z2 == detector.image.get(i20, i21)) {
                i9 = 2;
                if (i18 == 2) {
                    return MathUtils.distance(i19, i16, i7, i5);
                }
                i18++;
            } else {
                i9 = 2;
            }
            i17 += abs2;
            if (i17 > 0) {
                if (i16 == i6) {
                    break;
                }
                i16 += i13;
                i17 -= abs;
            }
            i19 += i10;
            i14 = i10;
            i11 = i9;
            z4 = z;
            z3 = true;
        }
        if (i18 == i9) {
            return MathUtils.distance(i15, i6, i7, i5);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final AlignmentPattern findAlignmentInRegion(float f, int i, int i2, float f2) throws NotFoundException {
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
