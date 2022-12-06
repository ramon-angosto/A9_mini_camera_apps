package com.bytedance.sdk.component.e.a.c;

import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.i;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: EventMonitorUtils */
public class b {
    public static void a(AtomicLong atomicLong, int i) {
        f m = i.e().m();
        if (m != null && m.h() && atomicLong != null) {
            atomicLong.getAndAdd((long) i);
        }
    }
}
