package com.meizu.cloud.pushsdk.handler;

import android.content.Context;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;

public interface b {
    void a(Context context, PushSwitchStatus pushSwitchStatus);

    void a(Context context, RegisterStatus registerStatus);

    void a(Context context, SubAliasStatus subAliasStatus);

    void a(Context context, SubTagsStatus subTagsStatus);

    void a(Context context, UnRegisterStatus unRegisterStatus);

    void a(Context context, String str);

    void a(Context context, String str, String str2, String str3);

    void a(Context context, boolean z);

    void a(PushNotificationBuilder pushNotificationBuilder);

    void b(Context context, String str);

    void b(Context context, String str, String str2, String str3);

    void c(Context context, String str);

    void c(Context context, String str, String str2, String str3);
}
