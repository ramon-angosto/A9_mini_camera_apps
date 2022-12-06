package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgwe extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgwe zzb;
    private zzgwd zzA;
    private zzgrn zzB = zzaK();
    private zzgvf zzC;
    private String zzD = "";
    private zzgux zzE;
    private byte zzF = 2;
    private int zze;
    private int zzf;
    private int zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzgvb zzk;
    private zzgrn zzl = zzaK();
    private zzgrn zzm = zzaK();
    private String zzn = "";
    private zzgvs zzo;
    private boolean zzp;
    private zzgrn zzq = zzgre.zzaK();
    private String zzr = "";
    private boolean zzs;
    private boolean zzt;
    private zzgpw zzu = zzgpw.zzb;
    private zzgwa zzv;
    private boolean zzw;
    private String zzx = "";
    private zzgrn zzy = zzgre.zzaK();
    private zzgrn zzz = zzgre.zzaK();

    static {
        zzgwe zzgwe = new zzgwe();
        zzb = zzgwe;
        zzgre.zzaQ(zzgwe.class, zzgwe);
    }

    private zzgwe() {
    }

    public static zzguz zza() {
        return (zzguz) zzb.zzaz();
    }

    static /* synthetic */ void zzg(zzgwe zzgwe, String str) {
        str.getClass();
        zzgwe.zze |= 4;
        zzgwe.zzh = str;
    }

    static /* synthetic */ void zzh(zzgwe zzgwe, String str) {
        str.getClass();
        zzgwe.zze |= 8;
        zzgwe.zzi = str;
    }

    static /* synthetic */ void zzi(zzgwe zzgwe, zzgvb zzgvb) {
        zzgvb.getClass();
        zzgwe.zzk = zzgvb;
        zzgwe.zze |= 32;
    }

    static /* synthetic */ void zzj(zzgwe zzgwe, zzgvy zzgvy) {
        zzgvy.getClass();
        zzgrn zzgrn = zzgwe.zzl;
        if (!zzgrn.zzc()) {
            zzgwe.zzl = zzgre.zzaL(zzgrn);
        }
        zzgwe.zzl.add(zzgvy);
    }

    static /* synthetic */ void zzk(zzgwe zzgwe, String str) {
        zzgwe.zze |= 64;
        zzgwe.zzn = str;
    }

    static /* synthetic */ void zzl(zzgwe zzgwe) {
        zzgwe.zze &= -65;
        zzgwe.zzn = zzb.zzn;
    }

    static /* synthetic */ void zzm(zzgwe zzgwe, zzgvs zzgvs) {
        zzgvs.getClass();
        zzgwe.zzo = zzgvs;
        zzgwe.zze |= 128;
    }

    static /* synthetic */ void zzn(zzgwe zzgwe, zzgwa zzgwa) {
        zzgwa.getClass();
        zzgwe.zzv = zzgwa;
        zzgwe.zze |= 8192;
    }

    static /* synthetic */ void zzo(zzgwe zzgwe, Iterable iterable) {
        zzgrn zzgrn = zzgwe.zzy;
        if (!zzgrn.zzc()) {
            zzgwe.zzy = zzgre.zzaL(zzgrn);
        }
        zzgpf.zzau(iterable, zzgwe.zzy);
    }

    static /* synthetic */ void zzp(zzgwe zzgwe, Iterable iterable) {
        zzgrn zzgrn = zzgwe.zzz;
        if (!zzgrn.zzc()) {
            zzgwe.zzz = zzgre.zzaL(zzgrn);
        }
        zzgpf.zzau(iterable, zzgwe.zzz);
    }

    static /* synthetic */ void zzq(zzgwe zzgwe, int i) {
        zzgwe.zzf = i - 1;
        zzgwe.zze |= 1;
    }

    public final String zzd() {
        return this.zzn;
    }

    public final String zze() {
        return this.zzh;
    }

    public final List zzf() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzF);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u001a\u0000\u0001\u0001\u001a\u001a\u0000\u0006\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013", new Object[]{"zze", "zzh", "zzi", "zzj", "zzl", zzgvy.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzf", zzgvt.zza, "zzg", zzguy.zza, "zzk", "zzn", "zzo", "zzu", "zzm", zzgwi.class, "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", zzgwo.class, "zzC", "zzD", "zzE"});
        } else if (i2 == 3) {
            return new zzgwe();
        } else {
            if (i2 == 4) {
                return new zzguz((zzguq) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzF = b;
            return null;
        }
    }
}
