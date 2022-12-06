package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzewf implements zzfyn {
    public static final /* synthetic */ zzewf zza = new zzewf();

    private /* synthetic */ zzewf() {
    }

    public final zzfzp zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        if (appSetIdInfo == null) {
            return zzfzg.zzi(new zzewi((String) null, -1));
        }
        return zzfzg.zzi(new zzewi(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
