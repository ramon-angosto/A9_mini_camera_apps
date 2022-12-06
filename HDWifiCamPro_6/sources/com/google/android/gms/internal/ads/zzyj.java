package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzyj {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        int i = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) <= 10) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return zzb[i] * 256;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i = ((bArr[3] & UByte.MAX_VALUE) | ((bArr[2] & 7) << 8)) + 1;
            return i + i;
        }
        byte b = bArr[4];
        return zzf((b & 192) >> 6, b & 63);
    }

    public static zzaf zzc(zzef zzef, String str, String str2, zzx zzx) {
        int i = zzc[(zzef.zzk() & PsExtractor.AUDIO_STREAM) >> 6];
        int zzk = zzef.zzk();
        int i2 = zze[(zzk & 56) >> 3];
        if ((zzk & 4) != 0) {
            i2++;
        }
        zzad zzad = new zzad();
        zzad.zzH(str);
        zzad.zzS(MimeTypes.AUDIO_AC3);
        zzad.zzw(i2);
        zzad.zzT(i);
        zzad.zzB(zzx);
        zzad.zzK(str2);
        return zzad.zzY();
    }

    public static zzaf zzd(zzef zzef, String str, String str2, zzx zzx) {
        zzef.zzG(2);
        int i = zzc[(zzef.zzk() & PsExtractor.AUDIO_STREAM) >> 6];
        int zzk = zzef.zzk();
        int i2 = zze[(zzk & 14) >> 1];
        if ((zzk & 1) != 0) {
            i2++;
        }
        if (((zzef.zzk() & 30) >> 1) > 0 && (2 & zzef.zzk()) != 0) {
            i2 += 2;
        }
        String str3 = (zzef.zza() <= 0 || (zzef.zzk() & 1) == 0) ? MimeTypes.AUDIO_E_AC3 : MimeTypes.AUDIO_E_AC3_JOC;
        zzad zzad = new zzad();
        zzad.zzH(str);
        zzad.zzS(str3);
        zzad.zzw(i2);
        zzad.zzT(i);
        zzad.zzB(zzx);
        zzad.zzK(str2);
        return zzad.zzY();
    }

    public static zzyi zze(zzee zzee) {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        zzee zzee2 = zzee;
        int zzb2 = zzee.zzb();
        zzee2.zzj(40);
        int zzc2 = zzee2.zzc(5);
        zzee2.zzh(zzb2);
        int i11 = -1;
        if (zzc2 > 10) {
            zzee2.zzj(16);
            int zzc3 = zzee2.zzc(2);
            if (zzc3 == 0) {
                i11 = 0;
            } else if (zzc3 == 1) {
                i11 = 1;
            } else if (zzc3 == 2) {
                i11 = 2;
            }
            zzee2.zzj(3);
            int zzc4 = zzee2.zzc(11) + 1;
            i4 = zzc4 + zzc4;
            int zzc5 = zzee2.zzc(2);
            if (zzc5 == 3) {
                i5 = 6;
                i2 = zzd[zzee2.zzc(2)];
                i6 = 3;
            } else {
                i6 = zzee2.zzc(2);
                i5 = zzb[i6];
                i2 = zzc[zzc5];
            }
            i3 = i5 * 256;
            int zzc6 = zzee2.zzc(3);
            boolean zzl = zzee.zzl();
            i = zze[zzc6] + (zzl ? 1 : 0);
            zzee2.zzj(10);
            if (zzee.zzl()) {
                zzee2.zzj(8);
            }
            if (zzc6 == 0) {
                zzee2.zzj(5);
                if (zzee.zzl()) {
                    zzee2.zzj(8);
                }
                i7 = 0;
                zzc6 = 0;
            } else {
                i7 = zzc6;
            }
            if (i11 == 1) {
                if (zzee.zzl()) {
                    zzee2.zzj(16);
                }
                i8 = 1;
            } else {
                i8 = i11;
            }
            if (zzee.zzl()) {
                if (i7 > 2) {
                    zzee2.zzj(2);
                }
                if ((i7 & 1) != 0 && i7 > 2) {
                    zzee2.zzj(6);
                }
                if ((i7 & 4) != 0) {
                    zzee2.zzj(6);
                }
                if (zzl && zzee.zzl()) {
                    zzee2.zzj(5);
                }
                if (i8 == 0) {
                    if (zzee.zzl()) {
                        zzee2.zzj(6);
                    }
                    if (i7 == 0 && zzee.zzl()) {
                        zzee2.zzj(6);
                    }
                    if (zzee.zzl()) {
                        zzee2.zzj(6);
                    }
                    int zzc7 = zzee2.zzc(2);
                    if (zzc7 == 1) {
                        zzee2.zzj(5);
                    } else if (zzc7 == 2) {
                        zzee2.zzj(12);
                    } else if (zzc7 == 3) {
                        int zzc8 = zzee2.zzc(5);
                        if (zzee.zzl()) {
                            zzee2.zzj(5);
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                if (zzee.zzl()) {
                                    zzee2.zzj(4);
                                }
                                if (zzee.zzl()) {
                                    zzee2.zzj(4);
                                }
                            }
                        }
                        if (zzee.zzl()) {
                            zzee2.zzj(5);
                            if (zzee.zzl()) {
                                zzee2.zzj(7);
                                if (zzee.zzl()) {
                                    i10 = 8;
                                    zzee2.zzj(8);
                                    zzee2.zzj((zzc8 + 2) * i10);
                                    zzee.zzd();
                                }
                            }
                        }
                        i10 = 8;
                        zzee2.zzj((zzc8 + 2) * i10);
                        zzee.zzd();
                    }
                    if (i7 < 2) {
                        if (zzee.zzl()) {
                            zzee2.zzj(14);
                        }
                        if (zzc6 == 0 && zzee.zzl()) {
                            zzee2.zzj(14);
                        }
                    }
                    if (zzee.zzl()) {
                        if (i6 == 0) {
                            zzee2.zzj(5);
                            i8 = 0;
                            i6 = 0;
                        } else {
                            for (int i12 = 0; i12 < i5; i12++) {
                                if (zzee.zzl()) {
                                    zzee2.zzj(5);
                                }
                            }
                        }
                    }
                    i8 = 0;
                }
            }
            if (zzee.zzl()) {
                zzee2.zzj(5);
                if (i7 == 2) {
                    zzee2.zzj(4);
                    i7 = 2;
                }
                if (i7 >= 6) {
                    zzee2.zzj(2);
                }
                if (zzee.zzl()) {
                    i9 = 8;
                    zzee2.zzj(8);
                } else {
                    i9 = 8;
                }
                if (i7 == 0 && zzee.zzl()) {
                    zzee2.zzj(i9);
                }
                if (zzc5 < 3) {
                    zzee.zzi();
                }
            }
            if (i8 == 0 && i6 != 3) {
                zzee.zzi();
            }
            if (i8 == 2 && (i6 == 3 || zzee.zzl())) {
                zzee2.zzj(6);
            }
            str = (zzee.zzl() && zzee2.zzc(6) == 1 && zzee2.zzc(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
        } else {
            zzee2.zzj(32);
            int zzc9 = zzee2.zzc(2);
            String str2 = zzc9 == 3 ? null : MimeTypes.AUDIO_AC3;
            i4 = zzf(zzc9, zzee2.zzc(6));
            zzee2.zzj(8);
            int zzc10 = zzee2.zzc(3);
            if (!((zzc10 & 1) == 0 || zzc10 == 1)) {
                zzee2.zzj(2);
            }
            if ((zzc10 & 4) != 0) {
                zzee2.zzj(2);
            }
            if (zzc10 == 2) {
                zzee2.zzj(2);
            }
            i2 = zzc9 < 3 ? zzc[zzc9] : -1;
            i = zze[zzc10] + (zzee.zzl() ? 1 : 0);
            i3 = 1536;
            str = str2;
        }
        return new zzyi(str, i11, i, i2, i4, i3, (zzyh) null);
    }

    private static int zzf(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= 3 || i2 < 0 || i3 >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
