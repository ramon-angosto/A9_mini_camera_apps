package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfge {
    private final HashMap zza = new HashMap();

    public final zzfgd zza(zzffu zzffu, Context context, zzffm zzffm, zzfgk zzfgk) {
        zzfgd zzfgd = (zzfgd) this.zza.get(zzffu);
        if (zzfgd != null) {
            return zzfgd;
        }
        zzffr zzffr = new zzffr(zzffx.zza(zzffu, context));
        zzfgd zzfgd2 = new zzfgd(zzffr, new zzfgm(zzffr, zzffm, zzfgk));
        this.zza.put(zzffu, zzfgd2);
        return zzfgd2;
    }
}
