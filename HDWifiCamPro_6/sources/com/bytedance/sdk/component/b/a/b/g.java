package com.bytedance.sdk.component.b.a.b;

import java.util.Arrays;

/* compiled from: SegmentedByteString */
final class g extends d {
    final transient byte[][] g;
    final transient int[] h;

    g(a aVar, int i) {
        super((byte[]) null);
        i.a(aVar.b, 0, (long) i);
        int i2 = 0;
        e eVar = aVar.a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (eVar.c != eVar.b) {
                i3 += eVar.c - eVar.b;
                i4++;
                eVar = eVar.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.g = new byte[i4][];
        this.h = new int[(i4 * 2)];
        e eVar2 = aVar.a;
        int i5 = 0;
        while (i2 < i) {
            this.g[i5] = eVar2.a;
            i2 += eVar2.c - eVar2.b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.h;
            iArr[i5] = i2;
            iArr[this.g.length + i5] = eVar2.b;
            eVar2.d = true;
            i5++;
            eVar2 = eVar2.f;
        }
    }

    public String a() {
        return e().a();
    }

    public String b() {
        return e().b();
    }

    public d a(int i, int i2) {
        return e().a(i, i2);
    }

    public byte a(int i) {
        int i2;
        i.a((long) this.h[this.g.length - 1], (long) i, 1);
        int b = b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.h[b - 1];
        }
        int[] iArr = this.h;
        byte[][] bArr = this.g;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.h, 0, this.g.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public int c() {
        return this.h[this.g.length - 1];
    }

    public byte[] d() {
        int[] iArr = this.h;
        byte[][] bArr = this.g;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.h;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.g[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    public boolean a(int i, d dVar, int i2, int i3) {
        int i4;
        if (i < 0 || i > c() - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.h[b - 1];
            }
            int min = Math.min(i3, ((this.h[b] - i4) + i4) - i);
            int[] iArr = this.h;
            byte[][] bArr = this.g;
            if (!dVar.a(i2, bArr[b], (i - i4) + iArr[bArr.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.h[b - 1];
            }
            int min = Math.min(i3, ((this.h[b] - i4) + i4) - i);
            int[] iArr = this.h;
            byte[][] bArr2 = this.g;
            if (!i.a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    private d e() {
        return new d(d());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.c() == c() && a(0, dVar, 0, c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.e;
        if (i != 0) {
            return i;
        }
        int length = this.g.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.g[i2];
            int[] iArr = this.h;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.e = i3;
        return i3;
    }

    public String toString() {
        return e().toString();
    }
}
