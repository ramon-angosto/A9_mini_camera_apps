package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzcmp;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzcnt;
import java.io.InputStream;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzt extends zzaa {
    public zzt() {
        super((zzz) null);
    }

    public final int zza() {
        return 16974374;
    }

    public final CookieManager zzb(Context context) {
        com.google.android.gms.ads.internal.zzt.zzp();
        if (zzs.zzB()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zze.zzh("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzt.zzo().zzt(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final WebResourceResponse zzc(String str, String str2, int i, String str3, Map map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }

    public final zzcmw zzd(zzcmp zzcmp, zzbep zzbep, boolean z) {
        return new zzcnt(zzcmp, zzbep, z);
    }
}
