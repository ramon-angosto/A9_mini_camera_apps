package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzagu implements zzzi {
    public static final zzzp zza = zzagt.zza;
    private final zzagv zzb = new zzagv((String) null);
    private final zzef zzc = new zzef(16384);
    private boolean zzd;

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        int zza2 = zzzj.zza(this.zzc.zzH(), 0, 16384);
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzF(0);
        this.zzc.zzE(zza2);
        if (!this.zzd) {
            this.zzb.zzd(0, 4);
            this.zzd = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    public final void zzb(zzzl zzzl) {
        this.zzb.zzb(zzzl, new zzaio(Integer.MIN_VALUE, 0, 1));
        zzzl.zzC();
        zzzl.zzN(new zzaak(C.TIME_UNSET, 0));
    }

    public final void zzc(long j, long j2) {
        this.zzd = false;
        this.zzb.zze();
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        zzyy zzyy;
        int i;
        zzef zzef = new zzef(10);
        int i2 = 0;
        while (true) {
            zzyy = (zzyy) zzzj;
            zzyy.zzm(zzef.zzH(), 0, 10, false);
            zzef.zzF(0);
            if (zzef.zzm() != 4801587) {
                break;
            }
            zzef.zzG(3);
            int zzj = zzef.zzj();
            i2 += zzj + 10;
            zzyy.zzl(zzj, false);
        }
        zzzj.zzj();
        zzyy.zzl(i2, false);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            zzyy.zzm(zzef.zzH(), 0, 7, false);
            zzef.zzF(0);
            int zzo = zzef.zzo();
            if (zzo == 44096 || zzo == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] zzH = zzef.zzH();
                int i6 = zzym.zza;
                if (zzH.length < 7) {
                    i = -1;
                } else {
                    byte b = ((zzH[2] & UByte.MAX_VALUE) << 8) | (zzH[3] & UByte.MAX_VALUE);
                    if (b == 65535) {
                        b = ((zzH[4] & UByte.MAX_VALUE) << 16) | ((zzH[5] & UByte.MAX_VALUE) << 8) | (zzH[6] & UByte.MAX_VALUE);
                    } else {
                        i5 = 4;
                    }
                    if (zzo == 44097) {
                        i5 += 2;
                    }
                    i = b + i5;
                }
                if (i == -1) {
                    return false;
                }
                zzyy.zzl(i - 7, false);
            } else {
                zzzj.zzj();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                zzyy.zzl(i4, false);
                i3 = 0;
            }
        }
    }
}
