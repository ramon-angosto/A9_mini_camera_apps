package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzahq implements zzahc {
    private final zzef zza;
    private final zzaab zzb;
    private final String zzc;
    private zzaap zzd;
    private String zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private long zzl;

    public zzahq() {
        this((String) null);
    }

    public final void zza(zzef zzef) {
        zzdd.zzb(this.zzd);
        while (zzef.zza() > 0) {
            int i = this.zzf;
            if (i == 0) {
                byte[] zzH = zzef.zzH();
                int zzc2 = zzef.zzc();
                int zzd2 = zzef.zzd();
                while (true) {
                    if (zzc2 >= zzd2) {
                        zzef.zzF(zzd2);
                        break;
                    }
                    byte b = zzH[zzc2];
                    boolean z = (b & UByte.MAX_VALUE) == 255;
                    boolean z2 = this.zzi && (b & 224) == 224;
                    this.zzi = z;
                    if (z2) {
                        zzef.zzF(zzc2 + 1);
                        this.zzi = false;
                        this.zza.zzH()[1] = zzH[zzc2];
                        this.zzg = 2;
                        this.zzf = 1;
                        break;
                    }
                    zzc2++;
                }
            } else if (i != 1) {
                int min = Math.min(zzef.zza(), this.zzk - this.zzg);
                this.zzd.zzq(zzef, min);
                int i2 = this.zzg + min;
                this.zzg = i2;
                int i3 = this.zzk;
                if (i2 >= i3) {
                    long j = this.zzl;
                    if (j != C.TIME_UNSET) {
                        this.zzd.zzs(j, 1, i3, 0, (zzaao) null);
                        this.zzl += this.zzj;
                    }
                    this.zzg = 0;
                    this.zzf = 0;
                }
            } else {
                int min2 = Math.min(zzef.zza(), 4 - this.zzg);
                zzef.zzB(this.zza.zzH(), this.zzg, min2);
                int i4 = this.zzg + min2;
                this.zzg = i4;
                if (i4 >= 4) {
                    this.zza.zzF(0);
                    if (!this.zzb.zza(this.zza.zze())) {
                        this.zzg = 0;
                        this.zzf = 1;
                    } else {
                        zzaab zzaab = this.zzb;
                        this.zzk = zzaab.zzc;
                        if (!this.zzh) {
                            this.zzj = (((long) zzaab.zzg) * 1000000) / ((long) zzaab.zzd);
                            zzad zzad = new zzad();
                            zzad.zzH(this.zze);
                            zzad.zzS(this.zzb.zzb);
                            zzad.zzL(4096);
                            zzad.zzw(this.zzb.zze);
                            zzad.zzT(this.zzb.zzd);
                            zzad.zzK(this.zzc);
                            this.zzd.zzk(zzad.zzY());
                            this.zzh = true;
                        }
                        this.zza.zzF(0);
                        this.zzd.zzq(this.zza, 4);
                        this.zzf = 2;
                    }
                }
            }
        }
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zze = zzaio.zzb();
        this.zzd = zzzl.zzv(zzaio.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        if (j != C.TIME_UNSET) {
            this.zzl = j;
        }
    }

    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzi = false;
        this.zzl = C.TIME_UNSET;
    }

    public zzahq(String str) {
        this.zzf = 0;
        this.zza = new zzef(4);
        this.zza.zzH()[0] = -1;
        this.zzb = new zzaab();
        this.zzl = C.TIME_UNSET;
        this.zzc = str;
    }
}
