package com.meizu.cloud.pushsdk.handler.a.b;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.e;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;

public class a extends com.meizu.cloud.pushsdk.handler.a.a<PushSwitchStatus> {
    public int a() {
        return 256;
    }

    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public PushSwitchStatus c(Intent intent) {
        return (PushSwitchStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS);
    }

    /* access modifiers changed from: protected */
    public void a(PushSwitchStatus pushSwitchStatus, e eVar) {
        if (b() != null && pushSwitchStatus != null) {
            b().a(c(), pushSwitchStatus);
        }
    }

    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start PushSwitchStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS.equals(i(intent));
    }
}
