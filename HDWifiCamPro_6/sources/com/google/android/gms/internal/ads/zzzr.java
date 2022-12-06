package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzr {
    public static int zza(zzef zzef, int i) {
        switch (i) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzef.zzk() + 1;
            case 7:
                return zzef.zzo() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzzj zzzj, zzzv zzzv) throws IOException {
        zzzj.zzj();
        zzyy zzyy = (zzyy) zzzj;
        boolean z = false;
        zzyy.zzl(1, false);
        byte[] bArr = new byte[1];
        zzyy.zzm(bArr, 0, 1, false);
        byte b = bArr[0] & 1;
        zzyy.zzl(2, false);
        int i = 1 != b ? 6 : 7;
        zzef zzef = new zzef(i);
        zzef.zzE(zzzm.zza(zzzj, zzef.zzH(), 0, i));
        zzzj.zzj();
        zzzq zzzq = new zzzq();
        if (1 == b) {
            z = true;
        }
        if (zzd(zzef, zzzv, z, zzzq)) {
            return zzzq.zza;
        }
        throw zzbu.zza((String) null, (Throwable) null);
    }

    public static boolean zzc(zzef zzef, zzzv zzzv, int i, zzzq zzzq) {
        int zza;
        zzef zzef2 = zzef;
        zzzv zzzv2 = zzzv;
        int zzc = zzef.zzc();
        long zzs = zzef.zzs();
        long j = zzs >>> 16;
        if (j != ((long) i)) {
            return false;
        }
        boolean z = (j & 1) == 1;
        int i2 = (int) ((zzs >> 12) & 15);
        int i3 = (int) ((zzs >> 8) & 15);
        int i4 = (int) (15 & (zzs >> 4));
        int i5 = (int) ((zzs >> 1) & 7);
        long j2 = zzs & 1;
        if (i4 <= 7) {
            if (i4 != zzzv2.zzg - 1) {
                return false;
            }
        } else if (i4 > 10 || zzzv2.zzg != 2) {
            return false;
        }
        if ((i5 != 0 && i5 != zzzv2.zzi) || j2 == 1 || !zzd(zzef2, zzzv2, z, zzzq) || (zza = zza(zzef2, i2)) == -1 || zza > zzzv2.zzb) {
            return false;
        }
        int i6 = zzzv2.zze;
        if (i3 != 0) {
            if (i3 <= 11) {
                if (i3 != zzzv2.zzf) {
                    return false;
                }
            } else if (i3 == 12) {
                if (zzef.zzk() * 1000 != i6) {
                    return false;
                }
            } else if (i3 > 14) {
                return false;
            } else {
                int zzo = zzef.zzo();
                if (i3 == 14) {
                    zzo *= 10;
                }
                if (zzo != i6) {
                    return false;
                }
            }
        }
        if (zzef.zzk() == zzen.zzh(zzef.zzH(), zzc, zzef.zzc() - 1, 0)) {
            return true;
        }
        return false;
    }

    private static boolean zzd(zzef zzef, zzzv zzzv, boolean z, zzzq zzzq) {
        try {
            long zzu = zzef.zzu();
            if (!z) {
                zzu *= (long) zzzv.zzb;
            }
            zzzq.zza = zzu;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
