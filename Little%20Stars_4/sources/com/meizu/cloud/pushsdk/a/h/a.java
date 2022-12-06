package com.meizu.cloud.pushsdk.a.h;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class a implements b, c, Cloneable {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    i a;
    long b;

    public a b() {
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public long a() {
        return this.b;
    }

    public boolean c() {
        return this.b == 0;
    }

    public InputStream d() {
        return new InputStream() {
            public void close() {
            }

            public int read() {
                if (a.this.b > 0) {
                    return a.this.f() & 255;
                }
                return -1;
            }

            public int read(byte[] bArr, int i, int i2) {
                return a.this.a(bArr, i, i2);
            }

            public int available() {
                return (int) Math.min(a.this.b, 2147483647L);
            }

            public String toString() {
                return a.this + ".inputStream()";
            }
        };
    }

    public long e() {
        long j = this.b;
        if (j == 0) {
            return 0;
        }
        i iVar = this.a.g;
        return (iVar.c >= 2048 || !iVar.e) ? j : j - ((long) (iVar.c - iVar.b));
    }

    public byte f() {
        if (this.b != 0) {
            i iVar = this.a;
            int i = iVar.b;
            int i2 = iVar.c;
            int i3 = i + 1;
            byte b2 = iVar.a[i];
            this.b--;
            if (i3 == i2) {
                this.a = iVar.a();
                j.a(iVar);
            } else {
                iVar.b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public d g() {
        return new d(i());
    }

    public String h() {
        try {
            return a(this.b, n.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        n.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            i iVar = this.a;
            if (((long) iVar.b) + j > ((long) iVar.c)) {
                return new String(a(j), charset);
            }
            String str = new String(iVar.a, iVar.b, (int) j, charset);
            iVar.b = (int) (((long) iVar.b) + j);
            this.b -= j;
            if (iVar.b == iVar.c) {
                this.a = iVar.a();
                j.a(iVar);
            }
            return str;
        }
    }

    public byte[] i() {
        try {
            return a(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] a(long j) throws EOFException {
        n.a(this.b, 0, j);
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
        n.a((long) bArr.length, (long) i, (long) i2);
        i iVar = this.a;
        if (iVar == null) {
            return -1;
        }
        int min = Math.min(i2, iVar.c - iVar.b);
        System.arraycopy(iVar.a, iVar.b, bArr, i, min);
        iVar.b += min;
        this.b -= (long) min;
        if (iVar.b == iVar.c) {
            this.a = iVar.a();
            j.a(iVar);
        }
        return min;
    }

    public void j() {
        try {
            b(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void b(long j) throws EOFException {
        while (j > 0) {
            i iVar = this.a;
            if (iVar != null) {
                int min = (int) Math.min(j, (long) (iVar.c - this.a.b));
                long j2 = (long) min;
                this.b -= j2;
                j -= j2;
                this.a.b += min;
                if (this.a.b == this.a.c) {
                    i iVar2 = this.a;
                    this.a = iVar2.a();
                    j.a(iVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public a b(d dVar) {
        if (dVar != null) {
            dVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public a b(String str) {
        return a(str, 0, str.length());
    }

    public a a(String str, int i, int i2) {
        char c2;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    i c3 = c(1);
                    byte[] bArr = c3.a;
                    int i3 = c3.c - i;
                    int min = Math.min(i2, 2048 - i3);
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
                        b((charAt >> 6) | 192);
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
                            int i7 = (((charAt & 10239) << 10) | (9215 & c2)) + 0;
                            b((i7 >> 18) | 240);
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
            b((i >> 6) | 192);
            b((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                b((i >> 12) | 224);
                b(((i >> 6) & 63) | 128);
                b((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            b((i >> 18) | 240);
            b(((i >> 12) & 63) | 128);
            b(((i >> 6) & 63) | 128);
            b((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* renamed from: b */
    public a c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public a c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            n.a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                i c2 = c(1);
                int min = Math.min(i3 - i, 2048 - c2.c);
                System.arraycopy(bArr, i, c2.a, c2.c, min);
                i += min;
                c2.c += min;
            }
            this.b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long a(l lVar) throws IOException {
        if (lVar != null) {
            long j = 0;
            while (true) {
                long b2 = lVar.b(this, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
                if (b2 == -1) {
                    return j;
                }
                j += b2;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public a b(int i) {
        i c2 = c(1);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    /* renamed from: c */
    public a e(long j) {
        if (j == 0) {
            return b(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        i c2 = c(i);
        byte[] bArr = c2.a;
        int i2 = c2.c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        c2.c += i;
        this.b += (long) i;
        return this;
    }

    public a d(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        i c2 = c(numberOfTrailingZeros);
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
    public i c(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        i iVar = this.a;
        if (iVar == null) {
            this.a = j.a();
            i iVar2 = this.a;
            iVar2.g = iVar2;
            iVar2.f = iVar2;
            return iVar2;
        }
        i iVar3 = iVar.g;
        return (iVar3.c + i > 2048 || !iVar3.e) ? iVar3.a(j.a()) : iVar3;
    }

    public void a(a aVar, long j) {
        if (aVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (aVar != this) {
            n.a(aVar.b, 0, j);
            while (j > 0) {
                if (j < ((long) (aVar.a.c - aVar.a.b))) {
                    i iVar = this.a;
                    i iVar2 = iVar != null ? iVar.g : null;
                    if (iVar2 != null && iVar2.e) {
                        if ((((long) iVar2.c) + j) - ((long) (iVar2.d ? 0 : iVar2.b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                            aVar.a.a(iVar2, (int) j);
                            aVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    aVar.a = aVar.a.a((int) j);
                }
                i iVar3 = aVar.a;
                long j2 = (long) (iVar3.c - iVar3.b);
                aVar.a = iVar3.a();
                i iVar4 = this.a;
                if (iVar4 == null) {
                    this.a = iVar3;
                    i iVar5 = this.a;
                    iVar5.g = iVar5;
                    iVar5.f = iVar5;
                } else {
                    iVar4.g.a(iVar3).b();
                }
                aVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long b(a aVar, long j) {
        if (aVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            aVar.a(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
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
        i iVar = this.a;
        i iVar2 = aVar.a;
        int i = iVar.b;
        int i2 = iVar2.b;
        while (j2 < this.b) {
            long min = (long) Math.min(iVar.c - i, iVar2.c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (iVar.a[i4] != iVar2.a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == iVar.c) {
                iVar = iVar.f;
                i = iVar.b;
            } else {
                i = i4;
            }
            if (i3 == iVar2.c) {
                iVar2 = iVar2.f;
                i2 = iVar2.b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        i iVar = this.a;
        if (iVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = iVar.c;
            for (int i3 = iVar.b; i3 < i2; i3++) {
                i = (i * 31) + iVar.a[i3];
            }
            iVar = iVar.f;
        } while (iVar != this.a);
        return i;
    }

    public String toString() {
        long j = this.b;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.b), clone().g().c()});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(this.a.a, this.a.b, this.a.c - this.a.b);
            i iVar = this.a;
            while (true) {
                iVar = iVar.f;
                if (iVar != this.a) {
                    instance.update(iVar.a, iVar.b, iVar.c - iVar.b);
                } else {
                    return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.b), d.a(instance.digest()).c()});
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: k */
    public a clone() {
        a aVar = new a();
        if (this.b == 0) {
            return aVar;
        }
        aVar.a = new i(this.a);
        i iVar = aVar.a;
        iVar.g = iVar;
        iVar.f = iVar;
        i iVar2 = this.a;
        while (true) {
            iVar2 = iVar2.f;
            if (iVar2 != this.a) {
                aVar.a.g.a(new i(iVar2));
            } else {
                aVar.b = this.b;
                return aVar;
            }
        }
    }
}
