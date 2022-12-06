package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzds {
    public final Object zza;
    private zzy zzb = new zzy();
    private boolean zzc;
    private boolean zzd;

    public zzds(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzds) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i, zzdq zzdq) {
        if (!this.zzd) {
            if (i != -1) {
                this.zzb.zza(i);
            }
            this.zzc = true;
            zzdq.zza(this.zza);
        }
    }

    public final void zzb(zzdr zzdr) {
        if (!this.zzd && this.zzc) {
            zzaa zzb2 = this.zzb.zzb();
            this.zzb = new zzy();
            this.zzc = false;
            zzdr.zza(this.zza, zzb2);
        }
    }

    public final void zzc(zzdr zzdr) {
        this.zzd = true;
        if (this.zzc) {
            zzdr.zza(this.zza, this.zzb.zzb());
        }
    }
}
