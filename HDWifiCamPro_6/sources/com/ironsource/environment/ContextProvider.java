package com.ironsource.environment;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ConcurrentHashMap;

public class ContextProvider {
    private static volatile ContextProvider e;
    private Activity a;
    private Context b;
    private ConcurrentHashMap<String, a> c = new ConcurrentHashMap<>();
    private Handler d = new Handler(Looper.getMainLooper());

    public interface a {
        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private ContextProvider() {
    }

    public static ContextProvider getInstance() {
        if (e == null) {
            synchronized (ContextProvider.class) {
                if (e == null) {
                    e = new ContextProvider();
                }
            }
        }
        return e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.Context getApplicationContext() {
        /*
            r1 = this;
            android.content.Context r0 = r1.b
            if (r0 != 0) goto L_0x000d
            android.app.Activity r0 = r1.a
            if (r0 == 0) goto L_0x000d
            android.content.Context r0 = r0.getApplicationContext()
            return r0
        L_0x000d:
            android.content.Context r0 = r1.b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.ContextProvider.getApplicationContext():android.content.Context");
    }

    public Activity getCurrentActiveActivity() {
        return this.a;
    }

    public void onPause(Activity activity) {
        if (activity != null) {
            for (a onPause : this.c.values()) {
                onPause.onPause(activity);
            }
        }
    }

    public void onResume(Activity activity) {
        if (activity != null) {
            this.a = activity;
            for (a onResume : this.c.values()) {
                onResume.onResume(this.a);
            }
        }
    }

    @Deprecated
    public void postOnUIThread(Runnable runnable) {
        Handler handler = this.d;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void registerLifeCycleListener(a aVar) {
        this.c.put(aVar.getClass().getSimpleName(), aVar);
    }

    public void updateActivity(Activity activity) {
        if (activity != null) {
            this.a = activity;
        }
    }

    public void updateAppContext(Context context) {
        if (context != null) {
            this.b = context;
        }
    }
}
