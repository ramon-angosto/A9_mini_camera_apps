package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfrx implements ServiceConnection {
    final /* synthetic */ zzfry zza;

    /* synthetic */ zzfrx(zzfry zzfry, zzfrw zzfrw) {
        this.zza = zzfry;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zza.zzc.zzd("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        zzfry zzfry = this.zza;
        zzfry.zzc().post(new zzfru(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zzc.zzd("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        zzfry zzfry = this.zza;
        zzfry.zzc().post(new zzfrv(this));
    }
}
