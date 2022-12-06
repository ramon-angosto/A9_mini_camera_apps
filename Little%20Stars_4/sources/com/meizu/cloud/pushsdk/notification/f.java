package com.meizu.cloud.pushsdk.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.util.b;

public class f extends a {
    public f(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void a(Notification notification, MessageV3 messageV3) {
        if (b.a()) {
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.b.b.a(this.a));
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.b.b.d(this.a), messageV3.getTitle());
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.b.b.e(this.a), messageV3.getContent());
            remoteViews.setLong(com.meizu.cloud.pushsdk.notification.b.b.f(this.a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.g(this.a), 8);
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.h(this.a), 8);
            notification.contentView = remoteViews;
        }
    }

    /* access modifiers changed from: protected */
    public void a(RemoteViews remoteViews, MessageV3 messageV3) {
        if (messageV3.getmAppIconSetting() == null || a()) {
            remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.b.b.k(this.a), a(this.a, messageV3.getPackageName()));
        } else if (!messageV3.getmAppIconSetting().isDefaultLargeIcon()) {
            Bitmap a = a(messageV3.getmAppIconSetting().getLargeIconUrl());
            if (a != null) {
                remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.b.b.k(this.a), a);
            } else {
                remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.b.b.k(this.a), a(this.a, messageV3.getPackageName()));
            }
        } else {
            remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.b.b.k(this.a), a(this.a, messageV3.getPackageName()));
        }
    }
}
