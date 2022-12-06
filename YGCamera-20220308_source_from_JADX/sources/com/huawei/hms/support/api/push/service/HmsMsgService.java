package com.huawei.hms.support.api.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.push.C0873c;
import com.huawei.hms.push.C0879i;
import com.huawei.hms.push.C0890t;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

public class HmsMsgService extends Service {

    /* renamed from: com.huawei.hms.support.api.push.service.HmsMsgService$a */
    private static class C0914a extends Handler {

        /* renamed from: a */
        public Context f978a;

        public C0914a(Context context) {
            this.f978a = context;
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            if (Build.VERSION.SDK_INT >= 21) {
                if (Objects.equals(this.f978a.getApplicationContext().getPackageManager().getNameForUid(message.sendingUid), HMSPackageManager.getInstance(this.f978a).getHMSPackageName()) && data != null) {
                    if (HMSPackageManager.getInstance(this.f978a).getHMSPackageStates() != PackageManagerHelper.PackageStates.ENABLED) {
                        HMSLog.m1379i("HmsMsgService", "service not start by hms");
                    } else {
                        HMSLog.m1379i("HmsMsgService", "chose push type");
                        if (Objects.equals(C0873c.m1217b(data, "push_action"), "com.huawei.push.msg.NOTIFY_MSG")) {
                            if (ResourceLoaderUtil.getmContext() == null) {
                                ResourceLoaderUtil.setmContext(this.f978a.getApplicationContext());
                            }
                            HMSLog.m1379i("HmsMsgService", "invokeSelfShow");
                            HmsMsgService.m1364c(this.f978a, data);
                        } else if (Objects.equals(C0873c.m1217b(data, "push_action"), "com.huawei.push.msg.PASSBY_MSG")) {
                            HMSLog.m1379i("HmsMsgService", "sendBroadcastToHms");
                            HmsMsgService.m1365d(this.f978a, data);
                        }
                    }
                }
                super.handleMessage(message);
            }
        }
    }

    /* renamed from: c */
    public static void m1364c(Context context, Bundle bundle) {
        if (!C0890t.m1323a(context)) {
            HMSLog.m1379i("HmsMsgService", context.getPackageName() + " disable display notification.");
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", C0873c.m1216a(bundle, "selfshow_info"));
        intent.putExtra("selfshow_token", C0873c.m1216a(bundle, "selfshow_token"));
        intent.setPackage(C0873c.m1218c(bundle, "push_package"));
        C0879i.m1226a(context, intent);
        HMSLog.m1379i("HmsMsgService", "invokeSelfShow done");
    }

    /* renamed from: d */
    public static void m1365d(Context context, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.push.intent.RECEIVE");
            intent.putExtra("msg_data", C0873c.m1216a(bundle, "msg_data"));
            intent.putExtra(RemoteMessageConst.DEVICE_TOKEN, C0873c.m1216a(bundle, RemoteMessageConst.DEVICE_TOKEN));
            intent.putExtra("msgIdStr", C0873c.m1218c(bundle, "msgIdStr"));
            intent.setFlags(32);
            intent.setPackage(C0873c.m1218c(bundle, "push_package"));
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".permission.PROCESS_PUSH_MSG");
            context.sendBroadcast(intent, sb.toString());
            HMSLog.m1379i("HmsMsgService", "send broadcast passby done");
        } catch (SecurityException unused) {
            HMSLog.m1379i("HmsMsgService", "send broadcast SecurityException");
        } catch (Exception unused2) {
            HMSLog.m1379i("HmsMsgService", "send broadcast Exception");
        }
    }

    public IBinder onBind(Intent intent) {
        HMSLog.m1379i("HmsMsgService", "onBind");
        Messenger messenger = new Messenger(new C0914a(this));
        stopService(intent);
        return messenger.getBinder();
    }

    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        HMSLog.m1379i("HmsMsgService", "Enter onStartCommand.");
        if (Build.VERSION.SDK_INT < 26) {
            return 2;
        }
        NotificationChannel notificationChannel = new NotificationChannel("HwPushChannelID", "pushKit", 3);
        notificationChannel.enableVibration(false);
        NotificationManager notificationManager = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Notification.Builder builder = new Notification.Builder(this, "HwPushChannelID");
        builder.setAutoCancel(true);
        startForeground(1, builder.build());
        return 2;
    }
}
