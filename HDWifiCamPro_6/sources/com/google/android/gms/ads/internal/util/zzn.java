package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbjy;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzgxw;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzn implements zzbjy {
    final /* synthetic */ zzbka zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    zzn(zzs zzs, zzbka zzbka, Context context, Uri uri) {
        this.zza = zzbka;
        this.zzb = context;
        this.zzc = uri;
    }

    public final void zza() {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.zza.zza()).build();
        build.intent.setPackage(zzgxw.zza(this.zzb));
        build.launchUrl(this.zzb, this.zzc);
        this.zza.zzf((Activity) this.zzb);
    }
}
