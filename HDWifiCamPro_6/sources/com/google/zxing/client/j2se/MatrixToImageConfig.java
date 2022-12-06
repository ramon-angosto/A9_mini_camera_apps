package com.google.zxing.client.j2se;

public final class MatrixToImageConfig {
    public static final int BLACK = -16777216;
    public static final int WHITE = -1;
    private final int offColor;
    private final int onColor;

    private static boolean hasTransparency(int i) {
        return (i & -16777216) != -16777216;
    }

    public MatrixToImageConfig() {
        this(-16777216, -1);
    }

    public MatrixToImageConfig(int i, int i2) {
        this.onColor = i;
        this.offColor = i2;
    }

    public int getPixelOnColor() {
        return this.onColor;
    }

    public int getPixelOffColor() {
        return this.offColor;
    }

    /* access modifiers changed from: package-private */
    public int getBufferedImageColorModel() {
        if (this.onColor == -16777216 && this.offColor == -1) {
            return 12;
        }
        return (hasTransparency(this.onColor) || hasTransparency(this.offColor)) ? 2 : 1;
    }
}
