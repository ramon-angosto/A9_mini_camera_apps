package com.huawei.android.pushagent.c.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import com.huawei.android.microkernel.MKService;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.f;
import com.huawei.android.pushagent.c.a.h;

public class b extends Thread {
    /* access modifiers changed from: private */
    public static b a = new b();
    private static long b = 0;
    private static Handler c = null;
    private static PowerManager.WakeLock d = null;
    private static boolean e = false;
    private static long f;

    static {
        a.start();
    }

    public static void a() {
        b = System.currentTimeMillis();
    }

    private static void a(Context context) {
        d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "pushagentPoxy");
    }

    public static void a(Context context, Intent intent) {
        String str;
        StringBuilder sb;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (d == null) {
                a(context);
            }
            int i = 0;
            while (c == null && i <= 60) {
                if (i % 20 == 0) {
                    e.a("PushLogAC2705", "when send msg handler is null, waitTimes:" + i);
                }
                i++;
                sleep(10);
            }
            if (d != null) {
                d.acquire(500);
            }
            if (c != null) {
                c.postDelayed(new c(context, intent), 1);
            }
        } catch (InterruptedException e2) {
            sb = new StringBuilder();
            sb.append("call handleEvent cause InterruptedException:");
            str = e2.toString();
            sb.append(str);
            e.d("PushLogAC2705", sb.toString());
            e.a("PushLogAC2705", "PushProxy cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms dealwith " + intent);
        } catch (Exception e3) {
            sb = new StringBuilder();
            sb.append("call handleEvent cause Exception:");
            str = e3.toString();
            sb.append(str);
            e.d("PushLogAC2705", sb.toString());
            e.a("PushLogAC2705", "PushProxy cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms dealwith " + intent);
        }
        e.a("PushLogAC2705", "PushProxy cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms dealwith " + intent);
    }

    private boolean a(Context context, String str) {
        int q = a.q(context);
        String r = a.r(context);
        if ("android.intent.action.PACKAGE_ADDED".equals(str) || "android.intent.action.PACKAGE_REMOVED".equals(str) || q == 0 || TextUtils.isEmpty(r)) {
            if (d.a(context)) {
                a.a(context, true);
                q = 1;
            } else {
                a.a(context, false);
                q = 2;
            }
            e.a("PushLogAC2705", "After voting, My service Stats = " + q);
            new h(context, "pushConfig").a("NeedMyServiceRun", Integer.valueOf(q));
        }
        return 1 == q;
    }

    /* access modifiers changed from: private */
    public void b(Context context, Intent intent) {
        if (intent != null) {
            if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
                c(context, intent);
            }
            com.huawei.android.pushagent.c.h.a(context);
            if (a(context, intent.getAction())) {
                e.a("PushLogAC2705", "my pkg " + context.getPackageName() + " need deal with:" + intent);
                if (!e(context, intent)) {
                    if (b(context)) {
                        e.a("PushLogAC2705", "enter checkBackUp()");
                        a();
                        a.f(context);
                        a.p(context);
                    }
                    d(context, intent);
                    return;
                }
                return;
            }
            e.a("PushLogAC2705", "need not current " + context.getPackageName() + " to depose, so exit receiver");
            a.a(context, 3);
            PushService.b();
        }
    }

    private boolean b(Context context) {
        return System.currentTimeMillis() < b || (com.huawei.android.pushagent.b.b.a.a(context).N() * 1000) + b < System.currentTimeMillis();
    }

    private static void c(Context context, Intent intent) {
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : "";
        String packageName = context.getPackageName();
        e.a("PushLogAC2705", "the Reinstall pkgName:" + schemeSpecificPart + ", current PkgName:" + packageName);
        if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(packageName)) {
            a.a(context, 1);
            boolean stopService = context.stopService(new Intent(context, PushService.class));
            e.a("PushLogAC2705", "after apk reinstalled , stop pushservice:" + String.valueOf(stopService));
        }
    }

    private void d(Context context, Intent intent) {
        Intent intent2;
        if (context != null && intent != null) {
            if (MKService.getAppContext() == null) {
                intent2 = new Intent(context, PushService.class);
            } else {
                intent2 = new Intent();
                e.a("PushLogAC2705", "MKService.getAppContext() is" + MKService.getAppContext());
                intent2.setComponent(new ComponentName(context, "com.huawei.deviceCloud.microKernel.push.PushMKService"));
            }
            intent2.fillIn(intent, 7);
            intent2.setPackage(context.getPackageName());
            e.a("PushLogAC2705", "serviceIntent is" + intent2.toURI());
            context.startService(intent2);
        }
    }

    private boolean e(Context context, Intent intent) {
        String str;
        e.a("PushLogAC2705", "enter needDelayIntent");
        if (!TextUtils.isEmpty(f.a(context, "device_info", "deviceId"))) {
            str = "local deviceId is not empty";
        } else {
            if (!e) {
                e = true;
                if (TextUtils.isEmpty(a.c(context))) {
                    e.a("PushLogAC2705", "first enter, imei is empty, begin to wait 1 minute");
                    f = System.currentTimeMillis();
                } else {
                    str = "first enter, imei is not empty, no deed to wait";
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis() - f;
                if (0 >= currentTimeMillis || currentTimeMillis > 60000) {
                    str = "second enter, no deed to wait";
                } else {
                    e.a("PushLogAC2705", "second enter, waitting 1 minute");
                }
            }
            intent.setPackage(context.getPackageName());
            com.huawei.android.pushagent.c.a.a.c(context, intent, 60000);
            return true;
        }
        e.a("PushLogAC2705", str);
        return false;
    }

    public void run() {
        Looper.prepare();
        if (c == null) {
            c = new Handler();
        }
        Looper.loop();
    }
}
