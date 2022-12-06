package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzabr implements zzzi {
    public static final zzzp zza = zzabq.zza;
    private final zzef zzb = new zzef(4);
    private final zzef zzc = new zzef(9);
    private final zzef zzd = new zzef(11);
    private final zzef zze = new zzef();
    private final zzabs zzf = new zzabs();
    private zzzl zzg;
    private int zzh = 1;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private boolean zzo;
    private zzabp zzp;
    private zzabv zzq;

    private final zzef zze(zzzj zzzj) throws IOException {
        if (this.zzm > this.zze.zzb()) {
            zzef zzef = this.zze;
            int zzb2 = zzef.zzb();
            zzef.zzD(new byte[Math.max(zzb2 + zzb2, this.zzm)], 0);
        } else {
            this.zze.zzF(0);
        }
        this.zze.zzE(this.zzm);
        ((zzyy) zzzj).zzn(this.zze.zzH(), 0, this.zzm, false);
        return this.zze;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzf() {
        if (!this.zzo) {
            this.zzg.zzN(new zzaak(C.TIME_UNSET, 0));
            this.zzo = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzzj r17, com.google.android.gms.internal.ads.zzaai r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zzzl r2 = r0.zzg
            com.google.android.gms.internal.ads.zzdd.zzb(r2)
        L_0x0009:
            int r2 = r0.zzh
            r3 = -1
            r4 = 8
            r5 = 9
            r6 = 2
            r7 = 4
            r8 = 0
            r9 = 1
            if (r2 == r9) goto L_0x011e
            r10 = 3
            if (r2 == r6) goto L_0x0110
            if (r2 == r10) goto L_0x00c9
            if (r2 != r7) goto L_0x00c3
            boolean r2 = r0.zzi
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x002c
            long r2 = r0.zzj
            long r14 = r0.zzn
            long r2 = r2 + r14
            goto L_0x003b
        L_0x002c:
            com.google.android.gms.internal.ads.zzabs r2 = r0.zzf
            long r2 = r2.zzc()
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0039
            r2 = 0
            goto L_0x003b
        L_0x0039:
            long r2 = r0.zzn
        L_0x003b:
            int r14 = r0.zzl
            if (r14 != r4) goto L_0x0053
            com.google.android.gms.internal.ads.zzabp r14 = r0.zzp
            if (r14 == 0) goto L_0x0052
            r16.zzf()
            com.google.android.gms.internal.ads.zzabp r4 = r0.zzp
            com.google.android.gms.internal.ads.zzef r5 = r16.zze(r17)
            boolean r2 = r4.zzf(r5, r2)
        L_0x0050:
            r3 = r9
            goto L_0x00a2
        L_0x0052:
            r14 = r4
        L_0x0053:
            if (r14 != r5) goto L_0x0067
            com.google.android.gms.internal.ads.zzabv r4 = r0.zzq
            if (r4 == 0) goto L_0x0098
            r16.zzf()
            com.google.android.gms.internal.ads.zzabv r4 = r0.zzq
            com.google.android.gms.internal.ads.zzef r5 = r16.zze(r17)
            boolean r2 = r4.zzf(r5, r2)
            goto L_0x0050
        L_0x0067:
            r4 = 18
            if (r14 != r4) goto L_0x0098
            boolean r4 = r0.zzo
            if (r4 != 0) goto L_0x0098
            com.google.android.gms.internal.ads.zzabs r4 = r0.zzf
            com.google.android.gms.internal.ads.zzef r5 = r16.zze(r17)
            boolean r2 = r4.zzf(r5, r2)
            com.google.android.gms.internal.ads.zzabs r3 = r0.zzf
            long r4 = r3.zzc()
            int r14 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x0050
            com.google.android.gms.internal.ads.zzzl r14 = r0.zzg
            com.google.android.gms.internal.ads.zzaaa r15 = new com.google.android.gms.internal.ads.zzaaa
            long[] r10 = r3.zzd()
            long[] r3 = r3.zze()
            r15.<init>(r10, r3, r4)
            r14.zzN(r15)
            r0.zzo = r9
            goto L_0x0050
        L_0x0098:
            int r2 = r0.zzm
            r3 = r1
            com.google.android.gms.internal.ads.zzyy r3 = (com.google.android.gms.internal.ads.zzyy) r3
            r3.zzo(r2, r8)
            r2 = r8
            r3 = r2
        L_0x00a2:
            boolean r4 = r0.zzi
            if (r4 != 0) goto L_0x00bc
            if (r2 == 0) goto L_0x00bc
            r0.zzi = r9
            com.google.android.gms.internal.ads.zzabs r2 = r0.zzf
            long r4 = r2.zzc()
            int r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00b8
            long r4 = r0.zzn
            long r10 = -r4
            goto L_0x00ba
        L_0x00b8:
            r10 = 0
        L_0x00ba:
            r0.zzj = r10
        L_0x00bc:
            r0.zzk = r7
            r0.zzh = r6
            if (r3 == 0) goto L_0x0009
            return r8
        L_0x00c3:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00c9:
            com.google.android.gms.internal.ads.zzef r2 = r0.zzd
            byte[] r2 = r2.zzH()
            r4 = 11
            boolean r2 = r1.zzn(r2, r8, r4, r9)
            if (r2 != 0) goto L_0x00d8
            return r3
        L_0x00d8:
            com.google.android.gms.internal.ads.zzef r2 = r0.zzd
            r2.zzF(r8)
            com.google.android.gms.internal.ads.zzef r2 = r0.zzd
            int r2 = r2.zzk()
            r0.zzl = r2
            com.google.android.gms.internal.ads.zzef r2 = r0.zzd
            int r2 = r2.zzm()
            r0.zzm = r2
            com.google.android.gms.internal.ads.zzef r2 = r0.zzd
            int r2 = r2.zzm()
            long r2 = (long) r2
            r0.zzn = r2
            com.google.android.gms.internal.ads.zzef r2 = r0.zzd
            int r2 = r2.zzk()
            int r2 = r2 << 24
            long r2 = (long) r2
            long r4 = r0.zzn
            long r2 = r2 | r4
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            r0.zzn = r2
            com.google.android.gms.internal.ads.zzef r2 = r0.zzd
            r2.zzG(r10)
            r0.zzh = r7
            goto L_0x0009
        L_0x0110:
            int r2 = r0.zzk
            r3 = r1
            com.google.android.gms.internal.ads.zzyy r3 = (com.google.android.gms.internal.ads.zzyy) r3
            r3.zzo(r2, r8)
            r0.zzk = r8
            r0.zzh = r10
            goto L_0x0009
        L_0x011e:
            com.google.android.gms.internal.ads.zzef r2 = r0.zzc
            byte[] r2 = r2.zzH()
            boolean r2 = r1.zzn(r2, r8, r5, r9)
            if (r2 != 0) goto L_0x012b
            return r3
        L_0x012b:
            com.google.android.gms.internal.ads.zzef r2 = r0.zzc
            r2.zzF(r8)
            com.google.android.gms.internal.ads.zzef r2 = r0.zzc
            r2.zzG(r7)
            com.google.android.gms.internal.ads.zzef r2 = r0.zzc
            int r2 = r2.zzk()
            r3 = r2 & 1
            r2 = r2 & r7
            if (r2 == 0) goto L_0x0151
            com.google.android.gms.internal.ads.zzabp r2 = r0.zzp
            if (r2 != 0) goto L_0x0151
            com.google.android.gms.internal.ads.zzabp r2 = new com.google.android.gms.internal.ads.zzabp
            com.google.android.gms.internal.ads.zzzl r7 = r0.zzg
            com.google.android.gms.internal.ads.zzaap r4 = r7.zzv(r4, r9)
            r2.<init>(r4)
            r0.zzp = r2
        L_0x0151:
            if (r3 == 0) goto L_0x0164
            com.google.android.gms.internal.ads.zzabv r2 = r0.zzq
            if (r2 != 0) goto L_0x0164
            com.google.android.gms.internal.ads.zzabv r2 = new com.google.android.gms.internal.ads.zzabv
            com.google.android.gms.internal.ads.zzzl r3 = r0.zzg
            com.google.android.gms.internal.ads.zzaap r3 = r3.zzv(r5, r6)
            r2.<init>(r3)
            r0.zzq = r2
        L_0x0164:
            com.google.android.gms.internal.ads.zzzl r2 = r0.zzg
            r2.zzC()
            com.google.android.gms.internal.ads.zzef r2 = r0.zzc
            int r2 = r2.zze()
            int r2 = r2 + -5
            r0.zzk = r2
            r0.zzh = r6
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabr.zza(com.google.android.gms.internal.ads.zzzj, com.google.android.gms.internal.ads.zzaai):int");
    }

    public final void zzb(zzzl zzzl) {
        this.zzg = zzzl;
    }

    public final void zzc(long j, long j2) {
        if (j == 0) {
            this.zzh = 1;
            this.zzi = false;
        } else {
            this.zzh = 3;
        }
        this.zzk = 0;
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        zzyy zzyy = (zzyy) zzzj;
        zzyy.zzm(this.zzb.zzH(), 0, 3, false);
        this.zzb.zzF(0);
        if (this.zzb.zzm() != 4607062) {
            return false;
        }
        zzyy.zzm(this.zzb.zzH(), 0, 2, false);
        this.zzb.zzF(0);
        if ((this.zzb.zzo() & 250) != 0) {
            return false;
        }
        zzyy.zzm(this.zzb.zzH(), 0, 4, false);
        this.zzb.zzF(0);
        int zze2 = this.zzb.zze();
        zzzj.zzj();
        zzyy.zzl(zze2, false);
        zzyy.zzm(this.zzb.zzH(), 0, 4, false);
        this.zzb.zzF(0);
        if (this.zzb.zze() == 0) {
            return true;
        }
        return false;
    }
}
