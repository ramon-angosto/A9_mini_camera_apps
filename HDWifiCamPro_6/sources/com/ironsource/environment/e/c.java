package com.ironsource.environment.e;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ironsource/environment/thread/IronSourceThreadManager;", "", "()V", "backgroundHandler", "Lcom/ironsource/environment/thread/IronSourceHandlerThread;", "uiHandler", "Landroid/os/Handler;", "postBackgroundTask", "", "action", "Ljava/lang/Runnable;", "delay", "", "postOnUiThreadTask", "removeBackgroundTask", "removeUiThreadTask", "environment_release"}, k = 1, mv = {1, 4, 2})
public final class c {
    public static final c a = new c();
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static final b c;

    static {
        b bVar = new b("background");
        bVar.start();
        bVar.a();
        c = bVar;
    }

    private c() {
    }

    public static void a(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, "action");
        b.postDelayed(runnable, j);
    }

    public static void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "action");
        b.removeCallbacks(runnable);
    }

    public static void b(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, "action");
        c.a(runnable, j);
    }

    public final void a(Runnable runnable) {
        a(runnable, 0);
    }

    public final void c(Runnable runnable) {
        b(runnable, 0);
    }
}
