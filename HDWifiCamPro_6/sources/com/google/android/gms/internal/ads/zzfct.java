package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfct implements Runnable {
    public final /* synthetic */ zzfcu zza;
    public final /* synthetic */ zze zzb;

    public /* synthetic */ zzfct(zzfcu zzfcu, zze zze) {
        this.zza = zzfcu;
        this.zzb = zze;
    }

    public final void run() {
        zzfcu zzfcu = this.zza;
        zzfcu.zze.zzd.zza(this.zzb);
    }
}
