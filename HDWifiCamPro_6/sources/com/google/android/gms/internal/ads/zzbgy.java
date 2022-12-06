package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbgy extends zzgre implements zzgsp {
    private static final zzgrk zzb = new zzbgw();
    /* access modifiers changed from: private */
    public static final zzbgy zze;
    private int zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    private long zzj;
    private zzgrj zzk = zzaH();
    private zzbgt zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private long zzs;

    static {
        zzbgy zzbgy = new zzbgy();
        zze = zzbgy;
        zzgre.zzaQ(zzbgy.class, zzbgy);
    }

    private zzbgy() {
    }

    static /* synthetic */ void zzA(zzbgy zzbgy, int i) {
        zzbgy.zzn = i - 1;
        zzbgy.zzf |= 64;
    }

    static /* synthetic */ void zzB(zzbgy zzbgy, int i) {
        zzbgy.zzo = i - 1;
        zzbgy.zzf |= 128;
    }

    static /* synthetic */ void zzC(zzbgy zzbgy, int i) {
        zzbgy.zzq = i - 1;
        zzbgy.zzf |= 512;
    }

    public static zzbgx zzg() {
        return (zzbgx) zze.zzaz();
    }

    public static zzbgy zzi(byte[] bArr) throws zzgrq {
        return (zzbgy) zzgre.zzaD(zze, bArr);
    }

    static /* synthetic */ void zzl(zzbgy zzbgy, long j) {
        zzbgy.zzf |= 1;
        zzbgy.zzg = j;
    }

    static /* synthetic */ void zzm(zzbgy zzbgy, long j) {
        zzbgy.zzf |= 4;
        zzbgy.zzi = j;
    }

    static /* synthetic */ void zzn(zzbgy zzbgy, long j) {
        zzbgy.zzf |= 8;
        zzbgy.zzj = j;
    }

    static /* synthetic */ void zzo(zzbgy zzbgy, Iterable iterable) {
        zzgrj zzgrj = zzbgy.zzk;
        if (!zzgrj.zzc()) {
            zzbgy.zzk = zzgre.zzaI(zzgrj);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzbgy.zzk.zzh(((zzbfn) it.next()).zza());
        }
    }

    static /* synthetic */ void zzp(zzbgy zzbgy, zzbgt zzbgt) {
        zzbgt.getClass();
        zzbgy.zzl = zzbgt;
        zzbgy.zzf |= 16;
    }

    static /* synthetic */ void zzq(zzbgy zzbgy, int i) {
        zzbgy.zzf |= 256;
        zzbgy.zzp = i;
    }

    static /* synthetic */ void zzr(zzbgy zzbgy, zzbhc zzbhc) {
        zzbgy.zzr = zzbhc.zza();
        zzbgy.zzf |= 1024;
    }

    static /* synthetic */ void zzs(zzbgy zzbgy, long j) {
        zzbgy.zzf |= 2048;
        zzbgy.zzs = j;
    }

    static /* synthetic */ void zzy(zzbgy zzbgy, int i) {
        zzbgy.zzh = i - 1;
        zzbgy.zzf |= 2;
    }

    static /* synthetic */ void zzz(zzbgy zzbgy, int i) {
        zzbgy.zzm = i - 1;
        zzbgy.zzf |= 32;
    }

    public final int zza() {
        return this.zzp;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgri zzgri = zzbgc.zza;
            return zzaP(zze, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005\u001e\u0006ဉ\u0004\u0007ဌ\u0005\bဌ\u0006\tဌ\u0007\nင\b\u000bဌ\t\fဌ\n\rဂ\u000b", new Object[]{"zzf", "zzg", "zzh", zzbgc.zza, "zzi", "zzj", "zzk", zzbfn.zzc(), "zzl", "zzm", zzgri, "zzn", zzgri, "zzo", zzgri, "zzp", "zzq", zzgri, "zzr", zzbhc.zzc(), "zzs"});
        } else if (i2 == 3) {
            return new zzbgy();
        } else {
            if (i2 == 4) {
                return new zzbgx((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }

    public final long zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzi;
    }

    public final long zze() {
        return this.zzg;
    }

    public final zzbgt zzf() {
        zzbgt zzbgt = this.zzl;
        return zzbgt == null ? zzbgt.zzd() : zzbgt;
    }

    public final zzbhc zzj() {
        zzbhc zzb2 = zzbhc.zzb(this.zzr);
        return zzb2 == null ? zzbhc.UNSPECIFIED : zzb2;
    }

    public final List zzk() {
        return new zzgrl(this.zzk, zzb);
    }

    public final int zzt() {
        int zza = zzbgd.zza(this.zzn);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzu() {
        int zza = zzbgd.zza(this.zzo);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzv() {
        int zza = zzbgd.zza(this.zzq);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzw() {
        int zza = zzbgd.zza(this.zzh);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzx() {
        int zza = zzbgd.zza(this.zzm);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
