package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzmy extends zzmx {
    zzmy() {
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, byte[] bArr, int i2, int i3) {
        while (r9 < i3 && bArr[r9] >= 0) {
            i2 = r9 + 1;
        }
        int i4 = 0;
        if (r9 < i3) {
            while (true) {
                if (r9 >= i3) {
                    break;
                }
                int i5 = r9 + 1;
                byte b = bArr[r9];
                if (b < 0) {
                    if (b < -32) {
                        if (i5 >= i3) {
                            return b;
                        }
                        if (b < -62) {
                            return -1;
                        }
                        r9 = i5 + 1;
                        if (bArr[i5] > -65) {
                            return -1;
                        }
                    } else if (b < -16) {
                        if (i5 >= i3 - 1) {
                            i4 = zzna.zza(bArr, i5, i3);
                            break;
                        }
                        int i6 = i5 + 1;
                        byte b2 = bArr[i5];
                        if (b2 > -65) {
                            return -1;
                        }
                        if (b == -32 && b2 < -96) {
                            return -1;
                        }
                        if (b == -19 && b2 >= -96) {
                            return -1;
                        }
                        r9 = i6 + 1;
                        if (bArr[i6] > -65) {
                            return -1;
                        }
                    } else if (i5 >= i3 - 2) {
                        i4 = zzna.zza(bArr, i5, i3);
                        break;
                    } else {
                        int i7 = i5 + 1;
                        byte b3 = bArr[i5];
                        if (b3 > -65 || (((b << 28) + (b3 + 112)) >> 30) != 0) {
                            return -1;
                        }
                        int i8 = i7 + 1;
                        if (bArr[i7] > -65) {
                            return -1;
                        }
                        i5 = i8 + 1;
                        if (bArr[i8] > -65) {
                            return -1;
                        }
                    }
                }
                r9 = i5;
            }
        }
        return i4;
    }
}
