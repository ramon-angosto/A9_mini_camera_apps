package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaeh {
    public int zzA = 1000;
    public int zzB = 200;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public byte[] zzM;
    public int zzN = 1;
    public int zzO = -1;
    public int zzP = 8000;
    public long zzQ = 0;
    public long zzR = 0;
    public zzaaq zzS;
    public boolean zzT;
    public boolean zzU = true;
    public zzaap zzV;
    public int zzW;
    /* access modifiers changed from: private */
    public int zzX;
    /* access modifiers changed from: private */
    public String zzY = "eng";
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzaao zzi;
    public byte[] zzj;
    public zzx zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = 0;
    public int zzq = -1;
    public float zzr = 0.0f;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public byte[] zzu = null;
    public int zzv = -1;
    public boolean zzw = false;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;

    protected zzaeh() {
    }

    static /* synthetic */ void zzd(zzaeh zzaeh) {
        if (zzaeh.zzV == null) {
            throw null;
        }
    }

    private static Pair zzf(zzef zzef) throws zzbu {
        try {
            zzef.zzG(16);
            long zzq2 = zzef.zzq();
            if (zzq2 == 1482049860) {
                return new Pair("video/divx", (Object) null);
            }
            if (zzq2 == 859189832) {
                return new Pair(MimeTypes.VIDEO_H263, (Object) null);
            }
            if (zzq2 == 826496599) {
                int zzc2 = zzef.zzc() + 20;
                byte[] zzH2 = zzef.zzH();
                while (true) {
                    int length = zzH2.length;
                    if (zzc2 >= length - 4) {
                        throw zzbu.zza("Failed to find FourCC VC1 initialization data", (Throwable) null);
                    } else if (zzH2[zzc2] == 0 && zzH2[zzc2 + 1] == 0 && zzH2[zzc2 + 2] == 1 && zzH2[zzc2 + 3] == 15) {
                        return new Pair(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(zzH2, zzc2, length)));
                    } else {
                        zzc2++;
                    }
                }
            } else {
                zzdw.zze("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair(MimeTypes.VIDEO_UNKNOWN, (Object) null);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbu.zza("Error parsing FourCC private data", (Throwable) null);
        }
    }

    private static List zzg(byte[] bArr) throws zzbu {
        byte b;
        byte b2;
        try {
            if (bArr[0] == 2) {
                int i = 0;
                int i2 = 1;
                while (true) {
                    b = bArr[i2] & UByte.MAX_VALUE;
                    if (b != 255) {
                        break;
                    }
                    i += 255;
                    i2++;
                }
                int i3 = i2 + 1;
                int i4 = i + b;
                int i5 = 0;
                while (true) {
                    b2 = bArr[i3] & UByte.MAX_VALUE;
                    if (b2 != 255) {
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
                        throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
                    }
                    throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
                }
                throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
            }
            throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
        }
    }

    private static boolean zzh(zzef zzef) throws zzbu {
        try {
            int zzi2 = zzef.zzi();
            if (zzi2 == 1) {
                return true;
            }
            if (zzi2 == 65534) {
                zzef.zzF(24);
                return zzef.zzr() == zzaei.zzf.getMostSignificantBits() && zzef.zzr() == zzaei.zzf.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbu.zza("Error parsing MS/ACM codec private", (Throwable) null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzbu {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        throw zzbu.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), (Throwable) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: com.google.android.gms.internal.ads.zzq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r14v0 */
    /* JADX WARNING: type inference failed for: r14v3 */
    /* JADX WARNING: type inference failed for: r14v5 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0245, code lost:
        r2 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x027e, code lost:
        r2 = -1;
        r6 = -1;
        r11 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.AUDIO_UNKNOWN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02b3, code lost:
        r2 = r1;
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0322, code lost:
        r5 = r1;
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x033f, code lost:
        r5 = r1;
        r2 = -1;
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0342, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0373, code lost:
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0374, code lost:
        r2 = -1;
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x038f, code lost:
        r2 = -1;
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0391, code lost:
        r1 = null;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0393, code lost:
        r10 = r0.zzM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0395, code lost:
        if (r10 == null) goto L_0x03a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0397, code lost:
        r10 = com.google.android.gms.internal.ads.zzze.zza(new com.google.android.gms.internal.ads.zzef(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03a0, code lost:
        if (r10 == null) goto L_0x03a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03a2, code lost:
        r1 = r10.zza;
        r11 = "video/dolby-vision";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03a6, code lost:
        r10 = r0.zzU;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03aa, code lost:
        if (true == r0.zzT) goto L_0x03ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03ac, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03ae, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03af, code lost:
        r10 = r10 | r12;
        r12 = new com.google.android.gms.internal.ads.zzad();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03b9, code lost:
        if (com.google.android.gms.internal.ads.zzbt.zzg(r11) == false) goto L_0x03cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03bb, code lost:
        r12.zzw(r0.zzN);
        r12.zzT(r0.zzP);
        r12.zzN(r6);
        r8 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03cf, code lost:
        if (com.google.android.gms.internal.ads.zzbt.zzh(r11) == false) goto L_0x0552;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03d3, code lost:
        if (r0.zzp != 0) goto L_0x03e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03d5, code lost:
        r3 = r0.zzn;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03d7, code lost:
        if (r3 != -1) goto L_0x03db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03d9, code lost:
        r3 = r0.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03db, code lost:
        r0.zzn = r3;
        r3 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03df, code lost:
        if (r3 != -1) goto L_0x03e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03e1, code lost:
        r3 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03e3, code lost:
        r0.zzo = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03e5, code lost:
        r3 = r0.zzn;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03e9, code lost:
        if (r3 == -1) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03eb, code lost:
        r8 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03ed, code lost:
        if (r8 == -1) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x03ef, code lost:
        r3 = ((float) (r0.zzm * r3)) / ((float) (r0.zzl * r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x03f9, code lost:
        r3 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03fc, code lost:
        if (r0.zzw == false) goto L_0x04c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0402, code lost:
        if (r0.zzC == -1.0f) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0408, code lost:
        if (r0.zzD == -1.0f) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x040e, code lost:
        if (r0.zzE == -1.0f) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0414, code lost:
        if (r0.zzF == -1.0f) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x041a, code lost:
        if (r0.zzG == -1.0f) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0420, code lost:
        if (r0.zzH == -1.0f) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0426, code lost:
        if (r0.zzI == -1.0f) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x042c, code lost:
        if (r0.zzJ == -1.0f) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0432, code lost:
        if (r0.zzK == -1.0f) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0438, code lost:
        if (r0.zzL != -1.0f) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x043b, code lost:
        r14 = new byte[25];
        r6 = java.nio.ByteBuffer.wrap(r14).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        r6.put((byte) 0);
        r6.putShort((short) ((int) ((r0.zzC * 50000.0f) + 0.5f)));
        r6.putShort((short) ((int) ((r0.zzD * 50000.0f) + 0.5f)));
        r6.putShort((short) ((int) ((r0.zzE * 50000.0f) + 0.5f)));
        r6.putShort((short) ((int) ((r0.zzF * 50000.0f) + 0.5f)));
        r6.putShort((short) ((int) ((r0.zzG * 50000.0f) + 0.5f)));
        r6.putShort((short) ((int) ((r0.zzH * 50000.0f) + 0.5f)));
        r6.putShort((short) ((int) ((r0.zzI * 50000.0f) + 0.5f)));
        r6.putShort((short) ((int) ((r0.zzJ * 50000.0f) + 0.5f)));
        r6.putShort((short) ((int) (r0.zzK + 0.5f)));
        r6.putShort((short) ((int) (r0.zzL + 0.5f)));
        r6.putShort((short) r0.zzA);
        r6.putShort((short) r0.zzB);
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x04b5, code lost:
        r14 = new com.google.android.gms.internal.ads.zzq(r0.zzx, r0.zzz, r0.zzy, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x04c3, code lost:
        if (r0.zza == null) goto L_0x04e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x04cf, code lost:
        if (com.google.android.gms.internal.ads.zzaei.zzg.containsKey(r0.zza) == false) goto L_0x04e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x04d1, code lost:
        r9 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzaei.zzg.get(r0.zza)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x04e4, code lost:
        if (r0.zzq != 0) goto L_0x0532;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x04ed, code lost:
        if (java.lang.Float.compare(r0.zzr, 0.0f) != 0) goto L_0x0532;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x04f5, code lost:
        if (java.lang.Float.compare(r0.zzs, 0.0f) != 0) goto L_0x0532;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x04fd, code lost:
        if (java.lang.Float.compare(r0.zzt, 0.0f) != 0) goto L_0x0500;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0508, code lost:
        if (java.lang.Float.compare(r0.zzs, 90.0f) != 0) goto L_0x050d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x050a, code lost:
        r7 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0515, code lost:
        if (java.lang.Float.compare(r0.zzs, -180.0f) == 0) goto L_0x052f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x051f, code lost:
        if (java.lang.Float.compare(r0.zzs, 180.0f) != 0) goto L_0x0522;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x052a, code lost:
        if (java.lang.Float.compare(r0.zzs, -90.0f) != 0) goto L_0x0532;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x052c, code lost:
        r7 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x052f, code lost:
        r7 = 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0532, code lost:
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0533, code lost:
        r12.zzX(r0.zzl);
        r12.zzF(r0.zzm);
        r12.zzP(r3);
        r12.zzR(r7);
        r12.zzQ(r0.zzu);
        r12.zzV(r0.zzv);
        r12.zzy(r14);
        r8 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0558, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_SUBRIP.equals(r11) != false) goto L_0x058a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0560, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.TEXT_SSA.equals(r11) != false) goto L_0x058a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0568, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.TEXT_VTT.equals(r11) != false) goto L_0x058a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0570, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_VOBSUB.equals(r11) != false) goto L_0x058a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0578, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_PGS.equals(r11) != false) goto L_0x058a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0580, code lost:
        if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_DVBSUBS.equals(r11) == false) goto L_0x0583;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0589, code lost:
        throw com.google.android.gms.internal.ads.zzbu.zza("Unexpected MIME type.", (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x058c, code lost:
        if (r0.zza == null) goto L_0x059f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0598, code lost:
        if (com.google.android.gms.internal.ads.zzaei.zzg.containsKey(r0.zza) != false) goto L_0x059f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x059a, code lost:
        r12.zzJ(r0.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x059f, code lost:
        r12.zzG(r18);
        r12.zzS(r11);
        r12.zzL(r2);
        r12.zzK(r0.zzY);
        r12.zzU(r10);
        r12.zzI(r5);
        r12.zzx(r1);
        r12.zzB(r0.zzk);
        r1 = r12.zzY();
        r0.zzV = r17.zzv(r0.zzc, r8);
        r0.zzV.zzk(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x05d0, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.internal.ads.zzzl r17, int r18) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = r0.zzb
            int r2 = r1.hashCode()
            r3 = 1
            r4 = 2
            r5 = 8
            r6 = 4
            r7 = 0
            r8 = 3
            r9 = -1
            switch(r2) {
                case -2095576542: goto L_0x0185;
                case -2095575984: goto L_0x017b;
                case -1985379776: goto L_0x0170;
                case -1784763192: goto L_0x0165;
                case -1730367663: goto L_0x015a;
                case -1482641358: goto L_0x014f;
                case -1482641357: goto L_0x0144;
                case -1373388978: goto L_0x0139;
                case -933872740: goto L_0x012e;
                case -538363189: goto L_0x0123;
                case -538363109: goto L_0x0118;
                case -425012669: goto L_0x010c;
                case -356037306: goto L_0x0100;
                case 62923557: goto L_0x00f4;
                case 62923603: goto L_0x00e8;
                case 62927045: goto L_0x00dc;
                case 82318131: goto L_0x00d1;
                case 82338133: goto L_0x00c6;
                case 82338134: goto L_0x00bb;
                case 99146302: goto L_0x00af;
                case 444813526: goto L_0x00a3;
                case 542569478: goto L_0x0097;
                case 635596514: goto L_0x008b;
                case 725948237: goto L_0x007f;
                case 725957860: goto L_0x0073;
                case 738597099: goto L_0x0067;
                case 855502857: goto L_0x005c;
                case 1045209816: goto L_0x0050;
                case 1422270023: goto L_0x0044;
                case 1809237540: goto L_0x0039;
                case 1950749482: goto L_0x002d;
                case 1950789798: goto L_0x0021;
                case 1951062397: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x018f
        L_0x0015:
            java.lang.String r2 = "A_OPUS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 12
            goto L_0x0190
        L_0x0021:
            java.lang.String r2 = "A_FLAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 22
            goto L_0x0190
        L_0x002d:
            java.lang.String r2 = "A_EAC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 17
            goto L_0x0190
        L_0x0039:
            java.lang.String r2 = "V_MPEG2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = r8
            goto L_0x0190
        L_0x0044:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 27
            goto L_0x0190
        L_0x0050:
            java.lang.String r2 = "S_TEXT/WEBVTT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 29
            goto L_0x0190
        L_0x005c:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = r5
            goto L_0x0190
        L_0x0067:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 28
            goto L_0x0190
        L_0x0073:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 24
            goto L_0x0190
        L_0x007f:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 25
            goto L_0x0190
        L_0x008b:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 26
            goto L_0x0190
        L_0x0097:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 20
            goto L_0x0190
        L_0x00a3:
            java.lang.String r2 = "V_THEORA"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 10
            goto L_0x0190
        L_0x00af:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 31
            goto L_0x0190
        L_0x00bb:
            java.lang.String r2 = "V_VP9"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = r3
            goto L_0x0190
        L_0x00c6:
            java.lang.String r2 = "V_VP8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = r7
            goto L_0x0190
        L_0x00d1:
            java.lang.String r2 = "V_AV1"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = r4
            goto L_0x0190
        L_0x00dc:
            java.lang.String r2 = "A_DTS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 19
            goto L_0x0190
        L_0x00e8:
            java.lang.String r2 = "A_AC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 16
            goto L_0x0190
        L_0x00f4:
            java.lang.String r2 = "A_AAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 13
            goto L_0x0190
        L_0x0100:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 21
            goto L_0x0190
        L_0x010c:
            java.lang.String r2 = "S_VOBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 30
            goto L_0x0190
        L_0x0118:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 7
            goto L_0x0190
        L_0x0123:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 5
            goto L_0x0190
        L_0x012e:
            java.lang.String r2 = "S_DVBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 32
            goto L_0x0190
        L_0x0139:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 9
            goto L_0x0190
        L_0x0144:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 15
            goto L_0x0190
        L_0x014f:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 14
            goto L_0x0190
        L_0x015a:
            java.lang.String r2 = "A_VORBIS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 11
            goto L_0x0190
        L_0x0165:
            java.lang.String r2 = "A_TRUEHD"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 18
            goto L_0x0190
        L_0x0170:
            java.lang.String r2 = "A_MS/ACM"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 23
            goto L_0x0190
        L_0x017b:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = r6
            goto L_0x0190
        L_0x0185:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018f
            r2 = 6
            goto L_0x0190
        L_0x018f:
            r2 = r9
        L_0x0190:
            java.lang.String r10 = ". Setting mimeType to audio/x-unknown"
            java.lang.String r11 = "audio/raw"
            java.lang.String r12 = "audio/x-unknown"
            java.lang.String r13 = "MatroskaExtractor"
            r14 = 0
            switch(r2) {
                case 0: goto L_0x038d;
                case 1: goto L_0x038a;
                case 2: goto L_0x0387;
                case 3: goto L_0x0384;
                case 4: goto L_0x0377;
                case 5: goto L_0x0377;
                case 6: goto L_0x0377;
                case 7: goto L_0x035c;
                case 8: goto L_0x0344;
                case 9: goto L_0x0329;
                case 10: goto L_0x0325;
                case 11: goto L_0x0316;
                case 12: goto L_0x02d5;
                case 13: goto L_0x02b7;
                case 14: goto L_0x02af;
                case 15: goto L_0x02aa;
                case 16: goto L_0x02a6;
                case 17: goto L_0x02a2;
                case 18: goto L_0x0297;
                case 19: goto L_0x0293;
                case 20: goto L_0x0293;
                case 21: goto L_0x028f;
                case 22: goto L_0x0283;
                case 23: goto L_0x0248;
                case 24: goto L_0x0223;
                case 25: goto L_0x01fe;
                case 26: goto L_0x01de;
                case 27: goto L_0x01da;
                case 28: goto L_0x01c8;
                case 29: goto L_0x01c4;
                case 30: goto L_0x01b8;
                case 31: goto L_0x01b4;
                case 32: goto L_0x01a3;
                default: goto L_0x019c;
            }
        L_0x019c:
            java.lang.String r1 = "Unrecognized codec identifier."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r14)
            throw r1
        L_0x01a3:
            byte[] r2 = new byte[r6]
            byte[] r1 = r0.zzi(r1)
            java.lang.System.arraycopy(r1, r7, r2, r7, r6)
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzp(r2)
            java.lang.String r11 = "application/dvbsubs"
            goto L_0x033f
        L_0x01b4:
            java.lang.String r11 = "application/pgs"
            goto L_0x038f
        L_0x01b8:
            byte[] r1 = r0.zzi(r1)
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzp(r1)
            java.lang.String r11 = "application/vobsub"
            goto L_0x033f
        L_0x01c4:
            java.lang.String r11 = "text/vtt"
            goto L_0x038f
        L_0x01c8:
            byte[] r1 = com.google.android.gms.internal.ads.zzaei.zzc
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzq(r1, r2)
            java.lang.String r11 = "text/x-ssa"
            goto L_0x033f
        L_0x01da:
            java.lang.String r11 = "application/x-subrip"
            goto L_0x038f
        L_0x01de:
            int r1 = r0.zzO
            r2 = 32
            if (r1 != r2) goto L_0x01e5
            goto L_0x0245
        L_0x01e5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Unsupported floating point PCM bit depth: "
            r2.append(r5)
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r13, r1)
            goto L_0x027e
        L_0x01fe:
            int r1 = r0.zzO
            if (r1 != r5) goto L_0x0204
            r6 = r8
            goto L_0x0245
        L_0x0204:
            r2 = 16
            if (r1 != r2) goto L_0x020b
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0245
        L_0x020b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Unsupported big endian PCM bit depth: "
            r2.append(r5)
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r13, r1)
            goto L_0x027e
        L_0x0223:
            int r1 = r0.zzO
            int r6 = com.google.android.gms.internal.ads.zzen.zzn(r1)
            if (r6 != 0) goto L_0x0245
            int r1 = r0.zzO
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Unsupported little endian PCM bit depth: "
            r2.append(r5)
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r13, r1)
            goto L_0x027e
        L_0x0245:
            r2 = r9
            goto L_0x0391
        L_0x0248:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            boolean r1 = zzh(r2)
            if (r1 == 0) goto L_0x0279
            int r1 = r0.zzO
            int r6 = com.google.android.gms.internal.ads.zzen.zzn(r1)
            if (r6 != 0) goto L_0x0245
            int r1 = r0.zzO
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Unsupported PCM bit depth: "
            r2.append(r5)
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r13, r1)
            goto L_0x027e
        L_0x0279:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
            com.google.android.gms.internal.ads.zzdw.zze(r13, r1)
        L_0x027e:
            r2 = r9
            r6 = r2
            r11 = r12
            goto L_0x0391
        L_0x0283:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r11 = "audio/flac"
            goto L_0x033f
        L_0x028f:
            java.lang.String r11 = "audio/vnd.dts.hd"
            goto L_0x038f
        L_0x0293:
            java.lang.String r11 = "audio/vnd.dts"
            goto L_0x038f
        L_0x0297:
            com.google.android.gms.internal.ads.zzaaq r1 = new com.google.android.gms.internal.ads.zzaaq
            r1.<init>()
            r0.zzS = r1
            java.lang.String r11 = "audio/true-hd"
            goto L_0x038f
        L_0x02a2:
            java.lang.String r11 = "audio/eac3"
            goto L_0x038f
        L_0x02a6:
            java.lang.String r11 = "audio/ac3"
            goto L_0x038f
        L_0x02aa:
            r1 = 4096(0x1000, float:5.74E-42)
            java.lang.String r11 = "audio/mpeg"
            goto L_0x02b3
        L_0x02af:
            r1 = 4096(0x1000, float:5.74E-42)
            java.lang.String r11 = "audio/mpeg-L2"
        L_0x02b3:
            r2 = r1
            r6 = r9
            goto L_0x0391
        L_0x02b7:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            byte[] r2 = r0.zzj
            com.google.android.gms.internal.ads.zzyf r2 = com.google.android.gms.internal.ads.zzyg.zza(r2)
            int r5 = r2.zza
            r0.zzP = r5
            int r5 = r2.zzb
            r0.zzN = r5
            java.lang.String r2 = r2.zzc
            java.lang.String r11 = "audio/mp4a-latm"
            r5 = r1
            r1 = r2
            goto L_0x0374
        L_0x02d5:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r8)
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r6)
            long r10 = r0.zzQ
            java.nio.ByteBuffer r2 = r2.putLong(r10)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r5 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r5)
            long r5 = r0.zzR
            java.nio.ByteBuffer r2 = r2.putLong(r5)
            byte[] r2 = r2.array()
            r1.add(r2)
            r2 = 5760(0x1680, float:8.071E-42)
            java.lang.String r11 = "audio/opus"
            goto L_0x0322
        L_0x0316:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = zzg(r1)
            r2 = 8192(0x2000, float:1.14794E-41)
            java.lang.String r11 = "audio/vorbis"
        L_0x0322:
            r5 = r1
            r6 = r9
            goto L_0x0342
        L_0x0325:
            java.lang.String r11 = "video/x-unknown"
            goto L_0x038f
        L_0x0329:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            android.util.Pair r1 = zzf(r2)
            java.lang.Object r2 = r1.first
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r1 = r1.second
            java.util.List r1 = (java.util.List) r1
        L_0x033f:
            r5 = r1
            r2 = r9
            r6 = r2
        L_0x0342:
            r1 = r14
            goto L_0x0393
        L_0x0344:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            com.google.android.gms.internal.ads.zzzy r1 = com.google.android.gms.internal.ads.zzzy.zza(r2)
            java.util.List r2 = r1.zza
            int r5 = r1.zzb
            r0.zzW = r5
            java.lang.String r1 = r1.zzd
            java.lang.String r11 = "video/hevc"
            goto L_0x0373
        L_0x035c:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            com.google.android.gms.internal.ads.zzyn r1 = com.google.android.gms.internal.ads.zzyn.zza(r2)
            java.util.List r2 = r1.zza
            int r5 = r1.zzb
            r0.zzW = r5
            java.lang.String r1 = r1.zzf
            java.lang.String r11 = "video/avc"
        L_0x0373:
            r5 = r2
        L_0x0374:
            r2 = r9
            r6 = r2
            goto L_0x0393
        L_0x0377:
            byte[] r1 = r0.zzj
            if (r1 != 0) goto L_0x037d
            r1 = r14
            goto L_0x0381
        L_0x037d:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x0381:
            java.lang.String r11 = "video/mp4v-es"
            goto L_0x033f
        L_0x0384:
            java.lang.String r11 = "video/mpeg2"
            goto L_0x038f
        L_0x0387:
            java.lang.String r11 = "video/av01"
            goto L_0x038f
        L_0x038a:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            goto L_0x038f
        L_0x038d:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
        L_0x038f:
            r2 = r9
            r6 = r2
        L_0x0391:
            r1 = r14
            r5 = r1
        L_0x0393:
            byte[] r10 = r0.zzM
            if (r10 == 0) goto L_0x03a6
            com.google.android.gms.internal.ads.zzef r12 = new com.google.android.gms.internal.ads.zzef
            r12.<init>((byte[]) r10)
            com.google.android.gms.internal.ads.zzze r10 = com.google.android.gms.internal.ads.zzze.zza(r12)
            if (r10 == 0) goto L_0x03a6
            java.lang.String r1 = r10.zza
            java.lang.String r11 = "video/dolby-vision"
        L_0x03a6:
            boolean r10 = r0.zzU
            boolean r12 = r0.zzT
            if (r3 == r12) goto L_0x03ae
            r12 = r7
            goto L_0x03af
        L_0x03ae:
            r12 = r4
        L_0x03af:
            r10 = r10 | r12
            com.google.android.gms.internal.ads.zzad r12 = new com.google.android.gms.internal.ads.zzad
            r12.<init>()
            boolean r13 = com.google.android.gms.internal.ads.zzbt.zzg(r11)
            if (r13 == 0) goto L_0x03cb
            int r4 = r0.zzN
            r12.zzw(r4)
            int r4 = r0.zzP
            r12.zzT(r4)
            r12.zzN(r6)
            r8 = r3
            goto L_0x058a
        L_0x03cb:
            boolean r3 = com.google.android.gms.internal.ads.zzbt.zzh(r11)
            if (r3 == 0) goto L_0x0552
            int r3 = r0.zzp
            if (r3 != 0) goto L_0x03e5
            int r3 = r0.zzn
            if (r3 != r9) goto L_0x03db
            int r3 = r0.zzl
        L_0x03db:
            r0.zzn = r3
            int r3 = r0.zzo
            if (r3 != r9) goto L_0x03e3
            int r3 = r0.zzm
        L_0x03e3:
            r0.zzo = r3
        L_0x03e5:
            int r3 = r0.zzn
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r3 == r9) goto L_0x03f9
            int r8 = r0.zzo
            if (r8 == r9) goto L_0x03f9
            int r13 = r0.zzm
            int r13 = r13 * r3
            float r3 = (float) r13
            int r13 = r0.zzl
            int r13 = r13 * r8
            float r8 = (float) r13
            float r3 = r3 / r8
            goto L_0x03fa
        L_0x03f9:
            r3 = r6
        L_0x03fa:
            boolean r8 = r0.zzw
            if (r8 == 0) goto L_0x04c1
            float r8 = r0.zzC
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04b5
            float r8 = r0.zzD
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04b5
            float r8 = r0.zzE
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04b5
            float r8 = r0.zzF
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04b5
            float r8 = r0.zzG
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04b5
            float r8 = r0.zzH
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04b5
            float r8 = r0.zzI
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04b5
            float r8 = r0.zzJ
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04b5
            float r8 = r0.zzK
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04b5
            float r8 = r0.zzL
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x043b
            goto L_0x04b5
        L_0x043b:
            r6 = 25
            byte[] r14 = new byte[r6]
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r14)
            java.nio.ByteOrder r8 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r6 = r6.order(r8)
            r6.put(r7)
            float r8 = r0.zzC
            r13 = 1195593728(0x47435000, float:50000.0)
            float r8 = r8 * r13
            r15 = 1056964608(0x3f000000, float:0.5)
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            float r8 = r0.zzD
            float r8 = r8 * r13
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            float r8 = r0.zzE
            float r8 = r8 * r13
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            float r8 = r0.zzF
            float r8 = r8 * r13
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            float r8 = r0.zzG
            float r8 = r8 * r13
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            float r8 = r0.zzH
            float r8 = r8 * r13
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            float r8 = r0.zzI
            float r8 = r8 * r13
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            float r8 = r0.zzJ
            float r8 = r8 * r13
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            float r8 = r0.zzK
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            float r8 = r0.zzL
            float r8 = r8 + r15
            int r8 = (int) r8
            short r8 = (short) r8
            r6.putShort(r8)
            int r8 = r0.zzA
            short r8 = (short) r8
            r6.putShort(r8)
            int r8 = r0.zzB
            short r8 = (short) r8
            r6.putShort(r8)
        L_0x04b5:
            com.google.android.gms.internal.ads.zzq r6 = new com.google.android.gms.internal.ads.zzq
            int r8 = r0.zzx
            int r13 = r0.zzz
            int r15 = r0.zzy
            r6.<init>(r8, r13, r15, r14)
            r14 = r6
        L_0x04c1:
            java.lang.String r6 = r0.zza
            if (r6 == 0) goto L_0x04e2
            java.util.Map r6 = com.google.android.gms.internal.ads.zzaei.zzg
            java.lang.String r8 = r0.zza
            boolean r6 = r6.containsKey(r8)
            if (r6 == 0) goto L_0x04e2
            java.util.Map r6 = com.google.android.gms.internal.ads.zzaei.zzg
            java.lang.String r8 = r0.zza
            java.lang.Object r6 = r6.get(r8)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r9 = r6
        L_0x04e2:
            int r6 = r0.zzq
            if (r6 != 0) goto L_0x0532
            float r6 = r0.zzr
            r8 = 0
            int r6 = java.lang.Float.compare(r6, r8)
            if (r6 != 0) goto L_0x0532
            float r6 = r0.zzs
            int r6 = java.lang.Float.compare(r6, r8)
            if (r6 != 0) goto L_0x0532
            float r6 = r0.zzt
            int r6 = java.lang.Float.compare(r6, r8)
            if (r6 != 0) goto L_0x0500
            goto L_0x0533
        L_0x0500:
            float r6 = r0.zzs
            r7 = 1119092736(0x42b40000, float:90.0)
            int r6 = java.lang.Float.compare(r6, r7)
            if (r6 != 0) goto L_0x050d
            r7 = 90
            goto L_0x0533
        L_0x050d:
            float r6 = r0.zzs
            r7 = -1020002304(0xffffffffc3340000, float:-180.0)
            int r6 = java.lang.Float.compare(r6, r7)
            if (r6 == 0) goto L_0x052f
            float r6 = r0.zzs
            r7 = 1127481344(0x43340000, float:180.0)
            int r6 = java.lang.Float.compare(r6, r7)
            if (r6 != 0) goto L_0x0522
            goto L_0x052f
        L_0x0522:
            float r6 = r0.zzs
            r7 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r6 = java.lang.Float.compare(r6, r7)
            if (r6 != 0) goto L_0x0532
            r7 = 270(0x10e, float:3.78E-43)
            goto L_0x0533
        L_0x052f:
            r7 = 180(0xb4, float:2.52E-43)
            goto L_0x0533
        L_0x0532:
            r7 = r9
        L_0x0533:
            int r6 = r0.zzl
            r12.zzX(r6)
            int r6 = r0.zzm
            r12.zzF(r6)
            r12.zzP(r3)
            r12.zzR(r7)
            byte[] r3 = r0.zzu
            r12.zzQ(r3)
            int r3 = r0.zzv
            r12.zzV(r3)
            r12.zzy(r14)
            r8 = r4
            goto L_0x058a
        L_0x0552:
            java.lang.String r3 = "application/x-subrip"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L_0x058a
            java.lang.String r3 = "text/x-ssa"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L_0x058a
            java.lang.String r3 = "text/vtt"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L_0x058a
            java.lang.String r3 = "application/vobsub"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L_0x058a
            java.lang.String r3 = "application/pgs"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L_0x058a
            java.lang.String r3 = "application/dvbsubs"
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x0583
            goto L_0x058a
        L_0x0583:
            java.lang.String r1 = "Unexpected MIME type."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r14)
            throw r1
        L_0x058a:
            java.lang.String r3 = r0.zza
            if (r3 == 0) goto L_0x059f
            java.util.Map r3 = com.google.android.gms.internal.ads.zzaei.zzg
            java.lang.String r4 = r0.zza
            boolean r3 = r3.containsKey(r4)
            if (r3 != 0) goto L_0x059f
            java.lang.String r3 = r0.zza
            r12.zzJ(r3)
        L_0x059f:
            r3 = r18
            r12.zzG(r3)
            r12.zzS(r11)
            r12.zzL(r2)
            java.lang.String r2 = r0.zzY
            r12.zzK(r2)
            r12.zzU(r10)
            r12.zzI(r5)
            r12.zzx(r1)
            com.google.android.gms.internal.ads.zzx r1 = r0.zzk
            r12.zzB(r1)
            com.google.android.gms.internal.ads.zzaf r1 = r12.zzY()
            int r2 = r0.zzc
            r3 = r17
            com.google.android.gms.internal.ads.zzaap r2 = r3.zzv(r2, r8)
            r0.zzV = r2
            com.google.android.gms.internal.ads.zzaap r2 = r0.zzV
            r2.zzk(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeh.zze(com.google.android.gms.internal.ads.zzzl, int):void");
    }
}
