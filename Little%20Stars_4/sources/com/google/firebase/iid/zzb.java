package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
    private int zzaSJ;
    private int zzaSK = 0;
    MessengerCompat zzaUg = new MessengerCompat((Handler) new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int zzc = MessengerCompat.zzc(message);
            zzf.zzaX(zzb.this);
            zzb.this.getPackageManager();
            if (zzc == zzf.zzaUs || zzc == zzf.zzaUr) {
                zzb.this.zzm((Intent) message.obj);
                return;
            }
            int i = zzf.zzaUr;
            int i2 = zzf.zzaUs;
            StringBuilder sb = new StringBuilder(77);
            sb.append("Message from unexpected caller ");
            sb.append(zzc);
            sb.append(" mine=");
            sb.append(i);
            sb.append(" appid=");
            sb.append(i2);
            Log.w("FirebaseInstanceId", sb.toString());
        }
    });
    final ExecutorService zzbqx = Executors.newSingleThreadExecutor();
    private final Object zzpp = new Object();

    public final IBinder onBind(Intent intent) {
        if (intent == null || !"com.google.firebase.INSTANCE_ID_EVENT".equals(intent.getAction())) {
            return null;
        }
        return this.zzaUg.getBinder();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        String str;
        synchronized (this.zzpp) {
            this.zzaSJ = i2;
            this.zzaSK++;
        }
        Intent zzz = zzz(intent);
        if (zzz == null) {
            zzBL();
            return 2;
        }
        try {
            return zzA(zzz);
        } finally {
            str = "from";
            if (zzz.getStringExtra(str) != null) {
                WakefulBroadcastReceiver.completeWakefulIntent(zzz);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int zzA(final Intent intent) {
        this.zzbqx.execute(new Runnable() {
            public void run() {
                zzb.this.zzm(intent);
                zzb.this.zzBL();
            }
        });
        return 3;
    }

    /* access modifiers changed from: protected */
    public void zzBL() {
        synchronized (this.zzpp) {
            this.zzaSK--;
            if (this.zzaSK == 0) {
                zzhE(this.zzaSJ);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzhE(int i) {
        return stopSelfResult(i);
    }

    public abstract void zzm(Intent intent);

    /* access modifiers changed from: protected */
    public abstract Intent zzz(Intent intent);
}
