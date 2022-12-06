package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzagy implements zzahc {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzee zzc = new zzee(new byte[7], 7);
    private final zzef zzd = new zzef(Arrays.copyOf(zza, 10));
    private final String zze;
    private String zzf;
    private zzaap zzg;
    private zzaap zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private zzaap zzu;
    private long zzv;

    public zzagy(boolean z, String str) {
        zzh();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = C.TIME_UNSET;
        this.zzt = C.TIME_UNSET;
        this.zzb = z;
        this.zze = str;
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzm = false;
        zzh();
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 256;
    }

    private final void zzi() {
        this.zzi = 3;
        this.zzj = 0;
    }

    private final void zzj(zzaap zzaap, long j, int i, int i2) {
        this.zzi = 4;
        this.zzj = i;
        this.zzu = zzaap;
        this.zzv = j;
        this.zzs = i2;
    }

    private final boolean zzk(zzef zzef, byte[] bArr, int i) {
        int min = Math.min(zzef.zza(), i - this.zzj);
        zzef.zzB(bArr, this.zzj, min);
        int i2 = this.zzj + min;
        this.zzj = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & UByte.MAX_VALUE) | UByte.MIN_VALUE);
    }

    private static final boolean zzm(zzef zzef, byte[] bArr, int i) {
        if (zzef.zza() < i) {
            return false;
        }
        zzef.zzB(bArr, 0, i);
        return true;
    }

    public final void zza(zzef zzef) throws zzbu {
        int i;
        byte b;
        int i2;
        int i3;
        zzef zzef2 = zzef;
        if (this.zzg != null) {
            int i4 = zzen.zza;
            while (zzef.zza() > 0) {
                int i5 = this.zzi;
                int i6 = 13;
                int i7 = 2;
                if (i5 == 0) {
                    byte[] zzH = zzef.zzH();
                    int zzc2 = zzef.zzc();
                    int zzd2 = zzef.zzd();
                    while (true) {
                        if (zzc2 >= zzd2) {
                            zzef2.zzF(zzc2);
                            break;
                        }
                        i = zzc2 + 1;
                        b = zzH[zzc2] & UByte.MAX_VALUE;
                        if (this.zzk == 512 && zzl((byte) -1, (byte) b)) {
                            if (this.zzm) {
                                break;
                            }
                            int i8 = i - 2;
                            zzef2.zzF(i8 + 1);
                            if (zzm(zzef2, this.zzc.zza, 1)) {
                                this.zzc.zzh(4);
                                int zzc3 = this.zzc.zzc(1);
                                int i9 = this.zzn;
                                if (i9 == -1 || zzc3 == i9) {
                                    if (this.zzo != -1) {
                                        if (!zzm(zzef2, this.zzc.zza, 1)) {
                                            break;
                                        }
                                        this.zzc.zzh(i7);
                                        if (this.zzc.zzc(4) == this.zzo) {
                                            zzef2.zzF(i8 + 2);
                                        }
                                    }
                                    if (!zzm(zzef2, this.zzc.zza, 4)) {
                                        break;
                                    }
                                    this.zzc.zzh(14);
                                    int zzc4 = this.zzc.zzc(i6);
                                    if (zzc4 >= 7) {
                                        byte[] zzH2 = zzef.zzH();
                                        int zzd3 = zzef.zzd();
                                        int i10 = i8 + zzc4;
                                        if (i10 < zzd3) {
                                            byte b2 = zzH2[i10];
                                            if (b2 != -1) {
                                                if (b2 == 73) {
                                                    int i11 = i10 + 1;
                                                    if (i11 != zzd3) {
                                                        if (zzH2[i11] == 68) {
                                                            int i12 = i10 + 2;
                                                            if (i12 != zzd3) {
                                                                if (zzH2[i12] == 51) {
                                                                    break;
                                                                }
                                                            } else {
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                int i13 = i10 + 1;
                                                if (i13 == zzd3) {
                                                    break;
                                                }
                                                byte b3 = zzH2[i13];
                                                if (zzl((byte) -1, b3) && ((b3 & 8) >> 3) == zzc3) {
                                                    break;
                                                }
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        int i14 = this.zzk;
                        byte b4 = i14 | b;
                        if (b4 == 329) {
                            i2 = 2;
                            i3 = 768;
                        } else if (b4 == 511) {
                            i2 = 2;
                            i3 = 512;
                        } else if (b4 != 836) {
                            if (b4 == 1075) {
                                this.zzi = 2;
                                this.zzj = 3;
                                this.zzs = 0;
                                this.zzd.zzF(0);
                                zzef2.zzF(i);
                                break;
                            } else if (i14 != 256) {
                                this.zzk = 256;
                                zzc2 = i - 1;
                                i6 = 13;
                                i7 = 2;
                            } else {
                                i2 = 2;
                                i7 = i2;
                                zzc2 = i;
                                i6 = 13;
                            }
                        } else {
                            i2 = 2;
                            i3 = 1024;
                        }
                        this.zzk = i3;
                        i7 = i2;
                        zzc2 = i;
                        i6 = 13;
                    }
                    this.zzp = (b & 8) >> 3;
                    this.zzl = 1 == ((b & 1) ^ 1);
                    if (!this.zzm) {
                        this.zzi = 1;
                        this.zzj = 0;
                    } else {
                        zzi();
                    }
                    zzef2.zzF(i);
                } else if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            int min = Math.min(zzef.zza(), this.zzs - this.zzj);
                            this.zzu.zzq(zzef2, min);
                            int i15 = this.zzj + min;
                            this.zzj = i15;
                            int i16 = this.zzs;
                            if (i15 == i16) {
                                long j = this.zzt;
                                if (j != C.TIME_UNSET) {
                                    this.zzu.zzs(j, 1, i16, 0, (zzaao) null);
                                    this.zzt += this.zzv;
                                }
                                zzh();
                            }
                        } else {
                            if (zzk(zzef2, this.zzc.zza, true != this.zzl ? 5 : 7)) {
                                this.zzc.zzh(0);
                                if (!this.zzq) {
                                    int zzc5 = this.zzc.zzc(2) + 1;
                                    if (zzc5 != 2) {
                                        zzdw.zze("AdtsReader", "Detected audio object type: " + zzc5 + ", but assuming AAC LC.");
                                    }
                                    this.zzc.zzj(5);
                                    int zzc6 = this.zzc.zzc(3);
                                    int i17 = this.zzo;
                                    int i18 = zzyg.zza;
                                    byte[] bArr = {(byte) (((i17 >> 1) & 7) | 16), (byte) (((zzc6 << 3) & 120) | ((i17 << 7) & 128))};
                                    zzyf zza2 = zzyg.zza(bArr);
                                    zzad zzad = new zzad();
                                    zzad.zzH(this.zzf);
                                    zzad.zzS(MimeTypes.AUDIO_AAC);
                                    zzad.zzx(zza2.zzc);
                                    zzad.zzw(zza2.zzb);
                                    zzad.zzT(zza2.zza);
                                    zzad.zzI(Collections.singletonList(bArr));
                                    zzad.zzK(this.zze);
                                    zzaf zzY = zzad.zzY();
                                    this.zzr = 1024000000 / ((long) zzY.zzA);
                                    this.zzg.zzk(zzY);
                                    this.zzq = true;
                                } else {
                                    this.zzc.zzj(10);
                                }
                                this.zzc.zzj(4);
                                int zzc7 = this.zzc.zzc(13) - 7;
                                if (this.zzl) {
                                    zzc7 -= 2;
                                }
                                zzj(this.zzg, this.zzr, 0, zzc7);
                            }
                        }
                    } else if (zzk(zzef2, this.zzd.zzH(), 10)) {
                        this.zzh.zzq(this.zzd, 10);
                        this.zzd.zzF(6);
                        zzj(this.zzh, 0, 10, 10 + this.zzd.zzj());
                    }
                } else if (zzef.zza() != 0) {
                    zzee zzee = this.zzc;
                    zzee.zza[0] = zzef.zzH()[zzef.zzc()];
                    zzee.zzh(2);
                    int zzc8 = this.zzc.zzc(4);
                    int i19 = this.zzo;
                    if (i19 == -1 || zzc8 == i19) {
                        if (!this.zzm) {
                            this.zzm = true;
                            this.zzn = this.zzp;
                            this.zzo = zzc8;
                        }
                        zzi();
                    } else {
                        zzg();
                    }
                }
            }
            return;
        }
        throw null;
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zzf = zzaio.zzb();
        this.zzg = zzzl.zzv(zzaio.zza(), 1);
        this.zzu = this.zzg;
        if (this.zzb) {
            zzaio.zzc();
            this.zzh = zzzl.zzv(zzaio.zza(), 5);
            zzaap zzaap = this.zzh;
            zzad zzad = new zzad();
            zzad.zzH(zzaio.zzb());
            zzad.zzS(MimeTypes.APPLICATION_ID3);
            zzaap.zzk(zzad.zzY());
            return;
        }
        this.zzh = new zzzh();
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        if (j != C.TIME_UNSET) {
            this.zzt = j;
        }
    }

    public final void zze() {
        this.zzt = C.TIME_UNSET;
        zzg();
    }
}
