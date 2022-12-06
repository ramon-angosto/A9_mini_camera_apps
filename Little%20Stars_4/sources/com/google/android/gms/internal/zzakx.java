package com.google.android.gms.internal;

public final class zzakx {
    public static void zzaj(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T zzz(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
