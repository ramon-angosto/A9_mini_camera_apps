package com.ironsource.sdk.utils;

import com.mbridge.msdk.MBridgeConstans;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class c {
    private static final byte[] d = {ByteCompanionObject.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private a a = new a(this, (byte) 0);
    private a b = new a(this, (byte) 0);
    private int[] c = new int[16];

    class a {
        boolean a;
        int[] b;
        long c;
        byte[] d;

        private a() {
            this.a = true;
            this.b = new int[4];
            this.d = new byte[64];
            a();
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.b;
            iArr[0] = 1732584193;
            iArr[1] = -271733879;
            iArr[2] = -1732584194;
            iArr[3] = 271733878;
            this.c = 0;
        }
    }

    c() {
        this.a.a();
        this.b.a = false;
    }

    private static int a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & i2) | (i4 & (~i2))) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private String a() {
        if (!this.b.a) {
            a aVar = this.b;
            a aVar2 = this.a;
            System.arraycopy(aVar2.d, 0, aVar.d, 0, aVar.d.length);
            System.arraycopy(aVar2.b, 0, aVar.b, 0, aVar.b.length);
            aVar.a = aVar2.a;
            aVar.c = aVar2.c;
            long j = this.b.c;
            int i = (int) ((j >>> 3) & 63);
            a(this.b, d, 0, i < 56 ? 56 - i : 120 - i);
            a(this.b, new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >>> 8) & 255)), (byte) ((int) ((j >>> 16) & 255)), (byte) ((int) ((j >>> 24) & 255)), (byte) ((int) ((j >>> 32) & 255)), (byte) ((int) ((j >>> 40) & 255)), (byte) ((int) ((j >>> 48) & 255)), (byte) ((int) ((j >>> 56) & 255))}, 0, 8);
            this.b.a = true;
        }
        int[] iArr = this.b.b;
        byte[] bArr = new byte[16];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 16; i2 < i4; i4 = 16) {
            bArr[i2] = (byte) (iArr[i3] & 255);
            bArr[i2 + 1] = (byte) ((iArr[i3] >>> 8) & 255);
            bArr[i2 + 2] = (byte) ((iArr[i3] >>> 16) & 255);
            bArr[i2 + 3] = (byte) ((iArr[i3] >>> 24) & 255);
            i3++;
            i2 += 4;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            byte b3 = b2 & UByte.MAX_VALUE;
            if (b3 < 16) {
                stringBuffer.append(MBridgeConstans.ENDCARD_URL_TYPE_PL);
            }
            stringBuffer.append(Integer.toHexString(b3));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        c cVar = new c();
        byte[] bytes = str.getBytes();
        cVar.a(cVar.a, bytes, 0, bytes.length);
        return cVar.a();
    }

    private void a(a aVar, byte[] bArr, int i, int i2) {
        int i3 = 0;
        this.b.a = false;
        if (i2 + i > bArr.length) {
            i2 = bArr.length - i;
        }
        int i4 = ((int) (aVar.c >>> 3)) & 63;
        aVar.c += (long) (i2 << 3);
        int i5 = 64 - i4;
        if (i2 >= i5) {
            System.arraycopy(bArr, i, aVar.d, i4, i5);
            a(aVar, a(aVar.d, 64, 0));
            while (i5 + 63 < i2) {
                a(aVar, a(bArr, 64, i5));
                i5 += 64;
            }
            i4 = 0;
            i3 = i5;
        }
        if (i3 < i2) {
            for (int i6 = i3; i6 < i2; i6++) {
                aVar.d[(i4 + i6) - i3] = bArr[i6 + i];
            }
        }
    }

    private static void a(a aVar, int[] iArr) {
        a aVar2 = aVar;
        int i = aVar2.b[0];
        int i2 = aVar2.b[1];
        int i3 = aVar2.b[2];
        int i4 = aVar2.b[3];
        int a2 = a(i, i2, i3, i4, iArr[0], 7, -680876936);
        int a3 = a(i4, a2, i2, i3, iArr[1], 12, -389564586);
        int a4 = a(i3, a3, a2, i2, iArr[2], 17, 606105819);
        int a5 = a(i2, a4, a3, a2, iArr[3], 22, -1044525330);
        int a6 = a(a2, a5, a4, a3, iArr[4], 7, -176418897);
        int a7 = a(a3, a6, a5, a4, iArr[5], 12, 1200080426);
        int a8 = a(a4, a7, a6, a5, iArr[6], 17, -1473231341);
        int a9 = a(a5, a8, a7, a6, iArr[7], 22, -45705983);
        int a10 = a(a6, a9, a8, a7, iArr[8], 7, 1770035416);
        int i5 = a10;
        int a11 = a(a7, i5, a9, a8, iArr[9], 12, -1958414417);
        int a12 = a(a8, a11, a10, a9, iArr[10], 17, -42063);
        int a13 = a(a9, a12, a11, a10, iArr[11], 22, -1990404162);
        int a14 = a(i5, a13, a12, a11, iArr[12], 7, 1804603682);
        int i6 = a14;
        int a15 = a(a11, i6, a13, a12, iArr[13], 12, -40341101);
        int a16 = a(a12, a15, a14, a13, iArr[14], 17, -1502002290);
        int a17 = a(a13, a16, a15, a14, iArr[15], 22, 1236535329);
        int b2 = b(i6, a17, a16, a15, iArr[1], 5, -165796510);
        int b3 = b(a15, b2, a17, a16, iArr[6], 9, -1069501632);
        int b4 = b(a16, b3, b2, a17, iArr[11], 14, 643717713);
        int b5 = b(a17, b4, b3, b2, iArr[0], 20, -373897302);
        int b6 = b(b2, b5, b4, b3, iArr[5], 5, -701558691);
        int b7 = b(b3, b6, b5, b4, iArr[10], 9, 38016083);
        int b8 = b(b4, b7, b6, b5, iArr[15], 14, -660478335);
        int b9 = b(b5, b8, b7, b6, iArr[4], 20, -405537848);
        int b10 = b(b6, b9, b8, b7, iArr[9], 5, 568446438);
        int i7 = b10;
        int b11 = b(b7, i7, b9, b8, iArr[14], 9, -1019803690);
        int b12 = b(b8, b11, b10, b9, iArr[3], 14, -187363961);
        int b13 = b(b9, b12, b11, b10, iArr[8], 20, 1163531501);
        int b14 = b(i7, b13, b12, b11, iArr[13], 5, -1444681467);
        int i8 = b14;
        int b15 = b(b11, i8, b13, b12, iArr[2], 9, -51403784);
        int b16 = b(b12, b15, b14, b13, iArr[7], 14, 1735328473);
        int b17 = b(b13, b16, b15, b14, iArr[12], 20, -1926607734);
        int c2 = c(i8, b17, b16, b15, iArr[5], 4, -378558);
        int c3 = c(b15, c2, b17, b16, iArr[8], 11, -2022574463);
        int c4 = c(b16, c3, c2, b17, iArr[11], 16, 1839030562);
        int c5 = c(b17, c4, c3, c2, iArr[14], 23, -35309556);
        int c6 = c(c2, c5, c4, c3, iArr[1], 4, -1530992060);
        int c7 = c(c3, c6, c5, c4, iArr[4], 11, 1272893353);
        int c8 = c(c4, c7, c6, c5, iArr[7], 16, -155497632);
        int c9 = c(c5, c8, c7, c6, iArr[10], 23, -1094730640);
        int c10 = c(c6, c9, c8, c7, iArr[13], 4, 681279174);
        int i9 = c10;
        int c11 = c(c7, i9, c9, c8, iArr[0], 11, -358537222);
        int c12 = c(c8, c11, c10, c9, iArr[3], 16, -722521979);
        int c13 = c(c9, c12, c11, c10, iArr[6], 23, 76029189);
        int c14 = c(i9, c13, c12, c11, iArr[9], 4, -640364487);
        int i10 = c14;
        int c15 = c(c11, i10, c13, c12, iArr[12], 11, -421815835);
        int c16 = c(c12, c15, c14, c13, iArr[15], 16, 530742520);
        int c17 = c(c13, c16, c15, c14, iArr[2], 23, -995338651);
        int d2 = d(i10, c17, c16, c15, iArr[0], 6, -198630844);
        int d3 = d(c15, d2, c17, c16, iArr[7], 10, 1126891415);
        int d4 = d(c16, d3, d2, c17, iArr[14], 15, -1416354905);
        int d5 = d(c17, d4, d3, d2, iArr[5], 21, -57434055);
        int d6 = d(d2, d5, d4, d3, iArr[12], 6, 1700485571);
        int d7 = d(d3, d6, d5, d4, iArr[3], 10, -1894986606);
        int d8 = d(d4, d7, d6, d5, iArr[10], 15, -1051523);
        int d9 = d(d5, d8, d7, d6, iArr[1], 21, -2054922799);
        int d10 = d(d6, d9, d8, d7, iArr[8], 6, 1873313359);
        int i11 = d10;
        int d11 = d(d7, i11, d9, d8, iArr[15], 10, -30611744);
        int d12 = d(d8, d11, d10, d9, iArr[6], 15, -1560198380);
        int d13 = d(d9, d12, d11, d10, iArr[13], 21, 1309151649);
        int d14 = d(i11, d13, d12, d11, iArr[4], 6, -145523070);
        int d15 = d(d11, d14, d13, d12, iArr[11], 10, -1120210379);
        int d16 = d(d12, d15, d14, d13, iArr[2], 15, 718787259);
        int d17 = d(d13, d16, d15, d14, iArr[9], 21, -343485551);
        int[] iArr2 = aVar2.b;
        iArr2[0] = iArr2[0] + d14;
        int[] iArr3 = aVar2.b;
        iArr3[1] = iArr3[1] + d17;
        int[] iArr4 = aVar2.b;
        iArr4[2] = iArr4[2] + d16;
        int[] iArr5 = aVar2.b;
        iArr5[3] = iArr5[3] + d15;
    }

    private int[] a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < 64; i4 += 4) {
            this.c[i3] = (bArr[i4 + i2] & UByte.MAX_VALUE) | ((bArr[(i4 + 1) + i2] & UByte.MAX_VALUE) << 8) | ((bArr[(i4 + 2) + i2] & UByte.MAX_VALUE) << 16) | ((bArr[(i4 + 3) + i2] & UByte.MAX_VALUE) << 24);
            i3++;
        }
        return this.c;
    }

    private static int b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & (~i4)) | (i2 & i4)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 ^ i2) ^ i4) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int d(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + (i3 ^ ((~i4) | i2)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    public final String toString() {
        return a();
    }
}
