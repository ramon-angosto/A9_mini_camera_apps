package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzq {
    public static final zzn zza = zzp.zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final byte[] zze;
    private int zzf;

    public zzq(int i, int i2, int i3, byte[] bArr) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = bArr;
    }

    @Pure
    public static int zza(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 9) {
            return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int zzb(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 16) {
            return 6;
        }
        if (i != 18) {
            return (i == 6 || i == 7) ? 3 : -1;
        }
        return 7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzq zzq = (zzq) obj;
            return this.zzb == zzq.zzb && this.zzc == zzq.zzc && this.zzd == zzq.zzd && Arrays.equals(this.zze, zzq.zze);
        }
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((this.zzb + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzc) * 31) + this.zzd) * 31) + Arrays.hashCode(this.zze);
        this.zzf = hashCode;
        return hashCode;
    }

    public final String toString() {
        int i = this.zzb;
        int i2 = this.zzc;
        int i3 = this.zzd;
        boolean z = this.zze != null;
        return "ColorInfo(" + i + ", " + i2 + ", " + i3 + ", " + z + ")";
    }
}
