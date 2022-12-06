package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzmr {
    private final zzck zza;
    /* access modifiers changed from: private */
    public zzfvn zzb = zzfvn.zzo();
    private zzfvq zzc = zzfvq.zzd();
    private zzsi zzd;
    private zzsi zze;
    private zzsi zzf;

    public zzmr(zzck zzck) {
        this.zza = zzck;
    }

    private static zzsi zzj(zzcg zzcg, zzfvn zzfvn, zzsi zzsi, zzck zzck) {
        zzcn zzn = zzcg.zzn();
        int zzg = zzcg.zzg();
        Object zzf2 = zzn.zzo() ? null : zzn.zzf(zzg);
        int zzc2 = (zzcg.zzs() || zzn.zzo()) ? -1 : zzn.zzd(zzg, zzck, false).zzc(zzen.zzv(zzcg.zzl()));
        for (int i = 0; i < zzfvn.size(); i++) {
            zzsi zzsi2 = (zzsi) zzfvn.get(i);
            if (zzm(zzsi2, zzf2, zzcg.zzs(), zzcg.zzd(), zzcg.zze(), zzc2)) {
                return zzsi2;
            }
        }
        if (zzfvn.isEmpty() && zzsi != null) {
            if (zzm(zzsi, zzf2, zzcg.zzs(), zzcg.zzd(), zzcg.zze(), zzc2)) {
                return zzsi;
            }
        }
        return null;
    }

    private final void zzk(zzfvp zzfvp, zzsi zzsi, zzcn zzcn) {
        if (zzsi != null) {
            if (zzcn.zza(zzsi.zza) != -1) {
                zzfvp.zza(zzsi, zzcn);
                return;
            }
            zzcn zzcn2 = (zzcn) this.zzc.get(zzsi);
            if (zzcn2 != null) {
                zzfvp.zza(zzsi, zzcn2);
            }
        }
    }

    private final void zzl(zzcn zzcn) {
        zzfvp zzfvp = new zzfvp();
        if (this.zzb.isEmpty()) {
            zzk(zzfvp, this.zze, zzcn);
            if (!zzfss.zza(this.zzf, this.zze)) {
                zzk(zzfvp, this.zzf, zzcn);
            }
            if (!zzfss.zza(this.zzd, this.zze) && !zzfss.zza(this.zzd, this.zzf)) {
                zzk(zzfvp, this.zzd, zzcn);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzfvp, (zzsi) this.zzb.get(i), zzcn);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfvp, this.zzd, zzcn);
            }
        }
        this.zzc = zzfvp.zzc();
    }

    private static boolean zzm(zzsi zzsi, Object obj, boolean z, int i, int i2, int i3) {
        if (!zzsi.zza.equals(obj)) {
            return false;
        }
        if (z) {
            if (zzsi.zzb == i) {
                return zzsi.zzc == i2;
            }
        } else if (zzsi.zzb == -1) {
            return zzsi.zze == i3;
        }
        return false;
    }

    public final zzcn zza(zzsi zzsi) {
        return (zzcn) this.zzc.get(zzsi);
    }

    public final zzsi zzb() {
        return this.zzd;
    }

    public final zzsi zzc() {
        Object obj;
        Object next;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfvn zzfvn = this.zzb;
        if (!(zzfvn instanceof List)) {
            Iterator it = zzfvn.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else if (!zzfvn.isEmpty()) {
            obj = zzfvn.get(zzfvn.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
        return (zzsi) obj;
    }

    public final zzsi zzd() {
        return this.zze;
    }

    public final zzsi zze() {
        return this.zzf;
    }

    public final void zzg(zzcg zzcg) {
        this.zzd = zzj(zzcg, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zzsi zzsi, zzcg zzcg) {
        this.zzb = zzfvn.zzm(list);
        if (!list.isEmpty()) {
            this.zze = (zzsi) list.get(0);
            if (zzsi != null) {
                this.zzf = zzsi;
            } else {
                throw null;
            }
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzcg, this.zzb, this.zze, this.zza);
        }
        zzl(zzcg.zzn());
    }

    public final void zzi(zzcg zzcg) {
        this.zzd = zzj(zzcg, this.zzb, this.zze, this.zza);
        zzl(zzcg.zzn());
    }
}
