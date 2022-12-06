package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfma {
    private final zzfli zza;
    private final ArrayList zzb = new ArrayList();

    public zzfma(zzfli zzfli, String str) {
        this.zza = zzfli;
        this.zzb.add(str);
    }

    public final zzfli zza() {
        return this.zza;
    }

    public final ArrayList zzb() {
        return this.zzb;
    }

    public final void zzc(String str) {
        this.zzb.add(str);
    }
}
