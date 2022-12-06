package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a;
import com.meizu.cloud.pushsdk.notification.e;
import com.meizu.cloud.pushsdk.util.c;

public class d extends a<String> {
    public int a() {
        return 16;
    }

    public d(Context context, a aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String c(Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        c.a(c(), stringExtra);
        return stringExtra;
    }

    /* access modifiers changed from: protected */
    public void a(String str, e eVar) {
        if (b() != null) {
            b().a(c(), str);
        }
    }

    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start RegisterMessageHandler match");
        return PushConstants.MZ_PUSH_ON_REGISTER_ACTION.equals(intent.getAction()) || (PushConstants.REGISTRATION_CALLBACK_INTENT.equals(intent.getAction()) && !TextUtils.isEmpty(intent.getStringExtra("registration_id")));
    }
}
