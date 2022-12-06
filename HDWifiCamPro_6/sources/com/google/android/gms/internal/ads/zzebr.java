package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzebr implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzebr(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        CookieManager zzb2 = zzt.zzq().zzb((Context) this.zzb.zzb());
        zzfib zzfib = zzfib.WEBVIEW_COOKIE;
        return zzfhr.zza(new zzebo(zzb2), zzfib, (zzfih) this.zza.zzb()).zzi(1, TimeUnit.SECONDS).zzc(Exception.class, new zzfhu(zzebp.zza)).zza();
    }
}
