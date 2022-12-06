package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaig {
    private final zzel zza = new zzel(0);
    private final zzef zzb = new zzef();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;

    zzaig(int i) {
    }

    private final int zze(zzzj zzzj) {
        zzef zzef = this.zzb;
        byte[] bArr = zzen.zzf;
        int length = bArr.length;
        zzef.zzD(bArr, 0);
        this.zzc = true;
        zzzj.zzj();
        return 0;
    }

    public final int zza(zzzj zzzj, zzaai zzaai, int i) throws IOException {
        long j;
        if (i <= 0) {
            zze(zzzj);
            return 0;
        }
        boolean z = this.zze;
        long j2 = C.TIME_UNSET;
        if (!z) {
            long zzd2 = zzzj.zzd();
            int min = (int) Math.min(112800, zzd2);
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
            int zzd3 = zzef.zzd();
            int i2 = zzd3 - 188;
            while (true) {
                if (i2 < zzc2) {
                    break;
                }
                byte[] zzH = zzef.zzH();
                int i3 = -4;
                int i4 = 0;
                while (true) {
                    if (i3 > 4) {
                        break;
                    }
                    int i5 = (i3 * 188) + i2;
                    if (i5 < zzc2 || i5 >= zzd3 || zzH[i5] != 71) {
                        i4 = 0;
                    } else {
                        i4++;
                        if (i4 == 5) {
                            long zzb2 = zzaiq.zzb(zzef, i2, i);
                            if (zzb2 != C.TIME_UNSET) {
                                j2 = zzb2;
                                break;
                            }
                        }
                    }
                    i3++;
                }
                i2--;
            }
            this.zzg = j2;
            this.zze = true;
            return 0;
        } else if (this.zzg == C.TIME_UNSET) {
            zze(zzzj);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(112800, zzzj.zzd());
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
                if (zzc3 >= zzd4) {
                    j = -9223372036854775807L;
                    break;
                }
                if (zzef2.zzH()[zzc3] == 71) {
                    j = zzaiq.zzb(zzef2, zzc3, i);
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
                zze(zzzj);
                return 0;
            }
            long zzb3 = this.zza.zzb(this.zzg) - this.zza.zzb(j4);
            this.zzh = zzb3;
            if (zzb3 < 0) {
                zzdw.zze("TsDurationReader", "Invalid duration: " + zzb3 + ". Using TIME_UNSET instead.");
                this.zzh = C.TIME_UNSET;
            }
            zze(zzzj);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzel zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
