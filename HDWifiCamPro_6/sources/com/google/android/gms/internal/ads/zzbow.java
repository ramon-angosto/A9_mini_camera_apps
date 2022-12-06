package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbow implements zzfsm {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzbow(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        Throwable th = (Throwable) obj;
        zzbpu zzbpu = zzbpt.zza;
        if (((Boolean) zzbkr.zzk.zze()).booleanValue()) {
            zzt.zzo().zzt(th, "prepareClickUrl.attestation2");
        }
        return str;
    }
}
