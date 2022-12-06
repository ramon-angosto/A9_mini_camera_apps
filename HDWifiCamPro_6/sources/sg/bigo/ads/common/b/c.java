package sg.bigo.ads.common.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import sg.bigo.ads.common.b.b;

public final class c implements Application.ActivityLifecycleCallbacks {
    private static boolean a = false;
    private static int b = -1;
    private static int c = -1;
    private WeakReference<Activity> d;

    static class a {
        /* access modifiers changed from: private */
        public static final c a = new c((byte) 0);
    }

    private c() {
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public static Activity a() {
        WeakReference<Activity> weakReference = a.a.d;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public static synchronized void a(Application application) {
        synchronized (c.class) {
            if (!a) {
                a = true;
                b = 0;
                c = 0;
                application.registerActivityLifecycleCallbacks(a.a);
            }
        }
    }

    public static int b() {
        int i;
        if (!a || (i = c) < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static boolean c() {
        return b > 0;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        b++;
    }

    public final void onActivityDestroyed(Activity activity) {
        b--;
    }

    public final void onActivityPaused(Activity activity) {
        this.d = null;
    }

    public final void onActivityResumed(Activity activity) {
        this.d = new WeakReference<>(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (c == 0) {
            b a2 = b.a();
            a2.b();
            if (a2.d != null && a2.c()) {
                a2.d.a(a2.b);
            }
            sg.bigo.ads.common.k.a.a(0, 3, "LAM", "On enter foreground.");
        }
        c++;
    }

    public final void onActivityStopped(Activity activity) {
        int i = c - 1;
        c = i;
        if (i == 0) {
            b a2 = b.a();
            if (a2.d != null && a2.c()) {
                b.a aVar = a2.d;
                boolean z = a2.a;
                long j = a2.b;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = a2.c;
                System.currentTimeMillis();
                aVar.a(z, j, elapsedRealtime, j2);
            }
            a2.a = false;
            sg.bigo.ads.common.k.a.a(0, 3, "LAM", "On enter background.");
        }
    }
}
