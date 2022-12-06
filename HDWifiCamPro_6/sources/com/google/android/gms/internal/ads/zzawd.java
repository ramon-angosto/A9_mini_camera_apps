package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzawd {
    private static final int zza = zzbar.zzg("vide");
    private static final int zzb = zzbar.zzg("soun");
    private static final int zzc = zzbar.zzg(MimeTypes.BASE_TYPE_TEXT);
    private static final int zzd = zzbar.zzg("sbtl");
    private static final int zze = zzbar.zzg("subt");
    private static final int zzf = zzbar.zzg("clcp");
    private static final int zzg = zzbar.zzg(C.CENC_TYPE_cenc);
    private static final int zzh = zzbar.zzg("meta");

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v15, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r11v16, types: [java.util.List] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x053d: MOVE  (r0v22 java.lang.String) = (r39v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0541  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0597  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x07cf  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x0822  */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x082b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x082c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01af  */
    public static com.google.android.gms.internal.ads.zzawo zza(com.google.android.gms.internal.ads.zzavu r47, com.google.android.gms.internal.ads.zzavv r48, long r49, com.google.android.gms.internal.ads.zzauv r51, boolean r52) throws com.google.android.gms.internal.ads.zzasz {
        /*
            r0 = r47
            r15 = r51
            int r1 = com.google.android.gms.internal.ads.zzavw.zzH
            com.google.android.gms.internal.ads.zzavu r1 = r0.zza(r1)
            int r2 = com.google.android.gms.internal.ads.zzavw.zzV
            com.google.android.gms.internal.ads.zzavv r2 = r1.zzb(r2)
            com.google.android.gms.internal.ads.zzbak r2 = r2.zza
            r14 = 16
            r2.zzv(r14)
            int r2 = r2.zze()
            int r3 = zzb
            r4 = 4
            r11 = -1
            if (r2 != r3) goto L_0x0023
            r10 = 1
            goto L_0x0043
        L_0x0023:
            int r3 = zza
            if (r2 != r3) goto L_0x0029
            r10 = 2
            goto L_0x0043
        L_0x0029:
            int r3 = zzc
            if (r2 == r3) goto L_0x0042
            int r3 = zzd
            if (r2 == r3) goto L_0x0042
            int r3 = zze
            if (r2 == r3) goto L_0x0042
            int r3 = zzf
            if (r2 != r3) goto L_0x003a
            goto L_0x0042
        L_0x003a:
            int r3 = zzh
            if (r2 != r3) goto L_0x0040
            r10 = r4
            goto L_0x0043
        L_0x0040:
            r10 = r11
            goto L_0x0043
        L_0x0042:
            r10 = 3
        L_0x0043:
            r8 = 0
            if (r10 != r11) goto L_0x0047
            return r8
        L_0x0047:
            int r2 = com.google.android.gms.internal.ads.zzavw.zzR
            com.google.android.gms.internal.ads.zzavv r2 = r0.zzb(r2)
            com.google.android.gms.internal.ads.zzbak r2 = r2.zza
            r7 = 8
            r2.zzv(r7)
            int r3 = r2.zze()
            int r3 = com.google.android.gms.internal.ads.zzavw.zzf(r3)
            if (r3 != 0) goto L_0x0060
            r5 = r7
            goto L_0x0061
        L_0x0060:
            r5 = r14
        L_0x0061:
            r2.zzw(r5)
            int r5 = r2.zze()
            r2.zzw(r4)
            int r6 = r2.zzc()
            if (r3 != 0) goto L_0x0073
            r12 = r4
            goto L_0x0074
        L_0x0073:
            r12 = r7
        L_0x0074:
            r9 = 0
        L_0x0075:
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r9 >= r12) goto L_0x0099
            byte[] r13 = r2.zza
            int r22 = r6 + r9
            byte r13 = r13[r22]
            if (r13 == r11) goto L_0x0096
            if (r3 != 0) goto L_0x008b
            long r12 = r2.zzm()
            goto L_0x008f
        L_0x008b:
            long r12 = r2.zzn()
        L_0x008f:
            r22 = 0
            int r3 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x009e
            goto L_0x009c
        L_0x0096:
            int r9 = r9 + 1
            goto L_0x0075
        L_0x0099:
            r2.zzw(r12)
        L_0x009c:
            r12 = r19
        L_0x009e:
            r2.zzw(r14)
            int r3 = r2.zze()
            int r6 = r2.zze()
            r2.zzw(r4)
            int r9 = r2.zze()
            int r2 = r2.zze()
            r4 = 65536(0x10000, float:9.18355E-41)
            r14 = -65536(0xffffffffffff0000, float:NaN)
            if (r3 != 0) goto L_0x00c8
            if (r6 != r4) goto L_0x00c7
            if (r9 != r14) goto L_0x00c6
            if (r2 != 0) goto L_0x00c3
            r2 = 90
            goto L_0x00e2
        L_0x00c3:
            r6 = r4
            r9 = r14
            goto L_0x00c7
        L_0x00c6:
            r6 = r4
        L_0x00c7:
            r3 = 0
        L_0x00c8:
            if (r3 != 0) goto L_0x00d6
            if (r6 != r14) goto L_0x00d5
            if (r9 != r4) goto L_0x00d4
            if (r2 != 0) goto L_0x00d3
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x00e2
        L_0x00d3:
            r9 = r4
        L_0x00d4:
            r6 = r14
        L_0x00d5:
            r3 = 0
        L_0x00d6:
            if (r3 != r14) goto L_0x00e1
            if (r6 != 0) goto L_0x00e1
            if (r9 != 0) goto L_0x00e1
            if (r2 != r14) goto L_0x00e1
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x00e2
        L_0x00e1:
            r2 = 0
        L_0x00e2:
            com.google.android.gms.internal.ads.zzawc r14 = new com.google.android.gms.internal.ads.zzawc
            r14.<init>(r5, r12, r2)
            int r2 = (r49 > r19 ? 1 : (r49 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x00f4
            long r2 = r14.zzb
            r24 = r2
            r2 = r48
            goto L_0x00f8
        L_0x00f4:
            r2 = r48
            r24 = r49
        L_0x00f8:
            com.google.android.gms.internal.ads.zzbak r2 = r2.zza
            r2.zzv(r7)
            int r3 = r2.zze()
            int r3 = com.google.android.gms.internal.ads.zzavw.zzf(r3)
            if (r3 != 0) goto L_0x0109
            r3 = r7
            goto L_0x010b
        L_0x0109:
            r3 = 16
        L_0x010b:
            r2.zzw(r3)
            long r30 = r2.zzm()
            int r2 = (r24 > r19 ? 1 : (r24 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0119
            r24 = r19
            goto L_0x0124
        L_0x0119:
            r26 = 1000000(0xf4240, double:4.940656E-318)
            r28 = r30
            long r2 = com.google.android.gms.internal.ads.zzbar.zzj(r24, r26, r28)
            r24 = r2
        L_0x0124:
            int r2 = com.google.android.gms.internal.ads.zzavw.zzI
            com.google.android.gms.internal.ads.zzavu r2 = r1.zza(r2)
            int r3 = com.google.android.gms.internal.ads.zzavw.zzJ
            com.google.android.gms.internal.ads.zzavu r2 = r2.zza(r3)
            int r3 = com.google.android.gms.internal.ads.zzavw.zzU
            com.google.android.gms.internal.ads.zzavv r1 = r1.zzb(r3)
            com.google.android.gms.internal.ads.zzbak r1 = r1.zza
            r1.zzv(r7)
            int r3 = r1.zze()
            int r3 = com.google.android.gms.internal.ads.zzavw.zzf(r3)
            if (r3 != 0) goto L_0x0147
            r4 = r7
            goto L_0x0149
        L_0x0147:
            r4 = 16
        L_0x0149:
            r1.zzw(r4)
            long r4 = r1.zzm()
            if (r3 != 0) goto L_0x0154
            r3 = 4
            goto L_0x0155
        L_0x0154:
            r3 = r7
        L_0x0155:
            r1.zzw(r3)
            int r1 = r1.zzj()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r6 = r1 >> 10
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r3.append(r6)
            int r6 = r1 >> 5
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r3.append(r6)
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            r3.append(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            java.lang.String r3 = r3.toString()
            android.util.Pair r13 = android.util.Pair.create(r1, r3)
            int r1 = com.google.android.gms.internal.ads.zzavw.zzW
            com.google.android.gms.internal.ads.zzavv r1 = r2.zzb(r1)
            com.google.android.gms.internal.ads.zzbak r12 = r1.zza
            int r19 = r14.zza
            int r20 = r14.zzc
            java.lang.Object r1 = r13.second
            r9 = r1
            java.lang.String r9 = (java.lang.String) r9
            r1 = 12
            r12.zzv(r1)
            int r6 = r12.zze()
            com.google.android.gms.internal.ads.zzavz r5 = new com.google.android.gms.internal.ads.zzavz
            r5.<init>(r6)
            r4 = 0
        L_0x01ad:
            if (r4 >= r6) goto L_0x07b3
            int r3 = r12.zzc()
            int r2 = r12.zze()
            if (r2 <= 0) goto L_0x01bd
            r22 = r10
            r1 = 1
            goto L_0x01c0
        L_0x01bd:
            r22 = r10
            r1 = 0
        L_0x01c0:
            java.lang.String r10 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzbac.zzd(r1, r10)
            int r1 = r12.zze()
            int r7 = com.google.android.gms.internal.ads.zzavw.zze
            if (r1 == r7) goto L_0x05ab
            int r7 = com.google.android.gms.internal.ads.zzavw.zzf
            if (r1 == r7) goto L_0x05ab
            int r7 = com.google.android.gms.internal.ads.zzavw.zzac
            if (r1 == r7) goto L_0x05ab
            int r7 = com.google.android.gms.internal.ads.zzavw.zzan
            if (r1 == r7) goto L_0x05ab
            int r7 = com.google.android.gms.internal.ads.zzavw.zzg
            if (r1 == r7) goto L_0x05ab
            int r7 = com.google.android.gms.internal.ads.zzavw.zzh
            if (r1 == r7) goto L_0x05ab
            int r7 = com.google.android.gms.internal.ads.zzavw.zzi
            if (r1 == r7) goto L_0x05ab
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaM
            if (r1 == r7) goto L_0x05ab
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaN
            if (r1 != r7) goto L_0x01ef
            goto L_0x05ab
        L_0x01ef:
            int r7 = com.google.android.gms.internal.ads.zzavw.zzl
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzad
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzq
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzs
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzu
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzx
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzv
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzw
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaA
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaB
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzo
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzp
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzm
            if (r1 == r7) goto L_0x02ed
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaQ
            if (r1 != r7) goto L_0x0229
            goto L_0x02ed
        L_0x0229:
            int r7 = com.google.android.gms.internal.ads.zzavw.zzam
            if (r1 == r7) goto L_0x0260
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaw
            if (r1 == r7) goto L_0x0260
            int r7 = com.google.android.gms.internal.ads.zzavw.zzax
            if (r1 == r7) goto L_0x0260
            int r7 = com.google.android.gms.internal.ads.zzavw.zzay
            if (r1 == r7) goto L_0x0260
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaz
            if (r1 != r7) goto L_0x023e
            goto L_0x0260
        L_0x023e:
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaP
            if (r1 != r7) goto L_0x024e
            java.lang.String r1 = java.lang.Integer.toString(r19)
            java.lang.String r7 = "application/x-camera-motion"
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzj(r1, r7, r8, r11, r15)
            r5.zzb = r1
        L_0x024e:
            r26 = r2
            r21 = r3
            r32 = r4
            r2 = r5
            r29 = r6
            r28 = r9
            r0 = r12
            r43 = r13
            r16 = r14
            goto L_0x034a
        L_0x0260:
            int r7 = r3 + 16
            r12.zzv(r7)
            int r7 = com.google.android.gms.internal.ads.zzavw.zzam
            r27 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r1 != r7) goto L_0x0275
            java.lang.String r1 = "application/ttml+xml"
        L_0x0270:
            r7 = r1
            r18 = r8
        L_0x0273:
            r10 = 1
            goto L_0x02a6
        L_0x0275:
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaw
            if (r1 != r7) goto L_0x028a
            int r1 = r2 + -16
            byte[] r7 = new byte[r1]
            r10 = 0
            r12.zzq(r7, r10, r1)
            java.util.List r1 = java.util.Collections.singletonList(r7)
            java.lang.String r7 = "application/x-quicktime-tx3g"
            r18 = r1
            goto L_0x0273
        L_0x028a:
            int r7 = com.google.android.gms.internal.ads.zzavw.zzax
            if (r1 != r7) goto L_0x0291
            java.lang.String r1 = "application/x-mp4-vtt"
            goto L_0x0270
        L_0x0291:
            int r7 = com.google.android.gms.internal.ads.zzavw.zzay
            if (r1 != r7) goto L_0x029a
            r27 = 0
            java.lang.String r1 = "application/ttml+xml"
            goto L_0x0270
        L_0x029a:
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaz
            if (r1 != r7) goto L_0x02e7
            r10 = 1
            r5.zzd = r10
            java.lang.String r1 = "application/x-mp4-cea-608"
            r7 = r1
            r18 = r8
        L_0x02a6:
            java.lang.String r1 = java.lang.Integer.toString(r19)
            r29 = 0
            r32 = -1
            r33 = 0
            r34 = -1
            r48 = r13
            r13 = r2
            r2 = r7
            r7 = r3
            r3 = r29
            r35 = r4
            r4 = r32
            r36 = r5
            r5 = r33
            r29 = r6
            r6 = r9
            r37 = r7
            r7 = r34
            r8 = r51
            r38 = r9
            r9 = r27
            r0 = r11
            r11 = r18
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzk(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11)
            r11 = r36
            r11.zzb = r1
            r43 = r48
            r2 = r11
            r0 = r12
            r26 = r13
            r16 = r14
            r32 = r35
            r21 = r37
            goto L_0x0348
        L_0x02e7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x02ed:
            r37 = r3
            r35 = r4
            r29 = r6
            r38 = r9
            r0 = r11
            r48 = r13
            r13 = r2
            r11 = r5
            r9 = r37
            int r3 = r9 + 16
            r12.zzv(r3)
            if (r52 == 0) goto L_0x030e
            int r2 = r12.zzj()
            r3 = 6
            r12.zzw(r3)
            r8 = 8
            goto L_0x0314
        L_0x030e:
            r8 = 8
            r12.zzw(r8)
            r2 = 0
        L_0x0314:
            if (r2 == 0) goto L_0x0350
            r7 = 1
            if (r2 != r7) goto L_0x031b
            r6 = 2
            goto L_0x0352
        L_0x031b:
            r6 = 2
            if (r2 != r6) goto L_0x033c
            r2 = 16
            r12.zzw(r2)
            long r2 = r12.zzl()
            double r2 = java.lang.Double.longBitsToDouble(r2)
            long r2 = java.lang.Math.round(r2)
            int r2 = (int) r2
            int r3 = r12.zzi()
            r4 = 20
            r12.zzw(r4)
            r5 = 16
            goto L_0x0369
        L_0x033c:
            r43 = r48
            r21 = r9
            r2 = r11
            r0 = r12
            r26 = r13
            r16 = r14
            r32 = r35
        L_0x0348:
            r28 = r38
        L_0x034a:
            r17 = 0
        L_0x034c:
            r23 = 3
            goto L_0x0794
        L_0x0350:
            r6 = 2
            r7 = 1
        L_0x0352:
            int r3 = r12.zzj()
            r4 = 6
            r12.zzw(r4)
            int r4 = r12.zzh()
            if (r2 != r7) goto L_0x0366
            r5 = 16
            r12.zzw(r5)
            goto L_0x0368
        L_0x0366:
            r5 = 16
        L_0x0368:
            r2 = r4
        L_0x0369:
            int r4 = r12.zzc()
            int r5 = com.google.android.gms.internal.ads.zzavw.zzad
            if (r1 != r5) goto L_0x037b
            r5 = r35
            int r1 = zze(r12, r9, r13, r11, r5)
            r12.zzv(r4)
            goto L_0x037d
        L_0x037b:
            r5 = r35
        L_0x037d:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzq
            if (r1 != r6) goto L_0x0384
            java.lang.String r1 = "audio/ac3"
            goto L_0x03ce
        L_0x0384:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzs
            if (r1 != r6) goto L_0x038b
            java.lang.String r1 = "audio/eac3"
            goto L_0x03ce
        L_0x038b:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzu
            if (r1 != r6) goto L_0x0392
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x03ce
        L_0x0392:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzv
            if (r1 == r6) goto L_0x03cc
            int r6 = com.google.android.gms.internal.ads.zzavw.zzw
            if (r1 != r6) goto L_0x039b
            goto L_0x03cc
        L_0x039b:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzx
            if (r1 != r6) goto L_0x03a2
            java.lang.String r1 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x03ce
        L_0x03a2:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzaA
            if (r1 != r6) goto L_0x03a9
            java.lang.String r1 = "audio/3gpp"
            goto L_0x03ce
        L_0x03a9:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzaB
            if (r1 != r6) goto L_0x03b0
            java.lang.String r1 = "audio/amr-wb"
            goto L_0x03ce
        L_0x03b0:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzo
            if (r1 == r6) goto L_0x03c9
            int r6 = com.google.android.gms.internal.ads.zzavw.zzp
            if (r1 != r6) goto L_0x03b9
            goto L_0x03c9
        L_0x03b9:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzm
            if (r1 != r6) goto L_0x03c0
            java.lang.String r1 = "audio/mpeg"
            goto L_0x03ce
        L_0x03c0:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzaQ
            if (r1 != r6) goto L_0x03c7
            java.lang.String r1 = "audio/alac"
            goto L_0x03ce
        L_0x03c7:
            r1 = 0
            goto L_0x03ce
        L_0x03c9:
            java.lang.String r1 = "audio/raw"
            goto L_0x03ce
        L_0x03cc:
            java.lang.String r1 = "audio/vnd.dts.hd"
        L_0x03ce:
            r26 = r2
            r27 = r3
            r6 = r4
            r18 = 0
            r4 = r1
        L_0x03d6:
            int r1 = r6 - r9
            if (r1 >= r13) goto L_0x0528
            r12.zzv(r6)
            int r3 = r12.zze()
            if (r3 <= 0) goto L_0x03e5
            r1 = r7
            goto L_0x03e6
        L_0x03e5:
            r1 = 0
        L_0x03e6:
            com.google.android.gms.internal.ads.zzbac.zzd(r1, r10)
            int r1 = r12.zze()
            int r2 = com.google.android.gms.internal.ads.zzavw.zzM
            if (r1 == r2) goto L_0x04a2
            if (r52 == 0) goto L_0x03f9
            int r7 = com.google.android.gms.internal.ads.zzavw.zzn
            if (r1 != r7) goto L_0x03f9
            goto L_0x04a2
        L_0x03f9:
            int r2 = com.google.android.gms.internal.ads.zzavw.zzr
            if (r1 != r2) goto L_0x0423
            int r1 = r6 + 8
            r12.zzv(r1)
            java.lang.String r1 = java.lang.Integer.toString(r19)
            r7 = r38
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzati.zzb(r12, r1, r7, r15)
            r11.zzb = r1
        L_0x040e:
            r0 = r3
            r39 = r4
            r40 = r5
            r4 = r6
            r28 = r7
            r42 = r9
            r15 = r10
            r32 = r13
            r17 = 2
            r23 = 16
            r13 = r11
        L_0x0420:
            r11 = 0
            goto L_0x049f
        L_0x0423:
            r7 = r38
            int r2 = com.google.android.gms.internal.ads.zzavw.zzt
            if (r1 != r2) goto L_0x0439
            int r1 = r6 + 8
            r12.zzv(r1)
            java.lang.String r1 = java.lang.Integer.toString(r19)
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzati.zzc(r12, r1, r7, r15)
            r11.zzb = r1
            goto L_0x040e
        L_0x0439:
            int r2 = com.google.android.gms.internal.ads.zzavw.zzy
            if (r1 != r2) goto L_0x047b
            java.lang.String r1 = java.lang.Integer.toString(r19)
            r28 = 0
            r32 = -1
            r33 = -1
            r34 = 0
            r35 = 0
            r2 = r4
            r0 = r3
            r3 = r28
            r39 = r4
            r4 = r32
            r40 = r5
            r23 = 16
            r5 = r33
            r41 = r6
            r17 = 2
            r6 = r27
            r28 = r7
            r15 = 1
            r7 = r26
            r8 = r34
            r42 = r9
            r9 = r51
            r15 = r10
            r10 = r35
            r32 = r13
            r13 = r11
            r11 = r28
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzg(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13.zzb = r1
        L_0x0478:
            r4 = r41
            goto L_0x0420
        L_0x047b:
            r0 = r3
            r39 = r4
            r40 = r5
            r41 = r6
            r28 = r7
            r42 = r9
            r15 = r10
            r32 = r13
            r17 = 2
            r23 = 16
            r13 = r11
            int r2 = com.google.android.gms.internal.ads.zzavw.zzaQ
            if (r1 != r2) goto L_0x0478
            byte[] r1 = new byte[r0]
            r4 = r41
            r12.zzv(r4)
            r11 = 0
            r12.zzq(r1, r11, r0)
            r18 = r1
        L_0x049f:
            r10 = -1
            goto L_0x0512
        L_0x04a2:
            r0 = r3
            r39 = r4
            r40 = r5
            r4 = r6
            r42 = r9
            r15 = r10
            r32 = r13
            r28 = r38
            r17 = 2
            r23 = 16
            r13 = r11
            r11 = 0
            if (r1 != r2) goto L_0x04ba
            r1 = r4
        L_0x04b8:
            r10 = -1
            goto L_0x04dd
        L_0x04ba:
            int r1 = r12.zzc()
        L_0x04be:
            int r2 = r1 - r4
            if (r2 >= r0) goto L_0x04db
            r12.zzv(r1)
            int r2 = r12.zze()
            if (r2 <= 0) goto L_0x04cd
            r3 = 1
            goto L_0x04ce
        L_0x04cd:
            r3 = r11
        L_0x04ce:
            com.google.android.gms.internal.ads.zzbac.zzd(r3, r15)
            int r3 = r12.zze()
            int r5 = com.google.android.gms.internal.ads.zzavw.zzM
            if (r3 == r5) goto L_0x04b8
            int r1 = r1 + r2
            goto L_0x04be
        L_0x04db:
            r1 = -1
            goto L_0x04b8
        L_0x04dd:
            if (r1 == r10) goto L_0x050e
            android.util.Pair r1 = zzf(r12, r1)
            java.lang.Object r2 = r1.first
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.second
            r18 = r1
            byte[] r18 = (byte[]) r18
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0510
            android.util.Pair r1 = com.google.android.gms.internal.ads.zzbad.zza(r18)
            java.lang.Object r3 = r1.first
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r27 = r1
            r26 = r3
            goto L_0x0510
        L_0x050e:
            r2 = r39
        L_0x0510:
            r39 = r2
        L_0x0512:
            int r6 = r4 + r0
            r0 = r10
            r11 = r13
            r10 = r15
            r38 = r28
            r13 = r32
            r4 = r39
            r5 = r40
            r9 = r42
            r7 = 1
            r8 = 8
            r15 = r51
            goto L_0x03d6
        L_0x0528:
            r10 = r0
            r39 = r4
            r40 = r5
            r42 = r9
            r32 = r13
            r28 = r38
            r17 = 2
            r23 = 16
            r13 = r11
            r11 = 0
            com.google.android.gms.internal.ads.zzasw r0 = r13.zzb
            if (r0 != 0) goto L_0x0597
            r0 = r39
            if (r0 == 0) goto L_0x0597
            java.lang.String r1 = "audio/raw"
            boolean r1 = r1.equals(r0)
            r15 = 1
            if (r15 == r1) goto L_0x054c
            r8 = r10
            goto L_0x054e
        L_0x054c:
            r8 = r17
        L_0x054e:
            java.lang.String r1 = java.lang.Integer.toString(r19)
            if (r18 != 0) goto L_0x0557
            r18 = 0
            goto L_0x055d
        L_0x0557:
            java.util.List r2 = java.util.Collections.singletonList(r18)
            r18 = r2
        L_0x055d:
            r3 = 0
            r4 = -1
            r5 = -1
            r9 = -1
            r21 = -1
            r33 = 0
            r34 = 0
            r2 = r0
            r6 = r27
            r7 = r26
            r0 = r10
            r10 = r21
            r21 = r11
            r11 = r18
            r0 = r12
            r12 = r51
            r43 = r48
            r44 = r13
            r17 = r21
            r45 = r32
            r13 = r33
            r16 = r14
            r14 = r28
            r15 = r34
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzh(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r14 = r44
            r14.zzb = r1
            r2 = r14
            r32 = r40
            r21 = r42
            r26 = r45
            goto L_0x034c
        L_0x0597:
            r43 = r48
            r17 = r11
            r0 = r12
            r16 = r14
            r2 = r13
            r33 = r23
            r26 = r32
            r32 = r40
            r21 = r42
            r23 = 3
            goto L_0x0796
        L_0x05ab:
            r45 = r2
            r42 = r3
            r40 = r4
            r29 = r6
            r28 = r9
            r15 = r10
            r0 = r12
            r43 = r13
            r16 = r14
            r17 = 0
            r14 = r5
            r13 = r42
            int r3 = r13 + 16
            r0.zzv(r3)
            r12 = 16
            r0.zzw(r12)
            int r6 = r0.zzj()
            int r7 = r0.zzj()
            r2 = 50
            r0.zzw(r2)
            int r2 = r0.zzc()
            int r3 = com.google.android.gms.internal.ads.zzavw.zzac
            if (r1 != r3) goto L_0x05eb
            r11 = r40
            r10 = r45
            int r1 = zze(r0, r13, r10, r14, r11)
            r0.zzv(r2)
            goto L_0x05ef
        L_0x05eb:
            r11 = r40
            r10 = r45
        L_0x05ef:
            r3 = 1065353216(0x3f800000, float:1.0)
            r23 = r3
            r4 = r17
            r3 = 0
            r9 = 0
            r18 = -1
            r21 = 0
        L_0x05fb:
            int r5 = r2 - r13
            if (r5 >= r10) goto L_0x0750
            r0.zzv(r2)
            int r5 = r0.zzc()
            int r8 = r0.zze()
            if (r8 != 0) goto L_0x0617
            int r8 = r0.zzc()
            int r8 = r8 - r13
            if (r8 != r10) goto L_0x0615
            goto L_0x0750
        L_0x0615:
            r8 = r17
        L_0x0617:
            if (r8 <= 0) goto L_0x061b
            r12 = 1
            goto L_0x061d
        L_0x061b:
            r12 = r17
        L_0x061d:
            com.google.android.gms.internal.ads.zzbac.zzd(r12, r15)
            int r12 = r0.zze()
            r45 = r10
            int r10 = com.google.android.gms.internal.ads.zzavw.zzK
            if (r12 != r10) goto L_0x064b
            if (r3 != 0) goto L_0x062e
            r3 = 1
            goto L_0x0630
        L_0x062e:
            r3 = r17
        L_0x0630:
            com.google.android.gms.internal.ads.zzbac.zze(r3)
            int r5 = r5 + 8
            r0.zzv(r5)
            com.google.android.gms.internal.ads.zzbas r3 = com.google.android.gms.internal.ads.zzbas.zza(r0)
            java.util.List r9 = r3.zza
            int r5 = r3.zzb
            r14.zzc = r5
            if (r4 != 0) goto L_0x0648
            float r3 = r3.zzc
            r23 = r3
        L_0x0648:
            java.lang.String r3 = "video/avc"
            goto L_0x0669
        L_0x064b:
            int r10 = com.google.android.gms.internal.ads.zzavw.zzL
            if (r12 != r10) goto L_0x0670
            if (r3 != 0) goto L_0x0653
            r3 = 1
            goto L_0x0655
        L_0x0653:
            r3 = r17
        L_0x0655:
            com.google.android.gms.internal.ads.zzbac.zze(r3)
            int r5 = r5 + 8
            r0.zzv(r5)
            com.google.android.gms.internal.ads.zzbay r3 = com.google.android.gms.internal.ads.zzbay.zza(r0)
            java.util.List r9 = r3.zza
            int r3 = r3.zzb
            r14.zzc = r3
            java.lang.String r3 = "video/hevc"
        L_0x0669:
            r26 = r1
        L_0x066b:
            r5 = 2
            r10 = 1
            r12 = 3
            goto L_0x0747
        L_0x0670:
            int r10 = com.google.android.gms.internal.ads.zzavw.zzaO
            if (r12 != r10) goto L_0x0687
            if (r3 != 0) goto L_0x0678
            r3 = 1
            goto L_0x067a
        L_0x0678:
            r3 = r17
        L_0x067a:
            com.google.android.gms.internal.ads.zzbac.zze(r3)
            int r3 = com.google.android.gms.internal.ads.zzavw.zzaM
            if (r1 != r3) goto L_0x0684
            java.lang.String r3 = "video/x-vnd.on2.vp8"
            goto L_0x0669
        L_0x0684:
            java.lang.String r3 = "video/x-vnd.on2.vp9"
            goto L_0x0669
        L_0x0687:
            int r10 = com.google.android.gms.internal.ads.zzavw.zzj
            if (r12 != r10) goto L_0x0697
            if (r3 != 0) goto L_0x068f
            r3 = 1
            goto L_0x0691
        L_0x068f:
            r3 = r17
        L_0x0691:
            com.google.android.gms.internal.ads.zzbac.zze(r3)
            java.lang.String r3 = "video/3gpp"
            goto L_0x0669
        L_0x0697:
            int r10 = com.google.android.gms.internal.ads.zzavw.zzM
            if (r12 != r10) goto L_0x06b8
            if (r3 != 0) goto L_0x069f
            r3 = 1
            goto L_0x06a1
        L_0x069f:
            r3 = r17
        L_0x06a1:
            com.google.android.gms.internal.ads.zzbac.zze(r3)
            android.util.Pair r3 = zzf(r0, r5)
            java.lang.Object r5 = r3.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.second
            byte[] r3 = (byte[]) r3
            java.util.List r9 = java.util.Collections.singletonList(r3)
            r26 = r1
            r3 = r5
            goto L_0x066b
        L_0x06b8:
            int r10 = com.google.android.gms.internal.ads.zzavw.zzal
            if (r12 != r10) goto L_0x06d1
            int r5 = r5 + 8
            r0.zzv(r5)
            int r4 = r0.zzi()
            float r4 = (float) r4
            int r5 = r0.zzi()
            float r5 = (float) r5
            float r23 = r4 / r5
            r26 = r1
            r4 = 1
            goto L_0x066b
        L_0x06d1:
            int r10 = com.google.android.gms.internal.ads.zzavw.zzaK
            if (r12 != r10) goto L_0x0708
            int r10 = r5 + 8
        L_0x06d7:
            int r12 = r10 - r5
            if (r12 >= r8) goto L_0x06fe
            r0.zzv(r10)
            int r12 = r0.zze()
            r26 = r1
            int r1 = r0.zze()
            r48 = r4
            int r4 = com.google.android.gms.internal.ads.zzavw.zzaL
            if (r1 != r4) goto L_0x06f8
            byte[] r1 = r0.zza
            int r12 = r12 + r10
            byte[] r1 = java.util.Arrays.copyOfRange(r1, r10, r12)
            r21 = r1
            goto L_0x0704
        L_0x06f8:
            int r10 = r10 + r12
            r4 = r48
            r1 = r26
            goto L_0x06d7
        L_0x06fe:
            r26 = r1
            r48 = r4
            r21 = 0
        L_0x0704:
            r4 = r48
            goto L_0x066b
        L_0x0708:
            r26 = r1
            r48 = r4
            int r1 = com.google.android.gms.internal.ads.zzavw.zzaJ
            if (r12 != r1) goto L_0x0742
            int r1 = r0.zzg()
            r12 = 3
            r0.zzw(r12)
            if (r1 != 0) goto L_0x073f
            int r1 = r0.zzg()
            if (r1 == 0) goto L_0x0738
            r10 = 1
            r5 = 2
            if (r1 == r10) goto L_0x0733
            if (r1 == r5) goto L_0x072e
            if (r1 == r12) goto L_0x0729
            goto L_0x0745
        L_0x0729:
            r4 = r48
            r18 = r12
            goto L_0x0747
        L_0x072e:
            r4 = r48
            r18 = r5
            goto L_0x0747
        L_0x0733:
            r4 = r48
            r18 = r10
            goto L_0x0747
        L_0x0738:
            r5 = 2
            r10 = 1
            r4 = r48
            r18 = r17
            goto L_0x0747
        L_0x073f:
            r5 = 2
            r10 = 1
            goto L_0x0745
        L_0x0742:
            r5 = 2
            r10 = 1
            r12 = 3
        L_0x0745:
            r4 = r48
        L_0x0747:
            int r2 = r2 + r8
            r1 = r26
            r10 = r45
            r12 = 16
            goto L_0x05fb
        L_0x0750:
            r45 = r10
            r5 = 2
            r10 = 1
            r12 = 3
            if (r3 == 0) goto L_0x078b
            java.lang.String r1 = java.lang.Integer.toString(r19)
            r4 = 0
            r8 = -1
            r15 = -1
            r26 = -1082130432(0xffffffffbf800000, float:-1.0)
            r27 = 0
            r2 = r3
            r3 = r4
            r4 = r8
            r8 = r5
            r5 = r15
            r15 = r8
            r8 = r26
            r26 = r45
            r10 = r20
            r32 = r11
            r11 = r23
            r23 = r12
            r33 = 16
            r12 = r21
            r21 = r13
            r13 = r18
            r46 = r14
            r14 = r27
            r15 = r51
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r2 = r46
            r2.zzb = r1
            goto L_0x0796
        L_0x078b:
            r32 = r11
            r23 = r12
            r21 = r13
            r2 = r14
            r26 = r45
        L_0x0794:
            r33 = 16
        L_0x0796:
            int r3 = r21 + r26
            r0.zzv(r3)
            int r4 = r32 + 1
            r15 = r51
            r12 = r0
            r5 = r2
            r14 = r16
            r10 = r22
            r9 = r28
            r6 = r29
            r13 = r43
            r7 = 8
            r8 = 0
            r11 = -1
            r0 = r47
            goto L_0x01ad
        L_0x07b3:
            r2 = r5
            r22 = r10
            r43 = r13
            r16 = r14
            r17 = 0
            int r0 = com.google.android.gms.internal.ads.zzavw.zzS
            r1 = r47
            com.google.android.gms.internal.ads.zzavu r0 = r1.zza(r0)
            if (r0 == 0) goto L_0x0822
            int r1 = com.google.android.gms.internal.ads.zzavw.zzT
            com.google.android.gms.internal.ads.zzavv r0 = r0.zzb(r1)
            if (r0 != 0) goto L_0x07cf
            goto L_0x0822
        L_0x07cf:
            com.google.android.gms.internal.ads.zzbak r0 = r0.zza
            r1 = 8
            r0.zzv(r1)
            int r1 = r0.zze()
            int r1 = com.google.android.gms.internal.ads.zzavw.zzf(r1)
            int r3 = r0.zzi()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r6 = r17
        L_0x07e8:
            if (r6 >= r3) goto L_0x081b
            r7 = 1
            if (r1 != r7) goto L_0x07f2
            long r8 = r0.zzn()
            goto L_0x07f6
        L_0x07f2:
            long r8 = r0.zzm()
        L_0x07f6:
            r4[r6] = r8
            if (r1 != r7) goto L_0x07ff
            long r8 = r0.zzl()
            goto L_0x0804
        L_0x07ff:
            int r8 = r0.zze()
            long r8 = (long) r8
        L_0x0804:
            r5[r6] = r8
            short r8 = r0.zzp()
            if (r8 != r7) goto L_0x0813
            r8 = 2
            r0.zzw(r8)
            int r6 = r6 + 1
            goto L_0x07e8
        L_0x0813:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x081b:
            android.util.Pair r0 = android.util.Pair.create(r4, r5)
            r1 = r0
            r0 = 0
            goto L_0x0827
        L_0x0822:
            r0 = 0
            android.util.Pair r1 = android.util.Pair.create(r0, r0)
        L_0x0827:
            com.google.android.gms.internal.ads.zzasw r3 = r2.zzb
            if (r3 != 0) goto L_0x082c
            return r0
        L_0x082c:
            com.google.android.gms.internal.ads.zzawo r0 = new com.google.android.gms.internal.ads.zzawo
            int r16 = r16.zza
            r3 = r43
            java.lang.Object r3 = r3.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r18 = r3.longValue()
            com.google.android.gms.internal.ads.zzasw r3 = r2.zzb
            int r4 = r2.zzd
            com.google.android.gms.internal.ads.zzawp[] r5 = r2.zza
            int r2 = r2.zzc
            java.lang.Object r6 = r1.first
            r28 = r6
            long[] r28 = (long[]) r28
            java.lang.Object r1 = r1.second
            r29 = r1
            long[] r29 = (long[]) r29
            r15 = r0
            r17 = r22
            r20 = r30
            r22 = r24
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r2
            r15.<init>(r16, r17, r18, r20, r22, r24, r25, r26, r27, r28, r29)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawd.zza(com.google.android.gms.internal.ads.zzavu, com.google.android.gms.internal.ads.zzavv, long, com.google.android.gms.internal.ads.zzauv, boolean):com.google.android.gms.internal.ads.zzawo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0176 A[LOOP:5: B:58:0x0176->B:59:0x0178, LOOP_START, PHI: r2 r3 r16 r23 
      PHI: (r2v29 int) = (r2v21 int), (r2v36 int) binds: [B:57:0x0174, B:59:0x0178] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v27 int) = (r3v24 int), (r3v42 int) binds: [B:57:0x0174, B:59:0x0178] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r16v9 int) = (r16v8 int), (r16v12 int) binds: [B:57:0x0174, B:59:0x0178] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r23v3 long) = (r23v2 long), (r23v5 long) binds: [B:57:0x0174, B:59:0x0178] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0226  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzawr zzb(com.google.android.gms.internal.ads.zzawo r41, com.google.android.gms.internal.ads.zzavu r42, com.google.android.gms.internal.ads.zzavd r43) throws com.google.android.gms.internal.ads.zzasz {
        /*
            r0 = r41
            r1 = r42
            r2 = r43
            int r3 = com.google.android.gms.internal.ads.zzavw.zzas
            com.google.android.gms.internal.ads.zzavv r3 = r1.zzb(r3)
            if (r3 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzawa r4 = new com.google.android.gms.internal.ads.zzawa
            r4.<init>(r3)
            goto L_0x0021
        L_0x0014:
            int r3 = com.google.android.gms.internal.ads.zzavw.zzat
            com.google.android.gms.internal.ads.zzavv r3 = r1.zzb(r3)
            if (r3 == 0) goto L_0x04c1
            com.google.android.gms.internal.ads.zzawb r4 = new com.google.android.gms.internal.ads.zzawb
            r4.<init>(r3)
        L_0x0021:
            int r3 = r4.zza()
            r5 = 0
            if (r3 != 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzawr r0 = new com.google.android.gms.internal.ads.zzawr
            long[] r7 = new long[r5]
            int[] r8 = new int[r5]
            r9 = 0
            long[] r10 = new long[r5]
            int[] r11 = new int[r5]
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            return r0
        L_0x0038:
            int r6 = com.google.android.gms.internal.ads.zzavw.zzau
            com.google.android.gms.internal.ads.zzavv r6 = r1.zzb(r6)
            if (r6 != 0) goto L_0x0048
            int r6 = com.google.android.gms.internal.ads.zzavw.zzav
            com.google.android.gms.internal.ads.zzavv r6 = r1.zzb(r6)
            r8 = 1
            goto L_0x0049
        L_0x0048:
            r8 = r5
        L_0x0049:
            com.google.android.gms.internal.ads.zzbak r6 = r6.zza
            int r9 = com.google.android.gms.internal.ads.zzavw.zzar
            com.google.android.gms.internal.ads.zzavv r9 = r1.zzb(r9)
            com.google.android.gms.internal.ads.zzbak r9 = r9.zza
            int r10 = com.google.android.gms.internal.ads.zzavw.zzao
            com.google.android.gms.internal.ads.zzavv r10 = r1.zzb(r10)
            com.google.android.gms.internal.ads.zzbak r10 = r10.zza
            int r11 = com.google.android.gms.internal.ads.zzavw.zzap
            com.google.android.gms.internal.ads.zzavv r11 = r1.zzb(r11)
            r12 = 0
            if (r11 == 0) goto L_0x0067
            com.google.android.gms.internal.ads.zzbak r11 = r11.zza
            goto L_0x0068
        L_0x0067:
            r11 = r12
        L_0x0068:
            int r13 = com.google.android.gms.internal.ads.zzavw.zzaq
            com.google.android.gms.internal.ads.zzavv r1 = r1.zzb(r13)
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.internal.ads.zzbak r1 = r1.zza
            goto L_0x0074
        L_0x0073:
            r1 = r12
        L_0x0074:
            com.google.android.gms.internal.ads.zzavx r13 = new com.google.android.gms.internal.ads.zzavx
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.zzv(r6)
            int r8 = r10.zzi()
            r9 = -1
            int r8 = r8 + r9
            int r14 = r10.zzi()
            int r15 = r10.zzi()
            if (r1 == 0) goto L_0x0096
            r1.zzv(r6)
            int r16 = r1.zzi()
            goto L_0x0098
        L_0x0096:
            r16 = r5
        L_0x0098:
            if (r11 == 0) goto L_0x00ab
            r11.zzv(r6)
            int r6 = r11.zzi()
            if (r6 <= 0) goto L_0x00a9
            int r12 = r11.zzi()
            int r12 = r12 + r9
            goto L_0x00ad
        L_0x00a9:
            r11 = r12
            goto L_0x00ac
        L_0x00ab:
            r6 = r5
        L_0x00ac:
            r12 = r9
        L_0x00ad:
            boolean r17 = r4.zzc()
            r18 = 0
            if (r17 == 0) goto L_0x0156
            com.google.android.gms.internal.ads.zzasw r5 = r0.zzf
            java.lang.String r5 = r5.zzf
            java.lang.String r9 = "audio/raw"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0156
            if (r8 != 0) goto L_0x0156
            if (r16 != 0) goto L_0x0155
            if (r6 != 0) goto L_0x0155
            int r1 = r13.zza
            long[] r5 = new long[r1]
            int[] r1 = new int[r1]
        L_0x00cd:
            boolean r6 = r13.zza()
            if (r6 == 0) goto L_0x00de
            int r6 = r13.zzb
            long r8 = r13.zzd
            r5[r6] = r8
            int r8 = r13.zzc
            r1[r6] = r8
            goto L_0x00cd
        L_0x00de:
            int r4 = r4.zzb()
            long r8 = (long) r15
            r6 = 8192(0x2000, float:1.14794E-41)
            int r6 = r6 / r4
            int r10 = r1.length
            r11 = 0
            r12 = 0
        L_0x00e9:
            if (r11 >= r10) goto L_0x00f5
            r13 = r1[r11]
            int r13 = com.google.android.gms.internal.ads.zzbar.zzd(r13, r6)
            int r12 = r12 + r13
            int r11 = r11 + 1
            goto L_0x00e9
        L_0x00f5:
            long[] r10 = new long[r12]
            int[] r11 = new int[r12]
            long[] r13 = new long[r12]
            int[] r12 = new int[r12]
            r14 = 0
            r15 = 0
            r16 = 0
            r20 = 0
        L_0x0103:
            int r7 = r1.length
            if (r14 >= r7) goto L_0x014a
            r7 = r1[r14]
            r22 = r5[r14]
            r40 = r16
            r16 = r1
            r1 = r15
            r15 = r40
        L_0x0111:
            if (r7 <= 0) goto L_0x013c
            int r24 = java.lang.Math.min(r6, r7)
            r10[r20] = r22
            r25 = r5
            int r5 = r4 * r24
            r11[r20] = r5
            int r1 = java.lang.Math.max(r1, r5)
            r26 = r4
            long r4 = (long) r15
            long r4 = r4 * r8
            r13[r20] = r4
            r4 = 1
            r12[r20] = r4
            r4 = r11[r20]
            long r4 = (long) r4
            long r22 = r22 + r4
            int r15 = r15 + r24
            int r7 = r7 - r24
            int r20 = r20 + 1
            r5 = r25
            r4 = r26
            goto L_0x0111
        L_0x013c:
            r26 = r4
            r25 = r5
            int r14 = r14 + 1
            r40 = r15
            r15 = r1
            r1 = r16
            r16 = r40
            goto L_0x0103
        L_0x014a:
            r29 = r3
            r5 = r10
            r7 = r11
            r6 = r12
            r33 = r15
            r25 = r18
            goto L_0x0282
        L_0x0155:
            r8 = 0
        L_0x0156:
            long[] r5 = new long[r3]
            int[] r7 = new int[r3]
            long[] r9 = new long[r3]
            r20 = r6
            int[] r6 = new int[r3]
            r2 = r8
            r0 = r12
            r12 = r15
            r23 = r18
            r25 = r23
            r27 = r20
            r8 = 0
            r22 = 0
            r28 = 0
            r15 = r14
            r20 = r16
            r14 = 0
            r16 = 0
        L_0x0174:
            if (r8 >= r3) goto L_0x0204
        L_0x0176:
            if (r16 != 0) goto L_0x0190
            boolean r16 = r13.zza()
            com.google.android.gms.internal.ads.zzbac.zze(r16)
            r30 = r2
            r29 = r3
            long r2 = r13.zzd
            r23 = r2
            int r2 = r13.zzc
            r16 = r2
            r3 = r29
            r2 = r30
            goto L_0x0176
        L_0x0190:
            r30 = r2
            r29 = r3
            if (r1 == 0) goto L_0x01ac
        L_0x0196:
            if (r28 != 0) goto L_0x01a9
            if (r20 <= 0) goto L_0x01a5
            int r28 = r1.zzi()
            int r22 = r1.zze()
            int r20 = r20 + -1
            goto L_0x0196
        L_0x01a5:
            r2 = -1
            r28 = 0
            goto L_0x01aa
        L_0x01a9:
            r2 = -1
        L_0x01aa:
            int r28 = r28 + -1
        L_0x01ac:
            r2 = r22
            r5[r8] = r23
            int r3 = r4.zzb()
            r7[r8] = r3
            if (r3 <= r14) goto L_0x01b9
            r14 = r3
        L_0x01b9:
            r22 = r4
            long r3 = (long) r2
            long r3 = r25 + r3
            r9[r8] = r3
            if (r11 != 0) goto L_0x01c4
            r3 = 1
            goto L_0x01c5
        L_0x01c4:
            r3 = 0
        L_0x01c5:
            r6[r8] = r3
            if (r8 != r0) goto L_0x01d6
            r3 = 1
            r6[r8] = r3
            int r27 = r27 + -1
            if (r27 <= 0) goto L_0x01d6
            int r0 = r11.zzi()
            r3 = -1
            int r0 = r0 + r3
        L_0x01d6:
            long r3 = (long) r12
            long r25 = r25 + r3
            int r3 = r15 + -1
            if (r3 != 0) goto L_0x01f0
            if (r30 <= 0) goto L_0x01ee
            int r3 = r10.zzi()
            int r4 = r10.zzi()
            int r12 = r30 + -1
            r15 = r3
            r30 = r12
            r12 = r4
            goto L_0x01f1
        L_0x01ee:
            r15 = 0
            goto L_0x01f1
        L_0x01f0:
            r15 = r3
        L_0x01f1:
            r3 = r7[r8]
            long r3 = (long) r3
            long r23 = r23 + r3
            int r16 = r16 + -1
            int r8 = r8 + 1
            r4 = r22
            r3 = r29
            r22 = r2
            r2 = r30
            goto L_0x0174
        L_0x0204:
            r30 = r2
            r29 = r3
            if (r28 != 0) goto L_0x020c
            r0 = 1
            goto L_0x020d
        L_0x020c:
            r0 = 0
        L_0x020d:
            com.google.android.gms.internal.ads.zzbac.zzc(r0)
        L_0x0210:
            if (r20 <= 0) goto L_0x0224
            int r0 = r1.zzi()
            if (r0 != 0) goto L_0x021a
            r0 = 1
            goto L_0x021b
        L_0x021a:
            r0 = 0
        L_0x021b:
            com.google.android.gms.internal.ads.zzbac.zzc(r0)
            r1.zze()
            int r20 = r20 + -1
            goto L_0x0210
        L_0x0224:
            if (r27 != 0) goto L_0x023f
            if (r15 != 0) goto L_0x0239
            if (r16 != 0) goto L_0x0232
            if (r30 == 0) goto L_0x022f
            r1 = 0
            r2 = 0
            goto L_0x0235
        L_0x022f:
            r0 = r41
            goto L_0x027f
        L_0x0232:
            r2 = r16
            r1 = 0
        L_0x0235:
            r15 = 0
            r0 = r41
            goto L_0x0245
        L_0x0239:
            r1 = 0
            r0 = r41
            r2 = r16
            goto L_0x0245
        L_0x023f:
            r0 = r41
            r2 = r16
            r1 = r27
        L_0x0245:
            int r3 = r0.zza
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "Inconsistent stbl box for track "
            r4.append(r8)
            r4.append(r3)
            java.lang.String r3 = ": remainingSynchronizationSamples "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = ", remainingSamplesAtTimestampDelta "
            r4.append(r1)
            r4.append(r15)
            java.lang.String r1 = ", remainingSamplesInChunk "
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r4.append(r1)
            r8 = r30
            r4.append(r8)
            java.lang.String r1 = r4.toString()
            java.lang.String r2 = "AtomParsers"
            android.util.Log.w(r2, r1)
        L_0x027f:
            r13 = r9
            r33 = r14
        L_0x0282:
            long[] r1 = r0.zzi
            if (r1 == 0) goto L_0x04a5
            boolean r4 = r43.zza()
            if (r4 == 0) goto L_0x028e
            goto L_0x04a5
        L_0x028e:
            int r4 = r1.length
            r8 = 1
            if (r4 != r8) goto L_0x031f
            int r4 = r0.zzb
            if (r4 != r8) goto L_0x031f
            int r4 = r13.length
            r8 = 2
            if (r4 < r8) goto L_0x031f
            long[] r8 = r0.zzj
            r9 = 0
            r10 = r8[r9]
            r34 = r1[r9]
            long r14 = r0.zzc
            long r2 = r0.zzd
            r36 = r14
            r38 = r2
            long r1 = com.google.android.gms.internal.ads.zzbar.zzj(r34, r36, r38)
            long r1 = r1 + r10
            r14 = r13[r9]
            int r3 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x031f
            r3 = 1
            r8 = r13[r3]
            int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x031f
            r3 = -1
            int r4 = r4 + r3
            r3 = r13[r4]
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x031f
            int r3 = (r1 > r25 ? 1 : (r1 == r25 ? 0 : -1))
            if (r3 > 0) goto L_0x031f
            long r34 = r10 - r14
            com.google.android.gms.internal.ads.zzasw r3 = r0.zzf
            int r3 = r3.zzs
            long r3 = (long) r3
            long r8 = r0.zzc
            r36 = r3
            r38 = r8
            long r3 = com.google.android.gms.internal.ads.zzbar.zzj(r34, r36, r38)
            long r34 = r25 - r1
            com.google.android.gms.internal.ads.zzasw r1 = r0.zzf
            int r1 = r1.zzs
            long r1 = (long) r1
            long r8 = r0.zzc
            r36 = r1
            r38 = r8
            long r1 = com.google.android.gms.internal.ads.zzbar.zzj(r34, r36, r38)
            int r8 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r8 != 0) goto L_0x02f3
            int r3 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r3 == 0) goto L_0x031f
            r3 = r18
        L_0x02f3:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x031f
            int r8 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x02ff
            goto L_0x031f
        L_0x02ff:
            int r3 = (int) r3
            r4 = r43
            r4.zzb = r3
            int r1 = (int) r1
            r4.zzc = r1
            long r0 = r0.zzc
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzbar.zzn(r13, r2, r0)
            com.google.android.gms.internal.ads.zzawr r0 = new com.google.android.gms.internal.ads.zzawr
            r30 = r0
            r31 = r5
            r32 = r7
            r34 = r13
            r35 = r6
            r30.<init>(r31, r32, r33, r34, r35)
            return r0
        L_0x031f:
            long[] r1 = r0.zzi
            int r2 = r1.length
            r3 = 1
            if (r2 != r3) goto L_0x035c
            r17 = 0
            r2 = r1[r17]
            int r1 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r1 != 0) goto L_0x035c
            r1 = r17
        L_0x032f:
            int r2 = r13.length
            if (r1 >= r2) goto L_0x034c
            r2 = r13[r1]
            long[] r4 = r0.zzj
            r8 = r4[r17]
            long r18 = r2 - r8
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r0.zzc
            r22 = r2
            long r2 = com.google.android.gms.internal.ads.zzbar.zzj(r18, r20, r22)
            r13[r1] = r2
            int r1 = r1 + 1
            r17 = 0
            goto L_0x032f
        L_0x034c:
            com.google.android.gms.internal.ads.zzawr r0 = new com.google.android.gms.internal.ads.zzawr
            r30 = r0
            r31 = r5
            r32 = r7
            r34 = r13
            r35 = r6
            r30.<init>(r31, r32, r33, r34, r35)
            return r0
        L_0x035c:
            int r1 = r0.zzb
            r2 = 1
            if (r1 != r2) goto L_0x0363
            r1 = 1
            goto L_0x0364
        L_0x0363:
            r1 = 0
        L_0x0364:
            r2 = 0
            r3 = 0
            r4 = 0
            r8 = 0
        L_0x0368:
            long[] r9 = r0.zzi
            int r10 = r9.length
            r11 = -1
            if (r2 >= r10) goto L_0x039e
            long[] r10 = r0.zzj
            r14 = r10[r2]
            int r10 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r10 == 0) goto L_0x039b
            r22 = r9[r2]
            long r9 = r0.zzc
            long r11 = r0.zzd
            r24 = r9
            r26 = r11
            long r9 = com.google.android.gms.internal.ads.zzbar.zzj(r22, r24, r26)
            r11 = 1
            int r12 = com.google.android.gms.internal.ads.zzbar.zzb(r13, r14, r11, r11)
            long r14 = r14 + r9
            r9 = 0
            int r10 = com.google.android.gms.internal.ads.zzbar.zzb(r13, r14, r1, r9)
            int r9 = r10 - r12
            int r3 = r3 + r9
            if (r4 == r12) goto L_0x0397
            r4 = 1
            goto L_0x0398
        L_0x0397:
            r4 = 0
        L_0x0398:
            r4 = r4 | r8
            r8 = r4
            r4 = r10
        L_0x039b:
            int r2 = r2 + 1
            goto L_0x0368
        L_0x039e:
            r2 = r29
            if (r3 == r2) goto L_0x03a4
            r2 = 1
            goto L_0x03a5
        L_0x03a4:
            r2 = 0
        L_0x03a5:
            r2 = r2 | r8
            if (r2 == 0) goto L_0x03ab
            long[] r4 = new long[r3]
            goto L_0x03ac
        L_0x03ab:
            r4 = r5
        L_0x03ac:
            if (r2 == 0) goto L_0x03b1
            int[] r8 = new int[r3]
            goto L_0x03b2
        L_0x03b1:
            r8 = r7
        L_0x03b2:
            r9 = 1
            if (r9 != r2) goto L_0x03b7
            r33 = 0
        L_0x03b7:
            if (r2 == 0) goto L_0x03bc
            int[] r9 = new int[r3]
            goto L_0x03bd
        L_0x03bc:
            r9 = r6
        L_0x03bd:
            long[] r3 = new long[r3]
            r25 = r33
            r10 = 0
            r14 = 0
        L_0x03c3:
            long[] r15 = r0.zzi
            int r11 = r15.length
            if (r10 >= r11) goto L_0x0477
            long[] r11 = r0.zzj
            r16 = r6
            r12 = r7
            r6 = r11[r10]
            r22 = r15[r10]
            r32 = -1
            int r11 = (r6 > r32 ? 1 : (r6 == r32 ? 0 : -1))
            if (r11 == 0) goto L_0x0457
            r15 = r10
            long r10 = r0.zzc
            r20 = r8
            r34 = r9
            long r8 = r0.zzd
            r26 = r22
            r28 = r10
            r30 = r8
            long r8 = com.google.android.gms.internal.ads.zzbar.zzj(r26, r28, r30)
            r10 = 1
            int r11 = com.google.android.gms.internal.ads.zzbar.zzb(r13, r6, r10, r10)
            long r8 = r8 + r6
            r10 = 0
            int r8 = com.google.android.gms.internal.ads.zzbar.zzb(r13, r8, r1, r10)
            if (r2 == 0) goto L_0x040d
            int r9 = r8 - r11
            java.lang.System.arraycopy(r5, r11, r4, r14, r9)
            r10 = r20
            java.lang.System.arraycopy(r12, r11, r10, r14, r9)
            r20 = r1
            r42 = r5
            r1 = r16
            r5 = r34
            java.lang.System.arraycopy(r1, r11, r5, r14, r9)
            goto L_0x0417
        L_0x040d:
            r42 = r5
            r10 = r20
            r5 = r34
            r20 = r1
            r1 = r16
        L_0x0417:
            r9 = r25
        L_0x0419:
            if (r11 >= r8) goto L_0x0450
            r28 = 1000000(0xf4240, double:4.940656E-318)
            r16 = r4
            r34 = r5
            long r4 = r0.zzd
            r26 = r18
            r30 = r4
            long r4 = com.google.android.gms.internal.ads.zzbar.zzj(r26, r28, r30)
            r24 = r13[r11]
            long r26 = r24 - r6
            r35 = r6
            long r6 = r0.zzc
            r30 = r6
            long r6 = com.google.android.gms.internal.ads.zzbar.zzj(r26, r28, r30)
            long r4 = r4 + r6
            r3[r14] = r4
            if (r2 == 0) goto L_0x0445
            r4 = r10[r14]
            if (r4 <= r9) goto L_0x0445
            r9 = r12[r11]
        L_0x0445:
            int r14 = r14 + 1
            int r11 = r11 + 1
            r4 = r16
            r5 = r34
            r6 = r35
            goto L_0x0419
        L_0x0450:
            r16 = r4
            r34 = r5
            r25 = r9
            goto L_0x0463
        L_0x0457:
            r20 = r1
            r42 = r5
            r34 = r9
            r15 = r10
            r1 = r16
            r16 = r4
            r10 = r8
        L_0x0463:
            long r18 = r18 + r22
            int r4 = r15 + 1
            r5 = r42
            r6 = r1
            r8 = r10
            r7 = r12
            r1 = r20
            r11 = r32
            r9 = r34
            r10 = r4
            r4 = r16
            goto L_0x03c3
        L_0x0477:
            r16 = r4
            r10 = r8
            r6 = r9
            r0 = 0
            r17 = 0
        L_0x047e:
            int r1 = r6.length
            if (r0 >= r1) goto L_0x048b
            if (r17 != 0) goto L_0x048d
            r1 = r6[r0]
            r2 = 1
            r17 = r1 & 1
            int r0 = r0 + 1
            goto L_0x047e
        L_0x048b:
            if (r17 == 0) goto L_0x049d
        L_0x048d:
            com.google.android.gms.internal.ads.zzawr r0 = new com.google.android.gms.internal.ads.zzawr
            r22 = r0
            r23 = r16
            r24 = r10
            r26 = r3
            r27 = r6
            r22.<init>(r23, r24, r25, r26, r27)
            return r0
        L_0x049d:
            com.google.android.gms.internal.ads.zzasz r0 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r1 = "The edited sample sequence does not contain a sync sample."
            r0.<init>(r1)
            throw r0
        L_0x04a5:
            r42 = r5
            r1 = r6
            r12 = r7
            long r2 = r0.zzc
            r4 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzbar.zzn(r13, r4, r2)
            com.google.android.gms.internal.ads.zzawr r0 = new com.google.android.gms.internal.ads.zzawr
            r30 = r0
            r31 = r42
            r32 = r12
            r34 = r13
            r35 = r1
            r30.<init>(r31, r32, r33, r34, r35)
            return r0
        L_0x04c1:
            com.google.android.gms.internal.ads.zzasz r0 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawd.zzb(com.google.android.gms.internal.ads.zzawo, com.google.android.gms.internal.ads.zzavu, com.google.android.gms.internal.ads.zzavd):com.google.android.gms.internal.ads.zzawr");
    }

    public static zzaxh zzc(zzavv zzavv, boolean z) {
        if (z) {
            return null;
        }
        zzbak zzbak = zzavv.zza;
        zzbak.zzv(8);
        while (zzbak.zza() >= 8) {
            int zzc2 = zzbak.zzc();
            int zze2 = zzbak.zze();
            if (zzbak.zze() == zzavw.zzaD) {
                zzbak.zzv(zzc2);
                int i = zzc2 + zze2;
                zzbak.zzw(12);
                while (zzbak.zzc() < i) {
                    int zzc3 = zzbak.zzc();
                    int zze3 = zzbak.zze();
                    if (zzbak.zze() == zzavw.zzaE) {
                        zzbak.zzv(zzc3);
                        int i2 = zzc3 + zze3;
                        zzbak.zzw(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzbak.zzc() < i2) {
                            zzaxg zza2 = zzawj.zza(zzbak);
                            if (zza2 != null) {
                                arrayList.add(zza2);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new zzaxh((List) arrayList);
                    }
                    zzbak.zzw(zze3 - 8);
                }
                return null;
            }
            zzbak.zzw(zze2 - 8);
        }
        return null;
    }

    private static int zzd(zzbak zzbak) {
        int zzg2 = zzbak.zzg();
        int i = zzg2 & 127;
        while ((zzg2 & 128) == 128) {
            zzg2 = zzbak.zzg();
            i = (i << 7) | (zzg2 & 127);
        }
        return i;
    }

    private static int zze(zzbak zzbak, int i, int i2, zzavz zzavz, int i3) {
        zzawp zzawp;
        zzbak zzbak2 = zzbak;
        int zzc2 = zzbak.zzc();
        while (true) {
            boolean z = false;
            if (zzc2 - i >= i2) {
                return 0;
            }
            zzbak.zzv(zzc2);
            int zze2 = zzbak.zze();
            zzbac.zzd(zze2 > 0, "childAtomSize should be positive");
            if (zzbak.zze() == zzavw.zzY) {
                int i4 = zzc2 + 8;
                Pair pair = null;
                boolean z2 = false;
                Integer num = null;
                zzawp zzawp2 = null;
                while (i4 - zzc2 < zze2) {
                    zzbak.zzv(i4);
                    int zze3 = zzbak.zze();
                    int zze4 = zzbak.zze();
                    if (zze4 == zzavw.zzae) {
                        num = Integer.valueOf(zzbak.zze());
                    } else if (zze4 == zzavw.zzZ) {
                        zzbak.zzw(4);
                        z2 = zzbak.zze() == zzg;
                    } else if (zze4 == zzavw.zzaa) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= zze3) {
                                zzawp = null;
                                break;
                            }
                            zzbak.zzv(i5);
                            int zze5 = zzbak.zze();
                            if (zzbak.zze() == zzavw.zzab) {
                                zzbak.zzw(6);
                                boolean z3 = zzbak.zzg() == 1;
                                int zzg2 = zzbak.zzg();
                                byte[] bArr = new byte[16];
                                zzbak.zzq(bArr, 0, 16);
                                zzawp = new zzawp(z3, zzg2, bArr);
                            } else {
                                i5 += zze5;
                            }
                        }
                        zzawp2 = zzawp;
                    }
                    i4 += zze3;
                }
                if (z2) {
                    zzbac.zzd(num != null, "frma atom is mandatory");
                    if (zzawp2 != null) {
                        z = true;
                    }
                    zzbac.zzd(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzawp2);
                }
                if (pair != null) {
                    zzavz.zza[i3] = (zzawp) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            zzavz zzavz2 = zzavz;
            zzc2 += zze2;
        }
    }

    private static Pair zzf(zzbak zzbak, int i) {
        zzbak.zzv(i + 12);
        zzbak.zzw(1);
        zzd(zzbak);
        zzbak.zzw(2);
        int zzg2 = zzbak.zzg();
        if ((zzg2 & 128) != 0) {
            zzbak.zzw(2);
        }
        if ((zzg2 & 64) != 0) {
            zzbak.zzw(zzbak.zzj());
        }
        if ((zzg2 & 32) != 0) {
            zzbak.zzw(2);
        }
        zzbak.zzw(1);
        zzd(zzbak);
        int zzg3 = zzbak.zzg();
        String str = null;
        if (zzg3 == 32) {
            str = MimeTypes.VIDEO_MP4V;
        } else if (zzg3 == 33) {
            str = "video/avc";
        } else if (zzg3 != 35) {
            if (zzg3 != 64) {
                if (zzg3 == 107) {
                    return Pair.create(MimeTypes.AUDIO_MPEG, (Object) null);
                }
                if (zzg3 == 165) {
                    str = MimeTypes.AUDIO_AC3;
                } else if (zzg3 != 166) {
                    switch (zzg3) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (zzg3) {
                                case 169:
                                case 172:
                                    return Pair.create(MimeTypes.AUDIO_DTS, (Object) null);
                                case 170:
                                case 171:
                                    return Pair.create(MimeTypes.AUDIO_DTS_HD, (Object) null);
                            }
                    }
                } else {
                    str = MimeTypes.AUDIO_E_AC3;
                }
            }
            str = MimeTypes.AUDIO_AAC;
        } else {
            str = "video/hevc";
        }
        zzbak.zzw(12);
        zzbak.zzw(1);
        int zzd2 = zzd(zzbak);
        byte[] bArr = new byte[zzd2];
        zzbak.zzq(bArr, 0, zzd2);
        return Pair.create(str, bArr);
    }
}
