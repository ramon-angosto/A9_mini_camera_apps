package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.Looper;

public final class Preconditions {
    public Preconditions() {
        throw new AssertionError("Cannot use constructor to make a new instance");
    }

    /* renamed from: a */
    public static boolean m418a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkHandlerThread(Handler handler) {
        checkHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void checkMainThread(String str) {
        if (!m418a()) {
            throw new IllegalStateException(str);
        }
    }

    public static void checkNotMainThread() {
        if (m418a()) {
            throw new IllegalStateException("Must not be called on the main application thread");
        }
    }

    public static <O> O checkNotNull(O o) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException("must not refer to a null object");
    }

    public static void checkState(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <O> O checkNotNull(O o, Object obj) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
