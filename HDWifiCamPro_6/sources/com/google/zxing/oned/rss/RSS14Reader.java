package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSS14Reader extends AbstractRSSReader {
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private static final int[] INSIDE_GSUM;
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] OUTSIDE_GSUM;
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private final List<Pair> possibleLeftPairs = new ArrayList();
    private final List<Pair> possibleRightPairs = new ArrayList();

    static {
        int[] iArr = new int[5];
        iArr[1] = 161;
        iArr[2] = 961;
        iArr[3] = 2015;
        iArr[4] = 2715;
        OUTSIDE_GSUM = iArr;
        int[] iArr2 = new int[4];
        iArr2[1] = 336;
        iArr2[2] = 1036;
        iArr2[3] = 1516;
        INSIDE_GSUM = iArr2;
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i, map));
        bitArray.reverse();
        for (Pair next : this.possibleLeftPairs) {
            if (next.getCount() > 1) {
                for (Pair next2 : this.possibleRightPairs) {
                    if (next2.getCount() > 1 && checkChecksum(next, next2)) {
                        return constructResult(next, next2);
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void addOrTally(Collection<Pair> collection, Pair pair) {
        if (pair != null) {
            boolean z = false;
            Iterator<Pair> it = collection.iterator();
            while (true) {
                if (it.hasNext()) {
                    Pair next = it.next();
                    if (next.getValue() == pair.getValue()) {
                        next.incrementCount();
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                collection.add(pair);
            }
        }
    }

    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        String valueOf = String.valueOf((((long) pair.getValue()) * 4537077) + ((long) pair2.getValue()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            int charAt = sb.charAt(i2) - '0';
            if ((i2 & 1) == 0) {
                charAt *= 3;
            }
            i += charAt;
        }
        int i3 = 10 - (i % 10);
        if (i3 == 10) {
            i3 = 0;
        }
        sb.append(i3);
        ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(sb.toString(), (byte[]) null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
    }

    private static boolean checkChecksum(Pair pair, Pair pair2) {
        int checksumPortion = (pair.getChecksumPortion() + (pair2.getChecksumPortion() * 16)) % 79;
        int value = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
        if (value > 72) {
            value--;
        }
        if (value > 8) {
            value--;
        }
        return checksumPortion == value;
    }

    private Pair decodePair(BitArray bitArray, boolean z, int i, Map<DecodeHintType, ?> map) {
        ResultPointCallback resultPointCallback;
        try {
            int[] findFinderPattern = findFinderPattern(bitArray, z);
            FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z, findFinderPattern);
            if (map == null) {
                resultPointCallback = null;
            } else {
                resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            }
            if (resultPointCallback != null) {
                float f = ((float) (findFinderPattern[0] + findFinderPattern[1])) / 2.0f;
                if (z) {
                    f = ((float) (bitArray.getSize() - 1)) - f;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(f, (float) i));
            }
            DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, true);
            DataCharacter decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, false);
            return new Pair((decodeDataCharacter.getValue() * 1597) + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + (decodeDataCharacter2.getChecksumPortion() * 4), parseFoundFinderPattern);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        for (int i = 0; i < dataCharacterCounters.length; i++) {
            dataCharacterCounters[i] = 0;
        }
        if (z) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int i2 = 0;
            for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                int i3 = dataCharacterCounters[i2];
                dataCharacterCounters[i2] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float sum = ((float) MathUtils.sum(dataCharacterCounters)) / ((float) i4);
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i5 = 0; i5 < dataCharacterCounters.length; i5++) {
            float f = ((float) dataCharacterCounters[i5]) / sum;
            int i6 = (int) (0.5f + f);
            if (i6 < 1) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                oddCounts[i7] = i6;
                oddRoundingErrors[i7] = f - ((float) i6);
            } else {
                evenCounts[i7] = i6;
                evenRoundingErrors[i7] = f - ((float) i6);
            }
        }
        adjustOddEvenCounts(z, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            i8 = (i8 * 9) + oddCounts[length2];
            i9 += oddCounts[length2];
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + evenCounts[length3];
            i11 += evenCounts[length3];
        }
        int i12 = i8 + (i10 * 3);
        if (z) {
            if ((i9 & 1) != 0 || i9 > 12 || i9 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i13 = (12 - i9) / 2;
            int i14 = OUTSIDE_ODD_WIDEST[i13];
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i14, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i13]) + RSSUtils.getRSSvalue(evenCounts, 9 - i14, true) + OUTSIDE_GSUM[i13], i12);
        } else if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            int i15 = (10 - i11) / 2;
            int i16 = INSIDE_ODD_WIDEST[i15];
            return new DataCharacter((RSSUtils.getRSSvalue(evenCounts, 9 - i16, false) * INSIDE_ODD_TOTAL_SUBSET[i15]) + RSSUtils.getRSSvalue(oddCounts, i16, true) + INSIDE_GSUM[i15], i12);
        }
    }

    private int[] findFinderPattern(BitArray bitArray, boolean z) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            z2 = !bitArray.get(i);
            if (z == z2) {
                break;
            }
            i++;
        }
        int i2 = 0;
        int i3 = i;
        while (i < size) {
            if (bitArray.get(i) != z2) {
                decodeFinderCounters[i2] = decodeFinderCounters[i2] + 1;
            } else {
                if (i2 != 3) {
                    i2++;
                } else if (isFinderPattern(decodeFinderCounters)) {
                    return new int[]{i3, i};
                } else {
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i2--;
                }
                decodeFinderCounters[i2] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z, int[] iArr) throws NotFoundException {
        int i2;
        int i3;
        boolean z2 = bitArray.get(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && z2 != bitArray.get(i4)) {
            i4--;
        }
        int i5 = i4 + 1;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = iArr[0] - i5;
        int parseFinderValue = parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int i6 = iArr[1];
        if (z) {
            i2 = (bitArray.getSize() - 1) - i6;
            i3 = (bitArray.getSize() - 1) - i5;
        } else {
            i2 = i6;
            i3 = i5;
        }
        return new FinderPattern(parseFinderValue, new int[]{i5, iArr[1]}, i3, i2, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void adjustOddEvenCounts(boolean r10, int r11) throws com.google.zxing.NotFoundException {
        /*
            r9 = this;
            int[] r0 = r9.getOddCounts()
            int r0 = com.google.zxing.common.detector.MathUtils.sum(r0)
            int[] r1 = r9.getEvenCounts()
            int r1 = com.google.zxing.common.detector.MathUtils.sum(r1)
            r2 = 4
            r3 = 0
            r4 = 1
            if (r10 == 0) goto L_0x0034
            r5 = 12
            if (r0 <= r5) goto L_0x001c
            r6 = r3
            r7 = r4
            goto L_0x0023
        L_0x001c:
            if (r0 >= r2) goto L_0x0021
            r7 = r3
            r6 = r4
            goto L_0x0023
        L_0x0021:
            r6 = r3
            r7 = r6
        L_0x0023:
            if (r1 <= r5) goto L_0x0029
            r2 = r3
            r5 = r6
            r6 = r7
            goto L_0x0048
        L_0x0029:
            if (r1 >= r2) goto L_0x0030
            r2 = r4
            r5 = r6
            r6 = r7
            r7 = r3
            goto L_0x0051
        L_0x0030:
            r2 = r3
            r5 = r6
            r6 = r7
            goto L_0x0050
        L_0x0034:
            r5 = 11
            if (r0 <= r5) goto L_0x003b
            r5 = r3
            r6 = r4
            goto L_0x0043
        L_0x003b:
            r5 = 5
            if (r0 >= r5) goto L_0x0041
            r6 = r3
            r5 = r4
            goto L_0x0043
        L_0x0041:
            r5 = r3
            r6 = r5
        L_0x0043:
            r7 = 10
            if (r1 <= r7) goto L_0x004a
            r2 = r3
        L_0x0048:
            r7 = r4
            goto L_0x0051
        L_0x004a:
            if (r1 >= r2) goto L_0x004f
            r7 = r3
            r2 = r4
            goto L_0x0051
        L_0x004f:
            r2 = r3
        L_0x0050:
            r7 = r2
        L_0x0051:
            int r8 = r0 + r1
            int r8 = r8 - r11
            r11 = r0 & 1
            if (r11 != r10) goto L_0x005a
            r10 = r4
            goto L_0x005b
        L_0x005a:
            r10 = r3
        L_0x005b:
            r11 = r1 & 1
            if (r11 != r4) goto L_0x0060
            r3 = r4
        L_0x0060:
            if (r8 != r4) goto L_0x0076
            if (r10 == 0) goto L_0x006d
            if (r3 != 0) goto L_0x0068
            r6 = r4
            goto L_0x00a2
        L_0x0068:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x006d:
            if (r3 == 0) goto L_0x0071
            r7 = r4
            goto L_0x00a2
        L_0x0071:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x0076:
            r11 = -1
            if (r8 != r11) goto L_0x008d
            if (r10 == 0) goto L_0x0084
            if (r3 != 0) goto L_0x007f
            r5 = r4
            goto L_0x00a2
        L_0x007f:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x0084:
            if (r3 == 0) goto L_0x0088
            r2 = r4
            goto L_0x00a2
        L_0x0088:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x008d:
            if (r8 != 0) goto L_0x00ec
            if (r10 == 0) goto L_0x00a0
            if (r3 == 0) goto L_0x009b
            if (r0 >= r1) goto L_0x0098
            r5 = r4
            r7 = r5
            goto L_0x00a2
        L_0x0098:
            r2 = r4
            r6 = r2
            goto L_0x00a2
        L_0x009b:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x00a0:
            if (r3 != 0) goto L_0x00e7
        L_0x00a2:
            if (r5 == 0) goto L_0x00b7
            if (r6 != 0) goto L_0x00b2
            int[] r10 = r9.getOddCounts()
            float[] r11 = r9.getOddRoundingErrors()
            increment(r10, r11)
            goto L_0x00b7
        L_0x00b2:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x00b7:
            if (r6 == 0) goto L_0x00c4
            int[] r10 = r9.getOddCounts()
            float[] r11 = r9.getOddRoundingErrors()
            decrement(r10, r11)
        L_0x00c4:
            if (r2 == 0) goto L_0x00d9
            if (r7 != 0) goto L_0x00d4
            int[] r10 = r9.getEvenCounts()
            float[] r11 = r9.getOddRoundingErrors()
            increment(r10, r11)
            goto L_0x00d9
        L_0x00d4:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x00d9:
            if (r7 == 0) goto L_0x00e6
            int[] r10 = r9.getEvenCounts()
            float[] r11 = r9.getEvenRoundingErrors()
            decrement(r10, r11)
        L_0x00e6:
            return
        L_0x00e7:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x00ec:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.RSS14Reader.adjustOddEvenCounts(boolean, int):void");
    }
}
