package com.meizu.cloud.pushsdk.handler.a.b;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.a;
import com.meizu.cloud.pushsdk.notification.e;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.c;

public class f extends a<UnRegisterStatus> {
    public int a() {
        return 1024;
    }

    public f(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public UnRegisterStatus c(Intent intent) {
        UnRegisterStatus unRegisterStatus = (UnRegisterStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_UNREGISTER_STATUS);
        if (unRegisterStatus.isUnRegisterSuccess()) {
            c.a(c(), "");
        }
        return unRegisterStatus;
    }

    /* access modifiers changed from: protected */
    public void a(UnRegisterStatus unRegisterStatus, e eVar) {
        if (b() != null && unRegisterStatus != null) {
            b().a(c(), unRegisterStatus);
        }
    }

    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start UnRegisterStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_UNREGISTER_STATUS.equals(i(intent));
    }
}
