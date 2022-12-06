package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbut {
    private final zzbtw zza;
    private zzfzp zzb;

    zzbut(zzbtw zzbtw) {
        this.zza = zzbtw;
    }

    private final void zzd() {
        if (this.zzb == null) {
            zzchh zzchh = new zzchh();
            this.zzb = zzchh;
            this.zza.zzb((zzape) null).zzi(new zzbur(zzchh), new zzbus(zzchh));
        }
    }

    public final zzbuw zza(String str, zzbud zzbud, zzbuc zzbuc) {
        zzd();
        return new zzbuw(this.zzb, "google.afma.activeView.handleUpdate", zzbud, zzbuc);
    }

    public final void zzb(String str, zzbpu zzbpu) {
        zzd();
        this.zzb = zzfzg.zzn(this.zzb, new zzbup(str, zzbpu), zzchc.zzf);
    }

    public final void zzc(String str, zzbpu zzbpu) {
        this.zzb = zzfzg.zzm(this.zzb, new zzbuq(str, zzbpu), zzchc.zzf);
    }
}
