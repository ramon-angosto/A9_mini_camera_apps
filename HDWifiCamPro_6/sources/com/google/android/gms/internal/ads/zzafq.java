package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzafq implements zzzi, zzaal {
    public static final zzzp zza = zzafn.zza;
    private final zzef zzb;
    private final zzef zzc;
    private final zzef zzd;
    private final zzef zze;
    private final ArrayDeque zzf;
    private final zzaft zzg;
    private final List zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private int zzl;
    private zzef zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private zzzl zzr;
    private zzafp[] zzs;
    private long[][] zzt;
    private int zzu;
    private long zzv;
    private int zzw;
    private zzadt zzx;

    public zzafq() {
        this(0);
    }

    private static int zzf(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzi(zzafy zzafy, long j) {
        int zza2 = zzafy.zza(j);
        return zza2 == -1 ? zzafy.zzb(j) : zza2;
    }

    private static long zzj(zzafy zzafy, long j, long j2) {
        int zzi2 = zzi(zzafy, j);
        if (zzi2 == -1) {
            return j2;
        }
        return Math.min(zzafy.zzc[zzi2], j2);
    }

    private final void zzk() {
        this.zzi = 0;
        this.zzl = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x018b A[LOOP:3: B:69:0x0188->B:71:0x018b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzl(long r28) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r27 = this;
            r0 = r27
        L_0x0002:
            java.util.ArrayDeque r1 = r0.zzf
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0273
            java.util.ArrayDeque r1 = r0.zzf
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzaev r1 = (com.google.android.gms.internal.ads.zzaev) r1
            long r3 = r1.zza
            int r1 = (r3 > r28 ? 1 : (r3 == r28 ? 0 : -1))
            if (r1 != 0) goto L_0x0273
            java.util.ArrayDeque r1 = r0.zzf
            java.lang.Object r1 = r1.pop()
            r3 = r1
            com.google.android.gms.internal.ads.zzaev r3 = (com.google.android.gms.internal.ads.zzaev) r3
            int r1 = r3.zzd
            r4 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r1 != r4) goto L_0x025c
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r4 = r0.zzw
            r12 = 1
            if (r4 != r12) goto L_0x0034
            r9 = r12
            goto L_0x0035
        L_0x0034:
            r9 = 0
        L_0x0035:
            com.google.android.gms.internal.ads.zzzx r13 = new com.google.android.gms.internal.ads.zzzx
            r13.<init>()
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            com.google.android.gms.internal.ads.zzaew r4 = r3.zzb(r4)
            if (r4 == 0) goto L_0x0058
            android.util.Pair r4 = com.google.android.gms.internal.ads.zzaff.zza(r4)
            java.lang.Object r5 = r4.first
            com.google.android.gms.internal.ads.zzbq r5 = (com.google.android.gms.internal.ads.zzbq) r5
            java.lang.Object r4 = r4.second
            com.google.android.gms.internal.ads.zzbq r4 = (com.google.android.gms.internal.ads.zzbq) r4
            if (r5 == 0) goto L_0x0054
            r13.zzb(r5)
        L_0x0054:
            r15 = r4
            r16 = r5
            goto L_0x005b
        L_0x0058:
            r15 = 0
            r16 = 0
        L_0x005b:
            r4 = 1835365473(0x6d657461, float:4.4382975E27)
            com.google.android.gms.internal.ads.zzaev r4 = r3.zza(r4)
            if (r4 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzbq r4 = com.google.android.gms.internal.ads.zzaff.zzb(r4)
            r10 = r4
            goto L_0x006b
        L_0x006a:
            r10 = 0
        L_0x006b:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 0
            r8 = 0
            com.google.android.gms.internal.ads.zzafo r17 = com.google.android.gms.internal.ads.zzafo.zza
            r4 = r13
            r14 = r10
            r10 = r17
            java.util.List r3 = com.google.android.gms.internal.ads.zzaff.zzc(r3, r4, r5, r7, r8, r9, r10)
            int r4 = r3.size()
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r11 = r6
            r8 = 0
            r9 = -1
        L_0x0088:
            r18 = 0
            if (r8 >= r4) goto L_0x01c7
            java.lang.Object r20 = r3.get(r8)
            r10 = r20
            com.google.android.gms.internal.ads.zzafy r10 = (com.google.android.gms.internal.ads.zzafy) r10
            int r5 = r10.zzb
            if (r5 != 0) goto L_0x00a1
            r22 = r3
            r24 = r4
            r0 = -1
            r3 = r1
            r1 = r6
            goto L_0x01bb
        L_0x00a1:
            com.google.android.gms.internal.ads.zzafv r5 = r10.zza
            r22 = r3
            long r2 = r5.zze
            int r23 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r23 == 0) goto L_0x00ac
            goto L_0x00ae
        L_0x00ac:
            long r2 = r10.zzh
        L_0x00ae:
            long r11 = java.lang.Math.max(r11, r2)
            com.google.android.gms.internal.ads.zzafp r6 = new com.google.android.gms.internal.ads.zzafp
            com.google.android.gms.internal.ads.zzzl r7 = r0.zzr
            r24 = r4
            int r4 = r5.zzb
            com.google.android.gms.internal.ads.zzaap r4 = r7.zzv(r8, r4)
            r6.<init>(r5, r10, r4)
            com.google.android.gms.internal.ads.zzaf r4 = r5.zzf
            java.lang.String r4 = r4.zzm
            java.lang.String r7 = "audio/true-hd"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x00d2
            int r4 = r10.zze
            int r4 = r4 * 16
            goto L_0x00d6
        L_0x00d2:
            int r4 = r10.zze
            int r4 = r4 + 30
        L_0x00d6:
            com.google.android.gms.internal.ads.zzaf r7 = r5.zzf
            com.google.android.gms.internal.ads.zzad r7 = r7.zzb()
            r7.zzL(r4)
            int r4 = r5.zzb
            r25 = r11
            r11 = 2
            if (r4 != r11) goto L_0x00f9
            int r4 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r4 <= 0) goto L_0x00f9
            int r4 = r10.zzb
            r10 = 1
            if (r4 <= r10) goto L_0x00f9
            float r4 = (float) r4
            float r2 = (float) r2
            r3 = 1232348160(0x49742400, float:1000000.0)
            float r2 = r2 / r3
            float r4 = r4 / r2
            r7.zzE(r4)
        L_0x00f9:
            int r2 = r5.zzb
            int r3 = com.google.android.gms.internal.ads.zzafm.zzb
            r4 = 1
            if (r2 != r4) goto L_0x0110
            boolean r2 = r13.zza()
            if (r2 == 0) goto L_0x0110
            int r2 = r13.zza
            r7.zzC(r2)
            int r2 = r13.zzb
            r7.zzD(r2)
        L_0x0110:
            int r2 = r5.zzb
            r3 = 2
            com.google.android.gms.internal.ads.zzbq[] r4 = new com.google.android.gms.internal.ads.zzbq[r3]
            r3 = 0
            r4[r3] = r15
            java.util.List r10 = r0.zzh
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x0122
            r10 = 0
            goto L_0x0129
        L_0x0122:
            com.google.android.gms.internal.ads.zzbq r10 = new com.google.android.gms.internal.ads.zzbq
            java.util.List r11 = r0.zzh
            r10.<init>((java.util.List) r11)
        L_0x0129:
            r11 = 1
            r4[r11] = r10
            com.google.android.gms.internal.ads.zzbq r12 = new com.google.android.gms.internal.ads.zzbq
            com.google.android.gms.internal.ads.zzbp[] r10 = new com.google.android.gms.internal.ads.zzbp[r3]
            r21 = r1
            r3 = r10
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r12.<init>(r0, r3)
            if (r2 != r11) goto L_0x0147
            if (r16 == 0) goto L_0x0180
            r0 = r16
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0186
        L_0x0147:
            r0 = 2
            if (r2 != r0) goto L_0x0180
            if (r14 == 0) goto L_0x0180
            r0 = 0
        L_0x014d:
            int r1 = r14.zza()
            if (r0 >= r1) goto L_0x0180
            com.google.android.gms.internal.ads.zzbp r1 = r14.zzb(r0)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzadq
            if (r2 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzadq r1 = (com.google.android.gms.internal.ads.zzadq) r1
            java.lang.String r2 = r1.zza
            java.lang.String r3 = "com.android.capture.fps"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzbq r0 = new com.google.android.gms.internal.ads.zzbq
            r2 = 1
            com.google.android.gms.internal.ads.zzbp[] r3 = new com.google.android.gms.internal.ads.zzbp[r2]
            r2 = 0
            r3[r2] = r1
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.<init>(r1, r3)
            goto L_0x0186
        L_0x0178:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = r0 + 1
            goto L_0x014d
        L_0x0180:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0 = r12
        L_0x0186:
            r3 = r0
            r0 = 0
        L_0x0188:
            r11 = 2
            if (r0 >= r11) goto L_0x0194
            r11 = r4[r0]
            com.google.android.gms.internal.ads.zzbq r3 = r3.zzd(r11)
            int r0 = r0 + 1
            goto L_0x0188
        L_0x0194:
            int r0 = r3.zza()
            if (r0 <= 0) goto L_0x019d
            r7.zzM(r3)
        L_0x019d:
            com.google.android.gms.internal.ads.zzaap r0 = r6.zzc
            com.google.android.gms.internal.ads.zzaf r3 = r7.zzY()
            r0.zzk(r3)
            int r0 = r5.zzb
            r3 = 2
            if (r0 != r3) goto L_0x01b3
            r0 = -1
            if (r9 != r0) goto L_0x01b4
            int r9 = r21.size()
            goto L_0x01b4
        L_0x01b3:
            r0 = -1
        L_0x01b4:
            r3 = r21
            r3.add(r6)
            r11 = r25
        L_0x01bb:
            int r8 = r8 + 1
            r0 = r27
            r6 = r1
            r1 = r3
            r3 = r22
            r4 = r24
            goto L_0x0088
        L_0x01c7:
            r4 = r0
            r3 = r1
            r0 = -1
            r4.zzu = r9
            r4.zzv = r11
            r1 = 0
            com.google.android.gms.internal.ads.zzafp[] r2 = new com.google.android.gms.internal.ads.zzafp[r1]
            java.lang.Object[] r1 = r3.toArray(r2)
            com.google.android.gms.internal.ads.zzafp[] r1 = (com.google.android.gms.internal.ads.zzafp[]) r1
            r4.zzs = r1
            com.google.android.gms.internal.ads.zzafp[] r1 = r4.zzs
            int r2 = r1.length
            long[][] r3 = new long[r2][]
            int[] r5 = new int[r2]
            long[] r6 = new long[r2]
            boolean[] r2 = new boolean[r2]
            r7 = 0
        L_0x01e5:
            int r8 = r1.length
            if (r7 >= r8) goto L_0x0201
            r8 = r1[r7]
            com.google.android.gms.internal.ads.zzafy r8 = r8.zzb
            int r8 = r8.zzb
            long[] r8 = new long[r8]
            r3[r7] = r8
            r8 = r1[r7]
            com.google.android.gms.internal.ads.zzafy r8 = r8.zzb
            long[] r8 = r8.zzf
            r21 = 0
            r9 = r8[r21]
            r6[r7] = r9
            int r7 = r7 + 1
            goto L_0x01e5
        L_0x0201:
            r21 = 0
            r7 = r21
        L_0x0205:
            int r8 = r1.length
            if (r7 >= r8) goto L_0x0247
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = r8
            r8 = r21
            r9 = r0
        L_0x0211:
            int r12 = r1.length
            if (r8 >= r12) goto L_0x0223
            boolean r12 = r2[r8]
            if (r12 != 0) goto L_0x0220
            r12 = r6[r8]
            int r14 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r14 > 0) goto L_0x0220
            r9 = r8
            r10 = r12
        L_0x0220:
            int r8 = r8 + 1
            goto L_0x0211
        L_0x0223:
            r8 = r5[r9]
            r10 = r3[r9]
            r10[r8] = r18
            r11 = r1[r9]
            com.google.android.gms.internal.ads.zzafy r11 = r11.zzb
            int[] r12 = r11.zzd
            r12 = r12[r8]
            long r12 = (long) r12
            long r18 = r18 + r12
            r12 = 1
            int r8 = r8 + r12
            r5[r9] = r8
            int r10 = r10.length
            if (r8 >= r10) goto L_0x0242
            long[] r10 = r11.zzf
            r13 = r10[r8]
            r6[r9] = r13
            goto L_0x0205
        L_0x0242:
            r2[r9] = r12
            int r7 = r7 + 1
            goto L_0x0205
        L_0x0247:
            r4.zzt = r3
            com.google.android.gms.internal.ads.zzzl r0 = r4.zzr
            r0.zzC()
            com.google.android.gms.internal.ads.zzzl r0 = r4.zzr
            r0.zzN(r4)
            java.util.ArrayDeque r0 = r4.zzf
            r0.clear()
            r0 = 2
            r4.zzi = r0
            goto L_0x0270
        L_0x025c:
            r4 = r0
            java.util.ArrayDeque r0 = r4.zzf
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0270
            java.util.ArrayDeque r0 = r4.zzf
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzaev r0 = (com.google.android.gms.internal.ads.zzaev) r0
            r0.zzc(r3)
        L_0x0270:
            r0 = r4
            goto L_0x0002
        L_0x0273:
            r4 = r0
            int r0 = r4.zzi
            r1 = 2
            if (r0 == r1) goto L_0x027c
            r27.zzk()
        L_0x027c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafq.zzl(long):void");
    }

    public final void zzb(zzzl zzzl) {
        this.zzr = zzzl;
    }

    public final void zzc(long j, long j2) {
        this.zzf.clear();
        this.zzl = 0;
        this.zzn = -1;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        if (j == 0) {
            zzk();
            return;
        }
        for (zzafp zzafp : this.zzs) {
            zzafy zzafy = zzafp.zzb;
            int zza2 = zzafy.zza(j2);
            if (zza2 == -1) {
                zza2 = zzafy.zzb(j2);
            }
            zzafp.zze = zza2;
            zzaaq zzaaq = zzafp.zzd;
            if (zzaaq != null) {
                zzaaq.zzb();
            }
        }
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        return zzafu.zzb(zzzj, false);
    }

    public final long zze() {
        return this.zzv;
    }

    public final zzaaj zzg(long j) {
        long j2;
        long j3;
        int zzb2;
        zzafp[] zzafpArr = this.zzs;
        if (zzafpArr.length == 0) {
            zzaam zzaam = zzaam.zza;
            return new zzaaj(zzaam, zzaam);
        }
        int i = this.zzu;
        long j4 = -1;
        if (i != -1) {
            zzafy zzafy = zzafpArr[i].zzb;
            int zzi2 = zzi(zzafy, j);
            if (zzi2 == -1) {
                zzaam zzaam2 = zzaam.zza;
                return new zzaaj(zzaam2, zzaam2);
            }
            long j5 = zzafy.zzf[zzi2];
            j2 = zzafy.zzc[zzi2];
            if (j5 >= j || zzi2 >= zzafy.zzb - 1 || (zzb2 = zzafy.zzb(j)) == -1 || zzb2 == zzi2) {
                j3 = -9223372036854775807L;
            } else {
                j3 = zzafy.zzf[zzb2];
                j4 = zzafy.zzc[zzb2];
            }
            j = j5;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            zzafp[] zzafpArr2 = this.zzs;
            if (i2 >= zzafpArr2.length) {
                break;
            }
            if (i2 != this.zzu) {
                zzafy zzafy2 = zzafpArr2[i2].zzb;
                long zzj2 = zzj(zzafy2, j, j2);
                if (j3 != C.TIME_UNSET) {
                    j4 = zzj(zzafy2, j3, j4);
                }
                j2 = zzj2;
            }
            i2++;
        }
        zzaam zzaam3 = new zzaam(j, j2);
        if (j3 == C.TIME_UNSET) {
            return new zzaaj(zzaam3, zzaam3);
        }
        return new zzaaj(zzaam3, new zzaam(j3, j4));
    }

    public final boolean zzh() {
        return true;
    }

    public zzafq(int i) {
        this.zzi = 0;
        this.zzg = new zzaft();
        this.zzh = new ArrayList();
        this.zze = new zzef(16);
        this.zzf = new ArrayDeque();
        this.zzb = new zzef(zzaaf.zza);
        this.zzc = new zzef(4);
        this.zzd = new zzef();
        this.zzn = -1;
        this.zzr = zzzl.zza;
        this.zzs = new zzafp[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzzj r33, com.google.android.gms.internal.ads.zzaai r34) throws java.io.IOException {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r2 = r34
        L_0x0006:
            int r3 = r0.zzi
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            r6 = 0
            r8 = -1
            r9 = 8
            r10 = 1
            if (r3 == 0) goto L_0x025d
            r13 = 262144(0x40000, double:1.295163E-318)
            if (r3 == r10) goto L_0x01db
            long r3 = r33.zzf()
            int r9 = r0.zzn
            if (r9 != r8) goto L_0x00ab
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r20 = r8
            r27 = r20
            r21 = r10
            r24 = r21
            r18 = r16
            r22 = r18
            r25 = r22
            r9 = 0
        L_0x0034:
            com.google.android.gms.internal.ads.zzafp[] r5 = r0.zzs
            int r15 = r5.length
            if (r9 >= r15) goto L_0x008e
            r5 = r5[r9]
            int r15 = r5.zze
            com.google.android.gms.internal.ads.zzafy r5 = r5.zzb
            int r12 = r5.zzb
            if (r15 != r12) goto L_0x0044
            goto L_0x008b
        L_0x0044:
            long[] r5 = r5.zzc
            r28 = r5[r15]
            long[][] r5 = r0.zzt
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzen.zzH(r5)
            long[][] r5 = (long[][]) r5
            r5 = r5[r9]
            r30 = r5[r15]
            long r28 = r28 - r3
            int r5 = (r28 > r6 ? 1 : (r28 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0061
            int r5 = (r28 > r13 ? 1 : (r28 == r13 ? 0 : -1))
            if (r5 < 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r5 = 0
            goto L_0x0062
        L_0x0061:
            r5 = r10
        L_0x0062:
            if (r5 != 0) goto L_0x0068
            if (r24 != 0) goto L_0x0070
            r12 = 0
            goto L_0x006a
        L_0x0068:
            r12 = r24
        L_0x006a:
            if (r5 != r12) goto L_0x0076
            int r15 = (r28 > r22 ? 1 : (r28 == r22 ? 0 : -1))
            if (r15 >= 0) goto L_0x0076
        L_0x0070:
            r12 = r5
            r20 = r9
            r25 = r30
            goto L_0x0078
        L_0x0076:
            r28 = r22
        L_0x0078:
            int r15 = (r30 > r18 ? 1 : (r30 == r18 ? 0 : -1))
            if (r15 >= 0) goto L_0x0087
            r21 = r5
            r27 = r9
            r24 = r12
            r22 = r28
            r18 = r30
            goto L_0x008b
        L_0x0087:
            r24 = r12
            r22 = r28
        L_0x008b:
            int r9 = r9 + 1
            goto L_0x0034
        L_0x008e:
            int r5 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x00a1
            if (r21 == 0) goto L_0x00a1
            r15 = 10485760(0xa00000, double:5.180654E-317)
            long r18 = r18 + r15
            int r5 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r5 >= 0) goto L_0x009e
            goto L_0x00a1
        L_0x009e:
            r9 = r27
            goto L_0x00a3
        L_0x00a1:
            r9 = r20
        L_0x00a3:
            r0.zzn = r9
            if (r9 != r8) goto L_0x00ab
            r24 = r8
            goto L_0x01da
        L_0x00ab:
            com.google.android.gms.internal.ads.zzafp[] r5 = r0.zzs
            r5 = r5[r9]
            com.google.android.gms.internal.ads.zzaap r9 = r5.zzc
            int r12 = r5.zze
            com.google.android.gms.internal.ads.zzafy r15 = r5.zzb
            long[] r8 = r15.zzc
            r10 = r8[r12]
            int[] r8 = r15.zzd
            r8 = r8[r12]
            com.google.android.gms.internal.ads.zzaaq r15 = r5.zzd
            long r3 = r10 - r3
            int r13 = r0.zzo
            long r13 = (long) r13
            long r3 = r3 + r13
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x01d6
            r6 = 262144(0x40000, double:1.295163E-318)
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x00d2
            goto L_0x01d6
        L_0x00d2:
            com.google.android.gms.internal.ads.zzafv r2 = r5.zza
            int r2 = r2.zzg
            r6 = 1
            if (r2 != r6) goto L_0x00de
            r6 = 8
            long r3 = r3 + r6
            int r8 = r8 + -8
        L_0x00de:
            int r2 = (int) r3
            r1.zzk(r2)
            com.google.android.gms.internal.ads.zzafv r2 = r5.zza
            int r3 = r2.zzj
            if (r3 == 0) goto L_0x0149
            com.google.android.gms.internal.ads.zzef r2 = r0.zzc
            byte[] r2 = r2.zzH()
            r4 = 0
            r2[r4] = r4
            r6 = 1
            r2[r6] = r4
            r6 = 2
            r2[r6] = r4
            r4 = 4
            int r6 = 4 - r3
        L_0x00fa:
            int r4 = r0.zzp
            if (r4 >= r8) goto L_0x018c
            int r4 = r0.zzq
            if (r4 != 0) goto L_0x0134
            r1.zzi(r2, r6, r3)
            int r4 = r0.zzo
            int r4 = r4 + r3
            r0.zzo = r4
            com.google.android.gms.internal.ads.zzef r4 = r0.zzc
            r7 = 0
            r4.zzF(r7)
            com.google.android.gms.internal.ads.zzef r4 = r0.zzc
            int r4 = r4.zze()
            if (r4 < 0) goto L_0x012c
            r0.zzq = r4
            com.google.android.gms.internal.ads.zzef r4 = r0.zzb
            r4.zzF(r7)
            com.google.android.gms.internal.ads.zzef r4 = r0.zzb
            r10 = 4
            r9.zzq(r4, r10)
            int r4 = r0.zzp
            int r4 = r4 + r10
            r0.zzp = r4
            int r8 = r8 + r6
            goto L_0x00fa
        L_0x012c:
            java.lang.String r1 = "Invalid NAL length"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x0134:
            r7 = 0
            int r4 = r9.zze(r1, r4, r7)
            int r7 = r0.zzo
            int r7 = r7 + r4
            r0.zzo = r7
            int r7 = r0.zzp
            int r7 = r7 + r4
            r0.zzp = r7
            int r7 = r0.zzq
            int r7 = r7 - r4
            r0.zzq = r7
            goto L_0x00fa
        L_0x0149:
            com.google.android.gms.internal.ads.zzaf r2 = r2.zzf
            java.lang.String r2 = r2.zzm
            java.lang.String r3 = "audio/ac4"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x016c
            int r2 = r0.zzp
            if (r2 != 0) goto L_0x0169
            com.google.android.gms.internal.ads.zzef r2 = r0.zzd
            com.google.android.gms.internal.ads.zzym.zzb(r8, r2)
            com.google.android.gms.internal.ads.zzef r2 = r0.zzd
            r3 = 7
            r9.zzq(r2, r3)
            int r2 = r0.zzp
            int r2 = r2 + r3
            r0.zzp = r2
        L_0x0169:
            int r8 = r8 + 7
            goto L_0x0171
        L_0x016c:
            if (r15 == 0) goto L_0x0171
            r15.zzd(r1)
        L_0x0171:
            int r2 = r0.zzp
            if (r2 >= r8) goto L_0x018c
            int r2 = r8 - r2
            r3 = 0
            int r2 = r9.zze(r1, r2, r3)
            int r3 = r0.zzo
            int r3 = r3 + r2
            r0.zzo = r3
            int r3 = r0.zzp
            int r3 = r3 + r2
            r0.zzp = r3
            int r3 = r0.zzq
            int r3 = r3 - r2
            r0.zzq = r3
            goto L_0x0171
        L_0x018c:
            com.google.android.gms.internal.ads.zzafy r1 = r5.zzb
            long[] r2 = r1.zzf
            r3 = r2[r12]
            int[] r1 = r1.zzg
            r1 = r1[r12]
            if (r15 == 0) goto L_0x01b5
            r21 = 0
            r22 = 0
            r2 = r15
            r16 = r9
            r17 = r3
            r19 = r1
            r20 = r8
            r15.zzc(r16, r17, r19, r20, r21, r22)
            r1 = 1
            int r12 = r12 + r1
            com.google.android.gms.internal.ads.zzafy r1 = r5.zzb
            int r1 = r1.zzb
            if (r12 != r1) goto L_0x01c3
            r1 = 0
            r2.zza(r9, r1)
            goto L_0x01c3
        L_0x01b5:
            r20 = 0
            r21 = 0
            r15 = r9
            r16 = r3
            r18 = r1
            r19 = r8
            r15.zzs(r16, r18, r19, r20, r21)
        L_0x01c3:
            int r1 = r5.zze
            r2 = 1
            int r1 = r1 + r2
            r5.zze = r1
            r1 = -1
            r0.zzn = r1
            r1 = 0
            r0.zzo = r1
            r0.zzp = r1
            r0.zzq = r1
            r24 = 0
            goto L_0x01da
        L_0x01d6:
            r2.zza = r10
            r24 = 1
        L_0x01da:
            return r24
        L_0x01db:
            long r5 = r0.zzk
            int r3 = r0.zzl
            long r7 = (long) r3
            long r5 = r5 - r7
            long r7 = r33.zzf()
            long r7 = r7 + r5
            com.google.android.gms.internal.ads.zzef r3 = r0.zzm
            if (r3 == 0) goto L_0x023a
            byte[] r10 = r3.zzH()
            int r11 = r0.zzl
            int r5 = (int) r5
            r1.zzi(r10, r11, r5)
            int r5 = r0.zzj
            if (r5 != r4) goto L_0x021f
            r3.zzF(r9)
            int r4 = r3.zze()
            int r11 = zzf(r4)
            if (r11 == 0) goto L_0x0206
            goto L_0x021c
        L_0x0206:
            r4 = 4
            r3.zzG(r4)
        L_0x020a:
            int r4 = r3.zza()
            if (r4 <= 0) goto L_0x021b
            int r4 = r3.zze()
            int r11 = zzf(r4)
            if (r11 == 0) goto L_0x020a
            goto L_0x021c
        L_0x021b:
            r11 = 0
        L_0x021c:
            r0.zzw = r11
            goto L_0x0245
        L_0x021f:
            java.util.ArrayDeque r4 = r0.zzf
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0245
            java.util.ArrayDeque r4 = r0.zzf
            java.lang.Object r4 = r4.peek()
            com.google.android.gms.internal.ads.zzaev r4 = (com.google.android.gms.internal.ads.zzaev) r4
            com.google.android.gms.internal.ads.zzaew r5 = new com.google.android.gms.internal.ads.zzaew
            int r6 = r0.zzj
            r5.<init>(r6, r3)
            r4.zzd(r5)
            goto L_0x0245
        L_0x023a:
            r3 = 262144(0x40000, double:1.295163E-318)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0248
            int r3 = (int) r5
            r1.zzk(r3)
        L_0x0245:
            r25 = 0
            goto L_0x0251
        L_0x0248:
            long r3 = r33.zzf()
            long r3 = r3 + r5
            r2.zza = r3
            r25 = 1
        L_0x0251:
            r0.zzl(r7)
            if (r25 == 0) goto L_0x0006
            int r3 = r0.zzi
            r4 = 2
            if (r3 == r4) goto L_0x0006
            r3 = 1
            return r3
        L_0x025d:
            r3 = r10
            int r5 = r0.zzl
            if (r5 != 0) goto L_0x0288
            com.google.android.gms.internal.ads.zzef r5 = r0.zze
            byte[] r5 = r5.zzH()
            r8 = 0
            boolean r5 = r1.zzn(r5, r8, r9, r3)
            if (r5 != 0) goto L_0x0271
            r3 = -1
            return r3
        L_0x0271:
            r0.zzl = r9
            com.google.android.gms.internal.ads.zzef r3 = r0.zze
            r3.zzF(r8)
            com.google.android.gms.internal.ads.zzef r3 = r0.zze
            long r10 = r3.zzs()
            r0.zzk = r10
            com.google.android.gms.internal.ads.zzef r3 = r0.zze
            int r3 = r3.zze()
            r0.zzj = r3
        L_0x0288:
            long r10 = r0.zzk
            r12 = 1
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x02a7
            com.google.android.gms.internal.ads.zzef r3 = r0.zze
            byte[] r3 = r3.zzH()
            r1.zzi(r3, r9, r9)
            int r3 = r0.zzl
            int r3 = r3 + r9
            r0.zzl = r3
            com.google.android.gms.internal.ads.zzef r3 = r0.zze
            long r5 = r3.zzt()
            r0.zzk = r5
            goto L_0x02d2
        L_0x02a7:
            int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x02d2
            long r5 = r33.zzd()
            r7 = -1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x02c3
            java.util.ArrayDeque r3 = r0.zzf
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzaev r3 = (com.google.android.gms.internal.ads.zzaev) r3
            if (r3 == 0) goto L_0x02c2
            long r5 = r3.zza
            goto L_0x02c3
        L_0x02c2:
            r5 = r7
        L_0x02c3:
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x02d2
            long r7 = r33.zzf()
            long r5 = r5 - r7
            int r3 = r0.zzl
            long r7 = (long) r3
            long r5 = r5 + r7
            r0.zzk = r5
        L_0x02d2:
            long r5 = r0.zzk
            int r3 = r0.zzl
            long r7 = (long) r3
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x040f
            int r5 = r0.zzj
            r6 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r5 == r6) goto L_0x03bd
            r6 = 1953653099(0x7472616b, float:7.681346E31)
            if (r5 == r6) goto L_0x03bd
            r6 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r5 == r6) goto L_0x03bd
            r6 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r5 == r6) goto L_0x03bd
            r6 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r5 == r6) goto L_0x03bd
            r6 = 1701082227(0x65647473, float:6.742798E22)
            if (r5 == r6) goto L_0x03bd
            if (r5 != r7) goto L_0x0302
            goto L_0x03bd
        L_0x0302:
            r6 = 1835296868(0x6d646864, float:4.418049E27)
            if (r5 == r6) goto L_0x0389
            r6 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r5 == r6) goto L_0x0389
            r6 = 1751411826(0x68646c72, float:4.3148E24)
            if (r5 == r6) goto L_0x0389
            r6 = 1937011556(0x73747364, float:1.9367383E31)
            if (r5 == r6) goto L_0x0389
            r6 = 1937011827(0x73747473, float:1.9367711E31)
            if (r5 == r6) goto L_0x0389
            r6 = 1937011571(0x73747373, float:1.9367401E31)
            if (r5 == r6) goto L_0x0389
            r6 = 1668576371(0x63747473, float:4.5093966E21)
            if (r5 == r6) goto L_0x0389
            r6 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r5 == r6) goto L_0x0389
            r6 = 1937011555(0x73747363, float:1.9367382E31)
            if (r5 == r6) goto L_0x0389
            r6 = 1937011578(0x7374737a, float:1.936741E31)
            if (r5 == r6) goto L_0x0389
            r6 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r5 == r6) goto L_0x0389
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r5 == r6) goto L_0x0389
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r5 == r6) goto L_0x0389
            r6 = 1953196132(0x746b6864, float:7.46037E31)
            if (r5 == r6) goto L_0x0389
            if (r5 == r4) goto L_0x0389
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            if (r5 == r4) goto L_0x0389
            r4 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r5 == r4) goto L_0x0389
            r4 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r5 != r4) goto L_0x035a
            goto L_0x0389
        L_0x035a:
            long r3 = r33.zzf()
            int r5 = r0.zzl
            long r5 = (long) r5
            long r10 = r3 - r5
            int r3 = r0.zzj
            r4 = 1836086884(0x6d707664, float:4.6512205E27)
            if (r3 != r4) goto L_0x0381
            com.google.android.gms.internal.ads.zzadt r3 = new com.google.android.gms.internal.ads.zzadt
            r8 = 0
            long r14 = r10 + r5
            long r12 = r0.zzk
            long r4 = r12 - r5
            r7 = r3
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r16 = r4
            r7.<init>(r8, r10, r12, r14, r16)
            r0.zzx = r3
        L_0x0381:
            r3 = 0
            r0.zzm = r3
            r3 = 1
            r0.zzi = r3
            goto L_0x0006
        L_0x0389:
            if (r3 != r9) goto L_0x038d
            r3 = 1
            goto L_0x038e
        L_0x038d:
            r3 = 0
        L_0x038e:
            com.google.android.gms.internal.ads.zzdd.zzf(r3)
            long r3 = r0.zzk
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x039c
            r3 = 1
            goto L_0x039d
        L_0x039c:
            r3 = 0
        L_0x039d:
            com.google.android.gms.internal.ads.zzdd.zzf(r3)
            com.google.android.gms.internal.ads.zzef r3 = new com.google.android.gms.internal.ads.zzef
            long r4 = r0.zzk
            int r4 = (int) r4
            r3.<init>((int) r4)
            com.google.android.gms.internal.ads.zzef r4 = r0.zze
            byte[] r4 = r4.zzH()
            byte[] r5 = r3.zzH()
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r5, r6, r9)
            r0.zzm = r3
            r3 = 1
            r0.zzi = r3
            goto L_0x0006
        L_0x03bd:
            long r3 = r33.zzf()
            long r5 = r0.zzk
            int r8 = r0.zzl
            long r10 = (long) r8
            long r3 = r3 + r5
            long r3 = r3 - r10
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x03f0
            int r5 = r0.zzj
            if (r5 != r7) goto L_0x03f0
            com.google.android.gms.internal.ads.zzef r5 = r0.zzd
            r5.zzC(r9)
            com.google.android.gms.internal.ads.zzef r5 = r0.zzd
            byte[] r5 = r5.zzH()
            r6 = 0
            r1.zzh(r5, r6, r9)
            com.google.android.gms.internal.ads.zzef r5 = r0.zzd
            com.google.android.gms.internal.ads.zzaff.zzd(r5)
            com.google.android.gms.internal.ads.zzef r5 = r0.zzd
            int r5 = r5.zzc()
            r1.zzk(r5)
            r33.zzj()
        L_0x03f0:
            java.util.ArrayDeque r5 = r0.zzf
            com.google.android.gms.internal.ads.zzaev r6 = new com.google.android.gms.internal.ads.zzaev
            int r7 = r0.zzj
            r6.<init>(r7, r3)
            r5.push(r6)
            long r5 = r0.zzk
            int r7 = r0.zzl
            long r7 = (long) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x040a
            r0.zzl(r3)
            goto L_0x0006
        L_0x040a:
            r32.zzk()
            goto L_0x0006
        L_0x040f:
            java.lang.String r1 = "Atom size less than header length (unsupported)."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zzc(r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafq.zza(com.google.android.gms.internal.ads.zzzj, com.google.android.gms.internal.ads.zzaai):int");
    }
}
