package com.huawei.android.pushagent.b.a.a;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import com.huawei.android.pushagent.a.d;
import com.huawei.android.pushagent.b.a.a;
import com.huawei.android.pushagent.b.a.a.c;
import com.huawei.android.pushagent.b.a.b.b;
import com.huawei.android.pushagent.c.a.e;
import java.net.Socket;

public abstract class a {
    public d a;
    public c b;
    public b c;
    public Context d;
    public b e;
    protected PowerManager.WakeLock f = null;
    private PowerManager g;

    /* renamed from: com.huawei.android.pushagent.b.a.a.a$1  reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[C0033a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.huawei.android.pushagent.b.a.a.a$a[] r0 = com.huawei.android.pushagent.b.a.a.a.C0033a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.huawei.android.pushagent.b.a.a.a$a r1 = com.huawei.android.pushagent.b.a.a.a.C0033a.CONNECT_METHOD_DIRECT_TrsPort     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.huawei.android.pushagent.b.a.a.a$a r1 = com.huawei.android.pushagent.b.a.a.a.C0033a.CONNECT_METHOD_DIRECT_DefaultPort     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.huawei.android.pushagent.b.a.a.a$a r1 = com.huawei.android.pushagent.b.a.a.a.C0033a.CONNECT_METHOD_Proxy_TrsPort     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.huawei.android.pushagent.b.a.a.a$a r1 = com.huawei.android.pushagent.b.a.a.a.C0033a.CONNECT_METHOD_Proxy_DefaultPort     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.a.AnonymousClass1.<clinit>():void");
        }
    }

    /* renamed from: com.huawei.android.pushagent.b.a.a.a$a  reason: collision with other inner class name */
    enum C0033a {
        CONNECT_METHOD_DIRECT_TrsPort,
        CONNECT_METHOD_DIRECT_DefaultPort,
        CONNECT_METHOD_Proxy_TrsPort,
        CONNECT_METHOD_Proxy_DefaultPort
    }

    public a(d dVar, Context context, b bVar, String str) {
        this.d = context;
        this.a = dVar;
        this.e = bVar;
        this.g = (PowerManager) context.getSystemService("power");
    }

    /* access modifiers changed from: protected */
    public d a(int i, int i2) {
        int i3 = AnonymousClass1.a[C0033a.values()[b(i, i2)].ordinal()];
        if (i3 == 1) {
            return new d(this.a.a, this.a.b, false, this.a.c);
        }
        if (i3 == 2) {
            return new d(this.a.a, 443, false, this.a.c);
        }
        if (i3 == 3) {
            return new d(this.a.a, 443, true, this.a.c);
        }
        if (i3 != 4) {
            return null;
        }
        return new d(this.a.a, this.a.b, true, this.a.c);
    }

    public abstract void a(c.a aVar, Bundle bundle);

    public abstract void a(boolean z) throws com.huawei.android.pushagent.a.c;

    public abstract void a(boolean z, boolean z2) throws com.huawei.android.pushagent.a.c;

    public boolean a() {
        b bVar = this.c;
        return bVar != null && bVar.b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b8, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(com.huawei.android.pushagent.a.b r7) throws java.lang.Exception {
        /*
            r6 = this;
            monitor-enter(r6)
            com.huawei.android.pushagent.b.a.b.b r0 = r6.c     // Catch:{ all -> 0x00b9 }
            r1 = 0
            if (r0 == 0) goto L_0x009b
            com.huawei.android.pushagent.b.a.b.b r0 = r6.c     // Catch:{ all -> 0x00b9 }
            java.net.Socket r0 = r0.c()     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x009b
            com.huawei.android.pushagent.b.a.a$a r0 = com.huawei.android.pushagent.b.a.a.c()     // Catch:{ all -> 0x00b9 }
            com.huawei.android.pushagent.b.a.a$a r2 = r6.e()     // Catch:{ all -> 0x00b9 }
            if (r0 != r2) goto L_0x0022
            com.huawei.android.pushagent.b.a.b.b r0 = r6.c     // Catch:{ all -> 0x00b9 }
            java.net.Socket r0 = r0.c()     // Catch:{ all -> 0x00b9 }
            r0.setSoTimeout(r1)     // Catch:{ all -> 0x00b9 }
            goto L_0x003d
        L_0x0022:
            com.huawei.android.pushagent.b.a.b.b r0 = r6.c     // Catch:{ all -> 0x00b9 }
            java.net.Socket r0 = r0.c()     // Catch:{ all -> 0x00b9 }
            com.huawei.android.pushagent.b.a.a.b r2 = r6.e     // Catch:{ all -> 0x00b9 }
            long r2 = r2.b((boolean) r1)     // Catch:{ all -> 0x00b9 }
            android.content.Context r4 = r6.d     // Catch:{ all -> 0x00b9 }
            com.huawei.android.pushagent.b.b.a r4 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r4)     // Catch:{ all -> 0x00b9 }
            long r4 = r4.Q()     // Catch:{ all -> 0x00b9 }
            long r2 = r2 + r4
            int r3 = (int) r2     // Catch:{ all -> 0x00b9 }
            r0.setSoTimeout(r3)     // Catch:{ all -> 0x00b9 }
        L_0x003d:
            r0 = 0
            if (r7 == 0) goto L_0x0045
            byte[] r0 = r7.b()     // Catch:{ all -> 0x00b9 }
            goto L_0x004c
        L_0x0045:
            java.lang.String r2 = "PushLogAC2705"
            java.lang.String r3 = "pushMsg = null, send fail"
            com.huawei.android.pushagent.c.a.e.d(r2, r3)     // Catch:{ all -> 0x00b9 }
        L_0x004c:
            if (r0 == 0) goto L_0x0093
            int r2 = r0.length     // Catch:{ all -> 0x00b9 }
            if (r2 != 0) goto L_0x0052
            goto L_0x0093
        L_0x0052:
            java.lang.String r2 = "PushLogAC2705"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r3.<init>()     // Catch:{ all -> 0x00b9 }
            java.lang.String r4 = "read to Send:"
            r3.append(r4)     // Catch:{ all -> 0x00b9 }
            byte r4 = r7.a()     // Catch:{ all -> 0x00b9 }
            java.lang.String r4 = com.huawei.android.pushagent.c.a.a((byte) r4)     // Catch:{ all -> 0x00b9 }
            r3.append(r4)     // Catch:{ all -> 0x00b9 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b9 }
            com.huawei.android.pushagent.c.a.e.b(r2, r3)     // Catch:{ all -> 0x00b9 }
            com.huawei.android.pushagent.b.a.b.b r2 = r6.c     // Catch:{ all -> 0x00b9 }
            boolean r0 = r2.a((byte[]) r0)     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x008b
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = "com.huawei.android.push.intent.MSG_SENT"
            r0.<init>(r1)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = "push_msg"
            android.content.Intent r7 = r0.putExtra(r1, r7)     // Catch:{ all -> 0x00b9 }
            com.huawei.android.pushagent.PushService.a((android.content.Intent) r7)     // Catch:{ all -> 0x00b9 }
            r7 = 1
            monitor-exit(r6)
            return r7
        L_0x008b:
            java.lang.String r7 = "PushLogAC2705"
            java.lang.String r0 = "call channel.send false!!"
        L_0x008f:
            com.huawei.android.pushagent.c.a.e.d(r7, r0)     // Catch:{ all -> 0x00b9 }
            goto L_0x00b7
        L_0x0093:
            java.lang.String r7 = "PushLogAC2705"
            java.lang.String r0 = "when send PushMsg, encode Len is null"
            com.huawei.android.pushagent.c.a.e.b(r7, r0)     // Catch:{ all -> 0x00b9 }
            goto L_0x00b7
        L_0x009b:
            java.lang.String r7 = "PushLogAC2705"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r0.<init>()     // Catch:{ all -> 0x00b9 }
            java.lang.String r2 = "when send pushMsg, channel is null， curCls:"
            r0.append(r2)     // Catch:{ all -> 0x00b9 }
            java.lang.Class r2 = r6.getClass()     // Catch:{ all -> 0x00b9 }
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ all -> 0x00b9 }
            r0.append(r2)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b9 }
            goto L_0x008f
        L_0x00b7:
            monitor-exit(r6)
            return r1
        L_0x00b9:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x00bd
        L_0x00bc:
            throw r7
        L_0x00bd:
            goto L_0x00bc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.a.a(com.huawei.android.pushagent.a.b):boolean");
    }

    /* access modifiers changed from: protected */
    public int b(int i, int i2) {
        return Math.abs(i + i2) % C0033a.values().length;
    }

    /* access modifiers changed from: protected */
    public synchronized void b() {
        this.f = this.g.newWakeLock(1, "mWakeLockForThread");
        this.f.setReferenceCounted(false);
        this.f.acquire(1000);
    }

    public Socket c() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public void d() {
        b bVar = this.c;
        if (bVar != null) {
            try {
                bVar.a();
                this.c = null;
            } catch (Exception e2) {
                e.c("PushLogAC2705", "call channel.close() cause:" + e2.toString(), e2);
            }
            c cVar = this.b;
            if (cVar != null) {
                cVar.interrupt();
                this.b = null;
            }
        }
    }

    public abstract a.C0032a e();

    public String toString() {
        return this.a.toString() + " " + this.e.toString();
    }
}
