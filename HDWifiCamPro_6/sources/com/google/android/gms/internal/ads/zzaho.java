package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaho implements zzahc {
    private final zzef zza = new zzef(10);
    private zzaap zzb;
    private boolean zzc;
    private long zzd = C.TIME_UNSET;
    private int zze;
    private int zzf;

    public final void zza(zzef zzef) {
        zzdd.zzb(this.zzb);
        if (this.zzc) {
            int zza2 = zzef.zza();
            int i = this.zzf;
            if (i < 10) {
                int min = Math.min(zza2, 10 - i);
                System.arraycopy(zzef.zzH(), zzef.zzc(), this.zza.zzH(), this.zzf, min);
                if (this.zzf + min == 10) {
                    this.zza.zzF(0);
                    if (this.zza.zzk() == 73 && this.zza.zzk() == 68 && this.zza.zzk() == 51) {
                        this.zza.zzG(3);
                        this.zze = this.zza.zzj() + 10;
                    } else {
                        zzdw.zze("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(zza2, this.zze - this.zzf);
            this.zzb.zzq(zzef, min2);
            this.zzf += min2;
        }
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zzb = zzzl.zzv(zzaio.zza(), 5);
        zzaap zzaap = this.zzb;
        zzad zzad = new zzad();
        zzad.zzH(zzaio.zzb());
        zzad.zzS(MimeTypes.APPLICATION_ID3);
        zzaap.zzk(zzad.zzY());
    }

    public final void zzc() {
        int i;
        zzdd.zzb(this.zzb);
        if (this.zzc && (i = this.zze) != 0 && this.zzf == i) {
            long j = this.zzd;
            if (j != C.TIME_UNSET) {
                this.zzb.zzs(j, 1, i, 0, (zzaao) null);
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            if (j != C.TIME_UNSET) {
                this.zzd = j;
            }
            this.zze = 0;
            this.zzf = 0;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzd = C.TIME_UNSET;
    }
}
