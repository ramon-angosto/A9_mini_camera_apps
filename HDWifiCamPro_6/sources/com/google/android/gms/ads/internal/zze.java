package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbua;
import com.google.android.gms.internal.ads.zzbuh;
import com.google.android.gms.internal.ads.zzcfs;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzchf;
import com.google.android.gms.internal.ads.zzfji;
import com.google.android.gms.internal.ads.zzfjj;
import com.google.android.gms.internal.ads.zzfjw;
import com.google.android.gms.internal.ads.zzfzg;
import com.google.android.gms.internal.ads.zzfzp;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zze {
    private Context zza;
    private long zzb = 0;

    public final void zza(Context context, zzcgv zzcgv, String str, Runnable runnable, zzfjw zzfjw) {
        zzb(context, zzcgv, true, (zzcfs) null, str, (String) null, runnable, zzfjw);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Context context, zzcgv zzcgv, boolean z, zzcfs zzcfs, String str, String str2, Runnable runnable, zzfjw zzfjw) {
        PackageInfo packageInfo;
        if (zzt.zzB().elapsedRealtime() - this.zzb < DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
            com.google.android.gms.ads.internal.util.zze.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzt.zzB().elapsedRealtime();
        if (zzcfs != null) {
            long zza2 = zzcfs.zza();
            if (zzt.zzB().currentTimeMillis() - zza2 <= ((Long) zzay.zzc().zzb(zzbjc.zzdi)).longValue() && zzcfs.zzi()) {
                return;
            }
        }
        if (context == null) {
            com.google.android.gms.ads.internal.util.zze.zzj("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zza = applicationContext;
            zzfjj zza3 = zzfji.zza(context, 4);
            zza3.zzf();
            zzbua zza4 = zzt.zzf().zza(this.zza, zzcgv, zzfjw).zza("google.afma.config.fetchAppSettings", zzbuh.zza, zzbuh.zza);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                jSONObject.put("experiment_ids", TextUtils.join(",", zzbjc.zza()));
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (!(applicationInfo == null || (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) == null)) {
                        jSONObject.put("version", packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
                }
                zzfzp zzb2 = zza4.zzb(jSONObject);
                zzfzp zzn = zzfzg.zzn(zzb2, new zzd(zzfjw, zza3), zzchc.zzf);
                if (runnable != null) {
                    zzb2.zzc(runnable, zzchc.zzf);
                }
                zzchf.zza(zzn, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.zze.zzh("Error requesting application settings", e);
                zza3.zze(false);
                zzfjw.zzb(zza3.zzj());
            }
        } else {
            com.google.android.gms.ads.internal.util.zze.zzj("App settings could not be fetched. Required parameters missing");
        }
    }

    public final void zzc(Context context, zzcgv zzcgv, String str, zzcfs zzcfs, zzfjw zzfjw) {
        zzb(context, zzcgv, false, zzcfs, zzcfs != null ? zzcfs.zzb() : null, str, (Runnable) null, zzfjw);
    }
}
