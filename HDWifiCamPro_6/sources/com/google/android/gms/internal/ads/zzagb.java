package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzagb implements zzagi {
    private final zzagh zza;
    /* access modifiers changed from: private */
    public final long zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final zzagn zzd;
    private int zze;
    /* access modifiers changed from: private */
    public long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzagb(zzagn zzagn, long j, long j2, long j3, long j4, boolean z) {
        zzdd.zzd(j >= 0 && j2 > j);
        this.zzd = zzagn;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzagh();
    }

    public final /* bridge */ /* synthetic */ zzaal zze() {
        if (this.zzf != 0) {
            return new zzaga(this, (zzafz) null);
        }
        return null;
    }

    public final void zzg(long j) {
        this.zzh = zzen.zzr(j, 0, this.zzf - 1);
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0;
        this.zzl = this.zzf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzd(com.google.android.gms.internal.ads.zzzj r24) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            int r2 = r0.zze
            r3 = 1
            r5 = 0
            r6 = -1
            if (r2 == 0) goto L_0x00e9
            if (r2 == r3) goto L_0x00fc
            r3 = 2
            r10 = 3
            if (r2 == r3) goto L_0x0015
            if (r2 == r10) goto L_0x00aa
            return r6
        L_0x0015:
            long r2 = r0.zzi
            long r11 = r0.zzj
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x0020
        L_0x001d:
            r2 = r6
            goto L_0x00a3
        L_0x0020:
            long r2 = r24.zzf()
            com.google.android.gms.internal.ads.zzagh r13 = r0.zza
            boolean r11 = r13.zzc(r1, r11)
            if (r11 != 0) goto L_0x003d
            long r11 = r0.zzi
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0035
            r2 = r11
            goto L_0x00a3
        L_0x0035:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "No ogg page can be found."
            r1.<init>(r2)
            throw r1
        L_0x003d:
            com.google.android.gms.internal.ads.zzagh r11 = r0.zza
            r11.zzb(r1, r5)
            r24.zzj()
            long r11 = r0.zzh
            com.google.android.gms.internal.ads.zzagh r13 = r0.zza
            long r14 = r13.zzb
            long r11 = r11 - r14
            int r8 = r13.zzd
            int r9 = r13.zze
            int r8 = r8 + r9
            r16 = 0
            int r9 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r9 < 0) goto L_0x005f
            r16 = 72000(0x11940, double:3.55727E-319)
            int r13 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r13 >= 0) goto L_0x005f
            goto L_0x001d
        L_0x005f:
            if (r9 >= 0) goto L_0x0066
            r0.zzj = r2
            r0.zzl = r14
            goto L_0x0070
        L_0x0066:
            long r2 = r24.zzf()
            long r4 = (long) r8
            long r2 = r2 + r4
            r0.zzi = r2
            r0.zzk = r14
        L_0x0070:
            long r2 = r0.zzj
            long r4 = r0.zzi
            long r14 = r2 - r4
            r17 = 100000(0x186a0, double:4.94066E-319)
            int r17 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r17 >= 0) goto L_0x0081
            r0.zzj = r4
            r2 = r4
            goto L_0x00a3
        L_0x0081:
            long r6 = (long) r8
            if (r9 > 0) goto L_0x0087
            r8 = 2
            goto L_0x0089
        L_0x0087:
            r8 = 1
        L_0x0089:
            long r17 = r24.zzf()
            long r6 = r6 * r8
            long r17 = r17 - r6
            long r11 = r11 * r14
            long r6 = r0.zzl
            long r8 = r0.zzk
            long r6 = r6 - r8
            long r11 = r11 / r6
            long r17 = r17 + r11
            r6 = -1
            long r21 = r2 + r6
            r19 = r4
            long r2 = com.google.android.gms.internal.ads.zzen.zzr(r17, r19, r21)
        L_0x00a3:
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x00a8
            return r2
        L_0x00a8:
            r0.zze = r10
        L_0x00aa:
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            r2.zzc(r1, r6)
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            r3 = 0
            r2.zzb(r1, r3)
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            long r3 = r2.zzb
            long r5 = r0.zzh
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00cc
            r24.zzj()
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzk
            r4 = 2
            long r1 = r1 + r4
            long r1 = -r1
            return r1
        L_0x00cc:
            r4 = 2
            int r3 = r2.zzd
            int r2 = r2.zze
            r6 = r1
            com.google.android.gms.internal.ads.zzyy r6 = (com.google.android.gms.internal.ads.zzyy) r6
            int r3 = r3 + r2
            r2 = 0
            r6.zzo(r3, r2)
            long r2 = r24.zzf()
            r0.zzi = r2
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            long r2 = r2.zzb
            r0.zzk = r2
            r6 = -1
            goto L_0x00aa
        L_0x00e9:
            long r4 = r24.zzf()
            r0.zzg = r4
            r0.zze = r3
            long r6 = r0.zzc
            r8 = -65307(0xffffffffffff00e5, double:NaN)
            long r6 = r6 + r8
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00fc
            return r6
        L_0x00fc:
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            r2.zza()
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            r4 = -1
            boolean r2 = r2.zzc(r1, r4)
            if (r2 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            r4 = 0
            r2.zzb(r1, r4)
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            int r5 = r2.zzd
            int r2 = r2.zze
            r6 = r1
            com.google.android.gms.internal.ads.zzyy r6 = (com.google.android.gms.internal.ads.zzyy) r6
            int r5 = r5 + r2
            r6.zzo(r5, r4)
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            long r4 = r2.zzb
        L_0x0122:
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            int r6 = r2.zza
            r7 = 4
            r6 = r6 & r7
            if (r6 == r7) goto L_0x0157
            r6 = -1
            boolean r2 = r2.zzc(r1, r6)
            if (r2 == 0) goto L_0x0157
            long r8 = r24.zzf()
            long r10 = r0.zzc
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x0157
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            boolean r2 = r2.zzb(r1, r3)
            if (r2 == 0) goto L_0x0157
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            int r8 = r2.zzd
            int r2 = r2.zze
            int r8 = r8 + r2
            boolean r2 = com.google.android.gms.internal.ads.zzzm.zze(r1, r8)
            if (r2 != 0) goto L_0x0152
            goto L_0x0157
        L_0x0152:
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            long r4 = r2.zzb
            goto L_0x0122
        L_0x0157:
            r0.zzf = r4
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzg
            return r1
        L_0x015f:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagb.zzd(com.google.android.gms.internal.ads.zzzj):long");
    }
}
