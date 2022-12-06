package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import kotlin.UByte;

final class VorbisBitArray {
    private int bitOffset;
    private final int byteLimit;
    private int byteOffset;
    private final byte[] data;

    public VorbisBitArray(byte[] bArr) {
        this.data = bArr;
        this.byteLimit = bArr.length;
    }

    public final void reset() {
        this.byteOffset = 0;
        this.bitOffset = 0;
    }

    public final boolean readBit() {
        boolean z = (((this.data[this.byteOffset] & UByte.MAX_VALUE) >> this.bitOffset) & 1) == 1;
        skipBits(1);
        return z;
    }

    public final int readBits(int i) {
        int i2 = this.byteOffset;
        int min = Math.min(i, 8 - this.bitOffset);
        int i3 = i2 + 1;
        int i4 = ((this.data[i2] & UByte.MAX_VALUE) >> this.bitOffset) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.data[i3] & UByte.MAX_VALUE) << min;
            min += 8;
            i3++;
        }
        int i5 = i4 & (-1 >>> (32 - i));
        skipBits(i);
        return i5;
    }

    public final void skipBits(int i) {
        int i2 = i / 8;
        this.byteOffset += i2;
        this.bitOffset += i - (i2 * 8);
        int i3 = this.bitOffset;
        if (i3 > 7) {
            this.byteOffset++;
            this.bitOffset = i3 - 8;
        }
        assertValidOffset();
    }

    public final int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public final void setPosition(int i) {
        this.byteOffset = i / 8;
        this.bitOffset = i - (this.byteOffset * 8);
        assertValidOffset();
    }

    public final int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.byteLimit;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void assertValidOffset() {
        /*
            r2 = this;
            int r0 = r2.byteOffset
            if (r0 < 0) goto L_0x0010
            int r1 = r2.byteLimit
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.bitOffset
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.VorbisBitArray.assertValidOffset():void");
    }
}
