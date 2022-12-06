package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfke extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzfke zzb;
    /* access modifiers changed from: private */
    public zzgrn zze = zzaK();

    static {
        zzfke zzfke = new zzfke();
        zzb = zzfke;
        zzgre.zzaQ(zzfke.class, zzfke);
    }

    private zzfke() {
    }

    public static zzfkb zzc() {
        return (zzfkb) zzb.zzaz();
    }

    static /* synthetic */ void zzf(zzfke zzfke, zzfkd zzfkd) {
        zzfkd.getClass();
        zzgrn zzgrn = zzfke.zze;
        if (!zzgrn.zzc()) {
            zzfke.zze = zzgre.zzaL(zzgrn);
        }
        zzfke.zze.add(zzfkd);
    }

    public final int zza() {
        return this.zze.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzfkd.class});
        } else if (i2 == 3) {
            return new zzfke();
        } else {
            if (i2 == 4) {
                return new zzfkb((zzfka) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
