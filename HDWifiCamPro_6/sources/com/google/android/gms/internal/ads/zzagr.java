package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzagr implements zzzi {
    public static final zzzp zza = zzagq.zza;
    private final zzags zzb = new zzags((String) null);
    private final zzef zzc = new zzef(2786);
    private boolean zzd;

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        int zza2 = zzzj.zza(this.zzc.zzH(), 0, 2786);
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
        zzef zzef = new zzef(10);
        int i = 0;
        while (true) {
            zzyy = (zzyy) zzzj;
            zzyy.zzm(zzef.zzH(), 0, 10, false);
            zzef.zzF(0);
            if (zzef.zzm() != 4801587) {
                break;
            }
            zzef.zzG(3);
            int zzj = zzef.zzj();
            i += zzj + 10;
            zzyy.zzl(zzj, false);
        }
        zzzj.zzj();
        zzyy.zzl(i, false);
        int i2 = 0;
        int i3 = i;
        while (true) {
            zzyy.zzm(zzef.zzH(), 0, 6, false);
            zzef.zzF(0);
            if (zzef.zzo() != 2935) {
                zzzj.zzj();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                zzyy.zzl(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int zzb2 = zzyj.zzb(zzef.zzH());
                if (zzb2 == -1) {
                    return false;
                }
                zzyy.zzl(zzb2 - 6, false);
            }
        }
    }
}
