package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbbk {
    private final Handler zza;
    /* access modifiers changed from: private */
    public final zzbbl zzb;

    public zzbbk(Handler handler, zzbbl zzbbl) {
        if (handler != null) {
            this.zza = handler;
            this.zzb = zzbbl;
            return;
        }
        throw null;
    }

    public final void zzb(String str, long j, long j2) {
        this.zza.post(new zzbbe(this, str, j, j2));
    }

    public final void zzc(zzauq zzauq) {
        this.zza.post(new zzbbj(this, zzauq));
    }

    public final void zzd(int i, long j) {
        this.zza.post(new zzbbg(this, i, j));
    }

    public final void zze(zzauq zzauq) {
        this.zza.post(new zzbbd(this, zzauq));
    }

    public final void zzf(zzasw zzasw) {
        this.zza.post(new zzbbf(this, zzasw));
    }

    public final void zzg(Surface surface) {
        this.zza.post(new zzbbi(this, surface));
    }

    public final void zzh(int i, int i2, int i3, float f) {
        this.zza.post(new zzbbh(this, i, i2, i3, f));
    }
}
