package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaik implements zzzi {
    public static final zzzp zza = zzaih.zza;
    /* access modifiers changed from: private */
    public final List zzb;
    private final zzef zzc;
    private final SparseIntArray zzd;
    /* access modifiers changed from: private */
    public final zzain zze;
    /* access modifiers changed from: private */
    public final SparseArray zzf;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzg;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzh;
    private final zzaig zzi;
    private zzaif zzj;
    /* access modifiers changed from: private */
    public zzzl zzk;
    /* access modifiers changed from: private */
    public int zzl;
    /* access modifiers changed from: private */
    public boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp;
    /* access modifiers changed from: private */
    public int zzq;

    public zzaik() {
        this(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0196, code lost:
        if (r1 == false) goto L_0x0198;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzzj r19, com.google.android.gms.internal.ads.zzaai r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            long r11 = r19.zzd()
            boolean r3 = r0.zzm
            r13 = -1
            r15 = 1
            r10 = 0
            if (r3 == 0) goto L_0x00a0
            int r3 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzaig r3 = r0.zzi
            boolean r4 = r3.zzd()
            if (r4 == 0) goto L_0x001f
            goto L_0x0026
        L_0x001f:
            int r4 = r0.zzq
            int r1 = r3.zza(r1, r2, r4)
            return r1
        L_0x0026:
            boolean r3 = r0.zzn
            r7 = 0
            if (r3 != 0) goto L_0x0077
            r0.zzn = r15
            com.google.android.gms.internal.ads.zzaig r3 = r0.zzi
            long r4 = r3.zzb()
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x0067
            com.google.android.gms.internal.ads.zzaif r9 = new com.google.android.gms.internal.ads.zzaif
            com.google.android.gms.internal.ads.zzel r4 = r3.zzc()
            long r5 = r3.zzb()
            int r3 = r0.zzq
            r16 = 112800(0x1b8a0, float:1.58066E-40)
            r17 = r3
            r3 = r9
            r13 = r7
            r7 = r11
            r15 = r9
            r9 = r17
            r10 = r16
            r3.<init>(r4, r5, r7, r9, r10)
            r0.zzj = r15
            com.google.android.gms.internal.ads.zzzl r3 = r0.zzk
            com.google.android.gms.internal.ads.zzaif r4 = r0.zzj
            com.google.android.gms.internal.ads.zzaal r4 = r4.zzb()
            r3.zzN(r4)
            goto L_0x0078
        L_0x0067:
            r13 = r7
            com.google.android.gms.internal.ads.zzzl r4 = r0.zzk
            com.google.android.gms.internal.ads.zzaak r5 = new com.google.android.gms.internal.ads.zzaak
            long r6 = r3.zzb()
            r5.<init>(r6, r13)
            r4.zzN(r5)
            goto L_0x0078
        L_0x0077:
            r13 = r7
        L_0x0078:
            boolean r3 = r0.zzo
            if (r3 == 0) goto L_0x008f
            r3 = 0
            r0.zzo = r3
            r0.zzc(r13, r13)
            long r4 = r19.zzf()
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x008b
            goto L_0x0090
        L_0x008b:
            r2.zza = r13
            r1 = 1
            return r1
        L_0x008f:
            r3 = 0
        L_0x0090:
            com.google.android.gms.internal.ads.zzaif r4 = r0.zzj
            if (r4 == 0) goto L_0x00a1
            boolean r5 = r4.zze()
            if (r5 != 0) goto L_0x009b
            goto L_0x00a1
        L_0x009b:
            int r1 = r4.zza(r1, r2)
            return r1
        L_0x00a0:
            r3 = r10
        L_0x00a1:
            com.google.android.gms.internal.ads.zzef r2 = r0.zzc
            byte[] r4 = r2.zzH()
            int r5 = r2.zzc()
            int r5 = 9400 - r5
            r6 = 188(0xbc, float:2.63E-43)
            if (r5 < r6) goto L_0x00b2
            goto L_0x00c4
        L_0x00b2:
            int r5 = r2.zza()
            if (r5 <= 0) goto L_0x00bf
            int r2 = r2.zzc()
            java.lang.System.arraycopy(r4, r2, r4, r3, r5)
        L_0x00bf:
            com.google.android.gms.internal.ads.zzef r2 = r0.zzc
            r2.zzD(r4, r5)
        L_0x00c4:
            com.google.android.gms.internal.ads.zzef r2 = r0.zzc
            int r5 = r2.zza()
            r7 = -1
            if (r5 >= r6) goto L_0x00e1
            int r2 = r2.zzd()
            int r5 = 9400 - r2
            int r5 = r1.zza(r4, r2, r5)
            if (r5 != r7) goto L_0x00da
            return r7
        L_0x00da:
            com.google.android.gms.internal.ads.zzef r7 = r0.zzc
            int r2 = r2 + r5
            r7.zzE(r2)
            goto L_0x00c4
        L_0x00e1:
            int r1 = r2.zzc()
            int r4 = r2.zzd()
            byte[] r2 = r2.zzH()
            int r2 = com.google.android.gms.internal.ads.zzaiq.zza(r2, r1, r4)
            com.google.android.gms.internal.ads.zzef r5 = r0.zzc
            r5.zzF(r2)
            int r5 = r2 + 188
            if (r5 <= r4) goto L_0x0101
            int r4 = r0.zzp
            int r2 = r2 - r1
            int r4 = r4 + r2
            r0.zzp = r4
            goto L_0x0103
        L_0x0101:
            r0.zzp = r3
        L_0x0103:
            com.google.android.gms.internal.ads.zzef r1 = r0.zzc
            int r2 = r1.zzd()
            if (r5 <= r2) goto L_0x010c
            return r3
        L_0x010c:
            int r1 = r1.zze()
            r4 = 8388608(0x800000, float:1.17549435E-38)
            r4 = r4 & r1
            if (r4 == 0) goto L_0x011b
            com.google.android.gms.internal.ads.zzef r1 = r0.zzc
            r1.zzF(r5)
            return r3
        L_0x011b:
            r4 = 4194304(0x400000, float:5.877472E-39)
            r4 = r4 & r1
            if (r4 == 0) goto L_0x0122
            r4 = 1
            goto L_0x0123
        L_0x0122:
            r4 = r3
        L_0x0123:
            int r6 = r1 >> 8
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = r1 & 32
            r9 = r1 & 16
            if (r9 == 0) goto L_0x0136
            android.util.SparseArray r9 = r0.zzf
            java.lang.Object r9 = r9.get(r6)
            com.google.android.gms.internal.ads.zzaip r9 = (com.google.android.gms.internal.ads.zzaip) r9
            goto L_0x0137
        L_0x0136:
            r9 = 0
        L_0x0137:
            if (r9 != 0) goto L_0x013f
            com.google.android.gms.internal.ads.zzef r1 = r0.zzc
            r1.zzF(r5)
            return r3
        L_0x013f:
            r1 = r1 & 15
            android.util.SparseIntArray r10 = r0.zzd
            int r13 = r1 + -1
            int r10 = r10.get(r6, r13)
            android.util.SparseIntArray r13 = r0.zzd
            r13.put(r6, r1)
            if (r10 != r1) goto L_0x0156
            com.google.android.gms.internal.ads.zzef r1 = r0.zzc
            r1.zzF(r5)
            return r3
        L_0x0156:
            r13 = 1
            int r10 = r10 + r13
            r10 = r10 & 15
            if (r1 == r10) goto L_0x015f
            r9.zzc()
        L_0x015f:
            if (r8 == 0) goto L_0x017b
            com.google.android.gms.internal.ads.zzef r1 = r0.zzc
            int r1 = r1.zzk()
            com.google.android.gms.internal.ads.zzef r8 = r0.zzc
            int r8 = r8.zzk()
            r8 = r8 & 64
            if (r8 == 0) goto L_0x0173
            r10 = 2
            goto L_0x0174
        L_0x0173:
            r10 = r3
        L_0x0174:
            r4 = r4 | r10
            com.google.android.gms.internal.ads.zzef r8 = r0.zzc
            int r1 = r1 + r7
            r8.zzG(r1)
        L_0x017b:
            boolean r1 = r0.zzm
            if (r1 != 0) goto L_0x0187
            android.util.SparseBooleanArray r7 = r0.zzh
            boolean r6 = r7.get(r6, r3)
            if (r6 != 0) goto L_0x0198
        L_0x0187:
            com.google.android.gms.internal.ads.zzef r6 = r0.zzc
            r6.zzE(r5)
            com.google.android.gms.internal.ads.zzef r6 = r0.zzc
            r9.zza(r6, r4)
            com.google.android.gms.internal.ads.zzef r4 = r0.zzc
            r4.zzE(r2)
            if (r1 != 0) goto L_0x01a5
        L_0x0198:
            boolean r1 = r0.zzm
            if (r1 == 0) goto L_0x01a5
            r1 = -1
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x01a5
            r1 = 1
            r0.zzo = r1
        L_0x01a5:
            com.google.android.gms.internal.ads.zzef r1 = r0.zzc
            r1.zzF(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaik.zza(com.google.android.gms.internal.ads.zzzj, com.google.android.gms.internal.ads.zzaai):int");
    }

    public final void zzb(zzzl zzzl) {
        this.zzk = zzzl;
    }

    public final void zzc(long j, long j2) {
        zzaif zzaif;
        int size = this.zzb.size();
        for (int i = 0; i < size; i++) {
            zzel zzel = (zzel) this.zzb.get(i);
            if (zzel.zze() != C.TIME_UNSET) {
                long zzc2 = zzel.zzc();
                if (zzc2 != C.TIME_UNSET) {
                    if (zzc2 != 0) {
                        if (zzc2 == j2) {
                        }
                    }
                }
            }
            zzel.zzf(j2);
        }
        if (!(j2 == 0 || (zzaif = this.zzj) == null)) {
            zzaif.zzd(j2);
        }
        this.zzc.zzC(0);
        this.zzd.clear();
        for (int i2 = 0; i2 < this.zzf.size(); i2++) {
            ((zzaip) this.zzf.valueAt(i2)).zzc();
        }
        this.zzp = 0;
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        byte[] zzH = this.zzc.zzH();
        zzyy zzyy = (zzyy) zzzj;
        zzyy.zzm(zzH, 0, 940, false);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 < 5) {
                if (zzH[(i2 * 188) + i] != 71) {
                    i++;
                } else {
                    i2++;
                }
            }
            zzyy.zzo(i, false);
            return true;
        }
        return false;
    }

    public zzaik(int i) {
        this(1, 0, 112800);
    }

    public zzaik(int i, int i2, int i3) {
        zzel zzel = new zzel(0);
        this.zze = new zzagz(0);
        this.zzb = Collections.singletonList(zzel);
        this.zzc = new zzef(new byte[9400], 0);
        this.zzg = new SparseBooleanArray();
        this.zzh = new SparseBooleanArray();
        this.zzf = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zzi = new zzaig(112800);
        this.zzk = zzzl.zza;
        this.zzq = -1;
        this.zzg.clear();
        this.zzf.clear();
        SparseArray sparseArray = new SparseArray();
        int size = sparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzf.put(sparseArray.keyAt(i4), (zzaip) sparseArray.valueAt(i4));
        }
        this.zzf.put(0, new zzaic(new zzaii(this)));
    }
}
