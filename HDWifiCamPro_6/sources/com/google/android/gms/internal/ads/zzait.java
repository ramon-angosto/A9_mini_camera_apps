package com.google.android.gms.internal.ads;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzait implements zzaiu {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, TTAdConstant.DOWNLOAD_URL_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, IronSourceError.ERROR_DO_RV_LOAD_MISSING_ACTIVITY, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzzl zzc;
    private final zzaap zzd;
    private final zzaix zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzef zzh;
    private final int zzi;
    private final zzaf zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzait(zzzl zzzl, zzaap zzaap, zzaix zzaix) throws zzbu {
        this.zzc = zzzl;
        this.zzd = zzaap;
        this.zze = zzaix;
        this.zzi = Math.max(1, zzaix.zzc / 10);
        zzef zzef = new zzef(zzaix.zzf);
        zzef.zzi();
        int zzi2 = zzef.zzi();
        this.zzf = zzi2;
        int i = zzaix.zzb;
        int i2 = (((zzaix.zzd - (i * 4)) * 8) / (zzaix.zze * i)) + 1;
        if (zzi2 == i2) {
            int zze2 = zzen.zze(this.zzi, zzi2);
            this.zzg = new byte[(zzaix.zzd * zze2)];
            int i3 = this.zzf;
            this.zzh = new zzef(zze2 * (i3 + i3) * i);
            int i4 = ((zzaix.zzc * zzaix.zzd) * 8) / this.zzf;
            zzad zzad = new zzad();
            zzad.zzS(MimeTypes.AUDIO_RAW);
            zzad.zzv(i4);
            zzad.zzO(i4);
            int i5 = this.zzi;
            zzad.zzL((i5 + i5) * i);
            zzad.zzw(zzaix.zzb);
            zzad.zzT(zzaix.zzc);
            zzad.zzN(2);
            this.zzj = zzad.zzY();
            return;
        }
        throw zzbu.zza("Expected frames per block: " + i2 + "; got: " + zzi2, (Throwable) null);
    }

    private final int zzd(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zze(int i) {
        return (i + i) * this.zze.zzb;
    }

    private final void zzf(int i) {
        long j = this.zzl;
        long zzw = zzen.zzw(this.zzn, 1000000, (long) this.zze.zzc);
        int zze2 = zze(i);
        this.zzd.zzs(j + zzw, 1, zze2, this.zzm - zze2, (zzaao) null);
        this.zzn += (long) i;
        this.zzm -= zze2;
    }

    public final void zza(int i, long j) {
        this.zzc.zzN(new zzaja(this.zze, this.zzf, (long) i, j));
        this.zzd.zzk(this.zzj);
    }

    public final void zzb(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0043 A[EDGE_INSN: B:38:0x0043->B:10:0x0043 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0023  */
    public final boolean zzc(com.google.android.gms.internal.ads.zzzj r20, long r21) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            int r3 = r0.zzi
            int r4 = r0.zzm
            int r4 = r0.zzd(r4)
            int r3 = r3 - r4
            int r4 = r0.zzf
            int r3 = com.google.android.gms.internal.ads.zzen.zze(r3, r4)
            com.google.android.gms.internal.ads.zzaix r4 = r0.zze
            int r4 = r4.zzd
            int r3 = r3 * r4
            r4 = 0
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0020
        L_0x001e:
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r4 != 0) goto L_0x0043
            int r7 = r0.zzk
            if (r7 >= r3) goto L_0x0043
            int r7 = r3 - r7
            long r7 = (long) r7
            long r7 = java.lang.Math.min(r7, r1)
            byte[] r9 = r0.zzg
            int r10 = r0.zzk
            int r7 = (int) r7
            r8 = r20
            int r7 = r8.zza(r9, r10, r7)
            r9 = -1
            if (r7 != r9) goto L_0x003d
            goto L_0x001e
        L_0x003d:
            int r9 = r0.zzk
            int r9 = r9 + r7
            r0.zzk = r9
            goto L_0x0021
        L_0x0043:
            int r1 = r0.zzk
            com.google.android.gms.internal.ads.zzaix r2 = r0.zze
            int r2 = r2.zzd
            int r1 = r1 / r2
            if (r1 <= 0) goto L_0x0143
            byte[] r2 = r0.zzg
            com.google.android.gms.internal.ads.zzef r3 = r0.zzh
            r7 = 0
        L_0x0051:
            if (r7 >= r1) goto L_0x0110
            r8 = 0
        L_0x0054:
            com.google.android.gms.internal.ads.zzaix r9 = r0.zze
            int r10 = r9.zzb
            if (r8 >= r10) goto L_0x0108
            byte[] r11 = r3.zzH()
            int r9 = r9.zzd
            int r12 = r7 * r9
            int r13 = r8 * 4
            int r12 = r12 + r13
            int r13 = r10 * 4
            int r13 = r13 + r12
            int r9 = r9 / r10
            int r9 = r9 + -4
            int r14 = r12 + 1
            byte r14 = r2[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << 8
            byte r15 = r2[r12]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r14 = r14 | r15
            short r14 = (short) r14
            int r12 = r12 + 2
            byte r12 = r2[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r15 = 88
            int r12 = java.lang.Math.min(r12, r15)
            int[] r16 = zzb
            r16 = r16[r12]
            int r5 = r0.zzf
            int r5 = r5 * r7
            int r5 = r5 * r10
            int r5 = r5 + r8
            int r5 = r5 + r5
            r15 = r14 & 255(0xff, float:3.57E-43)
            byte r15 = (byte) r15
            r11[r5] = r15
            int r15 = r5 + 1
            int r6 = r14 >> 8
            byte r6 = (byte) r6
            r11[r15] = r6
            r6 = r5
            r5 = 0
        L_0x009d:
            int r15 = r9 + r9
            if (r5 >= r15) goto L_0x0100
            int r15 = r5 / 8
            int r15 = r15 * r10
            int r15 = r15 * 4
            int r15 = r15 + r13
            int r18 = r5 / 2
            int r18 = r18 % 4
            int r15 = r15 + r18
            byte r15 = r2[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r18 = r5 % 2
            if (r18 != 0) goto L_0x00b8
            r15 = r15 & 15
            goto L_0x00ba
        L_0x00b8:
            int r15 = r15 >> 4
        L_0x00ba:
            r18 = r15 & 7
            int r18 = r18 + r18
            r17 = 1
            int r18 = r18 + 1
            int r18 = r18 * r16
            r16 = r2
            int r2 = r18 >> 3
            r18 = r15 & 8
            if (r18 == 0) goto L_0x00cd
            int r2 = -r2
        L_0x00cd:
            int r14 = r14 + r2
            r2 = -32768(0xffffffffffff8000, float:NaN)
            r21 = r9
            r9 = 32767(0x7fff, float:4.5916E-41)
            int r14 = com.google.android.gms.internal.ads.zzen.zzf(r14, r2, r9)
            int r2 = r10 + r10
            int r6 = r6 + r2
            r2 = r14 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r11[r6] = r2
            int r2 = r6 + 1
            int r9 = r14 >> 8
            byte r9 = (byte) r9
            r11[r2] = r9
            int[] r2 = zza
            r2 = r2[r15]
            int r12 = r12 + r2
            r2 = 88
            r9 = 0
            int r12 = com.google.android.gms.internal.ads.zzen.zzf(r12, r9, r2)
            int[] r9 = zzb
            r9 = r9[r12]
            int r5 = r5 + 1
            r2 = r16
            r16 = r9
            r9 = r21
            goto L_0x009d
        L_0x0100:
            r16 = r2
            r17 = 1
            int r8 = r8 + 1
            goto L_0x0054
        L_0x0108:
            r16 = r2
            r17 = 1
            int r7 = r7 + 1
            goto L_0x0051
        L_0x0110:
            int r2 = r0.zzf
            int r2 = r2 * r1
            int r2 = r0.zze(r2)
            r5 = 0
            r3.zzF(r5)
            r3.zzE(r2)
            int r2 = r0.zzk
            com.google.android.gms.internal.ads.zzaix r3 = r0.zze
            int r3 = r3.zzd
            int r1 = r1 * r3
            int r2 = r2 - r1
            r0.zzk = r2
            com.google.android.gms.internal.ads.zzef r1 = r0.zzh
            int r2 = r1.zzd()
            com.google.android.gms.internal.ads.zzaap r3 = r0.zzd
            com.google.android.gms.internal.ads.zzaan.zzb(r3, r1, r2)
            int r1 = r0.zzm
            int r1 = r1 + r2
            r0.zzm = r1
            int r1 = r0.zzd(r1)
            int r2 = r0.zzi
            if (r1 < r2) goto L_0x0143
            r0.zzf(r2)
        L_0x0143:
            if (r4 == 0) goto L_0x0150
            int r1 = r0.zzm
            int r1 = r0.zzd(r1)
            if (r1 <= 0) goto L_0x0150
            r0.zzf(r1)
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzait.zzc(com.google.android.gms.internal.ads.zzzj, long):boolean");
    }
}
