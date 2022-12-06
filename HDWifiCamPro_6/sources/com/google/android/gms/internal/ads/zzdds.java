package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdds extends zzdij {
    private boolean zzb = false;

    public zzdds(Set set) {
        super(set);
    }

    public final synchronized void zza() {
        if (!this.zzb) {
            zzo(zzddr.zza);
            this.zzb = true;
        }
    }
}
