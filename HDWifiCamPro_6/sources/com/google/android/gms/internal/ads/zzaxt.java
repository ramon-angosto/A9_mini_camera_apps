package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaxt implements Runnable {
    final /* synthetic */ zzaxw zza;
    final /* synthetic */ zzaxy zzb;

    zzaxt(zzaxy zzaxy, zzaxw zzaxw) {
        this.zzb = zzaxy;
        this.zza = zzaxw;
    }

    public final void run() {
        this.zza.zza();
        int size = this.zzb.zzn.size();
        for (int i = 0; i < size; i++) {
            ((zzayn) this.zzb.zzn.valueAt(i)).zzi();
        }
    }
}
