package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzefi implements Callable {
    public final /* synthetic */ zzefg zza;

    public /* synthetic */ zzefi(zzefg zzefg) {
        this.zza = zzefg;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
