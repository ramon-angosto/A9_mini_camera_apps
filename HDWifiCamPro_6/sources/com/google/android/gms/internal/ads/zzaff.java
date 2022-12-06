package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaff {
    private static final byte[] zza = zzen.zzaa("OpusHead");

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
        if (r3 != 13) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d7, code lost:
        r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zza(com.google.android.gms.internal.ads.zzaew r11) {
        /*
            com.google.android.gms.internal.ads.zzef r11 = r11.zza
            r0 = 8
            r11.zzF(r0)
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x000a:
            int r4 = r11.zza()
            if (r4 < r0) goto L_0x00de
            int r4 = r11.zzc()
            int r5 = r11.zze()
            int r6 = r11.zze()
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r6 != r7) goto L_0x0074
            r11.zzF(r4)
            int r2 = r4 + r5
            r11.zzG(r0)
            zzd(r11)
        L_0x002c:
            int r6 = r11.zzc()
            if (r6 >= r2) goto L_0x0071
            int r6 = r11.zzc()
            int r7 = r11.zze()
            int r8 = r11.zze()
            r9 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r8 != r9) goto L_0x006c
            r11.zzF(r6)
            int r6 = r6 + r7
            r11.zzG(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x004f:
            int r7 = r11.zzc()
            if (r7 >= r6) goto L_0x005f
            com.google.android.gms.internal.ads.zzbp r7 = com.google.android.gms.internal.ads.zzafm.zza(r11)
            if (r7 == 0) goto L_0x004f
            r2.add(r7)
            goto L_0x004f
        L_0x005f:
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L_0x0066
            goto L_0x0071
        L_0x0066:
            com.google.android.gms.internal.ads.zzbq r6 = new com.google.android.gms.internal.ads.zzbq
            r6.<init>((java.util.List) r2)
            goto L_0x0072
        L_0x006c:
            int r6 = r6 + r7
            r11.zzF(r6)
            goto L_0x002c
        L_0x0071:
            r6 = r1
        L_0x0072:
            r2 = r6
            goto L_0x00d8
        L_0x0074:
            r7 = 1936553057(0x736d7461, float:1.8813092E31)
            if (r6 != r7) goto L_0x00d8
            r11.zzF(r4)
            int r3 = r4 + r5
            r6 = 12
            r11.zzG(r6)
        L_0x0083:
            int r7 = r11.zzc()
            if (r7 >= r3) goto L_0x00d7
            int r7 = r11.zzc()
            int r8 = r11.zze()
            int r9 = r11.zze()
            r10 = 1935766900(0x73617574, float:1.7862687E31)
            if (r9 != r10) goto L_0x00d2
            r3 = 14
            if (r8 >= r3) goto L_0x009f
            goto L_0x00d7
        L_0x009f:
            r3 = 5
            r11.zzG(r3)
            int r3 = r11.zzk()
            r7 = 1123024896(0x42f00000, float:120.0)
            if (r3 == r6) goto L_0x00b0
            r6 = 13
            if (r3 == r6) goto L_0x00b4
            goto L_0x00d7
        L_0x00b0:
            if (r3 != r6) goto L_0x00b4
            r7 = 1131413504(0x43700000, float:240.0)
        L_0x00b4:
            r3 = 1
            r11.zzG(r3)
            int r6 = r11.zzk()
            com.google.android.gms.internal.ads.zzbq r8 = new com.google.android.gms.internal.ads.zzbq
            com.google.android.gms.internal.ads.zzbp[] r3 = new com.google.android.gms.internal.ads.zzbp[r3]
            com.google.android.gms.internal.ads.zzadw r9 = new com.google.android.gms.internal.ads.zzadw
            r9.<init>((float) r7, (int) r6)
            r6 = 0
            r3[r6] = r9
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8.<init>(r6, r3)
            r3 = r8
            goto L_0x00d8
        L_0x00d2:
            int r7 = r7 + r8
            r11.zzF(r7)
            goto L_0x0083
        L_0x00d7:
            r3 = r1
        L_0x00d8:
            int r4 = r4 + r5
            r11.zzF(r4)
            goto L_0x000a
        L_0x00de:
            android.util.Pair r11 = android.util.Pair.create(r2, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaff.zza(com.google.android.gms.internal.ads.zzaew):android.util.Pair");
    }

    public static zzbq zzb(zzaev zzaev) {
        zzadq zzadq;
        zzaew zzb = zzaev.zzb(1751411826);
        zzaew zzb2 = zzaev.zzb(1801812339);
        zzaew zzb3 = zzaev.zzb(1768715124);
        if (zzb == null || zzb2 == null || zzb3 == null || zzg(zzb.zza) != 1835299937) {
            return null;
        }
        zzef zzef = zzb2.zza;
        zzef.zzF(12);
        int zze = zzef.zze();
        String[] strArr = new String[zze];
        for (int i = 0; i < zze; i++) {
            int zze2 = zzef.zze();
            zzef.zzG(4);
            strArr[i] = zzef.zzx(zze2 - 8, zzfsk.zzc);
        }
        zzef zzef2 = zzb3.zza;
        zzef2.zzF(8);
        ArrayList arrayList = new ArrayList();
        while (zzef2.zza() > 8) {
            int zzc = zzef2.zzc();
            int zze3 = zzef2.zze();
            int zze4 = zzef2.zze() - 1;
            if (zze4 < 0 || zze4 >= strArr.length) {
                zzdw.zze("AtomParsers", "Skipped metadata with unknown key index: " + zze4);
            } else {
                String str = strArr[zze4];
                int i2 = zzc + zze3;
                int i3 = zzafm.zzb;
                while (true) {
                    int zzc2 = zzef2.zzc();
                    if (zzc2 >= i2) {
                        zzadq = null;
                        break;
                    }
                    int zze5 = zzef2.zze();
                    if (zzef2.zze() == 1684108385) {
                        int zze6 = zzef2.zze();
                        int zze7 = zzef2.zze();
                        int i4 = zze5 - 16;
                        byte[] bArr = new byte[i4];
                        zzef2.zzB(bArr, 0, i4);
                        zzadq = new zzadq(str, bArr, zze7, zze6);
                        break;
                    }
                    zzef2.zzF(zzc2 + zze5);
                }
                if (zzadq != null) {
                    arrayList.add(zzadq);
                }
            }
            zzef2.zzF(zzc + zze3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbq((List) arrayList);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v61, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v38, resolved type: long[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ae, code lost:
        if (r5 == 0) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bb, code lost:
        r5 = -9223372036854775807L;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x068d  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x07eb  */
    /* JADX WARNING: Removed duplicated region for block: B:504:0x0a77  */
    /* JADX WARNING: Removed duplicated region for block: B:516:0x0aaa  */
    /* JADX WARNING: Removed duplicated region for block: B:519:0x0ab9  */
    /* JADX WARNING: Removed duplicated region for block: B:520:0x0abc  */
    /* JADX WARNING: Removed duplicated region for block: B:525:0x0b1a  */
    /* JADX WARNING: Removed duplicated region for block: B:526:0x0b2f  */
    /* JADX WARNING: Removed duplicated region for block: B:554:0x0be1  */
    /* JADX WARNING: Removed duplicated region for block: B:568:0x0c2a  */
    /* JADX WARNING: Removed duplicated region for block: B:569:0x0c2c  */
    /* JADX WARNING: Removed duplicated region for block: B:572:0x0c35  */
    /* JADX WARNING: Removed duplicated region for block: B:639:0x0dac  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:663:0x0d98 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:670:0x0dbf A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List zzc(com.google.android.gms.internal.ads.zzaev r60, com.google.android.gms.internal.ads.zzzx r61, long r62, com.google.android.gms.internal.ads.zzx r64, boolean r65, boolean r66, com.google.android.gms.internal.ads.zzfsm r67) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r0 = r60
            r1 = r61
            r12 = r64
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r15 = 0
        L_0x000c:
            java.util.List r2 = r0.zzc
            int r2 = r2.size()
            if (r15 >= r2) goto L_0x0dc9
            java.util.List r2 = r0.zzc
            java.lang.Object r2 = r2.get(r15)
            r11 = r2
            com.google.android.gms.internal.ads.zzaev r11 = (com.google.android.gms.internal.ads.zzaev) r11
            int r2 = r11.zzd
            r3 = 1953653099(0x7472616b, float:7.681346E31)
            if (r2 == r3) goto L_0x0029
            r0 = r13
            r31 = r15
            goto L_0x0dae
        L_0x0029:
            r2 = 1836476516(0x6d766864, float:4.7662196E27)
            com.google.android.gms.internal.ads.zzaew r2 = r0.zzb(r2)
            if (r2 == 0) goto L_0x0dc7
            r3 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzaev r3 = r11.zza(r3)
            if (r3 == 0) goto L_0x0dc5
            r4 = 1751411826(0x68646c72, float:4.3148E24)
            com.google.android.gms.internal.ads.zzaew r4 = r3.zzb(r4)
            if (r4 == 0) goto L_0x0dc3
            com.google.android.gms.internal.ads.zzef r4 = r4.zza
            int r4 = zzg(r4)
            int r9 = zze(r4)
            r4 = -1
            if (r9 != r4) goto L_0x005b
            r0 = r67
            r2 = r11
            r33 = r13
            r31 = r15
        L_0x0058:
            r10 = 0
            goto L_0x07e2
        L_0x005b:
            r7 = 1953196132(0x746b6864, float:7.46037E31)
            com.google.android.gms.internal.ads.zzaew r7 = r11.zzb(r7)
            if (r7 == 0) goto L_0x0dc1
            com.google.android.gms.internal.ads.zzef r7 = r7.zza
            r10 = 8
            r7.zzF(r10)
            int r18 = r7.zze()
            int r18 = com.google.android.gms.internal.ads.zzaex.zze(r18)
            if (r18 != 0) goto L_0x0077
            r8 = r10
            goto L_0x0079
        L_0x0077:
            r8 = 16
        L_0x0079:
            r7.zzG(r8)
            int r8 = r7.zze()
            r10 = 4
            r7.zzG(r10)
            int r21 = r7.zzc()
            if (r18 != 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r10 = 8
        L_0x008d:
            r14 = 0
        L_0x008e:
            r24 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r14 >= r10) goto L_0x00b6
            byte[] r26 = r7.zzH()
            int r27 = r21 + r14
            byte r5 = r26[r27]
            if (r5 == r4) goto L_0x00b1
            if (r18 != 0) goto L_0x00a6
            long r5 = r7.zzs()
            goto L_0x00aa
        L_0x00a6:
            long r5 = r7.zzt()
        L_0x00aa:
            r26 = 0
            int r10 = (r5 > r26 ? 1 : (r5 == r26 ? 0 : -1))
            if (r10 != 0) goto L_0x00bd
            goto L_0x00bb
        L_0x00b1:
            r26 = 0
            int r14 = r14 + 1
            goto L_0x008e
        L_0x00b6:
            r26 = 0
            r7.zzG(r10)
        L_0x00bb:
            r5 = r24
        L_0x00bd:
            r10 = 16
            r7.zzG(r10)
            int r14 = r7.zze()
            int r10 = r7.zze()
            r4 = 4
            r7.zzG(r4)
            int r4 = r7.zze()
            int r7 = r7.zze()
            r0 = 65536(0x10000, float:9.18355E-41)
            r21 = r9
            r9 = -65536(0xffffffffffff0000, float:NaN)
            if (r14 != 0) goto L_0x00ec
            if (r10 != r0) goto L_0x00eb
            if (r4 != r9) goto L_0x00ea
            if (r7 != 0) goto L_0x00e7
            r14 = 90
            goto L_0x0106
        L_0x00e7:
            r10 = r0
            r4 = r9
            goto L_0x00eb
        L_0x00ea:
            r10 = r0
        L_0x00eb:
            r14 = 0
        L_0x00ec:
            if (r14 != 0) goto L_0x00fa
            if (r10 != r9) goto L_0x00f9
            if (r4 != r0) goto L_0x00f8
            if (r7 != 0) goto L_0x00f7
            r14 = 270(0x10e, float:3.78E-43)
            goto L_0x0106
        L_0x00f7:
            r4 = r0
        L_0x00f8:
            r10 = r9
        L_0x00f9:
            r14 = 0
        L_0x00fa:
            if (r14 != r9) goto L_0x0105
            if (r10 != 0) goto L_0x0105
            if (r4 != 0) goto L_0x0105
            if (r7 != r9) goto L_0x0105
            r14 = 180(0xb4, float:2.52E-43)
            goto L_0x0106
        L_0x0105:
            r14 = 0
        L_0x0106:
            com.google.android.gms.internal.ads.zzafe r0 = new com.google.android.gms.internal.ads.zzafe
            r0.<init>(r8, r5, r14)
            int r4 = (r62 > r24 ? 1 : (r62 == r24 ? 0 : -1))
            if (r4 != 0) goto L_0x0116
            long r4 = r0.zzb
            r31 = r4
            goto L_0x0118
        L_0x0116:
            r31 = r62
        L_0x0118:
            com.google.android.gms.internal.ads.zzef r2 = r2.zza
            r4 = 8
            r2.zzF(r4)
            int r5 = r2.zze()
            int r5 = com.google.android.gms.internal.ads.zzaex.zze(r5)
            if (r5 != 0) goto L_0x012a
            goto L_0x012c
        L_0x012a:
            r4 = 16
        L_0x012c:
            r2.zzG(r4)
            long r28 = r2.zzs()
            int r2 = (r31 > r24 ? 1 : (r31 == r24 ? 0 : -1))
            if (r2 != 0) goto L_0x0138
            goto L_0x0143
        L_0x0138:
            r33 = 1000000(0xf4240, double:4.940656E-318)
            r35 = r28
            long r4 = com.google.android.gms.internal.ads.zzen.zzw(r31, r33, r35)
            r24 = r4
        L_0x0143:
            r2 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzaev r2 = r3.zza(r2)
            if (r2 == 0) goto L_0x0dbf
            r4 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzaev r2 = r2.zza(r4)
            if (r2 == 0) goto L_0x0dbd
            r4 = 1835296868(0x6d646864, float:4.418049E27)
            com.google.android.gms.internal.ads.zzaew r3 = r3.zzb(r4)
            if (r3 == 0) goto L_0x0dbb
            com.google.android.gms.internal.ads.zzef r3 = r3.zza
            android.util.Pair r14 = zzi(r3)
            r3 = 1937011556(0x73747364, float:1.9367383E31)
            com.google.android.gms.internal.ads.zzaew r2 = r2.zzb(r3)
            if (r2 == 0) goto L_0x0db9
            com.google.android.gms.internal.ads.zzef r10 = r2.zza
            int r9 = r0.zza
            int r8 = r0.zzc
            java.lang.Object r2 = r14.second
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            r6 = 12
            r10.zzF(r6)
            int r5 = r10.zze()
            com.google.android.gms.internal.ads.zzafb r4 = new com.google.android.gms.internal.ads.zzafb
            r4.<init>(r5)
            r3 = 0
        L_0x018b:
            if (r3 >= r5) goto L_0x077b
            int r2 = r10.zzc()
            r31 = r15
            int r15 = r10.zze()
            if (r15 <= 0) goto L_0x019d
            r20 = r3
            r6 = 1
            goto L_0x01a0
        L_0x019d:
            r20 = r3
            r6 = 0
        L_0x01a0:
            java.lang.String r3 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzzm.zzb(r6, r3)
            int r3 = r10.zze()
            r6 = 1635148593(0x61766331, float:2.840654E20)
            r22 = r5
            r5 = 1701733238(0x656e6376, float:7.035987E22)
            if (r3 == r6) goto L_0x038a
            r6 = 1635148595(0x61766333, float:2.8406544E20)
            if (r3 == r6) goto L_0x038a
            if (r3 == r5) goto L_0x038a
            r6 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r3 == r6) goto L_0x038a
            r6 = 1836070006(0x6d703476, float:4.646239E27)
            if (r3 == r6) goto L_0x038a
            r6 = 1752589105(0x68766331, float:4.6541277E24)
            if (r3 == r6) goto L_0x038a
            r6 = 1751479857(0x68657631, float:4.3344087E24)
            if (r3 == r6) goto L_0x038a
            r6 = 1932670515(0x73323633, float:1.4119387E31)
            if (r3 == r6) goto L_0x038a
            r6 = 1211250227(0x48323633, float:182488.8)
            if (r3 == r6) goto L_0x038a
            r6 = 1987063864(0x76703038, float:1.21789965E33)
            if (r3 == r6) goto L_0x038a
            r6 = 1987063865(0x76703039, float:1.2178997E33)
            if (r3 == r6) goto L_0x038a
            r6 = 1635135537(0x61763031, float:2.8383572E20)
            if (r3 == r6) goto L_0x038a
            r6 = 1685479798(0x64766176, float:1.8179687E22)
            if (r3 == r6) goto L_0x038a
            r6 = 1685479729(0x64766131, float:1.817961E22)
            if (r3 == r6) goto L_0x038a
            r6 = 1685481573(0x64766865, float:1.8181686E22)
            if (r3 == r6) goto L_0x038a
            r6 = 1685481521(0x64766831, float:1.8181627E22)
            if (r3 != r6) goto L_0x01fd
            goto L_0x038a
        L_0x01fd:
            r5 = 1836069985(0x6d703461, float:4.6462328E27)
            if (r3 == r5) goto L_0x0350
            r5 = 1701733217(0x656e6361, float:7.0359778E22)
            if (r3 == r5) goto L_0x0350
            r5 = 1633889587(0x61632d33, float:2.6191674E20)
            if (r3 == r5) goto L_0x0350
            r5 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r3 == r5) goto L_0x0350
            r5 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r3 == r5) goto L_0x0350
            r5 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r3 == r5) goto L_0x0350
            r5 = 1685353315(0x64747363, float:1.803728E22)
            if (r3 == r5) goto L_0x0350
            r5 = 1685353317(0x64747365, float:1.8037282E22)
            if (r3 == r5) goto L_0x0350
            r5 = 1685353320(0x64747368, float:1.8037286E22)
            if (r3 == r5) goto L_0x0350
            r5 = 1685353324(0x6474736c, float:1.803729E22)
            if (r3 == r5) goto L_0x0350
            r5 = 1685353336(0x64747378, float:1.8037304E22)
            if (r3 == r5) goto L_0x0350
            r5 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r3 == r5) goto L_0x0350
            r5 = 1935767394(0x73617762, float:1.7863284E31)
            if (r3 == r5) goto L_0x0350
            r5 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r3 == r5) goto L_0x0350
            r5 = 1936684916(0x736f7774, float:1.89725E31)
            if (r3 == r5) goto L_0x0350
            r5 = 1953984371(0x74776f73, float:7.841539E31)
            if (r3 == r5) goto L_0x0350
            r5 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r3 == r5) goto L_0x0350
            r5 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r3 == r5) goto L_0x0350
            r5 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r3 == r5) goto L_0x0350
            r5 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r3 == r5) goto L_0x0350
            r5 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r3 == r5) goto L_0x0350
            r5 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r3 == r5) goto L_0x0350
            r5 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r3 == r5) goto L_0x0350
            r5 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r3 == r5) goto L_0x0350
            r5 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r3 != r5) goto L_0x027c
            goto L_0x0350
        L_0x027c:
            r5 = 1414810956(0x54544d4c, float:3.64731957E12)
            if (r3 == r5) goto L_0x02cf
            r5 = 1954034535(0x74783367, float:7.865797E31)
            if (r3 == r5) goto L_0x02cf
            r5 = 2004251764(0x77767474, float:4.998699E33)
            if (r3 == r5) goto L_0x02cf
            r5 = 1937010800(0x73747070, float:1.9366469E31)
            if (r3 == r5) goto L_0x02cf
            r5 = 1664495672(0x63363038, float:3.360782E21)
            if (r3 != r5) goto L_0x0296
            goto L_0x02cf
        L_0x0296:
            r5 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r3 != r5) goto L_0x02a2
            r3 = 1835365492(0x6d657474, float:4.4383032E27)
            zzn(r10, r3, r2, r9, r4)
            goto L_0x02ba
        L_0x02a2:
            r5 = 1667329389(0x63616d6d, float:4.1584024E21)
            if (r3 != r5) goto L_0x02ba
            com.google.android.gms.internal.ads.zzad r3 = new com.google.android.gms.internal.ads.zzad
            r3.<init>()
            r3.zzG(r9)
            java.lang.String r5 = "application/x-camera-motion"
            r3.zzS(r5)
            com.google.android.gms.internal.ads.zzaf r3 = r3.zzY()
            r4.zzb = r3
        L_0x02ba:
            r17 = r0
            r30 = r2
            r3 = r4
            r16 = r7
            r2 = r8
            r1 = r9
            r40 = r11
            r33 = r13
            r46 = r15
            r19 = r21
            r18 = r22
            goto L_0x034b
        L_0x02cf:
            int r5 = r2 + 16
            r10.zzF(r5)
            r5 = 1414810956(0x54544d4c, float:3.64731957E12)
            r32 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r3 != r5) goto L_0x02e8
            java.lang.String r3 = "application/ttml+xml"
        L_0x02e0:
            r30 = r2
            r5 = r32
            r2 = 0
        L_0x02e5:
            r32 = r8
            goto L_0x031f
        L_0x02e8:
            r5 = 1954034535(0x74783367, float:7.865797E31)
            if (r3 != r5) goto L_0x0302
            int r3 = r15 + -16
            byte[] r5 = new byte[r3]
            r6 = 0
            r10.zzB(r5, r6, r3)
            com.google.android.gms.internal.ads.zzfvn r3 = com.google.android.gms.internal.ads.zzfvn.zzp(r5)
            java.lang.String r5 = "application/x-quicktime-tx3g"
            r30 = r2
            r2 = r3
            r3 = r5
            r5 = r32
            goto L_0x02e5
        L_0x0302:
            r5 = 2004251764(0x77767474, float:4.998699E33)
            if (r3 != r5) goto L_0x030a
            java.lang.String r3 = "application/x-mp4-vtt"
            goto L_0x02e0
        L_0x030a:
            r5 = 1937010800(0x73747070, float:1.9366469E31)
            if (r3 != r5) goto L_0x0319
            java.lang.String r3 = "application/ttml+xml"
            r30 = r2
            r32 = r8
            r5 = r26
            r2 = 0
            goto L_0x031f
        L_0x0319:
            r3 = 1
            r4.zzd = r3
            java.lang.String r3 = "application/x-mp4-cea-608"
            goto L_0x02e0
        L_0x031f:
            com.google.android.gms.internal.ads.zzad r8 = new com.google.android.gms.internal.ads.zzad
            r8.<init>()
            r8.zzG(r9)
            r8.zzS(r3)
            r8.zzK(r7)
            r8.zzW(r5)
            r8.zzI(r2)
            com.google.android.gms.internal.ads.zzaf r2 = r8.zzY()
            r4.zzb = r2
            r17 = r0
            r3 = r4
            r16 = r7
            r1 = r9
            r40 = r11
            r33 = r13
            r46 = r15
            r19 = r21
            r18 = r22
            r2 = r32
        L_0x034b:
            r21 = r14
            r14 = r10
            goto L_0x0755
        L_0x0350:
            r32 = r8
            r8 = r2
            r2 = r10
            r6 = r4
            r5 = -1
            r4 = r8
            r33 = r13
            r18 = r22
            r13 = r5
            r5 = r15
            r22 = r6
            r19 = 12
            r6 = r9
            r16 = r7
            r13 = 2
            r13 = r8
            r1 = r19
            r39 = r32
            r8 = r66
            r1 = r9
            r19 = r21
            r9 = r64
            r17 = r0
            r21 = r14
            r0 = 0
            r14 = r10
            r10 = r22
            r40 = r11
            r11 = r20
            zzm(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r30 = r13
            r46 = r15
            r3 = r22
            r2 = r39
            goto L_0x0755
        L_0x038a:
            r17 = r0
            r16 = r7
            r39 = r8
            r1 = r9
            r40 = r11
            r33 = r13
            r19 = r21
            r18 = r22
            r0 = 0
            r13 = r2
            r22 = r4
            r21 = r14
            r14 = r10
            int r2 = r13 + 16
            r14.zzF(r2)
            r2 = 16
            r14.zzG(r2)
            int r4 = r14.zzo()
            int r6 = r14.zzo()
            r7 = 50
            r14.zzG(r7)
            int r7 = r14.zzc()
            if (r3 != r5) goto L_0x03ee
            android.util.Pair r3 = zzj(r14, r13, r15)
            if (r3 == 0) goto L_0x03e6
            java.lang.Object r5 = r3.first
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r12 != 0) goto L_0x03cf
            r9 = r0
            goto L_0x03da
        L_0x03cf:
            java.lang.Object r8 = r3.second
            com.google.android.gms.internal.ads.zzafw r8 = (com.google.android.gms.internal.ads.zzafw) r8
            java.lang.String r8 = r8.zzb
            com.google.android.gms.internal.ads.zzx r8 = r12.zzb(r8)
            r9 = r8
        L_0x03da:
            r8 = r22
            com.google.android.gms.internal.ads.zzafw[] r10 = r8.zza
            java.lang.Object r3 = r3.second
            com.google.android.gms.internal.ads.zzafw r3 = (com.google.android.gms.internal.ads.zzafw) r3
            r10[r20] = r3
            r3 = r5
            goto L_0x03ea
        L_0x03e6:
            r8 = r22
            r3 = r5
            r9 = r12
        L_0x03ea:
            r14.zzF(r7)
            goto L_0x03f1
        L_0x03ee:
            r8 = r22
            r9 = r12
        L_0x03f1:
            r5 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r3 != r5) goto L_0x03f9
            java.lang.String r10 = "video/mpeg"
            goto L_0x0405
        L_0x03f9:
            r5 = 1211250227(0x48323633, float:182488.8)
            if (r3 != r5) goto L_0x0404
            r3 = 1211250227(0x48323633, float:182488.8)
            java.lang.String r10 = "video/3gpp"
            goto L_0x0405
        L_0x0404:
            r10 = r0
        L_0x0405:
            r5 = 1065353216(0x3f800000, float:1.0)
            r2 = r0
            r11 = r2
            r22 = r11
            r26 = r22
            r41 = r26
            r27 = 0
            r42 = -1
            r43 = -1
            r44 = -1
            r45 = -1
        L_0x0419:
            int r0 = r7 - r13
            if (r0 >= r15) goto L_0x06c8
            r14.zzF(r7)
            int r0 = r14.zzc()
            int r30 = r14.zze()
            if (r30 != 0) goto L_0x0436
            int r30 = r14.zzc()
            int r12 = r30 - r13
            if (r12 != r15) goto L_0x0434
            goto L_0x06c8
        L_0x0434:
            r12 = 0
            goto L_0x0438
        L_0x0436:
            r12 = r30
        L_0x0438:
            if (r12 <= 0) goto L_0x0440
            r30 = r13
            r46 = r15
            r13 = 1
            goto L_0x0445
        L_0x0440:
            r30 = r13
            r46 = r15
            r13 = 0
        L_0x0445:
            java.lang.String r15 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzzm.zzb(r13, r15)
            int r13 = r14.zze()
            r15 = 1635148611(0x61766343, float:2.8406573E20)
            if (r13 != r15) goto L_0x0481
            if (r10 != 0) goto L_0x0457
            r2 = 1
            goto L_0x0458
        L_0x0457:
            r2 = 0
        L_0x0458:
            r10 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r2, r10)
            int r0 = r0 + 8
            r14.zzF(r0)
            com.google.android.gms.internal.ads.zzyn r0 = com.google.android.gms.internal.ads.zzyn.zza(r14)
            java.util.List r2 = r0.zza
            int r10 = r0.zzb
            r8.zzc = r10
            if (r27 != 0) goto L_0x046f
            float r5 = r0.zze
        L_0x046f:
            java.lang.String r0 = r0.zzf
            java.lang.String r10 = "video/avc"
        L_0x0473:
            r11 = r2
            r47 = r3
            r57 = r4
            r52 = r6
            r48 = r8
            r49 = r9
            r2 = r0
            goto L_0x06b5
        L_0x0481:
            r15 = 1752589123(0x68766343, float:4.6541328E24)
            if (r13 != r15) goto L_0x04a7
            if (r10 != 0) goto L_0x048a
            r2 = 1
            goto L_0x048b
        L_0x048a:
            r2 = 0
        L_0x048b:
            r10 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r2, r10)
            int r0 = r0 + 8
            r14.zzF(r0)
            com.google.android.gms.internal.ads.zzzy r0 = com.google.android.gms.internal.ads.zzzy.zza(r14)
            java.util.List r2 = r0.zza
            int r10 = r0.zzb
            r8.zzc = r10
            if (r27 != 0) goto L_0x04a2
            float r5 = r0.zzc
        L_0x04a2:
            java.lang.String r0 = r0.zzd
            java.lang.String r10 = "video/hevc"
            goto L_0x0473
        L_0x04a7:
            r15 = 1685480259(0x64766343, float:1.8180206E22)
            if (r13 == r15) goto L_0x0699
            r15 = 1685485123(0x64767643, float:1.8185683E22)
            if (r13 != r15) goto L_0x04b3
            goto L_0x0699
        L_0x04b3:
            r15 = 1987076931(0x76706343, float:1.21891066E33)
            if (r13 != r15) goto L_0x04cc
            if (r10 != 0) goto L_0x04bc
            r0 = 1
            goto L_0x04bd
        L_0x04bc:
            r0 = 0
        L_0x04bd:
            r10 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r10)
            r0 = 1987063864(0x76703038, float:1.21789965E33)
            if (r3 != r0) goto L_0x04c9
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x04dc
        L_0x04c9:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
            goto L_0x04dc
        L_0x04cc:
            r15 = 1635135811(0x61763143, float:2.8384055E20)
            if (r13 != r15) goto L_0x04e9
            if (r10 != 0) goto L_0x04d5
            r0 = 1
            goto L_0x04d6
        L_0x04d5:
            r0 = 0
        L_0x04d6:
            r10 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r10)
            java.lang.String r0 = "video/av01"
        L_0x04dc:
            r10 = r0
        L_0x04dd:
            r47 = r3
            r57 = r4
            r52 = r6
            r48 = r8
            r49 = r9
            goto L_0x06b5
        L_0x04e9:
            r15 = 1668050025(0x636c6c69, float:4.3612434E21)
            if (r13 != r15) goto L_0x050c
            if (r22 != 0) goto L_0x04f4
            java.nio.ByteBuffer r22 = zzl()
        L_0x04f4:
            r0 = r22
            r13 = 21
            r0.position(r13)
            short r13 = r14.zzy()
            r0.putShort(r13)
            short r13 = r14.zzy()
            r0.putShort(r13)
            r22 = r0
            goto L_0x04dd
        L_0x050c:
            r15 = 1835295606(0x6d646376, float:4.4176764E27)
            if (r13 != r15) goto L_0x0581
            if (r22 != 0) goto L_0x0517
            java.nio.ByteBuffer r22 = zzl()
        L_0x0517:
            r0 = r22
            short r13 = r14.zzy()
            short r15 = r14.zzy()
            r47 = r3
            short r3 = r14.zzy()
            r48 = r8
            short r8 = r14.zzy()
            r49 = r9
            short r9 = r14.zzy()
            r50 = r11
            short r11 = r14.zzy()
            r51 = r5
            short r5 = r14.zzy()
            r52 = r6
            short r6 = r14.zzy()
            long r53 = r14.zzs()
            long r55 = r14.zzs()
            r57 = r4
            r4 = 1
            r0.position(r4)
            r0.putShort(r9)
            r0.putShort(r11)
            r0.putShort(r13)
            r0.putShort(r15)
            r0.putShort(r3)
            r0.putShort(r8)
            r0.putShort(r5)
            r0.putShort(r6)
            r3 = 10000(0x2710, double:4.9407E-320)
            long r3 = r53 / r3
            int r3 = (int) r3
            short r3 = (short) r3
            r0.putShort(r3)
            r3 = 10000(0x2710, double:4.9407E-320)
            long r3 = r55 / r3
            int r3 = (int) r3
            short r3 = (short) r3
            r0.putShort(r3)
            r22 = r0
            goto L_0x06b1
        L_0x0581:
            r47 = r3
            r57 = r4
            r51 = r5
            r52 = r6
            r48 = r8
            r49 = r9
            r50 = r11
            r3 = 1681012275(0x64323633, float:1.3149704E22)
            if (r13 != r3) goto L_0x05a2
            if (r10 != 0) goto L_0x0598
            r0 = 1
            goto L_0x0599
        L_0x0598:
            r0 = 0
        L_0x0599:
            r3 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r3)
            java.lang.String r0 = "video/3gpp"
            r10 = r0
            goto L_0x06b1
        L_0x05a2:
            r3 = 0
            r4 = 1702061171(0x65736473, float:7.183675E22)
            if (r13 != r4) goto L_0x05ca
            if (r10 != 0) goto L_0x05ac
            r4 = 1
            goto L_0x05ad
        L_0x05ac:
            r4 = 0
        L_0x05ad:
            com.google.android.gms.internal.ads.zzzm.zzb(r4, r3)
            com.google.android.gms.internal.ads.zzaez r0 = zzk(r14, r0)
            java.lang.String r3 = r0.zza
            byte[] r4 = r0.zzb
            if (r4 == 0) goto L_0x05c3
            com.google.android.gms.internal.ads.zzfvn r11 = com.google.android.gms.internal.ads.zzfvn.zzp(r4)
            goto L_0x05c5
        L_0x05c3:
            r11 = r50
        L_0x05c5:
            r26 = r0
            r10 = r3
            goto L_0x06b3
        L_0x05ca:
            r3 = 1885434736(0x70617370, float:2.7909473E29)
            if (r13 != r3) goto L_0x05e6
            int r0 = r0 + 8
            r14.zzF(r0)
            int r0 = r14.zzn()
            float r0 = (float) r0
            int r3 = r14.zzn()
            float r3 = (float) r3
            float r0 = r0 / r3
            r5 = r0
            r11 = r50
            r27 = 1
            goto L_0x06b5
        L_0x05e6:
            r3 = 1937126244(0x73763364, float:1.9506033E31)
            if (r13 != r3) goto L_0x0612
            int r3 = r0 + 8
        L_0x05ed:
            int r4 = r3 - r0
            if (r4 >= r12) goto L_0x060d
            r14.zzF(r3)
            int r4 = r14.zze()
            int r5 = r14.zze()
            r6 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r5 != r6) goto L_0x060b
            byte[] r0 = r14.zzH()
            int r4 = r4 + r3
            byte[] r0 = java.util.Arrays.copyOfRange(r0, r3, r4)
            goto L_0x060e
        L_0x060b:
            int r3 = r3 + r4
            goto L_0x05ed
        L_0x060d:
            r0 = 0
        L_0x060e:
            r41 = r0
            goto L_0x06b1
        L_0x0612:
            r0 = 1936995172(0x73743364, float:1.9347576E31)
            if (r13 != r0) goto L_0x0643
            int r0 = r14.zzk()
            r3 = 3
            r14.zzG(r3)
            if (r0 != 0) goto L_0x06b1
            int r0 = r14.zzk()
            if (r0 == 0) goto L_0x063f
            r3 = 1
            if (r0 == r3) goto L_0x063b
            r3 = 2
            if (r0 == r3) goto L_0x0637
            r3 = 3
            if (r0 == r3) goto L_0x0632
            goto L_0x06b1
        L_0x0632:
            r0 = 3
            r42 = r0
            goto L_0x06b1
        L_0x0637:
            r42 = 2
            goto L_0x06b1
        L_0x063b:
            r42 = 1
            goto L_0x06b1
        L_0x063f:
            r42 = 0
            goto L_0x06b1
        L_0x0643:
            r0 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r13 != r0) goto L_0x06b1
            int r0 = r14.zze()
            r3 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r0 == r3) goto L_0x0667
            r3 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r0 != r3) goto L_0x0657
            goto L_0x0667
        L_0x0657:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaex.zzf(r0)
            java.lang.String r3 = "Unsupported color type: "
            java.lang.String r0 = r3.concat(r0)
            java.lang.String r3 = "AtomParsers"
            com.google.android.gms.internal.ads.zzdw.zze(r3, r0)
            goto L_0x06b1
        L_0x0667:
            int r0 = r14.zzo()
            int r3 = r14.zzo()
            r4 = 2
            r14.zzG(r4)
            r4 = 19
            if (r12 != r4) goto L_0x0683
            int r4 = r14.zzk()
            r4 = r4 & 128(0x80, float:1.794E-43)
            r12 = 19
            if (r4 == 0) goto L_0x0683
            r4 = 1
            goto L_0x0684
        L_0x0683:
            r4 = 0
        L_0x0684:
            int r0 = com.google.android.gms.internal.ads.zzq.zza(r0)
            r5 = 1
            if (r5 == r4) goto L_0x068d
            r4 = 2
            goto L_0x068e
        L_0x068d:
            r4 = 1
        L_0x068e:
            int r3 = com.google.android.gms.internal.ads.zzq.zzb(r3)
            r43 = r0
            r45 = r3
            r44 = r4
            goto L_0x06b1
        L_0x0699:
            r47 = r3
            r57 = r4
            r51 = r5
            r52 = r6
            r48 = r8
            r49 = r9
            r50 = r11
            com.google.android.gms.internal.ads.zzze r0 = com.google.android.gms.internal.ads.zzze.zza(r14)
            if (r0 == 0) goto L_0x06b1
            java.lang.String r2 = r0.zza
            java.lang.String r10 = "video/dolby-vision"
        L_0x06b1:
            r11 = r50
        L_0x06b3:
            r5 = r51
        L_0x06b5:
            int r7 = r7 + r12
            r12 = r64
            r13 = r30
            r15 = r46
            r3 = r47
            r8 = r48
            r9 = r49
            r6 = r52
            r4 = r57
            goto L_0x0419
        L_0x06c8:
            r57 = r4
            r51 = r5
            r52 = r6
            r48 = r8
            r49 = r9
            r50 = r11
            r30 = r13
            r46 = r15
            if (r10 != 0) goto L_0x06e0
            r2 = r39
            r3 = r48
            goto L_0x0755
        L_0x06e0:
            com.google.android.gms.internal.ads.zzad r0 = new com.google.android.gms.internal.ads.zzad
            r0.<init>()
            r0.zzG(r1)
            r0.zzS(r10)
            r0.zzx(r2)
            r2 = r57
            r0.zzX(r2)
            r2 = r52
            r0.zzF(r2)
            r5 = r51
            r0.zzP(r5)
            r2 = r39
            r0.zzR(r2)
            r3 = r41
            r0.zzQ(r3)
            r3 = r42
            r0.zzV(r3)
            r11 = r50
            r0.zzI(r11)
            r9 = r49
            r0.zzB(r9)
            r3 = r43
            r4 = -1
            r5 = r44
            r6 = r45
            if (r3 != r4) goto L_0x0725
            if (r5 != r4) goto L_0x0725
            if (r6 != r4) goto L_0x0725
            if (r22 == 0) goto L_0x0735
        L_0x0725:
            com.google.android.gms.internal.ads.zzq r4 = new com.google.android.gms.internal.ads.zzq
            if (r22 == 0) goto L_0x072e
            byte[] r10 = r22.array()
            goto L_0x072f
        L_0x072e:
            r10 = 0
        L_0x072f:
            r4.<init>(r3, r5, r6, r10)
            r0.zzy(r4)
        L_0x0735:
            if (r26 == 0) goto L_0x074d
            long r3 = r26.zzc
            int r3 = com.google.android.gms.internal.ads.zzfxs.zzc(r3)
            r0.zzv(r3)
            long r3 = r26.zzd
            int r3 = com.google.android.gms.internal.ads.zzfxs.zzc(r3)
            r0.zzO(r3)
        L_0x074d:
            com.google.android.gms.internal.ads.zzaf r0 = r0.zzY()
            r3 = r48
            r3.zzb = r0
        L_0x0755:
            int r0 = r30 + r46
            r14.zzF(r0)
            int r0 = r20 + 1
            r12 = r64
            r9 = r1
            r8 = r2
            r4 = r3
            r10 = r14
            r7 = r16
            r5 = r18
            r14 = r21
            r15 = r31
            r13 = r33
            r11 = r40
            r6 = 12
            r26 = 0
            r1 = r61
            r3 = r0
            r0 = r17
            r21 = r19
            goto L_0x018b
        L_0x077b:
            r17 = r0
            r3 = r4
            r40 = r11
            r33 = r13
            r31 = r15
            r19 = r21
            r21 = r14
            r0 = 1701082227(0x65647473, float:6.742798E22)
            r2 = r40
            com.google.android.gms.internal.ads.zzaev r0 = r2.zza(r0)
            if (r0 == 0) goto L_0x07a5
            android.util.Pair r0 = zzh(r0)
            if (r0 == 0) goto L_0x07a5
            java.lang.Object r1 = r0.first
            r10 = r1
            long[] r10 = (long[]) r10
            java.lang.Object r0 = r0.second
            long[] r0 = (long[]) r0
            r30 = r0
            goto L_0x07a8
        L_0x07a5:
            r10 = 0
            r30 = 0
        L_0x07a8:
            com.google.android.gms.internal.ads.zzaf r0 = r3.zzb
            if (r0 != 0) goto L_0x07b0
            r0 = r67
            goto L_0x0058
        L_0x07b0:
            com.google.android.gms.internal.ads.zzafv r0 = new com.google.android.gms.internal.ads.zzafv
            int r17 = r17.zza
            r1 = r21
            java.lang.Object r1 = r1.first
            java.lang.Long r1 = (java.lang.Long) r1
            long r4 = r1.longValue()
            com.google.android.gms.internal.ads.zzaf r1 = r3.zzb
            int r6 = r3.zzd
            com.google.android.gms.internal.ads.zzafw[] r7 = r3.zza
            int r3 = r3.zzc
            r16 = r0
            r18 = r19
            r19 = r4
            r21 = r28
            r23 = r24
            r25 = r1
            r26 = r6
            r27 = r7
            r28 = r3
            r29 = r10
            r16.<init>(r17, r18, r19, r21, r23, r25, r26, r27, r28, r29, r30)
            r10 = r0
            r0 = r67
        L_0x07e2:
            java.lang.Object r1 = r0.apply(r10)
            r4 = r1
            com.google.android.gms.internal.ads.zzafv r4 = (com.google.android.gms.internal.ads.zzafv) r4
            if (r4 == 0) goto L_0x0dac
            r1 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzaev r1 = r2.zza(r1)
            if (r1 == 0) goto L_0x0daa
            r2 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzaev r1 = r1.zza(r2)
            if (r1 == 0) goto L_0x0da8
            r2 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzaev r1 = r1.zza(r2)
            if (r1 == 0) goto L_0x0da6
            r2 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.gms.internal.ads.zzaew r2 = r1.zzb(r2)
            if (r2 == 0) goto L_0x0817
            com.google.android.gms.internal.ads.zzafc r3 = new com.google.android.gms.internal.ads.zzafc
            com.google.android.gms.internal.ads.zzaf r5 = r4.zzf
            r3.<init>(r2, r5)
            goto L_0x0825
        L_0x0817:
            r2 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.gms.internal.ads.zzaew r2 = r1.zzb(r2)
            if (r2 == 0) goto L_0x0d9e
            com.google.android.gms.internal.ads.zzafd r3 = new com.google.android.gms.internal.ads.zzafd
            r3.<init>(r2)
        L_0x0825:
            int r2 = r3.zzb()
            if (r2 != 0) goto L_0x0842
            com.google.android.gms.internal.ads.zzafy r1 = new com.google.android.gms.internal.ads.zzafy
            r2 = 0
            long[] r5 = new long[r2]
            int[] r6 = new int[r2]
            r7 = 0
            long[] r8 = new long[r2]
            int[] r9 = new int[r2]
            r10 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r2 = r1
        L_0x083e:
            r0 = r33
            goto L_0x0d94
        L_0x0842:
            r5 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.gms.internal.ads.zzaew r5 = r1.zzb(r5)
            if (r5 != 0) goto L_0x0858
            r5 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.gms.internal.ads.zzaew r5 = r1.zzb(r5)
            if (r5 == 0) goto L_0x0856
            r6 = 1
            goto L_0x0859
        L_0x0856:
            r5 = 0
            throw r5
        L_0x0858:
            r6 = 0
        L_0x0859:
            com.google.android.gms.internal.ads.zzef r5 = r5.zza
            r7 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.gms.internal.ads.zzaew r7 = r1.zzb(r7)
            if (r7 == 0) goto L_0x0d9c
            com.google.android.gms.internal.ads.zzef r7 = r7.zza
            r8 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.gms.internal.ads.zzaew r8 = r1.zzb(r8)
            if (r8 == 0) goto L_0x0d9a
            com.google.android.gms.internal.ads.zzef r8 = r8.zza
            r9 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.gms.internal.ads.zzaew r9 = r1.zzb(r9)
            if (r9 == 0) goto L_0x087d
            com.google.android.gms.internal.ads.zzef r10 = r9.zza
            goto L_0x087e
        L_0x087d:
            r10 = 0
        L_0x087e:
            r9 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.gms.internal.ads.zzaew r1 = r1.zzb(r9)
            if (r1 == 0) goto L_0x088a
            com.google.android.gms.internal.ads.zzef r1 = r1.zza
            goto L_0x088b
        L_0x088a:
            r1 = 0
        L_0x088b:
            com.google.android.gms.internal.ads.zzaey r9 = new com.google.android.gms.internal.ads.zzaey
            r9.<init>(r7, r5, r6)
            r5 = 12
            r8.zzF(r5)
            int r6 = r8.zzn()
            r7 = -1
            int r14 = r6 + -1
            int r6 = r8.zzn()
            int r7 = r8.zzn()
            if (r1 == 0) goto L_0x08ae
            r1.zzF(r5)
            int r11 = r1.zzn()
            goto L_0x08af
        L_0x08ae:
            r11 = 0
        L_0x08af:
            if (r10 == 0) goto L_0x08c5
            r10.zzF(r5)
            int r5 = r10.zzn()
            if (r5 <= 0) goto L_0x08c1
            int r12 = r10.zzn()
            r13 = -1
            int r12 = r12 + r13
            goto L_0x08c8
        L_0x08c1:
            r13 = -1
            r12 = r13
            r10 = 0
            goto L_0x08c8
        L_0x08c5:
            r13 = -1
            r12 = r13
            r5 = 0
        L_0x08c8:
            int r15 = r3.zza()
            com.google.android.gms.internal.ads.zzaf r0 = r4.zzf
            java.lang.String r0 = r0.zzm
            if (r15 == r13) goto L_0x096f
            java.lang.String r13 = "audio/raw"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x08ea
            java.lang.String r13 = "audio/g711-mlaw"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x08ea
            java.lang.String r13 = "audio/g711-alaw"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x096f
        L_0x08ea:
            if (r14 != 0) goto L_0x096f
            if (r11 != 0) goto L_0x096e
            if (r5 != 0) goto L_0x096e
            int r0 = r9.zza
            long[] r1 = new long[r0]
            int[] r0 = new int[r0]
        L_0x08f6:
            boolean r3 = r9.zza()
            if (r3 == 0) goto L_0x0907
            int r3 = r9.zzb
            long r5 = r9.zzd
            r1[r3] = r5
            int r5 = r9.zzc
            r0[r3] = r5
            goto L_0x08f6
        L_0x0907:
            long r5 = (long) r7
            r3 = 8192(0x2000, float:1.14794E-41)
            int r3 = r3 / r15
            int r7 = r0.length
            r8 = 0
            r9 = 0
        L_0x090e:
            if (r8 >= r7) goto L_0x091a
            r10 = r0[r8]
            int r10 = com.google.android.gms.internal.ads.zzen.zze(r10, r3)
            int r9 = r9 + r10
            int r8 = r8 + 1
            goto L_0x090e
        L_0x091a:
            long[] r7 = new long[r9]
            int[] r8 = new int[r9]
            long[] r10 = new long[r9]
            int[] r9 = new int[r9]
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
        L_0x0927:
            int r13 = r0.length
            if (r11 >= r13) goto L_0x0968
            r13 = r0[r11]
            r17 = r1[r11]
            r18 = r17
            r17 = r0
            r0 = r16
        L_0x0934:
            if (r13 <= 0) goto L_0x095f
            int r16 = java.lang.Math.min(r3, r13)
            r7[r14] = r18
            r20 = r1
            int r1 = r15 * r16
            r8[r14] = r1
            int r0 = java.lang.Math.max(r0, r1)
            r21 = r0
            long r0 = (long) r12
            long r0 = r0 * r5
            r10[r14] = r0
            r0 = 1
            r9[r14] = r0
            r0 = r8[r14]
            long r0 = (long) r0
            long r18 = r18 + r0
            int r12 = r12 + r16
            int r13 = r13 - r16
            int r14 = r14 + 1
            r1 = r20
            r0 = r21
            goto L_0x0934
        L_0x095f:
            r20 = r1
            int r11 = r11 + 1
            r16 = r0
            r0 = r17
            goto L_0x0927
        L_0x0968:
            long r0 = (long) r12
            long r5 = r5 * r0
            r11 = r16
            goto L_0x0b09
        L_0x096e:
            r14 = 0
        L_0x096f:
            long[] r0 = new long[r2]
            int[] r13 = new int[r2]
            long[] r15 = new long[r2]
            r16 = r5
            int[] r5 = new int[r2]
            r19 = r6
            r25 = r11
            r22 = r14
            r21 = r16
            r6 = 0
            r11 = 0
            r16 = 0
            r17 = 0
            r20 = 0
            r23 = 0
            r14 = r7
            r7 = 0
        L_0x098d:
            if (r6 >= r2) goto L_0x0a5b
            r26 = r23
            r23 = 1
        L_0x0993:
            if (r16 != 0) goto L_0x09b8
            boolean r23 = r9.zza()
            if (r23 == 0) goto L_0x09b0
            r28 = r7
            r24 = r8
            long r7 = r9.zzd
            r29 = r2
            int r2 = r9.zzc
            r16 = r2
            r26 = r7
            r8 = r24
            r7 = r28
            r2 = r29
            goto L_0x0993
        L_0x09b0:
            r29 = r2
            r28 = r7
            r24 = r8
            r2 = 0
            goto L_0x09c0
        L_0x09b8:
            r29 = r2
            r28 = r7
            r24 = r8
            r2 = r16
        L_0x09c0:
            if (r23 != 0) goto L_0x09e0
            java.lang.String r2 = "AtomParsers"
            java.lang.String r3 = "Unexpected end of chunk data"
            com.google.android.gms.internal.ads.zzdw.zze(r2, r3)
            long[] r0 = java.util.Arrays.copyOf(r0, r6)
            int[] r13 = java.util.Arrays.copyOf(r13, r6)
            long[] r15 = java.util.Arrays.copyOf(r15, r6)
            int[] r5 = java.util.Arrays.copyOf(r5, r6)
            r2 = r6
            r14 = r16
            r7 = r28
            goto L_0x0a5f
        L_0x09e0:
            if (r1 == 0) goto L_0x09f8
        L_0x09e2:
            if (r20 != 0) goto L_0x09f5
            if (r25 <= 0) goto L_0x09f1
            int r20 = r1.zzn()
            int r28 = r1.zze()
            int r25 = r25 + -1
            goto L_0x09e2
        L_0x09f1:
            r7 = -1
            r20 = 0
            goto L_0x09f6
        L_0x09f5:
            r7 = -1
        L_0x09f6:
            int r20 = r20 + -1
        L_0x09f8:
            r7 = r28
            r0[r6] = r26
            int r8 = r3.zzc()
            r13[r6] = r8
            if (r8 <= r11) goto L_0x0a05
            r11 = r8
        L_0x0a05:
            r23 = r9
            long r8 = (long) r7
            long r8 = r17 + r8
            r15[r6] = r8
            if (r10 != 0) goto L_0x0a10
            r8 = 1
            goto L_0x0a11
        L_0x0a10:
            r8 = 0
        L_0x0a11:
            r5[r6] = r8
            if (r6 != r12) goto L_0x0a28
            r8 = 1
            r5[r6] = r8
            int r21 = r21 + -1
            if (r21 <= 0) goto L_0x0a28
            if (r10 == 0) goto L_0x0a26
            int r8 = r10.zzn()
            r9 = -1
            int r8 = r8 + r9
            r12 = r8
            goto L_0x0a28
        L_0x0a26:
            r8 = 0
            throw r8
        L_0x0a28:
            long r8 = (long) r14
            long r17 = r17 + r8
            int r8 = r19 + -1
            if (r8 != 0) goto L_0x0a42
            if (r22 <= 0) goto L_0x0a3f
            int r14 = r24.zzn()
            int r8 = r24.zze()
            int r22 = r22 + -1
            r19 = r14
            r14 = r8
            goto L_0x0a44
        L_0x0a3f:
            r19 = 0
            goto L_0x0a44
        L_0x0a42:
            r19 = r8
        L_0x0a44:
            r8 = r13[r6]
            long r8 = (long) r8
            long r8 = r26 + r8
            r26 = -1
            int r16 = r2 + -1
            int r6 = r6 + 1
            r2 = r29
            r58 = r8
            r9 = r23
            r8 = r24
            r23 = r58
            goto L_0x098d
        L_0x0a5b:
            r29 = r2
            r14 = r16
        L_0x0a5f:
            long r6 = (long) r7
            long r6 = r17 + r6
            if (r1 == 0) goto L_0x0a74
        L_0x0a64:
            if (r25 <= 0) goto L_0x0a74
            int r3 = r1.zzn()
            if (r3 == 0) goto L_0x0a6e
            r1 = 0
            goto L_0x0a75
        L_0x0a6e:
            r1.zze()
            int r25 = r25 + -1
            goto L_0x0a64
        L_0x0a74:
            r1 = 1
        L_0x0a75:
            if (r21 != 0) goto L_0x0aaa
            if (r19 != 0) goto L_0x0aa2
            if (r14 != 0) goto L_0x0a9b
            if (r22 != 0) goto L_0x0a93
            if (r20 != 0) goto L_0x0a8d
            if (r1 != 0) goto L_0x0a87
            r1 = 0
            r3 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            goto L_0x0a99
        L_0x0a87:
            r16 = r0
            r17 = r2
            goto L_0x0b01
        L_0x0a8d:
            r10 = r20
            r3 = 0
            r8 = 0
            r9 = 0
            goto L_0x0a99
        L_0x0a93:
            r10 = r20
            r9 = r22
            r3 = 0
            r8 = 0
        L_0x0a99:
            r14 = 0
            goto L_0x0ab2
        L_0x0a9b:
            r10 = r20
            r9 = r22
            r3 = 0
            r8 = 0
            goto L_0x0ab2
        L_0x0aa2:
            r8 = r19
            r10 = r20
            r9 = r22
            r3 = 0
            goto L_0x0ab2
        L_0x0aaa:
            r8 = r19
            r10 = r20
            r3 = r21
            r9 = r22
        L_0x0ab2:
            int r12 = r4.zza
            r16 = r0
            r0 = 1
            if (r0 == r1) goto L_0x0abc
            java.lang.String r0 = ", ctts invalid"
            goto L_0x0abe
        L_0x0abc:
            java.lang.String r0 = ""
        L_0x0abe:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r17 = r2
            java.lang.String r2 = "Inconsistent stbl box for track "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = ": remainingSynchronizationSamples "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = ", remainingSamplesAtTimestampDelta "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = ", remainingSamplesInChunk "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r2 = ", remainingTimestampDeltaChanges "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = ", remainingSamplesAtTimestampOffset "
            r1.append(r2)
            r1.append(r10)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "AtomParsers"
            com.google.android.gms.internal.ads.zzdw.zze(r1, r0)
        L_0x0b01:
            r9 = r5
            r5 = r6
            r8 = r13
            r10 = r15
            r7 = r16
            r2 = r17
        L_0x0b09:
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r4.zzc
            r18 = r5
            r22 = r0
            long r0 = com.google.android.gms.internal.ads.zzen.zzw(r18, r20, r22)
            long[] r3 = r4.zzh
            if (r3 != 0) goto L_0x0b2f
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r4.zzc
            com.google.android.gms.internal.ads.zzen.zzR(r10, r2, r5)
            com.google.android.gms.internal.ads.zzafy r2 = new com.google.android.gms.internal.ads.zzafy
            r3 = r2
            r5 = r7
            r6 = r8
            r7 = r11
            r8 = r10
            r10 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x083e
        L_0x0b2f:
            int r0 = r3.length
            r1 = 1
            if (r0 != r1) goto L_0x0bd5
            int r0 = r4.zzb
            if (r0 != r1) goto L_0x0bd5
            int r0 = r10.length
            r1 = 2
            if (r0 < r1) goto L_0x0bd5
            long[] r0 = r4.zzi
            if (r0 == 0) goto L_0x0bd3
            long[] r0 = (long[]) r0
            r1 = 0
            r12 = r0[r1]
            r14 = r3[r1]
            long r0 = r4.zzc
            r25 = r2
            long r2 = r4.zzd
            r16 = r0
            r18 = r2
            long r0 = com.google.android.gms.internal.ads.zzen.zzw(r14, r16, r18)
            long r0 = r0 + r12
            r18 = r10
            r19 = r5
            r21 = r12
            r23 = r0
            boolean r2 = zzo(r18, r19, r21, r23)
            if (r2 == 0) goto L_0x0bd0
            r2 = 0
            r14 = r10[r2]
            long r16 = r12 - r14
            com.google.android.gms.internal.ads.zzaf r2 = r4.zzf
            int r2 = r2.zzA
            long r2 = (long) r2
            long r12 = r4.zzc
            r18 = r2
            r20 = r12
            long r2 = com.google.android.gms.internal.ads.zzen.zzw(r16, r18, r20)
            long r12 = r5 - r0
            com.google.android.gms.internal.ads.zzaf r0 = r4.zzf
            int r0 = r0.zzA
            long r14 = (long) r0
            long r0 = r4.zzc
            r16 = r0
            long r0 = com.google.android.gms.internal.ads.zzen.zzw(r12, r14, r16)
            r12 = 0
            int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x0b95
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x0b92
            r2 = r12
            goto L_0x0b95
        L_0x0b92:
            r14 = r61
            goto L_0x0bdb
        L_0x0b95:
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r14 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0b92
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r14 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0b92
            int r2 = (int) r2
            r14 = r61
            r14.zza = r2
            int r0 = (int) r0
            r14.zzb = r0
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r4.zzc
            com.google.android.gms.internal.ads.zzen.zzR(r10, r0, r2)
            long[] r0 = r4.zzh
            r1 = 0
            r15 = r0[r1]
            long r0 = r4.zzd
            r17 = 1000000(0xf4240, double:4.940656E-318)
            r19 = r0
            long r0 = com.google.android.gms.internal.ads.zzen.zzw(r15, r17, r19)
            com.google.android.gms.internal.ads.zzafy r2 = new com.google.android.gms.internal.ads.zzafy
            r3 = r2
            r5 = r7
            r6 = r8
            r7 = r11
            r8 = r10
            r10 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x083e
        L_0x0bd0:
            r14 = r61
            goto L_0x0bd9
        L_0x0bd3:
            r0 = 0
            throw r0
        L_0x0bd5:
            r14 = r61
            r25 = r2
        L_0x0bd9:
            r12 = 0
        L_0x0bdb:
            long[] r0 = r4.zzh
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x0c25
            r2 = 0
            r15 = r0[r2]
            int r0 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0c24
            long[] r0 = r4.zzi
            if (r0 == 0) goto L_0x0c22
            long[] r0 = (long[]) r0
            r12 = r0[r2]
            r0 = 0
        L_0x0bf1:
            int r1 = r10.length
            if (r0 >= r1) goto L_0x0c08
            r1 = r10[r0]
            long r15 = r1 - r12
            r17 = 1000000(0xf4240, double:4.940656E-318)
            long r1 = r4.zzc
            r19 = r1
            long r1 = com.google.android.gms.internal.ads.zzen.zzw(r15, r17, r19)
            r10[r0] = r1
            int r0 = r0 + 1
            goto L_0x0bf1
        L_0x0c08:
            long r0 = r4.zzc
            long r15 = r5 - r12
            r17 = 1000000(0xf4240, double:4.940656E-318)
            r19 = r0
            long r0 = com.google.android.gms.internal.ads.zzen.zzw(r15, r17, r19)
            com.google.android.gms.internal.ads.zzafy r2 = new com.google.android.gms.internal.ads.zzafy
            r3 = r2
            r5 = r7
            r6 = r8
            r7 = r11
            r8 = r10
            r10 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x083e
        L_0x0c22:
            r0 = 0
            throw r0
        L_0x0c24:
            r1 = 1
        L_0x0c25:
            int r0 = r4.zzb
            r2 = 1
            if (r0 != r2) goto L_0x0c2c
            r0 = 1
            goto L_0x0c2d
        L_0x0c2c:
            r0 = 0
        L_0x0c2d:
            int[] r2 = new int[r1]
            int[] r1 = new int[r1]
            long[] r3 = r4.zzi
            if (r3 == 0) goto L_0x0d98
            long[] r3 = (long[]) r3
            r5 = 0
            r6 = 0
            r15 = 0
            r16 = 0
        L_0x0c3c:
            long[] r12 = r4.zzh
            int r13 = r12.length
            if (r5 >= r13) goto L_0x0c9d
            r13 = r3[r5]
            r17 = -1
            int r17 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r17 == 0) goto L_0x0c8b
            r18 = r12[r5]
            r17 = r11
            long r11 = r4.zzc
            r24 = r7
            r26 = r8
            long r7 = r4.zzd
            r20 = r11
            r22 = r7
            long r7 = com.google.android.gms.internal.ads.zzen.zzw(r18, r20, r22)
            r11 = 1
            int r12 = com.google.android.gms.internal.ads.zzen.zzd(r10, r13, r11, r11)
            r2[r5] = r12
            long r13 = r13 + r7
            r12 = 0
            int r7 = com.google.android.gms.internal.ads.zzen.zzb(r10, r13, r0, r12)
            r1[r5] = r7
        L_0x0c6c:
            r7 = r2[r5]
            r8 = r1[r5]
            if (r7 >= r8) goto L_0x0c7d
            r13 = r9[r7]
            r13 = r13 & r11
            if (r13 != 0) goto L_0x0c7d
            int r7 = r7 + 1
            r2[r5] = r7
            r11 = 1
            goto L_0x0c6c
        L_0x0c7d:
            int r11 = r8 - r7
            int r6 = r6 + r11
            if (r15 == r7) goto L_0x0c84
            r7 = 1
            goto L_0x0c85
        L_0x0c84:
            r7 = r12
        L_0x0c85:
            r7 = r16 | r7
            r16 = r7
            r15 = r8
            goto L_0x0c92
        L_0x0c8b:
            r24 = r7
            r26 = r8
            r17 = r11
            r12 = 0
        L_0x0c92:
            int r5 = r5 + 1
            r14 = r61
            r11 = r17
            r7 = r24
            r8 = r26
            goto L_0x0c3c
        L_0x0c9d:
            r24 = r7
            r26 = r8
            r17 = r11
            r5 = r25
            r12 = 0
            if (r6 == r5) goto L_0x0caa
            r0 = 1
            goto L_0x0cab
        L_0x0caa:
            r0 = r12
        L_0x0cab:
            r0 = r16 | r0
            if (r0 == 0) goto L_0x0cb3
            long[] r3 = new long[r6]
            r5 = r3
            goto L_0x0cb5
        L_0x0cb3:
            r5 = r24
        L_0x0cb5:
            if (r0 == 0) goto L_0x0cbb
            int[] r3 = new int[r6]
            r7 = r3
            goto L_0x0cbd
        L_0x0cbb:
            r7 = r26
        L_0x0cbd:
            r3 = 1
            if (r3 != r0) goto L_0x0cc2
            r17 = r12
        L_0x0cc2:
            if (r0 == 0) goto L_0x0cc8
            int[] r3 = new int[r6]
            r11 = r3
            goto L_0x0cc9
        L_0x0cc8:
            r11 = r9
        L_0x0cc9:
            long[] r8 = new long[r6]
            r3 = r12
            r6 = r3
            r21 = r17
            r19 = 0
        L_0x0cd1:
            long[] r13 = r4.zzh
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0d77
            long[] r13 = r4.zzi
            r22 = r13[r3]
            r13 = r2[r3]
            r15 = r1[r3]
            if (r0 == 0) goto L_0x0cf2
            int r14 = r15 - r13
            r12 = r24
            java.lang.System.arraycopy(r12, r13, r5, r6, r14)
            r24 = r1
            r1 = r26
            java.lang.System.arraycopy(r1, r13, r7, r6, r14)
            java.lang.System.arraycopy(r9, r13, r11, r6, r14)
            goto L_0x0cf8
        L_0x0cf2:
            r12 = r24
            r24 = r1
            r1 = r26
        L_0x0cf8:
            r58 = r21
            r21 = r6
            r6 = r13
            r13 = r58
        L_0x0cff:
            if (r6 >= r15) goto L_0x0d4d
            r16 = 1000000(0xf4240, double:4.940656E-318)
            r25 = r11
            r26 = r12
            long r11 = r4.zzd
            r27 = r2
            r2 = r13
            r13 = r19
            r28 = r15
            r15 = r16
            r17 = r11
            long r11 = com.google.android.gms.internal.ads.zzen.zzw(r13, r15, r17)
            r13 = r10[r6]
            long r13 = r13 - r22
            r16 = r9
            r15 = r10
            r9 = 0
            long r34 = java.lang.Math.max(r9, r13)
            r36 = 1000000(0xf4240, double:4.940656E-318)
            long r13 = r4.zzc
            r38 = r13
            long r13 = com.google.android.gms.internal.ads.zzen.zzw(r34, r36, r38)
            long r11 = r11 + r13
            r8[r21] = r11
            if (r0 == 0) goto L_0x0d3c
            r11 = r7[r21]
            if (r11 <= r2) goto L_0x0d3c
            r2 = r1[r6]
        L_0x0d3c:
            r13 = r2
            int r21 = r21 + 1
            int r6 = r6 + 1
            r10 = r15
            r9 = r16
            r11 = r25
            r12 = r26
            r2 = r27
            r15 = r28
            goto L_0x0cff
        L_0x0d4d:
            r27 = r2
            r16 = r9
            r15 = r10
            r25 = r11
            r26 = r12
            r2 = r13
            r9 = 0
            long[] r6 = r4.zzh
            r11 = r6[r3]
            long r19 = r19 + r11
            int r3 = r3 + 1
            r10 = r15
            r9 = r16
            r6 = r21
            r11 = r25
            r12 = 0
            r21 = r2
            r2 = r27
            r58 = r26
            r26 = r1
            r1 = r24
            r24 = r58
            goto L_0x0cd1
        L_0x0d77:
            r25 = r11
            long r0 = r4.zzd
            r15 = 1000000(0xf4240, double:4.940656E-318)
            r13 = r19
            r17 = r0
            long r10 = com.google.android.gms.internal.ads.zzen.zzw(r13, r15, r17)
            com.google.android.gms.internal.ads.zzafy r0 = new com.google.android.gms.internal.ads.zzafy
            r3 = r0
            r6 = r7
            r7 = r21
            r9 = r25
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r2 = r0
            goto L_0x083e
        L_0x0d94:
            r0.add(r2)
            goto L_0x0dae
        L_0x0d98:
            r1 = 0
            throw r1
        L_0x0d9a:
            r1 = 0
            throw r1
        L_0x0d9c:
            r1 = 0
            throw r1
        L_0x0d9e:
            r1 = 0
            java.lang.String r0 = "Track has no sample table size information"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x0da6:
            r1 = 0
            throw r1
        L_0x0da8:
            r1 = 0
            throw r1
        L_0x0daa:
            r1 = 0
            throw r1
        L_0x0dac:
            r0 = r33
        L_0x0dae:
            int r15 = r31 + 1
            r1 = r61
            r12 = r64
            r13 = r0
            r0 = r60
            goto L_0x000c
        L_0x0db9:
            r1 = 0
            throw r1
        L_0x0dbb:
            r1 = 0
            throw r1
        L_0x0dbd:
            r1 = 0
            throw r1
        L_0x0dbf:
            r1 = 0
            throw r1
        L_0x0dc1:
            r1 = 0
            throw r1
        L_0x0dc3:
            r1 = 0
            throw r1
        L_0x0dc5:
            r1 = 0
            throw r1
        L_0x0dc7:
            r1 = 0
            throw r1
        L_0x0dc9:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaff.zzc(com.google.android.gms.internal.ads.zzaev, com.google.android.gms.internal.ads.zzzx, long, com.google.android.gms.internal.ads.zzx, boolean, boolean, com.google.android.gms.internal.ads.zzfsm):java.util.List");
    }

    public static void zzd(zzef zzef) {
        int zzc = zzef.zzc();
        zzef.zzG(4);
        if (zzef.zze() != 1751411826) {
            zzc += 4;
        }
        zzef.zzF(zzc);
    }

    private static int zze(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    private static int zzf(zzef zzef) {
        int zzk = zzef.zzk();
        int i = zzk & 127;
        while ((zzk & 128) == 128) {
            zzk = zzef.zzk();
            i = (i << 7) | (zzk & 127);
        }
        return i;
    }

    private static int zzg(zzef zzef) {
        zzef.zzF(16);
        return zzef.zze();
    }

    private static Pair zzh(zzaev zzaev) {
        zzaew zzb = zzaev.zzb(1701606260);
        if (zzb == null) {
            return null;
        }
        zzef zzef = zzb.zza;
        zzef.zzF(8);
        int zze = zzaex.zze(zzef.zze());
        int zzn = zzef.zzn();
        long[] jArr = new long[zzn];
        long[] jArr2 = new long[zzn];
        int i = 0;
        while (i < zzn) {
            jArr[i] = zze == 1 ? zzef.zzt() : zzef.zzs();
            jArr2[i] = zze == 1 ? zzef.zzr() : (long) zzef.zze();
            if (zzef.zzy() == 1) {
                zzef.zzG(2);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair zzi(zzef zzef) {
        int i = 8;
        zzef.zzF(8);
        int zze = zzaex.zze(zzef.zze());
        zzef.zzG(zze == 0 ? 8 : 16);
        long zzs = zzef.zzs();
        if (zze == 0) {
            i = 4;
        }
        zzef.zzG(i);
        int zzo = zzef.zzo();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((zzo >> 10) & 31) + 96));
        sb.append((char) (((zzo >> 5) & 31) + 96));
        sb.append((char) ((zzo & 31) + 96));
        return Pair.create(Long.valueOf(zzs), sb.toString());
    }

    private static Pair zzj(zzef zzef, int i, int i2) throws zzbu {
        Pair pair;
        Integer num;
        zzafw zzafw;
        int i3;
        int i4;
        byte[] bArr;
        zzef zzef2 = zzef;
        int zzc = zzef.zzc();
        while (zzc - i < i2) {
            zzef2.zzF(zzc);
            int zze = zzef.zze();
            boolean z = true;
            zzzm.zzb(zze > 0, "childAtomSize must be positive");
            if (zzef.zze() == 1936289382) {
                int i5 = zzc + 8;
                int i6 = 0;
                int i7 = -1;
                String str = null;
                Integer num2 = null;
                while (i5 - zzc < zze) {
                    zzef2.zzF(i5);
                    int zze2 = zzef.zze();
                    int zze3 = zzef.zze();
                    if (zze3 == 1718775137) {
                        num2 = Integer.valueOf(zzef.zze());
                    } else if (zze3 == 1935894637) {
                        zzef2.zzG(4);
                        str = zzef2.zzx(4, zzfsk.zzc);
                    } else if (zze3 == 1935894633) {
                        i7 = i5;
                        i6 = zze2;
                    }
                    i5 += zze2;
                }
                if (C.CENC_TYPE_cenc.equals(str) || C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str) || C.CENC_TYPE_cbcs.equals(str)) {
                    zzzm.zzb(num2 != null, "frma atom is mandatory");
                    zzzm.zzb(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            num = num2;
                            zzafw = null;
                            break;
                        }
                        zzef2.zzF(i8);
                        int zze4 = zzef.zze();
                        if (zzef.zze() == 1952804451) {
                            int zze5 = zzef.zze();
                            zzef2.zzG(1);
                            if (zzaex.zze(zze5) == 0) {
                                zzef2.zzG(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int zzk = zzef.zzk();
                                i4 = zzk & 15;
                                i3 = (zzk & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                            }
                            boolean z2 = zzef.zzk() == 1;
                            int zzk2 = zzef.zzk();
                            byte[] bArr2 = new byte[16];
                            zzef2.zzB(bArr2, 0, 16);
                            if (!z2 || zzk2 != 0) {
                                bArr = null;
                            } else {
                                int zzk3 = zzef.zzk();
                                byte[] bArr3 = new byte[zzk3];
                                zzef2.zzB(bArr3, 0, zzk3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzafw = new zzafw(z2, str, zzk2, bArr2, i3, i4, bArr);
                        } else {
                            Integer num3 = num2;
                            i8 += zze4;
                        }
                    }
                    if (zzafw == null) {
                        z = false;
                    }
                    zzzm.zzb(z, "tenc atom is mandatory");
                    int i9 = zzen.zza;
                    pair = Pair.create(num, zzafw);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            zzc += zze;
        }
        return null;
    }

    private static zzaez zzk(zzef zzef, int i) {
        zzef.zzF(i + 12);
        zzef.zzG(1);
        zzf(zzef);
        zzef.zzG(2);
        int zzk = zzef.zzk();
        if ((zzk & 128) != 0) {
            zzef.zzG(2);
        }
        if ((zzk & 64) != 0) {
            zzef.zzG(zzef.zzk());
        }
        if ((zzk & 32) != 0) {
            zzef.zzG(2);
        }
        zzef.zzG(1);
        zzf(zzef);
        String zzd = zzbt.zzd(zzef.zzk());
        if (MimeTypes.AUDIO_MPEG.equals(zzd) || MimeTypes.AUDIO_DTS.equals(zzd) || MimeTypes.AUDIO_DTS_HD.equals(zzd)) {
            return new zzaez(zzd, (byte[]) null, -1, -1);
        }
        zzef.zzG(4);
        long zzs = zzef.zzs();
        long zzs2 = zzef.zzs();
        zzef.zzG(1);
        int zzf = zzf(zzef);
        byte[] bArr = new byte[zzf];
        zzef.zzB(bArr, 0, zzf);
        return new zzaez(zzd, bArr, zzs2 <= 0 ? -1 : zzs2, zzs > 0 ? zzs : -1);
    }

    private static ByteBuffer zzl() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARNING: type inference failed for: r1v26, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03b3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:184:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzm(com.google.android.gms.internal.ads.zzef r23, int r24, int r25, int r26, int r27, java.lang.String r28, boolean r29, com.google.android.gms.internal.ads.zzx r30, com.google.android.gms.internal.ads.zzafb r31, int r32) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r0 = r23
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r30
            r6 = r31
            int r7 = r1 + 16
            r0.zzF(r7)
            r7 = 6
            if (r29 == 0) goto L_0x001e
            int r9 = r23.zzo()
            r0.zzG(r7)
            goto L_0x0024
        L_0x001e:
            r9 = 8
            r0.zzG(r9)
            r9 = 0
        L_0x0024:
            r10 = 20
            r11 = 16
            r12 = 2
            r13 = 1
            if (r9 == 0) goto L_0x004b
            if (r9 != r13) goto L_0x002f
            goto L_0x004b
        L_0x002f:
            if (r9 != r12) goto L_0x004a
            r0.zzG(r11)
            long r14 = r23.zzr()
            double r14 = java.lang.Double.longBitsToDouble(r14)
            long r14 = java.lang.Math.round(r14)
            int r7 = (int) r14
            int r9 = r23.zzn()
            r0.zzG(r10)
            r15 = 0
            goto L_0x0069
        L_0x004a:
            return
        L_0x004b:
            int r14 = r23.zzo()
            r0.zzG(r7)
            int r7 = r23.zzl()
            int r15 = r23.zzc()
            int r15 = r15 + -4
            r0.zzF(r15)
            int r15 = r23.zze()
            if (r9 != r13) goto L_0x0068
            r0.zzG(r11)
        L_0x0068:
            r9 = r14
        L_0x0069:
            int r11 = r23.zzc()
            r14 = 1701733217(0x656e6361, float:7.0359778E22)
            r12 = r24
            if (r12 != r14) goto L_0x009c
            android.util.Pair r12 = zzj(r0, r1, r2)
            if (r12 == 0) goto L_0x0098
            java.lang.Object r14 = r12.first
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            if (r5 != 0) goto L_0x0086
            r5 = 0
            goto L_0x0090
        L_0x0086:
            java.lang.Object r13 = r12.second
            com.google.android.gms.internal.ads.zzafw r13 = (com.google.android.gms.internal.ads.zzafw) r13
            java.lang.String r13 = r13.zzb
            com.google.android.gms.internal.ads.zzx r5 = r5.zzb(r13)
        L_0x0090:
            com.google.android.gms.internal.ads.zzafw[] r13 = r6.zza
            java.lang.Object r12 = r12.second
            com.google.android.gms.internal.ads.zzafw r12 = (com.google.android.gms.internal.ads.zzafw) r12
            r13[r32] = r12
        L_0x0098:
            r0.zzF(r11)
            r12 = r14
        L_0x009c:
            r13 = 1633889587(0x61632d33, float:2.6191674E20)
            r14 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r18 = "audio/raw"
            java.lang.String r10 = "audio/ac4"
            if (r12 != r13) goto L_0x00ad
            java.lang.String r12 = "audio/ac3"
        L_0x00aa:
            r13 = -1
            goto L_0x0163
        L_0x00ad:
            r13 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r12 != r13) goto L_0x00b5
            java.lang.String r12 = "audio/eac3"
            goto L_0x00aa
        L_0x00b5:
            r13 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r12 != r13) goto L_0x00bc
            r12 = r10
            goto L_0x00aa
        L_0x00bc:
            r13 = 1685353315(0x64747363, float:1.803728E22)
            if (r12 != r13) goto L_0x00c4
            java.lang.String r12 = "audio/vnd.dts"
            goto L_0x00aa
        L_0x00c4:
            r13 = 1685353320(0x64747368, float:1.8037286E22)
            if (r12 == r13) goto L_0x015f
            r13 = 1685353324(0x6474736c, float:1.803729E22)
            if (r12 != r13) goto L_0x00d0
            goto L_0x015f
        L_0x00d0:
            r13 = 1685353317(0x64747365, float:1.8037282E22)
            if (r12 != r13) goto L_0x00d8
            java.lang.String r12 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00aa
        L_0x00d8:
            r13 = 1685353336(0x64747378, float:1.8037304E22)
            if (r12 != r13) goto L_0x00e0
            java.lang.String r12 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x00aa
        L_0x00e0:
            r13 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r12 != r13) goto L_0x00e8
            java.lang.String r12 = "audio/3gpp"
            goto L_0x00aa
        L_0x00e8:
            r13 = 1935767394(0x73617762, float:1.7863284E31)
            if (r12 != r13) goto L_0x00f0
            java.lang.String r12 = "audio/amr-wb"
            goto L_0x00aa
        L_0x00f0:
            r13 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r12 == r13) goto L_0x015b
            r13 = 1936684916(0x736f7774, float:1.89725E31)
            if (r12 != r13) goto L_0x00fc
            goto L_0x015b
        L_0x00fc:
            r13 = 1953984371(0x74776f73, float:7.841539E31)
            if (r12 != r13) goto L_0x0107
            r12 = 268435456(0x10000000, float:2.5243549E-29)
            r13 = r12
            r12 = r18
            goto L_0x0163
        L_0x0107:
            r13 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r12 == r13) goto L_0x0157
            r13 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r12 != r13) goto L_0x0112
            goto L_0x0157
        L_0x0112:
            r13 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r12 != r13) goto L_0x011a
            java.lang.String r12 = "audio/mha1"
            goto L_0x00aa
        L_0x011a:
            r13 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r12 != r13) goto L_0x0122
            java.lang.String r12 = "audio/mhm1"
            goto L_0x00aa
        L_0x0122:
            if (r12 != r14) goto L_0x0127
            java.lang.String r12 = "audio/alac"
            goto L_0x00aa
        L_0x0127:
            r13 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r12 != r13) goto L_0x0130
            java.lang.String r12 = "audio/g711-alaw"
            goto L_0x00aa
        L_0x0130:
            r13 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r12 != r13) goto L_0x0139
            java.lang.String r12 = "audio/g711-mlaw"
            goto L_0x00aa
        L_0x0139:
            r13 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r12 != r13) goto L_0x0142
            java.lang.String r12 = "audio/opus"
            goto L_0x00aa
        L_0x0142:
            r13 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r12 != r13) goto L_0x014b
            java.lang.String r12 = "audio/flac"
            goto L_0x00aa
        L_0x014b:
            r13 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r12 != r13) goto L_0x0154
            java.lang.String r12 = "audio/true-hd"
            goto L_0x00aa
        L_0x0154:
            r12 = 0
            goto L_0x00aa
        L_0x0157:
            java.lang.String r12 = "audio/mpeg"
            goto L_0x00aa
        L_0x015b:
            r12 = r18
            r13 = 2
            goto L_0x0163
        L_0x015f:
            java.lang.String r12 = "audio/vnd.dts.hd"
            goto L_0x00aa
        L_0x0163:
            r8 = r7
            r7 = 0
            r18 = 0
            r20 = 0
        L_0x0169:
            int r14 = r11 - r1
            if (r14 >= r2) goto L_0x03ab
            r0.zzF(r11)
            int r14 = r23.zze()
            if (r14 <= 0) goto L_0x0178
            r1 = 1
            goto L_0x0179
        L_0x0178:
            r1 = 0
        L_0x0179:
            java.lang.String r2 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzzm.zzb(r1, r2)
            int r1 = r23.zze()
            r32 = r13
            r13 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r1 != r13) goto L_0x01a8
            int r1 = r14 + -13
            byte[] r2 = new byte[r1]
            int r13 = r11 + 13
            r0.zzF(r13)
            r13 = 0
            r0.zzB(r2, r13, r1)
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzp(r2)
            r20 = r1
            r21 = r7
        L_0x019e:
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
        L_0x01a1:
            r13 = 0
            r16 = 2
            r17 = 1
            goto L_0x03a0
        L_0x01a8:
            r13 = 1702061171(0x65736473, float:7.183675E22)
            if (r1 == r13) goto L_0x0368
            if (r29 == 0) goto L_0x01fe
            r13 = 2002876005(0x77617665, float:4.5729223E33)
            if (r1 != r13) goto L_0x01fe
            int r1 = r23.zzc()
            if (r1 < r11) goto L_0x01bf
            r21 = r1
            r1 = 0
            r13 = 1
            goto L_0x01c3
        L_0x01bf:
            r21 = r1
            r1 = 0
            r13 = 0
        L_0x01c3:
            com.google.android.gms.internal.ads.zzzm.zzb(r13, r1)
            r1 = r21
        L_0x01c8:
            int r13 = r1 - r11
            if (r13 >= r14) goto L_0x01f0
            r0.zzF(r1)
            int r13 = r23.zze()
            if (r13 <= 0) goto L_0x01d9
            r21 = r7
            r7 = 1
            goto L_0x01dc
        L_0x01d9:
            r21 = r7
            r7 = 0
        L_0x01dc:
            com.google.android.gms.internal.ads.zzzm.zzb(r7, r2)
            int r7 = r23.zze()
            r22 = r2
            r2 = 1702061171(0x65736473, float:7.183675E22)
            if (r7 == r2) goto L_0x01f3
            int r1 = r1 + r13
            r7 = r21
            r2 = r22
            goto L_0x01c8
        L_0x01f0:
            r21 = r7
            r1 = -1
        L_0x01f3:
            r2 = -1
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            r13 = 0
            r16 = 2
            r17 = 1
            goto L_0x0374
        L_0x01fe:
            r21 = r7
            r2 = 1684103987(0x64616333, float:1.6630662E22)
            if (r1 != r2) goto L_0x0217
            int r1 = r11 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r27)
            com.google.android.gms.internal.ads.zzaf r1 = com.google.android.gms.internal.ads.zzyj.zzc(r0, r1, r4, r5)
            r6.zzb = r1
        L_0x0214:
            r2 = 20
            goto L_0x019e
        L_0x0217:
            r2 = 1684366131(0x64656333, float:1.692581E22)
            if (r1 != r2) goto L_0x022c
            int r1 = r11 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r27)
            com.google.android.gms.internal.ads.zzaf r1 = com.google.android.gms.internal.ads.zzyj.zzd(r0, r1, r4, r5)
            r6.zzb = r1
            goto L_0x0214
        L_0x022c:
            r2 = 1684103988(0x64616334, float:1.6630663E22)
            if (r1 != r2) goto L_0x0270
            int r1 = r11 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r27)
            int r2 = com.google.android.gms.internal.ads.zzym.zza
            r7 = 1
            r0.zzG(r7)
            int r2 = r23.zzk()
            r2 = r2 & 32
            int r2 = r2 >> 5
            if (r7 == r2) goto L_0x024e
            r2 = 44100(0xac44, float:6.1797E-41)
            goto L_0x0251
        L_0x024e:
            r2 = 48000(0xbb80, float:6.7262E-41)
        L_0x0251:
            com.google.android.gms.internal.ads.zzad r7 = new com.google.android.gms.internal.ads.zzad
            r7.<init>()
            r7.zzH(r1)
            r7.zzS(r10)
            r1 = 2
            r7.zzw(r1)
            r7.zzT(r2)
            r7.zzB(r5)
            r7.zzK(r4)
            com.google.android.gms.internal.ads.zzaf r1 = r7.zzY()
            r6.zzb = r1
            goto L_0x0214
        L_0x0270:
            r2 = 1684892784(0x646d6c70, float:1.7518768E22)
            if (r1 != r2) goto L_0x0295
            if (r15 <= 0) goto L_0x027e
            r8 = r15
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            r9 = 2
            goto L_0x01a1
        L_0x027e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid sample rate for Dolby TrueHD MLP stream: "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r2)
            throw r0
        L_0x0295:
            r2 = 0
            r7 = 1684305011(0x64647473, float:1.6856995E22)
            if (r1 != r7) goto L_0x02ba
            com.google.android.gms.internal.ads.zzad r1 = new com.google.android.gms.internal.ads.zzad
            r1.<init>()
            r1.zzG(r3)
            r1.zzS(r12)
            r1.zzw(r9)
            r1.zzT(r8)
            r1.zzB(r5)
            r1.zzK(r4)
            com.google.android.gms.internal.ads.zzaf r1 = r1.zzY()
            r6.zzb = r1
            goto L_0x0214
        L_0x02ba:
            r7 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r1 != r7) goto L_0x02dc
            int r1 = r14 + -8
            byte[] r7 = zza
            int r13 = r7.length
            int r13 = r13 + r1
            byte[] r7 = java.util.Arrays.copyOf(r7, r13)
            int r13 = r11 + 8
            r0.zzF(r13)
            byte[] r13 = zza
            int r13 = r13.length
            r0.zzB(r7, r13, r1)
            java.util.List r1 = com.google.android.gms.internal.ads.zzaag.zza(r7)
            r20 = r1
            goto L_0x019e
        L_0x02dc:
            r7 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r1 != r7) goto L_0x0313
            int r1 = r14 + -12
            int r7 = r1 + 4
            byte[] r7 = new byte[r7]
            r13 = 102(0x66, float:1.43E-43)
            r19 = 0
            r7[r19] = r13
            r13 = 76
            r17 = 1
            r7[r17] = r13
            r13 = 97
            r16 = 2
            r7[r16] = r13
            r13 = 3
            r19 = 67
            r7[r13] = r19
            int r13 = r11 + 12
            r0.zzF(r13)
            r13 = 4
            r0.zzB(r7, r13, r1)
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzp(r7)
            r20 = r1
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
        L_0x0310:
            r13 = 0
            goto L_0x03a0
        L_0x0313:
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            r16 = 2
            r17 = 1
            if (r1 != r7) goto L_0x0365
            int r1 = r14 + -12
            byte[] r8 = new byte[r1]
            int r9 = r11 + 12
            r0.zzF(r9)
            r13 = 0
            r0.zzB(r8, r13, r1)
            com.google.android.gms.internal.ads.zzef r1 = new com.google.android.gms.internal.ads.zzef
            r1.<init>((byte[]) r8)
            r9 = 9
            r1.zzF(r9)
            int r9 = r1.zzk()
            r2 = 20
            r1.zzF(r2)
            int r1 = r1.zzn()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            android.util.Pair r1 = android.util.Pair.create(r1, r9)
            java.lang.Object r9 = r1.first
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.android.gms.internal.ads.zzfvn r8 = com.google.android.gms.internal.ads.zzfvn.zzp(r8)
            r20 = r8
            r8 = r9
            r9 = r1
            goto L_0x03a0
        L_0x0365:
            r2 = 20
            goto L_0x0310
        L_0x0368:
            r21 = r7
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            r13 = 0
            r16 = 2
            r17 = 1
            r1 = r11
            r2 = -1
        L_0x0374:
            if (r1 == r2) goto L_0x039c
            com.google.android.gms.internal.ads.zzaez r18 = zzk(r0, r1)
            java.lang.String r12 = r18.zza
            byte[] r1 = r18.zzb
            if (r1 == 0) goto L_0x039c
            java.lang.String r2 = "audio/mp4a-latm"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0398
            com.google.android.gms.internal.ads.zzyf r2 = com.google.android.gms.internal.ads.zzyg.zza(r1)
            int r8 = r2.zza
            int r9 = r2.zzb
            java.lang.String r2 = r2.zzc
            r21 = r2
        L_0x0398:
            com.google.android.gms.internal.ads.zzfvn r20 = com.google.android.gms.internal.ads.zzfvn.zzp(r1)
        L_0x039c:
            r1 = r12
            r12 = r9
            r9 = r12
            r12 = r1
        L_0x03a0:
            int r11 = r11 + r14
            r1 = r25
            r2 = r26
            r13 = r32
            r7 = r21
            goto L_0x0169
        L_0x03ab:
            r21 = r7
            r32 = r13
            com.google.android.gms.internal.ads.zzaf r0 = r6.zzb
            if (r0 != 0) goto L_0x03f9
            if (r12 == 0) goto L_0x03f9
            com.google.android.gms.internal.ads.zzad r0 = new com.google.android.gms.internal.ads.zzad
            r0.<init>()
            r0.zzG(r3)
            r0.zzS(r12)
            r1 = r21
            r0.zzx(r1)
            r0.zzw(r9)
            r0.zzT(r8)
            r8 = r32
            r0.zzN(r8)
            r1 = r20
            r0.zzI(r1)
            r0.zzB(r5)
            r0.zzK(r4)
            if (r18 == 0) goto L_0x03f3
            long r1 = r18.zzc
            int r1 = com.google.android.gms.internal.ads.zzfxs.zzc(r1)
            r0.zzv(r1)
            long r1 = r18.zzd
            int r1 = com.google.android.gms.internal.ads.zzfxs.zzc(r1)
            r0.zzO(r1)
        L_0x03f3:
            com.google.android.gms.internal.ads.zzaf r0 = r0.zzY()
            r6.zzb = r0
        L_0x03f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaff.zzm(com.google.android.gms.internal.ads.zzef, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzx, com.google.android.gms.internal.ads.zzafb, int):void");
    }

    private static void zzn(zzef zzef, int i, int i2, int i3, zzafb zzafb) {
        zzef.zzF(i2 + 16);
        zzef.zzv(0);
        String zzv = zzef.zzv(0);
        if (zzv != null) {
            zzad zzad = new zzad();
            zzad.zzG(i3);
            zzad.zzS(zzv);
            zzafb.zzb = zzad.zzY();
        }
    }

    private static boolean zzo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length;
        int i = length - 1;
        int zzf = zzen.zzf(4, 0, i);
        int zzf2 = zzen.zzf(length - 4, 0, i);
        if (jArr[0] > j2 || j2 >= jArr[zzf] || jArr[zzf2] >= j3 || j3 > j) {
            return false;
        }
        return true;
    }
}
