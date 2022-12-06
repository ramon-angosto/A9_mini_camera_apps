package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzvq extends zzvn {
    private final boolean zze;
    private final zzvf zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final boolean zzo;
    private final boolean zzp;
    private final int zzq;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r2 <= 2.14748365E9f) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        if (r1 >= 0) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
        if (r1 >= 0) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005d, code lost:
        if (r1 >= 0.0f) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0065, code lost:
        if (r7 >= 0) goto L_0x0067;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x00af A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzvq(int r5, com.google.android.gms.internal.ads.zzcp r6, int r7, com.google.android.gms.internal.ads.zzvf r8, int r9, int r10, boolean r11) {
        /*
            r4 = this;
            r4.<init>(r5, r6, r7)
            r4.zzf = r8
            boolean r5 = r8.zzI
            r6 = 1
            if (r6 == r5) goto L_0x000d
            r5 = 16
            goto L_0x000f
        L_0x000d:
            r5 = 24
        L_0x000f:
            boolean r7 = r8.zzH
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r10 = -1
            r0 = 0
            if (r11 == 0) goto L_0x003b
            com.google.android.gms.internal.ads.zzaf r1 = r4.zzd
            int r2 = r1.zzr
            if (r2 == r10) goto L_0x001f
            int r2 = r8.zzd
        L_0x001f:
            int r2 = r1.zzs
            if (r2 == r10) goto L_0x0025
            int r2 = r8.zze
        L_0x0025:
            float r2 = r1.zzt
            int r3 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0033
            int r3 = r8.zzf
            r3 = 1325400064(0x4f000000, float:2.14748365E9)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x003b
        L_0x0033:
            int r1 = r1.zzi
            if (r1 == r10) goto L_0x0039
            int r1 = r8.zzg
        L_0x0039:
            r1 = r6
            goto L_0x003c
        L_0x003b:
            r1 = r0
        L_0x003c:
            r4.zze = r1
            if (r11 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzaf r11 = r4.zzd
            int r1 = r11.zzr
            if (r1 == r10) goto L_0x004a
            int r2 = r8.zzh
            if (r1 < 0) goto L_0x0069
        L_0x004a:
            int r1 = r11.zzs
            if (r1 == r10) goto L_0x0052
            int r2 = r8.zzi
            if (r1 < 0) goto L_0x0069
        L_0x0052:
            float r1 = r11.zzt
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x005f
            int r7 = r8.zzj
            r7 = 0
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x0069
        L_0x005f:
            int r7 = r11.zzi
            if (r7 == r10) goto L_0x0067
            int r11 = r8.zzk
            if (r7 < 0) goto L_0x0069
        L_0x0067:
            r7 = r6
            goto L_0x006a
        L_0x0069:
            r7 = r0
        L_0x006a:
            r4.zzg = r7
            boolean r7 = com.google.android.gms.internal.ads.zzvr.zzm(r9, r0)
            r4.zzh = r7
            com.google.android.gms.internal.ads.zzaf r7 = r4.zzd
            int r11 = r7.zzi
            r4.zzi = r11
            int r7 = r7.zza()
            r4.zzj = r7
            com.google.android.gms.internal.ads.zzaf r7 = r4.zzd
            int r7 = r7.zzf
            int r7 = r8.zzp
            int r7 = java.lang.Integer.bitCount(r0)
            r4.zzl = r7
            com.google.android.gms.internal.ads.zzaf r7 = r4.zzd
            int r7 = r7.zzf
            r4.zzm = r6
            r7 = r0
        L_0x0091:
            com.google.android.gms.internal.ads.zzfvn r11 = r8.zzo
            int r11 = r11.size()
            if (r7 >= r11) goto L_0x00af
            com.google.android.gms.internal.ads.zzaf r11 = r4.zzd
            java.lang.String r11 = r11.zzm
            if (r11 == 0) goto L_0x00ac
            com.google.android.gms.internal.ads.zzfvn r1 = r8.zzo
            java.lang.Object r1 = r1.get(r7)
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L_0x00ac
            goto L_0x00b2
        L_0x00ac:
            int r7 = r7 + 1
            goto L_0x0091
        L_0x00af:
            r7 = 2147483647(0x7fffffff, float:NaN)
        L_0x00b2:
            r4.zzk = r7
            r7 = r9 & 128(0x80, float:1.794E-43)
            r8 = 128(0x80, float:1.794E-43)
            if (r7 != r8) goto L_0x00bc
            r7 = r6
            goto L_0x00bd
        L_0x00bc:
            r7 = r0
        L_0x00bd:
            r4.zzo = r7
            r7 = r9 & 64
            r8 = 64
            if (r7 != r8) goto L_0x00c7
            r7 = r6
            goto L_0x00c8
        L_0x00c7:
            r7 = r0
        L_0x00c8:
            r4.zzp = r7
            com.google.android.gms.internal.ads.zzaf r7 = r4.zzd
            java.lang.String r8 = r7.zzm
            r11 = 3
            r1 = 2
            if (r8 != 0) goto L_0x00d4
        L_0x00d2:
            r8 = r0
            goto L_0x0115
        L_0x00d4:
            int r2 = r8.hashCode()
            switch(r2) {
                case -1662735862: goto L_0x00fa;
                case -1662541442: goto L_0x00f0;
                case 1331836730: goto L_0x00e6;
                case 1599127257: goto L_0x00dc;
                default: goto L_0x00db;
            }
        L_0x00db:
            goto L_0x0104
        L_0x00dc:
            java.lang.String r2 = "video/x-vnd.on2.vp9"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0104
            r8 = r1
            goto L_0x0105
        L_0x00e6:
            java.lang.String r2 = "video/avc"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0104
            r8 = r11
            goto L_0x0105
        L_0x00f0:
            java.lang.String r2 = "video/hevc"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0104
            r8 = r6
            goto L_0x0105
        L_0x00fa:
            java.lang.String r2 = "video/av01"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0104
            r8 = r0
            goto L_0x0105
        L_0x0104:
            r8 = r10
        L_0x0105:
            if (r8 == 0) goto L_0x0114
            if (r8 == r6) goto L_0x0112
            if (r8 == r1) goto L_0x0110
            if (r8 == r11) goto L_0x010e
            goto L_0x00d2
        L_0x010e:
            r8 = r6
            goto L_0x0115
        L_0x0110:
            r8 = r1
            goto L_0x0115
        L_0x0112:
            r8 = r11
            goto L_0x0115
        L_0x0114:
            r8 = 4
        L_0x0115:
            r4.zzq = r8
            int r8 = r7.zzf
            com.google.android.gms.internal.ads.zzvf r8 = r4.zzf
            boolean r11 = r8.zzQ
            boolean r11 = com.google.android.gms.internal.ads.zzvr.zzm(r9, r11)
            if (r11 != 0) goto L_0x0125
        L_0x0123:
            r6 = r0
            goto L_0x0146
        L_0x0125:
            boolean r11 = r4.zze
            if (r11 != 0) goto L_0x012e
            boolean r2 = r8.zzG
            if (r2 != 0) goto L_0x012e
            goto L_0x0123
        L_0x012e:
            boolean r0 = com.google.android.gms.internal.ads.zzvr.zzm(r9, r0)
            if (r0 == 0) goto L_0x0146
            boolean r0 = r4.zzg
            if (r0 == 0) goto L_0x0146
            if (r11 == 0) goto L_0x0146
            int r7 = r7.zzi
            if (r7 == r10) goto L_0x0146
            boolean r7 = r8.zzA
            boolean r7 = r8.zzz
            r5 = r5 & r9
            if (r5 == 0) goto L_0x0146
            r6 = r1
        L_0x0146:
            r4.zzn = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvq.<init>(int, com.google.android.gms.internal.ads.zzcp, int, com.google.android.gms.internal.ads.zzvf, int, int, boolean):void");
    }

    public static /* synthetic */ int zza(zzvq zzvq, zzvq zzvq2) {
        zzfwv zzfwv;
        if (!zzvq.zze || !zzvq.zzh) {
            zzfwv = zzvr.zzc.zza();
        } else {
            zzfwv = zzvr.zzc;
        }
        zzfvc zzj2 = zzfvc.zzj();
        Integer valueOf = Integer.valueOf(zzvq.zzi);
        Integer valueOf2 = Integer.valueOf(zzvq2.zzi);
        boolean z = zzvq.zzf.zzz;
        return zzj2.zzc(valueOf, valueOf2, zzvr.zzd).zzc(Integer.valueOf(zzvq.zzj), Integer.valueOf(zzvq2.zzj), zzfwv).zzc(Integer.valueOf(zzvq.zzi), Integer.valueOf(zzvq2.zzi), zzfwv).zza();
    }

    public static /* synthetic */ int zzd(zzvq zzvq, zzvq zzvq2) {
        zzfvc zzb = zzfvc.zzj().zzd(zzvq.zzh, zzvq2.zzh).zzb(zzvq.zzl, zzvq2.zzl);
        boolean z = zzvq.zzm;
        boolean z2 = zzvq2.zzm;
        zzfvc zzc = zzb.zzd(true, true).zzd(zzvq.zze, zzvq2.zze).zzd(zzvq.zzg, zzvq2.zzg).zzc(Integer.valueOf(zzvq.zzk), Integer.valueOf(zzvq2.zzk), zzfwv.zzc().zza());
        boolean z3 = zzvq.zzo;
        zzfvc zzd = zzc.zzd(z3, zzvq2.zzo);
        boolean z4 = zzvq.zzp;
        zzfvc zzd2 = zzd.zzd(z4, zzvq2.zzp);
        if (z3 && z4) {
            zzd2 = zzd2.zzb(zzvq.zzq, zzvq2.zzq);
        }
        return zzd2.zza();
    }

    public final int zzb() {
        return this.zzn;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzvn zzvn) {
        zzvq zzvq = (zzvq) zzvn;
        if (!zzen.zzT(this.zzd.zzm, zzvq.zzd.zzm)) {
            return false;
        }
        boolean z = this.zzf.zzJ;
        return this.zzo == zzvq.zzo && this.zzp == zzvq.zzp;
    }
}
