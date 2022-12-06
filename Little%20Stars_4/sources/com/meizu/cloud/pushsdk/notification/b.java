package com.meizu.cloud.pushsdk.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;

public class b extends f {
    public b(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void b(Notification notification, MessageV3 messageV3) {
        if (com.meizu.cloud.pushsdk.util.b.a()) {
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.b.b.a(this.a));
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.b.b.d(this.a), messageV3.getTitle());
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.b.b.e(this.a), messageV3.getContent());
            remoteViews.setLong(com.meizu.cloud.pushsdk.notification.b.b.f(this.a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            b(remoteViews, messageV3);
            notification.bigContentView = remoteViews;
        }
    }

    private void b(RemoteViews remoteViews, MessageV3 messageV3) {
        if (messageV3.getmNotificationStyle() != null && !a()) {
            if (!TextUtils.isEmpty(messageV3.getmNotificationStyle().getExpandableImageUrl())) {
                Bitmap a = a(messageV3.getmNotificationStyle().getExpandableImageUrl());
                if (a != null) {
                    remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.g(this.a), 0);
                    remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.b.b.g(this.a), a);
                    return;
                }
                remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.g(this.a), 8);
                return;
            }
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.g(this.a), 8);
        }
    }
}
