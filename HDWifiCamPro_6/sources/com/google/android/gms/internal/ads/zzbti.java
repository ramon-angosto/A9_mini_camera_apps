package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbti implements zzbpu {
    final /* synthetic */ zzbsr zza;
    final /* synthetic */ zzca zzb;
    final /* synthetic */ zzbtw zzc;

    zzbti(zzbtw zzbtw, zzape zzape, zzbsr zzbsr, zzca zzca) {
        this.zzc = zzbtw;
        this.zza = zzbsr;
        this.zzb = zzca;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Object, com.google.android.gms.internal.ads.zzbpu] */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbtx zzbtx = (zzbtx) obj;
        synchronized (this.zzc.zza) {
            zze.zzi("JS Engine is requesting an update");
            if (this.zzc.zzi == 0) {
                zze.zzi("Starting reload.");
                this.zzc.zzi = 2;
                this.zzc.zzd((zzape) null);
            }
            this.zza.zzr("/requestReload", this.zzb.zza());
        }
    }
}
