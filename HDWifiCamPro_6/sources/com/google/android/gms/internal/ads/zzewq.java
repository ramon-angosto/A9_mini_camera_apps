package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzewq implements Callable {
    public final /* synthetic */ zzewr zza;

    public /* synthetic */ zzewq(zzewr zzewr) {
        this.zza = zzewr;
    }

    public final Object call() {
        return new zzews(new JSONObject());
    }
}
