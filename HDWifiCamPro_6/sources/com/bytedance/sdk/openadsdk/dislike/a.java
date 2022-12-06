package com.bytedance.sdk.openadsdk.dislike;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.n;
import java.util.List;

/* compiled from: DislikeDispatcher */
public class a {
    private static volatile a a;
    private final n<com.bytedance.sdk.openadsdk.c.a> b = m.c();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(String str, List<FilterWord> list) {
        this.b.a(str, list);
    }
}
