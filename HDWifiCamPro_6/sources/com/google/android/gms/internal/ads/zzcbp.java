package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcbp extends zzcbr {
    private final String zza;
    private final int zzb;

    public zzcbp(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzcbp)) {
            zzcbp zzcbp = (zzcbp) obj;
            if (!Objects.equal(this.zza, zzcbp.zza) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzcbp.zzb))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
