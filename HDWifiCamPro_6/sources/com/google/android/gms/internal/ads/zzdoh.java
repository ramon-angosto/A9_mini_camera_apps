package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdoh implements Runnable {
    public final /* synthetic */ zzdol zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzdoh(zzdol zzdol, boolean z) {
        this.zza = zzdol;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzs(this.zzb);
    }
}
