package com.shix.shixipc.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.shix.qhipc.R;

public class BridgeService extends Service {
    private String TAG = BridgeService.class.getSimpleName();
    private NotificationManager mCustomMgr;
    private Notification mNotify2;

    public IBinder onBind(Intent intent) {
        Log.d("tag", "BridgeService onBind()");
        return new ControllerBinder();
    }

    class ControllerBinder extends Binder {
        ControllerBinder() {
        }

        public BridgeService getBridgeService() {
            return BridgeService.this;
        }
    }

    public void onCreate() {
        super.onCreate();
        Log.d("tag", "BridgeService onCreate()");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT < 26) {
            stopForeground(true);
            this.mCustomMgr.cancel(R.mipmap.app);
        }
    }
}
