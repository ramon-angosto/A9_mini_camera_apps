package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgmk extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgmk zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgrn zzf = zzaK();

    static {
        zzgmk zzgmk = new zzgmk();
        zzb = zzgmk;
        zzgre.zzaQ(zzgmk.class, zzgmk);
    }

    private zzgmk() {
    }

    public static zzgmh zzd() {
        return (zzgmh) zzb.zzaz();
    }

    public static zzgmk zzf(InputStream inputStream, zzgqq zzgqq) throws IOException {
        return (zzgmk) zzgre.zzaF(zzb, inputStream, zzgqq);
    }

    public static zzgmk zzg(byte[] bArr, zzgqq zzgqq) throws zzgrq {
        return (zzgmk) zzgre.zzaG(zzb, bArr, zzgqq);
    }

    static /* synthetic */ void zzj(zzgmk zzgmk, zzgmj zzgmj) {
        zzgmj.getClass();
        zzgrn zzgrn = zzgmk.zzf;
        if (!zzgrn.zzc()) {
            zzgmk.zzf = zzgre.zzaL(zzgrn);
        }
        zzgmk.zzf.add(zzgmj);
    }

    public final int zza() {
        return this.zzf.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzgmj.class});
        } else if (i2 == 3) {
            return new zzgmk();
        } else {
            if (i2 == 4) {
                return new zzgmh((zzgmg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzc() {
        return this.zze;
    }

    public final List zzh() {
        return this.zzf;
    }
}
