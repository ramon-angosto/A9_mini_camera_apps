package com.huawei.android.pushagent;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.PowerManager;
import com.huawei.android.pushagent.b.a;
import com.huawei.android.pushagent.c.a.e;

public class b extends Thread {
    public Handler a;
    private MessageQueue b;
    /* access modifiers changed from: private */
    public PowerManager.WakeLock c = ((PowerManager) this.d.getSystemService("power")).newWakeLock(1, "eventLooper");
    /* access modifiers changed from: private */
    public Context d;

    final class a implements Runnable {
        private com.huawei.android.pushagent.b.a b;
        private Intent c;

        public a(com.huawei.android.pushagent.b.a aVar, Intent intent) {
            this.b = aVar;
            this.c = intent;
        }

        public void run() {
            try {
                this.b.a(b.this.d, this.c);
            } catch (Exception e) {
                e.c("PushLogAC2705", "ReceiverDispatcher: call Receiver:" + this.b.getClass().getSimpleName() + ", intent:" + this.c + " failed:" + e.toString(), e);
            }
        }
    }

    public b(Context context) {
        super("ReceiverDispatcher");
        this.d = context;
    }

    public void a(a aVar, Intent intent) {
        if (this.a == null) {
            e.d("PushLogAC2705", "ReceiverDispatcher: the handler is null");
            PushService.a().stopService();
            return;
        }
        try {
            if (!this.c.isHeld()) {
                this.c.acquire();
            }
            if (!this.a.postDelayed(new a(aVar, intent), 1)) {
                e.c("PushLogAC2705", "postDelayed runnable error");
                throw new Exception("postDelayed runnable error");
            }
        } catch (Exception e) {
            try {
                e.c("PushLogAC2705", "dispatchIntent error", e);
                if (this.c.isHeld()) {
                    e.b("PushLogAC2705", "release wakelock after dispatchIntent error");
                    this.c.release();
                }
            } catch (Exception e2) {
                e.c("PushLogAC2705", "release eventLooper wakelock error", e2);
            }
        }
    }

    public void run() {
        try {
            Looper.prepare();
            this.a = new Handler();
            this.b = Looper.myQueue();
            this.b.addIdleHandler(new c(this));
            Looper.loop();
            PowerManager.WakeLock wakeLock = this.c;
            if (wakeLock == null || !wakeLock.isHeld()) {
                return;
            }
        } catch (Throwable th) {
            PowerManager.WakeLock wakeLock2 = this.c;
            if (wakeLock2 != null && wakeLock2.isHeld()) {
                this.c.release();
            }
            throw th;
        }
        this.c.release();
    }
}
