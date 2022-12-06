package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzfsm;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzv implements zzfsm {
    public static final /* synthetic */ zzv zza = new zzv();

    private /* synthetic */ zzv() {
    }

    public final Object apply(Object obj) {
        int i = zzaa.zze;
        return ((JSONObject) obj).optString("nas");
    }
}
