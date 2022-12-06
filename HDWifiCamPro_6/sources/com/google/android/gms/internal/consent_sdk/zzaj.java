package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzaj extends zzd {
    /* access modifiers changed from: private */
    public final zzaj zza = this;
    /* access modifiers changed from: private */
    public final zzcl<Application> zzb;
    /* access modifiers changed from: private */
    public final zzcl<zzam> zzc;
    /* access modifiers changed from: private */
    public final zzcl<zzac> zzd;
    private final zzcl<zzas> zze;
    private final zzcl<zzba> zzf;
    private final zzcl<zzb> zzg;
    private final zzcl<zzn> zzh;
    /* access modifiers changed from: private */
    public final zzcl<zzh> zzi;
    /* access modifiers changed from: private */
    public final zzcl<zzak> zzj;
    private final zzcl<zzz> zzk;
    private final zzcl<zzv> zzl;
    private final zzcl<zzk> zzm;

    /* synthetic */ zzaj(Application application, zzaf zzaf) {
        this.zzb = zzci.zza(application);
        this.zzc = zzcg.zza(new zzan(this.zzb));
        this.zzd = zzcg.zza(zzad.zza);
        this.zze = new zzaf(this);
        this.zzf = zzcg.zza(new zzbb(this.zze));
        this.zzg = new zzc(this.zzb);
        this.zzh = new zzp(this.zzb, this.zzg, this.zzc);
        this.zzi = zzcg.zza(new zzi(zzaq.zza));
        this.zzj = new zzal(this.zzb, this.zzc, zzaq.zza);
        this.zzk = new zzab(this.zzi, this.zzj, this.zzc);
        this.zzl = new zzw(this.zzb, this.zzd, zzao.zza, zzaq.zza, this.zzc, this.zzf, this.zzh, this.zzk, this.zzi);
        this.zzm = zzcg.zza(new zzl(this.zzc, this.zzl, this.zzf));
    }

    public final zzk zzb() {
        return this.zzm.zzb();
    }

    public final zzba zzc() {
        return this.zzf.zzb();
    }
}
