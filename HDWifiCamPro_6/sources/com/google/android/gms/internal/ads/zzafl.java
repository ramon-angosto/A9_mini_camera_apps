package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzafl implements zzzi {
    public static final zzzp zza = zzafh.zza;
    private static final byte[] zzb = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzaf zzc;
    private int zzA;
    private int zzB;
    private boolean zzC;
    private zzzl zzD;
    private zzaap[] zzE;
    private zzaap[] zzF;
    private boolean zzG;
    private final List zzd;
    private final SparseArray zze;
    private final zzef zzf;
    private final zzef zzg;
    private final zzef zzh;
    private final byte[] zzi;
    private final zzef zzj;
    private final zzacg zzk;
    private final zzef zzl;
    private final ArrayDeque zzm;
    private final ArrayDeque zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private int zzr;
    private zzef zzs;
    private long zzt;
    private int zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private zzafk zzy;
    private int zzz;

    static {
        zzad zzad = new zzad();
        zzad.zzS(MimeTypes.APPLICATION_EMSG);
        zzc = zzad.zzY();
    }

    public zzafl() {
        this(0, (zzel) null);
    }

    private static int zze(int i) throws zzbu {
        if (i >= 0) {
            return i;
        }
        throw zzbu.zza("Unexpected negative value: " + i, (Throwable) null);
    }

    private static zzx zzf(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            zzaew zzaew = (zzaew) list.get(i);
            if (zzaew.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] zzH = zzaew.zza.zzH();
                UUID zza2 = zzafs.zza(zzH);
                if (zza2 == null) {
                    zzdw.zze("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzw(zza2, (String) null, MimeTypes.VIDEO_MP4, zzH));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new zzx((List) arrayList);
    }

    private final void zzg() {
        this.zzo = 0;
        this.zzr = 0;
    }

    private static void zzh(zzef zzef, int i, zzafx zzafx) throws zzbu {
        zzef.zzF(i + 8);
        int zze2 = zzef.zze() & ViewCompat.MEASURED_SIZE_MASK;
        if ((zze2 & 1) == 0) {
            boolean z = (zze2 & 2) != 0;
            int zzn2 = zzef.zzn();
            if (zzn2 == 0) {
                Arrays.fill(zzafx.zzl, 0, zzafx.zze, false);
                return;
            }
            int i2 = zzafx.zze;
            if (zzn2 == i2) {
                Arrays.fill(zzafx.zzl, 0, zzn2, z);
                zzafx.zza(zzef.zza());
                zzef zzef2 = zzafx.zzn;
                zzef.zzB(zzef2.zzH(), 0, zzef2.zzd());
                zzafx.zzn.zzF(0);
                zzafx.zzo = false;
                return;
            }
            throw zzbu.zza("Senc sample count " + zzn2 + " is different from fragment sample count" + i2, (Throwable) null);
        }
        throw zzbu.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.gms.internal.ads.zzafk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v21, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzi(long r48) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r47 = this;
            r0 = r47
        L_0x0002:
            java.util.ArrayDeque r1 = r0.zzm
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x06f9
            java.util.ArrayDeque r1 = r0.zzm
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzaev r1 = (com.google.android.gms.internal.ads.zzaev) r1
            long r1 = r1.zza
            int r1 = (r1 > r48 ? 1 : (r1 == r48 ? 0 : -1))
            if (r1 != 0) goto L_0x06f9
            java.util.ArrayDeque r1 = r0.zzm
            java.lang.Object r1 = r1.pop()
            r2 = r1
            com.google.android.gms.internal.ads.zzaev r2 = (com.google.android.gms.internal.ads.zzaev) r2
            int r1 = r2.zzd
            r3 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r6 = 12
            r7 = 8
            r8 = 0
            if (r1 != r3) goto L_0x0142
            java.util.List r1 = r2.zzb
            com.google.android.gms.internal.ads.zzx r1 = zzf(r1)
            r3 = 1836475768(0x6d766578, float:4.7659988E27)
            com.google.android.gms.internal.ads.zzaev r3 = r2.zza(r3)
            if (r3 == 0) goto L_0x0141
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.util.List r8 = r3.zzb
            int r8 = r8.size()
            r4 = 0
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x004d:
            if (r4 >= r8) goto L_0x00b9
            java.util.List r5 = r3.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.internal.ads.zzaew r5 = (com.google.android.gms.internal.ads.zzaew) r5
            int r9 = r5.zzd
            r15 = 1953654136(0x74726578, float:7.6818474E31)
            if (r9 != r15) goto L_0x0096
            com.google.android.gms.internal.ads.zzef r5 = r5.zza
            r5.zzF(r6)
            int r9 = r5.zze()
            int r15 = r5.zze()
            int r10 = r5.zze()
            int r6 = r5.zze()
            int r5 = r5.zze()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            com.google.android.gms.internal.ads.zzafg r11 = new com.google.android.gms.internal.ads.zzafg
            int r15 = r15 + -1
            r11.<init>(r15, r10, r6, r5)
            android.util.Pair r5 = android.util.Pair.create(r9, r11)
            java.lang.Object r6 = r5.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r5 = r5.second
            com.google.android.gms.internal.ads.zzafg r5 = (com.google.android.gms.internal.ads.zzafg) r5
            r12.put(r6, r5)
            goto L_0x00b4
        L_0x0096:
            r6 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r9 != r6) goto L_0x00b4
            com.google.android.gms.internal.ads.zzef r5 = r5.zza
            r5.zzF(r7)
            int r6 = r5.zze()
            int r6 = com.google.android.gms.internal.ads.zzaex.zze(r6)
            if (r6 != 0) goto L_0x00af
            long r5 = r5.zzs()
            goto L_0x00b3
        L_0x00af:
            long r5 = r5.zzt()
        L_0x00b3:
            r13 = r5
        L_0x00b4:
            int r4 = r4 + 1
            r6 = 12
            goto L_0x004d
        L_0x00b9:
            com.google.android.gms.internal.ads.zzzx r3 = new com.google.android.gms.internal.ads.zzzx
            r3.<init>()
            com.google.android.gms.internal.ads.zzafi r9 = new com.google.android.gms.internal.ads.zzafi
            r9.<init>(r0)
            r7 = 0
            r8 = 0
            r4 = r13
            r6 = r1
            java.util.List r1 = com.google.android.gms.internal.ads.zzaff.zzc(r2, r3, r4, r6, r7, r8, r9)
            int r2 = r1.size()
            android.util.SparseArray r3 = r0.zze
            int r3 = r3.size()
            if (r3 != 0) goto L_0x0110
            r3 = 0
        L_0x00d8:
            if (r3 >= r2) goto L_0x0109
            java.lang.Object r4 = r1.get(r3)
            com.google.android.gms.internal.ads.zzafy r4 = (com.google.android.gms.internal.ads.zzafy) r4
            com.google.android.gms.internal.ads.zzafv r5 = r4.zza
            com.google.android.gms.internal.ads.zzafk r6 = new com.google.android.gms.internal.ads.zzafk
            com.google.android.gms.internal.ads.zzzl r7 = r0.zzD
            int r8 = r5.zzb
            com.google.android.gms.internal.ads.zzaap r7 = r7.zzv(r3, r8)
            int r8 = r5.zza
            com.google.android.gms.internal.ads.zzafg r8 = zzj(r12, r8)
            r6.<init>(r7, r4, r8)
            android.util.SparseArray r4 = r0.zze
            int r7 = r5.zza
            r4.put(r7, r6)
            long r6 = r0.zzw
            long r4 = r5.zze
            long r4 = java.lang.Math.max(r6, r4)
            r0.zzw = r4
            int r3 = r3 + 1
            goto L_0x00d8
        L_0x0109:
            com.google.android.gms.internal.ads.zzzl r1 = r0.zzD
            r1.zzC()
            goto L_0x0002
        L_0x0110:
            android.util.SparseArray r3 = r0.zze
            int r3 = r3.size()
            if (r3 != r2) goto L_0x011b
            r16 = 1
            goto L_0x011d
        L_0x011b:
            r16 = 0
        L_0x011d:
            com.google.android.gms.internal.ads.zzdd.zzf(r16)
            r3 = 0
        L_0x0121:
            if (r3 >= r2) goto L_0x0002
            java.lang.Object r4 = r1.get(r3)
            com.google.android.gms.internal.ads.zzafy r4 = (com.google.android.gms.internal.ads.zzafy) r4
            com.google.android.gms.internal.ads.zzafv r5 = r4.zza
            android.util.SparseArray r6 = r0.zze
            int r7 = r5.zza
            java.lang.Object r6 = r6.get(r7)
            com.google.android.gms.internal.ads.zzafk r6 = (com.google.android.gms.internal.ads.zzafk) r6
            int r5 = r5.zza
            com.google.android.gms.internal.ads.zzafg r5 = zzj(r12, r5)
            r6.zzh(r4, r5)
            int r3 = r3 + 1
            goto L_0x0121
        L_0x0141:
            throw r8
        L_0x0142:
            r3 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r1 != r3) goto L_0x06e2
            android.util.SparseArray r1 = r0.zze
            byte[] r3 = r0.zzi
            java.util.List r6 = r2.zzc
            int r6 = r6.size()
            r9 = 0
        L_0x0152:
            if (r9 >= r6) goto L_0x064f
            java.util.List r10 = r2.zzc
            java.lang.Object r10 = r10.get(r9)
            com.google.android.gms.internal.ads.zzaev r10 = (com.google.android.gms.internal.ads.zzaev) r10
            int r11 = r10.zzd
            r12 = 1953653094(0x74726166, float:7.6813435E31)
            if (r11 != r12) goto L_0x0630
            r11 = 1952868452(0x74666864, float:7.301914E31)
            com.google.android.gms.internal.ads.zzaew r11 = r10.zzb(r11)
            if (r11 == 0) goto L_0x062e
            com.google.android.gms.internal.ads.zzef r11 = r11.zza
            r11.zzF(r7)
            int r12 = r11.zze()
            r13 = 16777215(0xffffff, float:2.3509886E-38)
            r12 = r12 & r13
            int r14 = r11.zze()
            java.lang.Object r14 = r1.get(r14)
            com.google.android.gms.internal.ads.zzafk r14 = (com.google.android.gms.internal.ads.zzafk) r14
            if (r14 != 0) goto L_0x0187
            r14 = r8
            goto L_0x01d0
        L_0x0187:
            r15 = r12 & 1
            if (r15 == 0) goto L_0x0195
            long r4 = r11.zzt()
            com.google.android.gms.internal.ads.zzafx r15 = r14.zzb
            r15.zzb = r4
            r15.zzc = r4
        L_0x0195:
            com.google.android.gms.internal.ads.zzafg r4 = r14.zze
            r5 = r12 & 2
            if (r5 == 0) goto L_0x01a2
            int r5 = r11.zze()
            int r5 = r5 + -1
            goto L_0x01a4
        L_0x01a2:
            int r5 = r4.zza
        L_0x01a4:
            r15 = r12 & 8
            if (r15 == 0) goto L_0x01ad
            int r15 = r11.zze()
            goto L_0x01af
        L_0x01ad:
            int r15 = r4.zzb
        L_0x01af:
            r17 = r12 & 16
            if (r17 == 0) goto L_0x01ba
            int r17 = r11.zze()
            r8 = r17
            goto L_0x01bc
        L_0x01ba:
            int r8 = r4.zzc
        L_0x01bc:
            r12 = r12 & 32
            if (r12 == 0) goto L_0x01c5
            int r4 = r11.zze()
            goto L_0x01c7
        L_0x01c5:
            int r4 = r4.zzd
        L_0x01c7:
            com.google.android.gms.internal.ads.zzafx r11 = r14.zzb
            com.google.android.gms.internal.ads.zzafg r12 = new com.google.android.gms.internal.ads.zzafg
            r12.<init>(r5, r15, r8, r4)
            r11.zza = r12
        L_0x01d0:
            if (r14 != 0) goto L_0x01df
            r19 = r1
            r25 = r2
            r23 = r6
            r5 = r7
            r28 = r9
            r0 = 1
            r1 = 0
            goto L_0x063b
        L_0x01df:
            com.google.android.gms.internal.ads.zzafx r4 = r14.zzb
            long r11 = r4.zzp
            boolean r5 = r4.zzq
            r14.zzi()
            r8 = 1
            r14.zzl = true
            r15 = 1952867444(0x74666474, float:7.3014264E31)
            com.google.android.gms.internal.ads.zzaew r15 = r10.zzb(r15)
            if (r15 == 0) goto L_0x0212
            com.google.android.gms.internal.ads.zzef r5 = r15.zza
            r5.zzF(r7)
            int r11 = r5.zze()
            int r11 = com.google.android.gms.internal.ads.zzaex.zze(r11)
            if (r11 != r8) goto L_0x0209
            long r11 = r5.zzt()
            goto L_0x020d
        L_0x0209:
            long r11 = r5.zzs()
        L_0x020d:
            r4.zzp = r11
            r4.zzq = r8
            goto L_0x0216
        L_0x0212:
            r4.zzp = r11
            r4.zzq = r5
        L_0x0216:
            java.util.List r5 = r10.zzb
            int r8 = r5.size()
            r11 = 0
            r12 = 0
            r15 = 0
        L_0x021f:
            r13 = 1953658222(0x7472756e, float:7.683823E31)
            if (r11 >= r8) goto L_0x0249
            java.lang.Object r19 = r5.get(r11)
            r7 = r19
            com.google.android.gms.internal.ads.zzaew r7 = (com.google.android.gms.internal.ads.zzaew) r7
            r19 = r1
            int r1 = r7.zzd
            if (r1 != r13) goto L_0x0242
            com.google.android.gms.internal.ads.zzef r1 = r7.zza
            r7 = 12
            r1.zzF(r7)
            int r1 = r1.zzn()
            if (r1 <= 0) goto L_0x0242
            int r15 = r15 + r1
            int r12 = r12 + 1
        L_0x0242:
            int r11 = r11 + 1
            r1 = r19
            r7 = 8
            goto L_0x021f
        L_0x0249:
            r19 = r1
            r1 = 0
            r14.zzh = r1
            r14.zzg = r1
            r14.zzf = r1
            com.google.android.gms.internal.ads.zzafx r1 = r14.zzb
            r1.zzd = r12
            r1.zze = r15
            int[] r7 = r1.zzg
            int r7 = r7.length
            if (r7 >= r12) goto L_0x0265
            long[] r7 = new long[r12]
            r1.zzf = r7
            int[] r7 = new int[r12]
            r1.zzg = r7
        L_0x0265:
            int[] r7 = r1.zzh
            int r7 = r7.length
            if (r7 >= r15) goto L_0x027e
            int r15 = r15 * 125
            int r15 = r15 / 100
            int[] r7 = new int[r15]
            r1.zzh = r7
            long[] r7 = new long[r15]
            r1.zzi = r7
            boolean[] r7 = new boolean[r15]
            r1.zzj = r7
            boolean[] r7 = new boolean[r15]
            r1.zzl = r7
        L_0x027e:
            r1 = 0
            r7 = 0
            r11 = 0
        L_0x0281:
            r20 = 0
            if (r1 >= r8) goto L_0x03fe
            java.lang.Object r15 = r5.get(r1)
            com.google.android.gms.internal.ads.zzaew r15 = (com.google.android.gms.internal.ads.zzaew) r15
            int r12 = r15.zzd
            if (r12 != r13) goto L_0x03ce
            int r12 = r11 + 1
            com.google.android.gms.internal.ads.zzef r15 = r15.zza
            r13 = 8
            r15.zzF(r13)
            int r13 = r15.zze()
            r18 = 16777215(0xffffff, float:2.3509886E-38)
            r13 = r13 & r18
            r22 = r5
            com.google.android.gms.internal.ads.zzafy r5 = r14.zzd
            com.google.android.gms.internal.ads.zzafv r5 = r5.zza
            r23 = r6
            com.google.android.gms.internal.ads.zzafx r6 = r14.zzb
            r24 = r8
            com.google.android.gms.internal.ads.zzafg r8 = r6.zza
            int r25 = com.google.android.gms.internal.ads.zzen.zza
            r26 = r12
            int[] r12 = r6.zzg
            int r25 = r15.zzn()
            r12[r11] = r25
            long[] r12 = r6.zzf
            r25 = r2
            r27 = r3
            long r2 = r6.zzb
            r12[r11] = r2
            r28 = r13 & 1
            if (r28 == 0) goto L_0x02d6
            int r0 = r15.zze()
            r28 = r9
            r29 = r10
            long r9 = (long) r0
            long r2 = r2 + r9
            r12[r11] = r2
            goto L_0x02da
        L_0x02d6:
            r28 = r9
            r29 = r10
        L_0x02da:
            r0 = r13 & 4
            int r2 = r8.zzd
            if (r0 == 0) goto L_0x02e4
            int r2 = r15.zze()
        L_0x02e4:
            r3 = r13 & 256(0x100, float:3.59E-43)
            r9 = r13 & 512(0x200, float:7.175E-43)
            r10 = r13 & 1024(0x400, float:1.435E-42)
            r12 = r13 & 2048(0x800, float:2.87E-42)
            long[] r13 = r5.zzh
            if (r13 == 0) goto L_0x030a
            r30 = r2
            int r2 = r13.length
            r31 = r4
            r4 = 1
            if (r2 != r4) goto L_0x030e
            r2 = 0
            r32 = r13[r2]
            int r4 = (r32 > r20 ? 1 : (r32 == r20 ? 0 : -1))
            if (r4 != 0) goto L_0x030e
            long[] r4 = r5.zzi
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzen.zzH(r4)
            long[] r4 = (long[]) r4
            r20 = r4[r2]
            goto L_0x030e
        L_0x030a:
            r30 = r2
            r31 = r4
        L_0x030e:
            int[] r2 = r6.zzh
            long[] r4 = r6.zzi
            boolean[] r13 = r6.zzj
            r32 = r1
            int[] r1 = r6.zzg
            r1 = r1[r11]
            int r1 = r1 + r7
            r40 = r13
            r39 = r14
            long r13 = r5.zzc
            r41 = r4
            long r4 = r6.zzp
        L_0x0325:
            if (r7 >= r1) goto L_0x03c3
            if (r3 == 0) goto L_0x032e
            int r11 = r15.zze()
            goto L_0x0330
        L_0x032e:
            int r11 = r8.zzb
        L_0x0330:
            zze(r11)
            if (r9 == 0) goto L_0x033e
            int r33 = r15.zze()
            r42 = r1
            r1 = r33
            goto L_0x0342
        L_0x033e:
            r42 = r1
            int r1 = r8.zzc
        L_0x0342:
            zze(r1)
            if (r10 == 0) goto L_0x0350
            int r33 = r15.zze()
            r43 = r0
            r0 = r33
            goto L_0x035d
        L_0x0350:
            r43 = r0
            if (r7 != 0) goto L_0x035b
            if (r0 == 0) goto L_0x035a
            r0 = r30
            r7 = 0
            goto L_0x035d
        L_0x035a:
            r7 = 0
        L_0x035b:
            int r0 = r8.zzd
        L_0x035d:
            if (r12 == 0) goto L_0x036c
            int r33 = r15.zze()
            r44 = r3
            r45 = r8
            r46 = r9
            r3 = r33
            goto L_0x0373
        L_0x036c:
            r44 = r3
            r45 = r8
            r46 = r9
            r3 = 0
        L_0x0373:
            long r8 = (long) r3
            long r8 = r8 + r4
            long r33 = r8 - r20
            r35 = 1000000(0xf4240, double:4.940656E-318)
            r37 = r13
            long r8 = com.google.android.gms.internal.ads.zzen.zzw(r33, r35, r37)
            r41[r7] = r8
            boolean r3 = r6.zzq
            r33 = r10
            if (r3 != 0) goto L_0x0396
            r3 = r39
            com.google.android.gms.internal.ads.zzafy r10 = r3.zzd
            r34 = r12
            r35 = r13
            long r12 = r10.zzh
            long r8 = r8 + r12
            r41[r7] = r8
            goto L_0x039c
        L_0x0396:
            r34 = r12
            r35 = r13
            r3 = r39
        L_0x039c:
            r2[r7] = r1
            r1 = 16
            int r0 = r0 >> r1
            r1 = 1
            r0 = r0 & r1
            r0 = r0 ^ r1
            if (r1 == r0) goto L_0x03a8
            r0 = 0
            goto L_0x03a9
        L_0x03a8:
            r0 = 1
        L_0x03a9:
            r40[r7] = r0
            long r0 = (long) r11
            long r4 = r4 + r0
            int r7 = r7 + 1
            r39 = r3
            r10 = r33
            r12 = r34
            r13 = r35
            r1 = r42
            r0 = r43
            r3 = r44
            r8 = r45
            r9 = r46
            goto L_0x0325
        L_0x03c3:
            r42 = r1
            r3 = r39
            r6.zzp = r4
            r11 = r26
            r7 = r42
            goto L_0x03e4
        L_0x03ce:
            r32 = r1
            r25 = r2
            r27 = r3
            r31 = r4
            r22 = r5
            r23 = r6
            r24 = r8
            r28 = r9
            r29 = r10
            r3 = r14
            r18 = 16777215(0xffffff, float:2.3509886E-38)
        L_0x03e4:
            int r1 = r32 + 1
            r0 = r47
            r14 = r3
            r5 = r22
            r6 = r23
            r8 = r24
            r2 = r25
            r3 = r27
            r9 = r28
            r10 = r29
            r4 = r31
            r13 = 1953658222(0x7472756e, float:7.683823E31)
            goto L_0x0281
        L_0x03fe:
            r25 = r2
            r27 = r3
            r31 = r4
            r23 = r6
            r28 = r9
            r29 = r10
            r3 = r14
            com.google.android.gms.internal.ads.zzafy r0 = r3.zzd
            com.google.android.gms.internal.ads.zzafv r0 = r0.zza
            r1 = r31
            com.google.android.gms.internal.ads.zzafg r2 = r1.zza
            if (r2 == 0) goto L_0x062c
            int r2 = r2.zza
            com.google.android.gms.internal.ads.zzafw r0 = r0.zza(r2)
            r2 = 1935763834(0x7361697a, float:1.785898E31)
            r10 = r29
            com.google.android.gms.internal.ads.zzaew r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x049c
            if (r0 == 0) goto L_0x049a
            com.google.android.gms.internal.ads.zzef r2 = r2.zza
            int r3 = r0.zzd
            r4 = 8
            r2.zzF(r4)
            int r5 = r2.zze()
            r6 = 1
            r5 = r5 & r6
            if (r5 != r6) goto L_0x043c
            r2.zzG(r4)
        L_0x043c:
            int r4 = r2.zzk()
            int r5 = r2.zzn()
            int r6 = r1.zze
            if (r5 > r6) goto L_0x047b
            if (r4 != 0) goto L_0x0461
            boolean[] r4 = r1.zzl
            r6 = 0
            r7 = 0
        L_0x044e:
            if (r6 >= r5) goto L_0x045f
            int r8 = r2.zzk()
            int r7 = r7 + r8
            if (r8 <= r3) goto L_0x0459
            r8 = 1
            goto L_0x045a
        L_0x0459:
            r8 = 0
        L_0x045a:
            r4[r6] = r8
            int r6 = r6 + 1
            goto L_0x044e
        L_0x045f:
            r4 = 0
            goto L_0x046e
        L_0x0461:
            if (r4 <= r3) goto L_0x0465
            r2 = 1
            goto L_0x0466
        L_0x0465:
            r2 = 0
        L_0x0466:
            int r7 = r4 * r5
            boolean[] r3 = r1.zzl
            r4 = 0
            java.util.Arrays.fill(r3, r4, r5, r2)
        L_0x046e:
            boolean[] r2 = r1.zzl
            int r3 = r1.zze
            java.util.Arrays.fill(r2, r5, r3, r4)
            if (r7 <= 0) goto L_0x049c
            r1.zza(r7)
            goto L_0x049c
        L_0x047b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Saiz sample count "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " is greater than fragment sample count"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x049a:
            r1 = 0
            throw r1
        L_0x049c:
            r2 = 1935763823(0x7361696f, float:1.7858967E31)
            com.google.android.gms.internal.ads.zzaew r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x04ea
            com.google.android.gms.internal.ads.zzef r2 = r2.zza
            r3 = 8
            r2.zzF(r3)
            int r4 = r2.zze()
            r5 = r4 & 1
            r6 = 1
            if (r5 != r6) goto L_0x04b8
            r2.zzG(r3)
        L_0x04b8:
            int r3 = r2.zzn()
            if (r3 != r6) goto L_0x04d3
            long r5 = r1.zzc
            int r3 = com.google.android.gms.internal.ads.zzaex.zze(r4)
            if (r3 != 0) goto L_0x04cb
            long r2 = r2.zzs()
            goto L_0x04cf
        L_0x04cb:
            long r2 = r2.zzt()
        L_0x04cf:
            long r5 = r5 + r2
            r1.zzc = r5
            goto L_0x04ea
        L_0x04d3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected saio entry count: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x04ea:
            r2 = 1936027235(0x73656e63, float:1.8177412E31)
            com.google.android.gms.internal.ads.zzaew r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x04f9
            com.google.android.gms.internal.ads.zzef r2 = r2.zza
            r3 = 0
            zzh(r2, r3, r1)
        L_0x04f9:
            if (r0 == 0) goto L_0x0500
            java.lang.String r8 = r0.zzb
            r31 = r8
            goto L_0x0502
        L_0x0500:
            r31 = 0
        L_0x0502:
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x0505:
            java.util.List r4 = r10.zzb
            int r4 = r4.size()
            if (r0 >= r4) goto L_0x0542
            java.util.List r4 = r10.zzb
            java.lang.Object r4 = r4.get(r0)
            com.google.android.gms.internal.ads.zzaew r4 = (com.google.android.gms.internal.ads.zzaew) r4
            com.google.android.gms.internal.ads.zzef r5 = r4.zza
            int r4 = r4.zzd
            r6 = 1935828848(0x73626770, float:1.7937577E31)
            r7 = 1936025959(0x73656967, float:1.817587E31)
            if (r4 != r6) goto L_0x052e
            r6 = 12
            r5.zzF(r6)
            int r4 = r5.zze()
            if (r4 != r7) goto L_0x053f
            r2 = r5
            goto L_0x053f
        L_0x052e:
            r6 = 12
            r8 = 1936158820(0x73677064, float:1.8336489E31)
            if (r4 != r8) goto L_0x053f
            r5.zzF(r6)
            int r4 = r5.zze()
            if (r4 != r7) goto L_0x053f
            r3 = r5
        L_0x053f:
            int r0 = r0 + 1
            goto L_0x0505
        L_0x0542:
            r6 = 12
            if (r2 == 0) goto L_0x05e5
            if (r3 != 0) goto L_0x054a
            goto L_0x05e5
        L_0x054a:
            r0 = 8
            r2.zzF(r0)
            int r4 = r2.zze()
            r5 = 4
            r2.zzG(r5)
            int r4 = com.google.android.gms.internal.ads.zzaex.zze(r4)
            r7 = 1
            if (r4 != r7) goto L_0x0561
            r2.zzG(r5)
        L_0x0561:
            int r2 = r2.zze()
            if (r2 != r7) goto L_0x05de
            r3.zzF(r0)
            int r0 = r3.zze()
            int r0 = com.google.android.gms.internal.ads.zzaex.zze(r0)
            r3.zzG(r5)
            if (r0 != r7) goto L_0x0587
            long r7 = r3.zzs()
            int r0 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0580
            goto L_0x058d
        L_0x0580:
            java.lang.String r0 = "Variable length description in sgpd found (unsupported)"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zzc(r0)
            throw r0
        L_0x0587:
            r2 = 2
            if (r0 < r2) goto L_0x058d
            r3.zzG(r5)
        L_0x058d:
            long r7 = r3.zzs()
            r11 = 1
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x05d7
            r0 = 1
            r3.zzG(r0)
            int r2 = r3.zzk()
            r4 = r2 & 240(0xf0, float:3.36E-43)
            int r34 = r4 >> 4
            r35 = r2 & 15
            int r2 = r3.zzk()
            if (r2 != r0) goto L_0x05e6
            int r32 = r3.zzk()
            r2 = 16
            byte[] r4 = new byte[r2]
            r5 = 0
            r3.zzB(r4, r5, r2)
            if (r32 != 0) goto L_0x05c5
            int r2 = r3.zzk()
            byte[] r8 = new byte[r2]
            r3.zzB(r8, r5, r2)
            r36 = r8
            goto L_0x05c7
        L_0x05c5:
            r36 = 0
        L_0x05c7:
            r1.zzk = r0
            com.google.android.gms.internal.ads.zzafw r2 = new com.google.android.gms.internal.ads.zzafw
            r30 = 1
            r29 = r2
            r33 = r4
            r29.<init>(r30, r31, r32, r33, r34, r35, r36)
            r1.zzm = r2
            goto L_0x05e6
        L_0x05d7:
            java.lang.String r0 = "Entry count in sgpd != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zzc(r0)
            throw r0
        L_0x05de:
            java.lang.String r0 = "Entry count in sbgp != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zzc(r0)
            throw r0
        L_0x05e5:
            r0 = 1
        L_0x05e6:
            java.util.List r2 = r10.zzb
            int r2 = r2.size()
            r3 = 0
        L_0x05ed:
            if (r3 >= r2) goto L_0x0625
            java.util.List r4 = r10.zzb
            java.lang.Object r4 = r4.get(r3)
            com.google.android.gms.internal.ads.zzaew r4 = (com.google.android.gms.internal.ads.zzaew) r4
            int r5 = r4.zzd
            r7 = 1970628964(0x75756964, float:3.1109627E32)
            if (r5 != r7) goto L_0x0619
            com.google.android.gms.internal.ads.zzef r4 = r4.zza
            r5 = 8
            r4.zzF(r5)
            r7 = r27
            r8 = 16
            r9 = 0
            r4.zzB(r7, r9, r8)
            byte[] r11 = zzb
            boolean r11 = java.util.Arrays.equals(r7, r11)
            if (r11 == 0) goto L_0x0620
            zzh(r4, r8, r1)
            goto L_0x0620
        L_0x0619:
            r7 = r27
            r5 = 8
            r8 = 16
            r9 = 0
        L_0x0620:
            int r3 = r3 + 1
            r27 = r7
            goto L_0x05ed
        L_0x0625:
            r7 = r27
            r5 = 8
            r9 = 0
            r1 = 0
            goto L_0x063f
        L_0x062c:
            r1 = 0
            throw r1
        L_0x062e:
            r1 = r8
            throw r1
        L_0x0630:
            r19 = r1
            r25 = r2
            r23 = r6
            r5 = r7
            r1 = r8
            r28 = r9
            r0 = 1
        L_0x063b:
            r6 = 12
            r9 = 0
            r7 = r3
        L_0x063f:
            int r2 = r28 + 1
            r0 = r47
            r8 = r1
            r9 = r2
            r3 = r7
            r1 = r19
            r6 = r23
            r2 = r25
            r7 = r5
            goto L_0x0152
        L_0x064f:
            r1 = r8
            r9 = 0
            java.util.List r0 = r2.zzb
            com.google.android.gms.internal.ads.zzx r0 = zzf(r0)
            r3 = r47
            if (r0 == 0) goto L_0x069f
            android.util.SparseArray r2 = r3.zze
            int r2 = r2.size()
            r4 = r9
        L_0x0662:
            if (r4 >= r2) goto L_0x069f
            android.util.SparseArray r5 = r3.zze
            java.lang.Object r5 = r5.valueAt(r4)
            com.google.android.gms.internal.ads.zzafk r5 = (com.google.android.gms.internal.ads.zzafk) r5
            com.google.android.gms.internal.ads.zzafy r6 = r5.zzd
            com.google.android.gms.internal.ads.zzafv r6 = r6.zza
            com.google.android.gms.internal.ads.zzafx r7 = r5.zzb
            com.google.android.gms.internal.ads.zzafg r7 = r7.zza
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            int r7 = r7.zza
            com.google.android.gms.internal.ads.zzafw r6 = r6.zza(r7)
            if (r6 == 0) goto L_0x0681
            java.lang.String r8 = r6.zzb
            goto L_0x0682
        L_0x0681:
            r8 = r1
        L_0x0682:
            com.google.android.gms.internal.ads.zzx r6 = r0.zzb(r8)
            com.google.android.gms.internal.ads.zzafy r7 = r5.zzd
            com.google.android.gms.internal.ads.zzafv r7 = r7.zza
            com.google.android.gms.internal.ads.zzaf r7 = r7.zzf
            com.google.android.gms.internal.ads.zzad r7 = r7.zzb()
            r7.zzB(r6)
            com.google.android.gms.internal.ads.zzaf r6 = r7.zzY()
            com.google.android.gms.internal.ads.zzaap r5 = r5.zza
            r5.zzk(r6)
            int r4 = r4 + 1
            goto L_0x0662
        L_0x069f:
            long r0 = r3.zzv
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x06f6
            android.util.SparseArray r0 = r3.zze
            int r0 = r0.size()
        L_0x06b0:
            if (r9 >= r0) goto L_0x06da
            android.util.SparseArray r1 = r3.zze
            java.lang.Object r1 = r1.valueAt(r9)
            com.google.android.gms.internal.ads.zzafk r1 = (com.google.android.gms.internal.ads.zzafk) r1
            long r4 = r3.zzv
            int r2 = r1.zzf
        L_0x06be:
            com.google.android.gms.internal.ads.zzafx r6 = r1.zzb
            int r7 = r6.zze
            if (r2 >= r7) goto L_0x06d7
            long[] r7 = r6.zzi
            r10 = r7[r2]
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x06d7
            boolean[] r6 = r6.zzj
            boolean r6 = r6[r2]
            if (r6 == 0) goto L_0x06d4
            r1.zzi = r2
        L_0x06d4:
            int r2 = r2 + 1
            goto L_0x06be
        L_0x06d7:
            int r9 = r9 + 1
            goto L_0x06b0
        L_0x06da:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3.zzv = r1
            goto L_0x06f6
        L_0x06e2:
            r3 = r0
            java.util.ArrayDeque r0 = r3.zzm
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x06f6
            java.util.ArrayDeque r0 = r3.zzm
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzaev r0 = (com.google.android.gms.internal.ads.zzaev) r0
            r0.zzc(r2)
        L_0x06f6:
            r0 = r3
            goto L_0x0002
        L_0x06f9:
            r3 = r0
            r47.zzg()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafl.zzi(long):void");
    }

    private static final zzafg zzj(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzafg) sparseArray.valueAt(0);
        }
        zzafg zzafg = (zzafg) sparseArray.get(i);
        if (zzafg != null) {
            return zzafg;
        }
        throw null;
    }

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        Throwable th;
        boolean z;
        long j;
        long j2;
        String str;
        String str2;
        long j3;
        long j4;
        long j5;
        long j6;
        zzafk zzafk;
        int i;
        boolean z2;
        int i2;
        zzzj zzzj2 = zzzj;
        while (true) {
            int i3 = this.zzo;
            th = null;
            z = true;
            int i4 = 0;
            if (i3 == 0) {
                if (this.zzr == 0) {
                    if (!zzzj2.zzn(this.zzl.zzH(), 0, 8, true)) {
                        return -1;
                    }
                    this.zzr = 8;
                    this.zzl.zzF(0);
                    this.zzq = this.zzl.zzs();
                    this.zzp = this.zzl.zze();
                }
                long j7 = this.zzq;
                if (j7 == 1) {
                    ((zzyy) zzzj2).zzn(this.zzl.zzH(), 8, 8, false);
                    this.zzr += 8;
                    this.zzq = this.zzl.zzt();
                } else if (j7 == 0) {
                    long zzd2 = zzzj.zzd();
                    if (zzd2 == -1) {
                        zzd2 = !this.zzm.isEmpty() ? ((zzaev) this.zzm.peek()).zza : -1;
                    }
                    if (zzd2 != -1) {
                        this.zzq = (zzd2 - zzzj.zzf()) + ((long) this.zzr);
                    }
                }
                long j8 = this.zzq;
                long j9 = (long) this.zzr;
                if (j8 >= j9) {
                    long zzf2 = zzzj.zzf() - j9;
                    int i5 = this.zzp;
                    if ((i5 == 1836019558 || i5 == 1835295092) && !this.zzG) {
                        this.zzD.zzN(new zzaak(this.zzw, zzf2));
                        this.zzG = true;
                    }
                    if (this.zzp == 1836019558) {
                        int size = this.zze.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            zzafx zzafx = ((zzafk) this.zze.valueAt(i6)).zzb;
                            zzafx.zzc = zzf2;
                            zzafx.zzb = zzf2;
                        }
                    }
                    int i7 = this.zzp;
                    if (i7 == 1835295092) {
                        this.zzy = null;
                        this.zzt = zzf2 + this.zzq;
                        this.zzo = 2;
                    } else if (i7 == 1836019574 || i7 == 1953653099 || i7 == 1835297121 || i7 == 1835626086 || i7 == 1937007212 || i7 == 1836019558 || i7 == 1953653094 || i7 == 1836475768 || i7 == 1701082227) {
                        long zzf3 = (zzzj.zzf() + this.zzq) - 8;
                        this.zzm.push(new zzaev(i7, zzf3));
                        if (this.zzq == ((long) this.zzr)) {
                            zzi(zzf3);
                        } else {
                            zzg();
                        }
                    } else if (i7 == 1751411826 || i7 == 1835296868 || i7 == 1836476516 || i7 == 1936286840 || i7 == 1937011556 || i7 == 1937011827 || i7 == 1668576371 || i7 == 1937011555 || i7 == 1937011578 || i7 == 1937013298 || i7 == 1937007471 || i7 == 1668232756 || i7 == 1937011571 || i7 == 1952867444 || i7 == 1952868452 || i7 == 1953196132 || i7 == 1953654136 || i7 == 1953658222 || i7 == 1886614376 || i7 == 1935763834 || i7 == 1935763823 || i7 == 1936027235 || i7 == 1970628964 || i7 == 1935828848 || i7 == 1936158820 || i7 == 1701606260 || i7 == 1835362404 || i7 == 1701671783) {
                        if (this.zzr == 8) {
                            long j10 = this.zzq;
                            if (j10 <= 2147483647L) {
                                zzef zzef = new zzef((int) j10);
                                System.arraycopy(this.zzl.zzH(), 0, zzef.zzH(), 0, 8);
                                this.zzs = zzef;
                                this.zzo = 1;
                            } else {
                                throw zzbu.zzc("Leaf atom with length > 2147483647 (unsupported).");
                            }
                        } else {
                            throw zzbu.zzc("Leaf atom defines extended atom size (unsupported).");
                        }
                    } else if (this.zzq <= 2147483647L) {
                        this.zzs = null;
                        this.zzo = 1;
                    } else {
                        throw zzbu.zzc("Skipping atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw zzbu.zzc("Atom size less than header length (unsupported).");
                }
            } else if (i3 == 1) {
                int i8 = ((int) this.zzq) - this.zzr;
                zzef zzef2 = this.zzs;
                if (zzef2 != null) {
                    ((zzyy) zzzj2).zzn(zzef2.zzH(), 8, i8, false);
                    zzaew zzaew = new zzaew(this.zzp, zzef2);
                    long zzf4 = zzzj.zzf();
                    if (!this.zzm.isEmpty()) {
                        ((zzaev) this.zzm.peek()).zzd(zzaew);
                    } else {
                        int i9 = zzaew.zzd;
                        if (i9 == 1936286840) {
                            zzef zzef3 = zzaew.zza;
                            zzef3.zzF(8);
                            int zze2 = zzef3.zze();
                            zzef3.zzG(4);
                            long zzs2 = zzef3.zzs();
                            if (zzaex.zze(zze2) == 0) {
                                j6 = zzef3.zzs();
                                j5 = zzef3.zzs();
                            } else {
                                j6 = zzef3.zzt();
                                j5 = zzef3.zzt();
                            }
                            long j11 = zzf4 + j5;
                            long j12 = j6;
                            long zzw2 = zzen.zzw(j12, 1000000, zzs2);
                            zzef3.zzG(2);
                            int zzo2 = zzef3.zzo();
                            int[] iArr = new int[zzo2];
                            long[] jArr = new long[zzo2];
                            long[] jArr2 = new long[zzo2];
                            long[] jArr3 = new long[zzo2];
                            long j13 = zzw2;
                            while (i4 < zzo2) {
                                int zze3 = zzef3.zze();
                                if ((zze3 & Integer.MIN_VALUE) == 0) {
                                    long zzs3 = zzef3.zzs();
                                    iArr[i4] = zze3 & Integer.MAX_VALUE;
                                    jArr[i4] = j11;
                                    jArr3[i4] = j13;
                                    long j14 = j12 + zzs3;
                                    int i10 = zzo2;
                                    long[] jArr4 = jArr3;
                                    long j15 = j14;
                                    long[] jArr5 = jArr2;
                                    long zzw3 = zzen.zzw(j14, 1000000, zzs2);
                                    jArr5[i4] = zzw3 - jArr4[i4];
                                    zzef3.zzG(4);
                                    j11 += (long) iArr[i4];
                                    i4++;
                                    jArr3 = jArr4;
                                    jArr = jArr;
                                    jArr2 = jArr5;
                                    j13 = zzw3;
                                    j12 = j15;
                                    zzo2 = i10;
                                } else {
                                    throw zzbu.zza("Unhandled indirect reference", (Throwable) null);
                                }
                            }
                            Pair create = Pair.create(Long.valueOf(zzw2), new zzyw(iArr, jArr, jArr2, jArr3));
                            this.zzx = ((Long) create.first).longValue();
                            this.zzD.zzN((zzaal) create.second);
                            this.zzG = true;
                        } else if (i9 == 1701671783) {
                            zzef zzef4 = zzaew.zza;
                            if (this.zzE.length != 0) {
                                zzef4.zzF(8);
                                int zze4 = zzaex.zze(zzef4.zze());
                                if (zze4 == 0) {
                                    String zzv2 = zzef4.zzv(0);
                                    if (zzv2 != null) {
                                        String zzv3 = zzef4.zzv(0);
                                        if (zzv3 != null) {
                                            long zzs4 = zzef4.zzs();
                                            long zzw4 = zzen.zzw(zzef4.zzs(), 1000000, zzs4);
                                            long j16 = this.zzx;
                                            long j17 = j16 != C.TIME_UNSET ? j16 + zzw4 : -9223372036854775807L;
                                            str2 = zzv2;
                                            j2 = zzen.zzw(zzef4.zzs(), 1000, zzs4);
                                            str = zzv3;
                                            j = zzef4.zzs();
                                            j3 = zzw4;
                                            j4 = j17;
                                        } else {
                                            throw null;
                                        }
                                    } else {
                                        throw null;
                                    }
                                } else if (zze4 != 1) {
                                    zzdw.zze("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + zze4);
                                } else {
                                    long zzs5 = zzef4.zzs();
                                    long zzw5 = zzen.zzw(zzef4.zzt(), 1000000, zzs5);
                                    long zzw6 = zzen.zzw(zzef4.zzs(), 1000, zzs5);
                                    long zzs6 = zzef4.zzs();
                                    String zzv4 = zzef4.zzv(0);
                                    if (zzv4 != null) {
                                        String zzv5 = zzef4.zzv(0);
                                        if (zzv5 != null) {
                                            str2 = zzv4;
                                            j2 = zzw6;
                                            str = zzv5;
                                            j = zzs6;
                                            j4 = zzw5;
                                            j3 = -9223372036854775807L;
                                        } else {
                                            throw null;
                                        }
                                    } else {
                                        throw null;
                                    }
                                }
                                byte[] bArr = new byte[zzef4.zza()];
                                zzef4.zzB(bArr, 0, zzef4.zza());
                                zzef zzef5 = new zzef(this.zzk.zza(new zzacf(str2, str, j2, j, bArr)));
                                int zza2 = zzef5.zza();
                                for (zzaap zzq2 : this.zzE) {
                                    zzef5.zzF(0);
                                    zzq2.zzq(zzef5, zza2);
                                }
                                if (j4 == C.TIME_UNSET) {
                                    this.zzn.addLast(new zzafj(j3, true, zza2));
                                    this.zzu += zza2;
                                } else if (!this.zzn.isEmpty()) {
                                    this.zzn.addLast(new zzafj(j4, false, zza2));
                                    this.zzu += zza2;
                                } else {
                                    zzaap[] zzaapArr = this.zzE;
                                    int length = zzaapArr.length;
                                    while (i4 < length) {
                                        zzaapArr[i4].zzs(j4, 1, zza2, 0, (zzaao) null);
                                        i4++;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    ((zzyy) zzzj2).zzo(i8, false);
                }
                zzi(zzzj.zzf());
            } else if (i3 != 2) {
                zzafk = this.zzy;
                if (zzafk != null) {
                    break;
                }
                SparseArray sparseArray = this.zze;
                int size2 = sparseArray.size();
                long j18 = Long.MAX_VALUE;
                zzafk zzafk2 = null;
                for (int i11 = 0; i11 < size2; i11++) {
                    zzafk zzafk3 = (zzafk) sparseArray.valueAt(i11);
                    if ((zzafk3.zzl || zzafk3.zzf != zzafk3.zzd.zzb) && (!zzafk3.zzl || zzafk3.zzh != zzafk3.zzb.zzd)) {
                        long zzd3 = zzafk3.zzd();
                        if (zzd3 < j18) {
                            zzafk2 = zzafk3;
                            j18 = zzd3;
                        }
                    }
                }
                if (zzafk2 == null) {
                    int zzf5 = (int) (this.zzt - zzzj.zzf());
                    if (zzf5 >= 0) {
                        ((zzyy) zzzj2).zzo(zzf5, false);
                        zzg();
                    } else {
                        throw zzbu.zza("Offset to end of mdat was negative.", (Throwable) null);
                    }
                } else {
                    int zzd4 = (int) (zzafk2.zzd() - zzzj.zzf());
                    if (zzd4 < 0) {
                        zzdw.zze("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                        zzd4 = 0;
                    }
                    ((zzyy) zzzj2).zzo(zzd4, false);
                    this.zzy = zzafk2;
                    zzafk = zzafk2;
                }
            } else {
                int size3 = this.zze.size();
                long j19 = Long.MAX_VALUE;
                zzafk zzafk4 = null;
                for (int i12 = 0; i12 < size3; i12++) {
                    zzafx zzafx2 = ((zzafk) this.zze.valueAt(i12)).zzb;
                    if (zzafx2.zzo) {
                        long j20 = zzafx2.zzc;
                        if (j20 < j19) {
                            zzafk4 = (zzafk) this.zze.valueAt(i12);
                            j19 = j20;
                        }
                    }
                }
                if (zzafk4 == null) {
                    this.zzo = 3;
                } else {
                    int zzf6 = (int) (j19 - zzzj.zzf());
                    if (zzf6 >= 0) {
                        zzyy zzyy = (zzyy) zzzj2;
                        zzyy.zzo(zzf6, false);
                        zzafx zzafx3 = zzafk4.zzb;
                        zzef zzef6 = zzafx3.zzn;
                        zzyy.zzn(zzef6.zzH(), 0, zzef6.zzd(), false);
                        zzafx3.zzn.zzF(0);
                        zzafx3.zzo = false;
                    } else {
                        throw zzbu.zza("Offset to encryption data was negative.", (Throwable) null);
                    }
                }
            }
        }
        if (this.zzo == 3) {
            int zzb2 = zzafk.zzb();
            this.zzz = zzb2;
            if (zzafk.zzf < zzafk.zzi) {
                ((zzyy) zzzj2).zzo(zzb2, false);
                zzafw zzf7 = zzafk.zzf();
                if (zzf7 != null) {
                    zzef zzef7 = zzafk.zzb.zzn;
                    int i13 = zzf7.zzd;
                    if (i13 != 0) {
                        zzef7.zzG(i13);
                    }
                    if (zzafk.zzb.zzb(zzafk.zzf)) {
                        zzef7.zzG(zzef7.zzo() * 6);
                    }
                }
                if (!zzafk.zzk()) {
                    this.zzy = null;
                }
                this.zzo = 3;
                return 0;
            }
            if (zzafk.zzd.zza.zzg == 1) {
                this.zzz = zzb2 - 8;
                ((zzyy) zzzj2).zzo(8, false);
            }
            if ("audio/ac4".equals(zzafk.zzd.zza.zzf.zzm)) {
                this.zzA = zzafk.zzc(this.zzz, 7);
                zzym.zzb(this.zzz, this.zzj);
                zzafk.zza.zzq(this.zzj, 7);
                i2 = this.zzA + 7;
                this.zzA = i2;
            } else {
                i2 = zzafk.zzc(this.zzz, 0);
                this.zzA = i2;
            }
            this.zzz += i2;
            this.zzo = 4;
            this.zzB = 0;
        }
        zzafv zzafv = zzafk.zzd.zza;
        zzaap zzaap = zzafk.zza;
        long zze5 = zzafk.zze();
        int i14 = zzafv.zzj;
        if (i14 == 0) {
            while (true) {
                int i15 = this.zzA;
                int i16 = this.zzz;
                if (i15 >= i16) {
                    break;
                }
                this.zzA += zzaap.zze(zzzj2, i16 - i15, false);
            }
        } else {
            byte[] zzH = this.zzg.zzH();
            zzH[0] = 0;
            zzH[1] = 0;
            zzH[2] = 0;
            int i17 = i14 + 1;
            int i18 = 4 - i14;
            while (this.zzA < this.zzz) {
                int i19 = this.zzB;
                if (i19 == 0) {
                    ((zzyy) zzzj2).zzn(zzH, i18, i17, false);
                    this.zzg.zzF(0);
                    int zze6 = this.zzg.zze();
                    if (zze6 > 0) {
                        this.zzB = zze6 - 1;
                        this.zzf.zzF(0);
                        zzaap.zzq(this.zzf, 4);
                        zzaap.zzq(this.zzg, z ? 1 : 0);
                        if (this.zzF.length > 0) {
                            String str3 = zzafv.zzf.zzm;
                            byte b = zzH[4];
                            byte[] bArr2 = zzaaf.zza;
                            if (("video/avc".equals(str3) && (b & 31) == 6) || ("video/hevc".equals(str3) && ((b & true ? 1 : 0) >> z) == 39)) {
                                z2 = z;
                                this.zzC = z2;
                                this.zzA += 5;
                                this.zzz += i18;
                            }
                        }
                        z2 = false;
                        this.zzC = z2;
                        this.zzA += 5;
                        this.zzz += i18;
                    } else {
                        throw zzbu.zza("Invalid NAL length", th);
                    }
                } else {
                    if (this.zzC) {
                        this.zzh.zzC(i19);
                        ((zzyy) zzzj2).zzn(this.zzh.zzH(), 0, this.zzB, false);
                        zzaap.zzq(this.zzh, this.zzB);
                        i = this.zzB;
                        zzef zzef8 = this.zzh;
                        int zzb3 = zzaaf.zzb(zzef8.zzH(), zzef8.zzd());
                        this.zzh.zzF("video/hevc".equals(zzafv.zzf.zzm) ? 1 : 0);
                        this.zzh.zzE(zzb3);
                        zzyv.zza(zze5, this.zzh, this.zzF);
                    } else {
                        i = zzaap.zze(zzzj2, i19, false);
                    }
                    this.zzA += i;
                    this.zzB -= i;
                    th = null;
                    z = true;
                }
            }
        }
        int zza3 = zzafk.zza();
        zzafw zzf8 = zzafk.zzf();
        zzaap.zzs(zze5, zza3, this.zzz, 0, zzf8 != null ? zzf8.zzc : null);
        while (!this.zzn.isEmpty()) {
            zzafj zzafj = (zzafj) this.zzn.removeFirst();
            this.zzu -= zzafj.zzc;
            long j21 = zzafj.zza;
            if (zzafj.zzb) {
                j21 += zze5;
            }
            for (zzaap zzs7 : this.zzE) {
                zzs7.zzs(j21, 1, zzafj.zzc, this.zzu, (zzaao) null);
            }
        }
        if (!zzafk.zzk()) {
            this.zzy = null;
        }
        this.zzo = 3;
        return 0;
    }

    public final void zzb(zzzl zzzl) {
        this.zzD = zzzl;
        zzg();
        this.zzE = new zzaap[2];
        int i = 0;
        this.zzE = (zzaap[]) zzen.zzae(this.zzE, 0);
        for (zzaap zzk2 : this.zzE) {
            zzk2.zzk(zzc);
        }
        this.zzF = new zzaap[this.zzd.size()];
        int i2 = 100;
        while (i < this.zzF.length) {
            int i3 = i2 + 1;
            zzaap zzv2 = this.zzD.zzv(i2, 3);
            zzv2.zzk((zzaf) this.zzd.get(i));
            this.zzF[i] = zzv2;
            i++;
            i2 = i3;
        }
    }

    public final void zzc(long j, long j2) {
        int size = this.zze.size();
        for (int i = 0; i < size; i++) {
            ((zzafk) this.zze.valueAt(i)).zzi();
        }
        this.zzn.clear();
        this.zzu = 0;
        this.zzv = j2;
        this.zzm.clear();
        zzg();
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        return zzafu.zza(zzzj);
    }

    public zzafl(int i, zzel zzel) {
        this.zzd = Collections.unmodifiableList(Collections.emptyList());
        this.zzk = new zzacg();
        this.zzl = new zzef(16);
        this.zzf = new zzef(zzaaf.zza);
        this.zzg = new zzef(5);
        this.zzh = new zzef();
        this.zzi = new byte[16];
        this.zzj = new zzef(this.zzi);
        this.zzm = new ArrayDeque();
        this.zzn = new ArrayDeque();
        this.zze = new SparseArray();
        this.zzw = C.TIME_UNSET;
        this.zzv = C.TIME_UNSET;
        this.zzx = C.TIME_UNSET;
        this.zzD = zzzl.zza;
        this.zzE = new zzaap[0];
        this.zzF = new zzaap[0];
    }
}
