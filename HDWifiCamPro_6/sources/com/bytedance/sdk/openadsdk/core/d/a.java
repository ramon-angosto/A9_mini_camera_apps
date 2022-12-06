package com.bytedance.sdk.openadsdk.core.d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.settings.j;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: FrequentCallController */
public class a {
    private static volatile a a;
    private static volatile boolean b;
    private static volatile long c;
    private final Queue<C0045a> d = new LinkedList();
    private Handler e;
    private final j f = m.d();

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

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int p = this.f.p();
        long o = this.f.o();
        if (this.d.size() <= 0 || this.d.size() < p) {
            this.d.offer(new C0045a(currentTimeMillis, str));
        } else {
            long abs = Math.abs(currentTimeMillis - this.d.peek().a);
            if (abs <= o) {
                b(o - abs);
                return true;
            }
            this.d.poll();
            this.d.offer(new C0045a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(c);
        } else {
            a(false);
        }
        return b;
    }

    private synchronized void a(long j) {
        if (this.e == null) {
            this.e = new Handler(Looper.getMainLooper());
        }
        this.e.postDelayed(new Runnable() {
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    /* access modifiers changed from: private */
    public synchronized void a(boolean z) {
        b = z;
    }

    public synchronized boolean b() {
        return b;
    }

    private synchronized void b(long j) {
        c = j;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0045a aVar : this.d) {
            if (hashMap.containsKey(aVar.b)) {
                hashMap.put(aVar.b, Integer.valueOf(((Integer) hashMap.get(aVar.b)).intValue() + 1));
            } else {
                hashMap.put(aVar.b, 1);
            }
        }
        int i = Integer.MIN_VALUE;
        str = "";
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i < intValue) {
                str = str2;
                i = intValue;
            }
        }
        return str;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.d.a$a  reason: collision with other inner class name */
    /* compiled from: FrequentCallController */
    private static class C0045a {
        /* access modifiers changed from: private */
        public final long a;
        /* access modifiers changed from: private */
        public final String b;

        private C0045a(long j, String str) {
            this.a = j;
            this.b = str;
        }
    }
}
