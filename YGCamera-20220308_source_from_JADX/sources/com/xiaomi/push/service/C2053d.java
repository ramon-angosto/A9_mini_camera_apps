package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.xiaomi.push.C1938m;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.push.service.d */
public class C2053d {

    /* renamed from: a */
    private static List<C2054a> f3878a = new CopyOnWriteArrayList();

    /* renamed from: com.xiaomi.push.service.d$a */
    private static class C2054a {

        /* renamed from: a */
        public final int f3879a;

        /* renamed from: a */
        public final long f3880a;

        /* renamed from: a */
        public final String f3881a;

        /* renamed from: a */
        public final Notification.Action[] f3882a;

        C2054a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f3881a = str;
            this.f3880a = j;
            this.f3879a = i;
            this.f3882a = actionArr;
        }
    }

    /* renamed from: a */
    private static void m5210a() {
        for (int size = f3878a.size() - 1; size >= 0; size--) {
            C2054a aVar = f3878a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f3880a > 5000) {
                f3878a.remove(aVar);
            }
        }
        if (f3878a.size() > 10) {
            f3878a.remove(0);
        }
    }

    /* renamed from: a */
    protected static void m5211a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (C1938m.m4714a(context) && i > 0 && statusBarNotification != null && Build.VERSION.SDK_INT >= 20) {
            m5212a(new C2054a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, C1994as.m5033a(statusBarNotification.getNotification())));
        }
    }

    /* renamed from: a */
    private static void m5212a(C2054a aVar) {
        f3878a.add(aVar);
        m5210a();
    }
}
