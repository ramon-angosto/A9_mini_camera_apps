package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzahb implements zzahc {
    private final List zza;
    private final zzaap[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = C.TIME_UNSET;

    public zzahb(List list) {
        this.zza = list;
        this.zzb = new zzaap[list.size()];
    }

    private final boolean zzf(zzef zzef, int i) {
        if (zzef.zza() == 0) {
            return false;
        }
        if (zzef.zzk() != i) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    public final void zza(zzef zzef) {
        if (!this.zzc) {
            return;
        }
        if (this.zzd != 2 || zzf(zzef, 32)) {
            if (this.zzd != 1 || zzf(zzef, 0)) {
                int zzc2 = zzef.zzc();
                int zza2 = zzef.zza();
                for (zzaap zzq : this.zzb) {
                    zzef.zzF(zzc2);
                    zzq.zzq(zzef, zza2);
                }
                this.zze += zza2;
            }
        }
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzail zzail = (zzail) this.zza.get(i);
            zzaio.zzc();
            zzaap zzv = zzzl.zzv(zzaio.zza(), 3);
            zzad zzad = new zzad();
            zzad.zzH(zzaio.zzb());
            zzad.zzS(MimeTypes.APPLICATION_DVBSUBS);
            zzad.zzI(Collections.singletonList(zzail.zzb));
            zzad.zzK(zzail.zza);
            zzv.zzk(zzad.zzY());
            this.zzb[i] = zzv;
        }
    }

    public final void zzc() {
        if (this.zzc) {
            if (this.zzf != C.TIME_UNSET) {
                for (zzaap zzs : this.zzb) {
                    zzs.zzs(this.zzf, 1, this.zze, 0, (zzaao) null);
                }
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            if (j != C.TIME_UNSET) {
                this.zzf = j;
            }
            this.zze = 0;
            this.zzd = 2;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzf = C.TIME_UNSET;
    }
}
