package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcx {
    public static final zzn zza = zzcw.zza;
    public final int zzb = 1;
    private final zzcp zzc;
    private final int[] zzd;
    private final boolean[] zze;

    public zzcx(zzcp zzcp, boolean z, int[] iArr, boolean[] zArr) {
        int i = zzcp.zzb;
        this.zzc = zzcp;
        this.zzd = (int[]) iArr.clone();
        this.zze = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzcx zzcx = (zzcx) obj;
            return this.zzc.equals(zzcx.zzc) && Arrays.equals(this.zzd, zzcx.zzd) && Arrays.equals(this.zze, zzcx.zze);
        }
    }

    public final int hashCode() {
        return (((this.zzc.hashCode() * 961) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze);
    }

    public final int zza() {
        return this.zzc.zzd;
    }

    public final zzaf zzb(int i) {
        return this.zzc.zzb(i);
    }

    public final boolean zzc() {
        for (boolean z : this.zze) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzd(int i) {
        return this.zze[i];
    }
}
