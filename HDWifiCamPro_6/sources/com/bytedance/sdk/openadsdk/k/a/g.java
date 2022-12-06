package com.bytedance.sdk.openadsdk.k.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.l;

/* compiled from: PAGTimerManager */
public class g {
    private static a a;
    private static HandlerThread b;

    public static void a() {
    }

    public static void a(b bVar) {
        if (bVar != null) {
            b();
            a aVar = a;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }
    }

    public static void b() {
        if (a == null) {
            try {
                if (b == null || !b.isAlive()) {
                    synchronized (g.class) {
                        if (b == null || !b.isAlive()) {
                            b = new HandlerThread("csj_MRC");
                            b.start();
                            a = new a(b.getLooper());
                        }
                    }
                }
            } catch (Throwable th) {
                l.e("MRC", th.getMessage());
            }
        }
    }

    /* compiled from: PAGTimerManager */
    private static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            b bVar = (b) message.obj;
            if (bVar != null) {
                int b = bVar.b();
                if (b == 1) {
                    bVar.g();
                } else if (b == 2) {
                    bVar.h();
                } else {
                    e.b(bVar.k());
                    return;
                }
                if (bVar.i()) {
                    e.b(bVar.k());
                } else if (bVar.l()) {
                    a(bVar);
                }
            }
        }

        public void a(b bVar) {
            if (bVar != null) {
                int intValue = bVar.k().intValue();
                if (!hasMessages(intValue)) {
                    Message obtain = Message.obtain();
                    obtain.what = intValue;
                    obtain.obj = bVar;
                    sendMessageDelayed(obtain, (long) bVar.f());
                }
            }
        }
    }
}
