package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbjp {
    private final Map zza = new HashMap();
    private final zzbjr zzb;

    public zzbjp(zzbjr zzbjr) {
        this.zzb = zzbjr;
    }

    public final zzbjr zza() {
        return this.zzb;
    }

    public final void zzb(String str, zzbjo zzbjo) {
        this.zza.put(str, zzbjo);
    }

    public final void zzc(String str, String str2, long j) {
        zzbjr zzbjr = this.zzb;
        zzbjo zzbjo = (zzbjo) this.zza.get(str2);
        String[] strArr = {str};
        if (zzbjo != null) {
            zzbjr.zze(zzbjo, j, strArr);
        }
        this.zza.put(str, new zzbjo(j, (String) null, (zzbjo) null));
    }
}
