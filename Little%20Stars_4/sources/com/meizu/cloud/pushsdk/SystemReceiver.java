package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.common.base.WorkReceiver;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.a.b;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.d;

public class SystemReceiver extends WorkReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
        } catch (Exception e) {
            DebugLogger.e("SystemReceiver", "Event core error " + e.getMessage());
            String packageName = context.getPackageName();
            d.a(context, packageName, (String) null, (String) null, "3.3.170110", "SystemReceiver " + e.getMessage(), 3000);
        }
    }

    public void onHandleIntent(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (!intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                    if (!"com.meizu.cloud.pushservice.action.PUSH_SERVICE_START".equals(intent.getAction())) {
                        if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
                            String encodedSchemeSpecificPart = intent.getData().getEncodedSchemeSpecificPart();
                            DebugLogger.e("SystemReceiver", encodedSchemeSpecificPart + " has been uninstall");
                            if (!TextUtils.isEmpty(encodedSchemeSpecificPart) && !MzSystemUtils.b(context, encodedSchemeSpecificPart)) {
                                DebugLogger.e("SystemReceiver", context.getPackageName() + " SystemReceiver start unregister packageName " + encodedSchemeSpecificPart);
                                MzSystemUtils.a(context, encodedSchemeSpecificPart, true);
                                b.a(context).a(encodedSchemeSpecificPart);
                                return;
                            }
                            return;
                        } else if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                            String encodedSchemeSpecificPart2 = intent.getData().getEncodedSchemeSpecificPart();
                            DebugLogger.e("SystemReceiver", encodedSchemeSpecificPart2 + " has been install");
                            MzSystemUtils.a(context, encodedSchemeSpecificPart2, false);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                a(context);
            } catch (Exception e) {
                DebugLogger.e("SystemReceiver", "onHandleIntent Exception " + e.getMessage());
            }
        }
    }

    public void a(Context context, Intent intent) {
        try {
            context.startService(intent);
        } catch (SecurityException e) {
            DebugLogger.e("SystemReceiver", "start service error " + e.getMessage());
        }
    }

    public void a(Context context) {
        String a = MzSystemUtils.a(context, "com.meizu.cloud");
        DebugLogger.i("SystemReceiver", context.getPackageName() + " start register cloudVersion_name " + a);
        Intent intent = new Intent();
        if ("com.meizu.cloud".equals(MzSystemUtils.a(context))) {
            DebugLogger.e("SystemReceiver", "cloud pushService start");
            intent.setAction("com.meizu.pushservice.action.START");
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
        } else if (!TextUtils.isEmpty(a) && MzSystemUtils.a(a, "4.5.7")) {
            DebugLogger.e("SystemReceiver", "flyme 4.x start register cloud versionName " + a);
            intent.setPackage("com.meizu.cloud");
            intent.setAction(PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        } else if (TextUtils.isEmpty(a) || !a.startsWith("3")) {
            DebugLogger.e("SystemReceiver", context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.setAction("com.meizu.pushservice.action.START");
        } else {
            DebugLogger.e("SystemReceiver", "flyme 3.x start register cloud versionName " + a);
            intent.setAction(PushConstants.REQUEST_REGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
        }
        a(context, intent);
    }
}
