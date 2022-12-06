package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeqt implements zzfsm {
    public static final /* synthetic */ zzeqt zza = new zzeqt();

    private /* synthetic */ zzeqt() {
    }

    public final Object apply(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return new zzeqx(appSetIdInfo.getId(), appSetIdInfo.getScope());
    }
}
