package com.google.android.gms.ads.mediation.customevent;

import java.util.HashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class CustomEventExtras {
    private final HashMap zza = new HashMap();

    public Object getExtra(String str) {
        return this.zza.get(str);
    }

    public void setExtra(String str, Object obj) {
        this.zza.put(str, obj);
    }
}
