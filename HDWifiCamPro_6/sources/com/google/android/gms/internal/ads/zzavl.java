package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzavl {
    private final byte[] zza = new byte[8];
    private final Stack zzb = new Stack();
    private final zzavt zzc = new zzavt();
    private int zzd;
    private int zze;
    private long zzf;
    private zzavo zzg;

    zzavl() {
    }

    private final long zzd(zzauy zzauy, int i) throws IOException, InterruptedException {
        zzauy.zzh(this.zza, 0, i, false);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zza[i2] & UByte.MAX_VALUE));
        }
        return j;
    }

    public final void zza() {
        this.zzd = 0;
        this.zzb.clear();
        this.zzc.zzd();
    }

    public final void zzb(zzavo zzavo) {
        this.zzg = zzavo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008b, code lost:
        if (r0 == 1) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzauy r13) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzavo r0 = r12.zzg
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x0009
        L_0x0008:
            r0 = r2
        L_0x0009:
            com.google.android.gms.internal.ads.zzbac.zze(r0)
        L_0x000c:
            java.util.Stack r0 = r12.zzb
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x003d
            long r3 = r13.zzd()
            java.util.Stack r0 = r12.zzb
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzavk r0 = (com.google.android.gms.internal.ads.zzavk) r0
            long r5 = r0.zzb
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0029
            goto L_0x003d
        L_0x0029:
            com.google.android.gms.internal.ads.zzavo r13 = r12.zzg
            java.util.Stack r0 = r12.zzb
            java.lang.Object r0 = r0.pop()
            com.google.android.gms.internal.ads.zzavk r0 = (com.google.android.gms.internal.ads.zzavk) r0
            int r0 = r0.zza
            com.google.android.gms.internal.ads.zzavr r13 = r13.zza
            r13.zzb(r0)
            return r1
        L_0x003d:
            int r0 = r12.zzd
            r3 = 2
            r4 = 4
            if (r0 != 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzavt r0 = r12.zzc
            long r5 = r0.zze(r13, r1, r2, r4)
            r7 = -2
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x007e
            r13.zze()
        L_0x0052:
            byte[] r0 = r12.zza
            r13.zzg(r0, r2, r4, r2)
            byte[] r0 = r12.zza
            byte r0 = r0[r2]
            int r0 = com.google.android.gms.internal.ads.zzavt.zzb(r0)
            r5 = -1
            if (r0 == r5) goto L_0x007a
            if (r0 > r4) goto L_0x007a
            byte[] r5 = r12.zza
            long r5 = com.google.android.gms.internal.ads.zzavt.zzc(r5, r0, r2)
            int r5 = (int) r5
            com.google.android.gms.internal.ads.zzavo r6 = r12.zzg
            com.google.android.gms.internal.ads.zzavr r6 = r6.zza
            boolean r6 = com.google.android.gms.internal.ads.zzavr.zzm(r5)
            if (r6 == 0) goto L_0x007a
            r13.zzi(r0, r2)
            long r5 = (long) r5
            goto L_0x007e
        L_0x007a:
            r13.zzi(r1, r2)
            goto L_0x0052
        L_0x007e:
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0085
            return r2
        L_0x0085:
            int r0 = (int) r5
            r12.zze = r0
            r12.zzd = r1
            goto L_0x008d
        L_0x008b:
            if (r0 != r1) goto L_0x0099
        L_0x008d:
            com.google.android.gms.internal.ads.zzavt r0 = r12.zzc
            r5 = 8
            long r5 = r0.zze(r13, r2, r1, r5)
            r12.zzf = r5
            r12.zzd = r3
        L_0x0099:
            com.google.android.gms.internal.ads.zzavo r0 = r12.zzg
            int r5 = r12.zze
            com.google.android.gms.internal.ads.zzavr r6 = r0.zza
            int r7 = com.google.android.gms.internal.ads.zzavr.zzl(r5)
            if (r7 == 0) goto L_0x017b
            if (r7 == r1) goto L_0x0159
            r8 = 8
            if (r7 == r3) goto L_0x012f
            r3 = 3
            if (r7 == r3) goto L_0x00f7
            if (r7 == r4) goto L_0x00ee
            long r6 = r12.zzf
            r10 = 4
            int r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x00d4
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x00bd
            goto L_0x00d4
        L_0x00bd:
            com.google.android.gms.internal.ads.zzasz r13 = new com.google.android.gms.internal.ads.zzasz
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid float size: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x00d4:
            int r3 = (int) r6
            long r6 = r12.zzd(r13, r3)
            if (r3 != r4) goto L_0x00e2
            int r13 = (int) r6
            float r13 = java.lang.Float.intBitsToFloat(r13)
            double r3 = (double) r13
            goto L_0x00e6
        L_0x00e2:
            double r3 = java.lang.Double.longBitsToDouble(r6)
        L_0x00e6:
            com.google.android.gms.internal.ads.zzavr r13 = r0.zza
            r13.zzc(r5, r3)
            r12.zzd = r2
            return r1
        L_0x00ee:
            long r3 = r12.zzf
            int r0 = (int) r3
            r6.zzk(r5, r0, r13)
            r12.zzd = r2
            return r1
        L_0x00f7:
            long r3 = r12.zzf
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0118
            int r3 = (int) r3
            if (r3 != 0) goto L_0x0106
            java.lang.String r13 = ""
            goto L_0x0110
        L_0x0106:
            byte[] r4 = new byte[r3]
            r13.zzh(r4, r2, r3, r2)
            java.lang.String r13 = new java.lang.String
            r13.<init>(r4)
        L_0x0110:
            com.google.android.gms.internal.ads.zzavr r0 = r0.zza
            r0.zzj(r5, r13)
            r12.zzd = r2
            return r1
        L_0x0118:
            com.google.android.gms.internal.ads.zzasz r13 = new com.google.android.gms.internal.ads.zzasz
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "String element size: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x012f:
            long r3 = r12.zzf
            int r6 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x0142
            int r3 = (int) r3
            long r3 = r12.zzd(r13, r3)
            com.google.android.gms.internal.ads.zzavr r13 = r0.zza
            r13.zzh(r5, r3)
            r12.zzd = r2
            return r1
        L_0x0142:
            com.google.android.gms.internal.ads.zzasz r13 = new com.google.android.gms.internal.ads.zzasz
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid integer size: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x0159:
            long r6 = r13.zzd()
            long r3 = r12.zzf
            java.util.Stack r13 = r12.zzb
            com.google.android.gms.internal.ads.zzavk r0 = new com.google.android.gms.internal.ads.zzavk
            long r3 = r3 + r6
            r8 = 0
            r0.<init>(r5, r3, r8)
            r13.add(r0)
            com.google.android.gms.internal.ads.zzavo r13 = r12.zzg
            int r4 = r12.zze
            long r8 = r12.zzf
            com.google.android.gms.internal.ads.zzavr r3 = r13.zza
            r5 = r6
            r7 = r8
            r3.zzi(r4, r5, r7)
            r12.zzd = r2
            return r1
        L_0x017b:
            long r3 = r12.zzf
            int r0 = (int) r3
            r13.zzi(r0, r2)
            r12.zzd = r2
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavl.zzc(com.google.android.gms.internal.ads.zzauy):boolean");
    }
}
