package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcp {
    public static final zzn zza = zzco.zza;
    public final int zzb = 1;
    public final String zzc;
    public final int zzd;
    private final zzaf[] zze;
    private int zzf;

    public zzcp(String str, zzaf... zzafArr) {
        this.zzc = str;
        this.zze = zzafArr;
        int zzb2 = zzbt.zzb(zzafArr[0].zzm);
        this.zzd = zzb2 == -1 ? zzbt.zzb(zzafArr[0].zzl) : zzb2;
        zzd(this.zze[0].zzd);
        int i = this.zze[0].zzf;
    }

    private static String zzd(String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzcp zzcp = (zzcp) obj;
            return this.zzc.equals(zzcp.zzc) && Arrays.equals(this.zze, zzcp.zze);
        }
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int hashCode = ((this.zzc.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + Arrays.hashCode(this.zze);
        this.zzf = hashCode;
        return hashCode;
    }

    public final int zza(zzaf zzaf) {
        for (int i = 0; i <= 0; i++) {
            if (zzaf == this.zze[i]) {
                return i;
            }
        }
        return -1;
    }

    public final zzaf zzb(int i) {
        return this.zze[i];
    }

    public final zzcp zzc(String str) {
        return new zzcp(str, this.zze);
    }
}
