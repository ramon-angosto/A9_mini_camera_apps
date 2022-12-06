package com.bytedance.sdk.component.utils;

/* compiled from: Predicate */
public class q {
    public static void a(boolean z, String str) {
        if (!z) {
            a(str);
        }
    }

    private static void a(String str) {
        throw new IllegalArgumentException(str);
    }
}
