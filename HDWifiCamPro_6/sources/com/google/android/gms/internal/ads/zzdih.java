package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdih implements Runnable {
    public final /* synthetic */ zzdii zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzdih(zzdii zzdii, Object obj) {
        this.zza = zzdii;
        this.zzb = obj;
    }

    public final void run() {
        try {
            this.zza.zza(this.zzb);
        } catch (Throwable th) {
            zzt.zzo().zzs(th, "EventEmitter.notify");
            zze.zzb("Event emitter exception.", th);
        }
    }
}
