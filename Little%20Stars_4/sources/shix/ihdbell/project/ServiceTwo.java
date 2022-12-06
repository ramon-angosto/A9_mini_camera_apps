package shix.ihdbell.project;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import com.jxl.app.littlestars.project.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;

public class ServiceTwo extends Service {
    public static final String TAG = "com.example.servicedemo.ServiceTwo";
    private NotificationManager mCustomMgr;
    private Notification mNotify2;
    /* access modifiers changed from: private */
    public SharedPreferences preAudio;
    private DeamonReceiver receiver = null;
    Thread thread = new Thread(new Runnable() {
        public void run() {
            new Timer().schedule(new TimerTask() {
                public void run() {
                    CommonUtil.Log(1, "zhaogeng----ServiceTwo-check  SystemValue.isDeamon:" + SystemValue.isDeamon);
                    if (SystemValue.isDeamon == 1 && !IpcamClientActivity.isServiceWorked(ServiceTwo.this, "com.zhao.damon.ServiceOne") && ServiceTwo.this.checkPackage("com.zhao.damon")) {
                        Log.e(ServiceTwo.TAG, "zhaogenghuai------------Start com.zhao.damon.ServiceOne");
                        Intent intent = new Intent();
                        intent.setAction("com.zhao.damon.ServiceOne");
                        Intent intent2 = new Intent(ServiceTwo.getExplicitIntent(ServiceTwo.this, intent));
                        intent2.putExtra("test", 1);
                        ServiceTwo.this.startService(intent2);
                    }
                }
            }, 0, 15);
        }
    });

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static Intent getExplicitIntent(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    public void onCreate() {
        super.onCreate();
        this.preAudio = getSharedPreferences("shix_zhao_audio", 0);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.e(TAG, "ServiceTwo---onStartCommand");
        SystemValue.isDeamon = intent.getIntExtra("test", 0);
        if (this.receiver == null) {
            this.receiver = new DeamonReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.zhao.damon.receiver");
            registerReceiver(this.receiver, intentFilter);
        }
        CommonUtil.Log(1, "zhaogeng----ServiceTwo-check  SystemValue.isDeamon:" + SystemValue.isDeamon);
        new Thread() {
            public void run() {
                while (SystemValue.isDeamon == 1) {
                    CommonUtil.Log(1, "zhaogeng----ServiceTwo-check  SystemValue.isDeamon:" + SystemValue.isDeamon);
                    if (SystemValue.isDeamon == 1 && !IpcamClientActivity.isServiceWorked(ServiceTwo.this, "com.zhao.damon.ServiceOne") && ServiceTwo.this.checkPackage("com.zhao.damon")) {
                        Log.e(ServiceTwo.TAG, "zhaogenghuai------------Start com.zhao.damon.ServiceOne");
                        Intent intent = new Intent();
                        intent.setAction("com.zhao.damon.ServiceOne");
                        Intent intent2 = new Intent(ServiceTwo.getExplicitIntent(ServiceTwo.this, intent));
                        intent2.putExtra("test", 1);
                        ServiceTwo.this.startService(intent2);
                    }
                }
            }
        }.start();
        return 3;
    }

    public boolean checkPackage(String str) {
        if (str != null && !"".equals(str)) {
            try {
                getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    private Notification getNotification(String str, String str2, boolean z) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String string = getResources().getString(R.string.app_name);
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClass(this, IpcamClientActivity.class);
        Log.e("ServiceTwo", "#### notification start");
        this.mNotify2 = new Notification(R.drawable.app, getResources().getString(R.string.app_name) + " " + str, System.currentTimeMillis());
        this.mNotify2.flags = 2;
        PendingIntent activity = PendingIntent.getActivity(this, R.drawable.app, intent, 134217728);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_layout);
        Notification notification = this.mNotify2;
        notification.contentIntent = activity;
        notification.contentView = remoteViews;
        notification.contentView.setTextViewText(R.id.no_title, string);
        this.mNotify2.contentView.setTextViewText(R.id.no_content, str);
        this.mNotify2.contentView.setTextViewText(R.id.no_time, format);
        this.mNotify2.contentView.setImageViewResource(R.id.no_img, R.drawable.app);
        return this.mNotify2;
    }

    public void onDestroy() {
        Log.e("test", "zhaogenghuai---2 onDestroy");
        DeamonReceiver deamonReceiver = this.receiver;
        if (deamonReceiver != null) {
            unregisterReceiver(deamonReceiver);
        }
        super.onDestroy();
    }

    class DeamonReceiver extends BroadcastReceiver {
        DeamonReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            CommonUtil.Log(1, "zhaogenghuai ===DeamonReceiver :" + action + " type:" + intent.getIntExtra("deamontype", 0));
            SystemValue.isDeamon = intent.getIntExtra("deamontype", 0);
            SharedPreferences.Editor edit = ServiceTwo.this.preAudio.edit();
            edit.putInt("deamontype", SystemValue.isDeamon);
            edit.commit();
        }
    }
}
