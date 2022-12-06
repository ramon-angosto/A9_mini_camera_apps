package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdim {
    private final Set zza;
    private final Set zzb;
    private final Set zzc;
    private final Set zzd;
    private final Set zze;
    private final Set zzf;
    private final Set zzg;
    private final Set zzh;
    private final Set zzi;
    private final Set zzj;
    private final Set zzk;
    private final Set zzl;
    private final Set zzm;
    private final Set zzn;
    private final zzfaw zzo;
    private zzddc zzp;
    private zzeko zzq;

    /* synthetic */ zzdim(zzdik zzdik, zzdil zzdil) {
        this.zza = zzdik.zzc;
        this.zzb = zzdik.zzd;
        this.zzd = zzdik.zzf;
        this.zze = zzdik.zzg;
        this.zzc = zzdik.zze;
        this.zzf = zzdik.zzh;
        this.zzg = zzdik.zza;
        this.zzh = zzdik.zzi;
        this.zzi = zzdik.zzl;
        this.zzj = zzdik.zzj;
        this.zzk = zzdik.zzk;
        this.zzl = zzdik.zzm;
        this.zzo = zzdik.zzo;
        this.zzm = zzdik.zzn;
        this.zzn = zzdik.zzb;
    }

    public final zzddc zza(Set set) {
        if (this.zzp == null) {
            this.zzp = new zzddc(set);
        }
        return this.zzp;
    }

    public final zzeko zzb(Clock clock, zzekp zzekp, zzehh zzehh, zzfkm zzfkm) {
        if (this.zzq == null) {
            this.zzq = new zzeko(clock, zzekp, zzehh, zzfkm);
        }
        return this.zzq;
    }

    public final zzfaw zzc() {
        return this.zzo;
    }

    public final Set zzd() {
        return this.zzm;
    }

    public final Set zze() {
        return this.zza;
    }

    public final Set zzf() {
        return this.zzh;
    }

    public final Set zzg() {
        return this.zzi;
    }

    public final Set zzh() {
        return this.zzd;
    }

    public final Set zzi() {
        return this.zzc;
    }

    public final Set zzj() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final Set zzk() {
        return this.zzg;
    }

    public final Set zzl() {
        return this.zzj;
    }

    public final Set zzm() {
        return this.zze;
    }

    public final Set zzn() {
        return this.zzl;
    }

    public final Set zzo() {
        return this.zzn;
    }

    public final Set zzp() {
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final Set zzq() {
        return this.zzb;
    }
}
