package com.iab.omid.library.vungle.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class b implements Application.ActivityLifecycleCallbacks {
    private static b a = new b();
    private boolean b;
    private boolean c;
    private a d;

    public interface a {
        void a(boolean z);
    }

    private b() {
    }

    public static b a() {
        return a;
    }

    private void a(boolean z) {
        if (this.c != z) {
            this.c = z;
            if (this.b) {
                e();
                a aVar = this.d;
                if (aVar != null) {
                    aVar.a(!z);
                }
            }
        }
    }

    private void e() {
        boolean z = !this.c;
        for (com.iab.omid.library.vungle.adsession.a adSessionStatePublisher : a.a().b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().a(z);
        }
    }

    public void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void b() {
        this.b = true;
        this.c = false;
        e();
    }

    public void c() {
        this.b = false;
        this.c = false;
        this.d = null;
    }

    /* access modifiers changed from: package-private */
    public ActivityManager.RunningAppProcessInfo d() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        a(false);
    }

    public void onActivityStopped(Activity activity) {
        View d2;
        if (Build.VERSION.SDK_INT >= 16) {
            boolean z = true;
            boolean z2 = d().importance != 100;
            boolean z3 = true;
            for (com.iab.omid.library.vungle.adsession.a next : a.a().c()) {
                if (next.e() && (d2 = next.d()) != null && d2.hasWindowFocus()) {
                    z3 = false;
                }
            }
            if (!z2 || !z3) {
                z = false;
            }
            a(z);
        }
    }
}
