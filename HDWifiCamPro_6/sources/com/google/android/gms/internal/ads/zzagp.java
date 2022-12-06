package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzagp extends zzagn {
    private zzago zza;
    private int zzb;
    private boolean zzc;
    private zzaau zzd;
    private zzaas zze;

    zzagp() {
    }

    /* access modifiers changed from: protected */
    public final long zza(zzef zzef) {
        int i;
        int i2 = 0;
        if ((zzef.zzH()[0] & 1) == 1) {
            return -1;
        }
        byte b = zzef.zzH()[0];
        zzago zzago = this.zza;
        zzdd.zzb(zzago);
        if (!zzago.zzd[(b >> 1) & (255 >>> (8 - zzago.zze))].zza) {
            i = zzago.zza.zze;
        } else {
            i = zzago.zza.zzf;
        }
        if (this.zzc) {
            i2 = (this.zzb + i) / 4;
        }
        long j = (long) i2;
        if (zzef.zzb() < zzef.zzd() + 4) {
            byte[] copyOf = Arrays.copyOf(zzef.zzH(), zzef.zzd() + 4);
            zzef.zzD(copyOf, copyOf.length);
        } else {
            zzef.zzE(zzef.zzd() + 4);
        }
        byte[] zzH = zzef.zzH();
        zzH[zzef.zzd() - 4] = (byte) ((int) (j & 255));
        zzH[zzef.zzd() - 3] = (byte) ((int) ((j >>> 8) & 255));
        zzH[zzef.zzd() - 2] = (byte) ((int) ((j >>> 16) & 255));
        zzH[zzef.zzd() - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    /* access modifiers changed from: protected */
    public final void zzi(long j) {
        super.zzi(j);
        int i = 0;
        this.zzc = j != 0;
        zzaau zzaau = this.zzd;
        if (zzaau != null) {
            i = zzaau.zze;
        }
        this.zzb = i;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0405 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0407  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzef r26, long r27, com.google.android.gms.internal.ads.zzagk r29) throws java.io.IOException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r29
            com.google.android.gms.internal.ads.zzago r3 = r0.zza
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzaf r1 = r2.zza
            if (r1 == 0) goto L_0x0011
            return r5
        L_0x0011:
            throw r4
        L_0x0012:
            com.google.android.gms.internal.ads.zzaau r7 = r0.zzd
            r6 = 4
            r12 = 1
            if (r7 != 0) goto L_0x0084
            com.google.android.gms.internal.ads.zzaav.zzd(r12, r1, r5)
            int r14 = r26.zzh()
            int r15 = r26.zzk()
            int r16 = r26.zzh()
            int r7 = r26.zzg()
            if (r7 > 0) goto L_0x0030
            r17 = -1
            goto L_0x0032
        L_0x0030:
            r17 = r7
        L_0x0032:
            int r7 = r26.zzg()
            if (r7 > 0) goto L_0x003b
            r18 = -1
            goto L_0x003d
        L_0x003b:
            r18 = r7
        L_0x003d:
            int r7 = r26.zzg()
            if (r7 > 0) goto L_0x0046
            r19 = -1
            goto L_0x0048
        L_0x0046:
            r19 = r7
        L_0x0048:
            int r3 = r26.zzk()
            r7 = r3 & 15
            double r7 = (double) r7
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r7 = java.lang.Math.pow(r9, r7)
            int r7 = (int) r7
            r3 = r3 & 240(0xf0, float:3.36E-43)
            int r3 = r3 >> r6
            double r4 = (double) r3
            double r3 = java.lang.Math.pow(r9, r4)
            int r3 = (int) r3
            int r4 = r26.zzk()
            byte[] r5 = r26.zzH()
            int r1 = r26.zzd()
            byte[] r23 = java.util.Arrays.copyOf(r5, r1)
            com.google.android.gms.internal.ads.zzaau r1 = new com.google.android.gms.internal.ads.zzaau
            r4 = r4 & r12
            if (r12 == r4) goto L_0x0077
            r22 = 0
            goto L_0x0079
        L_0x0077:
            r22 = r12
        L_0x0079:
            r13 = r1
            r20 = r7
            r21 = r3
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0.zzd = r1
            goto L_0x008e
        L_0x0084:
            com.google.android.gms.internal.ads.zzaas r8 = r0.zze
            if (r8 != 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzaas r1 = com.google.android.gms.internal.ads.zzaav.zzc(r1, r12, r12)
            r0.zze = r1
        L_0x008e:
            r1 = 0
            goto L_0x03ff
        L_0x0091:
            int r4 = r26.zzd()
            byte[] r9 = new byte[r4]
            byte[] r4 = r26.zzH()
            int r5 = r26.zzd()
            r10 = 0
            java.lang.System.arraycopy(r4, r10, r9, r10, r5)
            int r4 = r7.zza
            r5 = 5
            com.google.android.gms.internal.ads.zzaav.zzd(r5, r1, r10)
            int r11 = r26.zzk()
            int r11 = r11 + r12
            com.google.android.gms.internal.ads.zzaar r13 = new com.google.android.gms.internal.ads.zzaar
            byte[] r14 = r26.zzH()
            r13.<init>(r14)
            int r1 = r26.zzc()
            r14 = 8
            int r1 = r1 * r14
            r13.zzc(r1)
            r1 = r10
        L_0x00c2:
            r15 = 24
            r3 = 16
            if (r1 >= r11) goto L_0x01df
            int r14 = r13.zzb(r15)
            r10 = 5653314(0x564342, float:7.92198E-39)
            if (r14 != r10) goto L_0x01c4
            int r3 = r13.zzb(r3)
            int r10 = r13.zzb(r15)
            long[] r14 = new long[r10]
            boolean r15 = r13.zzd()
            r18 = 0
            if (r15 != 0) goto L_0x011f
            boolean r15 = r13.zzd()
            r6 = 0
        L_0x00e8:
            int r12 = r14.length
            if (r6 >= r12) goto L_0x011a
            if (r15 == 0) goto L_0x0108
            boolean r12 = r13.zzd()
            if (r12 == 0) goto L_0x0101
            int r12 = r13.zzb(r5)
            r21 = 1
            int r12 = r12 + 1
            r22 = r11
            long r11 = (long) r12
            r14[r6] = r11
            goto L_0x0115
        L_0x0101:
            r22 = r11
            r21 = 1
            r14[r6] = r18
            goto L_0x0115
        L_0x0108:
            r22 = r11
            r21 = 1
            int r11 = r13.zzb(r5)
            int r11 = r11 + 1
            long r11 = (long) r11
            r14[r6] = r11
        L_0x0115:
            int r6 = r6 + 1
            r11 = r22
            goto L_0x00e8
        L_0x011a:
            r22 = r11
            r21 = 1
            goto L_0x0159
        L_0x011f:
            r22 = r11
            r21 = r12
            int r6 = r13.zzb(r5)
            int r6 = r6 + 1
            r11 = r6
            r6 = 0
        L_0x012b:
            int r12 = r14.length
            if (r6 >= r12) goto L_0x0159
            int r12 = r10 - r6
            int r12 = com.google.android.gms.internal.ads.zzaav.zza(r12)
            int r12 = r13.zzb(r12)
            r15 = r6
            r6 = 0
        L_0x013a:
            if (r6 >= r12) goto L_0x014e
            int r5 = r14.length
            if (r15 >= r5) goto L_0x014e
            r5 = r8
            r24 = r9
            long r8 = (long) r11
            r14[r15] = r8
            int r15 = r15 + 1
            int r6 = r6 + 1
            r8 = r5
            r9 = r24
            r5 = 5
            goto L_0x013a
        L_0x014e:
            r5 = r8
            r24 = r9
            int r11 = r11 + 1
            r8 = r5
            r6 = r15
            r9 = r24
            r5 = 5
            goto L_0x012b
        L_0x0159:
            r5 = r8
            r24 = r9
            r6 = 4
            int r8 = r13.zzb(r6)
            r9 = 2
            if (r8 > r9) goto L_0x01ad
            r11 = 1
            if (r8 == r11) goto L_0x016a
            if (r8 != r9) goto L_0x019c
            r8 = 2
        L_0x016a:
            r9 = 32
            r13.zzc(r9)
            r13.zzc(r9)
            int r9 = r13.zzb(r6)
            int r9 = r9 + r11
            r13.zzc(r11)
            if (r8 != r11) goto L_0x0191
            if (r3 == 0) goto L_0x0195
            long r10 = (long) r10
            double r10 = (double) r10
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            long r2 = (long) r3
            double r2 = (double) r2
            double r14 = r14 / r2
            double r2 = java.lang.Math.pow(r10, r14)
            double r2 = java.lang.Math.floor(r2)
            long r2 = (long) r2
            r18 = r2
            goto L_0x0195
        L_0x0191:
            long r10 = (long) r10
            long r2 = (long) r3
            long r18 = r10 * r2
        L_0x0195:
            long r2 = (long) r9
            long r2 = r2 * r18
            int r2 = (int) r2
            r13.zzc(r2)
        L_0x019c:
            int r1 = r1 + 1
            r2 = r29
            r8 = r5
            r11 = r22
            r9 = r24
            r5 = 5
            r6 = 4
            r10 = 0
            r12 = 1
            r14 = 8
            goto L_0x00c2
        L_0x01ad:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "lookup type greater than 2 not decodable: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x01c4:
            r2 = 0
            int r1 = r13.zza()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "expected code book to start with [0x56, 0x43, 0x42] at "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x01df:
            r5 = r8
            r24 = r9
            r1 = 6
            int r2 = r13.zzb(r1)
            r6 = 1
            int r2 = r2 + r6
            r6 = 0
        L_0x01ea:
            if (r6 >= r2) goto L_0x01fd
            int r8 = r13.zzb(r3)
            if (r8 != 0) goto L_0x01f5
            int r6 = r6 + 1
            goto L_0x01ea
        L_0x01f5:
            java.lang.String r1 = "placeholder of time domain transforms not zeroed out"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x01fd:
            int r2 = r13.zzb(r1)
            r6 = 1
            int r2 = r2 + r6
            r8 = 0
        L_0x0204:
            r9 = 3
            if (r8 >= r2) goto L_0x02bc
            int r10 = r13.zzb(r3)
            if (r10 == 0) goto L_0x0290
            if (r10 != r6) goto L_0x0279
            r6 = 5
            int r10 = r13.zzb(r6)
            int[] r6 = new int[r10]
            r11 = 0
            r12 = -1
        L_0x0218:
            if (r11 >= r10) goto L_0x0229
            r14 = 4
            int r15 = r13.zzb(r14)
            r6[r11] = r15
            if (r15 <= r12) goto L_0x0224
            r12 = r15
        L_0x0224:
            int r11 = r11 + 1
            r15 = 24
            goto L_0x0218
        L_0x0229:
            int r12 = r12 + 1
            int[] r11 = new int[r12]
            r12 = 0
        L_0x022e:
            int r14 = r11.length
            if (r12 >= r14) goto L_0x025b
            int r14 = r13.zzb(r9)
            r15 = 1
            int r14 = r14 + r15
            r11[r12] = r14
            r14 = 2
            int r19 = r13.zzb(r14)
            if (r19 <= 0) goto L_0x0246
            r14 = 8
            r13.zzc(r14)
            goto L_0x0248
        L_0x0246:
            r14 = 8
        L_0x0248:
            r9 = 0
        L_0x0249:
            int r1 = r15 << r19
            if (r9 >= r1) goto L_0x0256
            r13.zzc(r14)
            int r9 = r9 + 1
            r14 = 8
            r15 = 1
            goto L_0x0249
        L_0x0256:
            int r12 = r12 + 1
            r1 = 6
            r9 = 3
            goto L_0x022e
        L_0x025b:
            r1 = 2
            r13.zzc(r1)
            r1 = 4
            int r9 = r13.zzb(r1)
            r1 = 0
            r12 = 0
            r14 = 0
        L_0x0267:
            if (r1 >= r10) goto L_0x02b4
            r15 = r6[r1]
            r15 = r11[r15]
            int r12 = r12 + r15
        L_0x026e:
            if (r14 >= r12) goto L_0x0276
            r13.zzc(r9)
            int r14 = r14 + 1
            goto L_0x026e
        L_0x0276:
            int r1 = r1 + 1
            goto L_0x0267
        L_0x0279:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "floor type greater than 1 not decodable: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x0290:
            r1 = 8
            r13.zzc(r1)
            r13.zzc(r3)
            r13.zzc(r3)
            r6 = 6
            r13.zzc(r6)
            r13.zzc(r1)
            r6 = 4
            int r9 = r13.zzb(r6)
            r6 = 1
            int r9 = r9 + r6
            r6 = 0
        L_0x02aa:
            if (r6 >= r9) goto L_0x02b4
            r13.zzc(r1)
            int r6 = r6 + 1
            r1 = 8
            goto L_0x02aa
        L_0x02b4:
            int r8 = r8 + 1
            r1 = 6
            r6 = 1
            r15 = 24
            goto L_0x0204
        L_0x02bc:
            int r2 = r13.zzb(r1)
            r6 = 1
            int r2 = r2 + r6
            r8 = 0
        L_0x02c3:
            if (r8 >= r2) goto L_0x032f
            int r9 = r13.zzb(r3)
            r10 = 2
            if (r9 > r10) goto L_0x0327
            r9 = 24
            r13.zzc(r9)
            r13.zzc(r9)
            r13.zzc(r9)
            int r10 = r13.zzb(r1)
            int r10 = r10 + r6
            r1 = 8
            r13.zzc(r1)
            int[] r6 = new int[r10]
            r11 = 0
        L_0x02e4:
            if (r11 >= r10) goto L_0x0303
            r12 = 3
            int r14 = r13.zzb(r12)
            boolean r15 = r13.zzd()
            if (r15 == 0) goto L_0x02f7
            r15 = 5
            int r18 = r13.zzb(r15)
            goto L_0x02fa
        L_0x02f7:
            r15 = 5
            r18 = 0
        L_0x02fa:
            int r18 = r18 * 8
            int r18 = r18 + r14
            r6[r11] = r18
            int r11 = r11 + 1
            goto L_0x02e4
        L_0x0303:
            r12 = 3
            r15 = 5
            r11 = 0
        L_0x0306:
            if (r11 >= r10) goto L_0x0322
            r14 = 0
        L_0x0309:
            if (r14 >= r1) goto L_0x031d
            r18 = r6[r11]
            r19 = 1
            int r22 = r19 << r14
            r18 = r18 & r22
            if (r18 == 0) goto L_0x0318
            r13.zzc(r1)
        L_0x0318:
            int r14 = r14 + 1
            r1 = 8
            goto L_0x0309
        L_0x031d:
            int r11 = r11 + 1
            r1 = 8
            goto L_0x0306
        L_0x0322:
            int r8 = r8 + 1
            r1 = 6
            r6 = 1
            goto L_0x02c3
        L_0x0327:
            java.lang.String r1 = "residueType greater than 2 is not decodable"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x032f:
            int r2 = r13.zzb(r1)
            r1 = 1
            int r2 = r2 + r1
            r1 = 0
        L_0x0336:
            if (r1 >= r2) goto L_0x03c1
            int r6 = r13.zzb(r3)
            if (r6 == 0) goto L_0x0357
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "mapping type other than 0 not supported: "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.String r8 = "VorbisUtil"
            com.google.android.gms.internal.ads.zzdw.zzb(r8, r6)
            r6 = 2
            r9 = 4
            goto L_0x03b5
        L_0x0357:
            boolean r6 = r13.zzd()
            if (r6 == 0) goto L_0x0367
            r6 = 4
            int r8 = r13.zzb(r6)
            r21 = 1
            int r12 = r8 + 1
            goto L_0x036b
        L_0x0367:
            r21 = 1
            r12 = r21
        L_0x036b:
            boolean r6 = r13.zzd()
            if (r6 == 0) goto L_0x038f
            r6 = 8
            int r8 = r13.zzb(r6)
            int r8 = r8 + 1
            r6 = 0
        L_0x037a:
            if (r6 >= r8) goto L_0x038f
            int r9 = r4 + -1
            int r10 = com.google.android.gms.internal.ads.zzaav.zza(r9)
            r13.zzc(r10)
            int r9 = com.google.android.gms.internal.ads.zzaav.zza(r9)
            r13.zzc(r9)
            int r6 = r6 + 1
            goto L_0x037a
        L_0x038f:
            r6 = 2
            int r8 = r13.zzb(r6)
            if (r8 != 0) goto L_0x03b9
            r8 = 1
            if (r12 <= r8) goto L_0x03a3
            r8 = 0
        L_0x039a:
            if (r8 >= r4) goto L_0x03a3
            r9 = 4
            r13.zzc(r9)
            int r8 = r8 + 1
            goto L_0x039a
        L_0x03a3:
            r9 = 4
            r8 = 0
        L_0x03a5:
            if (r8 >= r12) goto L_0x03b5
            r10 = 8
            r13.zzc(r10)
            r13.zzc(r10)
            r13.zzc(r10)
            int r8 = r8 + 1
            goto L_0x03a5
        L_0x03b5:
            int r1 = r1 + 1
            goto L_0x0336
        L_0x03b9:
            java.lang.String r1 = "to reserved bits must be zero after mapping coupling steps"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x03c1:
            r1 = 6
            int r1 = r13.zzb(r1)
            r2 = 1
            int r1 = r1 + r2
            com.google.android.gms.internal.ads.zzaat[] r10 = new com.google.android.gms.internal.ads.zzaat[r1]
            r2 = 0
        L_0x03cb:
            if (r2 >= r1) goto L_0x03e9
            boolean r4 = r13.zzd()
            int r6 = r13.zzb(r3)
            int r8 = r13.zzb(r3)
            r9 = 8
            int r11 = r13.zzb(r9)
            com.google.android.gms.internal.ads.zzaat r12 = new com.google.android.gms.internal.ads.zzaat
            r12.<init>(r4, r6, r8, r11)
            r10[r2] = r12
            int r2 = r2 + 1
            goto L_0x03cb
        L_0x03e9:
            boolean r1 = r13.zzd()
            if (r1 == 0) goto L_0x0452
            com.google.android.gms.internal.ads.zzago r1 = new com.google.android.gms.internal.ads.zzago
            int r2 = r10.length
            r3 = -1
            int r2 = r2 + r3
            int r11 = com.google.android.gms.internal.ads.zzaav.zza(r2)
            r6 = r1
            r8 = r5
            r9 = r24
            r6.<init>(r7, r8, r9, r10, r11)
        L_0x03ff:
            r0.zza = r1
            com.google.android.gms.internal.ads.zzago r1 = r0.zza
            if (r1 != 0) goto L_0x0407
            r2 = 1
            return r2
        L_0x0407:
            com.google.android.gms.internal.ads.zzaau r2 = r1.zza
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            byte[] r4 = r2.zzg
            r3.add(r4)
            byte[] r4 = r1.zzc
            r3.add(r4)
            com.google.android.gms.internal.ads.zzaas r1 = r1.zzb
            java.lang.String[] r1 = r1.zzb
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzn(r1)
            com.google.android.gms.internal.ads.zzbq r1 = com.google.android.gms.internal.ads.zzaav.zzb(r1)
            com.google.android.gms.internal.ads.zzad r4 = new com.google.android.gms.internal.ads.zzad
            r4.<init>()
            java.lang.String r5 = "audio/vorbis"
            r4.zzS(r5)
            int r5 = r2.zzd
            r4.zzv(r5)
            int r5 = r2.zzc
            r4.zzO(r5)
            int r5 = r2.zza
            r4.zzw(r5)
            int r2 = r2.zzb
            r4.zzT(r2)
            r4.zzI(r3)
            r4.zzM(r1)
            com.google.android.gms.internal.ads.zzaf r1 = r4.zzY()
            r2 = r29
            r2.zza = r1
            r1 = 1
            return r1
        L_0x0452:
            java.lang.String r1 = "framing bit after modes not set as expected"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagp.zzc(com.google.android.gms.internal.ads.zzef, long, com.google.android.gms.internal.ads.zzagk):boolean");
    }
}
