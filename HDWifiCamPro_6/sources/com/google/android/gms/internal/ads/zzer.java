package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzer implements zzex {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzfc zzd;

    protected zzer(boolean z) {
        this.zza = z;
    }

    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    public final void zzf(zzfz zzfz) {
        if (zzfz == null) {
            throw null;
        } else if (!this.zzb.contains(zzfz)) {
            this.zzb.add(zzfz);
            this.zzc++;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzg(int i) {
        zzfc zzfc = this.zzd;
        int i2 = zzen.zza;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzfz) this.zzb.get(i3)).zza(this, zzfc, this.zza, i);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzh() {
        zzfc zzfc = this.zzd;
        int i = zzen.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzfz) this.zzb.get(i2)).zzb(this, zzfc, this.zza);
        }
        this.zzd = null;
    }

    /* access modifiers changed from: protected */
    public final void zzi(zzfc zzfc) {
        for (int i = 0; i < this.zzc; i++) {
            ((zzfz) this.zzb.get(i)).zzc(this, zzfc, this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj(zzfc zzfc) {
        this.zzd = zzfc;
        for (int i = 0; i < this.zzc; i++) {
            ((zzfz) this.zzb.get(i)).zzd(this, zzfc, this.zza);
        }
    }
}
