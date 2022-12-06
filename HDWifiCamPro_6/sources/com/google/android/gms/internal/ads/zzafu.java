package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzafu {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zzzj zzzj) throws IOException {
        return zzc(zzzj, true, false);
    }

    public static boolean zzb(zzzj zzzj, boolean z) throws IOException {
        return zzc(zzzj, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d2, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fe, code lost:
        r8 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzc(com.google.android.gms.internal.ads.zzzj r21, boolean r22, boolean r23) throws java.io.IOException {
        /*
            r0 = r21
            long r1 = r21.zzd()
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 4096(0x1000, double:2.0237E-320)
            if (r5 == 0) goto L_0x0014
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r6 = r1
        L_0x0014:
            int r6 = (int) r6
            com.google.android.gms.internal.ads.zzef r7 = new com.google.android.gms.internal.ads.zzef
            r8 = 64
            r7.<init>((int) r8)
            r8 = 0
            r9 = r6
            r6 = r8
            r10 = r6
        L_0x0020:
            r11 = 1
            if (r6 >= r9) goto L_0x00fe
            r12 = 8
            r7.zzC(r12)
            byte[] r13 = r7.zzH()
            boolean r13 = r0.zzm(r13, r8, r12, r11)
            if (r13 != 0) goto L_0x0034
            goto L_0x00ff
        L_0x0034:
            long r13 = r7.zzs()
            int r15 = r7.zze()
            r16 = 1
            int r16 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            r11 = 16
            if (r16 != 0) goto L_0x0053
            byte[] r13 = r7.zzH()
            r0.zzh(r13, r12, r12)
            r7.zzE(r11)
            long r13 = r7.zzr()
            goto L_0x006c
        L_0x0053:
            r16 = 0
            int r11 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r11 != 0) goto L_0x006b
            long r16 = r21.zzd()
            int r11 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r11 == 0) goto L_0x006b
            long r13 = r21.zze()
            long r16 = r16 - r13
            r13 = 8
            long r13 = r16 + r13
        L_0x006b:
            r11 = r12
        L_0x006c:
            long r3 = (long) r11
            int r18 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r18 >= 0) goto L_0x0072
            return r8
        L_0x0072:
            int r6 = r6 + r11
            r11 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r15 != r11) goto L_0x0085
            int r3 = (int) r13
            int r9 = r9 + r3
            if (r5 == 0) goto L_0x0082
            long r3 = (long) r9
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0082
            int r9 = (int) r1
        L_0x0082:
            r3 = -1
            goto L_0x0020
        L_0x0085:
            r11 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r15 == r11) goto L_0x00fc
            r11 = 1836475768(0x6d766578, float:4.7659988E27)
            if (r15 != r11) goto L_0x0091
            goto L_0x00fc
        L_0x0091:
            r18 = r9
            long r8 = (long) r6
            long r8 = r8 + r13
            long r8 = r8 - r3
            r19 = r13
            r11 = r18
            long r12 = (long) r11
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 < 0) goto L_0x00a0
            goto L_0x00fe
        L_0x00a0:
            long r13 = r19 - r3
            int r3 = (int) r13
            int r6 = r6 + r3
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            if (r15 != r4) goto L_0x00f1
            r4 = 8
            if (r3 >= r4) goto L_0x00af
            r4 = 0
            return r4
        L_0x00af:
            r4 = 0
            r7.zzC(r3)
            byte[] r8 = r7.zzH()
            r0.zzh(r8, r4, r3)
            int r3 = r3 >> 2
            r8 = 0
        L_0x00bd:
            if (r8 >= r3) goto L_0x00ec
            r9 = 1
            if (r8 != r9) goto L_0x00c7
            r9 = 4
            r7.zzG(r9)
            goto L_0x00e9
        L_0x00c7:
            int r9 = r7.zze()
            int r12 = r9 >>> 8
            r13 = 3368816(0x336770, float:4.720717E-39)
            if (r12 != r13) goto L_0x00d4
        L_0x00d2:
            r10 = 1
            goto L_0x00ec
        L_0x00d4:
            r12 = 1751476579(0x68656963, float:4.333464E24)
            if (r9 != r12) goto L_0x00da
            r9 = r12
        L_0x00da:
            int[] r12 = zza
            r13 = 0
        L_0x00dd:
            r14 = 29
            if (r13 >= r14) goto L_0x00e9
            r14 = r12[r13]
            if (r14 != r9) goto L_0x00e6
            goto L_0x00d2
        L_0x00e6:
            int r13 = r13 + 1
            goto L_0x00dd
        L_0x00e9:
            int r8 = r8 + 1
            goto L_0x00bd
        L_0x00ec:
            if (r10 == 0) goto L_0x00ef
            goto L_0x00f6
        L_0x00ef:
            r3 = 0
            return r3
        L_0x00f1:
            if (r3 == 0) goto L_0x00f6
            r0.zzg(r3)
        L_0x00f6:
            r9 = r11
            r3 = -1
            r8 = 0
            goto L_0x0020
        L_0x00fc:
            r8 = 1
            goto L_0x00ff
        L_0x00fe:
            r8 = 0
        L_0x00ff:
            if (r10 == 0) goto L_0x0107
            r0 = r22
            if (r0 != r8) goto L_0x0107
            r0 = 1
            return r0
        L_0x0107:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafu.zzc(com.google.android.gms.internal.ads.zzzj, boolean, boolean):boolean");
    }
}
