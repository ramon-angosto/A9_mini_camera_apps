package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcqy {
    private zzcop zza;
    private zzcsl zzb;
    private zzfil zzc;
    private zzcsy zzd;
    private zzfff zze;

    private zzcqy() {
    }

    /* synthetic */ zzcqy(zzcqx zzcqx) {
    }

    public final zzcom zza() {
        zzgxq.zzc(this.zza, zzcop.class);
        zzgxq.zzc(this.zzb, zzcsl.class);
        if (this.zzc == null) {
            this.zzc = new zzfil();
        }
        if (this.zzd == null) {
            this.zzd = new zzcsy();
        }
        if (this.zze == null) {
            this.zze = new zzfff();
        }
        return new zzcpw(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (zzcpv) null);
    }

    public final zzcqy zzb(zzcop zzcop) {
        this.zza = zzcop;
        return this;
    }

    public final zzcqy zzc(zzcsl zzcsl) {
        this.zzb = zzcsl;
        return this;
    }
}
