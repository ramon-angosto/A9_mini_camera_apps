package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzto implements zzsu {
    private final zzew zzc;
    private int zzd = 1048576;
    private final zztn zze;
    private final zzwm zzf;
    private final zzph zzg;

    public zzto(zzew zzew, zztn zztn, byte[] bArr) {
        zzph zzph = new zzph();
        zzwm zzwm = new zzwm(-1);
        this.zzc = zzew;
        this.zze = zztn;
        this.zzg = zzph;
        this.zzf = zzwm;
    }

    public final zzto zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zztq zzb(zzbg zzbg) {
        if (zzbg.zzd != null) {
            return new zztq(zzbg, this.zzc, this.zze, zzpq.zza, this.zzf, this.zzd, (zztp) null, (byte[]) null);
        }
        throw null;
    }
}
