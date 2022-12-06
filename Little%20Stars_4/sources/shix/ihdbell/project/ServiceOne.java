package shix.ihdbell.project;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class ServiceOne extends Service {
    public static final String TAG = "com.example.servicedemo.ServiceOne";
    Thread thread = new Thread(new Runnable() {
        public void run() {
            new Timer().schedule(new TimerTask() {
                public void run() {
                }
            }, 1000, 1000);
        }
    });

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.e(TAG, "ServiceOne----onStartCommand");
        this.thread.start();
        return 1;
    }

    public void onDestroy() {
        Log.e("test", "zhaogenghuai---1 onDestroy");
        super.onDestroy();
    }
}
