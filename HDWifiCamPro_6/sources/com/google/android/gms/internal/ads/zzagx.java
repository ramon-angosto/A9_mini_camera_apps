package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzagx implements zzzi {
    public static final zzzp zza = zzagw.zza;
    private final zzagy zzb;
    private final zzef zzc;
    private final zzef zzd;
    private final zzee zze;
    private zzzl zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;

    public zzagx() {
        this(0);
    }

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        zzdd.zzb(this.zzf);
        int zza2 = zzzj.zza(this.zzc.zzH(), 0, 2048);
        if (!this.zzj) {
            this.zzf.zzN(new zzaak(C.TIME_UNSET, 0));
            this.zzj = true;
        }
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzF(0);
        this.zzc.zzE(zza2);
        if (!this.zzi) {
            this.zzb.zzd(this.zzg, 4);
            this.zzi = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    public final void zzb(zzzl zzzl) {
        this.zzf = zzzl;
        this.zzb.zzb(zzzl, new zzaio(Integer.MIN_VALUE, 0, 1));
        zzzl.zzC();
    }

    public final void zzc(long j, long j2) {
        this.zzi = false;
        this.zzb.zze();
        this.zzg = j2;
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        zzyy zzyy;
        int i = 0;
        while (true) {
            zzyy = (zzyy) zzzj;
            zzyy.zzm(this.zzd.zzH(), 0, 10, false);
            this.zzd.zzF(0);
            if (this.zzd.zzm() != 4801587) {
                break;
            }
            this.zzd.zzG(3);
            int zzj2 = this.zzd.zzj();
            i += zzj2 + 10;
            zzyy.zzl(zzj2, false);
        }
        zzzj.zzj();
        zzyy.zzl(i, false);
        if (this.zzh == -1) {
            this.zzh = (long) i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        do {
            zzyy.zzm(this.zzd.zzH(), 0, 2, false);
            this.zzd.zzF(0);
            if (!zzagy.zzf(this.zzd.zzo())) {
                i4++;
                zzzj.zzj();
                zzyy.zzl(i4, false);
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                zzyy.zzm(this.zzd.zzH(), 0, 4, false);
                this.zze.zzh(14);
                int zzc2 = this.zze.zzc(13);
                if (zzc2 <= 6) {
                    i4++;
                    zzzj.zzj();
                    zzyy.zzl(i4, false);
                } else {
                    zzyy.zzl(zzc2 - 6, false);
                    i3 += zzc2;
                }
            }
            i2 = 0;
            i3 = 0;
        } while (i4 - i < 8192);
        return false;
    }

    public zzagx(int i) {
        this.zzb = new zzagy(true, (String) null);
        this.zzc = new zzef(2048);
        this.zzh = -1;
        this.zzd = new zzef(10);
        byte[] zzH = this.zzd.zzH();
        this.zze = new zzee(zzH, zzH.length);
    }
}
