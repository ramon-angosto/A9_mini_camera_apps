package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzduv implements zzcoa {
    public final /* synthetic */ zzchh zza;

    public /* synthetic */ zzduv(zzchh zzchh) {
        this.zza = zzchh;
    }

    public final void zza(boolean z) {
        zzchh zzchh = this.zza;
        if (z) {
            zzchh.zzd((Object) null);
        } else {
            zzchh.zze(new Exception("Ad Web View failed to load."));
        }
    }
}
