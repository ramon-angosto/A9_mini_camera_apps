package com.bytedance.sdk.component.b.a.b;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.jvm.internal.CharCompanionObject;

/* compiled from: Buffer */
public final class a implements b, c, Cloneable, ByteChannel {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    e a;
    long b;

    public void close() {
    }

    public void flush() {
    }

    public boolean isOpen() {
        return true;
    }

    public boolean a() {
        return this.b == 0;
    }

    public byte b() {
        if (this.b != 0) {
            e eVar = this.a;
            int i = eVar.b;
            int i2 = eVar.c;
            int i3 = i + 1;
            byte b2 = eVar.a[i];
            this.b--;
            if (i3 == i2) {
                this.a = eVar.b();
                f.a(eVar);
            } else {
                eVar.b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public String c() {
        try {
            return a(this.b, i.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        i.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            e eVar = this.a;
            if (((long) eVar.b) + j > ((long) eVar.c)) {
                return new String(a(j), charset);
            }
            String str = new String(eVar.a, eVar.b, (int) j, charset);
            eVar.b = (int) (((long) eVar.b) + j);
            this.b -= j;
            if (eVar.b == eVar.c) {
                this.a = eVar.b();
                f.a(eVar);
            }
            return str;
        }
    }

    public byte[] a(long j) throws EOFException {
        i.a(this.b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 != -1) {
                i += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        i.a((long) bArr.length, (long) i, (long) i2);
        e eVar = this.a;
        if (eVar == null) {
            return -1;
        }
        int min = Math.min(i2, eVar.c - eVar.b);
        System.arraycopy(eVar.a, eVar.b, bArr, i, min);
        eVar.b += min;
        this.b -= (long) min;
        if (eVar.b == eVar.c) {
            this.a = eVar.b();
            f.a(eVar);
        }
        return min;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        e eVar = this.a;
        if (eVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), eVar.c - eVar.b);
        byteBuffer.put(eVar.a, eVar.b, min);
        eVar.b += min;
        this.b -= (long) min;
        if (eVar.b == eVar.c) {
            this.a = eVar.b();
            f.a(eVar);
        }
        return min;
    }

    public a a(String str) {
        return a(str, 0, str.length());
    }

    public a a(String str, int i, int i2) {
        char c2;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    e c3 = c(1);
                    byte[] bArr = c3.a;
                    int i3 = c3.c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = (i3 + i4) - c3.c;
                    c3.c += i5;
                    this.b += (long) i5;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        b((charAt >> 6) | PsExtractor.AUDIO_STREAM);
                        b((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        b((charAt >> 12) | 224);
                        b(((charAt >> 6) & 63) | 128);
                        b((int) (charAt & '?') | 128);
                    } else {
                        int i6 = i + 1;
                        if (i6 < i2) {
                            c2 = str.charAt(i6);
                        } else {
                            c2 = 0;
                        }
                        if (charAt > 56319 || c2 < 56320 || c2 > 57343) {
                            b(63);
                            i = i6;
                        } else {
                            int i7 = (((charAt & 10239) << 10) | (9215 & c2)) + CharCompanionObject.MIN_VALUE;
                            b((i7 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            b(((i7 >> 12) & 63) | 128);
                            b(((i7 >> 6) & 63) | 128);
                            b((i7 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public a a(int i) {
        if (i < 128) {
            b(i);
        } else if (i < 2048) {
            b((i >> 6) | PsExtractor.AUDIO_STREAM);
            b((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                b((i >> 12) | 224);
                b(((i >> 6) & 63) | 128);
                b((i & 63) | 128);
            } else {
                b(63);
            }
        } else if (i <= 1114111) {
            b((i >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            b(((i >> 12) & 63) | 128);
            b(((i >> 6) & 63) | 128);
            b((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public a a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(i.a)) {
            return a(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return b(bytes, 0, bytes.length);
        }
    }

    public a b(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            i.a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                e c2 = c(1);
                int min = Math.min(i3 - i, 8192 - c2.c);
                System.arraycopy(bArr, i, c2.a, c2.c, min);
                i += min;
                c2.c += min;
            }
            this.b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                e c2 = c(1);
                int min = Math.min(i, 8192 - c2.c);
                byteBuffer.get(c2.a, c2.c, min);
                i -= min;
                c2.c += min;
            }
            this.b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public a b(int i) {
        e c2 = c(1);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    public a b(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        e c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.a;
        int i = c2.c;
        for (int i2 = (c2.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.c += numberOfTrailingZeros;
        this.b += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: package-private */
    public e c(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        e eVar = this.a;
        if (eVar == null) {
            this.a = f.a();
            e eVar2 = this.a;
            eVar2.g = eVar2;
            eVar2.f = eVar2;
            return eVar2;
        }
        e eVar3 = eVar.g;
        return (eVar3.c + i > 8192 || !eVar3.e) ? eVar3.a(f.a()) : eVar3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        long j = this.b;
        if (j != aVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        e eVar = this.a;
        e eVar2 = aVar.a;
        int i = eVar.b;
        int i2 = eVar2.b;
        while (j2 < this.b) {
            long min = (long) Math.min(eVar.c - i, eVar2.c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (eVar.a[i4] != eVar2.a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == eVar.c) {
                eVar = eVar.f;
                i = eVar.b;
            } else {
                i = i4;
            }
            if (i3 == eVar2.c) {
                eVar2 = eVar2.f;
                i2 = eVar2.b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        e eVar = this.a;
        if (eVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = eVar.c;
            for (int i3 = eVar.b; i3 < i2; i3++) {
                i = (i * 31) + eVar.a[i3];
            }
            eVar = eVar.f;
        } while (eVar != this.a);
        return i;
    }

    public String toString() {
        return e().toString();
    }

    /* renamed from: d */
    public a clone() {
        a aVar = new a();
        if (this.b == 0) {
            return aVar;
        }
        aVar.a = this.a.a();
        e eVar = aVar.a;
        eVar.g = eVar;
        eVar.f = eVar;
        e eVar2 = this.a;
        while (true) {
            eVar2 = eVar2.f;
            if (eVar2 != this.a) {
                aVar.a.g.a(eVar2.a());
            } else {
                aVar.b = this.b;
                return aVar;
            }
        }
    }

    public final d e() {
        long j = this.b;
        if (j <= 2147483647L) {
            return d((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    public final d d(int i) {
        if (i == 0) {
            return d.c;
        }
        return new g(this, i);
    }
}
