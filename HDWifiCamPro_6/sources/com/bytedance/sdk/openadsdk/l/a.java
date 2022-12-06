package com.bytedance.sdk.openadsdk.l;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.work.WorkRequest;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ActivityLifecycleListener */
public class a implements Application.ActivityLifecycleCallbacks {
    public static boolean a = false;
    public static long b;
    public static long c;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final HashSet<Integer> e = new HashSet<>();
    /* access modifiers changed from: private */
    public final C0054a f = new C0054a();
    private final c g = new c();
    private final b h = new b();
    private volatile CopyOnWriteArrayList<com.bytedance.sdk.component.adexpress.a> i = new CopyOnWriteArrayList<>();
    private final Set<Integer> j = new HashSet();
    private HandlerThread k = null;
    private Handler l = null;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public a() {
        b();
    }

    private void b() {
        this.k = new HandlerThread(RequestParameters.SUBRESOURCE_LIFECYCLE, 10);
        this.k.start();
        this.l = new Handler(this.k.getLooper());
    }

    private void a(Runnable runnable) {
        if (!this.k.isAlive()) {
            b();
        }
        this.l.post(runnable);
    }

    public void onActivityStarted(Activity activity) {
        this.j.add(Integer.valueOf(activity.hashCode()));
        this.d.set(false);
    }

    public void onActivityResumed(Activity activity) {
        this.e.add(Integer.valueOf(activity.hashCode()));
        a((Runnable) this.g);
        if (!a) {
            b = System.currentTimeMillis();
            a = true;
        }
    }

    public void onActivityPaused(Activity activity) {
        if (ApmHelper.isIsInit()) {
            a((Runnable) this.h);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.l.a$a  reason: collision with other inner class name */
    /* compiled from: ActivityLifecycleListener */
    static class C0054a implements Runnable {
        C0054a() {
        }

        public void run() {
            e.b().execute(new g("reportPvFromBackGround") {
                public void run() {
                    ApmHelper.reportPvFromBackGround();
                }
            });
        }
    }

    /* compiled from: ActivityLifecycleListener */
    class c implements Runnable {
        c() {
        }

        public void run() {
            k.c().removeMessages(1001);
            Context a2 = m.a();
            if (a2 != null) {
                com.bytedance.sdk.component.f.c.a.b(a2);
            }
        }
    }

    /* compiled from: ActivityLifecycleListener */
    class b implements Runnable {
        b() {
        }

        public void run() {
            if (ApmHelper.isIsInit()) {
                Handler c = k.c();
                Message obtain = Message.obtain(c, a.this.f);
                obtain.what = 1001;
                c.sendMessageDelayed(obtain, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        this.j.remove(Integer.valueOf(activity.hashCode()));
        if (this.j.size() <= 0) {
            this.d.set(true);
        }
        if (a()) {
            a = false;
            k.b.set(false);
            c = System.currentTimeMillis();
        }
        a((Runnable) new d(b, c, a()));
    }

    /* compiled from: ActivityLifecycleListener */
    public class d implements Runnable {
        private long b = 0;
        private long c = 0;
        private boolean d = false;

        public d(long j, long j2, boolean z) {
            this.b = j;
            this.c = j2;
            this.d = z;
        }

        public void run() {
            if (this.d) {
                com.bytedance.sdk.openadsdk.h.b.a().a(this.b / 1000, this.c / 1000);
            }
            a.this.c();
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.e.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.i != null && this.i.size() > 0) {
            Iterator<com.bytedance.sdk.component.adexpress.a> it = this.i.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.adexpress.a next = it.next();
                if (next != null) {
                    next.a(activity);
                }
            }
        }
    }

    public void a(com.bytedance.sdk.component.adexpress.a aVar) {
        this.i.add(new WeakReference(aVar).get());
    }

    public boolean b(com.bytedance.sdk.component.adexpress.a aVar) {
        return this.i.remove(new WeakReference(aVar).get());
    }

    public boolean a() {
        return this.d.get();
    }

    /* access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.c.a.a.a();
    }
}
