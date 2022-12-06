package com.ironsource.environment;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/ironsource/environment/DeviceConfigurationsDataHolder;", "", "()V", "shouldUseAdvertisingId", "", "getShouldUseAdvertisingId", "()Z", "setShouldUseAdvertisingId", "(Z)V", "shouldUseAppSet", "getShouldUseAppSet", "setShouldUseAppSet", "environment_release"}, k = 1, mv = {1, 4, 2})
public final class g {
    public static final g a = new g();
    private static boolean b = true;
    private static boolean c = true;

    private g() {
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean a() {
        return b;
    }

    public static void b(boolean z) {
        c = z;
    }

    public static boolean b() {
        return c;
    }
}
