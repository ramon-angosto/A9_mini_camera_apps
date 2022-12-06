package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzahx {
    private final zzel zza = new zzel(0);
    private final zzef zzb = new zzef();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;

    zzahx() {
    }

    public static long zzc(zzef zzef) {
        zzef zzef2 = zzef;
        int zzc2 = zzef.zzc();
        if (zzef.zza() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        zzef2.zzB(bArr, 0, 9);
        zzef2.zzF(zzc2);
        if ((bArr[0] & 196) != 68 || (bArr[2] & 4) != 4 || (bArr[4] & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return C.TIME_UNSET;
        }
        long j = (long) bArr[0];
        byte b = bArr[1];
        long j2 = (long) bArr[2];
        return ((((long) bArr[3]) & 255) << 5) | ((j & 3) << 28) | (((56 & j) >> 3) << 30) | ((((long) b) & 255) << 20) | (((j2 & 248) >> 3) << 15) | ((j2 & 3) << 13) | ((((long) bArr[4]) & 248) >> 3);
    }

    private final int zzf(zzzj zzzj) {
        zzef zzef = this.zzb;
        byte[] bArr = zzen.zzf;
        int length = bArr.length;
        zzef.zzD(bArr, 0);
        this.zzc = true;
        zzzj.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        long j;
        long j2;
        if (!this.zze) {
            long zzd2 = zzzj.zzd();
            int min = (int) Math.min(20000, zzd2);
            long j3 = zzd2 - ((long) min);
            if (zzzj.zzf() != j3) {
                zzaai.zza = j3;
                return 1;
            }
            this.zzb.zzC(min);
            zzzj.zzj();
            ((zzyy) zzzj).zzm(this.zzb.zzH(), 0, min, false);
            zzef zzef = this.zzb;
            int zzc2 = zzef.zzc();
            int zzd3 = zzef.zzd() - 4;
            while (true) {
                if (zzd3 < zzc2) {
                    j2 = -9223372036854775807L;
                    break;
                }
                if (zzg(zzef.zzH(), zzd3) == 442) {
                    zzef.zzF(zzd3 + 4);
                    j2 = zzc(zzef);
                    if (j2 != C.TIME_UNSET) {
                        break;
                    }
                }
                zzd3--;
            }
            this.zzg = j2;
            this.zze = true;
            return 0;
        } else if (this.zzg == C.TIME_UNSET) {
            zzf(zzzj);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(20000, zzzj.zzd());
            if (zzzj.zzf() != 0) {
                zzaai.zza = 0;
                return 1;
            }
            this.zzb.zzC(min2);
            zzzj.zzj();
            ((zzyy) zzzj).zzm(this.zzb.zzH(), 0, min2, false);
            zzef zzef2 = this.zzb;
            int zzc3 = zzef2.zzc();
            int zzd4 = zzef2.zzd();
            while (true) {
                if (zzc3 >= zzd4 - 3) {
                    j = -9223372036854775807L;
                    break;
                }
                if (zzg(zzef2.zzH(), zzc3) == 442) {
                    zzef2.zzF(zzc3 + 4);
                    j = zzc(zzef2);
                    if (j != C.TIME_UNSET) {
                        break;
                    }
                }
                zzc3++;
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        } else {
            long j4 = this.zzf;
            if (j4 == C.TIME_UNSET) {
                zzf(zzzj);
                return 0;
            }
            long zzb2 = this.zza.zzb(this.zzg) - this.zza.zzb(j4);
            this.zzh = zzb2;
            if (zzb2 < 0) {
                zzdw.zze("PsDurationReader", "Invalid duration: " + zzb2 + ". Using TIME_UNSET instead.");
                this.zzh = C.TIME_UNSET;
            }
            zzf(zzzj);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzel zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
