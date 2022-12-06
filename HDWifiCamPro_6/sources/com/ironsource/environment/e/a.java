package com.ironsource.environment.e;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ironsource/environment/thread/ISAdPlayerThreadManager;", "", "()V", "backgroundHandler", "Lcom/ironsource/environment/thread/IronSourceHandlerThread;", "publisherCallbackHandler", "uiHandler", "Landroid/os/Handler;", "getBackgroundThreadLooper", "Landroid/os/Looper;", "postBackgroundTask", "", "action", "Ljava/lang/Runnable;", "delay", "", "postCallbacks", "postOnUiThreadTask", "environment_release"}, k = 1, mv = {1, 4, 2})
public final class a {
    public static final a a = new a();
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static final b c;
    private static final b d;

    static {
        b bVar = new b("isadplayer-background");
        bVar.start();
        bVar.a();
        c = bVar;
        b bVar2 = new b("isadplayer-publisher-callbacks");
        bVar2.start();
        bVar2.a();
        d = bVar2;
    }

    private a() {
    }

    public static Looper a() {
        return c.getLooper();
    }

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "action");
        b.postDelayed(runnable, 0);
    }

    public final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "action");
        c.a(runnable, 0);
    }

    public final void c(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "action");
        d.a(runnable, 0);
    }
}
