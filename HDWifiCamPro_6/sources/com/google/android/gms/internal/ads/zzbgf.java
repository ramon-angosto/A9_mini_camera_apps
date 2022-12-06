package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbgf extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbgf zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private int zzh;
    private int zzi = 1000;
    private zzbhp zzj;
    /* access modifiers changed from: private */
    public zzgrm zzk = zzaJ();
    private zzbfx zzl;
    private zzbga zzm;
    private zzbgt zzn;
    private zzbfb zzo;
    private zzbhd zzp;
    private zzbik zzq;
    private zzbfk zzr;

    static {
        zzbgf zzbgf = new zzbgf();
        zzb = zzbgf;
        zzgre.zzaQ(zzbgf.class, zzbgf);
    }

    private zzbgf() {
    }

    public static zzbge zzd() {
        return (zzbge) zzb.zzaz();
    }

    static /* synthetic */ void zzg(zzbgf zzbgf, String str) {
        str.getClass();
        zzbgf.zze |= 2;
        zzbgf.zzg = str;
    }

    static /* synthetic */ void zzh(zzbgf zzbgf, Iterable iterable) {
        zzgrm zzgrm = zzbgf.zzk;
        if (!zzgrm.zzc()) {
            int size = zzgrm.size();
            zzbgf.zzk = zzgrm.zza(size == 0 ? 10 : size + size);
        }
        zzgpf.zzau(iterable, zzbgf.zzk);
    }

    static /* synthetic */ void zzj(zzbgf zzbgf, zzbfx zzbfx) {
        zzbfx.getClass();
        zzbgf.zzl = zzbfx;
        zzbgf.zze |= 32;
    }

    static /* synthetic */ void zzk(zzbgf zzbgf, zzbfb zzbfb) {
        zzbfb.getClass();
        zzbgf.zzo = zzbfb;
        zzbgf.zze |= 256;
    }

    static /* synthetic */ void zzl(zzbgf zzbgf, zzbhd zzbhd) {
        zzbhd.getClass();
        zzbgf.zzp = zzbhd;
        zzbgf.zze |= 512;
    }

    static /* synthetic */ void zzm(zzbgf zzbgf, zzbik zzbik) {
        zzbik.getClass();
        zzbgf.zzq = zzbik;
        zzbgf.zze |= 1024;
    }

    static /* synthetic */ void zzn(zzbgf zzbgf, zzbfk zzbfk) {
        zzbfk.getClass();
        zzbgf.zzr = zzbfk;
        zzbgf.zze |= 2048;
    }

    public final zzbfb zza() {
        zzbfb zzbfb = this.zzo;
        return zzbfb == null ? zzbfb.zzc() : zzbfb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\fဌ\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzbgc.zza, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        } else if (i2 == 3) {
            return new zzbgf();
        } else {
            if (i2 == 4) {
                return new zzbge((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzbfx zzc() {
        zzbfx zzbfx = this.zzl;
        return zzbfx == null ? zzbfx.zzc() : zzbfx;
    }

    public final String zzf() {
        return this.zzg;
    }
}
