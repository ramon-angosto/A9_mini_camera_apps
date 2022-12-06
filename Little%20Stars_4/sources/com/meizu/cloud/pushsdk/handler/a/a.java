package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.c;
import com.meizu.cloud.pushsdk.notification.e;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a<T> implements c {
    private com.meizu.cloud.pushsdk.handler.a a;
    private Context b;
    private Map<Integer, String> c;

    /* access modifiers changed from: protected */
    public e a(T t) {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t, e eVar);

    /* access modifiers changed from: protected */
    public void b(T t) {
    }

    /* access modifiers changed from: protected */
    public abstract T c(Intent intent);

    /* access modifiers changed from: protected */
    public void c(T t) {
    }

    /* access modifiers changed from: protected */
    public int d(T t) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void e(T t) {
    }

    protected a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        if (context != null) {
            this.b = context.getApplicationContext();
            this.a = aVar;
            this.c = new HashMap();
            this.c.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
            this.c.put(4, "MESSAGE_TYPE_PUSH_SERVICE_V3");
            this.c.put(16, "MESSAGE_TYPE_REGISTER");
            this.c.put(32, "MESSAGE_TYPE_UNREGISTER");
            this.c.put(8, "MESSAGE_TYPE_THROUGH");
            this.c.put(64, "MESSAGE_TYPE_NOTIFICATION_CLICK");
            this.c.put(128, "MESSAGE_TYPE_NOTIFICATION_DELETE");
            this.c.put(256, "MESSAGE_TYPE_PUSH_SWITCH_STATUS");
            this.c.put(512, "MESSAGE_TYPE_PUSH_REGISTER_STATUS");
            this.c.put(2048, "MESSAGE_TYPE_PUSH_SUBTAGS_STATUS");
            this.c.put(1024, "MESSAGE_TYPE_PUSH_UNREGISTER_STATUS");
            this.c.put(4096, "MESSAGE_TYPE_PUSH_SUBALIAS_STATUS");
            this.c.put(8192, "MESSAGE_TYPE_SCHEDULE_NOTIFICATION");
            this.c.put(16384, "MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE");
            return;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    /* access modifiers changed from: protected */
    public String d(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY);
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        String c2 = com.meizu.cloud.pushsdk.util.c.c(c());
        if (!TextUtils.isEmpty(c2)) {
            return c2;
        }
        String b2 = MzSystemUtils.b(c());
        com.meizu.cloud.pushsdk.util.c.b(c(), b2);
        DebugLogger.e("AbstractMessageHandler", "force get deviceId " + b2);
        return b2;
    }

    /* access modifiers changed from: protected */
    public String e(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    /* access modifiers changed from: protected */
    public String f(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    /* access modifiers changed from: protected */
    public String g(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        return TextUtils.isEmpty(stringExtra) ? c().getPackageName() : stringExtra;
    }

    /* access modifiers changed from: protected */
    public String h(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        DebugLogger.e("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        return TextUtils.isEmpty(stringExtra) ? String.valueOf(System.currentTimeMillis() / 1000) : stringExtra;
    }

    public boolean b(Intent intent) {
        boolean z = false;
        if (a(intent)) {
            DebugLogger.e("AbstractMessageHandler", "current message Type " + a(a()));
            Object c2 = c(intent);
            DebugLogger.e("AbstractMessageHandler", "current Handler message " + c2);
            b(c2);
            int d = d(c2);
            boolean z2 = true;
            if (d != 0) {
                if (d == 1) {
                    DebugLogger.e("AbstractMessageHandler", "expire notification, dont show message");
                } else if (d == 2) {
                    DebugLogger.e("AbstractMessageHandler", "notification on time ,show message");
                } else if (d == 3) {
                    DebugLogger.e("AbstractMessageHandler", "schedule notification");
                    e(c2);
                    z = true;
                }
                z2 = false;
                if (z && z2) {
                    a(c2, a(c2));
                    c(c2);
                    DebugLogger.e("AbstractMessageHandler", "send message end ");
                }
            } else {
                DebugLogger.e("AbstractMessageHandler", "schedule send message off, send message directly");
            }
            z = true;
            a(c2, a(c2));
            c(c2);
            DebugLogger.e("AbstractMessageHandler", "send message end ");
        }
        return z;
    }

    public com.meizu.cloud.pushsdk.handler.a b() {
        return this.a;
    }

    public Context c() {
        return this.b;
    }

    public String i(Intent intent) {
        return intent.getStringExtra("method");
    }

    public boolean a(String str) {
        try {
            return c().getPackageName().equals(new JSONObject(str).getString("appId"));
        } catch (Exception unused) {
            DebugLogger.e("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    public String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            if (map != null) {
                str = map.get("sk");
                if (TextUtils.isEmpty(str)) {
                    str = com.meizu.cloud.pushsdk.b.f.e.a((Map) map).toString();
                }
            } else {
                str = null;
            }
        }
        DebugLogger.e("AbstractMessageHandler", "self json " + str);
        return str;
    }

    private String a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public boolean a(int i, String str) {
        boolean z = true;
        if (i == 0) {
            z = com.meizu.cloud.pushsdk.util.c.e(c(), str);
        } else if (i == 1) {
            z = com.meizu.cloud.pushsdk.util.c.f(c(), str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i == 0 ? " canNotificationMessage " : " canThroughMessage ");
        sb.append(z);
        DebugLogger.e("AbstractMessageHandler", sb.toString());
        return z;
    }
}
