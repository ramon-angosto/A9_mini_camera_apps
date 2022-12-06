package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final /* synthetic */ class zzd implements Callable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzi zzc;

    public /* synthetic */ zzd(boolean z, String str, zzi zzi) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzi;
    }

    public final Object call() {
        return zzm.zzc(this.zza, this.zzb, this.zzc);
    }
}
