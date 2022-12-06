package sg.bigo.ads.api.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a implements Application.ActivityLifecycleCallbacks {
    private WeakReference<Activity> a;
    /* access modifiers changed from: private */
    public final List<WeakReference<C0119a>> b;

    /* renamed from: sg.bigo.ads.api.core.a$a  reason: collision with other inner class name */
    public interface C0119a {
        void a();

        void b();
    }

    static class b {
        /* access modifiers changed from: private */
        public static final a a = new a((byte) 0);
    }

    private a() {
        this.b = new ArrayList();
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return b.a;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        for (WeakReference<C0119a> weakReference : this.b) {
            weakReference.get();
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        for (WeakReference<C0119a> weakReference : this.b) {
            weakReference.get();
        }
    }

    public final void onActivityPaused(Activity activity) {
        for (WeakReference<C0119a> weakReference : this.b) {
            C0119a aVar = (C0119a) weakReference.get();
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final void onActivityResumed(Activity activity) {
        this.a = new WeakReference<>(activity);
        for (WeakReference<C0119a> weakReference : this.b) {
            C0119a aVar = (C0119a) weakReference.get();
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
