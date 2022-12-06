package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaxx implements zzayo {
    final /* synthetic */ zzaxy zza;
    /* access modifiers changed from: private */
    public final int zzb;

    public zzaxx(zzaxy zzaxy, int i) {
        this.zza = zzaxy;
        this.zzb = i;
    }

    public final int zzb(zzasx zzasx, zzaur zzaur, boolean z) {
        return this.zza.zze(this.zzb, zzasx, zzaur, z);
    }

    public final void zzc() throws IOException {
        this.zza.zzr();
    }

    public final void zzd(long j) {
        this.zza.zzy(this.zzb, j);
    }

    public final boolean zze() {
        return this.zza.zzA(this.zzb);
    }
}
