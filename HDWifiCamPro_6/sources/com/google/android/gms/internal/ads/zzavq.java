package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzavq {
    public float zzA = -1.0f;
    public float zzB = -1.0f;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public int zzG = 1;
    public int zzH = -1;
    public int zzI = 8000;
    public long zzJ = 0;
    public long zzK = 0;
    public boolean zzL;
    public boolean zzM = true;
    public zzavi zzN;
    public int zzO;
    /* access modifiers changed from: private */
    public String zzP = "eng";
    public String zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public boolean zze;
    public byte[] zzf;
    public zzavh zzg;
    public byte[] zzh;
    public zzauv zzi;
    public int zzj = -1;
    public int zzk = -1;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = 0;
    public byte[] zzo = null;
    public int zzp = -1;
    public boolean zzq = false;
    public int zzr = -1;
    public int zzs = -1;
    public int zzt = -1;
    public int zzu = 1000;
    public int zzv = 200;
    public float zzw = -1.0f;
    public float zzx = -1.0f;
    public float zzy = -1.0f;
    public float zzz = -1.0f;

    private zzavq() {
    }

    /* synthetic */ zzavq(zzavp zzavp) {
    }

    private static List zzc(zzbak zzbak) throws zzasz {
        try {
            zzbak.zzw(16);
            if (zzbak.zzk() != 826496599) {
                return null;
            }
            int zzc2 = zzbak.zzc() + 20;
            byte[] bArr = zzbak.zza;
            while (true) {
                int length = bArr.length;
                if (zzc2 >= length - 4) {
                    throw new zzasz("Failed to find FourCC VC1 initialization data");
                } else if (bArr[zzc2] == 0 && bArr[zzc2 + 1] == 0 && bArr[zzc2 + 2] == 1 && bArr[zzc2 + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, zzc2, length));
                } else {
                    zzc2++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzasz("Error parsing FourCC VC1 codec private");
        }
    }

    private static List zzd(byte[] bArr) throws zzasz {
        byte b;
        byte b2;
        try {
            if (bArr[0] == 2) {
                int i = 0;
                int i2 = 1;
                while (true) {
                    b = bArr[i2];
                    if (b != -1) {
                        break;
                    }
                    i += 255;
                    i2++;
                }
                int i3 = i2 + 1;
                int i4 = i + b;
                int i5 = 0;
                while (true) {
                    b2 = bArr[i3];
                    if (b2 != -1) {
                        break;
                    }
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + b2;
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            int length = bArr.length - i9;
                            byte[] bArr3 = new byte[length];
                            System.arraycopy(bArr, i9, bArr3, 0, length);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzasz("Error parsing vorbis codec private");
                    }
                    throw new zzasz("Error parsing vorbis codec private");
                }
                throw new zzasz("Error parsing vorbis codec private");
            }
            throw new zzasz("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzasz("Error parsing vorbis codec private");
        }
    }

    private static boolean zze(zzbak zzbak) throws zzasz {
        try {
            int zzf2 = zzbak.zzf();
            if (zzf2 == 1) {
                return true;
            }
            if (zzf2 == 65534) {
                zzbak.zzv(24);
                return zzbak.zzl() == zzavr.zzd.getMostSignificantBits() && zzbak.zzl() == zzavr.zzd.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzasz("Error parsing MS/ACM codec private");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f8, code lost:
        r19 = -1;
        r22 = -1;
        r11 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.AUDIO_UNKNOWN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0226, code lost:
        r19 = r1;
        r22 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0281, code lost:
        r19 = r2;
        r22 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02c3, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02c4, code lost:
        r19 = -1;
        r22 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02de, code lost:
        r19 = -1;
        r22 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02e2, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02e3, code lost:
        r2 = r0.zzM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02e7, code lost:
        if (true == r0.zzL) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02e9, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02eb, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02ec, code lost:
        r2 = r2 | r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02f1, code lost:
        if (com.google.android.gms.internal.ads.zzbah.zza(r11) == false) goto L_0x031e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02f3, code lost:
        r1 = com.google.android.gms.internal.ads.zzasw.zzh(java.lang.Integer.toString(r32), r11, (java.lang.String) null, -1, r19, r0.zzG, r0.zzI, r22, -1, -1, r1, r0.zzi, r2 ? 1 : 0, r0.zzP, (com.google.android.gms.internal.ads.zzaxh) null);
        r9 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0322, code lost:
        if (com.google.android.gms.internal.ads.zzbah.zzb(r11) == false) goto L_0x043d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0326, code lost:
        if (r0.zzn != 0) goto L_0x0338;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0328, code lost:
        r2 = r0.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x032a, code lost:
        if (r2 != -1) goto L_0x032e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x032c, code lost:
        r2 = r0.zzj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x032e, code lost:
        r0.zzl = r2;
        r2 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0332, code lost:
        if (r2 != -1) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0334, code lost:
        r2 = r0.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0336, code lost:
        r0.zzm = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0338, code lost:
        r2 = r0.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x033c, code lost:
        if (r2 == -1) goto L_0x034e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x033e, code lost:
        r5 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0340, code lost:
        if (r5 == -1) goto L_0x034e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0342, code lost:
        r25 = ((float) (r0.zzk * r2)) / ((float) (r0.zzj * r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x034e, code lost:
        r25 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0352, code lost:
        if (r0.zzq == false) goto L_0x0411;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0358, code lost:
        if (r0.zzw == -1.0f) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x035e, code lost:
        if (r0.zzx == -1.0f) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0364, code lost:
        if (r0.zzy == -1.0f) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x036a, code lost:
        if (r0.zzz == -1.0f) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0370, code lost:
        if (r0.zzA == -1.0f) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0376, code lost:
        if (r0.zzB == -1.0f) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x037c, code lost:
        if (r0.zzC == -1.0f) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0382, code lost:
        if (r0.zzD == -1.0f) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0388, code lost:
        if (r0.zzE == -1.0f) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x038e, code lost:
        if (r0.zzF != -1.0f) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0391, code lost:
        r14 = new byte[25];
        r2 = java.nio.ByteBuffer.wrap(r14);
        r2.put((byte) 0);
        r2.putShort((short) ((int) ((r0.zzw * 50000.0f) + 0.5f)));
        r2.putShort((short) ((int) ((r0.zzx * 50000.0f) + 0.5f)));
        r2.putShort((short) ((int) ((r0.zzy * 50000.0f) + 0.5f)));
        r2.putShort((short) ((int) ((r0.zzz * 50000.0f) + 0.5f)));
        r2.putShort((short) ((int) ((r0.zzA * 50000.0f) + 0.5f)));
        r2.putShort((short) ((int) ((r0.zzB * 50000.0f) + 0.5f)));
        r2.putShort((short) ((int) ((r0.zzC * 50000.0f) + 0.5f)));
        r2.putShort((short) ((int) ((r0.zzD * 50000.0f) + 0.5f)));
        r2.putShort((short) ((int) (r0.zzE + 0.5f)));
        r2.putShort((short) ((int) (r0.zzF + 0.5f)));
        r2.putShort((short) r0.zzu);
        r2.putShort((short) r0.zzv);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0403, code lost:
        r28 = new com.google.android.gms.internal.ads.zzbau(r0.zzr, r0.zzt, r0.zzs, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0411, code lost:
        r28 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0413, code lost:
        r1 = com.google.android.gms.internal.ads.zzasw.zzl(java.lang.Integer.toString(r32), r11, (java.lang.String) null, -1, r19, r0.zzj, r0.zzk, -1.0f, r1, -1, r25, r0.zzo, r0.zzp, r28, r0.zzi);
        r9 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0443, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_SUBRIP.equals(r11) == false) goto L_0x0469;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0445, code lost:
        r1 = com.google.android.gms.internal.ads.zzasw.zzk(java.lang.Integer.toString(r32), r11, (java.lang.String) null, -1, r2 ? 1 : 0, r0.zzP, -1, r0.zzi, Long.MAX_VALUE, java.util.Collections.emptyList());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x046f, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_VOBSUB.equals(r11) != false) goto L_0x048a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0477, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_PGS.equals(r11) != false) goto L_0x048a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x047f, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_DVBSUBS.equals(r11) == false) goto L_0x0482;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0489, code lost:
        throw new com.google.android.gms.internal.ads.zzasz("Unexpected MIME type.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x048a, code lost:
        r1 = com.google.android.gms.internal.ads.zzasw.zzi(java.lang.Integer.toString(r32), r11, (java.lang.String) null, -1, r1, r0.zzP, r0.zzi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x04a2, code lost:
        r0.zzN = r31.zzbi(r0.zzb, r9);
        r0.zzN.zza(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04b1, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01bb, code lost:
        r22 = r1;
        r19 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.internal.ads.zzava r31, int r32) throws com.google.android.gms.internal.ads.zzasz {
        /*
            r30 = this;
            r0 = r30
            java.lang.String r1 = r0.zza
            int r2 = r1.hashCode()
            r3 = 25
            r4 = 4
            r5 = 8
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 3
            r10 = -1
            switch(r2) {
                case -2095576542: goto L_0x014a;
                case -2095575984: goto L_0x0140;
                case -1985379776: goto L_0x0135;
                case -1784763192: goto L_0x012a;
                case -1730367663: goto L_0x011f;
                case -1482641358: goto L_0x0114;
                case -1482641357: goto L_0x0109;
                case -1373388978: goto L_0x00ff;
                case -933872740: goto L_0x00f4;
                case -538363189: goto L_0x00e9;
                case -538363109: goto L_0x00de;
                case -425012669: goto L_0x00d3;
                case -356037306: goto L_0x00c7;
                case 62923557: goto L_0x00bb;
                case 62923603: goto L_0x00af;
                case 62927045: goto L_0x00a3;
                case 82338133: goto L_0x0098;
                case 82338134: goto L_0x008d;
                case 99146302: goto L_0x0081;
                case 444813526: goto L_0x0075;
                case 542569478: goto L_0x0069;
                case 725957860: goto L_0x005d;
                case 855502857: goto L_0x0052;
                case 1422270023: goto L_0x0046;
                case 1809237540: goto L_0x003b;
                case 1950749482: goto L_0x002f;
                case 1950789798: goto L_0x0023;
                case 1951062397: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0154
        L_0x0017:
            java.lang.String r2 = "A_OPUS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 11
            goto L_0x0155
        L_0x0023:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 21
            goto L_0x0155
        L_0x002f:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 16
            goto L_0x0155
        L_0x003b:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = r6
            goto L_0x0155
        L_0x0046:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 24
            goto L_0x0155
        L_0x0052:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 7
            goto L_0x0155
        L_0x005d:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 23
            goto L_0x0155
        L_0x0069:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 19
            goto L_0x0155
        L_0x0075:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 9
            goto L_0x0155
        L_0x0081:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 26
            goto L_0x0155
        L_0x008d:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = r7
            goto L_0x0155
        L_0x0098:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = r8
            goto L_0x0155
        L_0x00a3:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 18
            goto L_0x0155
        L_0x00af:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 15
            goto L_0x0155
        L_0x00bb:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 12
            goto L_0x0155
        L_0x00c7:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 20
            goto L_0x0155
        L_0x00d3:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = r3
            goto L_0x0155
        L_0x00de:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 6
            goto L_0x0155
        L_0x00e9:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = r4
            goto L_0x0155
        L_0x00f4:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 27
            goto L_0x0155
        L_0x00ff:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = r5
            goto L_0x0155
        L_0x0109:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 14
            goto L_0x0155
        L_0x0114:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 13
            goto L_0x0155
        L_0x011f:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 10
            goto L_0x0155
        L_0x012a:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 17
            goto L_0x0155
        L_0x0135:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 22
            goto L_0x0155
        L_0x0140:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = r9
            goto L_0x0155
        L_0x014a:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 5
            goto L_0x0155
        L_0x0154:
            r1 = r10
        L_0x0155:
            java.lang.String r2 = ". Setting mimeType to audio/x-unknown"
            java.lang.String r11 = "video/x-unknown"
            java.lang.String r12 = "audio/x-unknown"
            java.lang.String r13 = "MatroskaExtractor"
            r14 = 0
            switch(r1) {
                case 0: goto L_0x02dc;
                case 1: goto L_0x02d9;
                case 2: goto L_0x02d6;
                case 3: goto L_0x02c9;
                case 4: goto L_0x02c9;
                case 5: goto L_0x02c9;
                case 6: goto L_0x02b0;
                case 7: goto L_0x029c;
                case 8: goto L_0x0286;
                case 9: goto L_0x02de;
                case 10: goto L_0x0277;
                case 11: goto L_0x0236;
                case 12: goto L_0x022c;
                case 13: goto L_0x0222;
                case 14: goto L_0x021d;
                case 15: goto L_0x0219;
                case 16: goto L_0x0215;
                case 17: goto L_0x0211;
                case 18: goto L_0x020d;
                case 19: goto L_0x020d;
                case 20: goto L_0x0209;
                case 21: goto L_0x01ff;
                case 22: goto L_0x01c1;
                case 23: goto L_0x0197;
                case 24: goto L_0x0193;
                case 25: goto L_0x0189;
                case 26: goto L_0x0185;
                case 27: goto L_0x0169;
                default: goto L_0x0161;
            }
        L_0x0161:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2)
            throw r1
        L_0x0169:
            byte[] r1 = new byte[r4]
            byte[] r2 = r0.zzh
            byte r4 = r2[r8]
            r1[r8] = r4
            byte r4 = r2[r7]
            r1[r7] = r4
            byte r4 = r2[r6]
            r1[r6] = r4
            byte r2 = r2[r9]
            r1[r9] = r2
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r11 = "application/dvbsubs"
            goto L_0x02c4
        L_0x0185:
            java.lang.String r11 = "application/pgs"
            goto L_0x02de
        L_0x0189:
            byte[] r1 = r0.zzh
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r11 = "application/vobsub"
            goto L_0x02c4
        L_0x0193:
            java.lang.String r11 = "application/x-subrip"
            goto L_0x02de
        L_0x0197:
            int r1 = r0.zzH
            int r1 = com.google.android.gms.internal.ads.zzbar.zzh(r1)
            if (r1 != 0) goto L_0x01b9
            int r1 = r0.zzH
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unsupported PCM bit depth: "
            r4.append(r5)
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            android.util.Log.w(r13, r1)
            goto L_0x01f8
        L_0x01b9:
            java.lang.String r11 = "audio/raw"
        L_0x01bb:
            r22 = r1
            r19 = r10
            goto L_0x02e2
        L_0x01c1:
            com.google.android.gms.internal.ads.zzbak r1 = new com.google.android.gms.internal.ads.zzbak
            byte[] r4 = r0.zzh
            r1.<init>((byte[]) r4)
            boolean r1 = zze(r1)
            if (r1 == 0) goto L_0x01f3
            int r1 = r0.zzH
            int r1 = com.google.android.gms.internal.ads.zzbar.zzh(r1)
            if (r1 != 0) goto L_0x01f0
            int r1 = r0.zzH
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unsupported PCM bit depth: "
            r4.append(r5)
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            android.util.Log.w(r13, r1)
            goto L_0x01f8
        L_0x01f0:
            java.lang.String r11 = "audio/raw"
            goto L_0x01bb
        L_0x01f3:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
            android.util.Log.w(r13, r1)
        L_0x01f8:
            r19 = r10
            r22 = r19
            r11 = r12
            goto L_0x02e2
        L_0x01ff:
            byte[] r1 = r0.zzh
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r11 = "audio/x-flac"
            goto L_0x02c4
        L_0x0209:
            java.lang.String r11 = "audio/vnd.dts.hd"
            goto L_0x02de
        L_0x020d:
            java.lang.String r11 = "audio/vnd.dts"
            goto L_0x02de
        L_0x0211:
            java.lang.String r11 = "audio/true-hd"
            goto L_0x02de
        L_0x0215:
            java.lang.String r11 = "audio/eac3"
            goto L_0x02de
        L_0x0219:
            java.lang.String r11 = "audio/ac3"
            goto L_0x02de
        L_0x021d:
            r1 = 4096(0x1000, float:5.74E-42)
            java.lang.String r11 = "audio/mpeg"
            goto L_0x0226
        L_0x0222:
            r1 = 4096(0x1000, float:5.74E-42)
            java.lang.String r11 = "audio/mpeg-L2"
        L_0x0226:
            r19 = r1
            r22 = r10
            goto L_0x02e2
        L_0x022c:
            byte[] r1 = r0.zzh
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r11 = "audio/mp4a-latm"
            goto L_0x02c4
        L_0x0236:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r9)
            byte[] r2 = r0.zzh
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r4)
            long r11 = r0.zzJ
            java.nio.ByteBuffer r2 = r2.putLong(r11)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r4)
            long r4 = r0.zzK
            java.nio.ByteBuffer r2 = r2.putLong(r4)
            byte[] r2 = r2.array()
            r1.add(r2)
            r2 = 5760(0x1680, float:8.071E-42)
            java.lang.String r11 = "audio/opus"
            goto L_0x0281
        L_0x0277:
            byte[] r1 = r0.zzh
            java.util.List r1 = zzd(r1)
            r2 = 8192(0x2000, float:1.14794E-41)
            java.lang.String r11 = "audio/vorbis"
        L_0x0281:
            r19 = r2
            r22 = r10
            goto L_0x02e3
        L_0x0286:
            com.google.android.gms.internal.ads.zzbak r1 = new com.google.android.gms.internal.ads.zzbak
            byte[] r2 = r0.zzh
            r1.<init>((byte[]) r2)
            java.util.List r1 = zzc(r1)
            if (r1 == 0) goto L_0x0296
            java.lang.String r11 = "video/wvc1"
            goto L_0x02c4
        L_0x0296:
            java.lang.String r2 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            android.util.Log.w(r13, r2)
            goto L_0x02c4
        L_0x029c:
            com.google.android.gms.internal.ads.zzbak r1 = new com.google.android.gms.internal.ads.zzbak
            byte[] r2 = r0.zzh
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzbay r1 = com.google.android.gms.internal.ads.zzbay.zza(r1)
            java.util.List r2 = r1.zza
            int r1 = r1.zzb
            r0.zzO = r1
            java.lang.String r11 = "video/hevc"
            goto L_0x02c3
        L_0x02b0:
            com.google.android.gms.internal.ads.zzbak r1 = new com.google.android.gms.internal.ads.zzbak
            byte[] r2 = r0.zzh
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzbas r1 = com.google.android.gms.internal.ads.zzbas.zza(r1)
            java.util.List r2 = r1.zza
            int r1 = r1.zzb
            r0.zzO = r1
            java.lang.String r11 = "video/avc"
        L_0x02c3:
            r1 = r2
        L_0x02c4:
            r19 = r10
            r22 = r19
            goto L_0x02e3
        L_0x02c9:
            byte[] r1 = r0.zzh
            if (r1 != 0) goto L_0x02cf
            r1 = r14
            goto L_0x02d3
        L_0x02cf:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x02d3:
            java.lang.String r11 = "video/mp4v-es"
            goto L_0x02c4
        L_0x02d6:
            java.lang.String r11 = "video/mpeg2"
            goto L_0x02de
        L_0x02d9:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            goto L_0x02de
        L_0x02dc:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
        L_0x02de:
            r19 = r10
            r22 = r19
        L_0x02e2:
            r1 = r14
        L_0x02e3:
            boolean r2 = r0.zzM
            boolean r4 = r0.zzL
            if (r7 == r4) goto L_0x02eb
            r4 = r8
            goto L_0x02ec
        L_0x02eb:
            r4 = r6
        L_0x02ec:
            r2 = r2 | r4
            boolean r4 = com.google.android.gms.internal.ads.zzbah.zza(r11)
            if (r4 == 0) goto L_0x031e
            java.lang.String r15 = java.lang.Integer.toString(r32)
            r17 = 0
            r18 = -1
            int r3 = r0.zzG
            int r4 = r0.zzI
            r23 = -1
            r24 = -1
            com.google.android.gms.internal.ads.zzauv r5 = r0.zzi
            java.lang.String r6 = r0.zzP
            r29 = 0
            r16 = r11
            r20 = r3
            r21 = r4
            r25 = r1
            r26 = r5
            r27 = r2
            r28 = r6
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzh(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r9 = r7
            goto L_0x04a2
        L_0x031e:
            boolean r4 = com.google.android.gms.internal.ads.zzbah.zzb(r11)
            if (r4 == 0) goto L_0x043d
            int r2 = r0.zzn
            if (r2 != 0) goto L_0x0338
            int r2 = r0.zzl
            if (r2 != r10) goto L_0x032e
            int r2 = r0.zzj
        L_0x032e:
            r0.zzl = r2
            int r2 = r0.zzm
            if (r2 != r10) goto L_0x0336
            int r2 = r0.zzk
        L_0x0336:
            r0.zzm = r2
        L_0x0338:
            int r2 = r0.zzl
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r10) goto L_0x034e
            int r5 = r0.zzm
            if (r5 == r10) goto L_0x034e
            int r7 = r0.zzk
            int r7 = r7 * r2
            float r2 = (float) r7
            int r7 = r0.zzj
            int r7 = r7 * r5
            float r5 = (float) r7
            float r2 = r2 / r5
            r25 = r2
            goto L_0x0350
        L_0x034e:
            r25 = r4
        L_0x0350:
            boolean r2 = r0.zzq
            if (r2 == 0) goto L_0x0411
            float r2 = r0.zzw
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0403
            float r2 = r0.zzx
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0403
            float r2 = r0.zzy
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0403
            float r2 = r0.zzz
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0403
            float r2 = r0.zzA
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0403
            float r2 = r0.zzB
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0403
            float r2 = r0.zzC
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0403
            float r2 = r0.zzD
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0403
            float r2 = r0.zzE
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0403
            float r2 = r0.zzF
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0391
            goto L_0x0403
        L_0x0391:
            byte[] r14 = new byte[r3]
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r14)
            r2.put(r8)
            float r3 = r0.zzw
            r4 = 1195593728(0x47435000, float:50000.0)
            float r3 = r3 * r4
            r5 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.zzx
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.zzy
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.zzz
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.zzA
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.zzB
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.zzC
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.zzD
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.zzE
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.zzF
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            int r3 = r0.zzu
            short r3 = (short) r3
            r2.putShort(r3)
            int r3 = r0.zzv
            short r3 = (short) r3
            r2.putShort(r3)
        L_0x0403:
            com.google.android.gms.internal.ads.zzbau r2 = new com.google.android.gms.internal.ads.zzbau
            int r3 = r0.zzr
            int r4 = r0.zzt
            int r5 = r0.zzs
            r2.<init>(r3, r4, r5, r14)
            r28 = r2
            goto L_0x0413
        L_0x0411:
            r28 = r14
        L_0x0413:
            java.lang.String r15 = java.lang.Integer.toString(r32)
            r17 = 0
            r18 = -1
            int r2 = r0.zzj
            int r3 = r0.zzk
            r22 = -1082130432(0xffffffffbf800000, float:-1.0)
            r24 = -1
            byte[] r4 = r0.zzo
            int r5 = r0.zzp
            com.google.android.gms.internal.ads.zzauv r7 = r0.zzi
            r16 = r11
            r20 = r2
            r21 = r3
            r23 = r1
            r26 = r4
            r27 = r5
            r29 = r7
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzl(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r9 = r6
            goto L_0x04a2
        L_0x043d:
            java.lang.String r3 = "application/x-subrip"
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x0469
            java.lang.String r15 = java.lang.Integer.toString(r32)
            r17 = 0
            r18 = -1
            java.lang.String r1 = r0.zzP
            r21 = -1
            com.google.android.gms.internal.ads.zzauv r3 = r0.zzi
            r23 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.util.List r25 = java.util.Collections.emptyList()
            r16 = r11
            r19 = r2
            r20 = r1
            r22 = r3
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzk(r15, r16, r17, r18, r19, r20, r21, r22, r23, r25)
            goto L_0x04a2
        L_0x0469:
            java.lang.String r2 = "application/vobsub"
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x048a
            java.lang.String r2 = "application/pgs"
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x048a
            java.lang.String r2 = "application/dvbsubs"
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x0482
            goto L_0x048a
        L_0x0482:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2)
            throw r1
        L_0x048a:
            java.lang.String r15 = java.lang.Integer.toString(r32)
            r17 = 0
            r18 = -1
            java.lang.String r2 = r0.zzP
            com.google.android.gms.internal.ads.zzauv r3 = r0.zzi
            r16 = r11
            r19 = r1
            r20 = r2
            r21 = r3
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzi(r15, r16, r17, r18, r19, r20, r21)
        L_0x04a2:
            int r2 = r0.zzb
            r3 = r31
            com.google.android.gms.internal.ads.zzavi r2 = r3.zzbi(r2, r9)
            r0.zzN = r2
            com.google.android.gms.internal.ads.zzavi r2 = r0.zzN
            r2.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavq.zzb(com.google.android.gms.internal.ads.zzava, int):void");
    }
}
