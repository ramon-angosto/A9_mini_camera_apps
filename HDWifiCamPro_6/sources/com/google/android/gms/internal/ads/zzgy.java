package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgy implements zzji {
    private final zzkg zza;
    private final zzgx zzb;
    private zzka zzc;
    private zzji zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzgy(zzgx zzgx, zzde zzde) {
        this.zzb = zzgx;
        this.zza = new zzkg(zzde);
    }

    public final long zza() {
        throw null;
    }

    public final long zzb(boolean z) {
        zzka zzka = this.zzc;
        if (zzka == null || zzka.zzM() || (!this.zzc.zzN() && (z || this.zzc.zzG()))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzji zzji = this.zzd;
            if (zzji != null) {
                long zza2 = zzji.zza();
                if (this.zze) {
                    if (zza2 < this.zza.zza()) {
                        this.zza.zze();
                    } else {
                        this.zze = false;
                        if (this.zzf) {
                            this.zza.zzd();
                        }
                    }
                }
                this.zza.zzb(zza2);
                zzby zzc2 = zzji.zzc();
                if (!zzc2.equals(this.zza.zzc())) {
                    this.zza.zzg(zzc2);
                    this.zzb.zza(zzc2);
                }
            } else {
                throw null;
            }
        }
        if (this.zze) {
            return this.zza.zza();
        }
        zzji zzji2 = this.zzd;
        if (zzji2 != null) {
            return zzji2.zza();
        }
        throw null;
    }

    public final zzby zzc() {
        zzji zzji = this.zzd;
        return zzji != null ? zzji.zzc() : this.zza.zzc();
    }

    public final void zzd(zzka zzka) {
        if (zzka == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzka zzka) throws zzha {
        zzji zzji;
        zzji zzi = zzka.zzi();
        if (zzi != null && zzi != (zzji = this.zzd)) {
            if (zzji == null) {
                this.zzd = zzi;
                this.zzc = zzka;
                this.zzd.zzg(this.zza.zzc());
                return;
            }
            throw zzha.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    public final void zzg(zzby zzby) {
        zzji zzji = this.zzd;
        if (zzji != null) {
            zzji.zzg(zzby);
            zzby = this.zzd.zzc();
        }
        this.zza.zzg(zzby);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }
}
