package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaha implements zzahc {
    private final zzef zza = new zzef(new byte[18]);
    private final String zzb;
    private String zzc;
    private zzaap zzd;
    private int zze = 0;
    private int zzf;
    private int zzg;
    private long zzh;
    private zzaf zzi;
    private int zzj;
    private long zzk = C.TIME_UNSET;

    public zzaha(String str) {
        this.zzb = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0005 A[EDGE_INSN: B:63:0x0005->B:57:0x0005 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzef r15) {
        /*
            r14 = this;
            com.google.android.gms.internal.ads.zzaap r0 = r14.zzd
            com.google.android.gms.internal.ads.zzdd.zzb(r0)
        L_0x0005:
            int r0 = r15.zza()
            if (r0 <= 0) goto L_0x0192
            int r0 = r14.zze
            r1 = 8
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 4
            if (r0 == 0) goto L_0x0140
            if (r0 == r5) goto L_0x0050
            int r0 = r15.zza()
            int r1 = r14.zzj
            int r2 = r14.zzf
            int r1 = r1 - r2
            int r0 = java.lang.Math.min(r0, r1)
            com.google.android.gms.internal.ads.zzaap r1 = r14.zzd
            r1.zzq(r15, r0)
            int r1 = r14.zzf
            int r1 = r1 + r0
            r14.zzf = r1
            int r9 = r14.zzj
            if (r1 != r9) goto L_0x0005
            long r6 = r14.zzk
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzaap r5 = r14.zzd
            r8 = 1
            r10 = 0
            r11 = 0
            r5.zzs(r6, r8, r9, r10, r11)
            long r0 = r14.zzk
            long r2 = r14.zzh
            long r0 = r0 + r2
            r14.zzk = r0
        L_0x004d:
            r14.zze = r4
            goto L_0x0005
        L_0x0050:
            com.google.android.gms.internal.ads.zzef r0 = r14.zza
            byte[] r0 = r0.zzH()
            int r7 = r15.zza()
            int r8 = r14.zzf
            r9 = 18
            int r8 = 18 - r8
            int r7 = java.lang.Math.min(r7, r8)
            int r8 = r14.zzf
            r15.zzB(r0, r8, r7)
            int r0 = r14.zzf
            int r0 = r0 + r7
            r14.zzf = r0
            if (r0 != r9) goto L_0x0005
            com.google.android.gms.internal.ads.zzef r0 = r14.zza
            byte[] r0 = r0.zzH()
            com.google.android.gms.internal.ads.zzaf r7 = r14.zzi
            if (r7 != 0) goto L_0x008c
            java.lang.String r7 = r14.zzc
            java.lang.String r8 = r14.zzb
            r10 = 0
            com.google.android.gms.internal.ads.zzaf r7 = com.google.android.gms.internal.ads.zzzf.zza(r0, r7, r8, r10)
            r14.zzi = r7
            com.google.android.gms.internal.ads.zzaap r7 = r14.zzd
            com.google.android.gms.internal.ads.zzaf r8 = r14.zzi
            r7.zzk(r8)
        L_0x008c:
            int r7 = com.google.android.gms.internal.ads.zzzf.zza
            byte r7 = r0[r4]
            r8 = -2
            r10 = 5
            r11 = 7
            r12 = 6
            if (r7 == r8) goto L_0x00db
            r13 = -1
            if (r7 == r13) goto L_0x00c4
            r13 = 31
            if (r7 == r13) goto L_0x00b2
            byte r1 = r0[r10]
            r1 = r1 & r2
            int r1 = r1 << 12
            byte r2 = r0[r12]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r2 = r0[r11]
        L_0x00aa:
            r2 = r2 & 240(0xf0, float:3.36E-43)
            int r2 = r2 >> r6
            r1 = r1 | r2
            int r1 = r1 + r5
            r2 = r1
            r1 = r4
            goto L_0x00e9
        L_0x00b2:
            byte r7 = r0[r12]
            r2 = r2 & r7
            int r2 = r2 << 12
            byte r7 = r0[r11]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r6
            r2 = r2 | r7
            byte r1 = r0[r1]
            r1 = r1 & 60
            int r1 = r1 >> r3
            r1 = r1 | r2
            goto L_0x00d7
        L_0x00c4:
            byte r1 = r0[r11]
            r1 = r1 & r2
            int r1 = r1 << 12
            byte r2 = r0[r12]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r2 = 9
            byte r2 = r0[r2]
            r2 = r2 & 60
            int r2 = r2 >> r3
            r1 = r1 | r2
        L_0x00d7:
            int r1 = r1 + r5
            r2 = r1
            r1 = r5
            goto L_0x00e9
        L_0x00db:
            byte r1 = r0[r6]
            r1 = r1 & r2
            int r1 = r1 << 12
            byte r2 = r0[r11]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r2 = r0[r12]
            goto L_0x00aa
        L_0x00e9:
            if (r1 == 0) goto L_0x00ef
            int r2 = r2 * 16
            int r2 = r2 / 14
        L_0x00ef:
            r14.zzj = r2
            byte r1 = r0[r4]
            if (r1 == r8) goto L_0x0117
            r2 = -1
            if (r1 == r2) goto L_0x010e
            r2 = 31
            if (r1 == r2) goto L_0x0107
            byte r1 = r0[r6]
            r1 = r1 & r5
            int r1 = r1 << r12
            byte r0 = r0[r10]
        L_0x0102:
            r0 = r0 & 252(0xfc, float:3.53E-43)
        L_0x0104:
            int r0 = r0 >> r3
            r0 = r0 | r1
            goto L_0x011e
        L_0x0107:
            byte r1 = r0[r10]
            r1 = r1 & r11
            int r1 = r1 << r6
            byte r0 = r0[r12]
            goto L_0x0114
        L_0x010e:
            byte r1 = r0[r6]
            r1 = r1 & r11
            int r1 = r1 << r6
            byte r0 = r0[r11]
        L_0x0114:
            r0 = r0 & 60
            goto L_0x0104
        L_0x0117:
            byte r1 = r0[r10]
            r1 = r1 & r5
            int r1 = r1 << r12
            byte r0 = r0[r6]
            goto L_0x0102
        L_0x011e:
            int r0 = r0 + r5
            int r0 = r0 * 32
            long r0 = (long) r0
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 * r5
            com.google.android.gms.internal.ads.zzaf r2 = r14.zzi
            int r2 = r2.zzA
            long r5 = (long) r2
            long r0 = r0 / r5
            int r0 = (int) r0
            long r0 = (long) r0
            r14.zzh = r0
            com.google.android.gms.internal.ads.zzef r0 = r14.zza
            r0.zzF(r4)
            com.google.android.gms.internal.ads.zzaap r0 = r14.zzd
            com.google.android.gms.internal.ads.zzef r1 = r14.zza
            r0.zzq(r1, r9)
            r14.zze = r3
            goto L_0x0005
        L_0x0140:
            int r0 = r15.zza()
            if (r0 <= 0) goto L_0x0005
            int r0 = r14.zzg
            int r0 = r0 << r1
            r14.zzg = r0
            int r7 = r15.zzk()
            r0 = r0 | r7
            r14.zzg = r0
            int r7 = com.google.android.gms.internal.ads.zzzf.zza
            r7 = 2147385345(0x7ffe8001, float:NaN)
            if (r0 == r7) goto L_0x0168
            r7 = -25230976(0xfffffffffe7f0180, float:-8.474023E37)
            if (r0 == r7) goto L_0x0168
            r7 = 536864768(0x1fffe800, float:1.0838051E-19)
            if (r0 == r7) goto L_0x0168
            r7 = -14745368(0xffffffffff1f00e8, float:-2.1135196E38)
            if (r0 != r7) goto L_0x0140
        L_0x0168:
            com.google.android.gms.internal.ads.zzef r0 = r14.zza
            byte[] r0 = r0.zzH()
            int r1 = r14.zzg
            int r7 = r1 >> 24
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r0[r4] = r7
            int r7 = r1 >> 16
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r0[r5] = r7
            int r7 = r1 >> 8
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r0[r3] = r7
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r0[r2] = r1
            r14.zzf = r6
            r14.zzg = r4
            r14.zze = r5
            goto L_0x0005
        L_0x0192:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaha.zza(com.google.android.gms.internal.ads.zzef):void");
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zzc = zzaio.zzb();
        this.zzd = zzzl.zzv(zzaio.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        if (j != C.TIME_UNSET) {
            this.zzk = j;
        }
    }

    public final void zze() {
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzk = C.TIME_UNSET;
    }
}
