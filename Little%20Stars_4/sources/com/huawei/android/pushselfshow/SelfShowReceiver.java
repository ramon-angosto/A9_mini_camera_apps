package com.huawei.android.pushselfshow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.c.d;
import com.huawei.android.pushselfshow.permission.RequestPermissionsActivity;
import com.huawei.android.pushselfshow.utils.b.b;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;

public class SelfShowReceiver {

    static class a extends Thread {
        Context a;
        String b;

        public a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        public void run() {
            ArrayList a2 = com.huawei.android.pushselfshow.utils.a.a.a(this.a, this.b);
            int size = a2.size();
            e.e("PushSelfShowLog", "receive package add ,arrSize " + size);
            for (int i = 0; i < size; i++) {
                com.huawei.android.pushselfshow.utils.a.a(this.a, "16", (String) a2.get(i), PushConstants.EXTRA_APPLICATION_PENDING_INTENT);
            }
            if (size > 0) {
                com.huawei.android.pushselfshow.utils.a.a.b(this.a, this.b);
            }
            com.huawei.android.pushselfshow.utils.a.b(new File(b.a(this.a)));
        }
    }

    public void a(Context context, Intent intent, com.huawei.android.pushselfshow.b.a aVar) {
        e.a("PushSelfShowLog", "receive a selfshow message ,the type is" + aVar.o);
        if (!com.huawei.android.pushselfshow.a.a.a(aVar.o)) {
            com.huawei.android.pushselfshow.utils.a.a(context, "3", aVar);
            return;
        }
        long b = com.huawei.android.pushselfshow.utils.a.b(aVar.k);
        if (b == 0) {
            new d(context, aVar).start();
            return;
        }
        e.a("PushSelfShowLog", "waiting ……");
        intent.setPackage(context.getPackageName());
        com.huawei.android.pushselfshow.utils.a.a(context, intent, b);
    }

    public void a(Context context, Intent intent, String str, com.huawei.android.pushselfshow.b.a aVar, int i) {
        e.a("PushSelfShowLog", "receive a selfshow userhandle message");
        if (!"-1".equals(str)) {
            com.huawei.android.pushselfshow.c.b.a(context, intent);
        } else {
            com.huawei.android.pushselfshow.c.b.a(context, i);
        }
        if ("1".equals(str)) {
            new com.huawei.android.pushselfshow.a.a(context, aVar).a();
            if (aVar.n != null) {
                try {
                    JSONArray jSONArray = new JSONArray(aVar.n);
                    Intent intent2 = new Intent("com.huawei.android.push.intent.CLICK");
                    intent2.putExtra("click", jSONArray.toString()).setPackage(context.getPackageName()).setFlags(32);
                    context.sendBroadcast(intent2);
                } catch (Exception e) {
                    e.d("PushSelfShowLog", "message.extras is not a json format,err info " + e.toString());
                }
            }
        }
        com.huawei.android.pushselfshow.utils.a.a(context, str, aVar);
    }

    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            e.a("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
            return;
        }
        try {
            e.a(context);
            String action = intent.getAction();
            if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                Uri data = intent.getData();
                if (data != null) {
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    e.e("PushSelfShowLog", "receive package add ,the pkgName is " + schemeSpecificPart);
                    if (!TextUtils.isEmpty(schemeSpecificPart)) {
                        new a(context, schemeSpecificPart).start();
                    }
                }
            } else if (!"com.huawei.intent.action.PUSH".equals(action)) {
            } else {
                if (RequestPermissionsActivity.a(context)) {
                    e.b("PushSelfShowLog", "needStartPermissionActivity");
                    RequestPermissionsActivity.a(context, intent);
                    return;
                }
                String str = null;
                if (intent.hasExtra("selfshow_info")) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                    if (intent.hasExtra("selfshow_token")) {
                        byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                        if (intent.hasExtra("selfshow_event_id")) {
                            str = intent.getStringExtra("selfshow_event_id");
                        }
                        String str2 = str;
                        int intExtra = intent.hasExtra("selfshow_notify_id") ? intent.getIntExtra("selfshow_notify_id", 0) : 0;
                        com.huawei.android.pushselfshow.b.a aVar = new com.huawei.android.pushselfshow.b.a(byteArrayExtra, byteArrayExtra2);
                        if (!aVar.b()) {
                            e.a("PushSelfShowLog", "parseMessage failed");
                            return;
                        }
                        e.a("PushSelfShowLog", " onReceive the msg id = " + aVar.l + ",and cmd is" + aVar.o + ",and the eventId is " + str2);
                        if (str2 == null) {
                            a(context, intent, aVar);
                        } else {
                            a(context, intent, str2, aVar, intExtra);
                        }
                        com.huawei.android.pushselfshow.utils.a.b(new File(b.a(context)));
                    }
                }
            }
        } catch (Exception e) {
            e.a("PushSelfShowLog", e.toString(), (Throwable) e);
        }
    }
}
