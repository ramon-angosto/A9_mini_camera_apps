package com.meizu.cloud.pushsdk.notification;

import android.app.Notification;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.util.b;

public class c extends f {
    public c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void b(Notification notification, MessageV3 messageV3) {
        if (b.a()) {
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.b.b.b(this.a));
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.b.b.d(this.a), messageV3.getTitle());
            remoteViews.setLong(com.meizu.cloud.pushsdk.notification.b.b.f(this.a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            if (messageV3.getmNotificationStyle() != null && !TextUtils.isEmpty(messageV3.getmNotificationStyle().getExpandableText())) {
                remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.h(this.a), 0);
                remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.b.b.h(this.a), messageV3.getmNotificationStyle().getExpandableText());
            }
            notification.bigContentView = remoteViews;
        }
    }
}
