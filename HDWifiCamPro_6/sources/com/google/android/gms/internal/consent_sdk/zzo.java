package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
final class zzo {
    private final zzn zza;
    private final Activity zzb;
    private final ConsentDebugSettings zzc;
    private final ConsentRequestParameters zzd;

    /* synthetic */ zzo(zzn zzn, Activity activity, ConsentDebugSettings consentDebugSettings, ConsentRequestParameters consentRequestParameters, zzm zzm) {
        this.zza = zzn;
        this.zzb = activity;
        this.zzc = consentDebugSettings;
        this.zzd = consentRequestParameters;
    }

    static /* synthetic */ zzbu zza(zzo zzo) throws zzj {
        List<zzbp> list;
        String str;
        List<zzbr> list2;
        PackageInfo packageInfo;
        long j;
        View view;
        WindowInsets windowInsets;
        DisplayCutout displayCutout;
        Bundle bundle;
        zzbu zzbu = new zzbu();
        String zza2 = zzo.zzd.zza();
        String str2 = null;
        if (TextUtils.isEmpty(zza2)) {
            try {
                bundle = zzo.zza.zza.getPackageManager().getApplicationInfo(zzo.zza.zza.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                bundle = null;
            }
            if (bundle != null) {
                zza2 = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
            }
            if (TextUtils.isEmpty(zza2)) {
                throw new zzj(3, "The UMP SDK requires a valid application ID in your AndroidManifest.xml through a com.google.android.gms.ads.APPLICATION_ID meta-data tag.\nExample AndroidManifest:\n    <meta-data\n        android:name=\"com.google.android.gms.ads.APPLICATION_ID\"\n        android:value=\"ca-app-pub-0000000000000000~0000000000\">");
            }
        }
        zzbu.zza = zza2;
        zza zza3 = zzo.zza.zzb.zza();
        if (zza3 != null) {
            zzbu.zzc = zza3.zza;
            zzbu.zzb = Boolean.valueOf(zza3.zzb);
        }
        if (!zzo.zzc.isTestDevice()) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList<>();
            int debugGeography = zzo.zzc.getDebugGeography();
            if (debugGeography == 1) {
                list.add(zzbp.GEO_OVERRIDE_EEA);
            } else if (debugGeography == 2) {
                list.add(zzbp.GEO_OVERRIDE_NON_EEA);
            }
            list.add(zzbp.PREVIEWING_DEBUG_MESSAGES);
        }
        zzbu.zzk = list;
        zzbu.zzg = zzo.zza.zzc.zzb();
        zzbu.zzf = Boolean.valueOf(zzo.zzd.isTagForUnderAgeOfConsent());
        if (Build.VERSION.SDK_INT >= 21) {
            str = Locale.getDefault().toLanguageTag();
        } else {
            str = Locale.getDefault().toString();
        }
        zzbu.zze = str;
        zzbq zzbq = new zzbq();
        zzbq.zzb = Integer.valueOf(Build.VERSION.SDK_INT);
        zzbq.zza = Build.MODEL;
        zzbq.zzc = 2;
        zzbu.zzd = zzbq;
        Configuration configuration = zzo.zza.zza.getResources().getConfiguration();
        zzo.zza.zza.getResources().getConfiguration();
        zzbs zzbs = new zzbs();
        zzbs.zza = Integer.valueOf(configuration.screenWidthDp);
        zzbs.zzb = Integer.valueOf(configuration.screenHeightDp);
        zzbs.zzc = Double.valueOf((double) zzo.zza.zza.getResources().getDisplayMetrics().density);
        if (Build.VERSION.SDK_INT < 28) {
            list2 = Collections.emptyList();
        } else {
            Activity activity = zzo.zzb;
            Window window = activity == null ? null : activity.getWindow();
            if (window == null) {
                view = null;
            } else {
                view = window.getDecorView();
            }
            if (view == null) {
                windowInsets = null;
            } else {
                windowInsets = view.getRootWindowInsets();
            }
            if (windowInsets == null) {
                displayCutout = null;
            } else {
                displayCutout = windowInsets.getDisplayCutout();
            }
            if (displayCutout == null) {
                list2 = Collections.emptyList();
            } else {
                displayCutout.getSafeInsetBottom();
                ArrayList arrayList = new ArrayList();
                for (Rect next : displayCutout.getBoundingRects()) {
                    if (next != null) {
                        zzbr zzbr = new zzbr();
                        zzbr.zzb = Integer.valueOf(next.left);
                        zzbr.zzc = Integer.valueOf(next.right);
                        zzbr.zza = Integer.valueOf(next.top);
                        zzbr.zzd = Integer.valueOf(next.bottom);
                        arrayList.add(zzbr);
                    }
                }
                list2 = arrayList;
            }
        }
        zzbs.zzd = list2;
        zzbu.zzh = zzbs;
        Application zza4 = zzo.zza.zza;
        try {
            packageInfo = zzo.zza.zza.getPackageManager().getPackageInfo(zza4.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused2) {
            packageInfo = null;
        }
        zzbo zzbo = new zzbo();
        zzbo.zza = zza4.getPackageName();
        CharSequence applicationLabel = zzo.zza.zza.getPackageManager().getApplicationLabel(zzo.zza.zza.getApplicationInfo());
        if (applicationLabel != null) {
            str2 = applicationLabel.toString();
        }
        zzbo.zzb = str2;
        if (packageInfo != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                j = packageInfo.getLongVersionCode();
            } else {
                j = (long) packageInfo.versionCode;
            }
            zzbo.zzc = Long.toString(j);
        }
        zzbu.zzi = zzbo;
        zzbt zzbt = new zzbt();
        zzbt.zza = "2.0.0";
        zzbu.zzj = zzbt;
        return zzbu;
    }
}
