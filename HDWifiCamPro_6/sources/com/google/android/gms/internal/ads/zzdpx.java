package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdpx implements zzbpu {
    public final /* synthetic */ zzdqb zza;

    public /* synthetic */ zzdpx(zzdqb zzdqb) {
        this.zza = zzdqb;
    }

    public final void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        zzcmp.zzP().zzz(new zzdqa(this.zza, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzcmp.loadData(str, "text/html", "UTF-8");
        } else {
            zzcmp.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
