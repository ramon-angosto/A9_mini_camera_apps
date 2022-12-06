package com.google.zxing.client.j2se;

import com.google.zxing.LuminanceSource;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public final class BufferedImageLuminanceSource extends LuminanceSource {
    private static final double MINUS_45_IN_RADIANS = -0.7853981633974483d;
    private final BufferedImage image;
    private final int left;
    private final int top;

    public boolean isCropSupported() {
        return true;
    }

    public boolean isRotateSupported() {
        return true;
    }

    public BufferedImageLuminanceSource(BufferedImage bufferedImage) {
        this(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BufferedImageLuminanceSource(java.awt.image.BufferedImage r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            r9 = r21
            r10 = r22
            r11 = r23
            r1 = r24
            r0.<init>(r11, r1)
            int r2 = r20.getType()
            r12 = 10
            if (r2 != r12) goto L_0x001a
            r13 = r20
            r0.image = r13
            goto L_0x003e
        L_0x001a:
            r13 = r20
            int r14 = r20.getWidth()
            int r2 = r20.getHeight()
            int r3 = r9 + r11
            if (r3 > r14) goto L_0x0091
            int r15 = r10 + r1
            if (r15 > r2) goto L_0x0091
            java.awt.image.BufferedImage r1 = new java.awt.image.BufferedImage
            r1.<init>(r14, r2, r12)
            r0.image = r1
            java.awt.image.BufferedImage r1 = r0.image
            java.awt.image.WritableRaster r16 = r1.getRaster()
            int[] r8 = new int[r11]
            r7 = r10
        L_0x003c:
            if (r7 < r15) goto L_0x0043
        L_0x003e:
            r0.left = r9
            r0.top = r10
            return
        L_0x0043:
            r5 = 1
            r17 = 0
            r1 = r20
            r2 = r21
            r3 = r7
            r4 = r23
            r6 = r8
            r18 = r7
            r7 = r17
            r17 = r8
            r8 = r14
            r1.getRGB(r2, r3, r4, r5, r6, r7, r8)
            r1 = 0
        L_0x0059:
            if (r1 < r11) goto L_0x006e
            r5 = 1
            r1 = r16
            r2 = r21
            r3 = r18
            r4 = r23
            r6 = r17
            r1.setPixels(r2, r3, r4, r5, r6)
            int r7 = r18 + 1
            r8 = r17
            goto L_0x003c
        L_0x006e:
            r2 = r17[r1]
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = r3 & r2
            if (r3 != 0) goto L_0x0076
            r2 = -1
        L_0x0076:
            int r3 = r2 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 * 306
            int r4 = r2 >> 8
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 * 601
            int r3 = r3 + r4
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 * 117
            int r3 = r3 + r2
            int r3 = r3 + 512
            int r2 = r3 >> 10
            r17[r1] = r2
            int r1 = r1 + 1
            goto L_0x0059
        L_0x0091:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Crop rectangle does not fit within image data."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.j2se.BufferedImageLuminanceSource.<init>(java.awt.image.BufferedImage, int, int, int, int):void");
    }

    public byte[] getRow(int i, byte[] bArr) {
        if (i < 0 || i >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        this.image.getRaster().getDataElements(this.left, this.top + i, width, 1, bArr);
        return bArr;
    }

    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        byte[] bArr = new byte[(width * height)];
        this.image.getRaster().getDataElements(this.left, this.top, width, height, bArr);
        return bArr;
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new BufferedImageLuminanceSource(this.image, this.left + i, this.top + i2, i3, i4);
    }

    public LuminanceSource rotateCounterClockwise() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        AffineTransform affineTransform = r3;
        AffineTransform affineTransform2 = new AffineTransform(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, (double) width);
        BufferedImage bufferedImage = new BufferedImage(height, width, 10);
        Graphics2D createGraphics = bufferedImage.createGraphics();
        createGraphics.drawImage(this.image, affineTransform, (ImageObserver) null);
        createGraphics.dispose();
        int width2 = getWidth();
        return new BufferedImageLuminanceSource(bufferedImage, this.top, width - (this.left + width2), getHeight(), width2);
    }

    public LuminanceSource rotateCounterClockwise45() {
        int width = getWidth();
        int height = getHeight();
        int i = this.left + (width / 2);
        int i2 = this.top + (height / 2);
        AffineTransform rotateInstance = AffineTransform.getRotateInstance(MINUS_45_IN_RADIANS, (double) i, (double) i2);
        int max = Math.max(this.image.getWidth(), this.image.getHeight());
        BufferedImage bufferedImage = new BufferedImage(max, max, 10);
        Graphics2D createGraphics = bufferedImage.createGraphics();
        createGraphics.drawImage(this.image, rotateInstance, (ImageObserver) null);
        createGraphics.dispose();
        int max2 = Math.max(width, height) / 2;
        int max3 = Math.max(0, i - max2);
        int max4 = Math.max(0, i2 - max2);
        int i3 = max - 1;
        return new BufferedImageLuminanceSource(bufferedImage, max3, max4, Math.min(i3, i + max2) - max3, Math.min(i3, i2 + max2) - max4);
    }
}
