package com.meizu.cloud.pushsdk.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.a.a.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.b;

public abstract class a implements e {
    protected Context a;
    protected PushNotificationBuilder b;
    protected Handler c;
    private NotificationManager d;

    /* access modifiers changed from: protected */
    public void a(Notification.Builder builder, MessageV3 messageV3) {
    }

    /* access modifiers changed from: protected */
    public void a(Notification notification, MessageV3 messageV3) {
    }

    /* access modifiers changed from: protected */
    public void b(Notification.Builder builder, MessageV3 messageV3) {
    }

    /* access modifiers changed from: protected */
    public void b(Notification notification, MessageV3 messageV3) {
    }

    protected a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        this.b = pushNotificationBuilder;
        this.a = context;
        this.c = new Handler(context.getMainLooper());
        this.d = (NotificationManager) context.getSystemService("notification");
    }

    /* access modifiers changed from: protected */
    public Notification a(MessageV3 messageV3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Notification notification;
        Notification.Builder builder = new Notification.Builder(this.a);
        a(builder, messageV3, pendingIntent, pendingIntent2);
        c(builder, messageV3);
        b(builder, messageV3);
        a(builder, messageV3);
        if (b.a()) {
            notification = builder.build();
        } else {
            notification = builder.getNotification();
        }
        a(notification, messageV3);
        b(notification, messageV3);
        return notification;
    }

    /* access modifiers changed from: protected */
    public PendingIntent a(MessageV3 messageV3) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        Context context = this.a;
        intent.setClassName(this.a.getPackageName(), MzSystemUtils.a(context, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, context.getPackageName()));
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        return PendingIntent.getBroadcast(this.a, 0, intent, 1073741824);
    }

    /* access modifiers changed from: protected */
    public PendingIntent b(MessageV3 messageV3) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_DELETE);
        Context context = this.a;
        intent.setClassName(this.a.getPackageName(), MzSystemUtils.a(context, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, context.getPackageName()));
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        return PendingIntent.getBroadcast(this.a, 0, intent, 1073741824);
    }

    /* access modifiers changed from: protected */
    public void a(Notification.Builder builder, MessageV3 messageV3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        builder.setContentTitle(messageV3.getTitle());
        builder.setContentText(messageV3.getContent());
        builder.setTicker(messageV3.getContent());
        builder.setAutoCancel(true);
        if (b.b()) {
            builder.setVisibility(1);
        }
        PushNotificationBuilder pushNotificationBuilder = this.b;
        builder.setSmallIcon((pushNotificationBuilder == null || pushNotificationBuilder.getmStatusbarIcon() == 0) ? this.a.getApplicationInfo().icon : this.b.getmStatusbarIcon());
        builder.setContentIntent(pendingIntent);
        builder.setDeleteIntent(pendingIntent2);
    }

    /* access modifiers changed from: protected */
    public void c(Notification.Builder builder, MessageV3 messageV3) {
        AdvanceSetting advanceSetting = messageV3.getmAdvanceSetting();
        if (advanceSetting != null) {
            if (advanceSetting.getNotifyType() != null) {
                boolean isVibrate = advanceSetting.getNotifyType().isVibrate();
                boolean isLights = advanceSetting.getNotifyType().isLights();
                boolean isSound = advanceSetting.getNotifyType().isSound();
                if (isVibrate || isLights || isSound) {
                    int i = 0;
                    if (isVibrate) {
                        i = 2;
                    }
                    if (isLights) {
                        i |= 4;
                    }
                    if (isSound) {
                        i |= 1;
                    }
                    DebugLogger.e("AbstractPushNotification", "current notification type is " + i);
                    builder.setDefaults(i);
                }
            }
            builder.setOngoing(!advanceSetting.isClearNotification());
            if (advanceSetting.isHeadUpNotification() && b.a()) {
                builder.setPriority(2);
            }
        }
    }

    public Bitmap a(String str) {
        c a2 = com.meizu.cloud.pushsdk.a.a.a(str).a().a();
        if (!a2.b() || a2.a() == null) {
            DebugLogger.i("AbstractPushNotification", "ANRequest On other Thread down load largeIcon " + str + "image fail");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ANRequest On other Thread down load largeIcon ");
        sb.append(str);
        sb.append("image ");
        sb.append(a2.a() != null ? "success" : "fail");
        DebugLogger.i("AbstractPushNotification", sb.toString());
        return (Bitmap) a2.a();
    }

    public Bitmap a(Context context, String str) {
        try {
            return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(str)).getBitmap();
        } catch (PackageManager.NameNotFoundException e) {
            DebugLogger.i("AbstractPushNotification", "getappicon error " + e.getMessage());
            return ((BitmapDrawable) context.getApplicationInfo().loadIcon(context.getPackageManager())).getBitmap();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return Thread.currentThread() == this.a.getMainLooper().getThread();
    }

    public void c(MessageV3 messageV3) {
        Notification a2 = a(messageV3, a(messageV3), b(messageV3));
        int currentTimeMillis = (int) System.currentTimeMillis();
        if (messageV3.isDiscard()) {
            if (com.meizu.cloud.pushsdk.util.c.c(this.a, messageV3.getPackageName()) == 0) {
                com.meizu.cloud.pushsdk.util.c.a(this.a, messageV3.getPackageName(), currentTimeMillis);
                DebugLogger.i("AbstractPushNotification", "no notification show so put notification id " + currentTimeMillis);
            }
            if (!TextUtils.isEmpty(messageV3.getTaskId())) {
                if (com.meizu.cloud.pushsdk.util.c.d(this.a, messageV3.getPackageName()) == 0) {
                    com.meizu.cloud.pushsdk.util.c.b(this.a, messageV3.getPackageName(), Integer.valueOf(messageV3.getTaskId()).intValue());
                } else if (Integer.valueOf(messageV3.getTaskId()).intValue() < com.meizu.cloud.pushsdk.util.c.d(this.a, messageV3.getPackageName())) {
                    DebugLogger.i("AbstractPushNotification", "current package " + messageV3.getPackageName() + " taskid " + messageV3.getTaskId() + " dont show notification");
                    return;
                } else {
                    com.meizu.cloud.pushsdk.util.c.b(this.a, messageV3.getPackageName(), Integer.valueOf(messageV3.getTaskId()).intValue());
                    currentTimeMillis = com.meizu.cloud.pushsdk.util.c.c(this.a, messageV3.getPackageName());
                }
            }
            DebugLogger.i("AbstractPushNotification", "current package " + messageV3.getPackageName() + " notificationId=" + currentTimeMillis + " taskId=" + messageV3.getTaskId());
        }
        this.d.notify(currentTimeMillis, a2);
        a(this.d, currentTimeMillis, messageV3);
    }

    /* access modifiers changed from: protected */
    public void a(final NotificationManager notificationManager, final int i, MessageV3 messageV3) {
        AdvanceSetting advanceSetting = messageV3.getmAdvanceSetting();
        if (advanceSetting != null) {
            boolean isHeadUpNotification = advanceSetting.isHeadUpNotification();
            boolean isClearNotification = advanceSetting.isClearNotification();
            if (isHeadUpNotification && !isClearNotification) {
                messageV3.getmAdvanceSetting().setHeadUpNotification(false);
                messageV3.getmAdvanceSetting().getNotifyType().setSound(false);
                messageV3.getmAdvanceSetting().getNotifyType().setVibrate(false);
                final Notification a2 = a(messageV3, a(messageV3), b(messageV3));
                this.c.postDelayed(new Runnable() {
                    public void run() {
                        notificationManager.notify(i, a2);
                    }
                }, 5000);
            }
        }
    }
}
