package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzats {
    private final Handler zza;
    /* access modifiers changed from: private */
    public final zzatt zzb;

    public zzats(Handler handler, zzatt zzatt) {
        if (handler != null) {
            this.zza = handler;
            this.zzb = zzatt;
            return;
        }
        throw null;
    }

    public final void zzb(int i) {
        this.zza.post(new zzatr(this, i));
    }

    public final void zzc(int i, long j, long j2) {
        this.zza.post(new zzatp(this, i, j, j2));
    }

    public final void zzd(String str, long j, long j2) {
        this.zza.post(new zzatn(this, str, j, j2));
    }

    public final void zze(zzauq zzauq) {
        this.zza.post(new zzatq(this, zzauq));
    }

    public final void zzf(zzauq zzauq) {
        this.zza.post(new zzatm(this, zzauq));
    }

    public final void zzg(zzasw zzasw) {
        this.zza.post(new zzato(this, zzasw));
    }
}
