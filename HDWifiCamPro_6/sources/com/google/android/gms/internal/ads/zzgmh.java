package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgmh extends zzgra implements zzgsp {
    private zzgmh() {
        super(zzgmk.zzb);
    }

    public final zzgmh zza(zzgmj zzgmj) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgmk.zzj((zzgmk) this.zza, zzgmj);
        return this;
    }

    public final zzgmh zzb(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgmk) this.zza).zze = i;
        return this;
    }

    public final List zzc() {
        return Collections.unmodifiableList(((zzgmk) this.zza).zzh());
    }

    /* synthetic */ zzgmh(zzgmg zzgmg) {
        super(zzgmk.zzb);
    }
}
