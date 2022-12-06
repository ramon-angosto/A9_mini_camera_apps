package com.google.android.gms.internal.ads;

import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgng extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgng zzb;
    private String zze = "";
    private zzgrn zzf = zzaK();

    static {
        zzgng zzgng = new zzgng();
        zzb = zzgng;
        zzgre.zzaQ(zzgng.class, zzgng);
    }

    private zzgng() {
    }

    public static zzgng zzc() {
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzgmf.class});
        } else if (i2 == 3) {
            return new zzgng();
        } else {
            if (i2 == 4) {
                return new zzgnf((zzgne) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List zzd() {
        return this.zzf;
    }
}
