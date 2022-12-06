package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaiw implements zzzi {
    public static final zzzp zza = zzais.zza;
    private zzzl zzb;
    private zzaap zzc;
    private int zzd = 0;
    private long zze = -1;
    private zzaiu zzf;
    private int zzg = -1;
    private long zzh = -1;

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00eb, code lost:
        if (r1 != 65534) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f2, code lost:
        if (r2 == 32) goto L_0x00f9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzzj r19, com.google.android.gms.internal.ads.zzaai r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.google.android.gms.internal.ads.zzaap r2 = r0.zzc
            com.google.android.gms.internal.ads.zzdd.zzb(r2)
            int r2 = com.google.android.gms.internal.ads.zzen.zza
            int r2 = r0.zzd
            r3 = -1
            r4 = 4
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0159
            r8 = 2
            r9 = -1
            if (r2 == r6) goto L_0x0124
            r11 = 3
            if (r2 == r8) goto L_0x00a4
            if (r2 == r11) goto L_0x003d
            long r11 = r0.zzh
            int r2 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r6 = r7
        L_0x0026:
            com.google.android.gms.internal.ads.zzdd.zzf(r6)
            long r8 = r0.zzh
            long r10 = r19.zzf()
            long r8 = r8 - r10
            com.google.android.gms.internal.ads.zzaiu r2 = r0.zzf
            if (r2 == 0) goto L_0x003c
            boolean r1 = r2.zzc(r1, r8)
            if (r1 == 0) goto L_0x003b
            return r3
        L_0x003b:
            return r7
        L_0x003c:
            throw r5
        L_0x003d:
            android.util.Pair r2 = com.google.android.gms.internal.ads.zzaiz.zza(r19)
            java.lang.Object r3 = r2.first
            java.lang.Long r3 = (java.lang.Long) r3
            int r3 = r3.intValue()
            r0.zzg = r3
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            long r11 = r0.zze
            int r6 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r6 == 0) goto L_0x0063
            r13 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r6 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x0063
            r2 = r11
        L_0x0063:
            int r6 = r0.zzg
            long r11 = (long) r6
            long r11 = r11 + r2
            r0.zzh = r11
            long r1 = r19.zzd()
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x0096
            int r3 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0096
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Data exceeds input length: "
            r3.append(r6)
            r3.append(r11)
            java.lang.String r6 = ", "
            r3.append(r6)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.String r6 = "WavExtractor"
            com.google.android.gms.internal.ads.zzdw.zze(r6, r3)
            r0.zzh = r1
            goto L_0x0097
        L_0x0096:
            r1 = r11
        L_0x0097:
            com.google.android.gms.internal.ads.zzaiu r3 = r0.zzf
            if (r3 == 0) goto L_0x00a3
            int r5 = r0.zzg
            r3.zza(r5, r1)
            r0.zzd = r4
            return r7
        L_0x00a3:
            throw r5
        L_0x00a4:
            com.google.android.gms.internal.ads.zzaix r15 = com.google.android.gms.internal.ads.zzaiz.zzb(r19)
            int r1 = r15.zza
            r2 = 17
            if (r1 != r2) goto L_0x00ba
            com.google.android.gms.internal.ads.zzait r1 = new com.google.android.gms.internal.ads.zzait
            com.google.android.gms.internal.ads.zzzl r2 = r0.zzb
            com.google.android.gms.internal.ads.zzaap r3 = r0.zzc
            r1.<init>(r2, r3, r15)
            r0.zzf = r1
            goto L_0x010b
        L_0x00ba:
            r2 = 6
            if (r1 != r2) goto L_0x00ce
            com.google.android.gms.internal.ads.zzaiv r1 = new com.google.android.gms.internal.ads.zzaiv
            com.google.android.gms.internal.ads.zzzl r13 = r0.zzb
            com.google.android.gms.internal.ads.zzaap r14 = r0.zzc
            r17 = -1
            java.lang.String r16 = "audio/g711-alaw"
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zzf = r1
            goto L_0x010b
        L_0x00ce:
            r2 = 7
            if (r1 != r2) goto L_0x00e2
            com.google.android.gms.internal.ads.zzaiv r1 = new com.google.android.gms.internal.ads.zzaiv
            com.google.android.gms.internal.ads.zzzl r13 = r0.zzb
            com.google.android.gms.internal.ads.zzaap r14 = r0.zzc
            r17 = -1
            java.lang.String r16 = "audio/g711-mlaw"
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zzf = r1
            goto L_0x010b
        L_0x00e2:
            int r2 = r15.zze
            if (r1 == r6) goto L_0x00f5
            if (r1 == r11) goto L_0x00f0
            r3 = 65534(0xfffe, float:9.1833E-41)
            if (r1 == r3) goto L_0x00f5
        L_0x00ed:
            r17 = r7
            goto L_0x00fb
        L_0x00f0:
            r3 = 32
            if (r2 != r3) goto L_0x00ed
            goto L_0x00f9
        L_0x00f5:
            int r4 = com.google.android.gms.internal.ads.zzen.zzn(r2)
        L_0x00f9:
            r17 = r4
        L_0x00fb:
            if (r17 == 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzaiv r1 = new com.google.android.gms.internal.ads.zzaiv
            com.google.android.gms.internal.ads.zzzl r13 = r0.zzb
            com.google.android.gms.internal.ads.zzaap r14 = r0.zzc
            java.lang.String r16 = "audio/raw"
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zzf = r1
        L_0x010b:
            r0.zzd = r11
            return r7
        L_0x010e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unsupported WAV format type: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zzc(r1)
            throw r1
        L_0x0124:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            r3 = 8
            r2.<init>((int) r3)
            com.google.android.gms.internal.ads.zzaiy r4 = com.google.android.gms.internal.ads.zzaiy.zza(r1, r2)
            int r5 = r4.zza
            r6 = 1685272116(0x64733634, float:1.7945858E22)
            if (r5 == r6) goto L_0x013a
            r19.zzj()
            goto L_0x0154
        L_0x013a:
            com.google.android.gms.internal.ads.zzyy r1 = (com.google.android.gms.internal.ads.zzyy) r1
            r1.zzl(r3, r7)
            r2.zzF(r7)
            byte[] r5 = r2.zzH()
            r1.zzm(r5, r7, r3, r7)
            long r9 = r2.zzp()
            long r4 = r4.zzb
            int r2 = (int) r4
            int r2 = r2 + r3
            r1.zzo(r2, r7)
        L_0x0154:
            r0.zze = r9
            r0.zzd = r8
            return r7
        L_0x0159:
            long r8 = r19.zzf()
            r10 = 0
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x0165
            r2 = r6
            goto L_0x0166
        L_0x0165:
            r2 = r7
        L_0x0166:
            com.google.android.gms.internal.ads.zzdd.zzf(r2)
            int r2 = r0.zzg
            if (r2 == r3) goto L_0x0175
            com.google.android.gms.internal.ads.zzyy r1 = (com.google.android.gms.internal.ads.zzyy) r1
            r1.zzo(r2, r7)
            r0.zzd = r4
            goto L_0x018c
        L_0x0175:
            boolean r2 = com.google.android.gms.internal.ads.zzaiz.zzc(r19)
            if (r2 == 0) goto L_0x018d
            long r2 = r19.zze()
            long r4 = r19.zzf()
            com.google.android.gms.internal.ads.zzyy r1 = (com.google.android.gms.internal.ads.zzyy) r1
            long r2 = r2 - r4
            int r2 = (int) r2
            r1.zzo(r2, r7)
            r0.zzd = r6
        L_0x018c:
            return r7
        L_0x018d:
            java.lang.String r1 = "Unsupported or unrecognized wav file type."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiw.zza(com.google.android.gms.internal.ads.zzzj, com.google.android.gms.internal.ads.zzaai):int");
    }

    public final void zzb(zzzl zzzl) {
        this.zzb = zzzl;
        this.zzc = zzzl.zzv(0, 1);
        zzzl.zzC();
    }

    public final void zzc(long j, long j2) {
        this.zzd = j == 0 ? 0 : 4;
        zzaiu zzaiu = this.zzf;
        if (zzaiu != null) {
            zzaiu.zzb(j2);
        }
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        return zzaiz.zzc(zzzj);
    }
}
