package com.bytedance.sdk.component.e.a;

/* compiled from: AssertUtils */
public class c {
    public static void a(Object obj, String str) {
        if (obj == null) {
            a(str);
        }
    }

    public static void a(String str) {
        throw new IllegalArgumentException(str);
    }
}
