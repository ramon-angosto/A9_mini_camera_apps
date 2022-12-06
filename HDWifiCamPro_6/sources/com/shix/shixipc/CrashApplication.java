package com.shix.shixipc;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.shix.shixipc.utils.CommonAppUtil;
import com.shix.shixipc.utils.CommonUtil;
import com.unad.sdk.UNAD;
import com.unad.sdk.dto.AdError;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CrashApplication extends Application {
    private static final String APP_ID = "2882303761518409548";
    private static final String APP_KEY = "5791840937548";
    private static final String APP_Secret = "kLM7yeKwGfz1+KVjbT32SQ==";
    public static final String TAG = "com.shix.qhipc";
    private static CrashApplication app;
    private static Context context;
    public boolean isRun = false;
    private String jsonStrApp;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (CommonAppUtil.APP_isOpenAd() != 0) {
                try {
                    String access$000 = CrashApplication.this.getProcessName1(CrashApplication.this);
                    if (access$000 != null && access$000.equalsIgnoreCase(CrashApplication.this.getPackageName())) {
                        UNAD.initialize("Adgo-app-6643382167", CrashApplication.this.getApplicationContext(), new UNAD.InitCallback() {
                            public void onSuccess() {
                                Log.i("com.shix.qhipc", "onSuccess");
                            }

                            public void onError(AdError adError) {
                                Log.i("com.shix.qhipc", "error:" + adError.getMessage());
                            }
                        });
                    }
                } catch (Exception unused) {
                }
            }
        }
    };
    Runnable networkTaskApp = new Runnable() {
        public void run() {
            CommonUtil.LogAPP(2, "SHIXAPP networkTaskApp \n");
            try {
                CommonUtil.LogAPP(2, "SHIXAPP getJSONObjectApp \n");
                CrashApplication.this.getJSONObjectApp("https://cyappallgoogle.oss-eu-west-1.aliyuncs.com/hdwifi/app_hqls_google.txt");
            } catch (Exception e) {
                CommonUtil.LogAPP(2, "SHIXAPP Exception:" + e.getMessage().toString() + " \n");
                e.printStackTrace();
            }
        }
    };

    public static void reInitPush(Context context2) {
    }

    public void setRun(boolean z) {
        this.isRun = z;
    }

    public void onCreate() {
        super.onCreate();
        app = this;
        context = getApplicationContext();
        try {
            CommonUtil.LogAPP(2, "SHIXAPP startGetParms \n");
            new Thread(this.networkTaskApp).start();
        } catch (Exception unused) {
        }
        if (CommonAppUtil.APP_isOpenAd() == 0) {
            this.mHandler.sendEmptyMessageDelayed(1, 1000);
        } else {
            this.mHandler.sendEmptyMessageDelayed(1, 1);
        }
    }

    /* access modifiers changed from: private */
    public String getProcessName1(Context context2) {
        if (context2 == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context2.getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == Process.myPid()) {
                return next.processName;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context2) {
        super.attachBaseContext(context2);
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

    public void getJSONObjectApp(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        if (httpURLConnection.getResponseCode() == 200) {
            this.jsonStrApp = new String(readStream(httpURLConnection.getInputStream()));
            CommonUtil.Log(1, "getJSONObject jsonStrApp:" + this.jsonStrApp);
            String str2 = this.jsonStrApp;
            if (str2 != null) {
                CommonAppUtil.SaveAppJspn(str2);
            }
        }
    }

    public static byte[] readStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
