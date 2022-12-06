package com.huawei.android.pushagent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;
import com.huawei.android.microkernel.MKService;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.b.e.d;
import com.huawei.android.pushagent.b.f.b;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.g;
import java.util.Iterator;
import java.util.LinkedList;

public class PushService extends MKService {
    /* access modifiers changed from: private */
    public static String a = "PushLogAC2705";
    private static PushService d;
    private LinkedList b = new LinkedList();
    private b c;
    private a e = new a();
    private long f = 0;
    private boolean g = false;
    /* access modifiers changed from: private */
    public Context h = null;

    class a extends BroadcastReceiver {
        a() {
        }

        public void a() {
            com.huawei.android.pushagent.c.a.a.a(PushService.this.h, "com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT");
            com.huawei.android.pushagent.c.a.a.a(PushService.this.h, new Intent("com.huawei.intent.action.PUSH").putExtra("EXTRA_INTENT_TYPE", "com.huawei.android.push.intent.HEARTBEAT_REQ").putExtra("heartbeat_interval", 2592000000L).setPackage(PushService.this.h.getPackageName()));
        }

        public void a(Context context) {
            IntentFilter intentFilter = new IntentFilter();
            for (String addAction : g.a()) {
                intentFilter.addAction(addAction);
            }
            context.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            try {
                PushService.a(intent);
            } catch (Exception e) {
                String c = PushService.a;
                e.c(c, "call PushInnerReceiver:onReceive cause " + e.toString(), e);
            }
        }
    }

    public static synchronized PushService a() {
        PushService pushService;
        synchronized (PushService.class) {
            pushService = d;
        }
        return pushService;
    }

    public static void a(Intent intent) {
        try {
            PushService a2 = a();
            if (a2 == null) {
                e.d(a, "sendBroadcast error, pushService is null");
                return;
            }
            String str = a;
            e.a(str, "broadcast(),and mReceivers  " + d.b.size());
            a2.b(intent);
        } catch (Exception e2) {
            String str2 = a;
            e.c(str2, "call PushService:broadcast() cause " + e2.toString(), e2);
        }
    }

    private void a(com.huawei.android.pushagent.b.a aVar, IntentFilter intentFilter) {
        this.b.add(aVar);
    }

    public static void b() {
        PushService pushService = d;
        if (pushService != null) {
            pushService.g = true;
            pushService.stopService();
        }
    }

    private synchronized void b(Intent intent) {
        if (intent == null) {
            e.a(a, "when broadcastToProcess, intent is null");
            return;
        }
        String str = a;
        e.a(str, "broadcastToProcess, intent is:" + intent.getAction());
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            this.c.a((com.huawei.android.pushagent.b.a) it.next(), intent);
        }
    }

    private static synchronized void b(PushService pushService) {
        synchronized (PushService.class) {
            d = pushService;
        }
    }

    private void d() {
        try {
            String str = a;
            e.a(str, "initProcess(),and mReceivers  " + this.b.size());
            a(new com.huawei.android.pushagent.b.c.a(this.h), (IntentFilter) null);
            a(new d(this.h), (IntentFilter) null);
            a(new com.huawei.android.pushagent.b.f.a(this.h), (IntentFilter) null);
            a(new b(this.h), (IntentFilter) null);
            this.e.a(this.h);
        } catch (Exception e2) {
            String str2 = a;
            e.a(str2, "Exception:registerMyReceiver: " + e2.toString(), (Throwable) e2);
            stopService();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        this.h = getContext();
        Thread.setDefaultUncaughtExceptionHandler(new a(this));
        super.onCreate();
        try {
            e.a(this.h);
            e.b(a, "PushService:onCreate()");
            this.f = System.currentTimeMillis();
            try {
                this.c = new b(this.h);
                this.c.start();
                int i = 0;
                while (this.c.a == null) {
                    int i2 = i + 1;
                    if (i > 80) {
                        String str = a;
                        e.d(str, "call mReceiverDispatcher run after " + i2 + ", " + " but handler is null");
                        stopService();
                        return;
                    }
                    Thread.sleep(100);
                    if (i2 % 10 == 0) {
                        String str2 = a;
                        e.a(str2, "wait hander created: " + i2);
                    }
                    i = i2;
                }
                com.huawei.android.pushagent.b.a.a.a(this.h);
                b(this);
                d();
            } catch (Exception e2) {
                String str3 = a;
                e.a(str3, "create ReceiverDispatcher thread or get channelMgr exception ,stopself, " + e2.toString(), (Throwable) e2);
                stopService();
            }
        } catch (Exception e3) {
            String str4 = a;
            e.a(str4, "Exception:Log.init: " + e3.toString(), (Throwable) e3);
            stopService();
        }
    }

    public void onDestroy() {
        long A;
        String str = a;
        e.b(str, "enter PushService:onDestroy(), needExitService is:" + this.g);
        try {
            b(new Intent("com.huawei.android.push.intent.inner.STOP_SERVICE").putExtra("Remote_Package_Name", this.h.getPackageName()).setPackage(this.h.getPackageName()));
        } catch (Exception e2) {
            String str2 = a;
            e.c(str2, "call PushService:onDestroy() in broadcastToProcess cause " + e2.toString(), e2);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e3) {
            e.d(a, e3.toString());
        }
        try {
            if (this.e != null) {
                this.e.a();
                this.h.unregisterReceiver(this.e);
            }
        } catch (Exception e4) {
            String str3 = a;
            e.c(str3, "call PushService:onDestroy() in unregisterReceiver cause " + e4.toString(), e4);
        }
        try {
            if (!(this.c == null || this.c.a == null)) {
                this.c.a.getLooper().quit();
            }
        } catch (Exception e5) {
            String str4 = a;
            e.c(str4, "call PushService:onDestroy() in unregisterReceiver cause " + e5.toString(), e5);
        }
        if (!this.g) {
            long j = 0;
            long a2 = System.currentTimeMillis() - this.f > com.huawei.android.pushagent.b.b.a.a(this.h).w() * 1000 ? 0 : c.a(this.h, "run_time_less_times", 0) + 1;
            if (a2 == 0) {
                A = com.huawei.android.pushagent.b.b.a.a(this.h).x();
            } else if (a2 == 1) {
                A = com.huawei.android.pushagent.b.b.a.a(this.h).y();
            } else if (a2 == 2) {
                A = com.huawei.android.pushagent.b.b.a.a(this.h).z();
            } else {
                if (a2 >= 3) {
                    A = com.huawei.android.pushagent.b.b.a.a(this.h).A();
                }
                String str5 = a;
                e.a(str5, "next start time will be " + (j / 1000) + " seconds later" + " run_time_less_times is " + a2 + "times");
                c.a(this.h, new com.huawei.android.pushagent.a.a("run_time_less_times", Long.class, (Object) Long.valueOf(a2)));
                com.huawei.android.pushagent.c.a.a.c(this.h, new Intent("com.huawei.intent.action.PUSH_ON").setPackage(this.h.getPackageName()), j);
            }
            j = A * 1000;
            String str52 = a;
            e.a(str52, "next start time will be " + (j / 1000) + " seconds later" + " run_time_less_times is " + a2 + "times");
            c.a(this.h, new com.huawei.android.pushagent.a.a("run_time_less_times", Long.class, (Object) Long.valueOf(a2)));
            com.huawei.android.pushagent.c.a.a.c(this.h, new Intent("com.huawei.intent.action.PUSH_ON").setPackage(this.h.getPackageName()), j);
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            e.b(a, "PushService onStartCommand");
            if ("com.huawei.android.pushagent".equals(this.h.getPackageName())) {
                e.c(a, "apk provide pushservice");
                Toast.makeText(this.h, "HwPushService.apk error!", 1).show();
                return 2;
            }
            if (intent != null) {
                String str = a;
                e.a(str, "onStartCommand, intent is:" + intent.toURI());
                b(intent);
            } else {
                e.b(a, "onStartCommand, intent is null ,mybe restart service called by android system");
            }
            return 1;
        } catch (Exception e2) {
            String str2 = a;
            e.c(str2, "call PushService:onStartCommand() cause " + e2.toString(), e2);
        }
    }
}
