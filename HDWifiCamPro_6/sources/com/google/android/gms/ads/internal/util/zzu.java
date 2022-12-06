package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzcgi;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzu extends zzt {
    static final boolean zzf(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public final boolean zze(Activity activity, Configuration configuration) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzdW)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzdY)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzaw.zzb();
        int zzw = zzcgi.zzw(activity, configuration.screenHeightDp);
        int zzw2 = zzcgi.zzw(activity, configuration.screenWidthDp);
        zzt.zzp();
        DisplayMetrics zzr = zzs.zzr((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zzr.heightPixels;
        int i2 = zzr.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int round = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) zzay.zzc().zzb(zzbjc.zzdU)).intValue();
        if (!zzf(i, zzw + dimensionPixelSize, round) || !zzf(i2, zzw2, round)) {
            return true;
        }
        return false;
    }
}
