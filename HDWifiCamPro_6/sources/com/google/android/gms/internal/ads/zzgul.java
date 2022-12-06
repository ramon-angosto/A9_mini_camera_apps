package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgul extends zzguk {
    zzgul() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r13[r14] <= -65) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0082, code lost:
        if (r13[r14] <= -65) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r13[r14] <= -65) goto L_0x0087;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(int r12, byte[] r13, int r14, int r15) {
        /*
            r11 = this;
            r0 = -19
            r1 = -62
            r2 = -16
            r3 = 0
            r4 = -96
            r5 = -32
            r6 = -65
            r7 = -1
            if (r12 == 0) goto L_0x0086
            if (r14 < r15) goto L_0x0013
            return r12
        L_0x0013:
            byte r8 = (byte) r12
            if (r8 >= r5) goto L_0x0021
            if (r8 < r1) goto L_0x0020
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x0020
            goto L_0x0087
        L_0x0020:
            return r7
        L_0x0021:
            if (r8 >= r2) goto L_0x004a
            int r12 = r12 >> 8
            int r12 = ~r12
            byte r12 = (byte) r12
            if (r12 != 0) goto L_0x0038
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 >= r15) goto L_0x0033
            r10 = r14
            r14 = r12
            r12 = r10
            goto L_0x0038
        L_0x0033:
            int r12 = com.google.android.gms.internal.ads.zzgun.zzk(r8, r14)
            return r12
        L_0x0038:
            if (r12 > r6) goto L_0x0049
            if (r8 != r5) goto L_0x003e
            if (r12 < r4) goto L_0x0049
        L_0x003e:
            if (r8 != r0) goto L_0x0042
            if (r12 >= r4) goto L_0x0049
        L_0x0042:
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x0049
            goto L_0x0087
        L_0x0049:
            return r7
        L_0x004a:
            int r9 = r12 >> 8
            int r9 = ~r9
            byte r9 = (byte) r9
            if (r9 != 0) goto L_0x005e
            int r12 = r14 + 1
            byte r9 = r13[r14]
            if (r12 >= r15) goto L_0x0059
            r14 = r12
            r12 = r3
            goto L_0x0060
        L_0x0059:
            int r12 = com.google.android.gms.internal.ads.zzgun.zzk(r8, r9)
            return r12
        L_0x005e:
            int r12 = r12 >> 16
        L_0x0060:
            if (r12 != 0) goto L_0x0071
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 >= r15) goto L_0x006c
            r10 = r14
            r14 = r12
            r12 = r10
            goto L_0x0071
        L_0x006c:
            int r12 = com.google.android.gms.internal.ads.zzgun.zzl(r8, r9, r14)
            return r12
        L_0x0071:
            if (r9 > r6) goto L_0x0085
            int r8 = r8 << 28
            int r9 = r9 + 112
            int r8 = r8 + r9
            int r8 = r8 >> 30
            if (r8 != 0) goto L_0x0085
            if (r12 > r6) goto L_0x0085
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            return r7
        L_0x0086:
            r12 = r14
        L_0x0087:
            if (r12 >= r15) goto L_0x0090
            byte r14 = r13[r12]
            if (r14 < 0) goto L_0x0090
            int r12 = r12 + 1
            goto L_0x0087
        L_0x0090:
            if (r12 < r15) goto L_0x0095
        L_0x0092:
            r7 = r3
            goto L_0x00f1
        L_0x0095:
            if (r12 < r15) goto L_0x0098
            goto L_0x0092
        L_0x0098:
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 >= 0) goto L_0x00f2
            if (r12 >= r5) goto L_0x00ad
            if (r14 >= r15) goto L_0x00ab
            if (r12 < r1) goto L_0x00f1
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r6) goto L_0x0095
            goto L_0x00f1
        L_0x00ab:
            r7 = r12
            goto L_0x00f1
        L_0x00ad:
            if (r12 >= r2) goto L_0x00cd
            int r8 = r15 + -1
            if (r14 < r8) goto L_0x00b8
            int r3 = com.google.android.gms.internal.ads.zzgun.zzc(r13, r14, r15)
            goto L_0x0092
        L_0x00b8:
            int r8 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x00f1
            if (r12 != r5) goto L_0x00c2
            if (r14 < r4) goto L_0x00f1
        L_0x00c2:
            if (r12 != r0) goto L_0x00c6
            if (r14 >= r4) goto L_0x00f1
        L_0x00c6:
            int r12 = r8 + 1
            byte r14 = r13[r8]
            if (r14 <= r6) goto L_0x0095
            goto L_0x00f1
        L_0x00cd:
            int r8 = r15 + -2
            if (r14 < r8) goto L_0x00d6
            int r3 = com.google.android.gms.internal.ads.zzgun.zzc(r13, r14, r15)
            goto L_0x0092
        L_0x00d6:
            int r8 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x00f1
            int r12 = r12 << 28
            int r14 = r14 + 112
            int r12 = r12 + r14
            int r12 = r12 >> 30
            if (r12 != 0) goto L_0x00f1
            int r12 = r8 + 1
            byte r14 = r13[r8]
            if (r14 > r6) goto L_0x00f1
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 <= r6) goto L_0x00f2
        L_0x00f1:
            return r7
        L_0x00f2:
            r12 = r14
            goto L_0x0095
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgul.zza(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final String zzb(byte[] bArr, int i, int i2) throws zzgrq {
        int i3;
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (r12 < i4) {
                byte b = bArr[r12];
                if (!zzguj.zzd(b)) {
                    break;
                }
                i = r12 + 1;
                cArr[i3] = (char) b;
                i5 = i3 + 1;
            }
            while (r12 < i4) {
                int i6 = r12 + 1;
                byte b2 = bArr[r12];
                if (zzguj.zzd(b2)) {
                    int i7 = i3 + 1;
                    cArr[i3] = (char) b2;
                    r12 = i6;
                    while (true) {
                        i3 = i7;
                        if (r12 >= i4) {
                            break;
                        }
                        byte b3 = bArr[r12];
                        if (!zzguj.zzd(b3)) {
                            break;
                        }
                        r12++;
                        i7 = i3 + 1;
                        cArr[i3] = (char) b3;
                    }
                } else if (zzguj.zzf(b2)) {
                    if (i6 < i4) {
                        zzguj.zzc(b2, bArr[i6], cArr, i3);
                        r12 = i6 + 1;
                        i3++;
                    } else {
                        throw zzgrq.zzd();
                    }
                } else if (zzguj.zze(b2)) {
                    if (i6 < i4 - 1) {
                        int i8 = i6 + 1;
                        zzguj.zzb(b2, bArr[i6], bArr[i8], cArr, i3);
                        r12 = i8 + 1;
                        i3++;
                    } else {
                        throw zzgrq.zzd();
                    }
                } else if (i6 < i4 - 2) {
                    int i9 = i6 + 1;
                    int i10 = i9 + 1;
                    zzguj.zza(b2, bArr[i6], bArr[i9], bArr[i10], cArr, i3);
                    i3 += 2;
                    r12 = i10 + 1;
                } else {
                    throw zzgrq.zzd();
                }
            }
            return new String(cArr, 0, i3);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }
}
