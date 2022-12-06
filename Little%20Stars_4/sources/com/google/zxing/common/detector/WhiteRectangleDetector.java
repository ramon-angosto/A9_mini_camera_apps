package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 30;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    private static int round(float f) {
        return (int) (f + 0.5f);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        int i = this.width;
        this.leftInit = (i - 30) >> 1;
        this.rightInit = (i + 30) >> 1;
        int i2 = this.height;
        this.upInit = (i2 - 30) >> 1;
        this.downInit = (i2 + 30) >> 1;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= i2 || this.rightInit >= i) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        int i4 = i >> 1;
        this.leftInit = i2 - i4;
        this.rightInit = i2 + i4;
        this.upInit = i3 - i4;
        this.downInit = i3 + i4;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i = this.leftInit;
        int i2 = this.rightInit;
        int i3 = this.upInit;
        int i4 = this.downInit;
        boolean z = false;
        int i5 = i;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            if (!z2) {
                break;
            }
            boolean z4 = true;
            boolean z5 = false;
            while (z4 && i2 < this.width) {
                z4 = containsBlackPoint(i3, i4, i2, false);
                if (z4) {
                    i2++;
                    z5 = true;
                }
            }
            if (i2 >= this.width) {
                break;
            }
            boolean z6 = true;
            while (z6 && i4 < this.height) {
                z6 = containsBlackPoint(i5, i2, i4, true);
                if (z6) {
                    i4++;
                    z5 = true;
                }
            }
            if (i4 >= this.height) {
                break;
            }
            boolean z7 = true;
            while (z7 && i5 >= 0) {
                z7 = containsBlackPoint(i3, i4, i5, false);
                if (z7) {
                    i5--;
                    z5 = true;
                }
            }
            if (i5 < 0) {
                break;
            }
            boolean z8 = true;
            while (z8 && i3 >= 0) {
                z8 = containsBlackPoint(i5, i2, i3, true);
                if (z8) {
                    i3--;
                    z5 = true;
                }
            }
            if (i3 < 0) {
                break;
            }
            if (z5) {
                z3 = true;
            }
            z2 = z5;
        }
        z = true;
        if (z || !z3) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i2 - i5;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        for (int i7 = 1; i7 < i6; i7++) {
            resultPoint2 = getBlackPointOnSegment((float) i5, (float) (i4 - i7), (float) (i5 + i7), (float) i4);
            if (resultPoint2 != null) {
                break;
            }
        }
        if (resultPoint2 != null) {
            ResultPoint resultPoint3 = null;
            for (int i8 = 1; i8 < i6; i8++) {
                resultPoint3 = getBlackPointOnSegment((float) i5, (float) (i3 + i8), (float) (i5 + i8), (float) i3);
                if (resultPoint3 != null) {
                    break;
                }
            }
            if (resultPoint3 != null) {
                ResultPoint resultPoint4 = null;
                for (int i9 = 1; i9 < i6; i9++) {
                    resultPoint4 = getBlackPointOnSegment((float) i2, (float) (i3 + i9), (float) (i2 - i9), (float) i3);
                    if (resultPoint4 != null) {
                        break;
                    }
                }
                if (resultPoint4 != null) {
                    for (int i10 = 1; i10 < i6; i10++) {
                        resultPoint = getBlackPointOnSegment((float) i2, (float) (i4 - i10), (float) (i2 - i10), (float) i4);
                        if (resultPoint != null) {
                            break;
                        }
                    }
                    if (resultPoint != null) {
                        return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int distanceL2 = distanceL2(f, f2, f3, f4);
        float f5 = (float) distanceL2;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < distanceL2; i++) {
            float f8 = (float) i;
            int round = round((f8 * f6) + f);
            int round2 = round((f8 * f7) + f2);
            if (this.image.get(round, round2)) {
                return new ResultPoint((float) round, (float) round2);
            }
        }
        return null;
    }

    private static int distanceL2(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return round((float) Math.sqrt((double) ((f5 * f5) + (f6 * f6))));
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x < ((float) (this.width / 2))) {
            return new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.image.get(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
