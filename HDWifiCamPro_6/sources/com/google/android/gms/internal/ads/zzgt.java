package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgt {
    public final String zza;
    public final zzaf zzb;
    public final zzaf zzc;
    public final int zzd;
    public final int zze;

    public zzgt(String str, zzaf zzaf, zzaf zzaf2, int i, int i2) {
        boolean z = true;
        if (i != 0) {
            if (i2 == 0) {
                i2 = 0;
            } else {
                z = false;
            }
        }
        zzdd.zzd(z);
        zzdd.zzc(str);
        this.zza = str;
        if (zzaf != null) {
            this.zzb = zzaf;
            if (zzaf2 != null) {
                this.zzc = zzaf2;
                this.zzd = i;
                this.zze = i2;
                return;
            }
            throw null;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzgt zzgt = (zzgt) obj;
            return this.zzd == zzgt.zzd && this.zze == zzgt.zze && this.zza.equals(zzgt.zza) && this.zzb.equals(zzgt.zzb) && this.zzc.equals(zzgt.zzc);
        }
    }

    public final int hashCode() {
        return ((((((((this.zzd + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
