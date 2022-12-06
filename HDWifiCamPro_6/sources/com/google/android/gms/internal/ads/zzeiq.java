package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeiq implements zzehc {
    private final Context zza;
    private final zzdmh zzb;
    private final Executor zzc;
    private final zzfdj zzd;

    public zzeiq(Context context, Executor executor, zzdmh zzdmh, zzfdj zzfdj) {
        this.zza = context;
        this.zzb = zzdmh;
        this.zzc = executor;
        this.zzd = zzfdj;
    }

    private static String zzd(zzfdk zzfdk) {
        try {
            return zzfdk.zzw.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        String zzd2 = zzd(zzfdk);
        return zzfzg.zzn(zzfzg.zzi((Object) null), new zzeio(this, zzd2 != null ? Uri.parse(zzd2) : null, zzfdw, zzfdk), this.zzc);
    }

    public final boolean zzb(zzfdw zzfdw, zzfdk zzfdk) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbka.zzg(context) && !TextUtils.isEmpty(zzd(zzfdk));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(Uri uri, zzfdw zzfdw, zzfdk zzfdk, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzc zzc2 = new zzc(build.intent, (zzx) null);
            zzchh zzchh = new zzchh();
            zzdlh zze = this.zzb.zze(new zzczt(zzfdw, zzfdk, (String) null), new zzdlk(new zzeip(zzchh), (zzcmp) null));
            zzchh.zzd(new AdOverlayInfoParcel(zzc2, (zza) null, zze.zza(), (zzz) null, new zzcgv(0, 0, false, false, false), (zzcmp) null, (zzdkn) null));
            this.zzd.zza();
            return zzfzg.zzi(zze.zzg());
        } catch (Throwable th) {
            zze.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
