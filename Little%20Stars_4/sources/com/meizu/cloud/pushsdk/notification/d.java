package com.meizu.cloud.pushsdk.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout;
import com.meizu.cloud.pushsdk.util.b;

public class d extends f {
    public d(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void b(Notification notification, MessageV3 messageV3) {
        if (b.a()) {
            Bitmap a = a(messageV3.getmNotificationStyle().getBannerImageUrl());
            if (!a() && a != null) {
                RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.b.b.c(this.a));
                remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.b.b.i(this.a), a);
                remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.j(this.a), 8);
                remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.i(this.a), 0);
                notification.contentView = remoteViews;
                if (messageV3.getmNotificationStyle().getInnerStyle() == InnerStyleLayout.EXPANDABLE_PIC.getCode()) {
                    Bitmap a2 = a(messageV3.getmNotificationStyle().getExpandableImageUrl());
                    if (!a() && a2 != null) {
                        RemoteViews remoteViews2 = new RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.b.b.c(this.a));
                        remoteViews2.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.b.b.j(this.a), a2);
                        remoteViews2.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.j(this.a), 0);
                        remoteViews2.setViewVisibility(com.meizu.cloud.pushsdk.notification.b.b.i(this.a), 8);
                        notification.bigContentView = remoteViews2;
                    }
                }
            }
        }
    }
}
