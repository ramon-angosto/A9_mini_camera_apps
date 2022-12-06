package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaeb implements zzaed {
    private final byte[] zza = new byte[8];
    private final ArrayDeque zzb = new ArrayDeque();
    private final zzaek zzc = new zzaek();
    private zzaec zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zzzj zzzj, int i) throws IOException {
        ((zzyy) zzzj).zzn(this.zza, 0, i, false);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zza[i2] & UByte.MAX_VALUE));
        }
        return j;
    }

    public final void zza(zzaec zzaec) {
        this.zzd = zzaec;
    }

    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zze();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        if (r0 == 1) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzzj r14) throws java.io.IOException {
        /*
            r13 = this;
            com.google.android.gms.internal.ads.zzaec r0 = r13.zzd
            com.google.android.gms.internal.ads.zzdd.zzb(r0)
        L_0x0005:
            java.util.ArrayDeque r0 = r13.zzb
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzaea r0 = (com.google.android.gms.internal.ads.zzaea) r0
            r1 = 1
            if (r0 == 0) goto L_0x0033
            long r2 = r14.zzf()
            long r4 = r0.zzb
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x001d
            goto L_0x0033
        L_0x001d:
            com.google.android.gms.internal.ads.zzaec r14 = r13.zzd
            java.util.ArrayDeque r0 = r13.zzb
            java.lang.Object r0 = r0.pop()
            com.google.android.gms.internal.ads.zzaea r0 = (com.google.android.gms.internal.ads.zzaea) r0
            int r0 = r0.zza
            com.google.android.gms.internal.ads.zzaeg r14 = (com.google.android.gms.internal.ads.zzaeg) r14
            com.google.android.gms.internal.ads.zzaei r14 = r14.zza
            r14.zzh(r0)
            return r1
        L_0x0033:
            int r0 = r13.zze
            r2 = 2
            r3 = 4
            r4 = 0
            if (r0 != 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzaek r0 = r13.zzc
            long r5 = r0.zzd(r14, r1, r4, r3)
            r7 = -2
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x007a
            r14.zzj()
        L_0x0049:
            byte[] r0 = r13.zza
            r5 = r14
            com.google.android.gms.internal.ads.zzyy r5 = (com.google.android.gms.internal.ads.zzyy) r5
            r5.zzm(r0, r4, r3, r4)
            byte[] r0 = r13.zza
            byte r0 = r0[r4]
            int r0 = com.google.android.gms.internal.ads.zzaek.zzb(r0)
            r6 = -1
            if (r0 == r6) goto L_0x0076
            if (r0 > r3) goto L_0x0076
            byte[] r6 = r13.zza
            long r6 = com.google.android.gms.internal.ads.zzaek.zzc(r6, r0, r4)
            int r6 = (int) r6
            com.google.android.gms.internal.ads.zzaec r7 = r13.zzd
            com.google.android.gms.internal.ads.zzaeg r7 = (com.google.android.gms.internal.ads.zzaeg) r7
            com.google.android.gms.internal.ads.zzaei r7 = r7.zza
            boolean r7 = com.google.android.gms.internal.ads.zzaei.zzo(r6)
            if (r7 == 0) goto L_0x0076
            r5.zzo(r0, r4)
            long r5 = (long) r6
            goto L_0x007a
        L_0x0076:
            r5.zzo(r1, r4)
            goto L_0x0049
        L_0x007a:
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0081
            return r4
        L_0x0081:
            int r0 = (int) r5
            r13.zzf = r0
            r13.zze = r1
            goto L_0x0089
        L_0x0087:
            if (r0 != r1) goto L_0x0095
        L_0x0089:
            com.google.android.gms.internal.ads.zzaek r0 = r13.zzc
            r5 = 8
            long r5 = r0.zzd(r14, r4, r1, r5)
            r13.zzg = r5
            r13.zze = r2
        L_0x0095:
            com.google.android.gms.internal.ads.zzaec r0 = r13.zzd
            int r5 = r13.zzf
            com.google.android.gms.internal.ads.zzaeg r0 = (com.google.android.gms.internal.ads.zzaeg) r0
            com.google.android.gms.internal.ads.zzaei r6 = r0.zza
            int r7 = com.google.android.gms.internal.ads.zzaei.zzn(r5)
            if (r7 == 0) goto L_0x0183
            r8 = 0
            if (r7 == r1) goto L_0x0161
            r9 = 8
            if (r7 == r2) goto L_0x0138
            r2 = 3
            if (r7 == r2) goto L_0x00f5
            if (r7 == r3) goto L_0x00ec
            long r6 = r13.zzg
            r11 = 4
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x00d2
            int r2 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x00bc
            goto L_0x00d2
        L_0x00bc:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Invalid float size: "
            r14.append(r0)
            r14.append(r6)
            java.lang.String r14 = r14.toString()
            com.google.android.gms.internal.ads.zzbu r14 = com.google.android.gms.internal.ads.zzbu.zza(r14, r8)
            throw r14
        L_0x00d2:
            int r2 = (int) r6
            long r6 = r13.zzd(r14, r2)
            if (r2 != r3) goto L_0x00e0
            int r14 = (int) r6
            float r14 = java.lang.Float.intBitsToFloat(r14)
            double r2 = (double) r14
            goto L_0x00e4
        L_0x00e0:
            double r2 = java.lang.Double.longBitsToDouble(r6)
        L_0x00e4:
            com.google.android.gms.internal.ads.zzaei r14 = r0.zza
            r14.zzi(r5, r2)
            r13.zze = r4
            return r1
        L_0x00ec:
            long r2 = r13.zzg
            int r0 = (int) r2
            r6.zzg(r5, r0, r14)
            r13.zze = r4
            return r1
        L_0x00f5:
            long r2 = r13.zzg
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0122
            int r2 = (int) r2
            if (r2 != 0) goto L_0x0104
            java.lang.String r14 = ""
            goto L_0x011a
        L_0x0104:
            byte[] r3 = new byte[r2]
            com.google.android.gms.internal.ads.zzyy r14 = (com.google.android.gms.internal.ads.zzyy) r14
            r14.zzn(r3, r4, r2, r4)
        L_0x010b:
            if (r2 <= 0) goto L_0x0115
            int r14 = r2 + -1
            byte r6 = r3[r14]
            if (r6 != 0) goto L_0x0115
            r2 = r14
            goto L_0x010b
        L_0x0115:
            java.lang.String r14 = new java.lang.String
            r14.<init>(r3, r4, r2)
        L_0x011a:
            com.google.android.gms.internal.ads.zzaei r0 = r0.zza
            r0.zzl(r5, r14)
            r13.zze = r4
            return r1
        L_0x0122:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "String element size: "
            r14.append(r0)
            r14.append(r2)
            java.lang.String r14 = r14.toString()
            com.google.android.gms.internal.ads.zzbu r14 = com.google.android.gms.internal.ads.zzbu.zza(r14, r8)
            throw r14
        L_0x0138:
            long r2 = r13.zzg
            int r6 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x014b
            int r2 = (int) r2
            long r2 = r13.zzd(r14, r2)
            com.google.android.gms.internal.ads.zzaei r14 = r0.zza
            r14.zzj(r5, r2)
            r13.zze = r4
            return r1
        L_0x014b:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Invalid integer size: "
            r14.append(r0)
            r14.append(r2)
            java.lang.String r14 = r14.toString()
            com.google.android.gms.internal.ads.zzbu r14 = com.google.android.gms.internal.ads.zzbu.zza(r14, r8)
            throw r14
        L_0x0161:
            long r2 = r14.zzf()
            long r6 = r13.zzg
            java.util.ArrayDeque r14 = r13.zzb
            com.google.android.gms.internal.ads.zzaea r0 = new com.google.android.gms.internal.ads.zzaea
            long r6 = r6 + r2
            r0.<init>(r5, r6, r8)
            r14.push(r0)
            com.google.android.gms.internal.ads.zzaec r14 = r13.zzd
            int r6 = r13.zzf
            long r9 = r13.zzg
            com.google.android.gms.internal.ads.zzaeg r14 = (com.google.android.gms.internal.ads.zzaeg) r14
            com.google.android.gms.internal.ads.zzaei r5 = r14.zza
            r7 = r2
            r5.zzk(r6, r7, r9)
            r13.zze = r4
            return r1
        L_0x0183:
            long r0 = r13.zzg
            r2 = r14
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            int r0 = (int) r0
            r2.zzo(r0, r4)
            r13.zze = r4
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeb.zzc(com.google.android.gms.internal.ads.zzzj):boolean");
    }
}
