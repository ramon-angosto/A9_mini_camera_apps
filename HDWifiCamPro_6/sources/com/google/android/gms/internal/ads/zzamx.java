package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzamx extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzamx zzb;
    private int zze;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private int zzl = 1000;
    private long zzm = -1;
    private long zzn = -1;
    private long zzo = -1;
    private int zzp = 1000;
    private long zzq = -1;
    private long zzr = -1;
    private long zzs = -1;
    private long zzt = -1;
    private long zzu;
    private long zzv;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;
    private long zzz = -1;

    static {
        zzamx zzamx = new zzamx();
        zzb = zzamx;
        zzgre.zzaQ(zzamx.class, zzamx);
    }

    private zzamx() {
    }

    public static zzamw zza() {
        return (zzamw) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzamx zzamx, long j) {
        zzamx.zze |= 1;
        zzamx.zzf = j;
    }

    static /* synthetic */ void zze(zzamx zzamx, long j) {
        zzamx.zze |= 2;
        zzamx.zzg = j;
    }

    static /* synthetic */ void zzf(zzamx zzamx, long j) {
        zzamx.zze |= 4;
        zzamx.zzh = j;
    }

    static /* synthetic */ void zzg(zzamx zzamx, long j) {
        zzamx.zze |= 8;
        zzamx.zzi = j;
    }

    static /* synthetic */ void zzh(zzamx zzamx) {
        zzamx.zze &= -9;
        zzamx.zzi = -1;
    }

    static /* synthetic */ void zzi(zzamx zzamx, long j) {
        zzamx.zze |= 16;
        zzamx.zzj = j;
    }

    static /* synthetic */ void zzj(zzamx zzamx, long j) {
        zzamx.zze |= 32;
        zzamx.zzk = j;
    }

    static /* synthetic */ void zzk(zzamx zzamx, long j) {
        zzamx.zze |= 128;
        zzamx.zzm = j;
    }

    static /* synthetic */ void zzl(zzamx zzamx, long j) {
        zzamx.zze |= 256;
        zzamx.zzn = j;
    }

    static /* synthetic */ void zzm(zzamx zzamx, long j) {
        zzamx.zze |= 512;
        zzamx.zzo = j;
    }

    static /* synthetic */ void zzn(zzamx zzamx, long j) {
        zzamx.zze |= 2048;
        zzamx.zzq = j;
    }

    static /* synthetic */ void zzo(zzamx zzamx, long j) {
        zzamx.zze |= 4096;
        zzamx.zzr = j;
    }

    static /* synthetic */ void zzp(zzamx zzamx, long j) {
        zzamx.zze |= 8192;
        zzamx.zzs = j;
    }

    static /* synthetic */ void zzq(zzamx zzamx, long j) {
        zzamx.zze |= 16384;
        zzamx.zzt = j;
    }

    static /* synthetic */ void zzr(zzamx zzamx, long j) {
        zzamx.zze |= 32768;
        zzamx.zzu = j;
    }

    static /* synthetic */ void zzs(zzamx zzamx, long j) {
        zzamx.zze |= 65536;
        zzamx.zzv = j;
    }

    static /* synthetic */ void zzt(zzamx zzamx, long j) {
        zzamx.zze |= 131072;
        zzamx.zzw = j;
    }

    static /* synthetic */ void zzu(zzamx zzamx, long j) {
        zzamx.zze |= 262144;
        zzamx.zzx = j;
    }

    static /* synthetic */ void zzv(zzamx zzamx, int i) {
        zzamx.zzl = i - 1;
        zzamx.zze |= 64;
    }

    static /* synthetic */ void zzw(zzamx zzamx, int i) {
        zzamx.zzp = i - 1;
        zzamx.zze |= 1024;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgri zzgri = zzang.zza;
            return zzaP(zzb, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzgri, "zzm", "zzn", "zzo", "zzp", zzgri, "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz"});
        } else if (i2 == 3) {
            return new zzamx();
        } else {
            if (i2 == 4) {
                return new zzamw((zzamj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
