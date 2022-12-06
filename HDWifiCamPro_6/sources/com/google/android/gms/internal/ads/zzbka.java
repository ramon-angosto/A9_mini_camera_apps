package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbka {
    private CustomTabsSession zza;
    private CustomTabsClient zzb;
    private CustomTabsServiceConnection zzc;
    private zzbjy zzd;

    public static boolean zzg(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (!(queryIntentActivities == null || resolveActivity == null)) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzgxw.zza(context));
                }
            }
        }
        return false;
    }

    public final CustomTabsSession zza() {
        CustomTabsClient customTabsClient = this.zzb;
        if (customTabsClient == null) {
            this.zza = null;
        } else if (this.zza == null) {
            this.zza = customTabsClient.newSession((CustomTabsCallback) null);
        }
        return this.zza;
    }

    public final void zzb(Activity activity) {
        String zza2;
        if (this.zzb == null && (zza2 = zzgxw.zza(activity)) != null) {
            this.zzc = new zzgxx(this, (byte[]) null);
            CustomTabsClient.bindCustomTabsService(activity, zza2, this.zzc);
        }
    }

    public final void zzc(CustomTabsClient customTabsClient) {
        this.zzb = customTabsClient;
        this.zzb.warmup(0);
        zzbjy zzbjy = this.zzd;
        if (zzbjy != null) {
            zzbjy.zza();
        }
    }

    public final void zzd() {
        this.zzb = null;
        this.zza = null;
    }

    public final void zze(zzbjy zzbjy) {
        this.zzd = zzbjy;
    }

    public final void zzf(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.zzc;
        if (customTabsServiceConnection != null) {
            activity.unbindService(customTabsServiceConnection);
            this.zzb = null;
            this.zza = null;
            this.zzc = null;
        }
    }
}
