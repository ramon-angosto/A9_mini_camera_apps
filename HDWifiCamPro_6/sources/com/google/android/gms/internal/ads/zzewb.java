package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzewb implements Callable {
    public final /* synthetic */ zzewc zza;

    public /* synthetic */ zzewb(zzewc zzewc) {
        this.zza = zzewc;
    }

    public final Object call() {
        return new zzewd(new JSONObject());
    }
}
