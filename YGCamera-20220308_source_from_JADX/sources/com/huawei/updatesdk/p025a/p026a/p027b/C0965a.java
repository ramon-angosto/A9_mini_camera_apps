package com.huawei.updatesdk.p025a.p026a.p027b;

import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.huawei.updatesdk.a.a.b.a */
public final class C0965a {

    /* renamed from: b */
    private static final C0965a f1299b = new C0965a();

    /* renamed from: a */
    private final Queue<byte[]> f1300a = new ArrayDeque(0);

    private C0965a() {
    }

    /* renamed from: b */
    public static C0965a m1669b() {
        return f1299b;
    }

    /* renamed from: a */
    public void mo14877a(byte[] bArr) {
        if (bArr.length == 65536) {
            synchronized (this.f1300a) {
                if (this.f1300a.size() < 32 && !this.f1300a.offer(bArr)) {
                    C0968a.m1680a("ByteArrayPool", "releaseBytes false");
                }
            }
        }
    }

    /* renamed from: a */
    public byte[] mo14878a() {
        byte[] poll;
        synchronized (this.f1300a) {
            poll = this.f1300a.poll();
        }
        return poll == null ? new byte[65536] : poll;
    }
}
