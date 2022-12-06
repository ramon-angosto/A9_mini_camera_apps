package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzym {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008f, code lost:
        if (r11 != 11) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
        if (r11 != 11) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0099, code lost:
        if (r11 != 8) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzyl zza(com.google.android.gms.internal.ads.zzee r11) {
        /*
            r0 = 16
            int r1 = r11.zzc(r0)
            int r0 = r11.zzc(r0)
            r2 = 4
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L_0x0018
            r0 = 24
            int r0 = r11.zzc(r0)
            r3 = 7
            goto L_0x0019
        L_0x0018:
            r3 = r2
        L_0x0019:
            int r0 = r0 + r3
            r3 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r3) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r7 = r0
            r0 = 2
            int r1 = r11.zzc(r0)
            r3 = 0
            r4 = 3
            if (r1 != r4) goto L_0x003d
            r1 = r3
        L_0x002c:
            int r5 = r11.zzc(r0)
            int r1 = r1 + r5
            boolean r5 = r11.zzl()
            if (r5 != 0) goto L_0x0039
            int r1 = r1 + r4
            goto L_0x003d
        L_0x0039:
            int r1 = r1 + 1
            int r1 = r1 << r0
            goto L_0x002c
        L_0x003d:
            r5 = 10
            int r5 = r11.zzc(r5)
            boolean r6 = r11.zzl()
            if (r6 == 0) goto L_0x0052
            int r6 = r11.zzc(r4)
            if (r6 <= 0) goto L_0x0052
            r11.zzj(r0)
        L_0x0052:
            boolean r6 = r11.zzl()
            r8 = 44100(0xac44, float:6.1797E-41)
            r9 = 48000(0xbb80, float:6.7262E-41)
            r10 = 1
            if (r10 == r6) goto L_0x0061
            r6 = r8
            goto L_0x0062
        L_0x0061:
            r6 = r9
        L_0x0062:
            int r11 = r11.zzc(r2)
            if (r6 != r8) goto L_0x0072
            r8 = 13
            if (r11 != r8) goto L_0x0072
            int[] r11 = zzb
            r11 = r11[r8]
            r8 = r11
            goto L_0x009e
        L_0x0072:
            if (r6 != r9) goto L_0x009d
            r8 = 14
            if (r11 >= r8) goto L_0x009d
            int[] r3 = zzb
            r3 = r3[r11]
            int r5 = r5 % 5
            r8 = 8
            if (r5 == r10) goto L_0x0097
            r9 = 11
            if (r5 == r0) goto L_0x0092
            if (r5 == r4) goto L_0x0097
            if (r5 == r2) goto L_0x008b
            goto L_0x009d
        L_0x008b:
            if (r11 == r4) goto L_0x009b
            if (r11 == r8) goto L_0x009b
            if (r11 != r9) goto L_0x009d
            goto L_0x009b
        L_0x0092:
            if (r11 == r8) goto L_0x009b
            if (r11 != r9) goto L_0x009d
            goto L_0x009b
        L_0x0097:
            if (r11 == r4) goto L_0x009b
            if (r11 != r8) goto L_0x009d
        L_0x009b:
            int r3 = r3 + 1
        L_0x009d:
            r8 = r3
        L_0x009e:
            com.google.android.gms.internal.ads.zzyl r11 = new com.google.android.gms.internal.ads.zzyl
            r5 = 2
            r9 = 0
            r3 = r11
            r4 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzym.zza(com.google.android.gms.internal.ads.zzee):com.google.android.gms.internal.ads.zzyl");
    }

    public static void zzb(int i, zzef zzef) {
        zzef.zzC(7);
        byte[] zzH = zzef.zzH();
        zzH[0] = -84;
        zzH[1] = 64;
        zzH[2] = -1;
        zzH[3] = -1;
        zzH[4] = (byte) ((i >> 16) & 255);
        zzH[5] = (byte) ((i >> 8) & 255);
        zzH[6] = (byte) (i & 255);
    }
}
