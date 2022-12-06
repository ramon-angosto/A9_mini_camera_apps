package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcy {
    public static final zzcy zza = new zzcy(zzfvn.zzo());
    public static final zzn zzb = zzcv.zza;
    private final zzfvn zzc;

    public zzcy(List list) {
        this.zzc = zzfvn.zzm(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzc.equals(((zzcy) obj).zzc);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }

    public final zzfvn zza() {
        return this.zzc;
    }

    public final boolean zzb(int i) {
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            zzcx zzcx = (zzcx) this.zzc.get(i2);
            if (zzcx.zzc() && zzcx.zza() == i) {
                return true;
            }
        }
        return false;
    }
}
