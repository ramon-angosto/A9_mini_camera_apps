package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzy {
    public final List zza;
    public final int zzb;
    public final float zzc;
    public final String zzd;

    private zzzy(List list, int i, int i2, int i3, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = f;
        this.zzd = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:177:0x0383 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x038c A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03a1 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03b0 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0124 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0126 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzzy zza(com.google.android.gms.internal.ads.zzef r42) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r0 = r42
            r1 = 21
            r0.zzG(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r1 = r42.zzk()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r2 = 3
            r1 = r1 & r2
            int r3 = r42.zzk()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r4 = r42.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r5 = 0
            r6 = r5
            r7 = r6
        L_0x0018:
            r8 = 1
            if (r6 >= r3) goto L_0x0037
            r0.zzG(r8)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r8 = r42.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r9 = r7
            r7 = r5
        L_0x0024:
            if (r7 >= r8) goto L_0x0033
            int r10 = r42.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r11 = r10 + 4
            int r9 = r9 + r11
            r0.zzG(r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r7 = r7 + 1
            goto L_0x0024
        L_0x0033:
            int r6 = r6 + 1
            r7 = r9
            goto L_0x0018
        L_0x0037:
            r0.zzF(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            byte[] r4 = new byte[r7]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r6 = 0
            r11 = r5
            r17 = r6
            r14 = -1
            r15 = -1
            r16 = 1065353216(0x3f800000, float:1.0)
            r6 = r11
        L_0x0045:
            if (r6 >= r3) goto L_0x03f6
            int r12 = r42.zzk()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r12 = r12 & 63
            int r13 = r42.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r9 = r11
            r11 = r5
        L_0x0053:
            if (r11 >= r13) goto L_0x03e6
            int r10 = r42.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            byte[] r8 = com.google.android.gms.internal.ads.zzaaf.zza     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r2 = 4
            java.lang.System.arraycopy(r8, r5, r4, r9, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r9 = r9 + 4
            byte[] r8 = r42.zzH()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r5 = r42.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            java.lang.System.arraycopy(r8, r5, r4, r9, r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r5 = 33
            if (r12 != r5) goto L_0x03c3
            if (r11 != 0) goto L_0x03c3
            int r5 = r9 + r10
            int r8 = r9 + 2
            com.google.android.gms.internal.ads.zzaah r11 = new com.google.android.gms.internal.ads.zzaah     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.<init>(r4, r8, r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r5 = 3
            int r8 = r11.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r5 = 2
            int r20 = r11.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            boolean r21 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r14 = 5
            int r22 = r11.zza(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r15 = 0
            r23 = 0
        L_0x0097:
            r14 = 32
            if (r15 >= r14) goto L_0x00ab
            boolean r14 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r14 == 0) goto L_0x00a8
            r14 = 1
            int r17 = r14 << r15
            r14 = r23 | r17
            r23 = r14
        L_0x00a8:
            int r15 = r15 + 1
            goto L_0x0097
        L_0x00ab:
            r14 = 6
            int[] r15 = new int[r14]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r2 = 0
        L_0x00af:
            r5 = 8
            if (r2 >= r14) goto L_0x00bc
            int r5 = r11.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r15[r2] = r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r2 = r2 + 1
            goto L_0x00af
        L_0x00bc:
            int r25 = r11.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r2 = 0
            r14 = 0
        L_0x00c2:
            if (r2 >= r8) goto L_0x00d7
            boolean r27 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r27 == 0) goto L_0x00cc
            int r14 = r14 + 89
        L_0x00cc:
            boolean r27 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r27 == 0) goto L_0x00d4
            int r14 = r14 + 8
        L_0x00d4:
            int r2 = r2 + 1
            goto L_0x00c2
        L_0x00d7:
            r11.zze(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r8 <= 0) goto L_0x00e2
            int r2 = 8 - r8
            int r2 = r2 + r2
            r11.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
        L_0x00e2:
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r2 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r14 = 3
            if (r2 != r14) goto L_0x00f0
            r11.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r2 = 3
        L_0x00f0:
            int r14 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r27 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            boolean r28 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r28 == 0) goto L_0x0133
            int r28 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r29 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r30 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r31 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r5 = 1
            if (r2 == r5) goto L_0x011e
            r5 = 2
            if (r2 != r5) goto L_0x0119
            r32 = r3
            r2 = 2
            r3 = 1
            goto L_0x0121
        L_0x0119:
            r32 = r3
            r3 = 1
            r5 = 1
            goto L_0x0122
        L_0x011e:
            r32 = r3
            r3 = r5
        L_0x0121:
            r5 = 2
        L_0x0122:
            if (r2 != r3) goto L_0x0126
            r2 = 2
            goto L_0x0127
        L_0x0126:
            r2 = 1
        L_0x0127:
            int r28 = r28 + r29
            int r5 = r5 * r28
            int r14 = r14 - r5
            int r30 = r30 + r31
            int r2 = r2 * r30
            int r27 = r27 - r2
            goto L_0x0135
        L_0x0133:
            r32 = r3
        L_0x0135:
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r2 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            boolean r3 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r5 = 1
            if (r5 == r3) goto L_0x0148
            r3 = r8
            goto L_0x0149
        L_0x0148:
            r3 = 0
        L_0x0149:
            if (r3 > r8) goto L_0x0157
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r3 = r3 + 1
            goto L_0x0149
        L_0x0157:
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            boolean r3 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r3 == 0) goto L_0x01c0
            boolean r3 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r3 == 0) goto L_0x01c0
            r3 = 0
        L_0x0176:
            r5 = 4
            if (r3 >= r5) goto L_0x01c0
            r5 = 0
        L_0x017a:
            r8 = 6
            if (r5 >= r8) goto L_0x01b8
            boolean r26 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r26 != 0) goto L_0x018c
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r29 = r12
            r30 = r13
        L_0x018a:
            r8 = 3
            goto L_0x01ad
        L_0x018c:
            r8 = 64
            int r28 = r3 + r3
            r24 = 4
            int r28 = r28 + 4
            r29 = r12
            r30 = r13
            r12 = 1
            int r13 = r12 << r28
            int r8 = java.lang.Math.min(r8, r13)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r3 <= r12) goto L_0x01a4
            r11.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
        L_0x01a4:
            r12 = 0
        L_0x01a5:
            if (r12 >= r8) goto L_0x018a
            r11.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r12 = r12 + 1
            goto L_0x01a5
        L_0x01ad:
            if (r3 != r8) goto L_0x01b1
            r12 = r8
            goto L_0x01b2
        L_0x01b1:
            r12 = 1
        L_0x01b2:
            int r5 = r5 + r12
            r12 = r29
            r13 = r30
            goto L_0x017a
        L_0x01b8:
            r29 = r12
            r30 = r13
            r8 = 3
            int r3 = r3 + 1
            goto L_0x0176
        L_0x01c0:
            r29 = r12
            r30 = r13
            r8 = 3
            r3 = 2
            r11.zze(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            boolean r3 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r3 == 0) goto L_0x01dd
            r3 = 8
            r11.zze(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
        L_0x01dd:
            int r3 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r5 = 0
            int[] r12 = new int[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int[] r13 = new int[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r26 = r12
            r19 = r13
            r13 = -1
            r12 = r5
            r5 = -1
        L_0x01ed:
            if (r12 >= r3) goto L_0x0311
            if (r12 == 0) goto L_0x02c4
            boolean r28 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r28 == 0) goto L_0x02c4
            int r8 = r13 + r5
            boolean r31 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r33 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r31 = r31 + r31
            r18 = 1
            int r31 = 1 - r31
            int r33 = r33 + 1
            int r31 = r31 * r33
            r33 = r3
            int r3 = r8 + 1
            r34 = r14
            boolean[] r14 = new boolean[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r35 = r1
            r1 = 0
        L_0x0216:
            if (r1 > r8) goto L_0x022c
            boolean r36 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r36 != 0) goto L_0x0225
            boolean r36 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r14[r1] = r36     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            goto L_0x0229
        L_0x0225:
            r18 = 1
            r14[r1] = r18     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
        L_0x0229:
            int r1 = r1 + 1
            goto L_0x0216
        L_0x022c:
            int[] r1 = new int[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int[] r3 = new int[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r36 = r5 + -1
            r37 = 0
        L_0x0234:
            if (r36 < 0) goto L_0x024b
            r38 = r19[r36]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r38 = r38 + r31
            if (r38 >= 0) goto L_0x0248
            int r39 = r13 + r36
            boolean r39 = r14[r39]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r39 == 0) goto L_0x0248
            int r39 = r37 + 1
            r1[r37] = r38     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r37 = r39
        L_0x0248:
            int r36 = r36 + -1
            goto L_0x0234
        L_0x024b:
            if (r31 >= 0) goto L_0x0256
            boolean r36 = r14[r8]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r36 == 0) goto L_0x0256
            int r36 = r37 + 1
            r1[r37] = r31     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            goto L_0x0258
        L_0x0256:
            r36 = r37
        L_0x0258:
            r37 = r4
            r4 = 0
            r41 = r36
            r36 = r7
            r7 = r41
        L_0x0261:
            if (r4 >= r13) goto L_0x0276
            r38 = r26[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r38 = r38 + r31
            if (r38 >= 0) goto L_0x0273
            boolean r39 = r14[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r39 == 0) goto L_0x0273
            int r39 = r7 + 1
            r1[r7] = r38     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r7 = r39
        L_0x0273:
            int r4 = r4 + 1
            goto L_0x0261
        L_0x0276:
            int[] r1 = java.util.Arrays.copyOf(r1, r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r4 = r13 + -1
            r38 = 0
        L_0x027e:
            if (r4 < 0) goto L_0x0293
            r39 = r26[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r39 = r39 + r31
            if (r39 <= 0) goto L_0x0290
            boolean r40 = r14[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r40 == 0) goto L_0x0290
            int r40 = r38 + 1
            r3[r38] = r39     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r38 = r40
        L_0x0290:
            int r4 = r4 + -1
            goto L_0x027e
        L_0x0293:
            if (r31 <= 0) goto L_0x029e
            boolean r4 = r14[r8]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r4 == 0) goto L_0x029e
            int r4 = r38 + 1
            r3[r38] = r31     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            goto L_0x02a0
        L_0x029e:
            r4 = r38
        L_0x02a0:
            r8 = r4
            r4 = 0
        L_0x02a2:
            if (r4 >= r5) goto L_0x02b9
            r26 = r19[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r26 = r26 + r31
            if (r26 <= 0) goto L_0x02b6
            int r38 = r13 + r4
            boolean r38 = r14[r38]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r38 == 0) goto L_0x02b6
            int r38 = r8 + 1
            r3[r8] = r26     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r8 = r38
        L_0x02b6:
            int r4 = r4 + 1
            goto L_0x02a2
        L_0x02b9:
            int[] r3 = java.util.Arrays.copyOf(r3, r8)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r26 = r1
            r19 = r3
            r13 = r7
            r5 = r8
            goto L_0x0302
        L_0x02c4:
            r35 = r1
            r33 = r3
            r37 = r4
            r36 = r7
            r34 = r14
            int r1 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r3 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int[] r4 = new int[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r5 = 0
        L_0x02d9:
            if (r5 >= r1) goto L_0x02e9
            int r7 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r8 = 1
            int r7 = r7 + r8
            r4[r5] = r7     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r5 = r5 + 1
            goto L_0x02d9
        L_0x02e9:
            int[] r5 = new int[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r7 = 0
        L_0x02ec:
            if (r7 >= r3) goto L_0x02fc
            int r8 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r13 = 1
            int r8 = r8 + r13
            r5[r7] = r8     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r7 = r7 + 1
            goto L_0x02ec
        L_0x02fc:
            r13 = r1
            r26 = r4
            r19 = r5
            r5 = r3
        L_0x0302:
            int r12 = r12 + 1
            r3 = r33
            r14 = r34
            r1 = r35
            r7 = r36
            r4 = r37
            r8 = 3
            goto L_0x01ed
        L_0x0311:
            r35 = r1
            r37 = r4
            r36 = r7
            r34 = r14
            boolean r1 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r1 == 0) goto L_0x032f
            r1 = 0
        L_0x0320:
            int r3 = r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r1 >= r3) goto L_0x032f
            r3 = 5
            int r14 = r2 + 5
            r11.zze(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r1 = r1 + 1
            goto L_0x0320
        L_0x032f:
            r1 = 2
            r11.zze(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            boolean r1 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r1 == 0) goto L_0x03b5
            boolean r1 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r1 == 0) goto L_0x037b
            r1 = 8
            int r1 = r11.zza(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r2 = 255(0xff, float:3.57E-43)
            if (r1 != r2) goto L_0x035c
            r1 = 16
            int r2 = r11.zza(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            int r1 = r11.zza(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r2 == 0) goto L_0x037b
            if (r1 == 0) goto L_0x037b
            float r2 = (float) r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            float r1 = (float) r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            float r2 = r2 / r1
            r1 = r2
            goto L_0x037d
        L_0x035c:
            r2 = 17
            if (r1 >= r2) goto L_0x0365
            float[] r2 = com.google.android.gms.internal.ads.zzaaf.zzb     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r1 = r2[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            goto L_0x037d
        L_0x0365:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r2.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            java.lang.String r3 = "Unexpected aspect_ratio_idc value: "
            r2.append(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r2.append(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            java.lang.String r1 = "NalUnitUtil"
            java.lang.String r2 = r2.toString()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            com.google.android.gms.internal.ads.zzdw.zze(r1, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
        L_0x037b:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x037d:
            boolean r2 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r2 == 0) goto L_0x0386
            r11.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
        L_0x0386:
            boolean r2 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r2 == 0) goto L_0x039b
            r2 = 4
            r11.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            boolean r2 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r2 == 0) goto L_0x039b
            r2 = 24
            r11.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
        L_0x039b:
            boolean r2 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r2 == 0) goto L_0x03a7
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r11.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
        L_0x03a7:
            r11.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            boolean r2 = r11.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            if (r2 == 0) goto L_0x03b2
            int r27 = r27 + r27
        L_0x03b2:
            r16 = r1
            goto L_0x03b7
        L_0x03b5:
            r16 = 1065353216(0x3f800000, float:1.0)
        L_0x03b7:
            r24 = r15
            java.lang.String r17 = com.google.android.gms.internal.ads.zzdf.zzb(r20, r21, r22, r23, r24, r25)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r15 = r27
            r14 = r34
            r11 = 0
            goto L_0x03cf
        L_0x03c3:
            r35 = r1
            r32 = r3
            r37 = r4
            r36 = r7
            r29 = r12
            r30 = r13
        L_0x03cf:
            int r9 = r9 + r10
            r0.zzG(r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r1 = 1
            int r11 = r11 + r1
            r8 = r1
            r12 = r29
            r13 = r30
            r3 = r32
            r1 = r35
            r7 = r36
            r4 = r37
            r2 = 3
            r5 = 0
            goto L_0x0053
        L_0x03e6:
            r35 = r1
            r32 = r3
            r37 = r4
            r36 = r7
            int r6 = r6 + 1
            r11 = r9
            r2 = 3
            r5 = 0
            r8 = 1
            goto L_0x0045
        L_0x03f6:
            r35 = r1
            r37 = r4
            r36 = r7
            if (r36 != 0) goto L_0x0403
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            goto L_0x0407
        L_0x0403:
            java.util.List r0 = java.util.Collections.singletonList(r37)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
        L_0x0407:
            r12 = r0
            com.google.android.gms.internal.ads.zzzy r0 = new com.google.android.gms.internal.ads.zzzy     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            r1 = 1
            int r13 = r35 + 1
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0412 }
            return r0
        L_0x0412:
            r0 = move-exception
            java.lang.String r1 = "Error parsing HEVC config"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r1, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzy.zza(com.google.android.gms.internal.ads.zzef):com.google.android.gms.internal.ads.zzzy");
    }
}
