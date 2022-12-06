package com.huawei.android.pushagent.b.a.a.a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.pushagent.a.b;
import com.huawei.android.pushagent.a.d;
import com.huawei.android.pushagent.b.a.a;
import com.huawei.android.pushagent.b.a.a.c;
import com.huawei.android.pushagent.b.a.b.b;
import com.huawei.android.pushagent.c.a.e;

public class a extends com.huawei.android.pushagent.b.a.a.a {

    /* renamed from: com.huawei.android.pushagent.b.a.a.a.a$1  reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[c.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.huawei.android.pushagent.b.a.a.c$a[] r0 = com.huawei.android.pushagent.b.a.a.c.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.huawei.android.pushagent.b.a.a.c$a r1 = com.huawei.android.pushagent.b.a.a.c.a.SocketEvent_CONNECTED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.huawei.android.pushagent.b.a.a.c$a r1 = com.huawei.android.pushagent.b.a.a.c.a.SocketEvent_MSG_RECEIVED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.a.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(d dVar, Context context) {
        super(dVar, context, new b(context), a.class.getSimpleName());
        f();
    }

    public void a(c.a aVar, Bundle bundle) {
        StringBuilder sb;
        String str;
        e.a("PushLogAC2705", "enter PollingConnectEntity:notifyEvent(" + aVar + ",bd:" + bundle + ")");
        int i = AnonymousClass1.a[aVar.ordinal()];
        if (i == 1) {
            this.e.a();
            this.e.a(System.currentTimeMillis());
            try {
                a((b) new com.huawei.android.pushagent.a.a.a(com.huawei.android.pushagent.b.b.a.a(this.d).E()));
                if (this.c != null) {
                    this.c.c().setSoTimeout((int) (com.huawei.android.pushagent.b.b.a.a(this.d).v() * 1000));
                }
            } catch (Exception e) {
                e = e;
                sb = new StringBuilder();
                str = "call send cause:";
                sb.append(str);
                sb.append(e.toString());
                e.c("PushLogAC2705", sb.toString(), e);
            }
        } else if (i == 2) {
            b bVar = (b) bundle.getSerializable("push_msg");
            if (bVar == null) {
                e.b("PushLogAC2705", "push_msg is null");
                return;
            }
            e.b("PushLogAC2705", "received polling Msg:" + bVar.getClass().getSimpleName());
            if (bVar instanceof com.huawei.android.pushagent.a.a.b) {
                com.huawei.android.pushagent.a.a.b bVar2 = (com.huawei.android.pushagent.a.a.b) bVar;
                if (bVar2.d() < 0 || bVar2.d() > a.C0032a.values().length) {
                    e.d("PushLogAC2705", "received mode:" + bVar2.d() + " cannot be recongnized");
                    return;
                }
                a.C0032a aVar2 = a.C0032a.values()[bVar2.d()];
                com.huawei.android.pushagent.b.a.a.a(this.d).a(aVar2);
                this.e.b(((long) bVar2.f()) * 1000);
                if (bVar2.e() || aVar2 == a.C0032a.ConnectEntity_Push) {
                    try {
                        com.huawei.android.pushagent.b.a.a.e().a(true, bVar2.e());
                    } catch (com.huawei.android.pushagent.a.c e2) {
                        e.c("PushLogAC2705", e2.toString(), e2);
                    }
                }
                if (this.c != null) {
                    try {
                        this.c.a();
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder();
                        str = "call channel close cause:";
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0121, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(boolean r8) throws com.huawei.android.pushagent.a.c {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x012b }
            r1.<init>()     // Catch:{ all -> 0x012b }
            java.lang.String r2 = "enter PollingConnectEntity:connect(forceCon:"
            r1.append(r2)     // Catch:{ all -> 0x012b }
            r1.append(r8)     // Catch:{ all -> 0x012b }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x012b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.c.a.e.a(r0, r1)     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.a.a.b r0 = r7.e     // Catch:{ all -> 0x012b }
            r0.b()     // Catch:{ all -> 0x012b }
            android.content.Context r0 = r7.d     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.b.a r0 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r0)     // Catch:{ all -> 0x012b }
            boolean r0 = r0.X()     // Catch:{ all -> 0x012b }
            if (r0 != 0) goto L_0x002f
            monitor-exit(r7)
            return
        L_0x002f:
            boolean r0 = r7.a()     // Catch:{ all -> 0x012b }
            if (r0 == 0) goto L_0x003e
            java.lang.String r8 = "PushLogAC2705"
            java.lang.String r0 = "Polling aready connect, just wait Rsp!"
            com.huawei.android.pushagent.c.a.e.b(r8, r0)     // Catch:{ all -> 0x012b }
            monitor-exit(r7)
            return
        L_0x003e:
            r0 = 0
            if (r8 != 0) goto L_0x0095
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.a.a.b r8 = r7.e     // Catch:{ all -> 0x012b }
            long r3 = r8.d()     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.a.a.b r8 = r7.e     // Catch:{ all -> 0x012b }
            long r5 = r8.b((boolean) r0)     // Catch:{ all -> 0x012b }
            long r3 = r3 + r5
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 >= 0) goto L_0x0095
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.a.a.b r8 = r7.e     // Catch:{ all -> 0x012b }
            long r3 = r8.d()     // Catch:{ all -> 0x012b }
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 <= 0) goto L_0x0095
            java.lang.String r8 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x012b }
            r1.<init>()     // Catch:{ all -> 0x012b }
            java.lang.String r2 = "cannot connect, heartBeatInterval:"
            r1.append(r2)     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.a.a.b r2 = r7.e     // Catch:{ all -> 0x012b }
            long r2 = r2.b((boolean) r0)     // Catch:{ all -> 0x012b }
            r1.append(r2)     // Catch:{ all -> 0x012b }
            java.lang.String r0 = " lastCntTime:"
            r1.append(r0)     // Catch:{ all -> 0x012b }
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.a.a.b r2 = r7.e     // Catch:{ all -> 0x012b }
            long r2 = r2.d()     // Catch:{ all -> 0x012b }
            r0.<init>(r2)     // Catch:{ all -> 0x012b }
            r1.append(r0)     // Catch:{ all -> 0x012b }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.c.a.e.b(r8, r0)     // Catch:{ all -> 0x012b }
            monitor-exit(r7)
            return
        L_0x0095:
            android.content.Context r8 = r7.d     // Catch:{ all -> 0x012b }
            int r8 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r8)     // Catch:{ all -> 0x012b }
            r1 = -1
            if (r8 != r1) goto L_0x00a7
            java.lang.String r8 = "PushLogAC2705"
            java.lang.String r0 = "no network, so cannot connect Polling"
            com.huawei.android.pushagent.c.a.e.b(r8, r0)     // Catch:{ all -> 0x012b }
            monitor-exit(r7)
            return
        L_0x00a7:
            com.huawei.android.pushagent.b.a.a.c r8 = r7.b     // Catch:{ all -> 0x012b }
            if (r8 == 0) goto L_0x00d1
            com.huawei.android.pushagent.b.a.a.c r8 = r7.b     // Catch:{ all -> 0x012b }
            boolean r8 = r8.isAlive()     // Catch:{ all -> 0x012b }
            if (r8 != 0) goto L_0x00b4
            goto L_0x00d1
        L_0x00b4:
            java.lang.String r8 = "PushLogAC2705"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x012b }
            r0.<init>()     // Catch:{ all -> 0x012b }
            java.lang.String r1 = "aready in connect, just wait!! srvSocket:"
            r0.append(r1)     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.a.a.c r1 = r7.b     // Catch:{ all -> 0x012b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x012b }
            r0.append(r1)     // Catch:{ all -> 0x012b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.c.a.e.b(r8, r0)     // Catch:{ all -> 0x012b }
            goto L_0x0120
        L_0x00d1:
            java.lang.String r8 = "PushLogAC2705"
            java.lang.String r1 = "begin to create new socket, so close socket"
            com.huawei.android.pushagent.c.a.e.a(r8, r1)     // Catch:{ all -> 0x012b }
            r7.b()     // Catch:{ all -> 0x012b }
            r7.d()     // Catch:{ all -> 0x012b }
            android.content.Context r8 = r7.d     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.b.a r8 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r8)     // Catch:{ all -> 0x012b }
            java.net.InetSocketAddress r8 = r8.b((boolean) r0)     // Catch:{ all -> 0x012b }
            if (r8 == 0) goto L_0x0122
            java.lang.String r0 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x012b }
            r1.<init>()     // Catch:{ all -> 0x012b }
            java.lang.String r2 = "get pollingSrvAddr:"
            r1.append(r2)     // Catch:{ all -> 0x012b }
            r1.append(r8)     // Catch:{ all -> 0x012b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.c.a.e.a(r0, r1)     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.a.d r0 = r7.a     // Catch:{ all -> 0x012b }
            java.net.InetAddress r1 = r8.getAddress()     // Catch:{ all -> 0x012b }
            java.lang.String r1 = r1.getHostAddress()     // Catch:{ all -> 0x012b }
            r0.a = r1     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.a.d r0 = r7.a     // Catch:{ all -> 0x012b }
            int r8 = r8.getPort()     // Catch:{ all -> 0x012b }
            r0.b = r8     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.a.a.a.c r8 = new com.huawei.android.pushagent.b.a.a.a.c     // Catch:{ all -> 0x012b }
            r8.<init>(r7)     // Catch:{ all -> 0x012b }
            r7.b = r8     // Catch:{ all -> 0x012b }
            com.huawei.android.pushagent.b.a.a.c r8 = r7.b     // Catch:{ all -> 0x012b }
            r8.start()     // Catch:{ all -> 0x012b }
        L_0x0120:
            monitor-exit(r7)
            return
        L_0x0122:
            java.lang.String r8 = "PushLogAC2705"
            java.lang.String r0 = "no valid pollingSrvAddr, just wait!!"
            com.huawei.android.pushagent.c.a.e.d(r8, r0)     // Catch:{ all -> 0x012b }
            monitor-exit(r7)
            return
        L_0x012b:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.a.a.a(boolean):void");
    }

    public synchronized void a(boolean z, boolean z2) throws com.huawei.android.pushagent.a.c {
        a(z);
    }

    public a.C0032a e() {
        return a.C0032a.ConnectEntity_Polling;
    }

    public boolean f() {
        if (this.a != null) {
            return true;
        }
        this.a = new d("", -1, false, b.a.ChannelType_Normal);
        return true;
    }
}
