package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.C1559af;
import com.xiaomi.mipush.sdk.C1568ao;
import com.xiaomi.mipush.sdk.C1575au;
import com.xiaomi.mipush.sdk.C1578b;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.C1653bi;
import com.xiaomi.push.C1847gz;
import com.xiaomi.push.service.ServiceClient;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static int f3946a = 1;

    /* renamed from: a */
    private static BlockingQueue<Runnable> f3947a = new LinkedBlockingQueue();

    /* renamed from: a */
    private static ThreadPoolExecutor f3948a = new ThreadPoolExecutor(f3946a, f3950b, (long) f3951c, TimeUnit.SECONDS, f3947a);

    /* renamed from: a */
    private static boolean f3949a = false;

    /* renamed from: b */
    private static int f3950b = 1;

    /* renamed from: c */
    private static int f3951c = 2;

    /* renamed from: b */
    private boolean f3952b;

    public NetworkStatusReceiver() {
        this.f3952b = false;
        this.f3952b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f3952b = false;
        f3949a = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5330a(Context context) {
        if (!C1568ao.m2317a(context).mo17133a() && C1578b.m2373a(context).mo17173c() && !C1578b.m2373a(context).mo17176f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
            }
        }
        C1847gz.m3809a(context);
        if (C1653bi.m2685b(context) && C1568ao.m2317a(context).mo17153b()) {
            C1568ao.m2317a(context).mo17155c();
        }
        if (C1653bi.m2685b(context)) {
            if ("syncing".equals(C1559af.m2278a(context).mo17126a(C1575au.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(C1559af.m2278a(context).mo17126a(C1575au.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(C1559af.m2278a(context).mo17126a(C1575au.UPLOAD_HUAWEI_TOKEN))) {
                MiPushClient.syncAssemblePushToken(context);
            }
            if ("syncing".equals(C1559af.m2278a(context).mo17126a(C1575au.UPLOAD_FCM_TOKEN))) {
                MiPushClient.syncAssembleFCMPushToken(context);
            }
            if ("syncing".equals(C1559af.m2278a(context).mo17126a(C1575au.UPLOAD_COS_TOKEN))) {
                MiPushClient.syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(C1559af.m2278a(context).mo17126a(C1575au.UPLOAD_FTOS_TOKEN))) {
                MiPushClient.syncAssembleFTOSPushToken(context);
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }

    /* renamed from: a */
    public static boolean m5332a() {
        return f3949a;
    }

    public void onReceive(Context context, Intent intent) {
        if (!this.f3952b) {
            f3948a.execute(new C2077a(this, context));
        }
    }
}
