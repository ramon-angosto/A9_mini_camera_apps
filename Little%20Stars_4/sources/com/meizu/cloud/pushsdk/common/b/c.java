package com.meizu.cloud.pushsdk.common.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.meizu.cloud.pushsdk.common.b.g;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class c {
    private static Handler a = new e(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static a b;
    /* access modifiers changed from: private */
    public static LinkedList<b> c = new LinkedList<>();
    private static a.C0045a d = a.C0045a.DEBUG;
    private static a.C0045a e = a.C0045a.DEBUG;
    private static C0046c f = new C0046c();

    public interface a {

        /* renamed from: com.meizu.cloud.pushsdk.common.b.c$a$a  reason: collision with other inner class name */
        public enum C0045a {
            DEBUG,
            INFO,
            WARN,
            ERROR,
            NULL
        }

        void a(C0045a aVar, String str, String str2);
    }

    /* renamed from: com.meizu.cloud.pushsdk.common.b.c$c  reason: collision with other inner class name */
    public static class C0046c {
        int a = 100;
        int b = 120000;
    }

    public enum d {
        CONSOLE,
        FILE
    }

    public static void a(d dVar, a.C0045a aVar) {
        if (dVar == d.CONSOLE) {
            d = aVar;
        } else if (dVar == d.FILE) {
            e = aVar;
        }
    }

    public static void a(a aVar) {
        b = aVar;
    }

    public static void a() {
        synchronized (c) {
            a.removeMessages(1);
            a.obtainMessage(1).sendToTarget();
        }
    }

    private static void a(a.C0045a aVar, String str, String str2) {
        if (b != null && e.ordinal() <= aVar.ordinal()) {
            synchronized (c) {
                c.addLast(new b(aVar, str, str2));
                if (c.size() < f.a) {
                    if (f.b > 0) {
                        if (!a.hasMessages(1)) {
                            a.sendMessageDelayed(a.obtainMessage(1), (long) f.b);
                        }
                    }
                }
                a();
            }
        }
    }

    public static void a(String str, String str2) {
        if (d.ordinal() <= a.C0045a.DEBUG.ordinal()) {
            Log.d(str, str2);
        }
        a(a.C0045a.DEBUG, str, str2);
    }

    public static void b(String str, String str2) {
        if (d.ordinal() <= a.C0045a.INFO.ordinal()) {
            Log.i(str, str2);
        }
        a(a.C0045a.INFO, str, str2);
    }

    public static void c(String str, String str2) {
        if (d.ordinal() <= a.C0045a.WARN.ordinal()) {
            Log.w(str, str2);
        }
        a(a.C0045a.WARN, str, str2);
    }

    public static void d(String str, String str2) {
        if (d.ordinal() <= a.C0045a.ERROR.ordinal()) {
            Log.e(str, str2);
        }
        a(a.C0045a.ERROR, str, str2);
    }

    public static void a(String str, Throwable th) {
        d(str, Log.getStackTraceString(th));
    }

    private static class b {
        static SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss ");
        static String b = String.valueOf(Process.myPid());
        a.C0045a c;
        String d;
        String e;

        b(a.C0045a aVar, String str, String str2) {
            this.c = aVar;
            this.d = a.format(new Date()) + b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(Thread.currentThread().getId()) + " " + str;
            this.e = str2;
        }
    }

    private static class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (c.b != null) {
                g.a(new g.a() {
                    public void a() {
                        LinkedList linkedList;
                        synchronized (c.c) {
                            linkedList = new LinkedList(c.c);
                            c.c.clear();
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            c.b.a(bVar.c, bVar.d, bVar.e);
                        }
                    }
                });
            }
        }
    }
}
