package com.shix.shixipc;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.multidex.MultiDex;
import com.shix.shixipc.utils.CommonUtil;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;

public class CrashApplication extends Application {
    private static final String APP_ID = "2882303761519862638";
    private static final String APP_KEY = "5401986213638";
    private static final String APP_Secret = "BISeZ1h8085fDz5Lsc+0Ew==";
    public static final String TAG = "shix.cykj.camera";
    private static CrashApplication app;
    private static Context context;

    public void onCreate() {
        super.onCreate();
        app = this;
        context = getApplicationContext();
        if (shouldInit()) {
            MiPushClient.registerPush(this, "2882303761519862638", "5401986213638");
            CommonUtil.Log(1, "小米推送 注册");
        } else {
            CommonUtil.Log(1, "小米推送 no 注册");
        }
        Logger.setLogger(this, new LoggerInterface() {
            public void setTag(String str) {
            }

            public void log(String str, Throwable th) {
                Log.d("shix.cykj.camera", str, th);
            }

            public void log(String str) {
                Log.d("shix.cykj.camera", str);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context2) {
        super.attachBaseContext(context2);
        MultiDex.install(context2);
    }

    public static synchronized Context getContext() {
        Context context2;
        synchronized (CrashApplication.class) {
            context2 = context;
        }
        return context2;
    }

    public static synchronized CrashApplication getInstance() {
        CrashApplication crashApplication;
        synchronized (CrashApplication.class) {
            crashApplication = app;
        }
        return crashApplication;
    }

    private boolean shouldInit() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
        String packageName = getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid && packageName.equals(next.processName)) {
                return true;
            }
        }
        return false;
    }

    public static void reInitPush(Context context2) {
        MiPushClient.registerPush(context2.getApplicationContext(), "2882303761519862638", "5401986213638");
    }
}
