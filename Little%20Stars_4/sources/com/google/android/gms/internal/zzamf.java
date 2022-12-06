package com.google.android.gms.internal;

public final class zzamf implements Cloneable {
    private static final zzamg zzcac = new zzamg();
    private int mSize;
    private boolean zzcad;
    private int[] zzcae;
    private zzamg[] zzcaf;

    zzamf() {
        this(10);
    }

    zzamf(int i) {
        this.zzcad = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcae = new int[idealIntArraySize];
        this.zzcaf = new zzamg[idealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzcae;
        zzamg[] zzamgArr = this.zzcaf;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzamg zzamg = zzamgArr[i3];
            if (zzamg != zzcac) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzamgArr[i2] = zzamg;
                    zzamgArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzcad = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzamg[] zzamgArr, zzamg[] zzamgArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzamgArr[i2].equals(zzamgArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzom(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzcae[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzamf)) {
            return false;
        }
        zzamf zzamf = (zzamf) obj;
        return size() == zzamf.size() && zza(this.zzcae, zzamf.zzcae, this.mSize) && zza(this.zzcaf, zzamf.zzcaf, this.mSize);
    }

    public int hashCode() {
        if (this.zzcad) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzcae[i2]) * 31) + this.zzcaf[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r3.zzcaf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(int r4) {
        /*
            r3 = this;
            int r4 = r3.zzom(r4)
            if (r4 < 0) goto L_0x0013
            com.google.android.gms.internal.zzamg[] r0 = r3.zzcaf
            r1 = r0[r4]
            com.google.android.gms.internal.zzamg r2 = zzcac
            if (r1 == r2) goto L_0x0013
            r0[r4] = r2
            r4 = 1
            r3.zzcad = r4
        L_0x0013:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamf.remove(int):void");
    }

    /* access modifiers changed from: package-private */
    public int size() {
        if (this.zzcad) {
            gc();
        }
        return this.mSize;
    }

    /* renamed from: zzWV */
    public final zzamf clone() {
        int size = size();
        zzamf zzamf = new zzamf(size);
        System.arraycopy(this.zzcae, 0, zzamf.zzcae, 0, size);
        for (int i = 0; i < size; i++) {
            zzamg[] zzamgArr = this.zzcaf;
            if (zzamgArr[i] != null) {
                zzamf.zzcaf[i] = (zzamg) zzamgArr[i].clone();
            }
        }
        zzamf.mSize = size;
        return zzamf;
    }

    /* access modifiers changed from: package-private */
    public void zza(int i, zzamg zzamg) {
        int zzom = zzom(i);
        if (zzom >= 0) {
            this.zzcaf[zzom] = zzamg;
            return;
        }
        int i2 = zzom ^ -1;
        if (i2 < this.mSize) {
            zzamg[] zzamgArr = this.zzcaf;
            if (zzamgArr[i2] == zzcac) {
                this.zzcae[i2] = i;
                zzamgArr[i2] = zzamg;
                return;
            }
        }
        if (this.zzcad && this.mSize >= this.zzcae.length) {
            gc();
            i2 = zzom(i) ^ -1;
        }
        int i3 = this.mSize;
        if (i3 >= this.zzcae.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            zzamg[] zzamgArr2 = new zzamg[idealIntArraySize];
            int[] iArr2 = this.zzcae;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzamg[] zzamgArr3 = this.zzcaf;
            System.arraycopy(zzamgArr3, 0, zzamgArr2, 0, zzamgArr3.length);
            this.zzcae = iArr;
            this.zzcaf = zzamgArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzcae;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            zzamg[] zzamgArr4 = this.zzcaf;
            System.arraycopy(zzamgArr4, i2, zzamgArr4, i5, this.mSize - i2);
        }
        this.zzcae[i2] = i;
        this.zzcaf[i2] = zzamg;
        this.mSize++;
    }

    /* access modifiers changed from: package-private */
    public zzamg zzok(int i) {
        int zzom = zzom(i);
        if (zzom < 0) {
            return null;
        }
        zzamg[] zzamgArr = this.zzcaf;
        if (zzamgArr[zzom] == zzcac) {
            return null;
        }
        return zzamgArr[zzom];
    }

    /* access modifiers changed from: package-private */
    public zzamg zzol(int i) {
        if (this.zzcad) {
            gc();
        }
        return this.zzcaf[i];
    }
}
