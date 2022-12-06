package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzffp {
    private final LinkedList zza = new LinkedList();
    private final int zzb;
    private final int zzc;
    private final zzfgo zzd;

    public zzffp(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = new zzfgo();
    }

    private final void zzi() {
        while (!this.zza.isEmpty() && zzt.zzB().currentTimeMillis() - ((zzffz) this.zza.getFirst()).zzd >= ((long) this.zzc)) {
            this.zzd.zzg();
            this.zza.remove();
        }
    }

    public final int zza() {
        return this.zzd.zza();
    }

    public final int zzb() {
        zzi();
        return this.zza.size();
    }

    public final long zzc() {
        return this.zzd.zzb();
    }

    public final long zzd() {
        return this.zzd.zzc();
    }

    public final zzffz zze() {
        this.zzd.zzf();
        zzi();
        if (this.zza.isEmpty()) {
            return null;
        }
        zzffz zzffz = (zzffz) this.zza.remove();
        if (zzffz != null) {
            this.zzd.zzh();
        }
        return zzffz;
    }

    public final zzfgn zzf() {
        return this.zzd.zzd();
    }

    public final String zzg() {
        return this.zzd.zze();
    }

    public final boolean zzh(zzffz zzffz) {
        this.zzd.zzf();
        zzi();
        if (this.zza.size() == this.zzb) {
            return false;
        }
        this.zza.add(zzffz);
        return true;
    }
}
