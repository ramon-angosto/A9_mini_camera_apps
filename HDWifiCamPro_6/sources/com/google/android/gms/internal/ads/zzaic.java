package com.google.android.gms.internal.ads;

import androidx.core.view.InputDeviceCompat;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaic implements zzaip {
    private final zzaib zza;
    private final zzef zzb = new zzef(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzaic(zzaib zzaib) {
        this.zza = zzaib;
    }

    public final void zza(zzef zzef, int i) {
        int i2 = i & 1;
        int zzk = i2 != 0 ? zzef.zzk() + zzef.zzc() : -1;
        if (this.zzf) {
            if (i2 != 0) {
                this.zzf = false;
                zzef.zzF(zzk);
                this.zzd = 0;
            } else {
                return;
            }
        }
        while (zzef.zza() > 0) {
            int i3 = this.zzd;
            if (i3 < 3) {
                if (i3 == 0) {
                    int zzk2 = zzef.zzk();
                    zzef.zzF(zzef.zzc() - 1);
                    if (zzk2 == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int min = Math.min(zzef.zza(), 3 - this.zzd);
                zzef.zzB(this.zzb.zzH(), this.zzd, min);
                int i4 = this.zzd + min;
                this.zzd = i4;
                if (i4 == 3) {
                    this.zzb.zzF(0);
                    this.zzb.zzE(3);
                    this.zzb.zzG(1);
                    int zzk3 = this.zzb.zzk();
                    int zzk4 = this.zzb.zzk();
                    this.zze = (zzk3 & 128) != 0;
                    this.zzc = (((zzk3 & 15) << 8) | zzk4) + 3;
                    int zzb2 = this.zzb.zzb();
                    int i5 = this.zzc;
                    if (zzb2 < i5) {
                        int zzb3 = this.zzb.zzb();
                        this.zzb.zzz(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i5, zzb3 + zzb3)));
                    }
                }
            } else {
                int min2 = Math.min(zzef.zza(), this.zzc - i3);
                zzef.zzB(this.zzb.zzH(), this.zzd, min2);
                int i6 = this.zzd + min2;
                this.zzd = i6;
                int i7 = this.zzc;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzE(i7);
                    } else if (zzen.zzg(this.zzb.zzH(), 0, i7, -1) != 0) {
                        this.zzf = true;
                        return;
                    } else {
                        this.zzb.zzE(this.zzc - 4);
                    }
                    this.zzb.zzF(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
        }
    }

    public final void zzb(zzel zzel, zzzl zzzl, zzaio zzaio) {
        this.zza.zzb(zzel, zzzl, zzaio);
        this.zzf = true;
    }

    public final void zzc() {
        this.zzf = true;
    }
}
