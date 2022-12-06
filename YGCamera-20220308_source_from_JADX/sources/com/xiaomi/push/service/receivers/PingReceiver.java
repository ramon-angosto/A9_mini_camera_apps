package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1783fa;
import com.xiaomi.push.service.C2014bd;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.service.XMPushService;

public class PingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C1524b.m2159c(intent.getPackage() + " is the package name");
        if (!C2014bd.f3796o.equals(intent.getAction())) {
            C1524b.m2141a("cancel the old ping timer");
            C1783fa.m3471a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            C1524b.m2159c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                ServiceClient.getInstance(context).startServiceSafely(intent2);
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
            }
        }
    }
}
