package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzegw extends zzbyu {
    private final Context zza;
    private final zzdxq zzb;
    private final zzcgu zzc;
    private final zzego zzd;
    private final zzfir zze;

    public zzegw(Context context, zzego zzego, zzcgu zzcgu, zzdxq zzdxq, zzfir zzfir) {
        this.zza = context;
        this.zzb = zzdxq;
        this.zzc = zzcgu;
        this.zzd = zzego;
        this.zze = zzfir;
    }

    public static void zzc(Context context, zzdxq zzdxq, zzfir zzfir, zzego zzego, String str, String str2) {
        zzd(context, zzdxq, zzfir, zzego, str, str2, new HashMap());
    }

    public static void zzd(Context context, zzdxq zzdxq, zzfir zzfir, zzego zzego, String str, String str2, Map map) {
        String str3;
        String str4 = "offline";
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhs)).booleanValue()) {
            zzfiq zzb2 = zzfiq.zzb(str2);
            zzb2.zza("gqi", str);
            if (true == zzt.zzo().zzv(context)) {
                str4 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zzb2.zza("device_connectivity", str4);
            zzb2.zza("event_timestamp", String.valueOf(zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zzb2.zza((String) entry.getKey(), (String) entry.getValue());
            }
            str3 = zzfir.zza(zzb2);
        } else {
            zzdxp zza2 = zzdxq.zza();
            zza2.zzb("gqi", str);
            zza2.zzb("action", str2);
            if (true == zzt.zzo().zzv(context)) {
                str4 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zza2.zzb("device_connectivity", str4);
            zza2.zzb("event_timestamp", String.valueOf(zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry2 : map.entrySet()) {
                zza2.zzb((String) entry2.getKey(), (String) entry2.getValue());
            }
            str3 = zza2.zzf();
        }
        zzego.zzd(new zzegq(zzt.zzB().currentTimeMillis(), str, str3, 2));
    }

    public static void zzh(Activity activity, zzl zzl, zzbr zzbr, zzego zzego, zzdxq zzdxq, zzfir zzfir, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        zzt.zzp();
        AlertDialog.Builder zzG = zzs.zzG(activity);
        Resources zzd2 = zzt.zzo().zzd();
        if (zzd2 == null) {
            str3 = "Open ad when you're back online.";
        } else {
            str3 = zzd2.getString(R.string.offline_opt_in_title);
        }
        AlertDialog.Builder title = zzG.setTitle(str3);
        if (zzd2 == null) {
            str4 = "We'll send you a notification with a link to the advertiser site.";
        } else {
            str4 = zzd2.getString(R.string.offline_opt_in_message);
        }
        AlertDialog.Builder message = title.setMessage(str4);
        if (zzd2 == null) {
            str5 = "OK";
        } else {
            str5 = zzd2.getString(R.string.offline_opt_in_confirm);
        }
        AlertDialog.Builder positiveButton = message.setPositiveButton(str5, new zzegs(zzdxq, activity, zzfir, zzego, str, zzbr, str2, zzd2, zzl));
        if (zzd2 == null) {
            str6 = "No thanks";
        } else {
            str6 = zzd2.getString(R.string.offline_opt_in_decline);
        }
        positiveButton.setNegativeButton(str6, new zzegt(zzego, str, zzdxq, activity, zzfir, zzl)).setOnCancelListener(new zzegu(zzego, str, zzdxq, activity, zzfir, zzl));
        zzG.create().show();
    }

    private final void zzi(String str, String str2, Map map) {
        zzd(this.zza, this.zzb, this.zze, this.zzd, str, str2, map);
    }

    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            boolean zzv = zzt.zzo().zzv(this.zza);
            HashMap hashMap = new HashMap();
            char c = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (true == zzv) {
                    c = 1;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                try {
                    Context context = this.zza;
                    Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzi(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zzd.getWritableDatabase();
                if (c == 1) {
                    this.zzd.zzg(writableDatabase, this.zzc, stringExtra2);
                } else {
                    zzego.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                zze.zzg("Failed to get writable offline buffering database: ".concat(e.toString()));
            }
        }
    }

    public final void zzf() {
        this.zzd.zze(new zzegk(this.zzc));
    }

    public final void zzg(IObjectWrapper iObjectWrapper, String str, String str2) {
        String str3;
        String str4;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzt.zzq().zzg(context);
        Intent intent = new Intent();
        intent.setClass(context, AdService.class);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str);
        PendingIntent zza2 = zzfqd.zza(context, 0, intent, zzfqd.zza | 1073741824, 0);
        Intent intent2 = new Intent();
        intent2.setClass(context, AdService.class);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent zza3 = zzfqd.zza(context, 0, intent2, zzfqd.zza | 1073741824, 0);
        Resources zzd2 = zzt.zzo().zzd();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        if (zzd2 == null) {
            str3 = "View the ad you saved when you were offline";
        } else {
            str3 = zzd2.getString(R.string.offline_notification_title);
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(str3);
        if (zzd2 == null) {
            str4 = "Tap to open ad";
        } else {
            str4 = zzd2.getString(R.string.offline_notification_text);
        }
        ((NotificationManager) context.getSystemService("notification")).notify(str2, 54321, contentTitle.setContentText(str4).setAutoCancel(true).setDeleteIntent(zza3).setContentIntent(zza2).setSmallIcon(context.getApplicationInfo().icon).build());
        zzi(str2, "offline_notification_impression", new HashMap());
    }
}
