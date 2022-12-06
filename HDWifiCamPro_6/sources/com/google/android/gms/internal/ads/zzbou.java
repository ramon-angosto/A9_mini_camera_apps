package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbou implements zzfsm {
    public static final /* synthetic */ zzbou zza = new zzbou();

    private /* synthetic */ zzbou() {
    }

    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        zzbpu zzbpu = zzbpt.zza;
        if (!((Boolean) zzbkr.zzk.zze()).booleanValue()) {
            return "failure_click_attok";
        }
        zzt.zzo().zzt(th, "prepareClickUrl.attestation1");
        return "failure_click_attok";
    }
}
