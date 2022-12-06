package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.firebase.FirebaseError;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaei implements zzzi {
    public static final zzzp zza = zzaee.zza;
    private static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final byte[] zzc = zzen.zzaa("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] zzd = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] zze = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final UUID zzf = new UUID(72057594037932032L, -9223371306706625679L);
    /* access modifiers changed from: private */
    public static final Map zzg;
    private long zzA;
    private zzaeh zzB;
    private boolean zzC;
    private int zzD;
    private long zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private long zzI;
    private zzdx zzJ;
    private zzdx zzK;
    private boolean zzL;
    private boolean zzM;
    private int zzN;
    private long zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private int[] zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private int zzZ;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private int zzaf;
    private byte zzag;
    private boolean zzah;
    private zzzl zzai;
    private final zzaed zzh;
    private final zzaek zzi;
    private final SparseArray zzj;
    private final boolean zzk;
    private final zzef zzl;
    private final zzef zzm;
    private final zzef zzn;
    private final zzef zzo;
    private final zzef zzp;
    private final zzef zzq;
    private final zzef zzr;
    private final zzef zzs;
    private final zzef zzt;
    private final zzef zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(hashMap);
    }

    public zzaei() {
        this(0);
    }

    protected static final int zzn(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /*134*/:
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected static final boolean zzo(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @RequiresNonNull({"#2.output"})
    private final int zzp(zzzj zzzj, zzaeh zzaeh, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzaeh.zzb)) {
            zzx(zzzj, zzb, i);
            int i3 = this.zzaa;
            zzw();
            return i3;
        } else if ("S_TEXT/ASS".equals(zzaeh.zzb)) {
            zzx(zzzj, zzd, i);
            int i4 = this.zzaa;
            zzw();
            return i4;
        } else if ("S_TEXT/WEBVTT".equals(zzaeh.zzb)) {
            zzx(zzzj, zze, i);
            int i5 = this.zzaa;
            zzw();
            return i5;
        } else {
            zzaap zzaap = zzaeh.zzV;
            boolean z2 = true;
            if (!this.zzac) {
                if (zzaeh.zzg) {
                    this.zzV &= -1073741825;
                    int i6 = 128;
                    if (!this.zzad) {
                        ((zzyy) zzzj).zzn(this.zzn.zzH(), 0, 1, false);
                        this.zzZ++;
                        if ((this.zzn.zzH()[0] & ByteCompanionObject.MIN_VALUE) != 128) {
                            this.zzag = this.zzn.zzH()[0];
                            this.zzad = true;
                        } else {
                            throw zzbu.zza("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b = this.zzag;
                    if ((b & 1) == 1) {
                        byte b2 = b & 2;
                        this.zzV |= 1073741824;
                        if (!this.zzah) {
                            ((zzyy) zzzj).zzn(this.zzs.zzH(), 0, 8, false);
                            this.zzZ += 8;
                            this.zzah = true;
                            byte[] zzH2 = this.zzn.zzH();
                            if (b2 != 2) {
                                i6 = 0;
                            }
                            zzH2[0] = (byte) (i6 | 8);
                            this.zzn.zzF(0);
                            zzaap.zzr(this.zzn, 1, 1);
                            this.zzaa++;
                            this.zzs.zzF(0);
                            zzaap.zzr(this.zzs, 8, 1);
                            this.zzaa += 8;
                        }
                        if (b2 == 2) {
                            if (!this.zzae) {
                                ((zzyy) zzzj).zzn(this.zzn.zzH(), 0, 1, false);
                                this.zzZ++;
                                this.zzn.zzF(0);
                                this.zzaf = this.zzn.zzk();
                                this.zzae = true;
                            }
                            int i7 = this.zzaf * 4;
                            this.zzn.zzC(i7);
                            ((zzyy) zzzj).zzn(this.zzn.zzH(), 0, i7, false);
                            this.zzZ += i7;
                            int i8 = (this.zzaf >> 1) + 1;
                            int i9 = (i8 * 6) + 2;
                            ByteBuffer byteBuffer = this.zzv;
                            if (byteBuffer == null || byteBuffer.capacity() < i9) {
                                this.zzv = ByteBuffer.allocate(i9);
                            }
                            this.zzv.position(0);
                            this.zzv.putShort((short) i8);
                            int i10 = 0;
                            int i11 = 0;
                            while (true) {
                                i2 = this.zzaf;
                                if (i10 >= i2) {
                                    break;
                                }
                                int zzn2 = this.zzn.zzn();
                                if (i10 % 2 == 0) {
                                    this.zzv.putShort((short) (zzn2 - i11));
                                } else {
                                    this.zzv.putInt(zzn2 - i11);
                                }
                                i10++;
                                i11 = zzn2;
                            }
                            int i12 = (i - this.zzZ) - i11;
                            if ((i2 & 1) == 1) {
                                this.zzv.putInt(i12);
                            } else {
                                this.zzv.putShort((short) i12);
                                this.zzv.putInt(0);
                            }
                            this.zzt.zzD(this.zzv.array(), i9);
                            zzaap.zzr(this.zzt, i9, 1);
                            this.zzaa += i9;
                        }
                    }
                } else {
                    byte[] bArr = zzaeh.zzh;
                    if (bArr != null) {
                        this.zzq.zzD(bArr, bArr.length);
                    }
                }
                if (!"A_OPUS".equals(zzaeh.zzb) ? zzaeh.zzf > 0 : z) {
                    this.zzV |= 268435456;
                    this.zzu.zzC(0);
                    int zzd2 = (this.zzq.zzd() + i) - this.zzZ;
                    this.zzn.zzC(4);
                    this.zzn.zzH()[0] = (byte) ((zzd2 >> 24) & 255);
                    this.zzn.zzH()[1] = (byte) ((zzd2 >> 16) & 255);
                    this.zzn.zzH()[2] = (byte) ((zzd2 >> 8) & 255);
                    this.zzn.zzH()[3] = (byte) (zzd2 & 255);
                    zzaap.zzr(this.zzn, 4, 2);
                    this.zzaa += 4;
                }
                this.zzac = true;
            }
            int zzd3 = i + this.zzq.zzd();
            if (!"V_MPEG4/ISO/AVC".equals(zzaeh.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzaeh.zzb)) {
                if (zzaeh.zzS != null) {
                    if (this.zzq.zzd() != 0) {
                        z2 = false;
                    }
                    zzdd.zzf(z2);
                    zzaeh.zzS.zzd(zzzj);
                }
                while (true) {
                    int i13 = this.zzZ;
                    if (i13 >= zzd3) {
                        break;
                    }
                    int zzq2 = zzq(zzzj, zzaap, zzd3 - i13);
                    this.zzZ += zzq2;
                    this.zzaa += zzq2;
                }
            } else {
                byte[] zzH3 = this.zzm.zzH();
                zzH3[0] = 0;
                zzH3[1] = 0;
                zzH3[2] = 0;
                int i14 = zzaeh.zzW;
                int i15 = 4 - i14;
                while (this.zzZ < zzd3) {
                    int i16 = this.zzab;
                    if (i16 == 0) {
                        int min = Math.min(i14, this.zzq.zza());
                        ((zzyy) zzzj).zzn(zzH3, i15 + min, i14 - min, false);
                        if (min > 0) {
                            this.zzq.zzB(zzH3, i15, min);
                        }
                        this.zzZ += i14;
                        this.zzm.zzF(0);
                        this.zzab = this.zzm.zzn();
                        this.zzl.zzF(0);
                        zzaan.zzb(zzaap, this.zzl, 4);
                        this.zzaa += 4;
                    } else {
                        int zzq3 = zzq(zzzj, zzaap, i16);
                        this.zzZ += zzq3;
                        this.zzaa += zzq3;
                        this.zzab -= zzq3;
                    }
                }
            }
            if ("A_VORBIS".equals(zzaeh.zzb)) {
                this.zzo.zzF(0);
                zzaan.zzb(zzaap, this.zzo, 4);
                this.zzaa += 4;
            }
            int i17 = this.zzaa;
            zzw();
            return i17;
        }
    }

    private final int zzq(zzzj zzzj, zzaap zzaap, int i) throws IOException {
        int zza2 = this.zzq.zza();
        if (zza2 <= 0) {
            return zzaan.zza(zzaap, zzzj, i, false);
        }
        int min = Math.min(i, zza2);
        zzaan.zzb(zzaap, this.zzq, min);
        return min;
    }

    private final long zzr(long j) throws zzbu {
        long j2 = this.zzy;
        if (j2 != C.TIME_UNSET) {
            return zzen.zzw(j, j2, 1000);
        }
        throw zzbu.zza("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzs(int i) throws zzbu {
        if (this.zzJ == null || this.zzK == null) {
            throw zzbu.zza("Element " + i + " must be in a Cues", (Throwable) null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzt(int i) throws zzbu {
        if (this.zzB == null) {
            throw zzbu.zza("Element " + i + " must be in a TrackEntry", (Throwable) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0 A[EDGE_INSN: B:59:0x00e0->B:48:0x00e0 ?: BREAK  , SYNTHETIC] */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzu(com.google.android.gms.internal.ads.zzaeh r18, long r19, int r21, int r22, int r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.google.android.gms.internal.ads.zzaaq r2 = r1.zzS
            r9 = 1
            if (r2 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzaap r3 = r1.zzV
            com.google.android.gms.internal.ads.zzaao r8 = r1.zzi
            r1 = r2
            r2 = r3
            r3 = r19
            r5 = r21
            r6 = r22
            r7 = r23
            r1.zzc(r2, r3, r5, r6, r7, r8)
            goto L_0x0121
        L_0x001c:
            java.lang.String r2 = r1.zzb
            java.lang.String r3 = "S_TEXT/UTF8"
            boolean r2 = r3.equals(r2)
            java.lang.String r4 = "S_TEXT/WEBVTT"
            java.lang.String r5 = "S_TEXT/ASS"
            r6 = 0
            r7 = 2
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0058
        L_0x003c:
            int r2 = r0.zzR
            java.lang.String r8 = "MatroskaExtractor"
            if (r2 <= r9) goto L_0x0048
            java.lang.String r2 = "Skipping subtitle sample in laced block."
            com.google.android.gms.internal.ads.zzdw.zze(r8, r2)
            goto L_0x0058
        L_0x0048:
            long r10 = r0.zzP
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x005c
            java.lang.String r2 = "Skipping subtitle sample with no duration."
            com.google.android.gms.internal.ads.zzdw.zze(r8, r2)
        L_0x0058:
            r2 = r22
            goto L_0x00f3
        L_0x005c:
            java.lang.String r2 = r1.zzb
            com.google.android.gms.internal.ads.zzef r8 = r0.zzr
            byte[] r8 = r8.zzH()
            int r12 = r2.hashCode()
            r13 = 738597099(0x2c0618eb, float:1.9056378E-12)
            if (r12 == r13) goto L_0x0088
            r5 = 1045209816(0x3e4ca2d8, float:0.19983995)
            if (r12 == r5) goto L_0x0080
            r4 = 1422270023(0x54c61e47, float:6.807292E12)
            if (r12 == r4) goto L_0x0078
            goto L_0x0090
        L_0x0078:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0090
            r2 = r6
            goto L_0x0091
        L_0x0080:
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0090
            r2 = r7
            goto L_0x0091
        L_0x0088:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0090
            r2 = r9
            goto L_0x0091
        L_0x0090:
            r2 = -1
        L_0x0091:
            r3 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x00b3
            if (r2 == r9) goto L_0x00a8
            if (r2 != r7) goto L_0x00a2
            java.lang.String r2 = "%02d:%02d:%02d.%03d"
            byte[] r2 = zzy(r10, r2, r3)
            r3 = 25
            goto L_0x00bb
        L_0x00a2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x00a8:
            r2 = 10000(0x2710, double:4.9407E-320)
            java.lang.String r4 = "%01d:%02d:%02d:%02d"
            byte[] r2 = zzy(r10, r4, r2)
            r3 = 21
            goto L_0x00bb
        L_0x00b3:
            java.lang.String r2 = "%02d:%02d:%02d,%03d"
            byte[] r2 = zzy(r10, r2, r3)
            r3 = 19
        L_0x00bb:
            int r4 = r2.length
            java.lang.System.arraycopy(r2, r6, r8, r3, r4)
            com.google.android.gms.internal.ads.zzef r2 = r0.zzr
            int r2 = r2.zzc()
        L_0x00c5:
            com.google.android.gms.internal.ads.zzef r3 = r0.zzr
            int r3 = r3.zzd()
            if (r2 >= r3) goto L_0x00e0
            com.google.android.gms.internal.ads.zzef r3 = r0.zzr
            byte[] r3 = r3.zzH()
            byte r3 = r3[r2]
            if (r3 != 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzef r3 = r0.zzr
            r3.zzE(r2)
            goto L_0x00e0
        L_0x00dd:
            int r2 = r2 + 1
            goto L_0x00c5
        L_0x00e0:
            com.google.android.gms.internal.ads.zzaap r2 = r1.zzV
            com.google.android.gms.internal.ads.zzef r3 = r0.zzr
            int r4 = r3.zzd()
            com.google.android.gms.internal.ads.zzaan.zzb(r2, r3, r4)
            com.google.android.gms.internal.ads.zzef r2 = r0.zzr
            int r2 = r2.zzd()
            int r2 = r22 + r2
        L_0x00f3:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r21 & r3
            if (r3 == 0) goto L_0x0111
            int r3 = r0.zzR
            if (r3 <= r9) goto L_0x0103
            com.google.android.gms.internal.ads.zzef r3 = r0.zzu
            r3.zzC(r6)
            goto L_0x0111
        L_0x0103:
            com.google.android.gms.internal.ads.zzef r3 = r0.zzu
            int r3 = r3.zzd()
            com.google.android.gms.internal.ads.zzaap r4 = r1.zzV
            com.google.android.gms.internal.ads.zzef r5 = r0.zzu
            r4.zzr(r5, r3, r7)
            int r2 = r2 + r3
        L_0x0111:
            r14 = r2
            com.google.android.gms.internal.ads.zzaap r10 = r1.zzV
            com.google.android.gms.internal.ads.zzaao r1 = r1.zzi
            r11 = r19
            r13 = r21
            r15 = r23
            r16 = r1
            r10.zzs(r11, r13, r14, r15, r16)
        L_0x0121:
            r0.zzM = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaei.zzu(com.google.android.gms.internal.ads.zzaeh, long, int, int, int):void");
    }

    private final void zzv(zzzj zzzj, int i) throws IOException {
        if (this.zzn.zzd() < i) {
            if (this.zzn.zzb() < i) {
                zzef zzef = this.zzn;
                int zzb2 = zzef.zzb();
                zzef.zzz(Math.max(zzb2 + zzb2, i));
            }
            ((zzyy) zzzj).zzn(this.zzn.zzH(), this.zzn.zzd(), i - this.zzn.zzd(), false);
            this.zzn.zzE(i);
        }
    }

    private final void zzw() {
        this.zzZ = 0;
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = false;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = 0;
        this.zzag = 0;
        this.zzah = false;
        this.zzq.zzC(0);
    }

    private final void zzx(zzzj zzzj, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.zzr.zzb() < i2) {
            zzef zzef = this.zzr;
            byte[] copyOf = Arrays.copyOf(bArr, i2 + i);
            zzef.zzD(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzr.zzH(), 0, length);
        }
        ((zzyy) zzzj).zzn(this.zzr.zzH(), length, i, false);
        this.zzr.zzF(0);
        this.zzr.zzE(i2);
    }

    private static byte[] zzy(long j, String str, long j2) {
        zzdd.zzd(j != C.TIME_UNSET);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        return zzen.zzaa(String.format(Locale.US, str, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))}));
    }

    private static int[] zzz(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        this.zzM = false;
        while (!this.zzM) {
            if (this.zzh.zzc(zzzj)) {
                long zzf2 = zzzj.zzf();
                if (this.zzF) {
                    this.zzH = zzf2;
                    zzaai.zza = this.zzG;
                    this.zzF = false;
                    return 1;
                } else if (this.zzC) {
                    long j = this.zzH;
                    if (j != -1) {
                        zzaai.zza = j;
                        this.zzH = -1;
                        return 1;
                    }
                }
            } else {
                for (int i = 0; i < this.zzj.size(); i++) {
                    zzaeh zzaeh = (zzaeh) this.zzj.valueAt(i);
                    zzaeh.zzd(zzaeh);
                    zzaaq zzaaq = zzaeh.zzS;
                    if (zzaaq != null) {
                        zzaaq.zza(zzaeh.zzV, zzaeh.zzi);
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    public final void zzb(zzzl zzzl) {
        this.zzai = zzzl;
    }

    public final void zzc(long j, long j2) {
        this.zzI = C.TIME_UNSET;
        this.zzN = 0;
        this.zzh.zzb();
        this.zzi.zze();
        zzw();
        for (int i = 0; i < this.zzj.size(); i++) {
            zzaaq zzaaq = ((zzaeh) this.zzj.valueAt(i)).zzS;
            if (zzaaq != null) {
                zzaaq.zzb();
            }
        }
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        return new zzaej().zza(zzzj);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01e8, code lost:
        if (r1.equals("V_MPEGH/ISO/HEVC") != false) goto L_0x0315;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(int r21) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r20 = this;
            r7 = r20
            r0 = r21
            com.google.android.gms.internal.ads.zzzl r1 = r7.zzai
            com.google.android.gms.internal.ads.zzdd.zzb(r1)
            r1 = 160(0xa0, float:2.24E-43)
            r2 = 8
            java.lang.String r3 = "A_OPUS"
            r4 = 2
            r5 = 0
            if (r0 == r1) goto L_0x0331
            r1 = 174(0xae, float:2.44E-43)
            r10 = -1
            r11 = 0
            if (r0 == r1) goto L_0x018b
            r1 = 19899(0x4dbb, float:2.7884E-41)
            r2 = -1
            r4 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r0 == r1) goto L_0x0175
            r1 = 25152(0x6240, float:3.5245E-41)
            if (r0 == r1) goto L_0x0144
            r1 = 28032(0x6d80, float:3.9281E-41)
            if (r0 == r1) goto L_0x012f
            r1 = 357149030(0x1549a966, float:4.072526E-26)
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == r1) goto L_0x0117
            r1 = 374648427(0x1654ae6b, float:1.718026E-25)
            if (r0 == r1) goto L_0x0102
            if (r0 == r4) goto L_0x003e
            goto L_0x0183
        L_0x003e:
            boolean r0 = r7.zzC
            if (r0 != 0) goto L_0x00fd
            com.google.android.gms.internal.ads.zzzl r0 = r7.zzai
            com.google.android.gms.internal.ads.zzdx r1 = r7.zzJ
            com.google.android.gms.internal.ads.zzdx r4 = r7.zzK
            long r14 = r7.zzx
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00f0
            long r2 = r7.zzA
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x00f0
            if (r1 == 0) goto L_0x00f0
            int r2 = r1.zza()
            if (r2 == 0) goto L_0x00f0
            if (r4 == 0) goto L_0x00f0
            int r2 = r4.zza()
            int r3 = r1.zza()
            if (r2 == r3) goto L_0x006a
            goto L_0x00f0
        L_0x006a:
            int r2 = r1.zza()
            int[] r3 = new int[r2]
            long[] r12 = new long[r2]
            long[] r13 = new long[r2]
            long[] r14 = new long[r2]
            r15 = 0
        L_0x0077:
            if (r15 >= r2) goto L_0x008c
            long r16 = r1.zzb(r15)
            r14[r15] = r16
            long r8 = r7.zzx
            long r18 = r4.zzb(r15)
            long r8 = r8 + r18
            r12[r15] = r8
            int r15 = r15 + 1
            goto L_0x0077
        L_0x008c:
            r1 = 0
        L_0x008d:
            int r4 = r2 + -1
            if (r1 >= r4) goto L_0x00a6
            int r4 = r1 + 1
            r8 = r12[r4]
            r17 = r12[r1]
            long r8 = r8 - r17
            int r8 = (int) r8
            r3[r1] = r8
            r8 = r14[r4]
            r17 = r14[r1]
            long r8 = r8 - r17
            r13[r1] = r8
            r1 = r4
            goto L_0x008d
        L_0x00a6:
            long r1 = r7.zzx
            long r8 = r7.zzw
            long r1 = r1 + r8
            r8 = r12[r4]
            long r1 = r1 - r8
            int r1 = (int) r1
            r3[r4] = r1
            long r1 = r7.zzA
            r8 = r14[r4]
            long r1 = r1 - r8
            r13[r4] = r1
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x00ea
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Discarding last cue point with unexpected duration: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.String r2 = "MatroskaExtractor"
            com.google.android.gms.internal.ads.zzdw.zze(r2, r1)
            int r1 = r3.length
            int r1 = r1 + r10
            int[] r3 = java.util.Arrays.copyOf(r3, r1)
            int r1 = r12.length
            int r1 = r1 + r10
            long[] r12 = java.util.Arrays.copyOf(r12, r1)
            int r1 = r13.length
            int r1 = r1 + r10
            long[] r13 = java.util.Arrays.copyOf(r13, r1)
            int r1 = r14.length
            int r1 = r1 + r10
            long[] r14 = java.util.Arrays.copyOf(r14, r1)
        L_0x00ea:
            com.google.android.gms.internal.ads.zzyw r1 = new com.google.android.gms.internal.ads.zzyw
            r1.<init>(r3, r12, r13, r14)
            goto L_0x00f7
        L_0x00f0:
            com.google.android.gms.internal.ads.zzaak r1 = new com.google.android.gms.internal.ads.zzaak
            long r2 = r7.zzA
            r1.<init>(r2, r5)
        L_0x00f7:
            r0.zzN(r1)
            r0 = 1
            r7.zzC = r0
        L_0x00fd:
            r7.zzJ = r11
            r7.zzK = r11
            return
        L_0x0102:
            android.util.SparseArray r0 = r7.zzj
            int r0 = r0.size()
            if (r0 == 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzzl r0 = r7.zzai
            r0.zzC()
            return
        L_0x0110:
            java.lang.String r0 = "No valid tracks were found"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r11)
            throw r0
        L_0x0117:
            long r0 = r7.zzy
            int r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0122
            r0 = 1000000(0xf4240, double:4.940656E-318)
            r7.zzy = r0
        L_0x0122:
            long r0 = r7.zzz
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x0183
            long r0 = r7.zzr(r0)
            r7.zzA = r0
            return
        L_0x012f:
            r20.zzt(r21)
            com.google.android.gms.internal.ads.zzaeh r0 = r7.zzB
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x0183
            byte[] r0 = r0.zzh
            if (r0 != 0) goto L_0x013d
            goto L_0x0183
        L_0x013d:
            java.lang.String r0 = "Combining encryption and compression is not supported"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r11)
            throw r0
        L_0x0144:
            r20.zzt(r21)
            com.google.android.gms.internal.ads.zzaeh r0 = r7.zzB
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x0183
            com.google.android.gms.internal.ads.zzaao r1 = r0.zzi
            if (r1 == 0) goto L_0x016e
            com.google.android.gms.internal.ads.zzx r1 = new com.google.android.gms.internal.ads.zzx
            r2 = 1
            com.google.android.gms.internal.ads.zzw[] r2 = new com.google.android.gms.internal.ads.zzw[r2]
            com.google.android.gms.internal.ads.zzw r3 = new com.google.android.gms.internal.ads.zzw
            java.util.UUID r4 = com.google.android.gms.internal.ads.zzo.zza
            com.google.android.gms.internal.ads.zzaeh r5 = r7.zzB
            com.google.android.gms.internal.ads.zzaao r5 = r5.zzi
            byte[] r5 = r5.zzb
            java.lang.String r6 = "video/webm"
            r3.<init>(r4, r11, r6, r5)
            r4 = 0
            r2[r4] = r3
            r1.<init>(r11, r2)
            r0.zzk = r1
            return
        L_0x016e:
            java.lang.String r0 = "Encrypted Track found but ContentEncKeyID was not found"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r11)
            throw r0
        L_0x0175:
            int r0 = r7.zzD
            if (r0 == r10) goto L_0x0184
            long r5 = r7.zzE
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0184
            if (r0 != r4) goto L_0x0183
            r7.zzG = r5
        L_0x0183:
            return
        L_0x0184:
            java.lang.String r0 = "Mandatory element SeekID or SeekPosition not found"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r11)
            throw r0
        L_0x018b:
            com.google.android.gms.internal.ads.zzaeh r0 = r7.zzB
            com.google.android.gms.internal.ads.zzdd.zzb(r0)
            java.lang.String r1 = r0.zzb
            if (r1 == 0) goto L_0x032a
            int r5 = r1.hashCode()
            switch(r5) {
                case -2095576542: goto L_0x030a;
                case -2095575984: goto L_0x0300;
                case -1985379776: goto L_0x02f5;
                case -1784763192: goto L_0x02ea;
                case -1730367663: goto L_0x02df;
                case -1482641358: goto L_0x02d4;
                case -1482641357: goto L_0x02c9;
                case -1373388978: goto L_0x02be;
                case -933872740: goto L_0x02b3;
                case -538363189: goto L_0x02a8;
                case -538363109: goto L_0x029d;
                case -425012669: goto L_0x0291;
                case -356037306: goto L_0x0285;
                case 62923557: goto L_0x0279;
                case 62923603: goto L_0x026d;
                case 62927045: goto L_0x0261;
                case 82318131: goto L_0x0256;
                case 82338133: goto L_0x024b;
                case 82338134: goto L_0x0240;
                case 99146302: goto L_0x0234;
                case 444813526: goto L_0x0228;
                case 542569478: goto L_0x021c;
                case 635596514: goto L_0x0210;
                case 725948237: goto L_0x0204;
                case 725957860: goto L_0x01f8;
                case 738597099: goto L_0x01ec;
                case 855502857: goto L_0x01e2;
                case 1045209816: goto L_0x01d6;
                case 1422270023: goto L_0x01ca;
                case 1809237540: goto L_0x01bf;
                case 1950749482: goto L_0x01b3;
                case 1950789798: goto L_0x01a7;
                case 1951062397: goto L_0x019d;
                default: goto L_0x019b;
            }
        L_0x019b:
            goto L_0x0314
        L_0x019d:
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0314
            r2 = 11
            goto L_0x0315
        L_0x01a7:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 22
            goto L_0x0315
        L_0x01b3:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 17
            goto L_0x0315
        L_0x01bf:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 3
            goto L_0x0315
        L_0x01ca:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 27
            goto L_0x0315
        L_0x01d6:
            java.lang.String r2 = "S_TEXT/WEBVTT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 29
            goto L_0x0315
        L_0x01e2:
            java.lang.String r3 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0314
            goto L_0x0315
        L_0x01ec:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 28
            goto L_0x0315
        L_0x01f8:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 24
            goto L_0x0315
        L_0x0204:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 25
            goto L_0x0315
        L_0x0210:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 26
            goto L_0x0315
        L_0x021c:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 20
            goto L_0x0315
        L_0x0228:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 10
            goto L_0x0315
        L_0x0234:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 31
            goto L_0x0315
        L_0x0240:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 1
            goto L_0x0315
        L_0x024b:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 0
            goto L_0x0315
        L_0x0256:
            java.lang.String r2 = "V_AV1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = r4
            goto L_0x0315
        L_0x0261:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 19
            goto L_0x0315
        L_0x026d:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 16
            goto L_0x0315
        L_0x0279:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 13
            goto L_0x0315
        L_0x0285:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 21
            goto L_0x0315
        L_0x0291:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 30
            goto L_0x0315
        L_0x029d:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 7
            goto L_0x0315
        L_0x02a8:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 5
            goto L_0x0315
        L_0x02b3:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 32
            goto L_0x0315
        L_0x02be:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 9
            goto L_0x0315
        L_0x02c9:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 15
            goto L_0x0315
        L_0x02d4:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 14
            goto L_0x0315
        L_0x02df:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 12
            goto L_0x0315
        L_0x02ea:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 18
            goto L_0x0315
        L_0x02f5:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 23
            goto L_0x0315
        L_0x0300:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 4
            goto L_0x0315
        L_0x030a:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            r2 = 6
            goto L_0x0315
        L_0x0314:
            r2 = r10
        L_0x0315:
            switch(r2) {
                case 0: goto L_0x0319;
                case 1: goto L_0x0319;
                case 2: goto L_0x0319;
                case 3: goto L_0x0319;
                case 4: goto L_0x0319;
                case 5: goto L_0x0319;
                case 6: goto L_0x0319;
                case 7: goto L_0x0319;
                case 8: goto L_0x0319;
                case 9: goto L_0x0319;
                case 10: goto L_0x0319;
                case 11: goto L_0x0319;
                case 12: goto L_0x0319;
                case 13: goto L_0x0319;
                case 14: goto L_0x0319;
                case 15: goto L_0x0319;
                case 16: goto L_0x0319;
                case 17: goto L_0x0319;
                case 18: goto L_0x0319;
                case 19: goto L_0x0319;
                case 20: goto L_0x0319;
                case 21: goto L_0x0319;
                case 22: goto L_0x0319;
                case 23: goto L_0x0319;
                case 24: goto L_0x0319;
                case 25: goto L_0x0319;
                case 26: goto L_0x0319;
                case 27: goto L_0x0319;
                case 28: goto L_0x0319;
                case 29: goto L_0x0319;
                case 30: goto L_0x0319;
                case 31: goto L_0x0319;
                case 32: goto L_0x0319;
                default: goto L_0x0318;
            }
        L_0x0318:
            goto L_0x0327
        L_0x0319:
            com.google.android.gms.internal.ads.zzzl r1 = r7.zzai
            int r2 = r0.zzc
            r0.zze(r1, r2)
            android.util.SparseArray r1 = r7.zzj
            int r2 = r0.zzc
            r1.put(r2, r0)
        L_0x0327:
            r7.zzB = r11
            return
        L_0x032a:
            java.lang.String r0 = "CodecId is missing in TrackEntry element"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r11)
            throw r0
        L_0x0331:
            int r0 = r7.zzN
            if (r0 == r4) goto L_0x0336
            return
        L_0x0336:
            android.util.SparseArray r0 = r7.zzj
            int r1 = r7.zzT
            java.lang.Object r0 = r0.get(r1)
            r8 = r0
            com.google.android.gms.internal.ads.zzaeh r8 = (com.google.android.gms.internal.ads.zzaeh) r8
            com.google.android.gms.internal.ads.zzaeh.zzd(r8)
            long r0 = r7.zzY
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x036c
            java.lang.String r0 = r8.zzb
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x036c
            com.google.android.gms.internal.ads.zzef r0 = r7.zzu
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r1 = r1.order(r2)
            long r2 = r7.zzY
            java.nio.ByteBuffer r1 = r1.putLong(r2)
            byte[] r1 = r1.array()
            int r2 = r1.length
            r0.zzD(r1, r2)
        L_0x036c:
            r0 = 0
            r1 = 0
        L_0x036e:
            int r2 = r7.zzR
            if (r0 >= r2) goto L_0x037a
            int[] r2 = r7.zzS
            r2 = r2[r0]
            int r1 = r1 + r2
            int r0 = r0 + 1
            goto L_0x036e
        L_0x037a:
            r9 = 0
        L_0x037b:
            int r0 = r7.zzR
            if (r9 >= r0) goto L_0x03a7
            long r2 = r7.zzO
            int r0 = r8.zze
            int r0 = r0 * r9
            int r0 = r0 / 1000
            long r4 = (long) r0
            long r2 = r2 + r4
            int r0 = r7.zzV
            if (r9 != 0) goto L_0x0395
            boolean r4 = r7.zzX
            if (r4 != 0) goto L_0x0392
            r0 = r0 | 1
        L_0x0392:
            r4 = r0
            r9 = 0
            goto L_0x0396
        L_0x0395:
            r4 = r0
        L_0x0396:
            int[] r0 = r7.zzS
            r5 = r0[r9]
            int r10 = r1 - r5
            r0 = r20
            r1 = r8
            r6 = r10
            r0.zzu(r1, r2, r4, r5, r6)
            r0 = 1
            int r9 = r9 + r0
            r1 = r10
            goto L_0x037b
        L_0x03a7:
            r1 = 0
            r7.zzN = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaei.zzh(int):void");
    }

    /* access modifiers changed from: protected */
    public final void zzk(int i, long j, long j2) throws zzbu {
        zzdd.zzb(this.zzai);
        if (i == 160) {
            this.zzX = false;
            this.zzY = 0;
        } else if (i == 174) {
            this.zzB = new zzaeh();
        } else if (i == 187) {
            this.zzL = false;
        } else if (i == 19899) {
            this.zzD = -1;
            this.zzE = -1;
        } else if (i == 20533) {
            zzt(i);
            this.zzB.zzg = true;
        } else if (i == 21968) {
            zzt(i);
            this.zzB.zzw = true;
        } else if (i == 408125543) {
            long j3 = this.zzx;
            if (j3 == -1 || j3 == j) {
                this.zzx = j;
                this.zzw = j2;
                return;
            }
            throw zzbu.zza("Multiple Segment elements not supported", (Throwable) null);
        } else if (i == 475249515) {
            this.zzJ = new zzdx(32);
            this.zzK = new zzdx(32);
        } else if (i != 524531317 || this.zzC) {
        } else {
            if (!this.zzk || this.zzG == -1) {
                this.zzai.zzN(new zzaak(this.zzA, 0));
                this.zzC = true;
                return;
            }
            this.zzF = true;
        }
    }

    public zzaei(int i) {
        zzaeb zzaeb = new zzaeb();
        this.zzx = -1;
        this.zzy = C.TIME_UNSET;
        this.zzz = C.TIME_UNSET;
        this.zzA = C.TIME_UNSET;
        this.zzG = -1;
        this.zzH = -1;
        this.zzI = C.TIME_UNSET;
        this.zzh = zzaeb;
        this.zzh.zza(new zzaeg(this, (zzaef) null));
        this.zzk = true;
        this.zzi = new zzaek();
        this.zzj = new SparseArray();
        this.zzn = new zzef(4);
        this.zzo = new zzef(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzef(4);
        this.zzl = new zzef(zzaaf.zza);
        this.zzm = new zzef(4);
        this.zzq = new zzef();
        this.zzr = new zzef();
        this.zzs = new zzef(8);
        this.zzt = new zzef();
        this.zzu = new zzef();
        this.zzS = new int[1];
    }

    /* access modifiers changed from: protected */
    public final void zzl(int i, String str) throws zzbu {
        if (i == 134) {
            zzt(i);
            this.zzB.zzb = str;
        } else if (i != 17026) {
            if (i == 21358) {
                zzt(i);
                this.zzB.zza = str;
            } else if (i == 2274716) {
                zzt(i);
                this.zzB.zzY = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw zzbu.zza("DocType " + str + " not supported", (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0299, code lost:
        throw com.google.android.gms.internal.ads.zzbu.zza("EBML lacing sample size out of range.", (java.lang.Throwable) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(int r19, int r20, com.google.android.gms.internal.ads.zzzj r21) throws java.io.IOException {
        /*
            r18 = this;
            r7 = r18
            r0 = r19
            r1 = r20
            r8 = r21
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 0
            r4 = 4
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            if (r0 == r2) goto L_0x0119
            if (r0 == r5) goto L_0x0119
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L_0x00e3
            r2 = 16877(0x41ed, float:2.365E-41)
            if (r0 == r2) goto L_0x00b7
            r2 = 16981(0x4255, float:2.3795E-41)
            if (r0 == r2) goto L_0x00a5
            r2 = 18402(0x47e2, float:2.5787E-41)
            if (r0 == r2) goto L_0x0090
            r2 = 21419(0x53ab, float:3.0014E-41)
            if (r0 == r2) goto L_0x006b
            r2 = 25506(0x63a2, float:3.5742E-41)
            if (r0 == r2) goto L_0x0059
            r2 = 30322(0x7672, float:4.249E-41)
            if (r0 != r2) goto L_0x0043
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaeh r0 = r7.zzB
            byte[] r2 = new byte[r1]
            r0.zzu = r2
            byte[] r0 = r0.zzu
            r2 = r8
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x0043:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected id: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r3)
            throw r0
        L_0x0059:
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaeh r0 = r7.zzB
            byte[] r2 = new byte[r1]
            r0.zzj = r2
            byte[] r0 = r0.zzj
            r2 = r8
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x006b:
            com.google.android.gms.internal.ads.zzef r0 = r7.zzp
            byte[] r0 = r0.zzH()
            java.util.Arrays.fill(r0, r10)
            com.google.android.gms.internal.ads.zzef r0 = r7.zzp
            byte[] r0 = r0.zzH()
            r2 = r8
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            int r4 = r4 - r1
            r2.zzn(r0, r4, r1, r10)
            com.google.android.gms.internal.ads.zzef r0 = r7.zzp
            r0.zzF(r10)
            com.google.android.gms.internal.ads.zzef r0 = r7.zzp
            long r0 = r0.zzs()
            int r0 = (int) r0
            r7.zzD = r0
            return
        L_0x0090:
            byte[] r2 = new byte[r1]
            r3 = r8
            com.google.android.gms.internal.ads.zzyy r3 = (com.google.android.gms.internal.ads.zzyy) r3
            r3.zzn(r2, r10, r1, r10)
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaeh r0 = r7.zzB
            com.google.android.gms.internal.ads.zzaao r1 = new com.google.android.gms.internal.ads.zzaao
            r1.<init>(r9, r2, r10, r10)
            r0.zzi = r1
            return
        L_0x00a5:
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaeh r0 = r7.zzB
            byte[] r2 = new byte[r1]
            r0.zzh = r2
            byte[] r0 = r0.zzh
            r2 = r8
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x00b7:
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaeh r0 = r7.zzB
            int r2 = r0.zzX
            r3 = 1685485123(0x64767643, float:1.8185683E22)
            if (r2 == r3) goto L_0x00d6
            int r2 = r0.zzX
            r3 = 1685480259(0x64766343, float:1.8180206E22)
            if (r2 != r3) goto L_0x00cf
            goto L_0x00d6
        L_0x00cf:
            r0 = r8
            com.google.android.gms.internal.ads.zzyy r0 = (com.google.android.gms.internal.ads.zzyy) r0
            r0.zzo(r1, r10)
            return
        L_0x00d6:
            byte[] r2 = new byte[r1]
            r0.zzM = r2
            byte[] r0 = r0.zzM
            r2 = r8
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x00e3:
            int r0 = r7.zzN
            if (r0 == r6) goto L_0x00e8
            return
        L_0x00e8:
            android.util.SparseArray r0 = r7.zzj
            int r2 = r7.zzT
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.ads.zzaeh r0 = (com.google.android.gms.internal.ads.zzaeh) r0
            int r2 = r7.zzW
            if (r2 != r4) goto L_0x0112
            java.lang.String r0 = r0.zzb
            java.lang.String r2 = "V_VP9"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0112
            com.google.android.gms.internal.ads.zzef r0 = r7.zzu
            r0.zzC(r1)
            com.google.android.gms.internal.ads.zzef r0 = r7.zzu
            byte[] r0 = r0.zzH()
            r2 = r8
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x0112:
            r0 = r8
            com.google.android.gms.internal.ads.zzyy r0 = (com.google.android.gms.internal.ads.zzyy) r0
            r0.zzo(r1, r10)
            return
        L_0x0119:
            int r2 = r7.zzN
            r11 = 8
            if (r2 != 0) goto L_0x013e
            com.google.android.gms.internal.ads.zzaek r2 = r7.zzi
            long r12 = r2.zzd(r8, r10, r9, r11)
            int r2 = (int) r12
            r7.zzT = r2
            com.google.android.gms.internal.ads.zzaek r2 = r7.zzi
            int r2 = r2.zza()
            r7.zzU = r2
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zzP = r12
            r7.zzN = r9
            com.google.android.gms.internal.ads.zzef r2 = r7.zzn
            r2.zzC(r10)
        L_0x013e:
            android.util.SparseArray r2 = r7.zzj
            int r12 = r7.zzT
            java.lang.Object r2 = r2.get(r12)
            r12 = r2
            com.google.android.gms.internal.ads.zzaeh r12 = (com.google.android.gms.internal.ads.zzaeh) r12
            if (r12 != 0) goto L_0x0158
            int r0 = r7.zzU
            r2 = r8
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            int r0 = r1 - r0
            r2.zzo(r0, r10)
            r7.zzN = r10
            return
        L_0x0158:
            com.google.android.gms.internal.ads.zzaeh.zzd(r12)
            int r2 = r7.zzN
            if (r2 != r9) goto L_0x0304
            r2 = 3
            r7.zzv(r8, r2)
            com.google.android.gms.internal.ads.zzef r13 = r7.zzn
            byte[] r13 = r13.zzH()
            byte r13 = r13[r6]
            r13 = r13 & 6
            int r13 = r13 >> r9
            r14 = 255(0xff, float:3.57E-43)
            if (r13 != 0) goto L_0x0187
            r7.zzR = r9
            int[] r2 = r7.zzS
            int[] r2 = zzz(r2, r9)
            r7.zzS = r2
            int[] r2 = r7.zzS
            int r3 = r7.zzU
            int r1 = r1 - r3
            int r1 = r1 + -3
            r2[r10] = r1
            goto L_0x02af
        L_0x0187:
            r7.zzv(r8, r4)
            com.google.android.gms.internal.ads.zzef r15 = r7.zzn
            byte[] r15 = r15.zzH()
            byte r15 = r15[r2]
            r15 = r15 & r14
            int r15 = r15 + r9
            r7.zzR = r15
            int[] r4 = r7.zzS
            int[] r4 = zzz(r4, r15)
            r7.zzS = r4
            if (r13 != r6) goto L_0x01af
            int r2 = r7.zzU
            int r3 = r7.zzR
            int r1 = r1 - r2
            int r1 = r1 + -4
            int r1 = r1 / r3
            int[] r2 = r7.zzS
            java.util.Arrays.fill(r2, r10, r3, r1)
            goto L_0x02af
        L_0x01af:
            if (r13 != r9) goto L_0x01ef
            r2 = r10
            r3 = r2
            r16 = 4
        L_0x01b5:
            int r4 = r7.zzR
            int r4 = r4 + -1
            if (r2 >= r4) goto L_0x01e3
            int[] r4 = r7.zzS
            r4[r2] = r10
        L_0x01bf:
            int r4 = r16 + 1
            r7.zzv(r8, r4)
            com.google.android.gms.internal.ads.zzef r13 = r7.zzn
            byte[] r13 = r13.zzH()
            int r15 = r4 + -1
            byte r13 = r13[r15]
            r13 = r13 & r14
            int[] r15 = r7.zzS
            r16 = r15[r2]
            int r16 = r16 + r13
            r15[r2] = r16
            if (r13 == r14) goto L_0x01e0
            int r3 = r3 + r16
            int r2 = r2 + 1
            r16 = r4
            goto L_0x01b5
        L_0x01e0:
            r16 = r4
            goto L_0x01bf
        L_0x01e3:
            int[] r2 = r7.zzS
            int r13 = r7.zzU
            int r1 = r1 - r13
            int r1 = r1 - r16
            int r1 = r1 - r3
            r2[r4] = r1
            goto L_0x02af
        L_0x01ef:
            if (r13 != r2) goto L_0x02fc
            r2 = r10
            r4 = r2
            r16 = 4
        L_0x01f5:
            int r13 = r7.zzR
            int r13 = r13 + -1
            if (r2 >= r13) goto L_0x02a2
            int[] r13 = r7.zzS
            r13[r2] = r10
            int r13 = r16 + 1
            r7.zzv(r8, r13)
            int r15 = r13 + -1
            com.google.android.gms.internal.ads.zzef r5 = r7.zzn
            byte[] r5 = r5.zzH()
            byte r5 = r5[r15]
            if (r5 == 0) goto L_0x029a
            r5 = r10
        L_0x0211:
            if (r5 >= r11) goto L_0x0264
            int r16 = 7 - r5
            int r6 = r9 << r16
            com.google.android.gms.internal.ads.zzef r9 = r7.zzn
            byte[] r9 = r9.zzH()
            byte r9 = r9[r15]
            r9 = r9 & r6
            if (r9 == 0) goto L_0x0259
            int r13 = r13 + r5
            r7.zzv(r8, r13)
            int r9 = r15 + 1
            com.google.android.gms.internal.ads.zzef r10 = r7.zzn
            byte[] r10 = r10.zzH()
            byte r10 = r10[r15]
            r10 = r10 & r14
            int r6 = ~r6
            r6 = r6 & r10
            r17 = r4
            long r3 = (long) r6
        L_0x0236:
            if (r9 >= r13) goto L_0x024a
            int r6 = r9 + 1
            long r3 = r3 << r11
            com.google.android.gms.internal.ads.zzef r15 = r7.zzn
            byte[] r15 = r15.zzH()
            byte r9 = r15[r9]
            r9 = r9 & r14
            long r14 = (long) r9
            long r3 = r3 | r14
            r9 = r6
            r14 = 255(0xff, float:3.57E-43)
            goto L_0x0236
        L_0x024a:
            if (r2 <= 0) goto L_0x0268
            r14 = 1
            int r5 = r5 * 7
            int r5 = r5 + 6
            long r5 = r14 << r5
            r14 = -1
            long r5 = r5 + r14
            long r3 = r3 - r5
            goto L_0x0268
        L_0x0259:
            r17 = r4
            int r5 = r5 + 1
            r3 = 0
            r6 = 2
            r9 = 1
            r10 = 0
            r14 = 255(0xff, float:3.57E-43)
            goto L_0x0211
        L_0x0264:
            r17 = r4
            r3 = 0
        L_0x0268:
            r16 = r13
            r5 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x0292
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x0292
            int r3 = (int) r3
            int[] r4 = r7.zzS
            if (r2 == 0) goto L_0x0282
            int r5 = r2 + -1
            r5 = r4[r5]
            int r3 = r3 + r5
        L_0x0282:
            r4[r2] = r3
            int r4 = r17 + r3
            int r2 = r2 + 1
            r3 = 0
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            r14 = 255(0xff, float:3.57E-43)
            goto L_0x01f5
        L_0x0292:
            java.lang.String r0 = "EBML lacing sample size out of range."
            r1 = 0
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x029a:
            r1 = r3
            java.lang.String r0 = "No valid varint length mask found"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x02a2:
            r17 = r4
            int[] r2 = r7.zzS
            int r3 = r7.zzU
            int r1 = r1 - r3
            int r1 = r1 - r16
            int r1 = r1 - r17
            r2[r13] = r1
        L_0x02af:
            com.google.android.gms.internal.ads.zzef r1 = r7.zzn
            byte[] r1 = r1.zzH()
            r2 = 0
            byte r1 = r1[r2]
            com.google.android.gms.internal.ads.zzef r2 = r7.zzn
            byte[] r2 = r2.zzH()
            r3 = 1
            byte r2 = r2[r3]
            long r3 = r7.zzI
            int r1 = r1 << r11
            r5 = 255(0xff, float:3.57E-43)
            r2 = r2 & r5
            r1 = r1 | r2
            long r1 = (long) r1
            long r1 = r7.zzr(r1)
            long r3 = r3 + r1
            r7.zzO = r3
            int r1 = r12.zzd
            r2 = 2
            if (r1 == r2) goto L_0x02ef
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x02ec
            com.google.android.gms.internal.ads.zzef r0 = r7.zzn
            byte[] r0 = r0.zzH()
            byte r0 = r0[r2]
            r1 = 128(0x80, float:1.794E-43)
            r0 = r0 & r1
            if (r0 != r1) goto L_0x02e8
            r0 = 1
            goto L_0x02e9
        L_0x02e8:
            r0 = 0
        L_0x02e9:
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x02f1
        L_0x02ec:
            r1 = r0
            r0 = 0
            goto L_0x02f1
        L_0x02ef:
            r1 = r0
            r0 = 1
        L_0x02f1:
            r7.zzV = r0
            r7.zzN = r2
            r0 = 0
            r7.zzQ = r0
            r0 = r1
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x0305
        L_0x02fc:
            java.lang.String r0 = "Unexpected lacing value: 2"
            r1 = 0
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x0304:
            r1 = r5
        L_0x0305:
            if (r0 != r1) goto L_0x0335
        L_0x0307:
            int r0 = r7.zzQ
            int r1 = r7.zzR
            if (r0 >= r1) goto L_0x0331
            int[] r1 = r7.zzS
            r0 = r1[r0]
            r1 = 0
            int r5 = r7.zzp(r8, r12, r0, r1)
            long r0 = r7.zzO
            int r2 = r7.zzQ
            int r3 = r12.zze
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.zzV
            r6 = 0
            r0 = r18
            r1 = r12
            r0.zzu(r1, r2, r4, r5, r6)
            int r0 = r7.zzQ
            r1 = 1
            int r0 = r0 + r1
            r7.zzQ = r0
            goto L_0x0307
        L_0x0331:
            r0 = 0
            r7.zzN = r0
            return
        L_0x0335:
            r1 = 1
        L_0x0336:
            int r0 = r7.zzQ
            int r2 = r7.zzR
            if (r0 >= r2) goto L_0x034c
            int[] r2 = r7.zzS
            r3 = r2[r0]
            int r3 = r7.zzp(r8, r12, r3, r1)
            r2[r0] = r3
            int r0 = r7.zzQ
            int r0 = r0 + r1
            r7.zzQ = r0
            goto L_0x0336
        L_0x034c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaei.zzg(int, int, com.google.android.gms.internal.ads.zzzj):void");
    }

    /* access modifiers changed from: protected */
    public final void zzj(int i, long j) throws zzbu {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        zzt(i);
                        this.zzB.zzd = (int) j;
                        return;
                    case 136:
                        zzt(i);
                        zzaeh zzaeh = this.zzB;
                        if (j == 1) {
                            z = true;
                        }
                        zzaeh.zzU = z;
                        return;
                    case 155:
                        this.zzP = zzr(j);
                        return;
                    case 159:
                        zzt(i);
                        this.zzB.zzN = (int) j;
                        return;
                    case 176:
                        zzt(i);
                        this.zzB.zzl = (int) j;
                        return;
                    case 179:
                        zzs(i);
                        this.zzJ.zzc(zzr(j));
                        return;
                    case 186:
                        zzt(i);
                        this.zzB.zzm = (int) j;
                        return;
                    case 215:
                        zzt(i);
                        this.zzB.zzc = (int) j;
                        return;
                    case 231:
                        this.zzI = zzr(j);
                        return;
                    case 238:
                        this.zzW = (int) j;
                        return;
                    case 241:
                        if (!this.zzL) {
                            zzs(i);
                            this.zzK.zzc(j);
                            this.zzL = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzX = true;
                        return;
                    case 16871:
                        zzt(i);
                        this.zzB.zzX = (int) j;
                        return;
                    case 16980:
                        if (j != 3) {
                            throw zzbu.zza("ContentCompAlgo " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            throw zzbu.zza("DocTypeReadVersion " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            throw zzbu.zza("EBMLReadVersion " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            throw zzbu.zza("ContentEncAlgo " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            throw zzbu.zza("AESSettingsCipherMode " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 21420:
                        this.zzE = j + this.zzx;
                        return;
                    case 21432:
                        zzt(i);
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.zzB.zzv = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzB.zzv = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzB.zzv = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzB.zzv = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        zzt(i);
                        this.zzB.zzn = (int) j;
                        return;
                    case 21682:
                        zzt(i);
                        this.zzB.zzp = (int) j;
                        return;
                    case 21690:
                        zzt(i);
                        this.zzB.zzo = (int) j;
                        return;
                    case 21930:
                        zzt(i);
                        zzaeh zzaeh2 = this.zzB;
                        if (j == 1) {
                            z = true;
                        }
                        zzaeh2.zzT = z;
                        return;
                    case 21998:
                        zzt(i);
                        this.zzB.zzf = (int) j;
                        return;
                    case 22186:
                        zzt(i);
                        this.zzB.zzQ = j;
                        return;
                    case 22203:
                        zzt(i);
                        this.zzB.zzR = j;
                        return;
                    case 25188:
                        zzt(i);
                        this.zzB.zzO = (int) j;
                        return;
                    case 30114:
                        this.zzY = j;
                        return;
                    case 30321:
                        zzt(i);
                        int i3 = (int) j;
                        if (i3 == 0) {
                            this.zzB.zzq = 0;
                            return;
                        } else if (i3 == 1) {
                            this.zzB.zzq = 1;
                            return;
                        } else if (i3 == 2) {
                            this.zzB.zzq = 2;
                            return;
                        } else if (i3 == 3) {
                            this.zzB.zzq = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        zzt(i);
                        this.zzB.zze = (int) j;
                        return;
                    case 2807729:
                        this.zzy = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                zzt(i);
                                int i4 = (int) j;
                                if (i4 == 1) {
                                    this.zzB.zzz = 2;
                                    return;
                                } else if (i4 == 2) {
                                    this.zzB.zzz = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                zzt(i);
                                int zzb2 = zzq.zzb((int) j);
                                if (zzb2 != -1) {
                                    this.zzB.zzy = zzb2;
                                    return;
                                }
                                return;
                            case 21947:
                                zzt(i);
                                zzaeh zzaeh3 = this.zzB;
                                zzaeh3.zzw = true;
                                int zza2 = zzq.zza((int) j);
                                if (zza2 != -1) {
                                    zzaeh3.zzx = zza2;
                                    return;
                                }
                                return;
                            case 21948:
                                zzt(i);
                                this.zzB.zzA = (int) j;
                                return;
                            case 21949:
                                zzt(i);
                                this.zzB.zzB = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                throw zzbu.zza("ContentEncodingScope " + j + " not supported", (Throwable) null);
            }
        } else if (j != 0) {
            throw zzbu.zza("ContentEncodingOrder " + j + " not supported", (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzi(int i, double d) throws zzbu {
        if (i == 181) {
            zzt(i);
            this.zzB.zzP = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    zzt(i);
                    this.zzB.zzC = (float) d;
                    return;
                case 21970:
                    zzt(i);
                    this.zzB.zzD = (float) d;
                    return;
                case 21971:
                    zzt(i);
                    this.zzB.zzE = (float) d;
                    return;
                case 21972:
                    zzt(i);
                    this.zzB.zzF = (float) d;
                    return;
                case 21973:
                    zzt(i);
                    this.zzB.zzG = (float) d;
                    return;
                case 21974:
                    zzt(i);
                    this.zzB.zzH = (float) d;
                    return;
                case 21975:
                    zzt(i);
                    this.zzB.zzI = (float) d;
                    return;
                case 21976:
                    zzt(i);
                    this.zzB.zzJ = (float) d;
                    return;
                case 21977:
                    zzt(i);
                    this.zzB.zzK = (float) d;
                    return;
                case 21978:
                    zzt(i);
                    this.zzB.zzL = (float) d;
                    return;
                default:
                    switch (i) {
                        case 30323:
                            zzt(i);
                            this.zzB.zzr = (float) d;
                            return;
                        case 30324:
                            zzt(i);
                            this.zzB.zzs = (float) d;
                            return;
                        case 30325:
                            zzt(i);
                            this.zzB.zzt = (float) d;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.zzz = (long) d;
        }
    }
}
