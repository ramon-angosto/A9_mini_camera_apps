package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzti implements zztz {
    final /* synthetic */ zztl zza;
    /* access modifiers changed from: private */
    public final int zzb;

    public zzti(zztl zztl, int i) {
        this.zza = zztl;
        this.zzb = i;
    }

    public final int zza(zzjg zzjg, zzgi zzgi, int i) {
        return this.zza.zzg(this.zzb, zzjg, zzgi, i);
    }

    public final int zzb(long j) {
        return this.zza.zzi(this.zzb, j);
    }

    public final void zzd() throws IOException {
        this.zza.zzH(this.zzb);
    }

    public final boolean zze() {
        return this.zza.zzO(this.zzb);
    }
}
