package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader {
    private static final int MAX_AVG_VARIANCE = 51;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final int MAX_INDIVIDUAL_VARIANCE = 102;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] dataCharacterCounters = new int[8];
    private final int[] decodeFinderCounters = new int[4];
    private final int[] evenCounts;
    private final float[] evenRoundingErrors = new float[4];
    private final int[] oddCounts;
    private final float[] oddRoundingErrors = new float[4];

    protected AbstractRSSReader() {
        int[] iArr = this.dataCharacterCounters;
        this.oddCounts = new int[(iArr.length / 2)];
        this.evenCounts = new int[(iArr.length / 2)];
    }

    /* access modifiers changed from: protected */
    public int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    /* access modifiers changed from: protected */
    public int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    /* access modifiers changed from: protected */
    public float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }

    /* access modifiers changed from: protected */
    public float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    /* access modifiers changed from: protected */
    public int[] getOddCounts() {
        return this.oddCounts;
    }

    /* access modifiers changed from: protected */
    public int[] getEvenCounts() {
        return this.evenCounts;
    }

    protected static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (patternMatchVariance(iArr, iArr2[i], MAX_INDIVIDUAL_VARIANCE) < 51) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static int count(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    protected static void increment(int[] iArr, float[] fArr) {
        float f = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void decrement(int[] iArr, float[] fArr) {
        float f = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean isFinderPattern(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f < MIN_FINDER_PATTERN_RATIO || f > MAX_FINDER_PATTERN_RATIO) {
            return false;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (int i4 : iArr) {
            if (i4 > i2) {
                i2 = i4;
            }
            if (i4 < i3) {
                i3 = i4;
            }
        }
        if (i2 < i3 * 10) {
            return true;
        }
        return false;
    }
}
