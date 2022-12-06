package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzabc implements zzzi {
    private final zzef zza = new zzef(12);
    private final zzabb zzb = new zzabb((zzaba) null);
    private int zzc;
    private zzzl zzd = new zzzg();
    private zzabd zze;
    private long zzf = C.TIME_UNSET;
    /* access modifiers changed from: private */
    public zzabf[] zzg = new zzabf[0];
    private long zzh;
    private zzabf zzi;
    private int zzj = -1;
    private long zzk = -1;
    private long zzl = -1;
    private int zzm;
    private boolean zzn;

    private final zzabf zzf(int i) {
        for (zzabf zzabf : this.zzg) {
            if (zzabf.zzg(i)) {
                return zzabf;
            }
        }
        return null;
    }

    public final void zzb(zzzl zzzl) {
        this.zzc = 0;
        this.zzd = zzzl;
        this.zzh = -1;
    }

    public final void zzc(long j, long j2) {
        int i;
        this.zzh = -1;
        this.zzi = null;
        for (zzabf zzf2 : this.zzg) {
            zzf2.zzf(j);
        }
        if (j != 0) {
            i = 6;
        } else if (this.zzg.length == 0) {
            this.zzc = 0;
            return;
        } else {
            i = 3;
        }
        this.zzc = i;
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        ((zzyy) zzzj).zzm(this.zza.zzH(), 0, 12, false);
        this.zza.zzF(0);
        if (this.zza.zzg() != 1179011410) {
            return false;
        }
        this.zza.zzG(4);
        if (this.zza.zzg() == 541677121) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzzj r24, com.google.android.gms.internal.ads.zzaai r25) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            long r2 = r0.zzh
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L_0x002e
            long r9 = r24.zzf()
            int r6 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r6 < 0) goto L_0x0028
            r11 = 262144(0x40000, double:1.295163E-318)
            long r11 = r11 + r9
            int r6 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x001f
            goto L_0x0028
        L_0x001f:
            r6 = r1
            com.google.android.gms.internal.ads.zzyy r6 = (com.google.android.gms.internal.ads.zzyy) r6
            long r2 = r2 - r9
            int r2 = (int) r2
            r6.zzo(r2, r8)
            goto L_0x002e
        L_0x0028:
            r6 = r25
            r6.zza = r2
            r2 = r7
            goto L_0x002f
        L_0x002e:
            r2 = r8
        L_0x002f:
            r0.zzh = r4
            if (r2 == 0) goto L_0x0034
            return r7
        L_0x0034:
            int r2 = r0.zzc
            r3 = 12
            r6 = 0
            if (r2 == 0) goto L_0x03aa
            r9 = 1819436136(0x6c726468, float:1.1721368E27)
            r10 = 1414744396(0x5453494c, float:3.62987127E12)
            r11 = 2
            if (r2 == r7) goto L_0x034e
            r12 = 3
            if (r2 == r11) goto L_0x0224
            r9 = 4
            r13 = 0
            r15 = 8
            r11 = 16
            if (r2 == r12) goto L_0x0192
            r4 = 5
            r5 = 8
            if (r2 == r9) goto L_0x0162
            if (r2 == r4) goto L_0x00e6
            long r11 = r24.zzf()
            long r13 = r0.zzl
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x0064
            r8 = -1
            goto L_0x00e5
        L_0x0064:
            com.google.android.gms.internal.ads.zzabf r2 = r0.zzi
            if (r2 == 0) goto L_0x0073
            boolean r1 = r2.zzh(r1)
            if (r1 != 0) goto L_0x0070
            goto L_0x00e5
        L_0x0070:
            r0.zzi = r6
            return r8
        L_0x0073:
            long r11 = r24.zzf()
            r13 = 1
            long r11 = r11 & r13
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x0084
            r2 = r1
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            r2.zzo(r7, r8)
        L_0x0084:
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            byte[] r2 = r2.zzH()
            r4 = r1
            com.google.android.gms.internal.ads.zzyy r4 = (com.google.android.gms.internal.ads.zzyy) r4
            r4.zzm(r2, r8, r3, r8)
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            r2.zzF(r8)
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            int r2 = r2.zzg()
            if (r2 != r10) goto L_0x00b6
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            r2.zzF(r5)
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            int r2 = r2.zzg()
            r6 = 1769369453(0x69766f6d, float:1.8620122E25)
            if (r2 != r6) goto L_0x00ae
            goto L_0x00af
        L_0x00ae:
            r3 = r5
        L_0x00af:
            r4.zzo(r3, r8)
            r24.zzj()
            goto L_0x00e5
        L_0x00b6:
            com.google.android.gms.internal.ads.zzef r3 = r0.zza
            int r3 = r3.zzg()
            r6 = 1263424842(0x4b4e554a, float:1.352225E7)
            if (r2 != r6) goto L_0x00cb
            long r1 = r24.zzf()
            long r3 = (long) r3
            long r1 = r1 + r3
            long r1 = r1 + r15
            r0.zzh = r1
            goto L_0x00e5
        L_0x00cb:
            r4.zzo(r5, r8)
            r24.zzj()
            com.google.android.gms.internal.ads.zzabf r2 = r0.zzf(r2)
            if (r2 != 0) goto L_0x00e0
            long r1 = r24.zzf()
            long r3 = (long) r3
            long r1 = r1 + r3
            r0.zzh = r1
            goto L_0x00e5
        L_0x00e0:
            r2.zze(r3)
            r0.zzi = r2
        L_0x00e5:
            return r8
        L_0x00e6:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            int r3 = r0.zzm
            r2.<init>((int) r3)
            byte[] r3 = r2.zzH()
            int r4 = r0.zzm
            com.google.android.gms.internal.ads.zzyy r1 = (com.google.android.gms.internal.ads.zzyy) r1
            r1.zzn(r3, r8, r4, r8)
            int r1 = r2.zza()
            if (r1 >= r11) goto L_0x00ff
            goto L_0x0117
        L_0x00ff:
            int r1 = r2.zzc()
            r2.zzG(r5)
            int r3 = r2.zzg()
            long r4 = r0.zzk
            long r9 = (long) r3
            int r3 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0112
            goto L_0x0114
        L_0x0112:
            long r4 = r4 + r15
            r13 = r4
        L_0x0114:
            r2.zzF(r1)
        L_0x0117:
            int r1 = r2.zza()
            if (r1 < r11) goto L_0x013e
            int r1 = r2.zzg()
            int r3 = r2.zzg()
            int r4 = r2.zzg()
            long r4 = (long) r4
            long r4 = r4 + r13
            r2.zzg()
            com.google.android.gms.internal.ads.zzabf r1 = r0.zzf(r1)
            if (r1 == 0) goto L_0x0117
            r3 = r3 & r11
            if (r3 != r11) goto L_0x013a
            r1.zzb(r4)
        L_0x013a:
            r1.zzd()
            goto L_0x0117
        L_0x013e:
            com.google.android.gms.internal.ads.zzabf[] r1 = r0.zzg
            int r2 = r1.length
            r3 = r8
        L_0x0142:
            if (r3 >= r2) goto L_0x014c
            r4 = r1[r3]
            r4.zzc()
            int r3 = r3 + 1
            goto L_0x0142
        L_0x014c:
            r0.zzn = r7
            com.google.android.gms.internal.ads.zzzl r1 = r0.zzd
            com.google.android.gms.internal.ads.zzaaz r2 = new com.google.android.gms.internal.ads.zzaaz
            long r3 = r0.zzf
            r2.<init>(r0, r3)
            r1.zzN(r2)
            r1 = 6
            r0.zzc = r1
            long r1 = r0.zzk
            r0.zzh = r1
            return r8
        L_0x0162:
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            byte[] r2 = r2.zzH()
            r3 = r1
            com.google.android.gms.internal.ads.zzyy r3 = (com.google.android.gms.internal.ads.zzyy) r3
            r3.zzn(r2, r8, r5, r8)
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            r2.zzF(r8)
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            int r2 = r2.zzg()
            com.google.android.gms.internal.ads.zzef r3 = r0.zza
            int r3 = r3.zzg()
            r5 = 829973609(0x31786469, float:3.6145826E-9)
            if (r2 != r5) goto L_0x0189
            r0.zzc = r4
            r0.zzm = r3
            goto L_0x0191
        L_0x0189:
            long r1 = r24.zzf()
            long r3 = (long) r3
            long r1 = r1 + r3
            r0.zzh = r1
        L_0x0191:
            return r8
        L_0x0192:
            long r6 = r0.zzk
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x01a4
            long r4 = r24.zzf()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x01a1
            goto L_0x01a4
        L_0x01a1:
            r0.zzh = r6
            return r8
        L_0x01a4:
            com.google.android.gms.internal.ads.zzef r4 = r0.zza
            byte[] r4 = r4.zzH()
            r5 = r1
            com.google.android.gms.internal.ads.zzyy r5 = (com.google.android.gms.internal.ads.zzyy) r5
            r5.zzm(r4, r8, r3, r8)
            r24.zzj()
            com.google.android.gms.internal.ads.zzef r4 = r0.zza
            r4.zzF(r8)
            com.google.android.gms.internal.ads.zzabb r4 = r0.zzb
            com.google.android.gms.internal.ads.zzef r6 = r0.zza
            r4.zza(r6)
            com.google.android.gms.internal.ads.zzef r4 = r0.zza
            int r4 = r4.zzg()
            com.google.android.gms.internal.ads.zzabb r6 = r0.zzb
            int r7 = r6.zza
            r12 = 1179011410(0x46464952, float:12690.33)
            if (r7 != r12) goto L_0x01d2
            r5.zzo(r3, r8)
            return r8
        L_0x01d2:
            if (r7 != r10) goto L_0x0218
            r3 = 1769369453(0x69766f6d, float:1.8620122E25)
            if (r4 == r3) goto L_0x01da
            goto L_0x0218
        L_0x01da:
            long r3 = r24.zzf()
            r0.zzk = r3
            int r5 = r6.zzb
            long r5 = (long) r5
            long r3 = r3 + r5
            long r3 = r3 + r15
            r0.zzl = r3
            boolean r5 = r0.zzn
            if (r5 != 0) goto L_0x020b
            com.google.android.gms.internal.ads.zzabd r5 = r0.zze
            if (r5 == 0) goto L_0x0209
            int r5 = r5.zzb
            r5 = r5 & r11
            if (r5 == r11) goto L_0x0204
            com.google.android.gms.internal.ads.zzzl r3 = r0.zzd
            com.google.android.gms.internal.ads.zzaak r4 = new com.google.android.gms.internal.ads.zzaak
            long r5 = r0.zzf
            r4.<init>(r5, r13)
            r3.zzN(r4)
            r2 = 1
            r0.zzn = r2
            goto L_0x020b
        L_0x0204:
            r0.zzc = r9
            r0.zzh = r3
            return r8
        L_0x0209:
            r1 = 0
            throw r1
        L_0x020b:
            long r1 = r24.zzf()
            r3 = 12
            long r1 = r1 + r3
            r0.zzh = r1
            r1 = 6
            r0.zzc = r1
            return r8
        L_0x0218:
            long r1 = r24.zzf()
            int r3 = r6.zzb
            long r3 = (long) r3
            long r1 = r1 + r3
            long r1 = r1 + r15
            r0.zzh = r1
            return r8
        L_0x0224:
            int r3 = r0.zzj
            int r3 = r3 + -4
            com.google.android.gms.internal.ads.zzef r4 = new com.google.android.gms.internal.ads.zzef
            r4.<init>((int) r3)
            byte[] r5 = r4.zzH()
            com.google.android.gms.internal.ads.zzyy r1 = (com.google.android.gms.internal.ads.zzyy) r1
            r1.zzn(r5, r8, r3, r8)
            com.google.android.gms.internal.ads.zzabg r1 = com.google.android.gms.internal.ads.zzabg.zzc(r9, r4)
            int r3 = r1.zza()
            if (r3 != r9) goto L_0x0333
            java.lang.Class<com.google.android.gms.internal.ads.zzabd> r3 = com.google.android.gms.internal.ads.zzabd.class
            com.google.android.gms.internal.ads.zzaay r3 = r1.zzb(r3)
            com.google.android.gms.internal.ads.zzabd r3 = (com.google.android.gms.internal.ads.zzabd) r3
            if (r3 == 0) goto L_0x032b
            r0.zze = r3
            int r4 = r3.zzc
            long r4 = (long) r4
            int r3 = r3.zza
            long r6 = (long) r3
            long r4 = r4 * r6
            r0.zzf = r4
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.google.android.gms.internal.ads.zzfvn r1 = r1.zza
            int r4 = r1.size()
            r5 = r8
            r14 = r5
        L_0x0262:
            if (r5 >= r4) goto L_0x0317
            java.lang.Object r6 = r1.get(r5)
            com.google.android.gms.internal.ads.zzaay r6 = (com.google.android.gms.internal.ads.zzaay) r6
            int r7 = r6.zza()
            r9 = 1819440243(0x6c727473, float:1.17243986E27)
            if (r7 != r9) goto L_0x0310
            com.google.android.gms.internal.ads.zzabg r6 = (com.google.android.gms.internal.ads.zzabg) r6
            int r7 = r14 + 1
            java.lang.Class<com.google.android.gms.internal.ads.zzabe> r9 = com.google.android.gms.internal.ads.zzabe.class
            com.google.android.gms.internal.ads.zzaay r9 = r6.zzb(r9)
            com.google.android.gms.internal.ads.zzabe r9 = (com.google.android.gms.internal.ads.zzabe) r9
            java.lang.Class<com.google.android.gms.internal.ads.zzabh> r10 = com.google.android.gms.internal.ads.zzabh.class
            com.google.android.gms.internal.ads.zzaay r10 = r6.zzb(r10)
            com.google.android.gms.internal.ads.zzabh r10 = (com.google.android.gms.internal.ads.zzabh) r10
            if (r9 != 0) goto L_0x0295
            java.lang.String r6 = "AviExtractor"
            java.lang.String r9 = "Missing Stream Header"
            com.google.android.gms.internal.ads.zzdw.zze(r6, r9)
        L_0x0290:
            r24 = r3
        L_0x0292:
            r3 = 0
            goto L_0x0304
        L_0x0295:
            if (r10 != 0) goto L_0x029f
            java.lang.String r6 = "AviExtractor"
            java.lang.String r9 = "Missing Stream Format"
            com.google.android.gms.internal.ads.zzdw.zze(r6, r9)
            goto L_0x0290
        L_0x029f:
            int r13 = r9.zzd
            long r12 = (long) r13
            int r15 = r9.zzb
            r24 = r3
            long r2 = (long) r15
            r15 = 1000000(0xf4240, double:4.940656E-318)
            long r17 = r2 * r15
            int r2 = r9.zzc
            long r2 = (long) r2
            r15 = r12
            r19 = r2
            long r12 = com.google.android.gms.internal.ads.zzen.zzw(r15, r17, r19)
            com.google.android.gms.internal.ads.zzaf r2 = r10.zza
            com.google.android.gms.internal.ads.zzad r3 = r2.zzb()
            r3.zzG(r14)
            int r10 = r9.zze
            if (r10 == 0) goto L_0x02c6
            r3.zzL(r10)
        L_0x02c6:
            java.lang.Class<com.google.android.gms.internal.ads.zzabi> r10 = com.google.android.gms.internal.ads.zzabi.class
            com.google.android.gms.internal.ads.zzaay r6 = r6.zzb(r10)
            com.google.android.gms.internal.ads.zzabi r6 = (com.google.android.gms.internal.ads.zzabi) r6
            if (r6 == 0) goto L_0x02d5
            java.lang.String r6 = r6.zza
            r3.zzJ(r6)
        L_0x02d5:
            java.lang.String r2 = r2.zzm
            int r6 = com.google.android.gms.internal.ads.zzbt.zzb(r2)
            r2 = 1
            if (r6 == r2) goto L_0x02e2
            if (r6 != r11) goto L_0x0292
            r15 = r11
            goto L_0x02e3
        L_0x02e2:
            r15 = r6
        L_0x02e3:
            com.google.android.gms.internal.ads.zzzl r6 = r0.zzd
            com.google.android.gms.internal.ads.zzaap r6 = r6.zzv(r14, r15)
            com.google.android.gms.internal.ads.zzaf r3 = r3.zzY()
            r6.zzk(r3)
            com.google.android.gms.internal.ads.zzabf r3 = new com.google.android.gms.internal.ads.zzabf
            int r9 = r9.zzd
            r21 = r12
            r13 = r3
            r16 = r21
            r18 = r9
            r19 = r6
            r13.<init>(r14, r15, r16, r18, r19)
            r9 = r21
            r0.zzf = r9
        L_0x0304:
            if (r3 == 0) goto L_0x030c
            r6 = r24
            r6.add(r3)
            goto L_0x030e
        L_0x030c:
            r6 = r24
        L_0x030e:
            r14 = r7
            goto L_0x0311
        L_0x0310:
            r6 = r3
        L_0x0311:
            int r5 = r5 + 1
            r3 = r6
            r12 = 3
            goto L_0x0262
        L_0x0317:
            r6 = r3
            com.google.android.gms.internal.ads.zzabf[] r1 = new com.google.android.gms.internal.ads.zzabf[r8]
            java.lang.Object[] r1 = r6.toArray(r1)
            com.google.android.gms.internal.ads.zzabf[] r1 = (com.google.android.gms.internal.ads.zzabf[]) r1
            r0.zzg = r1
            com.google.android.gms.internal.ads.zzzl r1 = r0.zzd
            r1.zzC()
            r1 = 3
            r0.zzc = r1
            return r8
        L_0x032b:
            java.lang.String r1 = "AviHeader not found"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x0333:
            r2 = 0
            int r1 = r1.zza()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unexpected header list type "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x034e:
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            byte[] r2 = r2.zzH()
            com.google.android.gms.internal.ads.zzyy r1 = (com.google.android.gms.internal.ads.zzyy) r1
            r1.zzn(r2, r8, r3, r8)
            com.google.android.gms.internal.ads.zzef r1 = r0.zza
            r1.zzF(r8)
            com.google.android.gms.internal.ads.zzabb r1 = r0.zzb
            com.google.android.gms.internal.ads.zzef r2 = r0.zza
            r1.zza(r2)
            int r3 = r1.zza
            if (r3 != r10) goto L_0x0393
            int r2 = r2.zzg()
            r1.zzc = r2
            com.google.android.gms.internal.ads.zzabb r1 = r0.zzb
            int r2 = r1.zzc
            if (r2 != r9) goto L_0x037c
            int r1 = r1.zzb
            r0.zzj = r1
            r0.zzc = r11
            return r8
        L_0x037c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "hdrl expected, found: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r4 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r4)
            throw r1
        L_0x0393:
            r4 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "LIST expected, found: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r4)
            throw r1
        L_0x03aa:
            r4 = r6
            boolean r5 = r23.zzd(r24)
            if (r5 == 0) goto L_0x03ba
            com.google.android.gms.internal.ads.zzyy r1 = (com.google.android.gms.internal.ads.zzyy) r1
            r1.zzo(r3, r8)
            r1 = 1
            r0.zzc = r1
            return r8
        L_0x03ba:
            java.lang.String r1 = "AVI Header List not found"
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabc.zza(com.google.android.gms.internal.ads.zzzj, com.google.android.gms.internal.ads.zzaai):int");
    }
}
