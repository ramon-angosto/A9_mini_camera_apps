package com.meizu.cloud.pushsdk.notification;

import android.app.Notification;
import android.content.Context;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.util.b;

public class g extends a {
    public g(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void a(Notification.Builder builder, MessageV3 messageV3) {
        if (b.a()) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(messageV3.getTitle());
            bigTextStyle.setSummaryText(messageV3.getContent());
            bigTextStyle.bigText(messageV3.getContent());
            builder.setStyle(bigTextStyle);
        }
    }
}
