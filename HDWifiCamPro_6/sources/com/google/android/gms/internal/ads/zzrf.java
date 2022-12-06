package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzrf {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();
    private static int zzd = -1;

    public static int zza() throws zzqz {
        int i;
        int i2 = zzd;
        if (i2 == -1) {
            i2 = 0;
            zzqn zzc2 = zzc("video/avc", false, false);
            if (zzc2 != null) {
                MediaCodecInfo.CodecProfileLevel[] zzg = zzc2.zzg();
                int length = zzg.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = zzg[i2].level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i = 35651584;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzen.zza >= 21 ? 345600 : 172800);
            }
            zzd = i2;
        }
        return i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0399, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x039a, code lost:
        if (r4 != r1) goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x039c, code lost:
        com.google.android.gms.internal.ads.zzdw.zze("MediaCodecUtil", "Unknown AV1 level: " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x07c4, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:470:0x07c5, code lost:
        if (r4 != r1) goto L_0x07dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:471:0x07c7, code lost:
        com.google.android.gms.internal.ads.zzdw.zze("MediaCodecUtil", "Unknown AVC level: " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:479:?, code lost:
        return new android.util.Pair(java.lang.Integer.valueOf(r0), java.lang.Integer.valueOf(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:?, code lost:
        return new android.util.Pair(java.lang.Integer.valueOf(r15), java.lang.Integer.valueOf(r4));
     */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x06ce  */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x0777  */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x078c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zzb(com.google.android.gms.internal.ads.zzaf r17) {
        /*
            r0 = r17
            java.lang.String r1 = r0.zzj
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = r0.zzm
            java.lang.String r4 = "video/dolby-vision"
            boolean r3 = r4.equals(r3)
            r4 = 128(0x80, float:1.794E-43)
            r6 = 64
            r7 = 32
            r8 = 0
            r9 = 4096(0x1000, float:5.74E-42)
            r10 = 16
            r11 = 8
            r12 = 3
            r13 = 4
            r15 = 2
            java.lang.String r2 = "MediaCodecUtil"
            r5 = 1
            if (r3 == 0) goto L_0x0200
            java.lang.String r0 = r0.zzj
            int r3 = r1.length
            if (r3 >= r12) goto L_0x0041
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
        L_0x003d:
            r16 = 0
            goto L_0x01ff
        L_0x0041:
            java.util.regex.Pattern r3 = zzb
            r14 = r1[r5]
            java.util.regex.Matcher r3 = r3.matcher(r14)
            boolean r14 = r3.matches()
            if (r14 != 0) goto L_0x005d
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x003d
        L_0x005d:
            java.lang.String r0 = r3.group(r5)
            if (r0 != 0) goto L_0x0066
        L_0x0063:
            r3 = 0
            goto L_0x010f
        L_0x0066:
            int r3 = r0.hashCode()
            switch(r3) {
                case 1536: goto L_0x00cb;
                case 1537: goto L_0x00c1;
                case 1538: goto L_0x00b7;
                case 1539: goto L_0x00ad;
                case 1540: goto L_0x00a3;
                case 1541: goto L_0x0099;
                case 1542: goto L_0x008f;
                case 1543: goto L_0x0085;
                case 1544: goto L_0x007b;
                case 1545: goto L_0x006f;
                default: goto L_0x006d;
            }
        L_0x006d:
            goto L_0x00d5
        L_0x006f:
            java.lang.String r3 = "09"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = 9
            goto L_0x00d6
        L_0x007b:
            java.lang.String r3 = "08"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = r11
            goto L_0x00d6
        L_0x0085:
            java.lang.String r3 = "07"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = 7
            goto L_0x00d6
        L_0x008f:
            java.lang.String r3 = "06"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = 6
            goto L_0x00d6
        L_0x0099:
            java.lang.String r3 = "05"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = 5
            goto L_0x00d6
        L_0x00a3:
            java.lang.String r3 = "04"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = r13
            goto L_0x00d6
        L_0x00ad:
            java.lang.String r3 = "03"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = r12
            goto L_0x00d6
        L_0x00b7:
            java.lang.String r3 = "02"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = r15
            goto L_0x00d6
        L_0x00c1:
            java.lang.String r3 = "01"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = r5
            goto L_0x00d6
        L_0x00cb:
            java.lang.String r3 = "00"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            r3 = r8
            goto L_0x00d6
        L_0x00d5:
            r3 = -1
        L_0x00d6:
            switch(r3) {
                case 0: goto L_0x010b;
                case 1: goto L_0x0106;
                case 2: goto L_0x0101;
                case 3: goto L_0x00fc;
                case 4: goto L_0x00f7;
                case 5: goto L_0x00f2;
                case 6: goto L_0x00ed;
                case 7: goto L_0x00e8;
                case 8: goto L_0x00e1;
                case 9: goto L_0x00da;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            goto L_0x0063
        L_0x00da:
            r3 = 512(0x200, float:7.175E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x010f
        L_0x00e1:
            r3 = 256(0x100, float:3.59E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x010f
        L_0x00e8:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            goto L_0x010f
        L_0x00ed:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            goto L_0x010f
        L_0x00f2:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            goto L_0x010f
        L_0x00f7:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            goto L_0x010f
        L_0x00fc:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            goto L_0x010f
        L_0x0101:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            goto L_0x010f
        L_0x0106:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)
            goto L_0x010f
        L_0x010b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
        L_0x010f:
            if (r3 != 0) goto L_0x0120
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unknown Dolby Vision profile string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x003d
        L_0x0120:
            r0 = r1[r15]
            if (r0 != 0) goto L_0x0127
        L_0x0124:
            r1 = 0
            goto L_0x01e7
        L_0x0127:
            int r1 = r0.hashCode()
            switch(r1) {
                case 1537: goto L_0x01db;
                case 1538: goto L_0x01ce;
                case 1539: goto L_0x01c1;
                case 1540: goto L_0x01b4;
                case 1541: goto L_0x01a7;
                case 1542: goto L_0x019a;
                case 1543: goto L_0x018d;
                case 1544: goto L_0x0180;
                case 1545: goto L_0x0170;
                default: goto L_0x012e;
            }
        L_0x012e:
            switch(r1) {
                case 1567: goto L_0x0160;
                case 1568: goto L_0x0150;
                case 1569: goto L_0x0140;
                case 1570: goto L_0x0132;
                default: goto L_0x0131;
            }
        L_0x0131:
            goto L_0x0124
        L_0x0132:
            java.lang.String r1 = "13"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            goto L_0x01e7
        L_0x0140:
            java.lang.String r1 = "12"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            r1 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x01e7
        L_0x0150:
            java.lang.String r1 = "11"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            r1 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x01e7
        L_0x0160:
            java.lang.String r1 = "10"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            r1 = 512(0x200, float:7.175E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x01e7
        L_0x0170:
            java.lang.String r1 = "09"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            r1 = 256(0x100, float:3.59E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x01e7
        L_0x0180:
            java.lang.String r1 = "08"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x01e7
        L_0x018d:
            java.lang.String r1 = "07"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            goto L_0x01e7
        L_0x019a:
            java.lang.String r1 = "06"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            goto L_0x01e7
        L_0x01a7:
            java.lang.String r1 = "05"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            goto L_0x01e7
        L_0x01b4:
            java.lang.String r1 = "04"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x01e7
        L_0x01c1:
            java.lang.String r1 = "03"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            goto L_0x01e7
        L_0x01ce:
            java.lang.String r1 = "02"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
            goto L_0x01e7
        L_0x01db:
            java.lang.String r1 = "01"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0124
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
        L_0x01e7:
            if (r1 != 0) goto L_0x01f8
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unknown Dolby Vision level string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x003d
        L_0x01f8:
            android.util.Pair r2 = new android.util.Pair
            r2.<init>(r3, r1)
            r16 = r2
        L_0x01ff:
            return r16
        L_0x0200:
            r3 = r1[r8]
            int r14 = r3.hashCode()
            switch(r14) {
                case 3004662: goto L_0x0246;
                case 3006243: goto L_0x023c;
                case 3006244: goto L_0x0232;
                case 3199032: goto L_0x0228;
                case 3214780: goto L_0x021e;
                case 3356560: goto L_0x0214;
                case 3624515: goto L_0x020a;
                default: goto L_0x0209;
            }
        L_0x0209:
            goto L_0x0250
        L_0x020a:
            java.lang.String r14 = "vp09"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x0250
            r3 = r15
            goto L_0x0251
        L_0x0214:
            java.lang.String r14 = "mp4a"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x0250
            r3 = 6
            goto L_0x0251
        L_0x021e:
            java.lang.String r14 = "hvc1"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x0250
            r3 = r13
            goto L_0x0251
        L_0x0228:
            java.lang.String r14 = "hev1"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x0250
            r3 = r12
            goto L_0x0251
        L_0x0232:
            java.lang.String r14 = "avc2"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x0250
            r3 = r5
            goto L_0x0251
        L_0x023c:
            java.lang.String r14 = "avc1"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x0250
            r3 = r8
            goto L_0x0251
        L_0x0246:
            java.lang.String r14 = "av01"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x0250
            r3 = 5
            goto L_0x0251
        L_0x0250:
            r3 = -1
        L_0x0251:
            switch(r3) {
                case 0: goto L_0x0704;
                case 1: goto L_0x0704;
                case 2: goto L_0x0634;
                case 3: goto L_0x03d2;
                case 4: goto L_0x03d2;
                case 5: goto L_0x02e1;
                case 6: goto L_0x0256;
                default: goto L_0x0254;
            }
        L_0x0254:
            r0 = 0
            return r0
        L_0x0256:
            java.lang.String r0 = r0.zzj
            int r3 = r1.length
            if (r3 == r12) goto L_0x026c
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
        L_0x0268:
            r16 = 0
            goto L_0x02e0
        L_0x026c:
            java.lang.String r3 = "audio/mp4a-latm"
            r4 = r1[r5]     // Catch:{ NumberFormatException -> 0x02d2 }
            int r4 = java.lang.Integer.parseInt(r4, r10)     // Catch:{ NumberFormatException -> 0x02d2 }
            java.lang.String r4 = com.google.android.gms.internal.ads.zzbt.zzd(r4)     // Catch:{ NumberFormatException -> 0x02d2 }
            boolean r3 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x02d2 }
            if (r3 == 0) goto L_0x0268
            r1 = r1[r15]     // Catch:{ NumberFormatException -> 0x02d2 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x02d2 }
            r3 = 17
            if (r1 == r3) goto L_0x02bd
            r3 = 20
            if (r1 == r3) goto L_0x02ba
            r3 = 23
            if (r1 == r3) goto L_0x02b7
            r3 = 29
            if (r1 == r3) goto L_0x02b4
            r3 = 39
            if (r1 == r3) goto L_0x02b1
            r3 = 42
            if (r1 == r3) goto L_0x02ae
            switch(r1) {
                case 1: goto L_0x02ac;
                case 2: goto L_0x02ab;
                case 3: goto L_0x02a9;
                case 4: goto L_0x02a7;
                case 5: goto L_0x02a5;
                case 6: goto L_0x02a2;
                default: goto L_0x029f;
            }     // Catch:{ NumberFormatException -> 0x02d2 }
        L_0x029f:
            r1 = -1
            r5 = -1
            goto L_0x02c0
        L_0x02a2:
            r1 = -1
            r5 = 6
            goto L_0x02c0
        L_0x02a5:
            r5 = 5
            goto L_0x02ac
        L_0x02a7:
            r5 = r13
            goto L_0x02ac
        L_0x02a9:
            r5 = r12
            goto L_0x02ac
        L_0x02ab:
            r5 = r15
        L_0x02ac:
            r1 = -1
            goto L_0x02c0
        L_0x02ae:
            r5 = 42
            goto L_0x02ac
        L_0x02b1:
            r5 = 39
            goto L_0x02ac
        L_0x02b4:
            r5 = 29
            goto L_0x02ac
        L_0x02b7:
            r5 = 23
            goto L_0x02ac
        L_0x02ba:
            r5 = 20
            goto L_0x02ac
        L_0x02bd:
            r5 = 17
            goto L_0x02ac
        L_0x02c0:
            if (r5 == r1) goto L_0x0268
            android.util.Pair r1 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x02d2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ NumberFormatException -> 0x02d2 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch:{ NumberFormatException -> 0x02d2 }
            r1.<init>(r3, r4)     // Catch:{ NumberFormatException -> 0x02d2 }
            r16 = r1
            goto L_0x02e0
        L_0x02d2:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x0268
        L_0x02e0:
            return r16
        L_0x02e1:
            java.lang.String r3 = r0.zzj
            com.google.android.gms.internal.ads.zzq r0 = r0.zzy
            int r14 = r1.length
            if (r14 >= r13) goto L_0x02f9
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "Ignoring malformed AV1 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
        L_0x02f5:
            r16 = 0
            goto L_0x03d1
        L_0x02f9:
            r14 = r1[r5]     // Catch:{ NumberFormatException -> 0x03c2 }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ NumberFormatException -> 0x03c2 }
            r10 = r1[r15]     // Catch:{ NumberFormatException -> 0x03c2 }
            java.lang.String r8 = r10.substring(r8, r15)     // Catch:{ NumberFormatException -> 0x03c2 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x03c2 }
            r1 = r1[r12]     // Catch:{ NumberFormatException -> 0x03c2 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x03c2 }
            if (r14 == 0) goto L_0x0326
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown AV1 profile: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x02f5
        L_0x0326:
            if (r1 == r11) goto L_0x0353
            r3 = 10
            if (r1 == r3) goto L_0x0341
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Unknown AV1 bit depth: "
            r0.append(r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x02f5
        L_0x0341:
            if (r0 == 0) goto L_0x0351
            byte[] r1 = r0.zze
            if (r1 != 0) goto L_0x034f
            int r0 = r0.zzd
            r1 = 7
            if (r0 == r1) goto L_0x034f
            r1 = 6
            if (r0 != r1) goto L_0x0351
        L_0x034f:
            r0 = r9
            goto L_0x0354
        L_0x0351:
            r0 = r15
            goto L_0x0354
        L_0x0353:
            r0 = r5
        L_0x0354:
            switch(r8) {
                case 0: goto L_0x0398;
                case 1: goto L_0x0396;
                case 2: goto L_0x0394;
                case 3: goto L_0x0392;
                case 4: goto L_0x038e;
                case 5: goto L_0x038c;
                case 6: goto L_0x038a;
                case 7: goto L_0x0399;
                case 8: goto L_0x0387;
                case 9: goto L_0x0384;
                case 10: goto L_0x0381;
                case 11: goto L_0x037e;
                case 12: goto L_0x037c;
                case 13: goto L_0x0379;
                case 14: goto L_0x0376;
                case 15: goto L_0x0372;
                case 16: goto L_0x036f;
                case 17: goto L_0x036c;
                case 18: goto L_0x0369;
                case 19: goto L_0x0366;
                case 20: goto L_0x0363;
                case 21: goto L_0x0360;
                case 22: goto L_0x035d;
                case 23: goto L_0x035a;
                default: goto L_0x0357;
            }
        L_0x0357:
            r1 = -1
            r4 = -1
            goto L_0x039a
        L_0x035a:
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0399
        L_0x035d:
            r4 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0399
        L_0x0360:
            r4 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x0399
        L_0x0363:
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0399
        L_0x0366:
            r4 = 524288(0x80000, float:7.34684E-40)
            goto L_0x0399
        L_0x0369:
            r4 = 262144(0x40000, float:3.67342E-40)
            goto L_0x0399
        L_0x036c:
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0399
        L_0x036f:
            r4 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0399
        L_0x0372:
            r4 = 32768(0x8000, float:4.5918E-41)
            goto L_0x0399
        L_0x0376:
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0399
        L_0x0379:
            r4 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0399
        L_0x037c:
            r4 = r9
            goto L_0x0399
        L_0x037e:
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0399
        L_0x0381:
            r4 = 1024(0x400, float:1.435E-42)
            goto L_0x0399
        L_0x0384:
            r4 = 512(0x200, float:7.175E-43)
            goto L_0x0399
        L_0x0387:
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0399
        L_0x038a:
            r4 = r6
            goto L_0x0399
        L_0x038c:
            r4 = r7
            goto L_0x0399
        L_0x038e:
            r1 = -1
            r4 = 16
            goto L_0x039a
        L_0x0392:
            r4 = r11
            goto L_0x0399
        L_0x0394:
            r4 = r13
            goto L_0x0399
        L_0x0396:
            r4 = r15
            goto L_0x0399
        L_0x0398:
            r4 = r5
        L_0x0399:
            r1 = -1
        L_0x039a:
            if (r4 != r1) goto L_0x03b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown AV1 level: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x02f5
        L_0x03b2:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r2.<init>(r0, r1)
            r16 = r2
            goto L_0x03d1
        L_0x03c2:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "Ignoring malformed AV1 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x02f5
        L_0x03d1:
            return r16
        L_0x03d2:
            java.lang.String r0 = r0.zzj
            int r3 = r1.length
            if (r3 >= r13) goto L_0x03e8
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed HEVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
        L_0x03e4:
            r16 = 0
            goto L_0x0633
        L_0x03e8:
            java.util.regex.Pattern r3 = zzb
            r10 = r1[r5]
            java.util.regex.Matcher r3 = r3.matcher(r10)
            boolean r10 = r3.matches()
            if (r10 != 0) goto L_0x0404
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed HEVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x03e4
        L_0x0404:
            java.lang.String r0 = r3.group(r5)
            java.lang.String r3 = "1"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0412
            r0 = r5
            goto L_0x041b
        L_0x0412:
            java.lang.String r3 = "2"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0624
            r0 = r15
        L_0x041b:
            r1 = r1[r12]
            if (r1 != 0) goto L_0x0422
        L_0x041f:
            r3 = 0
            goto L_0x0607
        L_0x0422:
            int r3 = r1.hashCode()
            switch(r3) {
                case 70821: goto L_0x0546;
                case 70914: goto L_0x053b;
                case 70917: goto L_0x0530;
                case 71007: goto L_0x0525;
                case 71010: goto L_0x051a;
                case 74665: goto L_0x0510;
                case 74758: goto L_0x0506;
                case 74761: goto L_0x04fc;
                case 74851: goto L_0x04f2;
                case 74854: goto L_0x04e7;
                case 2193639: goto L_0x04db;
                case 2193642: goto L_0x04cf;
                case 2193732: goto L_0x04c3;
                case 2193735: goto L_0x04b7;
                case 2193738: goto L_0x04ab;
                case 2193825: goto L_0x049f;
                case 2193828: goto L_0x0493;
                case 2193831: goto L_0x0487;
                case 2312803: goto L_0x047c;
                case 2312806: goto L_0x0471;
                case 2312896: goto L_0x0466;
                case 2312899: goto L_0x045b;
                case 2312902: goto L_0x044f;
                case 2312989: goto L_0x0443;
                case 2312992: goto L_0x0437;
                case 2312995: goto L_0x042b;
                default: goto L_0x0429;
            }
        L_0x0429:
            goto L_0x0551
        L_0x042b:
            java.lang.String r3 = "L186"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 12
            goto L_0x0552
        L_0x0437:
            java.lang.String r3 = "L183"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 11
            goto L_0x0552
        L_0x0443:
            java.lang.String r3 = "L180"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 10
            goto L_0x0552
        L_0x044f:
            java.lang.String r3 = "L156"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 9
            goto L_0x0552
        L_0x045b:
            java.lang.String r3 = "L153"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = r11
            goto L_0x0552
        L_0x0466:
            java.lang.String r3 = "L150"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 7
            goto L_0x0552
        L_0x0471:
            java.lang.String r3 = "L123"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 6
            goto L_0x0552
        L_0x047c:
            java.lang.String r3 = "L120"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 5
            goto L_0x0552
        L_0x0487:
            java.lang.String r3 = "H186"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 25
            goto L_0x0552
        L_0x0493:
            java.lang.String r3 = "H183"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 24
            goto L_0x0552
        L_0x049f:
            java.lang.String r3 = "H180"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 23
            goto L_0x0552
        L_0x04ab:
            java.lang.String r3 = "H156"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 22
            goto L_0x0552
        L_0x04b7:
            java.lang.String r3 = "H153"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 21
            goto L_0x0552
        L_0x04c3:
            java.lang.String r3 = "H150"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 20
            goto L_0x0552
        L_0x04cf:
            java.lang.String r3 = "H123"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 19
            goto L_0x0552
        L_0x04db:
            java.lang.String r3 = "H120"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 18
            goto L_0x0552
        L_0x04e7:
            java.lang.String r3 = "L93"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = r13
            goto L_0x0552
        L_0x04f2:
            java.lang.String r3 = "L90"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = r12
            goto L_0x0552
        L_0x04fc:
            java.lang.String r3 = "L63"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = r15
            goto L_0x0552
        L_0x0506:
            java.lang.String r3 = "L60"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = r5
            goto L_0x0552
        L_0x0510:
            java.lang.String r3 = "L30"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = r8
            goto L_0x0552
        L_0x051a:
            java.lang.String r3 = "H93"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 17
            goto L_0x0552
        L_0x0525:
            java.lang.String r3 = "H90"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 16
            goto L_0x0552
        L_0x0530:
            java.lang.String r3 = "H63"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 15
            goto L_0x0552
        L_0x053b:
            java.lang.String r3 = "H60"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 14
            goto L_0x0552
        L_0x0546:
            java.lang.String r3 = "H30"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0551
            r3 = 13
            goto L_0x0552
        L_0x0551:
            r3 = -1
        L_0x0552:
            switch(r3) {
                case 0: goto L_0x0603;
                case 1: goto L_0x05fe;
                case 2: goto L_0x05f7;
                case 3: goto L_0x05f2;
                case 4: goto L_0x05eb;
                case 5: goto L_0x05e4;
                case 6: goto L_0x05df;
                case 7: goto L_0x05d8;
                case 8: goto L_0x05d1;
                case 9: goto L_0x05ca;
                case 10: goto L_0x05c3;
                case 11: goto L_0x05bc;
                case 12: goto L_0x05b5;
                case 13: goto L_0x05b0;
                case 14: goto L_0x05ab;
                case 15: goto L_0x05a6;
                case 16: goto L_0x05a0;
                case 17: goto L_0x0598;
                case 18: goto L_0x0590;
                case 19: goto L_0x0588;
                case 20: goto L_0x057f;
                case 21: goto L_0x0577;
                case 22: goto L_0x056f;
                case 23: goto L_0x0567;
                case 24: goto L_0x055f;
                case 25: goto L_0x0557;
                default: goto L_0x0555;
            }
        L_0x0555:
            goto L_0x041f
        L_0x0557:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x055f:
            r3 = 8388608(0x800000, float:1.17549435E-38)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x0567:
            r3 = 2097152(0x200000, float:2.938736E-39)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x056f:
            r3 = 524288(0x80000, float:7.34684E-40)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x0577:
            r3 = 131072(0x20000, float:1.83671E-40)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x057f:
            r3 = 32768(0x8000, float:4.5918E-41)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x0588:
            r3 = 8192(0x2000, float:1.14794E-41)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x0590:
            r3 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x0598:
            r3 = 512(0x200, float:7.175E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05a0:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            goto L_0x0607
        L_0x05a6:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            goto L_0x0607
        L_0x05ab:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            goto L_0x0607
        L_0x05b0:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)
            goto L_0x0607
        L_0x05b5:
            r3 = 16777216(0x1000000, float:2.3509887E-38)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05bc:
            r3 = 4194304(0x400000, float:5.877472E-39)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05c3:
            r3 = 1048576(0x100000, float:1.469368E-39)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05ca:
            r3 = 262144(0x40000, float:3.67342E-40)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05d1:
            r3 = 65536(0x10000, float:9.18355E-41)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05d8:
            r3 = 16384(0x4000, float:2.2959E-41)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05df:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            goto L_0x0607
        L_0x05e4:
            r3 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05eb:
            r3 = 256(0x100, float:3.59E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05f2:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            goto L_0x0607
        L_0x05f7:
            r3 = 16
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0607
        L_0x05fe:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            goto L_0x0607
        L_0x0603:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
        L_0x0607:
            if (r3 != 0) goto L_0x0618
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "Unknown HEVC level string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x03e4
        L_0x0618:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.<init>(r0, r3)
            r16 = r2
            goto L_0x0633
        L_0x0624:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unknown HEVC profile string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x03e4
        L_0x0633:
            return r16
        L_0x0634:
            java.lang.String r0 = r0.zzj
            int r3 = r1.length
            if (r3 >= r12) goto L_0x064a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
        L_0x0646:
            r16 = 0
            goto L_0x0703
        L_0x064a:
            r3 = r1[r5]     // Catch:{ NumberFormatException -> 0x06f4 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x06f4 }
            r1 = r1[r15]     // Catch:{ NumberFormatException -> 0x06f4 }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x06f4 }
            if (r3 == 0) goto L_0x0667
            if (r3 == r5) goto L_0x0665
            if (r3 == r15) goto L_0x0663
            if (r3 == r12) goto L_0x0661
            r1 = -1
        L_0x065f:
            r8 = -1
            goto L_0x0669
        L_0x0661:
            r1 = r11
            goto L_0x065f
        L_0x0663:
            r1 = r13
            goto L_0x065f
        L_0x0665:
            r1 = r15
            goto L_0x065f
        L_0x0667:
            r1 = r5
            goto L_0x065f
        L_0x0669:
            if (r1 != r8) goto L_0x0680
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown VP9 profile: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x0646
        L_0x0680:
            r3 = 10
            if (r0 == r3) goto L_0x06ca
            r3 = 11
            if (r0 == r3) goto L_0x06c8
            r3 = 20
            if (r0 == r3) goto L_0x06c6
            r3 = 21
            if (r0 == r3) goto L_0x06c4
            r3 = 30
            if (r0 == r3) goto L_0x06c0
            r3 = 31
            if (r0 == r3) goto L_0x06be
            r3 = 40
            if (r0 == r3) goto L_0x06bc
            r3 = 41
            if (r0 == r3) goto L_0x06cb
            r3 = 50
            if (r0 == r3) goto L_0x06b9
            r3 = 51
            if (r0 == r3) goto L_0x06b6
            switch(r0) {
                case 60: goto L_0x06b3;
                case 61: goto L_0x06b1;
                case 62: goto L_0x06ae;
                default: goto L_0x06ab;
            }
        L_0x06ab:
            r3 = -1
            r4 = -1
            goto L_0x06cc
        L_0x06ae:
            r4 = 8192(0x2000, float:1.14794E-41)
            goto L_0x06cb
        L_0x06b1:
            r4 = r9
            goto L_0x06cb
        L_0x06b3:
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x06cb
        L_0x06b6:
            r4 = 512(0x200, float:7.175E-43)
            goto L_0x06cb
        L_0x06b9:
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x06cb
        L_0x06bc:
            r4 = r6
            goto L_0x06cb
        L_0x06be:
            r4 = r7
            goto L_0x06cb
        L_0x06c0:
            r3 = -1
            r4 = 16
            goto L_0x06cc
        L_0x06c4:
            r4 = r11
            goto L_0x06cb
        L_0x06c6:
            r4 = r13
            goto L_0x06cb
        L_0x06c8:
            r4 = r15
            goto L_0x06cb
        L_0x06ca:
            r4 = r5
        L_0x06cb:
            r3 = -1
        L_0x06cc:
            if (r4 != r3) goto L_0x06e4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Unknown VP9 level: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x0646
        L_0x06e4:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r2.<init>(r0, r1)
            r16 = r2
            goto L_0x0703
        L_0x06f4:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x0646
        L_0x0703:
            return r16
        L_0x0704:
            java.lang.String r0 = r0.zzj
            int r3 = r1.length
            if (r3 >= r15) goto L_0x071a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed AVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
        L_0x0716:
            r16 = 0
            goto L_0x0812
        L_0x071a:
            r10 = r1[r5]     // Catch:{ NumberFormatException -> 0x0803 }
            int r10 = r10.length()     // Catch:{ NumberFormatException -> 0x0803 }
            r14 = 6
            if (r10 != r14) goto L_0x073a
            r3 = r1[r5]     // Catch:{ NumberFormatException -> 0x0803 }
            java.lang.String r3 = r3.substring(r8, r15)     // Catch:{ NumberFormatException -> 0x0803 }
            r8 = 16
            int r3 = java.lang.Integer.parseInt(r3, r8)     // Catch:{ NumberFormatException -> 0x0803 }
            r1 = r1[r5]     // Catch:{ NumberFormatException -> 0x0803 }
            java.lang.String r1 = r1.substring(r13)     // Catch:{ NumberFormatException -> 0x0803 }
            int r0 = java.lang.Integer.parseInt(r1, r8)     // Catch:{ NumberFormatException -> 0x0803 }
            goto L_0x074a
        L_0x073a:
            r8 = 16
            if (r3 < r12) goto L_0x07ed
            r3 = r1[r5]     // Catch:{ NumberFormatException -> 0x0803 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0803 }
            r1 = r1[r15]     // Catch:{ NumberFormatException -> 0x0803 }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0803 }
        L_0x074a:
            r1 = 66
            if (r3 == r1) goto L_0x0773
            r1 = 77
            if (r3 == r1) goto L_0x0774
            r1 = 88
            if (r3 == r1) goto L_0x0771
            r1 = 100
            if (r3 == r1) goto L_0x076f
            r1 = 110(0x6e, float:1.54E-43)
            if (r3 == r1) goto L_0x076d
            r1 = 122(0x7a, float:1.71E-43)
            if (r3 == r1) goto L_0x076b
            r1 = 244(0xf4, float:3.42E-43)
            if (r3 == r1) goto L_0x0769
            r1 = -1
            r15 = -1
            goto L_0x0775
        L_0x0769:
            r15 = r6
            goto L_0x0774
        L_0x076b:
            r15 = r7
            goto L_0x0774
        L_0x076d:
            r15 = r8
            goto L_0x0774
        L_0x076f:
            r15 = r11
            goto L_0x0774
        L_0x0771:
            r15 = r13
            goto L_0x0774
        L_0x0773:
            r15 = r5
        L_0x0774:
            r1 = -1
        L_0x0775:
            if (r15 != r1) goto L_0x078c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown AVC profile: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x0716
        L_0x078c:
            switch(r0) {
                case 10: goto L_0x07c3;
                case 11: goto L_0x07c1;
                case 12: goto L_0x07bf;
                case 13: goto L_0x07bd;
                default: goto L_0x078f;
            }
        L_0x078f:
            switch(r0) {
                case 20: goto L_0x07bb;
                case 21: goto L_0x07b9;
                case 22: goto L_0x07c4;
                default: goto L_0x0792;
            }
        L_0x0792:
            switch(r0) {
                case 30: goto L_0x07b6;
                case 31: goto L_0x07b3;
                case 32: goto L_0x07b0;
                default: goto L_0x0795;
            }
        L_0x0795:
            switch(r0) {
                case 40: goto L_0x07ad;
                case 41: goto L_0x07ab;
                case 42: goto L_0x07a8;
                default: goto L_0x0798;
            }
        L_0x0798:
            switch(r0) {
                case 50: goto L_0x07a5;
                case 51: goto L_0x07a1;
                case 52: goto L_0x079e;
                default: goto L_0x079b;
            }
        L_0x079b:
            r1 = -1
            r4 = -1
            goto L_0x07c5
        L_0x079e:
            r4 = 65536(0x10000, float:9.18355E-41)
            goto L_0x07c4
        L_0x07a1:
            r4 = 32768(0x8000, float:4.5918E-41)
            goto L_0x07c4
        L_0x07a5:
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x07c4
        L_0x07a8:
            r4 = 8192(0x2000, float:1.14794E-41)
            goto L_0x07c4
        L_0x07ab:
            r4 = r9
            goto L_0x07c4
        L_0x07ad:
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x07c4
        L_0x07b0:
            r4 = 1024(0x400, float:1.435E-42)
            goto L_0x07c4
        L_0x07b3:
            r4 = 512(0x200, float:7.175E-43)
            goto L_0x07c4
        L_0x07b6:
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x07c4
        L_0x07b9:
            r4 = r6
            goto L_0x07c4
        L_0x07bb:
            r4 = r7
            goto L_0x07c4
        L_0x07bd:
            r4 = r8
            goto L_0x07c4
        L_0x07bf:
            r4 = r11
            goto L_0x07c4
        L_0x07c1:
            r4 = r13
            goto L_0x07c4
        L_0x07c3:
            r4 = r5
        L_0x07c4:
            r1 = -1
        L_0x07c5:
            if (r4 != r1) goto L_0x07dd
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Unknown AVC level: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x0716
        L_0x07dd:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r2.<init>(r0, r1)
            r16 = r2
            goto L_0x0812
        L_0x07ed:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0803 }
            r1.<init>()     // Catch:{ NumberFormatException -> 0x0803 }
            java.lang.String r3 = "Ignoring malformed AVC codec string: "
            r1.append(r3)     // Catch:{ NumberFormatException -> 0x0803 }
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x0803 }
            java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x0803 }
            com.google.android.gms.internal.ads.zzdw.zze(r2, r1)     // Catch:{ NumberFormatException -> 0x0803 }
            goto L_0x0716
        L_0x0803:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed AVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r2, r0)
            goto L_0x0716
        L_0x0812:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrf.zzb(com.google.android.gms.internal.ads.zzaf):android.util.Pair");
    }

    public static zzqn zzc(String str, boolean z, boolean z2) throws zzqz {
        List zzf = zzf(str, false, false);
        if (zzf.isEmpty()) {
            return null;
        }
        return (zzqn) zzf.get(0);
    }

    public static zzqn zzd() throws zzqz {
        return zzc(MimeTypes.AUDIO_RAW, false, false);
    }

    public static String zze(zzaf zzaf) {
        Pair zzb2;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(zzaf.zzm)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (!"video/dolby-vision".equals(zzaf.zzm) || (zzb2 = zzb(zzaf)) == null) {
            return null;
        }
        int intValue = ((Integer) zzb2.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static synchronized List zzf(String str, boolean z, boolean z2) throws zzqz {
        zzra zzra;
        int i;
        String str2 = str;
        boolean z3 = z;
        boolean z4 = z2;
        synchronized (zzrf.class) {
            zzqx zzqx = new zzqx(str2, z3, z4);
            List list = (List) zzc.get(zzqx);
            if (list != null) {
                return list;
            }
            if (zzen.zza >= 21) {
                zzra = new zzrd(z3, z4);
            } else {
                zzra = new zzrc((zzrb) null);
            }
            ArrayList zzh = zzh(zzqx, zzra);
            if (z3 && zzh.isEmpty() && (i = zzen.zza) >= 21 && i <= 23) {
                zzh = zzh(zzqx, new zzrc((zzrb) null));
                if (!zzh.isEmpty()) {
                    String str3 = ((zzqn) zzh.get(0)).zza;
                    zzdw.zze("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str2 + ". Assuming: " + str3);
                }
            }
            if (MimeTypes.AUDIO_RAW.equals(str2)) {
                if (zzen.zza < 26 && zzen.zzb.equals("R9") && zzh.size() == 1 && ((zzqn) zzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzh.add(zzqn.zzc("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
                }
                zzi(zzh, zzqv.zza);
            }
            if (zzen.zza < 21 && zzh.size() > 1) {
                String str4 = ((zzqn) zzh.get(0)).zza;
                if ("OMX.SEC.mp3.dec".equals(str4) || "OMX.SEC.MP3.Decoder".equals(str4) || "OMX.brcm.audio.mp3.decoder".equals(str4)) {
                    zzi(zzh, zzqw.zza);
                }
            }
            if (zzen.zza < 32 && zzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzqn) zzh.get(0)).zza)) {
                zzh.add((zzqn) zzh.remove(0));
            }
            zzfvn zzm = zzfvn.zzm(zzh);
            zzc.put(zzqx, zzm);
            return zzm;
        }
    }

    public static List zzg(List list, zzaf zzaf) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zzqt(zzaf));
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0255, code lost:
        if (r2 != r8) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x025b, code lost:
        if (r1.zzb == false) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x025d, code lost:
        r22 = r12;
        r18 = r13;
        r20 = r14;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (r12.endsWith(".secure") == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r6.add(com.google.android.gms.internal.ads.zzqn.zzc(r12, r15, r5, r10, r11, r21, r0, false, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0279, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x027a, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0094, code lost:
        if ("OMX.Exynos.AAC.Decoder".equals(r12) == false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ec, code lost:
        if ("SCV31".equals(com.google.android.gms.internal.ads.zzen.zzb) == false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0134, code lost:
        if (com.google.android.gms.internal.ads.zzen.zzb.startsWith("t0") != false) goto L_0x002d;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x02c8 A[SYNTHETIC, Splitter:B:186:0x02c8] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x02e8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zzqx r23, com.google.android.gms.internal.ads.zzra r24) throws com.google.android.gms.internal.ads.zzqz {
        /*
            r1 = r23
            r2 = r24
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0316 }
            r6.<init>()     // Catch:{ Exception -> 0x0316 }
            java.lang.String r15 = r1.zza     // Catch:{ Exception -> 0x0316 }
            int r14 = r24.zza()     // Catch:{ Exception -> 0x0316 }
            boolean r16 = r24.zze()     // Catch:{ Exception -> 0x0316 }
            r17 = 0
            r13 = r17
        L_0x001b:
            if (r13 >= r14) goto L_0x0315
            android.media.MediaCodecInfo r0 = r2.zzb(r13)     // Catch:{ Exception -> 0x0316 }
            int r7 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0316 }
            r8 = 29
            if (r7 < r8) goto L_0x0034
            boolean r7 = r0.isAlias()     // Catch:{ Exception -> 0x0316 }
            if (r7 == 0) goto L_0x0034
        L_0x002d:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x030a
        L_0x0034:
            java.lang.String r12 = r0.getName()     // Catch:{ Exception -> 0x0316 }
            boolean r7 = r0.isEncoder()     // Catch:{ Exception -> 0x0316 }
            if (r7 != 0) goto L_0x002d
            java.lang.String r7 = ".secure"
            if (r16 != 0) goto L_0x0048
            boolean r9 = r12.endsWith(r7)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
        L_0x0048:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0316 }
            r10 = 21
            if (r9 >= r10) goto L_0x007e
            java.lang.String r9 = "CIPAACDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "CIPMP3Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "CIPVorbisDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "CIPAMRNBDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "AACDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "MP3Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
        L_0x007e:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0316 }
            r10 = 24
            java.lang.String r11 = "samsung"
            if (r9 >= r10) goto L_0x00ee
            java.lang.String r9 = "OMX.SEC.aac.dec"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x0096
            java.lang.String r9 = "OMX.Exynos.AAC.Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r9 == 0) goto L_0x00ee
        L_0x0096:
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzc     // Catch:{ Exception -> 0x0316 }
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x0316 }
            if (r9 == 0) goto L_0x00ee
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            java.lang.String r10 = "zeroflte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            java.lang.String r10 = "zerolte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            java.lang.String r10 = "zenlte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "SC-05G"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "marinelteatt"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "404SC"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "SC-04G"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = "SCV31"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
        L_0x00ee:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0316 }
            java.lang.String r10 = "jflte"
            r5 = 19
            if (r9 > r5) goto L_0x0136
            java.lang.String r9 = "OMX.SEC.vp8.dec"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r9 == 0) goto L_0x0136
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzc     // Catch:{ Exception -> 0x0316 }
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x0316 }
            if (r9 == 0) goto L_0x0136
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            java.lang.String r11 = "d2"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            java.lang.String r11 = "serrano"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            java.lang.String r11 = "santos"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            java.lang.String r11 = "t0"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x0316 }
            if (r9 != 0) goto L_0x002d
        L_0x0136:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0316 }
            if (r9 > r5) goto L_0x014a
            java.lang.String r5 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0316 }
            boolean r5 = r5.startsWith(r10)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x014a
            java.lang.String r5 = "OMX.qcom.video.decoder.vp8"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r5 != 0) goto L_0x002d
        L_0x014a:
            int r5 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0316 }
            r11 = 23
            if (r5 > r11) goto L_0x0160
            java.lang.String r5 = "audio/eac3-joc"
            boolean r5 = r5.equals(r15)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x0160
            java.lang.String r5 = "OMX.MTK.AUDIO.DECODER.DSPAC3"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r5 != 0) goto L_0x002d
        L_0x0160:
            java.lang.String[] r5 = r0.getSupportedTypes()     // Catch:{ Exception -> 0x0316 }
            int r9 = r5.length     // Catch:{ Exception -> 0x0316 }
            r10 = r17
        L_0x0167:
            if (r10 >= r9) goto L_0x0178
            r11 = r5[r10]     // Catch:{ Exception -> 0x0316 }
            boolean r19 = r11.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x0316 }
            if (r19 == 0) goto L_0x0173
            r5 = r11
            goto L_0x01d8
        L_0x0173:
            int r10 = r10 + 1
            r11 = 23
            goto L_0x0167
        L_0x0178:
            java.lang.String r5 = "video/dolby-vision"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x019e
            java.lang.String r5 = "OMX.MS.HEVCDV.Decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x018b
            java.lang.String r5 = "video/hevcdv"
            goto L_0x01d8
        L_0x018b:
            java.lang.String r5 = "OMX.RTK.video.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r5 != 0) goto L_0x019b
            java.lang.String r5 = "OMX.realtek.video.decoder.tunneled"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x01d7
        L_0x019b:
            java.lang.String r5 = "video/dv_hevc"
            goto L_0x01d8
        L_0x019e:
            java.lang.String r5 = "audio/alac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x01b1
            java.lang.String r5 = "OMX.lge.alac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x01b1
            java.lang.String r5 = "audio/x-lg-alac"
            goto L_0x01d8
        L_0x01b1:
            java.lang.String r5 = "audio/flac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x01c4
            java.lang.String r5 = "OMX.lge.flac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x01c4
            java.lang.String r5 = "audio/x-lg-flac"
            goto L_0x01d8
        L_0x01c4:
            java.lang.String r5 = "audio/ac3"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x01d7
            java.lang.String r5 = "OMX.lge.ac3.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x0316 }
            if (r5 == 0) goto L_0x01d7
            java.lang.String r5 = "audio/lg-ac3"
            goto L_0x01d8
        L_0x01d7:
            r5 = 0
        L_0x01d8:
            if (r5 == 0) goto L_0x002d
            android.media.MediaCodecInfo$CodecCapabilities r10 = r0.getCapabilitiesForType(r5)     // Catch:{ Exception -> 0x02b9 }
            boolean r9 = r2.zzd(r4, r5, r10)     // Catch:{ Exception -> 0x02b9 }
            boolean r11 = r2.zzc(r4, r5, r10)     // Catch:{ Exception -> 0x02b9 }
            boolean r8 = r1.zzc     // Catch:{ Exception -> 0x02b9 }
            if (r8 != 0) goto L_0x01ed
            if (r11 != 0) goto L_0x002d
            goto L_0x01f1
        L_0x01ed:
            if (r9 != 0) goto L_0x01f1
            goto L_0x002d
        L_0x01f1:
            boolean r8 = r2.zzd(r3, r5, r10)     // Catch:{ Exception -> 0x02b9 }
            boolean r9 = r2.zzc(r3, r5, r10)     // Catch:{ Exception -> 0x02b9 }
            boolean r11 = r1.zzb     // Catch:{ Exception -> 0x02b9 }
            r20 = 1
            if (r11 != 0) goto L_0x0202
            if (r9 != 0) goto L_0x002d
            goto L_0x0206
        L_0x0202:
            if (r8 == 0) goto L_0x002d
            r8 = r20
        L_0x0206:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x02b9 }
            r11 = 29
            if (r9 < r11) goto L_0x0212
            boolean r9 = r0.isHardwareAccelerated()     // Catch:{ Exception -> 0x02b9 }
            r11 = r9
            goto L_0x021d
        L_0x0212:
            boolean r9 = zzj(r0, r15)     // Catch:{ Exception -> 0x02b9 }
            if (r9 != 0) goto L_0x021b
            r11 = r20
            goto L_0x021d
        L_0x021b:
            r11 = r17
        L_0x021d:
            boolean r21 = zzj(r0, r15)     // Catch:{ Exception -> 0x02b9 }
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x02b9 }
            r2 = 29
            if (r9 < r2) goto L_0x022c
            boolean r0 = r0.isVendor()     // Catch:{ Exception -> 0x02b9 }
            goto L_0x0251
        L_0x022c:
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x02b9 }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfse.zza(r0)     // Catch:{ Exception -> 0x02b9 }
            java.lang.String r2 = "omx.google."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x02b9 }
            if (r2 != 0) goto L_0x024f
            java.lang.String r2 = "c2.android."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x02b9 }
            if (r2 != 0) goto L_0x024f
            java.lang.String r2 = "c2.google."
            boolean r0 = r0.startsWith(r2)     // Catch:{ Exception -> 0x02b9 }
            if (r0 != 0) goto L_0x024f
            r0 = r20
            goto L_0x0251
        L_0x024f:
            r0 = r17
        L_0x0251:
            if (r16 == 0) goto L_0x0257
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x02b9 }
            if (r2 == r8) goto L_0x025d
        L_0x0257:
            if (r16 != 0) goto L_0x0285
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x027d }
            if (r2 != 0) goto L_0x0285
        L_0x025d:
            r2 = 0
            r19 = 0
            r7 = r12
            r8 = r15
            r9 = r5
            r22 = r12
            r12 = r21
            r18 = r13
            r13 = r0
            r20 = r14
            r14 = r2
            r2 = r15
            r15 = r19
            com.google.android.gms.internal.ads.zzqn r0 = com.google.android.gms.internal.ads.zzqn.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0279 }
            r6.add(r0)     // Catch:{ Exception -> 0x0279 }
            goto L_0x030a
        L_0x0279:
            r0 = move-exception
            r1 = r22
            goto L_0x02c0
        L_0x027d:
            r0 = move-exception
            r18 = r13
            r20 = r14
            r2 = r15
            r1 = r12
            goto L_0x02c0
        L_0x0285:
            r22 = r12
            r18 = r13
            r20 = r14
            r2 = r15
            if (r16 != 0) goto L_0x030a
            if (r8 == 0) goto L_0x030a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0279 }
            r8.<init>()     // Catch:{ Exception -> 0x0279 }
            r15 = r22
            r8.append(r15)     // Catch:{ Exception -> 0x02b6 }
            r8.append(r7)     // Catch:{ Exception -> 0x02b6 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x02b6 }
            r14 = 0
            r19 = 1
            r8 = r2
            r9 = r5
            r12 = r21
            r13 = r0
            r1 = r15
            r15 = r19
            com.google.android.gms.internal.ads.zzqn r0 = com.google.android.gms.internal.ads.zzqn.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x02b4 }
            r6.add(r0)     // Catch:{ Exception -> 0x02b4 }
            return r6
        L_0x02b4:
            r0 = move-exception
            goto L_0x02c0
        L_0x02b6:
            r0 = move-exception
            r1 = r15
            goto L_0x02c0
        L_0x02b9:
            r0 = move-exception
            r1 = r12
            r18 = r13
            r20 = r14
            r2 = r15
        L_0x02c0:
            int r7 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0316 }
            java.lang.String r8 = "MediaCodecUtil"
            r9 = 23
            if (r7 > r9) goto L_0x02e8
            boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x0316 }
            if (r7 != 0) goto L_0x02e8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0316 }
            r0.<init>()     // Catch:{ Exception -> 0x0316 }
            java.lang.String r5 = "Skipping codec "
            r0.append(r5)     // Catch:{ Exception -> 0x0316 }
            r0.append(r1)     // Catch:{ Exception -> 0x0316 }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x0316 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0316 }
            com.google.android.gms.internal.ads.zzdw.zzb(r8, r0)     // Catch:{ Exception -> 0x0316 }
            goto L_0x030a
        L_0x02e8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0316 }
            r2.<init>()     // Catch:{ Exception -> 0x0316 }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x0316 }
            r2.append(r1)     // Catch:{ Exception -> 0x0316 }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x0316 }
            r2.append(r5)     // Catch:{ Exception -> 0x0316 }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x0316 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0316 }
            com.google.android.gms.internal.ads.zzdw.zzb(r8, r1)     // Catch:{ Exception -> 0x0316 }
            throw r0     // Catch:{ Exception -> 0x0316 }
        L_0x030a:
            int r13 = r18 + 1
            r1 = r23
            r15 = r2
            r14 = r20
            r2 = r24
            goto L_0x001b
        L_0x0315:
            return r6
        L_0x0316:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzqz r1 = new com.google.android.gms.internal.ads.zzqz
            r2 = 0
            r1.<init>(r0, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrf.zzh(com.google.android.gms.internal.ads.zzqx, com.google.android.gms.internal.ads.zzra):java.util.ArrayList");
    }

    private static void zzi(List list, zzre zzre) {
        Collections.sort(list, new zzqu(zzre));
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzen.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzbt.zzg(str)) {
            return true;
        }
        String zza2 = zzfse.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.")) {
            return true;
        }
        if (zza2.startsWith("omx.")) {
            return false;
        }
        if (!zza2.startsWith("c2.")) {
            return true;
        }
        return false;
    }
}
