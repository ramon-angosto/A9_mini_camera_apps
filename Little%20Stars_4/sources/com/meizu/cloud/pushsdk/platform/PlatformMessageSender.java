package com.meizu.cloud.pushsdk.platform;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.List;

public class PlatformMessageSender {

    private interface a {
        String a();

        BasicPushStatus b();

        String c();
    }

    public static void a(Context context, final PushSwitchStatus pushSwitchStatus) {
        a(context, (a) new a() {
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS;
            }

            public String c() {
                return PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS;
            }

            public BasicPushStatus b() {
                return pushSwitchStatus;
            }
        });
    }

    public static void a(Context context, final RegisterStatus registerStatus) {
        a(context, (a) new a() {
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS;
            }

            public String c() {
                return PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS;
            }

            public BasicPushStatus b() {
                return registerStatus;
            }
        });
    }

    public static void a(Context context, final UnRegisterStatus unRegisterStatus) {
        a(context, (a) new a() {
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_UNREGISTER_STATUS;
            }

            public String c() {
                return PushConstants.EXTRA_APP_PUSH_UNREGISTER_STATUS;
            }

            public BasicPushStatus b() {
                return unRegisterStatus;
            }
        });
    }

    public static void a(Context context, final SubTagsStatus subTagsStatus) {
        a(context, (a) new a() {
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS;
            }

            public String c() {
                return PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS;
            }

            public BasicPushStatus b() {
                return subTagsStatus;
            }
        });
    }

    public static void a(Context context, final SubAliasStatus subAliasStatus) {
        a(context, (a) new a() {
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS;
            }

            public String c() {
                return PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS;
            }

            public BasicPushStatus b() {
                return subAliasStatus;
            }
        });
    }

    private static void a(Context context, a aVar) {
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.addCategory(packageName);
        intent.setPackage(packageName);
        intent.putExtra("method", aVar.a());
        intent.putExtra(aVar.c(), aVar.b());
        a(context, intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, context.getPackageName());
        a(context, new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START"), (String) null, context.getPackageName());
    }

    public static void a(Context context, int i, boolean z, String str) {
        String a2 = MzSystemUtils.a(context, "com.meizu.cloud");
        DebugLogger.i("PlatformMessageSender", context.getPackageName() + " switchPushMessageSetting cloudVersion_name " + a2);
        if (!TextUtils.isEmpty(a2) && a2.startsWith("6")) {
            Intent intent = new Intent(PushConstants.MZ_PUSH_ON_MESSAGE_SWITCH_SETTING);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_TYPE, i);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_STATUS, z);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_PACKAGE_NAME, str);
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            context.startService(intent);
        }
    }

    public static void launchStartActivity(Context context, String str, String str2, String str3) {
        MessageV3 parse = MessageV3.parse("", str, "", str3);
        parse.setUploadDataPackageName(str2);
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, parse);
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
            intent.setClassName(str2, "com.meizu.cloud.pushsdk.NotificationService");
        }
        intent.putExtra("command_type", "reflect_receiver");
        DebugLogger.i("PlatformMessageSender", "start notification service " + parse);
        try {
            context.startService(intent);
        } catch (Exception e) {
            DebugLogger.e("PlatformMessageSender", "launchStartActivity error " + e.getMessage());
        }
    }

    public static void a(Context context, Intent intent, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        String a2 = a(context, str, str2);
        if (!TextUtils.isEmpty(a2)) {
            intent.setClassName(str2, a2);
        }
        context.sendBroadcast(intent);
    }

    private static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return queryBroadcastReceivers.get(0).activityInfo.name;
            }
        }
        return null;
    }
}
