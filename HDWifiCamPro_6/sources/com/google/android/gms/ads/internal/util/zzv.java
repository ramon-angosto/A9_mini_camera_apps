package com.google.android.gms.ads.internal.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzv extends zzu {
    public final void zzg(Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", 2);
        notificationChannel.setShowBadge(false);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    }

    public final int zzh(Context context, TelephonyManager telephonyManager) {
        zzt.zzp();
        if (!zzs.zzx(context, "android.permission.ACCESS_NETWORK_STATE") || !telephonyManager.isDataEnabled()) {
            return 1;
        }
        return 2;
    }
}
