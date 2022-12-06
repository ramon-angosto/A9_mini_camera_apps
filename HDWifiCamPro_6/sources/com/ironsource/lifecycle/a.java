package com.ironsource.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ironsource/lifecycle/ForegroundTimeCalculator;", "Lcom/ironsource/lifecycle/IronsourceLifecycleListener;", "task", "Lcom/ironsource/lifecycle/SessionCalcTask;", "(Lcom/ironsource/lifecycle/SessionCalcTask;)V", "sessionStartTime", "", "appPaused", "", "appResumed", "appStarted", "appStopped", "getSessionTime", "updateSessionStartTime", "environment_release"}, k = 1, mv = {1, 4, 2})
public final class a implements c {
    private long a = System.currentTimeMillis();
    private final g b;

    public a(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "task");
        this.b = gVar;
        d.a().a((c) this);
    }

    public final void a() {
        this.a = System.currentTimeMillis();
    }

    public final void b() {
        this.b.a = Long.valueOf(System.currentTimeMillis() - this.a);
        this.b.run();
    }
}
