package com.huawei.android.pushagent.b.a.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.b.f;
import com.huawei.android.pushagent.a.b.k;
import com.huawei.android.pushagent.a.d;
import com.huawei.android.pushagent.b.a.a;
import com.huawei.android.pushagent.b.a.a.c;
import com.huawei.android.pushagent.b.d.b;
import com.huawei.android.pushagent.c.a.e;

public class a extends com.huawei.android.pushagent.b.a.a.a {
    boolean g = false;

    /* renamed from: com.huawei.android.pushagent.b.a.a.b.a$1  reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[c.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.huawei.android.pushagent.b.a.a.c$a[] r0 = com.huawei.android.pushagent.b.a.a.c.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.huawei.android.pushagent.b.a.a.c$a r1 = com.huawei.android.pushagent.b.a.a.c.a.SocketEvent_CONNECTING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.huawei.android.pushagent.b.a.a.c$a r1 = com.huawei.android.pushagent.b.a.a.c.a.SocketEvent_CONNECTED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.huawei.android.pushagent.b.a.a.c$a r1 = com.huawei.android.pushagent.b.a.a.c.a.SocketEvent_CLOSE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.huawei.android.pushagent.b.a.a.c$a r1 = com.huawei.android.pushagent.b.a.a.c.a.SocketEvent_MSG_RECEIVED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.b.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(d dVar, Context context) {
        super(dVar, context, new b(context), a.class.getSimpleName());
        f();
    }

    public void a(c.a aVar, Bundle bundle) {
        Intent intent;
        int a = com.huawei.android.pushagent.b.b.c.a(this.d, "tryConnectPushSevTimes", 0);
        int a2 = com.huawei.android.pushagent.b.b.c.a(this.d, "lastConnectPushSrvMethodIdx", 0);
        e.a("PushLogAC2705", "enter PushConnectEntity. notifyEvent is " + aVar + ", " + " tryConnectPushSevTimes:" + a + " lastConnctIdx:" + a2);
        int i = AnonymousClass1.a[aVar.ordinal()];
        if (i == 1) {
            intent = new Intent("com.huawei.android.push.intent.CONNECTING");
        } else if (i == 2) {
            this.e.a();
            this.e.a(System.currentTimeMillis());
            b.a(this.d).a(this.d, b.C0035b.SOCKET_CONNECTED, new Bundle());
            com.huawei.android.pushagent.b.b.c.a(this.d, new com.huawei.android.pushagent.a.a("lastcontectsucc_time", Long.class, (Object) Long.valueOf(System.currentTimeMillis())));
            intent = new Intent("com.huawei.android.push.intent.CONNECTED");
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        } else if (i == 3) {
            bundle.putInt("connect_mode", e().ordinal());
            PushService.a(new Intent("com.huawei.android.push.intent.CHANNEL_CLOSED").putExtras(bundle));
            if (com.huawei.android.pushagent.b.a.a.c() == e()) {
                com.huawei.android.pushagent.c.a.a.a(this.d, "com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT");
                b.a(this.d).a(this.d, b.C0035b.SOCKET_CLOSE, bundle);
            }
            if (!this.g) {
                int i2 = a + 1;
                e.b("PushLogAC2705", "channel is not Regist, tryConnectPushSevTimes add to " + i2);
                com.huawei.android.pushagent.b.b.c.a(this.d, new com.huawei.android.pushagent.a.a("tryConnectPushSevTimes", Integer.class, (Object) Integer.valueOf(i2)));
                com.huawei.android.pushagent.b.b.c.a(this.d, new com.huawei.android.pushagent.a.a("lastConnectPushSrvMethodIdx", Integer.class, (Object) Integer.valueOf(a2)));
                return;
            }
            return;
        } else if (i == 4) {
            com.huawei.android.pushagent.a.b bVar = (com.huawei.android.pushagent.a.b) bundle.getSerializable("push_msg");
            if (bVar == null) {
                e.b("PushLogAC2705", "push_msg is null");
                return;
            }
            e.a("PushLogAC2705", "received pushSrv Msg:" + com.huawei.android.pushagent.c.a.a(bVar.a()));
            if (bVar.a() == -45 || bVar.a() == -33) {
                this.g = true;
                com.huawei.android.pushagent.b.b.c.a(this.d, new com.huawei.android.pushagent.a.a("lastConnectPushSrvMethodIdx", Integer.class, (Object) Integer.valueOf(b(a, a2))));
                com.huawei.android.pushagent.b.b.c.a(this.d, new com.huawei.android.pushagent.a.a("tryConnectPushSevTimes", Integer.class, (Object) 0));
            } else if ((bVar instanceof f) || (bVar instanceof k)) {
                com.huawei.android.pushagent.c.a.a.a(this.d, "com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT");
                this.e.c(false);
            }
            this.e.a();
            Intent intent2 = new Intent("com.huawei.android.push.intent.MSG_RECEIVED");
            intent2.putExtra("push_msg", bVar);
            PushService.a(intent2);
            return;
        } else {
            return;
        }
        PushService.a(intent);
    }

    public synchronized void a(boolean z) throws com.huawei.android.pushagent.a.c {
        a(z, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0173, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(boolean r9, boolean r10) throws com.huawei.android.pushagent.a.c {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018a }
            r1.<init>()     // Catch:{ Exception -> 0x018a }
            java.lang.String r2 = "enter PushConnectEntity:connect(isForceToConnPushSrv:"
            r1.append(r2)     // Catch:{ Exception -> 0x018a }
            r1.append(r9)     // Catch:{ Exception -> 0x018a }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ Exception -> 0x018a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.c.a.e.a(r0, r1)     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a.b r0 = r8.e     // Catch:{ Exception -> 0x018a }
            r0.b()     // Catch:{ Exception -> 0x018a }
            android.content.Context r0 = r8.d     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.b.a r0 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r0)     // Catch:{ Exception -> 0x018a }
            boolean r0 = r0.V()     // Catch:{ Exception -> 0x018a }
            if (r0 != 0) goto L_0x002f
            monitor-exit(r8)
            return
        L_0x002f:
            android.content.Context r0 = r8.d     // Catch:{ Exception -> 0x018a }
            int r0 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r0)     // Catch:{ Exception -> 0x018a }
            r1 = -1
            if (r0 != r1) goto L_0x0041
            java.lang.String r9 = "PushLogAC2705"
            java.lang.String r10 = "no network, so cannot connect"
            com.huawei.android.pushagent.c.a.e.d(r9, r10)     // Catch:{ Exception -> 0x018a }
            monitor-exit(r8)
            return
        L_0x0041:
            android.content.Context r0 = r8.d     // Catch:{ Exception -> 0x018a }
            java.lang.String r1 = "cloudpush_isNoDelayConnect"
            r2 = 0
            boolean r0 = com.huawei.android.pushagent.b.b.c.a((android.content.Context) r0, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x018a }
            r1 = 1
            if (r0 == 0) goto L_0x004e
            r9 = 1
        L_0x004e:
            boolean r0 = r8.a()     // Catch:{ Exception -> 0x018a }
            if (r0 == 0) goto L_0x0080
            if (r9 == 0) goto L_0x0077
            java.lang.String r10 = "PushLogAC2705"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018a }
            r0.<init>()     // Catch:{ Exception -> 0x018a }
            java.lang.String r1 = "hasConnect, but isForceToConnPushSrv:"
            r0.append(r1)     // Catch:{ Exception -> 0x018a }
            r0.append(r9)     // Catch:{ Exception -> 0x018a }
            java.lang.String r9 = ", so send heartBeat"
            r0.append(r9)     // Catch:{ Exception -> 0x018a }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.c.a.e.a(r10, r9)     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a.b r9 = r8.e     // Catch:{ Exception -> 0x018a }
            r9.g()     // Catch:{ Exception -> 0x018a }
            goto L_0x007e
        L_0x0077:
            java.lang.String r9 = "PushLogAC2705"
            java.lang.String r10 = "aready connect, need not connect more"
            com.huawei.android.pushagent.c.a.e.a(r9, r10)     // Catch:{ Exception -> 0x018a }
        L_0x007e:
            monitor-exit(r8)
            return
        L_0x0080:
            android.content.Context r0 = r8.d     // Catch:{ Exception -> 0x018a }
            java.lang.String r3 = "tryConnectPushSevTimes"
            int r0 = com.huawei.android.pushagent.b.b.c.a((android.content.Context) r0, (java.lang.String) r3, (int) r2)     // Catch:{ Exception -> 0x018a }
            android.content.Context r3 = r8.d     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.d.b r3 = com.huawei.android.pushagent.b.d.b.a(r3)     // Catch:{ Exception -> 0x018a }
            android.content.Context r4 = r8.d     // Catch:{ Exception -> 0x018a }
            long r3 = r3.b(r4)     // Catch:{ Exception -> 0x018a }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x017d
            java.lang.String r3 = "PushLogAC2705"
            java.lang.String r4 = "no limit to connect pushsvr"
            com.huawei.android.pushagent.c.a.e.a(r3, r4)     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a.c r3 = r8.b     // Catch:{ Exception -> 0x018a }
            if (r3 == 0) goto L_0x00b7
            com.huawei.android.pushagent.b.a.a.c r3 = r8.b     // Catch:{ Exception -> 0x018a }
            boolean r3 = r3.isAlive()     // Catch:{ Exception -> 0x018a }
            if (r3 != 0) goto L_0x00ae
            goto L_0x00b7
        L_0x00ae:
            java.lang.String r9 = "PushLogAC2705"
            java.lang.String r10 = "It is in connecting..."
            com.huawei.android.pushagent.c.a.e.b(r9, r10)     // Catch:{ Exception -> 0x018a }
            goto L_0x0172
        L_0x00b7:
            java.lang.String r3 = "PushLogAC2705"
            java.lang.String r4 = "begin to create new socket, so close socket"
            com.huawei.android.pushagent.c.a.e.a(r3, r4)     // Catch:{ Exception -> 0x018a }
            r8.b()     // Catch:{ Exception -> 0x018a }
            r8.d()     // Catch:{ Exception -> 0x018a }
            java.lang.String r3 = "PushLogAC2705"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018a }
            r4.<init>()     // Catch:{ Exception -> 0x018a }
            java.lang.String r5 = "IS_NODELAY_CONNECT:"
            r4.append(r5)     // Catch:{ Exception -> 0x018a }
            android.content.Context r5 = r8.d     // Catch:{ Exception -> 0x018a }
            java.lang.String r6 = "cloudpush_isNoDelayConnect"
            boolean r5 = com.huawei.android.pushagent.b.b.c.a((android.content.Context) r5, (java.lang.String) r6, (boolean) r2)     // Catch:{ Exception -> 0x018a }
            r4.append(r5)     // Catch:{ Exception -> 0x018a }
            java.lang.String r5 = " hasMsg:"
            r4.append(r5)     // Catch:{ Exception -> 0x018a }
            r4.append(r10)     // Catch:{ Exception -> 0x018a }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.c.a.e.a(r3, r4)     // Catch:{ Exception -> 0x018a }
            android.content.Context r3 = r8.d     // Catch:{ Exception -> 0x018a }
            java.lang.String r4 = "cloudpush_isNoDelayConnect"
            boolean r3 = com.huawei.android.pushagent.b.b.c.a((android.content.Context) r3, (java.lang.String) r4, (boolean) r2)     // Catch:{ Exception -> 0x018a }
            if (r3 != 0) goto L_0x0116
            if (r10 != 0) goto L_0x0116
            android.content.Context r10 = r8.d     // Catch:{ Exception -> 0x018a }
            boolean r10 = com.huawei.android.pushagent.b.d.a.a((android.content.Context) r10, (int) r1)     // Catch:{ Exception -> 0x018a }
            if (r10 != 0) goto L_0x0116
            android.content.Context r9 = r8.d     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a r9 = com.huawei.android.pushagent.b.a.a.a((android.content.Context) r9)     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a$a r10 = com.huawei.android.pushagent.b.a.a.C0032a.ConnectEntity_Polling     // Catch:{ Exception -> 0x018a }
            r9.a((com.huawei.android.pushagent.b.a.a.C0032a) r10)     // Catch:{ Exception -> 0x018a }
            android.content.Context r9 = r8.d     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a r9 = com.huawei.android.pushagent.b.a.a.a((android.content.Context) r9)     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a$a r10 = com.huawei.android.pushagent.b.a.a.C0032a.ConnectEntity_Polling     // Catch:{ Exception -> 0x018a }
            r9.a(r10, r2)     // Catch:{ Exception -> 0x018a }
            monitor-exit(r8)
            return
        L_0x0116:
            r8.g = r2     // Catch:{ Exception -> 0x018a }
            android.content.Context r10 = r8.d     // Catch:{ Exception -> 0x018a }
            java.lang.String r1 = "lastConnectPushSrvMethodIdx"
            int r10 = com.huawei.android.pushagent.b.b.c.a((android.content.Context) r10, (java.lang.String) r1, (int) r2)     // Catch:{ Exception -> 0x018a }
            android.content.Context r1 = r8.d     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.b.a r1 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r1)     // Catch:{ Exception -> 0x018a }
            java.net.InetSocketAddress r9 = r1.a((boolean) r9)     // Catch:{ Exception -> 0x018a }
            if (r9 == 0) goto L_0x0174
            java.lang.String r1 = "PushLogAC2705"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018a }
            r2.<init>()     // Catch:{ Exception -> 0x018a }
            java.lang.String r3 = "get pushSrvAddr:"
            r2.append(r3)     // Catch:{ Exception -> 0x018a }
            r2.append(r9)     // Catch:{ Exception -> 0x018a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.c.a.e.a(r1, r2)     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.a.d r1 = r8.a     // Catch:{ Exception -> 0x018a }
            java.net.InetAddress r2 = r9.getAddress()     // Catch:{ Exception -> 0x018a }
            java.lang.String r2 = r2.getHostAddress()     // Catch:{ Exception -> 0x018a }
            r1.a = r2     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.a.d r1 = r8.a     // Catch:{ Exception -> 0x018a }
            int r9 = r9.getPort()     // Catch:{ Exception -> 0x018a }
            r1.b = r9     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.a.d r9 = r8.a     // Catch:{ Exception -> 0x018a }
            android.content.Context r1 = r8.d     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.b.b$a r1 = com.huawei.android.pushagent.b.b.c.b(r1)     // Catch:{ Exception -> 0x018a }
            r9.c = r1     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.a.d r9 = r8.a((int) r10, (int) r0)     // Catch:{ Exception -> 0x018a }
            r8.a = r9     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a.b.c r9 = new com.huawei.android.pushagent.b.a.a.b.c     // Catch:{ Exception -> 0x018a }
            r9.<init>(r8)     // Catch:{ Exception -> 0x018a }
            r8.b = r9     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a.c r9 = r8.b     // Catch:{ Exception -> 0x018a }
            r9.start()     // Catch:{ Exception -> 0x018a }
        L_0x0172:
            monitor-exit(r8)
            return
        L_0x0174:
            java.lang.String r9 = "PushLogAC2705"
            java.lang.String r10 = "no valid pushSrvAddr, just wait!!"
            com.huawei.android.pushagent.c.a.e.a(r9, r10)     // Catch:{ Exception -> 0x018a }
            monitor-exit(r8)
            return
        L_0x017d:
            android.content.Context r9 = r8.d     // Catch:{ Exception -> 0x018a }
            com.huawei.android.pushagent.b.a.a r9 = com.huawei.android.pushagent.b.a.a.a((android.content.Context) r9)     // Catch:{ Exception -> 0x018a }
            r9.a((long) r3)     // Catch:{ Exception -> 0x018a }
            monitor-exit(r8)
            return
        L_0x0188:
            r9 = move-exception
            goto L_0x0191
        L_0x018a:
            r9 = move-exception
            com.huawei.android.pushagent.a.c r10 = new com.huawei.android.pushagent.a.c     // Catch:{ all -> 0x0188 }
            r10.<init>((java.lang.Throwable) r9)     // Catch:{ all -> 0x0188 }
            throw r10     // Catch:{ all -> 0x0188 }
        L_0x0191:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.b.a.a(boolean, boolean):void");
    }

    public a.C0032a e() {
        return a.C0032a.ConnectEntity_Push;
    }

    public boolean f() {
        if (this.a != null) {
            return true;
        }
        this.a = new d("", -1, false, com.huawei.android.pushagent.b.b.c.b(this.d));
        return true;
    }
}
