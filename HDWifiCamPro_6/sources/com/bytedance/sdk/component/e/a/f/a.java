package com.bytedance.sdk.component.e.a.f;

import com.bytedance.sdk.component.e.a.i;

/* compiled from: MyTrack */
public class a {
    private static volatile b a;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new c(i.e().d(), new f(i.e().d()));
                }
            }
        }
        return a;
    }
}
