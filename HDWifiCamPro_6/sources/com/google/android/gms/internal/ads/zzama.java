package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzama extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzama zzb;
    private int zze;
    private String zzf = "";
    private long zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private long zzk;
    private long zzl;
    private String zzm = "";
    private long zzn;
    private String zzo = "";
    private String zzp = "";
    private zzgrn zzq = zzaK();
    private int zzr;

    static {
        zzama zzama = new zzama();
        zzb = zzama;
        zzgre.zzaQ(zzama.class, zzama);
    }

    private zzama() {
    }

    public static zzalw zza() {
        return (zzalw) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzama zzama, long j) {
        zzama.zze |= 2;
        zzama.zzg = j;
    }

    static /* synthetic */ void zze(zzama zzama, String str) {
        str.getClass();
        zzama.zze |= 4;
        zzama.zzh = str;
    }

    static /* synthetic */ void zzf(zzama zzama, String str) {
        str.getClass();
        zzama.zze |= 8;
        zzama.zzi = str;
    }

    static /* synthetic */ void zzg(zzama zzama, String str) {
        zzama.zze |= 16;
        zzama.zzj = str;
    }

    static /* synthetic */ void zzh(zzama zzama, String str) {
        zzama.zze |= 1024;
        zzama.zzp = str;
    }

    static /* synthetic */ void zzi(zzama zzama, String str) {
        str.getClass();
        zzama.zze |= 1;
        zzama.zzf = str;
    }

    static /* synthetic */ void zzj(zzama zzama, int i) {
        zzama.zzr = i - 1;
        zzama.zze |= 2048;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzaly.class, "zzr", zzalz.zza});
        } else if (i2 == 3) {
            return new zzama();
        } else {
            if (i2 == 4) {
                return new zzalw((zzalv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
