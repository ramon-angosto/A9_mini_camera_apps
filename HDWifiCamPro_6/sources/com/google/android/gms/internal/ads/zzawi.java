package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzawi implements zzauz {
    public static final zzavb zza = new zzawf();
    private static final int zzb = zzbar.zzg("seig");
    private static final byte[] zzc = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final SparseArray zzd;
    private final zzbak zze;
    private final zzbak zzf;
    private final zzbak zzg;
    private final zzbak zzh;
    private final zzbak zzi;
    private final byte[] zzj;
    private final Stack zzk;
    private final LinkedList zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private int zzp;
    private zzbak zzq;
    private long zzr;
    private long zzs;
    private zzawh zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private zzava zzx;
    private boolean zzy;

    public zzawi() {
        this(0, (zzbao) null, (zzawo) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzauv zza(java.util.List r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r3 = r1
            r4 = r2
        L_0x0008:
            if (r3 >= r0) goto L_0x00b7
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzavv r5 = (com.google.android.gms.internal.ads.zzavv) r5
            int r6 = r5.zzaR
            int r7 = com.google.android.gms.internal.ads.zzavw.zzX
            if (r6 != r7) goto L_0x00b3
            if (r4 != 0) goto L_0x001d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001d:
            com.google.android.gms.internal.ads.zzbak r5 = r5.zza
            byte[] r5 = r5.zza
            com.google.android.gms.internal.ads.zzbak r6 = new com.google.android.gms.internal.ads.zzbak
            r6.<init>((byte[]) r5)
            int r7 = r6.zzd()
            r8 = 32
            if (r7 >= r8) goto L_0x0030
        L_0x002e:
            r6 = r2
            goto L_0x0097
        L_0x0030:
            r6.zzv(r1)
            int r7 = r6.zze()
            int r8 = r6.zza()
            int r8 = r8 + 4
            if (r7 == r8) goto L_0x0040
            goto L_0x002e
        L_0x0040:
            int r7 = r6.zze()
            int r8 = com.google.android.gms.internal.ads.zzavw.zzX
            if (r7 == r8) goto L_0x0049
            goto L_0x002e
        L_0x0049:
            int r7 = r6.zze()
            int r7 = com.google.android.gms.internal.ads.zzavw.zzf(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x006b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Unsupported pssh version: "
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "PsshAtomUtil"
            android.util.Log.w(r7, r6)
            goto L_0x002e
        L_0x006b:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.zzl()
            long r12 = r6.zzl()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x0083
            int r7 = r6.zzi()
            int r7 = r7 * 16
            r6.zzw(r7)
        L_0x0083:
            int r7 = r6.zzi()
            int r8 = r6.zza()
            if (r7 == r8) goto L_0x008e
            goto L_0x002e
        L_0x008e:
            byte[] r8 = new byte[r7]
            r6.zzq(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L_0x0097:
            if (r6 != 0) goto L_0x009b
            r6 = r2
            goto L_0x009f
        L_0x009b:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L_0x009f:
            if (r6 != 0) goto L_0x00a9
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto L_0x00b3
        L_0x00a9:
            com.google.android.gms.internal.ads.zzauu r7 = new com.google.android.gms.internal.ads.zzauu
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5, r1)
            r4.add(r7)
        L_0x00b3:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x00b7:
            if (r4 != 0) goto L_0x00ba
            return r2
        L_0x00ba:
            com.google.android.gms.internal.ads.zzauv r14 = new com.google.android.gms.internal.ads.zzauv
            r14.<init>((java.util.List) r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawi.zza(java.util.List):com.google.android.gms.internal.ads.zzauv");
    }

    private final void zzb() {
        this.zzm = 0;
        this.zzp = 0;
    }

    private static void zzc(zzbak zzbak, int i, zzawq zzawq) throws zzasz {
        zzbak.zzv(i + 8);
        int zze2 = zzavw.zze(zzbak.zze());
        if ((zze2 & 1) == 0) {
            boolean z = (zze2 & 2) != 0;
            int zzi2 = zzbak.zzi();
            int i2 = zzawq.zze;
            if (zzi2 == i2) {
                Arrays.fill(zzawq.zzm, 0, zzi2, z);
                zzawq.zza(zzbak.zza());
                zzbak.zzq(zzawq.zzp.zza, 0, zzawq.zzo);
                zzawq.zzp.zzv(0);
                zzawq.zzq = false;
                return;
            }
            throw new zzasz("Length mismatch: " + zzi2 + ", " + i2);
        }
        throw new zzasz("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0388  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x059d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzh(long r50) throws com.google.android.gms.internal.ads.zzasz {
        /*
            r49 = this;
        L_0x0000:
            r0 = r49
        L_0x0002:
            java.util.Stack r1 = r0.zzk
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0634
            java.util.Stack r1 = r0.zzk
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzavu r1 = (com.google.android.gms.internal.ads.zzavu) r1
            long r1 = r1.zza
            int r1 = (r1 > r50 ? 1 : (r1 == r50 ? 0 : -1))
            if (r1 != 0) goto L_0x0634
            java.util.Stack r1 = r0.zzk
            java.lang.Object r1 = r1.pop()
            com.google.android.gms.internal.ads.zzavu r1 = (com.google.android.gms.internal.ads.zzavu) r1
            int r2 = r1.zzaR
            int r3 = com.google.android.gms.internal.ads.zzavw.zzE
            r4 = 12
            r5 = 8
            r7 = 1
            if (r2 != r3) goto L_0x015d
            java.util.List r2 = r1.zzb
            com.google.android.gms.internal.ads.zzauv r2 = zza(r2)
            int r3 = com.google.android.gms.internal.ads.zzavw.zzP
            com.google.android.gms.internal.ads.zzavu r3 = r1.zza(r3)
            android.util.SparseArray r14 = new android.util.SparseArray
            r14.<init>()
            java.util.List r8 = r3.zzb
            int r8 = r8.size()
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = r9
            r9 = 0
        L_0x0049:
            if (r9 >= r8) goto L_0x00b3
            java.util.List r10 = r3.zzb
            java.lang.Object r10 = r10.get(r9)
            com.google.android.gms.internal.ads.zzavv r10 = (com.google.android.gms.internal.ads.zzavv) r10
            int r11 = r10.zzaR
            int r12 = com.google.android.gms.internal.ads.zzavw.zzB
            if (r11 != r12) goto L_0x0091
            com.google.android.gms.internal.ads.zzbak r10 = r10.zza
            r10.zzv(r4)
            int r11 = r10.zze()
            int r12 = r10.zzi()
            int r13 = r10.zzi()
            int r6 = r10.zzi()
            int r10 = r10.zze()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            com.google.android.gms.internal.ads.zzawe r4 = new com.google.android.gms.internal.ads.zzawe
            int r12 = r12 + -1
            r4.<init>(r12, r13, r6, r10)
            android.util.Pair r4 = android.util.Pair.create(r11, r4)
            java.lang.Object r6 = r4.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r4 = r4.second
            com.google.android.gms.internal.ads.zzawe r4 = (com.google.android.gms.internal.ads.zzawe) r4
            r14.put(r6, r4)
            goto L_0x00ae
        L_0x0091:
            int r4 = com.google.android.gms.internal.ads.zzavw.zzQ
            if (r11 != r4) goto L_0x00ae
            com.google.android.gms.internal.ads.zzbak r4 = r10.zza
            r4.zzv(r5)
            int r6 = r4.zze()
            int r6 = com.google.android.gms.internal.ads.zzavw.zzf(r6)
            if (r6 != 0) goto L_0x00a9
            long r10 = r4.zzm()
            goto L_0x00ad
        L_0x00a9:
            long r10 = r4.zzn()
        L_0x00ad:
            r15 = r10
        L_0x00ae:
            int r9 = r9 + 1
            r4 = 12
            goto L_0x0049
        L_0x00b3:
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            java.util.List r4 = r1.zzc
            int r4 = r4.size()
            r5 = 0
        L_0x00bf:
            if (r5 >= r4) goto L_0x00e7
            java.util.List r6 = r1.zzc
            java.lang.Object r6 = r6.get(r5)
            r8 = r6
            com.google.android.gms.internal.ads.zzavu r8 = (com.google.android.gms.internal.ads.zzavu) r8
            int r6 = r8.zzaR
            int r9 = com.google.android.gms.internal.ads.zzavw.zzG
            if (r6 != r9) goto L_0x00e4
            int r6 = com.google.android.gms.internal.ads.zzavw.zzF
            com.google.android.gms.internal.ads.zzavv r9 = r1.zzb(r6)
            r13 = 0
            r10 = r15
            r12 = r2
            com.google.android.gms.internal.ads.zzawo r6 = com.google.android.gms.internal.ads.zzawd.zza(r8, r9, r10, r12, r13)
            if (r6 == 0) goto L_0x00e4
            int r8 = r6.zza
            r3.put(r8, r6)
        L_0x00e4:
            int r5 = r5 + 1
            goto L_0x00bf
        L_0x00e7:
            int r1 = r3.size()
            android.util.SparseArray r2 = r0.zzd
            int r2 = r2.size()
            if (r2 != 0) goto L_0x012f
            r2 = 0
        L_0x00f4:
            if (r2 >= r1) goto L_0x0128
            java.lang.Object r4 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzawo r4 = (com.google.android.gms.internal.ads.zzawo) r4
            com.google.android.gms.internal.ads.zzawh r5 = new com.google.android.gms.internal.ads.zzawh
            com.google.android.gms.internal.ads.zzava r6 = r0.zzx
            int r7 = r4.zzb
            com.google.android.gms.internal.ads.zzavi r6 = r6.zzbi(r2, r7)
            r5.<init>(r6)
            int r6 = r4.zza
            java.lang.Object r6 = r14.get(r6)
            com.google.android.gms.internal.ads.zzawe r6 = (com.google.android.gms.internal.ads.zzawe) r6
            r5.zza(r4, r6)
            android.util.SparseArray r6 = r0.zzd
            int r7 = r4.zza
            r6.put(r7, r5)
            long r5 = r0.zzs
            long r7 = r4.zze
            long r4 = java.lang.Math.max(r5, r7)
            r0.zzs = r4
            int r2 = r2 + 1
            goto L_0x00f4
        L_0x0128:
            com.google.android.gms.internal.ads.zzava r1 = r0.zzx
            r1.zzb()
            goto L_0x0002
        L_0x012f:
            android.util.SparseArray r2 = r0.zzd
            int r2 = r2.size()
            if (r2 != r1) goto L_0x0138
            goto L_0x0139
        L_0x0138:
            r7 = 0
        L_0x0139:
            com.google.android.gms.internal.ads.zzbac.zze(r7)
            r2 = 0
        L_0x013d:
            if (r2 >= r1) goto L_0x0002
            java.lang.Object r4 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzawo r4 = (com.google.android.gms.internal.ads.zzawo) r4
            android.util.SparseArray r5 = r0.zzd
            int r6 = r4.zza
            java.lang.Object r5 = r5.get(r6)
            com.google.android.gms.internal.ads.zzawh r5 = (com.google.android.gms.internal.ads.zzawh) r5
            int r6 = r4.zza
            java.lang.Object r6 = r14.get(r6)
            com.google.android.gms.internal.ads.zzawe r6 = (com.google.android.gms.internal.ads.zzawe) r6
            r5.zza(r4, r6)
            int r2 = r2 + 1
            goto L_0x013d
        L_0x015d:
            int r3 = com.google.android.gms.internal.ads.zzavw.zzN
            if (r2 != r3) goto L_0x061d
            android.util.SparseArray r2 = r0.zzd
            byte[] r3 = r0.zzj
            java.util.List r4 = r1.zzc
            int r4 = r4.size()
            r6 = 0
        L_0x016c:
            if (r6 >= r4) goto L_0x05f2
            java.util.List r8 = r1.zzc
            java.lang.Object r8 = r8.get(r6)
            com.google.android.gms.internal.ads.zzavu r8 = (com.google.android.gms.internal.ads.zzavu) r8
            int r9 = r8.zzaR
            int r10 = com.google.android.gms.internal.ads.zzavw.zzO
            if (r9 != r10) goto L_0x05d8
            int r9 = com.google.android.gms.internal.ads.zzavw.zzA
            com.google.android.gms.internal.ads.zzavv r9 = r8.zzb(r9)
            com.google.android.gms.internal.ads.zzbak r9 = r9.zza
            r9.zzv(r5)
            int r10 = r9.zze()
            int r10 = com.google.android.gms.internal.ads.zzavw.zze(r10)
            int r11 = r9.zze()
            java.lang.Object r11 = r2.get(r11)
            com.google.android.gms.internal.ads.zzawh r11 = (com.google.android.gms.internal.ads.zzawh) r11
            if (r11 != 0) goto L_0x019d
            r11 = 0
            goto L_0x01e4
        L_0x019d:
            r12 = r10 & 1
            if (r12 == 0) goto L_0x01ab
            long r12 = r9.zzn()
            com.google.android.gms.internal.ads.zzawq r14 = r11.zza
            r14.zzb = r12
            r14.zzc = r12
        L_0x01ab:
            com.google.android.gms.internal.ads.zzawe r12 = r11.zzd
            r13 = r10 & 2
            if (r13 == 0) goto L_0x01b8
            int r13 = r9.zzi()
            int r13 = r13 + -1
            goto L_0x01ba
        L_0x01b8:
            int r13 = r12.zza
        L_0x01ba:
            r14 = r10 & 8
            if (r14 == 0) goto L_0x01c3
            int r14 = r9.zzi()
            goto L_0x01c5
        L_0x01c3:
            int r14 = r12.zzb
        L_0x01c5:
            r15 = r10 & 16
            if (r15 == 0) goto L_0x01ce
            int r15 = r9.zzi()
            goto L_0x01d0
        L_0x01ce:
            int r15 = r12.zzc
        L_0x01d0:
            r10 = r10 & 32
            if (r10 == 0) goto L_0x01d9
            int r9 = r9.zzi()
            goto L_0x01db
        L_0x01d9:
            int r9 = r12.zzd
        L_0x01db:
            com.google.android.gms.internal.ads.zzawq r10 = r11.zza
            com.google.android.gms.internal.ads.zzawe r12 = new com.google.android.gms.internal.ads.zzawe
            r12.<init>(r13, r14, r15, r9)
            r10.zza = r12
        L_0x01e4:
            if (r11 != 0) goto L_0x01e8
            goto L_0x05d8
        L_0x01e8:
            com.google.android.gms.internal.ads.zzawq r9 = r11.zza
            long r12 = r9.zzr
            r11.zzb()
            int r10 = com.google.android.gms.internal.ads.zzavw.zzz
            com.google.android.gms.internal.ads.zzavv r10 = r8.zzb(r10)
            if (r10 == 0) goto L_0x0215
            int r10 = com.google.android.gms.internal.ads.zzavw.zzz
            com.google.android.gms.internal.ads.zzavv r10 = r8.zzb(r10)
            com.google.android.gms.internal.ads.zzbak r10 = r10.zza
            r10.zzv(r5)
            int r12 = r10.zze()
            int r12 = com.google.android.gms.internal.ads.zzavw.zzf(r12)
            if (r12 != r7) goto L_0x0211
            long r12 = r10.zzn()
            goto L_0x0215
        L_0x0211:
            long r12 = r10.zzm()
        L_0x0215:
            java.util.List r10 = r8.zzb
            int r14 = r10.size()
            r5 = 0
            r7 = 0
            r15 = 0
        L_0x021e:
            if (r15 >= r14) goto L_0x0250
            java.lang.Object r18 = r10.get(r15)
            r19 = r2
            r2 = r18
            com.google.android.gms.internal.ads.zzavv r2 = (com.google.android.gms.internal.ads.zzavv) r2
            r18 = r4
            int r4 = r2.zzaR
            r20 = r12
            int r12 = com.google.android.gms.internal.ads.zzavw.zzC
            if (r4 != r12) goto L_0x0245
            com.google.android.gms.internal.ads.zzbak r2 = r2.zza
            r4 = 12
            r2.zzv(r4)
            int r2 = r2.zzi()
            if (r2 <= 0) goto L_0x0247
            int r5 = r5 + r2
            int r7 = r7 + 1
            goto L_0x0247
        L_0x0245:
            r4 = 12
        L_0x0247:
            int r15 = r15 + 1
            r4 = r18
            r2 = r19
            r12 = r20
            goto L_0x021e
        L_0x0250:
            r19 = r2
            r18 = r4
            r20 = r12
            r2 = 0
            r4 = 12
            r11.zzg = r2
            r11.zzf = r2
            r11.zze = r2
            com.google.android.gms.internal.ads.zzawq r2 = r11.zza
            r2.zzd = r7
            r2.zze = r5
            int[] r12 = r2.zzg
            if (r12 == 0) goto L_0x026c
            int r12 = r12.length
            if (r12 >= r7) goto L_0x0274
        L_0x026c:
            long[] r12 = new long[r7]
            r2.zzf = r12
            int[] r7 = new int[r7]
            r2.zzg = r7
        L_0x0274:
            int[] r7 = r2.zzh
            if (r7 == 0) goto L_0x027b
            int r7 = r7.length
            if (r7 >= r5) goto L_0x0293
        L_0x027b:
            int r5 = r5 * 125
            int r5 = r5 / 100
            int[] r7 = new int[r5]
            r2.zzh = r7
            int[] r7 = new int[r5]
            r2.zzi = r7
            long[] r7 = new long[r5]
            r2.zzj = r7
            boolean[] r7 = new boolean[r5]
            r2.zzk = r7
            boolean[] r5 = new boolean[r5]
            r2.zzm = r5
        L_0x0293:
            r2 = 0
            r5 = 0
            r7 = 0
        L_0x0296:
            if (r2 >= r14) goto L_0x0402
            java.lang.Object r17 = r10.get(r2)
            r4 = r17
            com.google.android.gms.internal.ads.zzavv r4 = (com.google.android.gms.internal.ads.zzavv) r4
            int r15 = r4.zzaR
            int r12 = com.google.android.gms.internal.ads.zzavw.zzC
            if (r15 != r12) goto L_0x03d8
            int r12 = r7 + 1
            com.google.android.gms.internal.ads.zzbak r4 = r4.zza
            r13 = 8
            r4.zzv(r13)
            int r13 = r4.zze()
            int r13 = com.google.android.gms.internal.ads.zzavw.zze(r13)
            com.google.android.gms.internal.ads.zzawo r15 = r11.zzc
            r24 = r10
            com.google.android.gms.internal.ads.zzawq r10 = r11.zza
            r25 = r12
            com.google.android.gms.internal.ads.zzawe r12 = r10.zza
            r26 = r14
            int[] r14 = r10.zzg
            int r27 = r4.zzi()
            r14[r7] = r27
            long[] r14 = r10.zzf
            r27 = r1
            long r0 = r10.zzb
            r14[r7] = r0
            r28 = r13 & 1
            if (r28 == 0) goto L_0x02e6
            r28 = r6
            int r6 = r4.zze()
            r29 = r8
            r30 = r9
            long r8 = (long) r6
            long r0 = r0 + r8
            r14[r7] = r0
            goto L_0x02ec
        L_0x02e6:
            r28 = r6
            r29 = r8
            r30 = r9
        L_0x02ec:
            r0 = r13 & 4
            int r1 = r12.zzd
            if (r0 == 0) goto L_0x02f6
            int r1 = r4.zzi()
        L_0x02f6:
            r6 = r13 & 256(0x100, float:3.59E-43)
            r8 = r13 & 512(0x200, float:7.175E-43)
            r9 = r13 & 1024(0x400, float:1.435E-42)
            r13 = r13 & 2048(0x800, float:2.87E-42)
            long[] r14 = r15.zzi
            if (r14 == 0) goto L_0x0325
            r31 = r1
            int r1 = r14.length
            r32 = r3
            r3 = 1
            if (r1 != r3) goto L_0x0329
            r1 = 0
            r33 = r14[r1]
            r22 = 0
            int r3 = (r33 > r22 ? 1 : (r33 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x0329
            long[] r3 = r15.zzj
            r33 = r3[r1]
            r35 = 1000(0x3e8, double:4.94E-321)
            r3 = r2
            long r1 = r15.zzc
            r37 = r1
            long r1 = com.google.android.gms.internal.ads.zzbar.zzj(r33, r35, r37)
            r22 = r1
            goto L_0x032c
        L_0x0325:
            r31 = r1
            r32 = r3
        L_0x0329:
            r3 = r2
            r22 = 0
        L_0x032c:
            int[] r1 = r10.zzh
            int[] r2 = r10.zzi
            long[] r14 = r10.zzj
            r33 = r11
            boolean[] r11 = r10.zzk
            r34 = r3
            int r3 = r15.zzb
            int[] r3 = r10.zzg
            r3 = r3[r7]
            int r3 = r3 + r5
            r41 = r14
            long r14 = r15.zzc
            if (r7 <= 0) goto L_0x034c
            r42 = r1
            r43 = r2
            long r1 = r10.zzr
            goto L_0x0352
        L_0x034c:
            r42 = r1
            r43 = r2
            r1 = r20
        L_0x0352:
            if (r5 >= r3) goto L_0x03cf
            if (r6 == 0) goto L_0x035b
            int r7 = r4.zzi()
            goto L_0x035d
        L_0x035b:
            int r7 = r12.zzb
        L_0x035d:
            if (r8 == 0) goto L_0x0368
            int r35 = r4.zzi()
            r44 = r3
            r3 = r35
            goto L_0x036c
        L_0x0368:
            r44 = r3
            int r3 = r12.zzc
        L_0x036c:
            if (r5 != 0) goto L_0x0377
            if (r0 == 0) goto L_0x0376
            r45 = r0
            r0 = r31
            r5 = 0
            goto L_0x0386
        L_0x0376:
            r5 = 0
        L_0x0377:
            if (r9 == 0) goto L_0x0382
            int r35 = r4.zze()
            r45 = r0
            r0 = r35
            goto L_0x0386
        L_0x0382:
            r45 = r0
            int r0 = r12.zzd
        L_0x0386:
            if (r13 == 0) goto L_0x039a
            r46 = r6
            int r6 = r4.zze()
            int r6 = r6 * 1000
            r47 = r8
            r48 = r9
            long r8 = (long) r6
            long r8 = r8 / r14
            int r6 = (int) r8
            r43[r5] = r6
            goto L_0x03a3
        L_0x039a:
            r46 = r6
            r47 = r8
            r48 = r9
            r6 = 0
            r43[r5] = r6
        L_0x03a3:
            r37 = 1000(0x3e8, double:4.94E-321)
            r35 = r1
            r39 = r14
            long r8 = com.google.android.gms.internal.ads.zzbar.zzj(r35, r37, r39)
            long r8 = r8 - r22
            r41[r5] = r8
            r42[r5] = r3
            r3 = 16
            int r0 = r0 >> r3
            r3 = 1
            r0 = r0 & r3
            r0 = r0 ^ r3
            if (r3 == r0) goto L_0x03bd
            r0 = 0
            goto L_0x03be
        L_0x03bd:
            r0 = 1
        L_0x03be:
            r11[r5] = r0
            long r6 = (long) r7
            long r1 = r1 + r6
            int r5 = r5 + 1
            r3 = r44
            r0 = r45
            r6 = r46
            r8 = r47
            r9 = r48
            goto L_0x0352
        L_0x03cf:
            r44 = r3
            r10.zzr = r1
            r7 = r25
            r5 = r44
            goto L_0x03ea
        L_0x03d8:
            r27 = r1
            r34 = r2
            r32 = r3
            r28 = r6
            r29 = r8
            r30 = r9
            r24 = r10
            r33 = r11
            r26 = r14
        L_0x03ea:
            int r2 = r34 + 1
            r0 = r49
            r10 = r24
            r14 = r26
            r1 = r27
            r6 = r28
            r8 = r29
            r9 = r30
            r3 = r32
            r11 = r33
            r4 = 12
            goto L_0x0296
        L_0x0402:
            r27 = r1
            r32 = r3
            r28 = r6
            r29 = r8
            r30 = r9
            r33 = r11
            int r0 = com.google.android.gms.internal.ads.zzavw.zzaf
            com.google.android.gms.internal.ads.zzavv r0 = r8.zzb(r0)
            if (r0 == 0) goto L_0x048f
            r11 = r33
            com.google.android.gms.internal.ads.zzawo r1 = r11.zzc
            com.google.android.gms.internal.ads.zzawp[] r1 = r1.zzh
            r2 = r30
            com.google.android.gms.internal.ads.zzawe r3 = r2.zza
            int r3 = r3.zza
            r1 = r1[r3]
            com.google.android.gms.internal.ads.zzbak r0 = r0.zza
            int r1 = r1.zza
            r3 = 8
            r0.zzv(r3)
            int r4 = r0.zze()
            int r4 = com.google.android.gms.internal.ads.zzavw.zze(r4)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x043c
            r0.zzw(r3)
        L_0x043c:
            int r3 = r0.zzg()
            int r4 = r0.zzi()
            int r5 = r2.zze
            if (r4 != r5) goto L_0x0470
            if (r3 != 0) goto L_0x045f
            boolean[] r3 = r2.zzm
            r5 = 0
            r6 = 0
        L_0x044e:
            if (r5 >= r4) goto L_0x046c
            int r7 = r0.zzg()
            int r6 = r6 + r7
            if (r7 <= r1) goto L_0x0459
            r7 = 1
            goto L_0x045a
        L_0x0459:
            r7 = 0
        L_0x045a:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x044e
        L_0x045f:
            if (r3 <= r1) goto L_0x0463
            r0 = 1
            goto L_0x0464
        L_0x0463:
            r0 = 0
        L_0x0464:
            int r6 = r3 * r4
            boolean[] r1 = r2.zzm
            r3 = 0
            java.util.Arrays.fill(r1, r3, r4, r0)
        L_0x046c:
            r2.zza(r6)
            goto L_0x0491
        L_0x0470:
            com.google.android.gms.internal.ads.zzasz r0 = new com.google.android.gms.internal.ads.zzasz
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Length mismatch: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = ", "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x048f:
            r2 = r30
        L_0x0491:
            int r0 = com.google.android.gms.internal.ads.zzavw.zzag
            com.google.android.gms.internal.ads.zzavv r0 = r8.zzb(r0)
            if (r0 == 0) goto L_0x04e1
            com.google.android.gms.internal.ads.zzbak r0 = r0.zza
            r1 = 8
            r0.zzv(r1)
            int r3 = r0.zze()
            int r4 = com.google.android.gms.internal.ads.zzavw.zze(r3)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x04af
            r0.zzw(r1)
        L_0x04af:
            int r1 = r0.zzi()
            if (r1 != r5) goto L_0x04ca
            long r4 = r2.zzc
            int r1 = com.google.android.gms.internal.ads.zzavw.zzf(r3)
            if (r1 != 0) goto L_0x04c2
            long r0 = r0.zzm()
            goto L_0x04c6
        L_0x04c2:
            long r0 = r0.zzn()
        L_0x04c6:
            long r4 = r4 + r0
            r2.zzc = r4
            goto L_0x04e1
        L_0x04ca:
            com.google.android.gms.internal.ads.zzasz r0 = new com.google.android.gms.internal.ads.zzasz
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected saio entry count: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x04e1:
            int r0 = com.google.android.gms.internal.ads.zzavw.zzak
            com.google.android.gms.internal.ads.zzavv r0 = r8.zzb(r0)
            if (r0 == 0) goto L_0x04ef
            com.google.android.gms.internal.ads.zzbak r0 = r0.zza
            r1 = 0
            zzc(r0, r1, r2)
        L_0x04ef:
            int r0 = com.google.android.gms.internal.ads.zzavw.zzah
            com.google.android.gms.internal.ads.zzavv r0 = r8.zzb(r0)
            int r1 = com.google.android.gms.internal.ads.zzavw.zzai
            com.google.android.gms.internal.ads.zzavv r1 = r8.zzb(r1)
            if (r0 == 0) goto L_0x0593
            if (r1 == 0) goto L_0x0593
            com.google.android.gms.internal.ads.zzbak r0 = r0.zza
            com.google.android.gms.internal.ads.zzbak r1 = r1.zza
            r3 = 8
            r0.zzv(r3)
            int r3 = r0.zze()
            int r4 = r0.zze()
            int r5 = zzb
            if (r4 == r5) goto L_0x0516
            goto L_0x0593
        L_0x0516:
            int r3 = com.google.android.gms.internal.ads.zzavw.zzf(r3)
            r4 = 4
            r5 = 1
            if (r3 != r5) goto L_0x0521
            r0.zzw(r4)
        L_0x0521:
            int r0 = r0.zze()
            if (r0 != r5) goto L_0x058b
            r0 = 8
            r1.zzv(r0)
            int r0 = r1.zze()
            int r3 = r1.zze()
            int r6 = zzb
            if (r3 != r6) goto L_0x0589
            int r0 = com.google.android.gms.internal.ads.zzavw.zzf(r0)
            r3 = 2
            if (r0 != r5) goto L_0x0552
            long r4 = r1.zzm()
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x054a
            goto L_0x0557
        L_0x054a:
            com.google.android.gms.internal.ads.zzasz r0 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r1 = "Variable length decription in sgpd found (unsupported)"
            r0.<init>(r1)
            throw r0
        L_0x0552:
            if (r0 < r3) goto L_0x0557
            r1.zzw(r4)
        L_0x0557:
            long r4 = r1.zzm()
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0581
            r1.zzw(r3)
            int r0 = r1.zzg()
            r3 = 1
            if (r0 != r3) goto L_0x0594
            int r0 = r1.zzg()
            r4 = 16
            byte[] r5 = new byte[r4]
            r6 = 0
            r1.zzq(r5, r6, r4)
            r2.zzl = r3
            com.google.android.gms.internal.ads.zzawp r1 = new com.google.android.gms.internal.ads.zzawp
            r1.<init>(r3, r0, r5)
            r2.zzn = r1
            goto L_0x0594
        L_0x0581:
            com.google.android.gms.internal.ads.zzasz r0 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x0589:
            r3 = r5
            goto L_0x0594
        L_0x058b:
            com.google.android.gms.internal.ads.zzasz r0 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r1 = "Entry count in sbgp != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x0593:
            r3 = 1
        L_0x0594:
            java.util.List r0 = r8.zzb
            int r0 = r0.size()
            r1 = 0
        L_0x059b:
            if (r1 >= r0) goto L_0x05d2
            java.util.List r4 = r8.zzb
            java.lang.Object r4 = r4.get(r1)
            com.google.android.gms.internal.ads.zzavv r4 = (com.google.android.gms.internal.ads.zzavv) r4
            int r5 = r4.zzaR
            int r6 = com.google.android.gms.internal.ads.zzavw.zzaj
            if (r5 != r6) goto L_0x05c6
            com.google.android.gms.internal.ads.zzbak r4 = r4.zza
            r5 = 8
            r4.zzv(r5)
            r6 = r32
            r7 = 16
            r9 = 0
            r4.zzq(r6, r9, r7)
            byte[] r10 = zzc
            boolean r10 = java.util.Arrays.equals(r6, r10)
            if (r10 == 0) goto L_0x05cd
            zzc(r4, r7, r2)
            goto L_0x05cd
        L_0x05c6:
            r6 = r32
            r5 = 8
            r7 = 16
            r9 = 0
        L_0x05cd:
            int r1 = r1 + 1
            r32 = r6
            goto L_0x059b
        L_0x05d2:
            r6 = r32
            r5 = 8
            r9 = 0
            goto L_0x05e3
        L_0x05d8:
            r27 = r1
            r19 = r2
            r18 = r4
            r28 = r6
            r9 = 0
            r6 = r3
            r3 = r7
        L_0x05e3:
            int r0 = r28 + 1
            r7 = r3
            r3 = r6
            r4 = r18
            r2 = r19
            r1 = r27
            r6 = r0
            r0 = r49
            goto L_0x016c
        L_0x05f2:
            r9 = 0
            java.util.List r0 = r1.zzb
            com.google.android.gms.internal.ads.zzauv r0 = zza(r0)
            if (r0 == 0) goto L_0x0000
            r2 = r49
            android.util.SparseArray r1 = r2.zzd
            int r1 = r1.size()
        L_0x0603:
            if (r9 >= r1) goto L_0x0631
            android.util.SparseArray r3 = r2.zzd
            java.lang.Object r3 = r3.valueAt(r9)
            com.google.android.gms.internal.ads.zzawh r3 = (com.google.android.gms.internal.ads.zzawh) r3
            com.google.android.gms.internal.ads.zzavi r4 = r3.zzb
            com.google.android.gms.internal.ads.zzawo r3 = r3.zzc
            com.google.android.gms.internal.ads.zzasw r3 = r3.zzf
            com.google.android.gms.internal.ads.zzasw r3 = r3.zzc(r0)
            r4.zza(r3)
            int r9 = r9 + 1
            goto L_0x0603
        L_0x061d:
            r2 = r0
            java.util.Stack r0 = r2.zzk
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0631
            java.util.Stack r0 = r2.zzk
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzavu r0 = (com.google.android.gms.internal.ads.zzavu) r0
            r0.zzc(r1)
        L_0x0631:
            r0 = r2
            goto L_0x0002
        L_0x0634:
            r2 = r0
            r49.zzb()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawi.zzh(long):void");
    }

    public final void zzd(zzava zzava) {
        this.zzx = zzava;
    }

    public final void zze(long j, long j2) {
        int size = this.zzd.size();
        for (int i = 0; i < size; i++) {
            ((zzawh) this.zzd.valueAt(i)).zzb();
        }
        this.zzl.clear();
        this.zzk.clear();
        zzb();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: com.google.android.gms.internal.ads.zzawh} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzf(com.google.android.gms.internal.ads.zzauy r26, com.google.android.gms.internal.ads.zzave r27) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
        L_0x0004:
            int r2 = r0.zzm
            r4 = 2
            r6 = 8
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0341
            if (r2 == r7) goto L_0x0242
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = 3
            if (r2 == r4) goto L_0x01ea
            if (r2 != r12) goto L_0x00f5
            com.google.android.gms.internal.ads.zzawh r2 = r0.zzt
            if (r2 != 0) goto L_0x0080
            android.util.SparseArray r2 = r0.zzd
            int r13 = r2.size()
            r14 = r10
            r11 = 0
            r10 = r8
        L_0x0026:
            if (r10 >= r13) goto L_0x0048
            java.lang.Object r16 = r2.valueAt(r10)
            r12 = r16
            com.google.android.gms.internal.ads.zzawh r12 = (com.google.android.gms.internal.ads.zzawh) r12
            int r5 = r12.zzg
            com.google.android.gms.internal.ads.zzawq r3 = r12.zza
            int r9 = r3.zzd
            if (r5 != r9) goto L_0x0039
            goto L_0x0044
        L_0x0039:
            long[] r3 = r3.zzf
            r18 = r3[r5]
            int r3 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r3 >= 0) goto L_0x0044
            r11 = r12
            r14 = r18
        L_0x0044:
            int r10 = r10 + 1
            r12 = 3
            goto L_0x0026
        L_0x0048:
            if (r11 != 0) goto L_0x0063
            long r2 = r0.zzr
            long r4 = r26.zzd()
            long r2 = r2 - r4
            int r2 = (int) r2
            if (r2 < 0) goto L_0x005b
            r1.zzi(r2, r8)
            r25.zzb()
            goto L_0x0004
        L_0x005b:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Offset to end of mdat was negative."
            r1.<init>(r2)
            throw r1
        L_0x0063:
            com.google.android.gms.internal.ads.zzawq r2 = r11.zza
            long[] r2 = r2.zzf
            int r3 = r11.zzg
            r9 = r2[r3]
            long r2 = r26.zzd()
            long r9 = r9 - r2
            int r2 = (int) r9
            if (r2 >= 0) goto L_0x007b
            java.lang.String r2 = "FragmentedMp4Extractor"
            java.lang.String r3 = "Ignoring negative offset to sample data."
            android.util.Log.w(r2, r3)
            r2 = r8
        L_0x007b:
            r1.zzi(r2, r8)
            r0.zzt = r11
        L_0x0080:
            com.google.android.gms.internal.ads.zzawh r2 = r0.zzt
            com.google.android.gms.internal.ads.zzawq r3 = r2.zza
            int[] r5 = r3.zzh
            int r9 = r2.zze
            r5 = r5[r9]
            r0.zzu = r5
            boolean r10 = r3.zzl
            if (r10 == 0) goto L_0x00df
            com.google.android.gms.internal.ads.zzbak r5 = r3.zzp
            com.google.android.gms.internal.ads.zzawe r10 = r3.zza
            int r10 = r10.zza
            com.google.android.gms.internal.ads.zzawp r11 = r3.zzn
            if (r11 == 0) goto L_0x009b
            goto L_0x00a1
        L_0x009b:
            com.google.android.gms.internal.ads.zzawo r11 = r2.zzc
            com.google.android.gms.internal.ads.zzawp[] r11 = r11.zzh
            r11 = r11[r10]
        L_0x00a1:
            int r10 = r11.zza
            boolean[] r3 = r3.zzm
            boolean r3 = r3[r9]
            com.google.android.gms.internal.ads.zzbak r9 = r0.zzh
            byte[] r11 = r9.zza
            if (r7 == r3) goto L_0x00af
            r12 = r8
            goto L_0x00b1
        L_0x00af:
            r12 = 128(0x80, float:1.794E-43)
        L_0x00b1:
            r12 = r12 | r10
            byte r12 = (byte) r12
            r11[r8] = r12
            r9.zzv(r8)
            com.google.android.gms.internal.ads.zzavi r2 = r2.zzb
            com.google.android.gms.internal.ads.zzbak r9 = r0.zzh
            r2.zzb(r9, r7)
            r2.zzb(r5, r10)
            if (r3 != 0) goto L_0x00c6
            int r10 = r10 + r7
            goto L_0x00d6
        L_0x00c6:
            int r3 = r5.zzj()
            r9 = -2
            r5.zzw(r9)
            int r3 = r3 * 6
            int r3 = r3 + r4
            r2.zzb(r5, r3)
            int r10 = r10 + r7
            int r10 = r10 + r3
        L_0x00d6:
            r0.zzv = r10
            int r2 = r0.zzu
            int r5 = r2 + r10
            r0.zzu = r5
            goto L_0x00e1
        L_0x00df:
            r0.zzv = r8
        L_0x00e1:
            com.google.android.gms.internal.ads.zzawh r2 = r0.zzt
            com.google.android.gms.internal.ads.zzawo r2 = r2.zzc
            int r2 = r2.zzg
            if (r2 != r7) goto L_0x00f0
            int r5 = r5 + -8
            r0.zzu = r5
            r1.zzi(r6, r8)
        L_0x00f0:
            r2 = 4
            r0.zzm = r2
            r0.zzw = r8
        L_0x00f5:
            com.google.android.gms.internal.ads.zzawh r2 = r0.zzt
            com.google.android.gms.internal.ads.zzawq r3 = r2.zza
            com.google.android.gms.internal.ads.zzawo r5 = r2.zzc
            com.google.android.gms.internal.ads.zzavi r9 = r2.zzb
            int r2 = r2.zze
            int r6 = r5.zzk
            if (r6 != 0) goto L_0x0114
        L_0x0103:
            int r4 = r0.zzv
            int r6 = r0.zzu
            if (r4 >= r6) goto L_0x016a
            int r6 = r6 - r4
            int r4 = r9.zzd(r1, r6, r8)
            int r6 = r0.zzv
            int r6 = r6 + r4
            r0.zzv = r6
            goto L_0x0103
        L_0x0114:
            com.google.android.gms.internal.ads.zzbak r10 = r0.zzf
            byte[] r10 = r10.zza
            r10[r8] = r8
            r10[r7] = r8
            r10[r4] = r8
            int r4 = r6 + 1
            r11 = 4
            int r6 = 4 - r6
        L_0x0123:
            int r11 = r0.zzv
            int r12 = r0.zzu
            if (r11 >= r12) goto L_0x016a
            int r11 = r0.zzw
            if (r11 != 0) goto L_0x015b
            r1.zzh(r10, r6, r4, r8)
            com.google.android.gms.internal.ads.zzbak r11 = r0.zzf
            r11.zzv(r8)
            com.google.android.gms.internal.ads.zzbak r11 = r0.zzf
            int r11 = r11.zzi()
            r12 = -1
            int r11 = r11 + r12
            r0.zzw = r11
            com.google.android.gms.internal.ads.zzbak r11 = r0.zze
            r11.zzv(r8)
            com.google.android.gms.internal.ads.zzbak r11 = r0.zze
            r12 = 4
            r9.zzb(r11, r12)
            com.google.android.gms.internal.ads.zzbak r11 = r0.zzf
            r9.zzb(r11, r7)
            int r11 = r0.zzv
            int r11 = r11 + 5
            r0.zzv = r11
            int r11 = r0.zzu
            int r11 = r11 + r6
            r0.zzu = r11
            goto L_0x0123
        L_0x015b:
            int r11 = r9.zzd(r1, r11, r8)
            int r12 = r0.zzv
            int r12 = r12 + r11
            r0.zzv = r12
            int r12 = r0.zzw
            int r12 = r12 - r11
            r0.zzw = r12
            goto L_0x0123
        L_0x016a:
            long[] r1 = r3.zzj
            r10 = r1[r2]
            int[] r1 = r3.zzi
            r1 = r1[r2]
            long r12 = (long) r1
            long r10 = r10 + r12
            r12 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r12
            boolean r1 = r3.zzl
            if (r7 == r1) goto L_0x017d
            r4 = r8
            goto L_0x017f
        L_0x017d:
            r4 = 1073741824(0x40000000, float:2.0)
        L_0x017f:
            boolean[] r6 = r3.zzk
            boolean r2 = r6[r2]
            r12 = r4 | r2
            if (r1 == 0) goto L_0x01a6
            com.google.android.gms.internal.ads.zzawp r1 = r3.zzn
            if (r1 != 0) goto L_0x0193
            com.google.android.gms.internal.ads.zzawp[] r1 = r5.zzh
            com.google.android.gms.internal.ads.zzawe r2 = r3.zza
            int r2 = r2.zza
            r1 = r1[r2]
        L_0x0193:
            r5 = r1
            com.google.android.gms.internal.ads.zzawh r1 = r0.zzt
            com.google.android.gms.internal.ads.zzawp r2 = r1.zzi
            if (r5 == r2) goto L_0x01a2
            com.google.android.gms.internal.ads.zzavh r1 = new com.google.android.gms.internal.ads.zzavh
            byte[] r2 = r5.zzb
            r1.<init>(r7, r2)
            goto L_0x01a4
        L_0x01a2:
            com.google.android.gms.internal.ads.zzavh r1 = r1.zzh
        L_0x01a4:
            r15 = r1
            goto L_0x01a8
        L_0x01a6:
            r5 = 0
            r15 = 0
        L_0x01a8:
            com.google.android.gms.internal.ads.zzawh r1 = r0.zzt
            r1.zzh = r15
            r1.zzi = r5
            int r13 = r0.zzu
            r14 = 0
            r9.zzc(r10, r12, r13, r14, r15)
            java.util.LinkedList r1 = r0.zzl
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x01dc
            com.google.android.gms.internal.ads.zzawh r1 = r0.zzt
            int r2 = r1.zze
            int r2 = r2 + r7
            r1.zze = r2
            int r2 = r1.zzf
            int r2 = r2 + r7
            r1.zzf = r2
            int[] r3 = r3.zzg
            int r4 = r1.zzg
            r3 = r3[r4]
            if (r2 != r3) goto L_0x01d8
            int r4 = r4 + r7
            r1.zzg = r4
            r1.zzf = r8
            r1 = 0
            r0.zzt = r1
        L_0x01d8:
            r1 = 3
            r0.zzm = r1
            return r8
        L_0x01dc:
            r1 = 0
            java.util.LinkedList r2 = r0.zzl
            java.lang.Object r2 = r2.removeFirst()
            com.google.android.gms.internal.ads.zzawg r2 = (com.google.android.gms.internal.ads.zzawg) r2
            int r3 = r2.zzb
            long r2 = r2.zza
            throw r1
        L_0x01ea:
            android.util.SparseArray r2 = r0.zzd
            int r2 = r2.size()
            r3 = r8
            r4 = 0
        L_0x01f2:
            if (r3 >= r2) goto L_0x0214
            android.util.SparseArray r5 = r0.zzd
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zzawh r5 = (com.google.android.gms.internal.ads.zzawh) r5
            com.google.android.gms.internal.ads.zzawq r5 = r5.zza
            boolean r6 = r5.zzq
            if (r6 == 0) goto L_0x0211
            long r5 = r5.zzc
            int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0211
            android.util.SparseArray r4 = r0.zzd
            java.lang.Object r4 = r4.valueAt(r3)
            com.google.android.gms.internal.ads.zzawh r4 = (com.google.android.gms.internal.ads.zzawh) r4
            r10 = r5
        L_0x0211:
            int r3 = r3 + 1
            goto L_0x01f2
        L_0x0214:
            if (r4 != 0) goto L_0x021b
            r2 = 3
            r0.zzm = r2
            goto L_0x0004
        L_0x021b:
            long r2 = r26.zzd()
            long r10 = r10 - r2
            int r2 = (int) r10
            if (r2 < 0) goto L_0x023a
            r1.zzi(r2, r8)
            com.google.android.gms.internal.ads.zzawq r2 = r4.zza
            com.google.android.gms.internal.ads.zzbak r3 = r2.zzp
            byte[] r3 = r3.zza
            int r4 = r2.zzo
            r1.zzh(r3, r8, r4, r8)
            com.google.android.gms.internal.ads.zzbak r3 = r2.zzp
            r3.zzv(r8)
            r2.zzq = r8
            goto L_0x0004
        L_0x023a:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Offset to encryption data was negative."
            r1.<init>(r2)
            throw r1
        L_0x0242:
            long r2 = r0.zzo
            int r2 = (int) r2
            int r3 = r0.zzp
            int r2 = r2 - r3
            com.google.android.gms.internal.ads.zzbak r3 = r0.zzq
            if (r3 == 0) goto L_0x0335
            byte[] r3 = r3.zza
            r1.zzh(r3, r6, r2, r8)
            com.google.android.gms.internal.ads.zzavv r2 = new com.google.android.gms.internal.ads.zzavv
            int r3 = r0.zzn
            com.google.android.gms.internal.ads.zzbak r5 = r0.zzq
            r2.<init>(r3, r5)
            long r9 = r26.zzd()
            java.util.Stack r3 = r0.zzk
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0273
            java.util.Stack r3 = r0.zzk
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzavu r3 = (com.google.android.gms.internal.ads.zzavu) r3
            r3.zzd(r2)
            goto L_0x0338
        L_0x0273:
            int r3 = r2.zzaR
            int r5 = com.google.android.gms.internal.ads.zzavw.zzD
            if (r3 != r5) goto L_0x0338
            com.google.android.gms.internal.ads.zzbak r2 = r2.zza
            r2.zzv(r6)
            int r3 = r2.zze()
            r5 = 4
            r2.zzw(r5)
            long r5 = r2.zzm()
            int r3 = com.google.android.gms.internal.ads.zzavw.zzf(r3)
            if (r3 != 0) goto L_0x0299
            long r11 = r2.zzm()
            long r13 = r2.zzm()
            goto L_0x02a1
        L_0x0299:
            long r11 = r2.zzn()
            long r13 = r2.zzn()
        L_0x02a1:
            long r9 = r9 + r13
            r18 = r9
            r9 = r11
            r13 = 1000000(0xf4240, double:4.940656E-318)
            r11 = r9
            r15 = r5
            long r20 = com.google.android.gms.internal.ads.zzbar.zzj(r11, r13, r15)
            r2.zzw(r4)
            int r3 = r2.zzj()
            int[] r4 = new int[r3]
            long[] r15 = new long[r3]
            long[] r13 = new long[r3]
            long[] r14 = new long[r3]
            r9 = r20
        L_0x02bf:
            if (r8 >= r3) goto L_0x0311
            int r16 = r2.zze()
            r17 = -2147483648(0xffffffff80000000, float:-0.0)
            r17 = r16 & r17
            if (r17 != 0) goto L_0x0309
            long r22 = r2.zzm()
            r17 = 2147483647(0x7fffffff, float:NaN)
            r16 = r16 & r17
            r4[r8] = r16
            r15[r8] = r18
            r14[r8] = r9
            long r9 = r11 + r22
            r16 = 1000000(0xf4240, double:4.940656E-318)
            r11 = r9
            r22 = r3
            r7 = r13
            r3 = r14
            r13 = r16
            r23 = r9
            r9 = r15
            r15 = r5
            long r10 = com.google.android.gms.internal.ads.zzbar.zzj(r11, r13, r15)
            r12 = r3[r8]
            long r12 = r10 - r12
            r7[r8] = r12
            r12 = 4
            r2.zzw(r12)
            r13 = r4[r8]
            long r13 = (long) r13
            long r18 = r18 + r13
            int r8 = r8 + 1
            r14 = r3
            r13 = r7
            r15 = r9
            r9 = r10
            r3 = r22
            r11 = r23
            r7 = 1
            goto L_0x02bf
        L_0x0309:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Unhandled indirect reference"
            r1.<init>(r2)
            throw r1
        L_0x0311:
            r7 = r13
            r3 = r14
            r9 = r15
            java.lang.Long r2 = java.lang.Long.valueOf(r20)
            com.google.android.gms.internal.ads.zzaux r5 = new com.google.android.gms.internal.ads.zzaux
            r5.<init>(r4, r9, r7, r3)
            android.util.Pair r2 = android.util.Pair.create(r2, r5)
            java.lang.Object r3 = r2.first
            java.lang.Long r3 = (java.lang.Long) r3
            r3.longValue()
            com.google.android.gms.internal.ads.zzava r3 = r0.zzx
            java.lang.Object r2 = r2.second
            com.google.android.gms.internal.ads.zzavg r2 = (com.google.android.gms.internal.ads.zzavg) r2
            r3.zzc(r2)
            r2 = 1
            r0.zzy = r2
            goto L_0x0338
        L_0x0335:
            r1.zzi(r2, r8)
        L_0x0338:
            long r2 = r26.zzd()
            r0.zzh(r2)
            goto L_0x0004
        L_0x0341:
            int r2 = r0.zzp
            if (r2 != 0) goto L_0x0369
            com.google.android.gms.internal.ads.zzbak r2 = r0.zzi
            byte[] r2 = r2.zza
            r3 = 1
            boolean r2 = r1.zzh(r2, r8, r6, r3)
            if (r2 != 0) goto L_0x0352
            r2 = -1
            return r2
        L_0x0352:
            r0.zzp = r6
            com.google.android.gms.internal.ads.zzbak r2 = r0.zzi
            r2.zzv(r8)
            com.google.android.gms.internal.ads.zzbak r2 = r0.zzi
            long r2 = r2.zzm()
            r0.zzo = r2
            com.google.android.gms.internal.ads.zzbak r2 = r0.zzi
            int r2 = r2.zze()
            r0.zzn = r2
        L_0x0369:
            long r2 = r0.zzo
            r9 = 1
            int r5 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x0385
            com.google.android.gms.internal.ads.zzbak r2 = r0.zzi
            byte[] r2 = r2.zza
            r1.zzh(r2, r6, r6, r8)
            int r2 = r0.zzp
            int r2 = r2 + r6
            r0.zzp = r2
            com.google.android.gms.internal.ads.zzbak r2 = r0.zzi
            long r2 = r2.zzn()
            r0.zzo = r2
        L_0x0385:
            int r5 = r0.zzp
            long r9 = (long) r5
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 < 0) goto L_0x04bf
            long r2 = r26.zzd()
            long r2 = r2 - r9
            int r5 = r0.zzn
            int r7 = com.google.android.gms.internal.ads.zzavw.zzN
            if (r5 != r7) goto L_0x03b1
            android.util.SparseArray r5 = r0.zzd
            int r5 = r5.size()
            r7 = r8
        L_0x039e:
            if (r7 >= r5) goto L_0x03b1
            android.util.SparseArray r9 = r0.zzd
            java.lang.Object r9 = r9.valueAt(r7)
            com.google.android.gms.internal.ads.zzawh r9 = (com.google.android.gms.internal.ads.zzawh) r9
            com.google.android.gms.internal.ads.zzawq r9 = r9.zza
            r9.zzc = r2
            r9.zzb = r2
            int r7 = r7 + 1
            goto L_0x039e
        L_0x03b1:
            int r5 = r0.zzn
            int r7 = com.google.android.gms.internal.ads.zzavw.zzk
            if (r5 != r7) goto L_0x03d6
            r7 = 0
            r0.zzt = r7
            long r5 = r0.zzo
            long r2 = r2 + r5
            r0.zzr = r2
            boolean r2 = r0.zzy
            if (r2 != 0) goto L_0x03d2
            com.google.android.gms.internal.ads.zzava r2 = r0.zzx
            com.google.android.gms.internal.ads.zzavf r3 = new com.google.android.gms.internal.ads.zzavf
            long r5 = r0.zzs
            r3.<init>(r5)
            r2.zzc(r3)
            r2 = 1
            r0.zzy = r2
        L_0x03d2:
            r0.zzm = r4
            goto L_0x0004
        L_0x03d6:
            int r2 = com.google.android.gms.internal.ads.zzavw.zzE
            if (r5 == r2) goto L_0x0498
            int r2 = com.google.android.gms.internal.ads.zzavw.zzG
            if (r5 == r2) goto L_0x0498
            int r2 = com.google.android.gms.internal.ads.zzavw.zzH
            if (r5 == r2) goto L_0x0498
            int r2 = com.google.android.gms.internal.ads.zzavw.zzI
            if (r5 == r2) goto L_0x0498
            int r2 = com.google.android.gms.internal.ads.zzavw.zzJ
            if (r5 == r2) goto L_0x0498
            int r2 = com.google.android.gms.internal.ads.zzavw.zzN
            if (r5 == r2) goto L_0x0498
            int r2 = com.google.android.gms.internal.ads.zzavw.zzO
            if (r5 == r2) goto L_0x0498
            int r2 = com.google.android.gms.internal.ads.zzavw.zzP
            if (r5 == r2) goto L_0x0498
            int r2 = com.google.android.gms.internal.ads.zzavw.zzS
            if (r5 != r2) goto L_0x03fc
            goto L_0x0498
        L_0x03fc:
            int r2 = com.google.android.gms.internal.ads.zzavw.zzV
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzU
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzF
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzD
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzW
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzz
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzA
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzR
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzB
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzC
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzX
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzaf
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzag
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzak
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzaj
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzah
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzai
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzT
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzQ
            if (r5 == r2) goto L_0x0466
            int r2 = com.google.android.gms.internal.ads.zzavw.zzaI
            if (r5 != r2) goto L_0x0450
            goto L_0x0466
        L_0x0450:
            long r5 = r0.zzo
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x045e
            r2 = 0
            r0.zzq = r2
            r2 = 1
            r0.zzm = r2
            goto L_0x0004
        L_0x045e:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Skipping atom with length > 2147483647 (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x0466:
            int r2 = r0.zzp
            if (r2 != r6) goto L_0x0490
            long r9 = r0.zzo
            int r2 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0488
            com.google.android.gms.internal.ads.zzbak r2 = new com.google.android.gms.internal.ads.zzbak
            int r3 = (int) r9
            r2.<init>((int) r3)
            r0.zzq = r2
            com.google.android.gms.internal.ads.zzbak r2 = r0.zzi
            byte[] r2 = r2.zza
            com.google.android.gms.internal.ads.zzbak r3 = r0.zzq
            byte[] r3 = r3.zza
            java.lang.System.arraycopy(r2, r8, r3, r8, r6)
            r2 = 1
            r0.zzm = r2
            goto L_0x0004
        L_0x0488:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Leaf atom with length > 2147483647 (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x0490:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Leaf atom defines extended atom size (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x0498:
            long r2 = r26.zzd()
            long r6 = r0.zzo
            long r2 = r2 + r6
            r6 = -8
            long r2 = r2 + r6
            java.util.Stack r4 = r0.zzk
            com.google.android.gms.internal.ads.zzavu r6 = new com.google.android.gms.internal.ads.zzavu
            r6.<init>(r5, r2)
            r4.add(r6)
            long r4 = r0.zzo
            int r6 = r0.zzp
            long r6 = (long) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x04ba
            r0.zzh(r2)
            goto L_0x0004
        L_0x04ba:
            r25.zzb()
            goto L_0x0004
        L_0x04bf:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Atom size less than header length (unsupported)."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawi.zzf(com.google.android.gms.internal.ads.zzauy, com.google.android.gms.internal.ads.zzave):int");
    }

    public final boolean zzg(zzauy zzauy) throws IOException, InterruptedException {
        return zzawn.zza(zzauy);
    }

    public zzawi(int i, zzbao zzbao, zzawo zzawo) {
        this.zzi = new zzbak(16);
        this.zze = new zzbak(zzbai.zza);
        this.zzf = new zzbak(5);
        this.zzg = new zzbak();
        this.zzh = new zzbak(1);
        this.zzj = new byte[16];
        this.zzk = new Stack();
        this.zzl = new LinkedList();
        this.zzd = new SparseArray();
        this.zzs = C.TIME_UNSET;
        zzb();
    }
}
