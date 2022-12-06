package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ad;

public class PkgUninstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Uri data;
        if (intent != null && "android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()) && (data = intent.getData()) != null) {
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.setAction(ad.a);
                intent2.putExtra("uninstall_pkg_name", data.getEncodedSchemeSpecificPart());
                context.startService(intent2);
            } catch (Exception e) {
                b.a((Throwable) e);
            }
        }
    }
}
