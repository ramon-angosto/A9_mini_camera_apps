package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjc;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zza {
    public static final boolean zza(Context context, Intent intent, zzz zzz, zzx zzx, boolean z) {
        if (z) {
            return zzc(context, intent.getData(), zzz, zzx);
        }
        try {
            String uri = intent.toURI();
            zze.zza("Launching an intent: " + uri);
            zzt.zzp();
            zzs.zzJ(context, intent);
            if (zzz != null) {
                zzz.zzg();
            }
            if (zzx != null) {
                zzx.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zze.zzj(e.getMessage());
            if (zzx != null) {
                zzx.zza(false);
            }
            return false;
        }
    }

    public static final boolean zzb(Context context, zzc zzc, zzz zzz, zzx zzx) {
        int i = 0;
        if (zzc == null) {
            zze.zzj("No intent data for launcher overlay.");
            return false;
        }
        zzbjc.zzc(context);
        Intent intent = zzc.zzh;
        if (intent != null) {
            return zza(context, intent, zzz, zzx, zzc.zzj);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzc.zzb)) {
            zze.zzj("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzc.zzc)) {
            intent2.setDataAndType(Uri.parse(zzc.zzb), zzc.zzc);
        } else {
            intent2.setData(Uri.parse(zzc.zzb));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.zzd)) {
            intent2.setPackage(zzc.zzd);
        }
        if (!TextUtils.isEmpty(zzc.zze)) {
            String[] split = zzc.zze.split("/", 2);
            if (split.length < 2) {
                zze.zzj("Could not parse component name from open GMSG: ".concat(String.valueOf(zzc.zze)));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str = zzc.zzf;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zze.zzj("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzdG)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzdF)).booleanValue()) {
                zzt.zzp();
                zzs.zzm(context, intent2);
            }
        }
        return zza(context, intent2, zzz, zzx, zzc.zzj);
    }

    private static final boolean zzc(Context context, Uri uri, zzz zzz, zzx zzx) {
        int i;
        try {
            i = zzt.zzp().zzk(context, uri);
            if (zzz != null) {
                zzz.zzg();
            }
        } catch (ActivityNotFoundException e) {
            zze.zzj(e.getMessage());
            i = 6;
        }
        if (zzx != null) {
            zzx.zzb(i);
        }
        return i == 5;
    }
}
