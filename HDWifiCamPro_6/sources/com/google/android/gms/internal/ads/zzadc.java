package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzadc {
    public static final zzada zza = zzacz.zza;

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.google.android.gms.internal.ads.zzbq zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzada r13, com.google.android.gms.internal.ads.zzacd r14) {
        /*
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.google.android.gms.internal.ads.zzef r0 = new com.google.android.gms.internal.ads.zzef
            r0.<init>(r11, r12)
            int r11 = r0.zza()
            r12 = 2
            r1 = 10
            r2 = 4
            r3 = 0
            r4 = 1
            java.lang.String r5 = "Id3Decoder"
            r6 = 0
            if (r11 >= r1) goto L_0x0021
            java.lang.String r11 = "Data too short to be an ID3 tag"
            com.google.android.gms.internal.ads.zzdw.zze(r5, r11)
        L_0x001e:
            r9 = r6
            goto L_0x00ad
        L_0x0021:
            int r11 = r0.zzm()
            r7 = 4801587(0x494433, float:6.728456E-39)
            if (r11 == r7) goto L_0x0046
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7[r3] = r11
            java.lang.String r11 = "%06X"
            java.lang.String r11 = java.lang.String.format(r11, r7)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r7 = "Unexpected first three bytes of ID3 tag header: 0x"
            java.lang.String r11 = r7.concat(r11)
            com.google.android.gms.internal.ads.zzdw.zze(r5, r11)
            goto L_0x001e
        L_0x0046:
            int r11 = r0.zzk()
            r0.zzG(r4)
            int r7 = r0.zzk()
            int r8 = r0.zzj()
            if (r11 != r12) goto L_0x0061
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0088
            java.lang.String r11 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme"
            com.google.android.gms.internal.ads.zzdw.zze(r5, r11)
            goto L_0x001e
        L_0x0061:
            r9 = 3
            if (r11 != r9) goto L_0x0072
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0088
            int r9 = r0.zze()
            r0.zzG(r9)
            int r9 = r9 + r2
            int r8 = r8 - r9
            goto L_0x0088
        L_0x0072:
            if (r11 != r2) goto L_0x0097
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0082
            int r9 = r0.zzj()
            int r10 = r9 + -4
            r0.zzG(r10)
            int r8 = r8 - r9
        L_0x0082:
            r9 = r7 & 16
            if (r9 == 0) goto L_0x0088
            int r8 = r8 + -10
        L_0x0088:
            if (r11 >= r2) goto L_0x0090
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0090
            r7 = r4
            goto L_0x0091
        L_0x0090:
            r7 = r3
        L_0x0091:
            com.google.android.gms.internal.ads.zzadb r9 = new com.google.android.gms.internal.ads.zzadb
            r9.<init>(r11, r7, r8)
            goto L_0x00ad
        L_0x0097:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Skipped ID3 tag with unsupported majorVersion="
            r7.append(r8)
            r7.append(r11)
            java.lang.String r11 = r7.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r5, r11)
            goto L_0x001e
        L_0x00ad:
            if (r9 != 0) goto L_0x00b0
            return r6
        L_0x00b0:
            int r11 = r0.zzc()
            int r7 = r9.zza
            if (r7 != r12) goto L_0x00bb
            r1 = 6
        L_0x00bb:
            int r12 = r9.zzc
            boolean r7 = r9.zzb
            if (r7 == 0) goto L_0x00cd
            int r12 = r9.zzc
            int r12 = zze(r0, r12)
        L_0x00cd:
            int r11 = r11 + r12
            r0.zzE(r11)
            int r11 = r9.zza
            boolean r11 = zzj(r0, r11, r1, r3)
            if (r11 != 0) goto L_0x0102
            int r11 = r9.zza
            if (r11 != r2) goto L_0x00e9
            boolean r11 = zzj(r0, r2, r1, r4)
            if (r11 == 0) goto L_0x00e9
            r3 = r4
            goto L_0x0102
        L_0x00e9:
            int r11 = r9.zza
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Failed to validate ID3 tag with majorVersion="
            r12.append(r13)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r5, r11)
            return r6
        L_0x0102:
            int r11 = r0.zza()
            if (r11 < r1) goto L_0x0116
            int r11 = r9.zza
            com.google.android.gms.internal.ads.zzadd r11 = zzf(r11, r0, r3, r1, r13)
            if (r11 == 0) goto L_0x0102
            r14.add(r11)
            goto L_0x0102
        L_0x0116:
            com.google.android.gms.internal.ads.zzbq r11 = new com.google.android.gms.internal.ads.zzbq
            r11.<init>((java.util.List) r14)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadc.zza(byte[], int, com.google.android.gms.internal.ads.zzada, com.google.android.gms.internal.ads.zzacd):com.google.android.gms.internal.ads.zzbq");
    }

    private static int zzb(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int zzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return zzd;
        }
        while (true) {
            int length = bArr.length;
            if (zzd >= length - 1) {
                return length;
            }
            if ((zzd - i) % 2 == 0 && bArr[zzd + 1] == 0) {
                return zzd;
            }
            zzd = zzd(bArr, zzd + 1);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzef zzef, int i) {
        byte[] zzH = zzef.zzH();
        int zzc = zzef.zzc();
        int i2 = i;
        int i3 = zzc;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= zzc + i2) {
                return i2;
            }
            if ((zzH[i3] & UByte.MAX_VALUE) == 255 && zzH[i4] == 0) {
                System.arraycopy(zzH, i3 + 2, zzH, i4, (i2 - (i3 - zzc)) - 2);
                i2--;
            }
            i3 = i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0255, code lost:
        if (r9 == 67) goto L_0x0257;
     */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02e2 A[Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x032a A[Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x04f6 A[Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzadd zzf(int r32, com.google.android.gms.internal.ads.zzef r33, boolean r34, int r35, com.google.android.gms.internal.ads.zzada r36) {
        /*
            r0 = r32
            r1 = r33
            r2 = r34
            r3 = r35
            int r4 = r33.zzk()
            int r5 = r33.zzk()
            int r6 = r33.zzk()
            r7 = 3
            r8 = 0
            if (r0 < r7) goto L_0x001d
            int r9 = r33.zzk()
            goto L_0x001e
        L_0x001d:
            r9 = r8
        L_0x001e:
            r10 = 4
            if (r0 != r10) goto L_0x003d
            int r11 = r33.zzn()
            if (r2 != 0) goto L_0x0048
            r12 = r11 & 255(0xff, float:3.57E-43)
            int r13 = r11 >> 8
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 7
            r12 = r12 | r13
            int r13 = r11 >> 16
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 14
            r12 = r12 | r13
            int r11 = r11 >> 24
            int r11 = r11 << 21
            r11 = r11 | r12
            goto L_0x0048
        L_0x003d:
            if (r0 != r7) goto L_0x0044
            int r11 = r33.zzn()
            goto L_0x0048
        L_0x0044:
            int r11 = r33.zzm()
        L_0x0048:
            if (r0 < r7) goto L_0x004f
            int r12 = r33.zzo()
            goto L_0x0050
        L_0x004f:
            r12 = r8
        L_0x0050:
            r13 = 0
            if (r4 != 0) goto L_0x0066
            if (r5 != 0) goto L_0x0066
            if (r6 != 0) goto L_0x0066
            if (r9 != 0) goto L_0x0066
            if (r11 != 0) goto L_0x0066
            if (r12 == 0) goto L_0x005e
            goto L_0x0066
        L_0x005e:
            int r0 = r33.zzd()
            r1.zzF(r0)
            return r13
        L_0x0066:
            int r14 = r33.zzc()
            int r14 = r14 + r11
            int r15 = r33.zzd()
            if (r14 <= r15) goto L_0x0080
            java.lang.String r0 = "Id3Decoder"
            java.lang.String r2 = "Frame size exceeds remaining tag data"
            com.google.android.gms.internal.ads.zzdw.zze(r0, r2)
            int r0 = r33.zzd()
            r1.zzF(r0)
            return r13
        L_0x0080:
            if (r36 != 0) goto L_0x0544
            r15 = 1
            if (r0 != r7) goto L_0x00a3
            r7 = r12 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x008b
            r7 = r15
            goto L_0x008c
        L_0x008b:
            r7 = r8
        L_0x008c:
            r17 = r12 & 64
            if (r17 == 0) goto L_0x0093
            r17 = r15
            goto L_0x0095
        L_0x0093:
            r17 = r8
        L_0x0095:
            r12 = r12 & 32
            if (r12 == 0) goto L_0x009b
            r12 = r15
            goto L_0x009c
        L_0x009b:
            r12 = r8
        L_0x009c:
            r19 = r8
            r18 = r17
            r17 = r7
            goto L_0x00d6
        L_0x00a3:
            if (r0 != r10) goto L_0x00ce
            r7 = r12 & 64
            if (r7 == 0) goto L_0x00ab
            r7 = r15
            goto L_0x00ac
        L_0x00ab:
            r7 = r8
        L_0x00ac:
            r17 = r12 & 8
            if (r17 == 0) goto L_0x00b3
            r17 = r15
            goto L_0x00b5
        L_0x00b3:
            r17 = r8
        L_0x00b5:
            r18 = r12 & 4
            if (r18 == 0) goto L_0x00bc
            r18 = r15
            goto L_0x00be
        L_0x00bc:
            r18 = r8
        L_0x00be:
            r19 = r12 & 2
            if (r19 == 0) goto L_0x00c5
            r19 = r15
            goto L_0x00c7
        L_0x00c5:
            r19 = r8
        L_0x00c7:
            r12 = r12 & r15
            r31 = r12
            r12 = r7
            r7 = r31
            goto L_0x00d6
        L_0x00ce:
            r7 = r8
            r12 = r7
            r17 = r12
            r18 = r17
            r19 = r18
        L_0x00d6:
            if (r17 != 0) goto L_0x0538
            if (r18 == 0) goto L_0x00dc
            goto L_0x0538
        L_0x00dc:
            if (r12 == 0) goto L_0x00e3
            int r11 = r11 + -1
            r1.zzG(r15)
        L_0x00e3:
            if (r7 == 0) goto L_0x00ea
            int r11 = r11 + -4
            r1.zzG(r10)
        L_0x00ea:
            if (r19 == 0) goto L_0x00f0
            int r11 = zze(r1, r11)
        L_0x00f0:
            r7 = 84
            r12 = 88
            r10 = 2
            if (r4 != r7) goto L_0x012f
            if (r5 != r12) goto L_0x012f
            if (r6 != r12) goto L_0x012f
            if (r0 == r10) goto L_0x00ff
            if (r9 != r12) goto L_0x012f
        L_0x00ff:
            if (r11 > 0) goto L_0x0102
            goto L_0x0137
        L_0x0102:
            int r2 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = r11 + -1
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r1.zzB(r10, r8, r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = zzc(r10, r8, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r12.<init>(r10, r8, r7, r3)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r8 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = r7 + r8
            int r2 = zzc(r10, r7, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r2 = zzg(r10, r7, r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            com.google.android.gms.internal.ads.zzadl r3 = new com.google.android.gms.internal.ads.zzadl     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r7 = "TXXX"
            r3.<init>(r7, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            goto L_0x015d
        L_0x012f:
            if (r4 != r7) goto L_0x0162
            java.lang.String r2 = zzi(r0, r7, r5, r6, r9)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            if (r11 > 0) goto L_0x0140
        L_0x0137:
            r17 = r4
            r3 = r5
            r4 = r6
            r8 = r9
            r21 = r14
            goto L_0x04f4
        L_0x0140:
            int r3 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r7 = zzh(r3)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r10 = r11 + -1
            byte[] r12 = new byte[r10]     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r1.zzB(r12, r8, r10)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r3 = zzc(r12, r8, r3)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r10 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r10.<init>(r12, r8, r3, r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            com.google.android.gms.internal.ads.zzadl r3 = new com.google.android.gms.internal.ads.zzadl     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r3.<init>(r2, r13, r10)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
        L_0x015d:
            r13 = r3
            goto L_0x0137
        L_0x015f:
            r0 = move-exception
            goto L_0x0534
        L_0x0162:
            r7 = 87
            java.lang.String r15 = "ISO-8859-1"
            if (r4 != r7) goto L_0x01a2
            if (r5 != r12) goto L_0x01a0
            if (r6 != r12) goto L_0x01a0
            if (r0 == r10) goto L_0x0170
            if (r9 != r12) goto L_0x01a0
        L_0x0170:
            if (r11 > 0) goto L_0x0173
            goto L_0x0137
        L_0x0173:
            int r2 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = r11 + -1
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r1.zzB(r10, r8, r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = zzc(r10, r8, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r12.<init>(r10, r8, r7, r3)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r2 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = r7 + r2
            int r2 = zzd(r10, r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r2 = zzg(r10, r7, r2, r15)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            com.google.android.gms.internal.ads.zzadn r3 = new com.google.android.gms.internal.ads.zzadn     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r7 = "WXXX"
            r3.<init>(r7, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            goto L_0x015d
        L_0x01a0:
            r12 = r7
            goto L_0x01a3
        L_0x01a2:
            r12 = r4
        L_0x01a3:
            if (r12 != r7) goto L_0x01bd
            java.lang.String r2 = zzi(r0, r7, r5, r6, r9)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            byte[] r3 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r1.zzB(r3, r8, r11)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = zzd(r3, r8)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r10 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r10.<init>(r3, r8, r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            com.google.android.gms.internal.ads.zzadn r3 = new com.google.android.gms.internal.ads.zzadn     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r3.<init>(r2, r13, r10)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            goto L_0x015d
        L_0x01bd:
            r7 = 80
            if (r12 != r7) goto L_0x01ea
            r12 = 82
            if (r5 != r12) goto L_0x01e9
            r12 = 73
            if (r6 != r12) goto L_0x01e9
            r12 = 86
            if (r9 != r12) goto L_0x01e9
            byte[] r2 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r1.zzB(r2, r8, r11)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r3 = zzd(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r7 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r7.<init>(r2, r8, r3, r15)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r8 = 1
            int r3 = r3 + r8
            int r8 = r2.length     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            byte[] r2 = zzk(r2, r3, r8)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            com.google.android.gms.internal.ads.zzadj r3 = new com.google.android.gms.internal.ads.zzadj     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r3.<init>(r7, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            goto L_0x015d
        L_0x01e9:
            r12 = r7
        L_0x01ea:
            r13 = 71
            if (r12 != r13) goto L_0x023e
            r12 = 69
            if (r5 != r12) goto L_0x023c
            r12 = 79
            if (r6 != r12) goto L_0x023c
            r12 = 66
            if (r9 == r12) goto L_0x01fc
            if (r0 != r10) goto L_0x023c
        L_0x01fc:
            int r2 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = r11 + -1
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r1.zzB(r10, r8, r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = zzd(r10, r8)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r12.<init>(r10, r8, r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r8 = 1
            int r7 = r7 + r8
            int r8 = zzc(r10, r7, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r7 = zzg(r10, r7, r8, r3)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r13 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r8 = r8 + r13
            int r13 = zzc(r10, r8, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r3 = zzg(r10, r8, r13, r3)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r2 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r13 = r13 + r2
            int r2 = r10.length     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            byte[] r2 = zzk(r10, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            com.google.android.gms.internal.ads.zzacy r13 = new com.google.android.gms.internal.ads.zzacy     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r13.<init>(r12, r7, r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            goto L_0x0137
        L_0x023c:
            r12 = 71
        L_0x023e:
            r13 = 67
            if (r0 != r10) goto L_0x024b
            if (r12 != r7) goto L_0x02cf
            r10 = 73
            if (r5 != r10) goto L_0x02cf
            if (r6 != r13) goto L_0x02cf
            goto L_0x0257
        L_0x024b:
            r10 = 65
            if (r12 != r10) goto L_0x02cf
            if (r5 != r7) goto L_0x02cf
            r10 = 73
            if (r6 != r10) goto L_0x02cf
            if (r9 != r13) goto L_0x02cf
        L_0x0257:
            int r2 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            int r7 = r11 + -1
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r1.zzB(r10, r8, r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r7 = 2
            if (r0 != r7) goto L_0x028a
            java.lang.String r7 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r12 = 3
            r7.<init>(r10, r8, r12, r15)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r8 = "image/"
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfse.zza(r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r7 = r8.concat(r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r8 = "image/jpg"
            boolean r8 = r8.equals(r7)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            if (r8 == 0) goto L_0x0287
            java.lang.String r7 = "image/jpeg"
        L_0x0287:
            r8 = r7
            r7 = 2
            goto L_0x02aa
        L_0x028a:
            int r7 = zzd(r10, r8)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r12.<init>(r10, r8, r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfse.zza(r12)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r12 = 47
            int r12 = r8.indexOf(r12)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r13 = -1
            if (r12 != r13) goto L_0x02aa
            java.lang.String r12 = "image/"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r8 = r12.concat(r8)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
        L_0x02aa:
            int r12 = r7 + 1
            byte r12 = r10[r12]     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r12 = r12 & 255(0xff, float:3.57E-43)
            r13 = 2
            int r7 = r7 + r13
            int r13 = zzc(r10, r7, r2)     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            java.lang.String r15 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0528 }
            r21 = r14
            int r14 = r13 - r7
            r15.<init>(r10, r7, r14, r3)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r2 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r13 = r13 + r2
            int r2 = r10.length     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            byte[] r2 = zzk(r10, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            com.google.android.gms.internal.ads.zzaco r13 = new com.google.android.gms.internal.ads.zzaco     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r13.<init>(r8, r15, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            goto L_0x0323
        L_0x02cf:
            r21 = r14
            if (r12 != r13) goto L_0x032a
            r10 = 79
            if (r5 != r10) goto L_0x032a
            r10 = 77
            if (r6 != r10) goto L_0x032a
            r10 = 77
            if (r9 == r10) goto L_0x02e2
            r10 = 2
            if (r0 != r10) goto L_0x032a
        L_0x02e2:
            r2 = 4
            if (r11 >= r2) goto L_0x02ed
            r17 = r4
            r3 = r5
            r4 = r6
            r8 = r9
            r13 = 0
            goto L_0x04f4
        L_0x02ed:
            int r2 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r7 = 3
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r1.zzB(r10, r8, r7)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r12.<init>(r10, r8, r7)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r7 = r11 + -4
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r1.zzB(r10, r8, r7)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r7 = zzc(r10, r8, r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String r13 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r13.<init>(r10, r8, r7, r3)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r8 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r7 = r7 + r8
            int r2 = zzc(r10, r7, r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String r2 = zzg(r10, r7, r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            com.google.android.gms.internal.ads.zzacw r3 = new com.google.android.gms.internal.ads.zzacw     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r3.<init>(r12, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r13 = r3
        L_0x0323:
            r17 = r4
            r3 = r5
            r4 = r6
            r8 = r9
            goto L_0x04f4
        L_0x032a:
            if (r12 != r13) goto L_0x03a9
            r10 = 72
            if (r5 != r10) goto L_0x03a9
            r10 = 65
            if (r6 != r10) goto L_0x03a9
            if (r9 != r7) goto L_0x03a9
            int r7 = r33.zzc()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            byte[] r10 = r33.zzH()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r10 = zzd(r10, r7)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            byte[] r13 = r33.zzH()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r14 = r10 - r7
            r12.<init>(r13, r7, r14, r15)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r13 = 1
            int r10 = r10 + r13
            r1.zzF(r10)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r24 = r33.zze()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r25 = r33.zze()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            long r13 = r33.zzs()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r15 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 != 0) goto L_0x0369
            r13 = -1
        L_0x0369:
            r26 = r13
            long r13 = r33.zzs()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r15 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 != 0) goto L_0x037a
            r13 = -1
        L_0x037a:
            r28 = r13
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r10.<init>()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r7 = r7 + r11
        L_0x0382:
            int r13 = r33.zzc()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            if (r13 >= r7) goto L_0x0393
            r13 = 0
            com.google.android.gms.internal.ads.zzadd r14 = zzf(r0, r1, r2, r3, r13)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            if (r14 == 0) goto L_0x0382
            r10.add(r14)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            goto L_0x0382
        L_0x0393:
            com.google.android.gms.internal.ads.zzadd[] r2 = new com.google.android.gms.internal.ads.zzadd[r8]     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.Object[] r2 = r10.toArray(r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r30 = r2
            com.google.android.gms.internal.ads.zzadd[] r30 = (com.google.android.gms.internal.ads.zzadd[]) r30     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            com.google.android.gms.internal.ads.zzacs r2 = new com.google.android.gms.internal.ads.zzacs     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r22 = r2
            r23 = r12
            r22.<init>(r23, r24, r25, r26, r28, r30)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r13 = r2
            goto L_0x0323
        L_0x03a9:
            if (r12 != r13) goto L_0x0465
            r7 = 84
            if (r5 != r7) goto L_0x0465
            r7 = 79
            if (r6 != r7) goto L_0x0465
            if (r9 != r13) goto L_0x0465
            int r7 = r33.zzc()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            byte[] r10 = r33.zzH()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r10 = zzd(r10, r7)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            byte[] r13 = r33.zzH()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r14 = r10 - r7
            r12.<init>(r13, r7, r14, r15)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r18 = 1
            int r10 = r10 + 1
            r1.zzF(r10)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r10 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r13 = r10 & 2
            if (r13 == 0) goto L_0x03de
            r24 = r18
            goto L_0x03e0
        L_0x03de:
            r24 = r8
        L_0x03e0:
            r10 = r10 & 1
            int r13 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
        L_0x03e8:
            if (r8 >= r13) goto L_0x041f
            r36 = r13
            int r13 = r33.zzc()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r17 = r4
            byte[] r4 = r33.zzH()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r4 = zzd(r4, r13)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r20 = r9
            java.lang.String r9 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r28 = r6
            byte[] r6 = r33.zzH()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r29 = r5
            int r5 = r4 - r13
            r9.<init>(r6, r13, r5, r15)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r14[r8] = r9     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r4 = r4 + 1
            r1.zzF(r4)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r8 = r8 + 1
            r13 = r36
            r4 = r17
            r9 = r20
            r6 = r28
            r5 = r29
            goto L_0x03e8
        L_0x041f:
            r17 = r4
            r29 = r5
            r28 = r6
            r20 = r9
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r4.<init>()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r7 = r7 + r11
        L_0x042d:
            int r5 = r33.zzc()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            if (r5 >= r7) goto L_0x043e
            r5 = 0
            com.google.android.gms.internal.ads.zzadd r6 = zzf(r0, r1, r2, r3, r5)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            if (r6 == 0) goto L_0x042d
            r4.add(r6)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            goto L_0x042d
        L_0x043e:
            r2 = 0
            com.google.android.gms.internal.ads.zzadd[] r3 = new com.google.android.gms.internal.ads.zzadd[r2]     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.Object[] r2 = r4.toArray(r3)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r27 = r2
            com.google.android.gms.internal.ads.zzadd[] r27 = (com.google.android.gms.internal.ads.zzadd[]) r27     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            com.google.android.gms.internal.ads.zzacu r2 = new com.google.android.gms.internal.ads.zzacu     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r8 = 1
            if (r8 == r10) goto L_0x0451
            r25 = 0
            goto L_0x0453
        L_0x0451:
            r25 = r8
        L_0x0453:
            r22 = r2
            r23 = r12
            r26 = r14
            r22.<init>(r23, r24, r25, r26, r27)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r13 = r2
            r8 = r20
            r4 = r28
            r3 = r29
            goto L_0x04f4
        L_0x0465:
            r17 = r4
            r29 = r5
            r28 = r6
            r20 = r9
            r2 = 77
            if (r12 != r2) goto L_0x04df
            r2 = 76
            r3 = r29
            if (r3 != r2) goto L_0x04da
            r2 = 76
            r4 = r28
            r8 = r20
            if (r4 != r2) goto L_0x04e5
            r2 = 84
            if (r8 != r2) goto L_0x04e5
            int r23 = r33.zzo()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r24 = r33.zzm()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r25 = r33.zzm()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r2 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r5 = r33.zzk()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            com.google.android.gms.internal.ads.zzee r6 = new com.google.android.gms.internal.ads.zzee     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r6.<init>()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            byte[] r7 = r33.zzH()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r9 = r33.zzd()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r6.zzg(r7, r9)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r7 = r33.zzc()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r7 = r7 * 8
            r6.zzh(r7)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r7 = r11 + -10
            int r7 = r7 * 8
            int r9 = r2 + r5
            int r7 = r7 / r9
            int[] r9 = new int[r7]     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int[] r10 = new int[r7]     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r12 = 0
        L_0x04bc:
            if (r12 >= r7) goto L_0x04cd
            int r13 = r6.zzc(r2)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r14 = r6.zzc(r5)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r9[r12] = r13     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r10[r12] = r14     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            int r12 = r12 + 1
            goto L_0x04bc
        L_0x04cd:
            com.google.android.gms.internal.ads.zzadh r2 = new com.google.android.gms.internal.ads.zzadh     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r22 = r2
            r26 = r9
            r27 = r10
            r22.<init>(r23, r24, r25, r26, r27)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r13 = r2
            goto L_0x04f4
        L_0x04da:
            r8 = r20
            r4 = r28
            goto L_0x04e5
        L_0x04df:
            r8 = r20
            r4 = r28
            r3 = r29
        L_0x04e5:
            java.lang.String r2 = zzi(r0, r12, r3, r4, r8)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            byte[] r5 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r6 = 0
            r1.zzB(r5, r6, r11)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            com.google.android.gms.internal.ads.zzacq r13 = new com.google.android.gms.internal.ads.zzacq     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r13.<init>(r2, r5)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
        L_0x04f4:
            if (r13 != 0) goto L_0x0522
            java.lang.String r2 = "Id3Decoder"
            r5 = r17
            java.lang.String r0 = zzi(r0, r5, r3, r4, r8)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r3.<init>()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String r4 = "Failed to decode frame: id="
            r3.append(r4)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r3.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String r0 = ", frameSize="
            r3.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            r3.append(r11)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            java.lang.String r0 = r3.toString()     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)     // Catch:{ UnsupportedEncodingException -> 0x051f, all -> 0x051b }
            goto L_0x0522
        L_0x051b:
            r0 = move-exception
            r14 = r21
            goto L_0x0534
        L_0x051f:
            r14 = r21
            goto L_0x0528
        L_0x0522:
            r14 = r21
            r1.zzF(r14)
            return r13
        L_0x0528:
            java.lang.String r0 = "Id3Decoder"
            java.lang.String r2 = "Unsupported character encoding"
            com.google.android.gms.internal.ads.zzdw.zze(r0, r2)     // Catch:{ all -> 0x015f }
            r1.zzF(r14)
            r0 = 0
            return r0
        L_0x0534:
            r1.zzF(r14)
            throw r0
        L_0x0538:
            java.lang.String r0 = "Id3Decoder"
            java.lang.String r2 = "Skipping unsupported compressed or encrypted frame"
            com.google.android.gms.internal.ads.zzdw.zze(r0, r2)
            r1.zzF(r14)
            r0 = 0
            return r0
        L_0x0544:
            r0 = r13
            r1.zzF(r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadc.zzf(int, com.google.android.gms.internal.ads.zzef, boolean, int, com.google.android.gms.internal.ads.zzada):com.google.android.gms.internal.ads.zzadd");
    }

    private static String zzg(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    private static String zzh(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : C.UTF16_NAME;
    }

    private static String zzi(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private static boolean zzj(zzef zzef, int i, int i2, boolean z) {
        int i3;
        long j;
        int i4;
        int i5;
        zzef zzef2 = zzef;
        int i6 = i;
        int zzc = zzef.zzc();
        while (true) {
            try {
                int i7 = 1;
                if (zzef.zza() >= i2) {
                    if (i6 >= 3) {
                        i4 = zzef.zze();
                        j = zzef.zzs();
                        i3 = zzef.zzo();
                    } else {
                        i4 = zzef.zzm();
                        j = (long) zzef.zzm();
                        i3 = 0;
                    }
                    if (i4 == 0 && j == 0 && i3 == 0) {
                        zzef2.zzF(zzc);
                        return true;
                    }
                    if (i6 == 4 && !z) {
                        if ((8421504 & j) != 0) {
                            zzef2.zzF(zzc);
                            return false;
                        }
                        j = ((j >> 24) << 21) | ((255 & (j >> 16)) << 14) | (j & 255) | (((j >> 8) & 255) << 7);
                    }
                    if (i6 == 4) {
                        if ((i3 & 64) == 0) {
                            i7 = 0;
                        }
                        i5 = i3 & 1;
                    } else if (i6 == 3) {
                        int i8 = (i3 & 32) != 0 ? 1 : 0;
                        if ((i3 & 128) != 0) {
                            i7 = i8;
                            i5 = 1;
                        } else {
                            i7 = i8;
                            i5 = 0;
                        }
                    } else {
                        i5 = 0;
                        i7 = 0;
                    }
                    if (i5 != 0) {
                        i7 += 4;
                    }
                    if (j < ((long) i7)) {
                        zzef2.zzF(zzc);
                        return false;
                    } else if (((long) zzef.zza()) < j) {
                        return false;
                    } else {
                        zzef2.zzG((int) j);
                    }
                } else {
                    zzef2.zzF(zzc);
                    return true;
                }
            } finally {
                zzef2.zzF(zzc);
            }
        }
    }

    private static byte[] zzk(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return zzen.zzf;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }
}
