package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzyg {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzyf zza(byte[] bArr) throws zzbu {
        return zzb(new zzee(bArr, bArr.length), false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzyf zzb(com.google.android.gms.internal.ads.zzee r11, boolean r12) throws com.google.android.gms.internal.ads.zzbu {
        /*
            int r0 = zzc(r11)
            int r1 = zzd(r11)
            r2 = 4
            int r3 = r11.zzc(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "mp4a.40."
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r5 = 22
            r6 = 5
            if (r0 == r6) goto L_0x0027
            r6 = 29
            if (r0 != r6) goto L_0x0035
        L_0x0027:
            int r1 = zzd(r11)
            int r0 = zzc(r11)
            if (r0 != r5) goto L_0x0035
            int r3 = r11.zzc(r2)
        L_0x0035:
            if (r12 == 0) goto L_0x00d7
            r12 = 17
            r6 = 6
            r7 = 1
            r8 = 2
            r9 = 3
            if (r0 == r7) goto L_0x0065
            if (r0 == r8) goto L_0x0065
            if (r0 == r9) goto L_0x0065
            if (r0 == r2) goto L_0x0065
            if (r0 == r6) goto L_0x0065
            r2 = 7
            if (r0 == r2) goto L_0x0065
            if (r0 == r12) goto L_0x0065
            switch(r0) {
                case 19: goto L_0x0065;
                case 20: goto L_0x0065;
                case 21: goto L_0x0065;
                case 22: goto L_0x0065;
                case 23: goto L_0x0065;
                default: goto L_0x004f;
            }
        L_0x004f:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Unsupported audio object type: "
            r11.append(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.google.android.gms.internal.ads.zzbu r11 = com.google.android.gms.internal.ads.zzbu.zzc(r11)
            throw r11
        L_0x0065:
            boolean r2 = r11.zzl()
            if (r2 == 0) goto L_0x0072
            java.lang.String r2 = "AacUtil"
            java.lang.String r10 = "Unexpected frameLengthFlag = 1"
            com.google.android.gms.internal.ads.zzdw.zze(r2, r10)
        L_0x0072:
            boolean r2 = r11.zzl()
            if (r2 == 0) goto L_0x007d
            r2 = 14
            r11.zzj(r2)
        L_0x007d:
            boolean r2 = r11.zzl()
            if (r3 == 0) goto L_0x00d1
            r10 = 20
            if (r0 == r6) goto L_0x008d
            if (r0 != r10) goto L_0x008b
            r0 = r10
            goto L_0x008d
        L_0x008b:
            r6 = r0
            goto L_0x0091
        L_0x008d:
            r6 = r0
            r11.zzj(r9)
        L_0x0091:
            if (r2 == 0) goto L_0x00ad
            if (r0 != r5) goto L_0x009b
            r0 = 16
            r11.zzj(r0)
            r0 = r5
        L_0x009b:
            if (r0 == r12) goto L_0x00a7
            r12 = 19
            if (r0 == r12) goto L_0x00a7
            if (r0 == r10) goto L_0x00a7
            r12 = 23
            if (r0 != r12) goto L_0x00aa
        L_0x00a7:
            r11.zzj(r9)
        L_0x00aa:
            r11.zzj(r7)
        L_0x00ad:
            switch(r6) {
                case 17: goto L_0x00b1;
                case 18: goto L_0x00b0;
                case 19: goto L_0x00b1;
                case 20: goto L_0x00b1;
                case 21: goto L_0x00b1;
                case 22: goto L_0x00b1;
                case 23: goto L_0x00b1;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            goto L_0x00d7
        L_0x00b1:
            int r11 = r11.zzc(r8)
            if (r11 == r8) goto L_0x00bb
            if (r11 == r9) goto L_0x00ba
            goto L_0x00d7
        L_0x00ba:
            r11 = r9
        L_0x00bb:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Unsupported epConfig: "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            com.google.android.gms.internal.ads.zzbu r11 = com.google.android.gms.internal.ads.zzbu.zzc(r11)
            throw r11
        L_0x00d1:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            r11.<init>()
            throw r11
        L_0x00d7:
            int[] r11 = zzc
            r11 = r11[r3]
            r12 = -1
            r0 = 0
            if (r11 == r12) goto L_0x00e5
            com.google.android.gms.internal.ads.zzyf r12 = new com.google.android.gms.internal.ads.zzyf
            r12.<init>(r1, r11, r4, r0)
            return r12
        L_0x00e5:
            com.google.android.gms.internal.ads.zzbu r11 = com.google.android.gms.internal.ads.zzbu.zza(r0, r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyg.zzb(com.google.android.gms.internal.ads.zzee, boolean):com.google.android.gms.internal.ads.zzyf");
    }

    private static int zzc(zzee zzee) {
        int zzc2 = zzee.zzc(5);
        return zzc2 == 31 ? zzee.zzc(6) + 32 : zzc2;
    }

    private static int zzd(zzee zzee) throws zzbu {
        int zzc2 = zzee.zzc(4);
        if (zzc2 == 15) {
            return zzee.zzc(24);
        }
        if (zzc2 < 13) {
            return zzb[zzc2];
        }
        throw zzbu.zza((String) null, (Throwable) null);
    }
}
