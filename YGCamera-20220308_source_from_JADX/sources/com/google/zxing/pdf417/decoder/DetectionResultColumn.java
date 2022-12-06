package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    DetectionResultColumn(BoundingBox boundingBox2) {
        this.boundingBox = new BoundingBox(boundingBox2);
        this.codewords = new Codeword[((boundingBox2.getMaxY() - boundingBox2.getMinY()) + 1)];
    }

    /* access modifiers changed from: package-private */
    public final Codeword getCodewordNearby(int i) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = getCodeword(i);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int imageRowToCodewordIndex = imageRowToCodewordIndex(i) - i2;
            if (imageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[imageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int imageRowToCodewordIndex2 = imageRowToCodewordIndex(i) + i2;
            Codeword[] codewordArr = this.codewords;
            if (imageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[imageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final int imageRowToCodewordIndex(int i) {
        return i - this.boundingBox.getMinY();
    }

    /* access modifiers changed from: package-private */
    public final void setCodeword(int i, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i)] = codeword;
    }

    /* access modifiers changed from: package-private */
    public final Codeword getCodeword(int i) {
        return this.codewords[imageRowToCodewordIndex(i)];
    }

    /* access modifiers changed from: package-private */
    public final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    /* access modifiers changed from: package-private */
    public final Codeword[] getCodewords() {
        return this.codewords;
    }

    public String toString() {
        Formatter formatter;
        Throwable th = null;
        try {
            formatter = new Formatter();
            int i = 0;
            for (Codeword codeword : this.codewords) {
                if (codeword == null) {
                    formatter.format("%3d:    |   %n", new Object[]{Integer.valueOf(i)});
                    i++;
                } else {
                    int i2 = i + 1;
                    formatter.format("%3d: %3d|%3d%n", new Object[]{Integer.valueOf(i), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue())});
                    i = i2;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            } else if (th != th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
