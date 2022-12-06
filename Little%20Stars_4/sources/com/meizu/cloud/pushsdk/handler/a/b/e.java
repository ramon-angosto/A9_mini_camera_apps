package com.meizu.cloud.pushsdk.handler.a.b;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.a;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;

public class e extends a<SubTagsStatus> {
    public int a() {
        return 2048;
    }

    public e(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public SubTagsStatus c(Intent intent) {
        return (SubTagsStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS);
    }

    /* access modifiers changed from: protected */
    public void a(SubTagsStatus subTagsStatus, com.meizu.cloud.pushsdk.notification.e eVar) {
        if (b() != null && subTagsStatus != null) {
            b().a(c(), subTagsStatus);
        }
    }

    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start SubScribeTagsStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS.equals(i(intent));
    }
}
