package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzequ implements zzfyn {
    public static final /* synthetic */ zzequ zza = new zzequ();

    private /* synthetic */ zzequ() {
    }

    public final zzfzp zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        if (appSetIdInfo == null) {
            return zzfzg.zzi(new zzeqx((String) null, -1));
        }
        return zzfzg.zzi(new zzeqx(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
