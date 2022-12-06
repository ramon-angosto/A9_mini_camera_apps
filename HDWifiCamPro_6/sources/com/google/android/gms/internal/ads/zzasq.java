package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzasq {
    public final zzayc zza;
    public final Object zzb;
    public final int zzc;
    public final zzayo[] zzd;
    public final boolean[] zze;
    public final long zzf;
    public int zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public zzasq zzl;
    public zzazi zzm;
    private final zzatb[] zzn;
    private final zzatc[] zzo;
    private final zzazh zzp;
    private final zzaye zzq;
    private zzazi zzr;
    private final zzcjv zzs;

    public final long zza(long j, boolean z) {
        return zzb(j, false, new boolean[2]);
    }

    public final long zzb(long j, boolean z, boolean[] zArr) {
        zzazf zzazf = this.zzm.zzb;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= 2) {
                break;
            }
            boolean[] zArr2 = this.zze;
            if (z || !this.zzm.zza(this.zzr, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zzB = this.zza.zzB(zzazf.zzb(), this.zze, this.zzd, zArr, j);
        this.zzr = this.zzm;
        this.zzk = false;
        int i2 = 0;
        while (true) {
            zzayo[] zzayoArr = this.zzd;
            if (i2 < 2) {
                if (zzayoArr[i2] != null) {
                    zzbac.zze(zzazf.zza(i2) != null);
                    this.zzk = true;
                } else {
                    zzbac.zze(zzazf.zza(i2) == null);
                }
                i2++;
            } else {
                this.zzs.zzd(this.zzn, this.zzm.zza, zzazf);
                return zzB;
            }
        }
    }

    public final void zzc() {
        try {
            this.zzq.zzc(this.zza);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }

    public final boolean zzd() {
        if (!this.zzj) {
            return false;
        }
        if (this.zzk) {
            return this.zza.zzg() == Long.MIN_VALUE;
        }
        return true;
    }

    public final boolean zze() throws zzasi {
        zzazi zzc2 = this.zzp.zzc(this.zzo, this.zza.zzn());
        zzazi zzazi = this.zzr;
        if (zzazi != null) {
            int i = 0;
            while (i < 2) {
                if (zzc2.zza(zzazi, i)) {
                    i++;
                }
            }
            return false;
        }
        this.zzm = zzc2;
        return true;
    }

    public zzasq(zzatb[] zzatbArr, zzatc[] zzatcArr, long j, zzazh zzazh, zzcjv zzcjv, zzaye zzaye, Object obj, int i, int i2, boolean z, long j2, byte[] bArr) {
        this.zzn = zzatbArr;
        this.zzo = zzatcArr;
        this.zzf = j;
        this.zzp = zzazh;
        this.zzs = zzcjv;
        this.zzq = zzaye;
        if (obj != null) {
            this.zzb = obj;
            this.zzc = i;
            this.zzg = i2;
            this.zzi = z;
            this.zzh = j2;
            this.zzd = new zzayo[2];
            this.zze = new boolean[2];
            this.zza = zzaye.zze(i2, zzcjv.zzl());
            return;
        }
        throw null;
    }
}
