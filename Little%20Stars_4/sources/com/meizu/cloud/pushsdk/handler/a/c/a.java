package com.meizu.cloud.pushsdk.handler.a.c;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.a.c;
import com.meizu.cloud.pushsdk.notification.e;
import com.meizu.cloud.pushsdk.util.d;

public class a extends c {
    public int a() {
        return 8192;
    }

    /* access modifiers changed from: protected */
    public int d(MessageV3 messageV3) {
        return 0;
    }

    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public MessageV3 c(Intent intent) {
        return (MessageV3) intent.getParcelableExtra(PushConstants.EXTRA_APP_PUSH_SCHEDULE_NOTIFICATION_MESSAGE);
    }

    /* access modifiers changed from: protected */
    public void a(MessageV3 messageV3, e eVar) {
        if (eVar != null) {
            eVar.c(messageV3);
        }
    }

    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start ScheduleNotificationHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SCHEDULE_NOTIFICATION.equals(i(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void b(MessageV3 messageV3) {
        DebugLogger.e("AbstractMessageHandler", "ScheduleNotificationHandler dont repeat upload receiver push event");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void c(MessageV3 messageV3) {
        d.a(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }
}
