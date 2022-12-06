package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzasg implements zzatb, zzatc {
    private final int zza;
    private zzatd zzb;
    private int zzc;
    private int zzd;
    private zzayo zze;
    private long zzf;
    private boolean zzg = true;
    private boolean zzh;

    public zzasg(int i) {
        this.zza = i;
    }

    public final boolean zzA() {
        return this.zzg;
    }

    public final boolean zzB() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final boolean zzC() {
        return this.zzg ? this.zzh : this.zze.zze();
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final int zzd(zzasx zzasx, zzaur zzaur, boolean z) {
        zzasx zzasx2 = zzasx;
        zzaur zzaur2 = zzaur;
        int zzb2 = this.zze.zzb(zzasx2, zzaur2, z);
        if (zzb2 == -4) {
            if (zzaur.zzf()) {
                this.zzg = true;
                return this.zzh ? -4 : -3;
            }
            zzaur2.zzc += this.zzf;
        } else if (zzb2 == -5) {
            zzasw zzasw = zzasx2.zza;
            long j = zzasw.zzw;
            if (j != Long.MAX_VALUE) {
                zzasx2.zza = new zzasw(zzasw.zza, zzasw.zze, zzasw.zzf, zzasw.zzc, zzasw.zzb, zzasw.zzg, zzasw.zzj, zzasw.zzk, zzasw.zzl, zzasw.zzm, zzasw.zzn, zzasw.zzp, zzasw.zzo, zzasw.zzq, zzasw.zzr, zzasw.zzs, zzasw.zzt, zzasw.zzu, zzasw.zzv, zzasw.zzx, zzasw.zzy, zzasw.zzz, j + this.zzf, zzasw.zzh, zzasw.zzi, zzasw.zzd);
                return -5;
            }
        }
        return zzb2;
    }

    public int zze() throws zzasi {
        throw null;
    }

    public final zzatc zzf() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final zzatd zzg() {
        return this.zzb;
    }

    public final zzayo zzh() {
        return this.zze;
    }

    public zzbag zzi() {
        return null;
    }

    public final void zzj() {
        boolean z = true;
        if (this.zzd != 1) {
            z = false;
        }
        zzbac.zze(z);
        this.zzd = 0;
        this.zze = null;
        this.zzh = false;
        zzn();
    }

    public final void zzk(zzatd zzatd, zzasw[] zzaswArr, zzayo zzayo, long j, boolean z, long j2) throws zzasi {
        zzbac.zze(this.zzd == 0);
        this.zzb = zzatd;
        this.zzd = 1;
        zzo(z);
        zzt(zzaswArr, zzayo, j2);
        zzp(j, z);
    }

    public void zzl(int i, Object obj) throws zzasi {
    }

    public final void zzm() throws IOException {
        this.zze.zzc();
    }

    /* access modifiers changed from: protected */
    public void zzn() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzo(boolean z) throws zzasi {
    }

    /* access modifiers changed from: protected */
    public void zzp(long j, boolean z) throws zzasi {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzq() throws zzasi {
    }

    /* access modifiers changed from: protected */
    public void zzr() throws zzasi {
    }

    /* access modifiers changed from: protected */
    public void zzs(zzasw[] zzaswArr, long j) throws zzasi {
    }

    public final void zzt(zzasw[] zzaswArr, zzayo zzayo, long j) throws zzasi {
        zzbac.zze(!this.zzh);
        this.zze = zzayo;
        this.zzg = false;
        this.zzf = j;
        zzs(zzaswArr, j);
    }

    public final void zzu(long j) throws zzasi {
        this.zzh = false;
        this.zzg = false;
        zzp(j, false);
    }

    public final void zzv() {
        this.zzh = true;
    }

    public final void zzw(int i) {
        this.zzc = i;
    }

    /* access modifiers changed from: protected */
    public final void zzx(long j) {
        this.zze.zzd(j - this.zzf);
    }

    public final void zzy() throws zzasi {
        boolean z = true;
        if (this.zzd != 1) {
            z = false;
        }
        zzbac.zze(z);
        this.zzd = 2;
        zzq();
    }

    public final void zzz() throws zzasi {
        zzbac.zze(this.zzd == 2);
        this.zzd = 1;
        zzr();
    }
}
