package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.d;
import com.xiaomi.push.service.y;
import com.xiaomi.smack.p;
import com.xiaomi.smack.packet.f;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.s;
import com.xiaomi.xmpush.thrift.t;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XMPushService extends Service implements com.xiaomi.smack.d {
    public static int a = 1;
    /* access modifiers changed from: private */
    public static final int f = Process.myPid();
    /* access modifiers changed from: private */
    public com.xiaomi.smack.b b;
    private af c;
    private d d;
    private long e = 0;
    /* access modifiers changed from: private */
    public com.xiaomi.smack.l g;
    /* access modifiers changed from: private */
    public com.xiaomi.smack.a h;
    private b i;
    /* access modifiers changed from: private */
    public PacketSync j = null;
    /* access modifiers changed from: private */
    public d k = null;
    private com.xiaomi.smack.f l = new aj(this);

    class a extends g {
        y.b b = null;

        public a(y.b bVar) {
            super(9);
            this.b = bVar;
        }

        public void a() {
            String str;
            try {
                if (!XMPushService.this.e()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                y.b b2 = y.a().b(this.b.h, this.b.b);
                if (b2 == null) {
                    str = "ignore bind because the channel " + this.b.h + " is removed ";
                } else if (b2.m == y.c.unbind) {
                    b2.a(y.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.h.a(b2);
                    com.xiaomi.stats.h.a(XMPushService.this, b2);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + b2.m;
                }
                com.xiaomi.channel.commonutils.logger.b.a(str);
            } catch (p e) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                XMPushService.this.a(10, (Exception) e);
            }
        }

        public String b() {
            return "bind the client. " + this.b.h;
        }
    }

    static class b extends g {
        private final y.b b;

        public b(y.b bVar) {
            super(12);
            this.b = bVar;
        }

        public void a() {
            this.b.a(y.c.unbind, 1, 21, (String) null, (String) null);
        }

        public String b() {
            return "bind time out. chid=" + this.b.h;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return TextUtils.equals(((b) obj).b.h, this.b.h);
        }

        public int hashCode() {
            return this.b.h.hashCode();
        }
    }

    public class c extends g {
        c() {
            super(1);
        }

        public void a() {
            if (XMPushService.this.a()) {
                XMPushService.this.o();
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("should not connect. quit the job.");
            }
        }

        public String b() {
            return "do reconnect..";
        }
    }

    class d extends BroadcastReceiver {
        d() {
        }

        public void onReceive(Context context, Intent intent) {
            XMPushService.this.k();
        }
    }

    public class e extends g {
        public int b;
        public Exception c;

        e(int i, Exception exc) {
            super(2);
            this.b = i;
            this.c = exc;
        }

        public void a() {
            XMPushService.this.a(this.b, this.c);
        }

        public String b() {
            return "disconnect the connection.";
        }
    }

    class f extends g {
        private Intent c = null;

        public f(Intent intent) {
            super(15);
            this.c = intent;
        }

        public void a() {
            XMPushService.this.a(this.c);
        }

        public String b() {
            return "Handle intent action = " + this.c.getAction();
        }
    }

    public static abstract class g extends d.b {
        public g(int i) {
            super(i);
        }

        public abstract void a();

        public abstract String b();

        public void run() {
            if (!(this.a == 4 || this.a == 8)) {
                com.xiaomi.channel.commonutils.logger.b.a("JOB: " + b());
            }
            a();
        }
    }

    class h extends g {
        public h() {
            super(5);
        }

        public void a() {
            XMPushService.this.k.b();
        }

        public String b() {
            return "ask the job queue to quit";
        }
    }

    public class i extends Binder {
        public i() {
        }
    }

    class j extends g {
        private com.xiaomi.smack.packet.d c = null;

        public j(com.xiaomi.smack.packet.d dVar) {
            super(8);
            this.c = dVar;
        }

        public void a() {
            XMPushService.this.j.a(this.c);
        }

        public String b() {
            return "receive a message.";
        }
    }

    class k extends g {
        public k() {
            super(4);
        }

        public void a() {
            if (XMPushService.this.e()) {
                try {
                    com.xiaomi.stats.h.a();
                    XMPushService.this.h.n();
                } catch (p e) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                    XMPushService.this.a(10, (Exception) e);
                }
            }
        }

        public String b() {
            return "send ping..";
        }
    }

    class l extends g {
        y.b b = null;

        public l(y.b bVar) {
            super(4);
            this.b = bVar;
        }

        public void a() {
            try {
                this.b.a(y.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.h.a(this.b.h, this.b.b);
                this.b.a(y.c.binding, 1, 16, (String) null, (String) null);
                XMPushService.this.h.a(this.b);
            } catch (p e) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                XMPushService.this.a(10, (Exception) e);
            }
        }

        public String b() {
            return "rebind the client. " + this.b.h;
        }
    }

    class m extends g {
        m() {
            super(3);
        }

        public void a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.a()) {
                XMPushService.this.o();
            }
        }

        public String b() {
            return "reset the connection.";
        }
    }

    class n extends g {
        y.b b = null;
        int c;
        String d;
        String e;

        public n(y.b bVar, int i, String str, String str2) {
            super(9);
            this.b = bVar;
            this.c = i;
            this.d = str;
            this.e = str2;
        }

        public void a() {
            if (!(this.b.m == y.c.unbind || XMPushService.this.h == null)) {
                try {
                    XMPushService.this.h.a(this.b.h, this.b.b);
                } catch (p e2) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                    XMPushService.this.a(10, (Exception) e2);
                }
            }
            this.b.a(y.c.unbind, this.c, 0, this.e, this.d);
        }

        public String b() {
            return "unbind the channel. " + this.b.h;
        }
    }

    static {
        HostManager.addReservedHost("app.chat.xiaomi.net", "app.chat.xiaomi.net");
        HostManager.addReservedHost("app.chat.xiaomi.net", "42.62.94.2:443");
        HostManager.addReservedHost("app.chat.xiaomi.net", "114.54.23.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.13.142.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.206.200.2");
        com.xiaomi.smack.l.a = true;
    }

    @TargetApi(11)
    public static Notification a(Context context) {
        Intent intent = new Intent(context, XMPushService.class);
        if (Build.VERSION.SDK_INT >= 11) {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setSmallIcon(context.getApplicationInfo().icon);
            builder.setContentTitle("Push Service");
            builder.setContentText("Push Service");
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
            return builder.getNotification();
        }
        Notification notification = new Notification();
        notification.setLatestEventInfo(context, "Push Service", "Push Service", PendingIntent.getService(context, 0, intent, 0));
        return notification;
    }

    public static com.xiaomi.smack.packet.c a(f fVar, Context context, com.xiaomi.xmpush.thrift.p pVar) {
        try {
            com.xiaomi.smack.packet.c cVar = new com.xiaomi.smack.packet.c();
            cVar.l("5");
            cVar.m("xiaomi.com");
            cVar.n(fVar.a);
            cVar.b(true);
            cVar.f("push");
            cVar.o(pVar.f);
            String str = fVar.a;
            pVar.g.b = str.substring(0, str.indexOf("@"));
            pVar.g.d = str.substring(str.indexOf("/") + 1);
            String valueOf = String.valueOf(com.xiaomi.channel.commonutils.string.a.a(ae.a(ae.a(fVar.c, cVar.k()), ae.a(pVar))));
            com.xiaomi.smack.packet.a aVar = new com.xiaomi.smack.packet.a(NotifyType.SOUND, (String) null, (String[]) null, (String[]) null);
            aVar.b(valueOf);
            cVar.a(aVar);
            com.xiaomi.channel.commonutils.logger.b.a("try send mi push message. packagename:" + pVar.f + " action:" + pVar.a);
            return cVar;
        } catch (NullPointerException e2) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
            return null;
        }
    }

    private com.xiaomi.smack.packet.c a(com.xiaomi.smack.packet.c cVar, String str) {
        byte[] a2 = ae.a(str, cVar.k());
        com.xiaomi.smack.packet.c cVar2 = new com.xiaomi.smack.packet.c();
        cVar2.n(cVar.n());
        cVar2.m(cVar.m());
        cVar2.k(cVar.k());
        cVar2.l(cVar.l());
        cVar2.b(true);
        String a3 = ae.a(a2, com.xiaomi.smack.util.g.c(cVar.a()));
        String[] strArr = null;
        com.xiaomi.smack.packet.a aVar = new com.xiaomi.smack.packet.a(NotifyType.SOUND, (String) null, strArr, strArr);
        aVar.b(a3);
        cVar2.a(aVar);
        return cVar2;
    }

    private com.xiaomi.smack.packet.d a(com.xiaomi.smack.packet.d dVar, String str, String str2, boolean z) {
        StringBuilder sb;
        String str3;
        y a2 = y.a();
        List<String> b2 = a2.b(str);
        if (b2.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            dVar.o(str);
            str = dVar.l();
            if (TextUtils.isEmpty(str)) {
                str = b2.get(0);
                dVar.l(str);
            }
            y.b b3 = a2.b(str, dVar.n());
            if (!e()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (b3 == null || b3.m != y.c.binded) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            } else if (TextUtils.equals(str2, b3.j)) {
                return (!(dVar instanceof com.xiaomi.smack.packet.c) || !z) ? dVar : a((com.xiaomi.smack.packet.c) dVar, b3.i);
            } else {
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
                return null;
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
        return null;
    }

    public static <T extends org.apache.thrift.a<T, ?>> com.xiaomi.xmpush.thrift.p a(String str, String str2, T t, com.xiaomi.xmpush.thrift.a aVar) {
        byte[] a2 = ae.a(t);
        com.xiaomi.xmpush.thrift.p pVar = new com.xiaomi.xmpush.thrift.p();
        com.xiaomi.xmpush.thrift.k kVar = new com.xiaomi.xmpush.thrift.k();
        kVar.a = 5;
        kVar.b = "fakeid";
        pVar.a(kVar);
        pVar.a(ByteBuffer.wrap(a2));
        pVar.a(aVar);
        pVar.c(true);
        pVar.b(str);
        pVar.a(false);
        pVar.a(str2);
        return pVar;
    }

    private String a(String str) {
        return "<iq id='0' chid='0' type='get'><ping>%1$s%2$s</ping></iq>";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: com.xiaomi.push.service.XMPushService$l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: com.xiaomi.push.service.XMPushService$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v22, resolved type: com.xiaomi.push.service.aq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v49, resolved type: com.xiaomi.push.service.XMPushService$m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v53, resolved type: com.xiaomi.push.service.ag} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v56, resolved type: com.xiaomi.push.service.ag} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v58, resolved type: com.xiaomi.push.service.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v67, resolved type: com.xiaomi.push.service.ap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v68, resolved type: com.xiaomi.push.service.ap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v69, resolved type: com.xiaomi.push.service.ap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v85, resolved type: com.xiaomi.push.service.ap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v70, resolved type: com.xiaomi.push.service.ap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v71, resolved type: com.xiaomi.push.service.ap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v72, resolved type: com.xiaomi.push.service.ap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v73, resolved type: com.xiaomi.push.service.ap} */
    /* JADX WARNING: type inference failed for: r12v14, types: [com.xiaomi.push.service.XMPushService$g] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Intent r12) {
        /*
            r11 = this;
            com.xiaomi.push.service.y r0 = com.xiaomi.push.service.y.a()
            java.lang.String r1 = com.xiaomi.push.service.aa.d
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x04a7
            java.lang.String r1 = com.xiaomi.push.service.aa.j
            java.lang.String r5 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x0021
            goto L_0x04a7
        L_0x0021:
            java.lang.String r1 = com.xiaomi.push.service.aa.i
            java.lang.String r5 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x008d
            java.lang.String r1 = com.xiaomi.push.service.aa.y
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r3 = com.xiaomi.push.service.aa.q
            java.lang.String r5 = r12.getStringExtra(r3)
            java.lang.String r3 = com.xiaomi.push.service.aa.p
            java.lang.String r6 = r12.getStringExtra(r3)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r3 = "Service called closechannel chid = "
            r12.append(r3)
            r12.append(r5)
            java.lang.String r3 = " userId = "
            r12.append(r3)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r12)
            boolean r12 = android.text.TextUtils.isEmpty(r5)
            if (r12 == 0) goto L_0x0079
            java.util.List r12 = r0.b(r1)
            java.util.Iterator r12 = r12.iterator()
        L_0x0069:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x051f
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            r11.a((java.lang.String) r0, (int) r2)
            goto L_0x0069
        L_0x0079:
            boolean r12 = android.text.TextUtils.isEmpty(r6)
            if (r12 == 0) goto L_0x0084
            r11.a((java.lang.String) r5, (int) r2)
            goto L_0x051f
        L_0x0084:
            r7 = 2
            r8 = 0
            r9 = 0
            r4 = r11
            r4.a(r5, r6, r7, r8, r9)
            goto L_0x051f
        L_0x008d:
            java.lang.String r1 = com.xiaomi.push.service.aa.e
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            java.lang.String r2 = "ext_encrypt"
            java.lang.String r5 = "ext_packet"
            if (r1 == 0) goto L_0x00c6
            java.lang.String r0 = com.xiaomi.push.service.aa.y
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.aa.B
            java.lang.String r1 = r12.getStringExtra(r1)
            android.os.Bundle r4 = r12.getBundleExtra(r5)
            boolean r12 = r12.getBooleanExtra(r2, r3)
            com.xiaomi.smack.packet.c r2 = new com.xiaomi.smack.packet.c
            r2.<init>(r4)
            com.xiaomi.smack.packet.d r12 = r11.a((com.xiaomi.smack.packet.d) r2, (java.lang.String) r0, (java.lang.String) r1, (boolean) r12)
            if (r12 == 0) goto L_0x051f
            com.xiaomi.push.service.ag r0 = new com.xiaomi.push.service.ag
            r0.<init>(r11, r12)
            r11.c((com.xiaomi.push.service.XMPushService.g) r0)
            goto L_0x051f
        L_0x00c6:
            java.lang.String r1 = com.xiaomi.push.service.aa.g
            java.lang.String r6 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r6)
            if (r1 == 0) goto L_0x0115
            java.lang.String r0 = com.xiaomi.push.service.aa.y
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.aa.B
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r5 = "ext_packets"
            android.os.Parcelable[] r5 = r12.getParcelableArrayExtra(r5)
            int r6 = r5.length
            com.xiaomi.smack.packet.c[] r6 = new com.xiaomi.smack.packet.c[r6]
            boolean r12 = r12.getBooleanExtra(r2, r3)
        L_0x00eb:
            int r2 = r5.length
            if (r4 >= r2) goto L_0x010b
            com.xiaomi.smack.packet.c r2 = new com.xiaomi.smack.packet.c
            r3 = r5[r4]
            android.os.Bundle r3 = (android.os.Bundle) r3
            r2.<init>(r3)
            r6[r4] = r2
            r2 = r6[r4]
            com.xiaomi.smack.packet.d r2 = r11.a((com.xiaomi.smack.packet.d) r2, (java.lang.String) r0, (java.lang.String) r1, (boolean) r12)
            com.xiaomi.smack.packet.c r2 = (com.xiaomi.smack.packet.c) r2
            r6[r4] = r2
            r2 = r6[r4]
            if (r2 != 0) goto L_0x0108
            return
        L_0x0108:
            int r4 = r4 + 1
            goto L_0x00eb
        L_0x010b:
            com.xiaomi.push.service.a r12 = new com.xiaomi.push.service.a
            r12.<init>(r11, r6)
        L_0x0110:
            r11.c((com.xiaomi.push.service.XMPushService.g) r12)
            goto L_0x051f
        L_0x0115:
            java.lang.String r1 = com.xiaomi.push.service.aa.f
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x0142
            java.lang.String r0 = com.xiaomi.push.service.aa.y
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.aa.B
            java.lang.String r1 = r12.getStringExtra(r1)
            android.os.Bundle r12 = r12.getBundleExtra(r5)
            com.xiaomi.smack.packet.b r2 = new com.xiaomi.smack.packet.b
            r2.<init>(r12)
            com.xiaomi.smack.packet.d r12 = r11.a((com.xiaomi.smack.packet.d) r2, (java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r12 == 0) goto L_0x051f
            com.xiaomi.push.service.ag r12 = new com.xiaomi.push.service.ag
            r12.<init>(r11, r2)
            goto L_0x0110
        L_0x0142:
            java.lang.String r1 = com.xiaomi.push.service.aa.h
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x016f
            java.lang.String r0 = com.xiaomi.push.service.aa.y
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.aa.B
            java.lang.String r1 = r12.getStringExtra(r1)
            android.os.Bundle r12 = r12.getBundleExtra(r5)
            com.xiaomi.smack.packet.f r2 = new com.xiaomi.smack.packet.f
            r2.<init>((android.os.Bundle) r12)
            com.xiaomi.smack.packet.d r12 = r11.a((com.xiaomi.smack.packet.d) r2, (java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r12 == 0) goto L_0x051f
            com.xiaomi.push.service.ag r12 = new com.xiaomi.push.service.ag
            r12.<init>(r11, r2)
            goto L_0x0110
        L_0x016f:
            java.lang.String r1 = com.xiaomi.push.service.aa.k
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01d5
            java.lang.String r0 = com.xiaomi.push.service.aa.q
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.aa.p
            java.lang.String r1 = r12.getStringExtra(r1)
            if (r0 == 0) goto L_0x051f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "request reset connection from chid = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r2)
            com.xiaomi.push.service.y r2 = com.xiaomi.push.service.y.a()
            com.xiaomi.push.service.y$b r0 = r2.b(r0, r1)
            if (r0 == 0) goto L_0x051f
            java.lang.String r1 = r0.i
            java.lang.String r2 = com.xiaomi.push.service.aa.u
            java.lang.String r12 = r12.getStringExtra(r2)
            boolean r12 = r1.equals(r12)
            if (r12 == 0) goto L_0x051f
            com.xiaomi.push.service.y$c r12 = r0.m
            com.xiaomi.push.service.y$c r0 = com.xiaomi.push.service.y.c.binded
            if (r12 != r0) goto L_0x051f
            com.xiaomi.smack.a r12 = r11.g()
            if (r12 == 0) goto L_0x01ce
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 15000(0x3a98, double:7.411E-320)
            long r0 = r0 - r2
            boolean r12 = r12.a((long) r0)
            if (r12 != 0) goto L_0x051f
        L_0x01ce:
            com.xiaomi.push.service.XMPushService$m r12 = new com.xiaomi.push.service.XMPushService$m
            r12.<init>()
            goto L_0x0110
        L_0x01d5:
            java.lang.String r1 = com.xiaomi.push.service.aa.l
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L_0x0265
            java.lang.String r1 = com.xiaomi.push.service.aa.y
            java.lang.String r1 = r12.getStringExtra(r1)
            java.util.List r3 = r0.b(r1)
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x0207
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "open channel should be called first before update info, pkg="
            r12.append(r0)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
        L_0x0203:
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r12)
            return
        L_0x0207:
            java.lang.String r1 = com.xiaomi.push.service.aa.q
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r5 = com.xiaomi.push.service.aa.p
            java.lang.String r5 = r12.getStringExtra(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto L_0x021f
            java.lang.Object r1 = r3.get(r4)
            java.lang.String r1 = (java.lang.String) r1
        L_0x021f:
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 == 0) goto L_0x023d
            java.util.Collection r0 = r0.c(r1)
            if (r0 == 0) goto L_0x0241
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0241
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            r2 = r0
            com.xiaomi.push.service.y$b r2 = (com.xiaomi.push.service.y.b) r2
            goto L_0x0241
        L_0x023d:
            com.xiaomi.push.service.y$b r2 = r0.b(r1, r5)
        L_0x0241:
            if (r2 == 0) goto L_0x051f
            java.lang.String r0 = com.xiaomi.push.service.aa.w
            boolean r0 = r12.hasExtra(r0)
            if (r0 == 0) goto L_0x0253
            java.lang.String r0 = com.xiaomi.push.service.aa.w
            java.lang.String r0 = r12.getStringExtra(r0)
            r2.f = r0
        L_0x0253:
            java.lang.String r0 = com.xiaomi.push.service.aa.x
            boolean r0 = r12.hasExtra(r0)
            if (r0 == 0) goto L_0x051f
            java.lang.String r0 = com.xiaomi.push.service.aa.x
            java.lang.String r12 = r12.getStringExtra(r0)
            r2.g = r12
            goto L_0x051f
        L_0x0265:
            java.lang.String r0 = r12.getAction()
            java.lang.String r1 = "com.xiaomi.mipush.REGISTER_APP"
            boolean r0 = r1.equals(r0)
            java.lang.String r1 = "mipush_payload"
            java.lang.String r5 = "mipush_app_package"
            if (r0 == 0) goto L_0x02e2
            android.content.Context r0 = r11.getApplicationContext()
            com.xiaomi.push.service.ac r0 = com.xiaomi.push.service.ac.a(r0)
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x02a8
            android.content.Context r0 = r11.getApplicationContext()
            com.xiaomi.push.service.ac r0 = com.xiaomi.push.service.ac.a(r0)
            int r0 = r0.b()
            if (r0 != 0) goto L_0x02a8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "register without being provisioned. "
            r0.append(r1)
            java.lang.String r12 = r12.getStringExtra(r5)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            goto L_0x0203
        L_0x02a8:
            byte[] r6 = r12.getByteArrayExtra(r1)
            java.lang.String r5 = r12.getStringExtra(r5)
            java.lang.String r0 = "mipush_env_chanage"
            boolean r0 = r12.getBooleanExtra(r0, r4)
            java.lang.String r1 = "mipush_env_type"
            int r3 = r12.getIntExtra(r1, r3)
            com.xiaomi.push.service.h r12 = com.xiaomi.push.service.h.a((android.content.Context) r11)
            r12.c(r5)
            if (r0 == 0) goto L_0x02dd
            java.lang.String r12 = r11.getPackageName()
            java.lang.String r0 = "com.xiaomi.xmsf"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x02dd
            com.xiaomi.push.service.ap r12 = new com.xiaomi.push.service.ap
            r2 = 14
            r0 = r12
            r1 = r11
            r4 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0110
        L_0x02dd:
            r11.a((byte[]) r6, (java.lang.String) r5)
            goto L_0x051f
        L_0x02e2:
            java.lang.String r0 = r12.getAction()
            java.lang.String r6 = "com.xiaomi.mipush.SEND_MESSAGE"
            boolean r0 = r6.equals(r0)
            java.lang.String r6 = "com.xiaomi.mipush.UNREGISTER_APP"
            if (r0 != 0) goto L_0x0456
            java.lang.String r0 = r12.getAction()
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x02fc
            goto L_0x0456
        L_0x02fc:
            java.lang.String r0 = com.xiaomi.push.service.ad.a
            java.lang.String r1 = r12.getAction()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x03ba
            java.lang.String r0 = "uninstall_pkg_name"
            java.lang.String r12 = r12.getStringExtra(r0)
            if (r12 == 0) goto L_0x03b9
            java.lang.String r0 = r12.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x031c
            goto L_0x03b9
        L_0x031c:
            android.content.pm.PackageManager r0 = r11.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0326 }
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.getPackageInfo(r12, r1)     // Catch:{ NameNotFoundException -> 0x0326 }
            r3 = 0
        L_0x0326:
            java.lang.String r0 = "com.xiaomi.channel"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0347
            com.xiaomi.push.service.y r0 = com.xiaomi.push.service.y.a()
            java.lang.String r1 = "1"
            java.util.Collection r0 = r0.c(r1)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0347
            if (r3 == 0) goto L_0x0347
            r11.a((java.lang.String) r1, (int) r4)
            java.lang.String r12 = "close the miliao channel as the app is uninstalled."
            goto L_0x0203
        L_0x0347:
            java.lang.String r0 = "pref_registered_pkg_names"
            android.content.SharedPreferences r0 = r11.getSharedPreferences(r0, r4)
            java.lang.String r1 = r0.getString(r12, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x051f
            if (r3 == 0) goto L_0x051f
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.remove(r12)
            r0.commit()
            boolean r0 = com.xiaomi.push.service.r.e(r11, r12)
            if (r0 == 0) goto L_0x036c
            com.xiaomi.push.service.r.d(r11, r12)
        L_0x036c:
            com.xiaomi.push.service.r.b(r11, r12)
            boolean r0 = r11.e()
            if (r0 == 0) goto L_0x051f
            if (r1 == 0) goto L_0x051f
            com.xiaomi.xmpush.thrift.p r0 = r11.a((java.lang.String) r12, (java.lang.String) r1)     // Catch:{ p -> 0x0399 }
            r11.a((com.xiaomi.xmpush.thrift.p) r0)     // Catch:{ p -> 0x0399 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ p -> 0x0399 }
            r0.<init>()     // Catch:{ p -> 0x0399 }
            java.lang.String r1 = "uninstall "
            r0.append(r1)     // Catch:{ p -> 0x0399 }
            r0.append(r12)     // Catch:{ p -> 0x0399 }
            java.lang.String r12 = " msg sent"
            r0.append(r12)     // Catch:{ p -> 0x0399 }
            java.lang.String r12 = r0.toString()     // Catch:{ p -> 0x0399 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r12)     // Catch:{ p -> 0x0399 }
            goto L_0x051f
        L_0x0399:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Fail to send Message: "
            r0.append(r1)
            java.lang.String r1 = r12.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            r0 = 10
            r11.a((int) r0, (java.lang.Exception) r12)
            goto L_0x051f
        L_0x03b9:
            return
        L_0x03ba:
            java.lang.String r0 = r12.getAction()
            java.lang.String r1 = "com.xiaomi.mipush.CLEAR_NOTIFICATION"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x03e7
            java.lang.String r0 = com.xiaomi.push.service.aa.y
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.aa.z
            int r12 = r12.getIntExtra(r1, r4)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x051f
            if (r12 < 0) goto L_0x03df
            com.xiaomi.push.service.r.a((android.content.Context) r11, (java.lang.String) r0, (int) r12)
            goto L_0x051f
        L_0x03df:
            r1 = -1
            if (r12 != r1) goto L_0x051f
            com.xiaomi.push.service.r.b(r11, r0)
            goto L_0x051f
        L_0x03e7:
            java.lang.String r0 = r12.getAction()
            java.lang.String r1 = "com.xiaomi.mipush.SET_NOTIFICATION_TYPE"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x051f
            java.lang.String r0 = com.xiaomi.push.service.aa.y
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.aa.C
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.aa.A
            boolean r2 = r12.hasExtra(r2)
            if (r2 == 0) goto L_0x0422
            java.lang.String r2 = com.xiaomi.push.service.aa.A
            int r12 = r12.getIntExtra(r2, r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.xiaomi.channel.commonutils.string.c.b(r2)
            r3 = 0
            goto L_0x0427
        L_0x0422:
            java.lang.String r2 = com.xiaomi.channel.commonutils.string.c.b(r0)
            r12 = 0
        L_0x0427:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x0440
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x0434
            goto L_0x0440
        L_0x0434:
            if (r3 == 0) goto L_0x043b
            com.xiaomi.push.service.r.d(r11, r0)
            goto L_0x051f
        L_0x043b:
            com.xiaomi.push.service.r.b((android.content.Context) r11, (java.lang.String) r0, (int) r12)
            goto L_0x051f
        L_0x0440:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "invalid notification for "
            r12.append(r1)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
        L_0x0451:
            com.xiaomi.channel.commonutils.logger.b.d(r12)
            goto L_0x051f
        L_0x0456:
            java.lang.String r0 = r12.getStringExtra(r5)
            byte[] r1 = r12.getByteArrayExtra(r1)
            java.lang.String r2 = "com.xiaomi.mipush.MESSAGE_CACHE"
            boolean r2 = r12.getBooleanExtra(r2, r3)
            com.xiaomi.push.service.y r3 = com.xiaomi.push.service.y.a()
            java.lang.String r4 = "5"
            java.util.Collection r3 = r3.c(r4)
            java.lang.String r12 = r12.getAction()
            boolean r12 = r6.equals(r12)
            if (r12 == 0) goto L_0x047f
            com.xiaomi.push.service.h r12 = com.xiaomi.push.service.h.a((android.content.Context) r11)
            r12.b(r0)
        L_0x047f:
            boolean r12 = r3.isEmpty()
            if (r12 == 0) goto L_0x048c
            if (r2 == 0) goto L_0x051f
        L_0x0487:
            com.xiaomi.push.service.j.b(r0, r1)
            goto L_0x051f
        L_0x048c:
            java.util.Iterator r12 = r3.iterator()
            java.lang.Object r12 = r12.next()
            com.xiaomi.push.service.y$b r12 = (com.xiaomi.push.service.y.b) r12
            com.xiaomi.push.service.y$c r12 = r12.m
            com.xiaomi.push.service.y$c r3 = com.xiaomi.push.service.y.c.binded
            if (r12 == r3) goto L_0x049f
            if (r2 == 0) goto L_0x051f
            goto L_0x0487
        L_0x049f:
            com.xiaomi.push.service.aq r12 = new com.xiaomi.push.service.aq
            r2 = 4
            r12.<init>(r11, r2, r0, r1)
            goto L_0x0110
        L_0x04a7:
            java.lang.String r0 = com.xiaomi.push.service.aa.q
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.aa.u
            java.lang.String r1 = r12.getStringExtra(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x04bc
            java.lang.String r12 = "security is empty. ignore."
            goto L_0x0508
        L_0x04bc:
            if (r0 == 0) goto L_0x051b
            boolean r1 = r11.a((java.lang.String) r0, (android.content.Intent) r12)
            com.xiaomi.push.service.y$b r7 = r11.b(r0, r12)
            boolean r12 = com.xiaomi.channel.commonutils.network.d.d(r11)
            if (r12 != 0) goto L_0x04d6
            com.xiaomi.push.service.b r5 = r11.i
            r8 = 0
            r9 = 2
        L_0x04d0:
            r10 = 0
            r6 = r11
            r5.a(r6, r7, r8, r9, r10)
            goto L_0x051f
        L_0x04d6:
            boolean r12 = r11.e()
            if (r12 == 0) goto L_0x0517
            com.xiaomi.push.service.y$c r12 = r7.m
            com.xiaomi.push.service.y$c r0 = com.xiaomi.push.service.y.c.unbind
            if (r12 != r0) goto L_0x04e9
            com.xiaomi.push.service.XMPushService$a r12 = new com.xiaomi.push.service.XMPushService$a
            r12.<init>(r7)
            goto L_0x0110
        L_0x04e9:
            if (r1 == 0) goto L_0x04f2
            com.xiaomi.push.service.XMPushService$l r12 = new com.xiaomi.push.service.XMPushService$l
            r12.<init>(r7)
            goto L_0x0110
        L_0x04f2:
            com.xiaomi.push.service.y$c r12 = r7.m
            com.xiaomi.push.service.y$c r0 = com.xiaomi.push.service.y.c.binding
            if (r12 != r0) goto L_0x050c
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.String r0 = r7.h
            r12[r4] = r0
            java.lang.String r0 = r7.b
            r12[r3] = r0
            java.lang.String r0 = "the client is binding. %1$s %2$s."
            java.lang.String r12 = java.lang.String.format(r0, r12)
        L_0x0508:
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r12)
            goto L_0x051f
        L_0x050c:
            com.xiaomi.push.service.y$c r12 = r7.m
            com.xiaomi.push.service.y$c r0 = com.xiaomi.push.service.y.c.binded
            if (r12 != r0) goto L_0x051f
            com.xiaomi.push.service.b r5 = r11.i
            r8 = 1
            r9 = 0
            goto L_0x04d0
        L_0x0517:
            r11.a((boolean) r3)
            goto L_0x051f
        L_0x051b:
            java.lang.String r12 = "channel id is empty, do nothing!"
            goto L_0x0451
        L_0x051f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.a(android.content.Intent):void");
    }

    private void a(String str, int i2) {
        Collection<y.b> c2 = y.a().c(str);
        if (c2 != null) {
            for (y.b next : c2) {
                if (next != null) {
                    a((g) new n(next, i2, (String) null, (String) null));
                }
            }
        }
        y.a().a(str);
    }

    private boolean a(String str, Intent intent) {
        y.b b2 = y.a().b(str, intent.getStringExtra(aa.p));
        boolean z = false;
        if (b2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(aa.B);
        String stringExtra2 = intent.getStringExtra(aa.u);
        if (!TextUtils.isEmpty(b2.j) && !TextUtils.equals(stringExtra, b2.j)) {
            com.xiaomi.channel.commonutils.logger.b.a("session changed. old session=" + b2.j + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(b2.i)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.a("security changed. chid = " + str + " sechash = " + com.xiaomi.channel.commonutils.string.c.a(stringExtra2));
        return true;
    }

    private y.b b(String str, Intent intent) {
        y.b b2 = y.a().b(str, intent.getStringExtra(aa.p));
        if (b2 == null) {
            b2 = new y.b(this);
        }
        b2.h = intent.getStringExtra(aa.q);
        b2.b = intent.getStringExtra(aa.p);
        b2.c = intent.getStringExtra(aa.s);
        b2.a = intent.getStringExtra(aa.y);
        b2.f = intent.getStringExtra(aa.w);
        b2.g = intent.getStringExtra(aa.x);
        b2.e = intent.getBooleanExtra(aa.v, false);
        b2.i = intent.getStringExtra(aa.u);
        b2.j = intent.getStringExtra(aa.B);
        b2.d = intent.getStringExtra(aa.t);
        b2.k = this.i;
        b2.l = getApplicationContext();
        y.a().a(b2);
        return b2;
    }

    private void c(g gVar) {
        this.k.a((d.b) gVar);
    }

    /* access modifiers changed from: private */
    public void j() {
        if (g.a(getApplicationContext()) != null) {
            y.b a2 = g.a(getApplicationContext()).a(this);
            a(a2);
            y.a().a(a2);
            if (com.xiaomi.channel.commonutils.network.d.d(getApplicationContext())) {
                a(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        NetworkInfo networkInfo;
        String str;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
            networkInfo = null;
        }
        if (networkInfo != null) {
            str = "network changed, " + networkInfo.toString();
        } else {
            str = "network changed, no active network";
        }
        com.xiaomi.channel.commonutils.logger.b.a(str);
        if (com.xiaomi.stats.f.b() != null) {
            com.xiaomi.stats.f.b().b();
        }
        this.g.r();
        if (com.xiaomi.channel.commonutils.network.d.d(this)) {
            if (e() && l()) {
                m();
            }
            if (!e() && !f()) {
                this.k.b(1);
                a((g) new c());
            }
            com.xiaomi.push.log.b.a((Context) this).a();
        } else {
            a((g) new e(2, (Exception) null));
        }
        n();
    }

    private boolean l() {
        if (System.currentTimeMillis() - this.e < 30000) {
            return false;
        }
        return com.xiaomi.channel.commonutils.network.d.e(this);
    }

    private void m() {
        this.e = System.currentTimeMillis();
        if (this.k.d()) {
            com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
            y.a().a((Context) this, 14);
            stopSelf();
            return;
        }
        if (e()) {
            if (this.h.q() || com.xiaomi.channel.commonutils.network.d.f(this)) {
                a((g) new k());
                return;
            }
            a((g) new e(17, (Exception) null));
        }
        a(true);
    }

    /* access modifiers changed from: private */
    public void n() {
        if (!a()) {
            com.xiaomi.push.service.timers.a.a();
        } else if (!com.xiaomi.push.service.timers.a.b()) {
            com.xiaomi.push.service.timers.a.a(true);
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        String str;
        com.xiaomi.smack.a aVar = this.h;
        if (aVar == null || !aVar.h()) {
            com.xiaomi.smack.a aVar2 = this.h;
            if (aVar2 == null || !aVar2.i()) {
                this.b.b(com.xiaomi.channel.commonutils.network.d.g(this));
                p();
                if (this.h == null) {
                    y.a().a((Context) this);
                }
                try {
                    if (com.xiaomi.channel.commonutils.android.i.d()) {
                        sendBroadcast(this.h == null ? new Intent("miui.intent.action.NETWORK_BLOCKED") : new Intent("miui.intent.action.NETWORK_CONNECTED"));
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                    return;
                }
            } else {
                str = "try to connect while is connected.";
            }
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
    }

    private void p() {
        try {
            this.g.a(this.l, (com.xiaomi.smack.filter.a) new at(this));
            this.g.t();
            this.h = this.g;
        } catch (p e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create xmpp connection", (Throwable) e2);
            this.g.a(new com.xiaomi.smack.packet.f(f.b.unavailable), 3, (Exception) e2);
        }
    }

    private boolean q() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return v.a((Context) this).a(com.xiaomi.xmpush.thrift.b.ForegroundServiceSwitch.a(), false);
    }

    private void r() {
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(f, new Notification());
        } else {
            bindService(new Intent(this, XMJobService.class), new al(this), 1);
        }
    }

    public com.xiaomi.smack.l a(com.xiaomi.smack.b bVar) {
        return new com.xiaomi.smack.l(this, bVar);
    }

    public com.xiaomi.smack.packet.c a(byte[] bArr) {
        com.xiaomi.xmpush.thrift.p pVar = new com.xiaomi.xmpush.thrift.p();
        try {
            ae.a(pVar, bArr);
            return a(g.a(this), (Context) this, pVar);
        } catch (org.apache.thrift.f e2) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
            return null;
        }
    }

    public com.xiaomi.xmpush.thrift.p a(String str, String str2) {
        s sVar = new s();
        sVar.b(str2);
        sVar.c("app_uninstalled");
        sVar.a(com.xiaomi.smack.packet.d.j());
        sVar.a(false);
        return a(str, str2, sVar, com.xiaomi.xmpush.thrift.a.Notification);
    }

    public void a(int i2) {
        this.k.b(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        com.xiaomi.smack.a aVar = this.h;
        sb.append(aVar == null ? null : Integer.valueOf(aVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
        com.xiaomi.smack.a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.a(new com.xiaomi.smack.packet.f(f.b.unavailable), i2, exc);
            this.h = null;
        }
        a(7);
        a(4);
        y.a().a((Context) this, i2);
    }

    public void a(g gVar) {
        a(gVar, 0);
    }

    public void a(g gVar, long j2) {
        this.k.a((d.b) gVar, j2);
    }

    public void a(y.b bVar) {
        bVar.a((y.b.a) new ar(this));
    }

    public void a(com.xiaomi.smack.a aVar) {
        this.c.a();
        Iterator<y.b> it = y.a().b().iterator();
        while (it.hasNext()) {
            a((g) new a(it.next()));
        }
    }

    public void a(com.xiaomi.smack.a aVar, int i2, Exception exc) {
        a(false);
    }

    public void a(com.xiaomi.smack.a aVar, Exception exc) {
        a(false);
    }

    public void a(com.xiaomi.smack.packet.d dVar) {
        com.xiaomi.smack.a aVar = this.h;
        if (aVar != null) {
            aVar.a(dVar);
            return;
        }
        throw new p("try send msg while connection is null.");
    }

    public void a(com.xiaomi.xmpush.thrift.p pVar) {
        if (this.h != null) {
            com.xiaomi.smack.packet.c a2 = a(g.a(this), (Context) this, pVar);
            if (a2 != null) {
                this.h.a((com.xiaomi.smack.packet.d) a2);
                return;
            }
            return;
        }
        throw new p("try send msg while connection is null.");
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        y.b b2 = y.a().b(str, str2);
        if (b2 != null) {
            a((g) new n(b2, i2, str4, str3));
        }
        y.a().a(str, str2);
    }

    public void a(String str, byte[] bArr) {
        if (this.h != null) {
            com.xiaomi.smack.packet.c a2 = a(bArr);
            if (a2 != null) {
                this.h.a((com.xiaomi.smack.packet.d) a2);
            } else {
                j.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
            }
        } else {
            throw new p("try send msg while connection is null.");
        }
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            j.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.a("register request without payload");
            return;
        }
        com.xiaomi.xmpush.thrift.p pVar = new com.xiaomi.xmpush.thrift.p();
        try {
            ae.a(pVar, bArr);
            if (pVar.a == com.xiaomi.xmpush.thrift.a.Registration) {
                t tVar = new t();
                try {
                    ae.a(tVar, pVar.f());
                    j.a(pVar.j(), bArr);
                    a((g) new i(this, pVar.j(), tVar.d(), tVar.h(), bArr));
                } catch (org.apache.thrift.f e2) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                    j.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                j.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.a("register request with invalid payload");
            }
        } catch (org.apache.thrift.f e3) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e3);
            j.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(com.xiaomi.smack.packet.d[] dVarArr) {
        com.xiaomi.smack.a aVar = this.h;
        if (aVar != null) {
            aVar.a(dVarArr);
            return;
        }
        throw new p("try send msg while connection is null.");
    }

    public boolean a() {
        return com.xiaomi.channel.commonutils.network.d.d(this) && y.a().c() > 0 && !b();
    }

    public void b(g gVar) {
        this.k.a(gVar.a, (d.b) gVar);
    }

    public void b(y.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.a("schedule rebind job in " + (a2 / 1000));
            a((g) new a(bVar), a2);
        }
    }

    public void b(com.xiaomi.smack.a aVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
    }

    public boolean b() {
        try {
            Class<?> cls = Class.forName("miui.os.Build");
            return cls.getField("IS_CM_CUSTOMIZATION_TEST").getBoolean((Object) null) || cls.getField("IS_CU_CUSTOMIZATION_TEST").getBoolean((Object) null);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b(int i2) {
        return this.k.a(i2);
    }

    public b c() {
        return new b();
    }

    public b d() {
        return this.i;
    }

    public boolean e() {
        com.xiaomi.smack.a aVar = this.h;
        return aVar != null && aVar.i();
    }

    public boolean f() {
        com.xiaomi.smack.a aVar = this.h;
        return aVar != null && aVar.h();
    }

    public com.xiaomi.smack.a g() {
        return this.h;
    }

    public void h() {
        a((g) new ak(this, 10), 15000);
    }

    public IBinder onBind(Intent intent) {
        return new i();
    }

    public void onCreate() {
        super.onCreate();
        com.xiaomi.channel.commonutils.android.i.a(this);
        f a2 = g.a(this);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.misc.a.a(a2.g);
        }
        ab.a(this);
        this.b = new am(this, (Map) null, 5222, "xiaomi.com", (com.xiaomi.smack.e) null);
        this.b.a(true);
        this.g = a(this.b);
        this.g.b(a("xiaomi.com"));
        new Fallback("mibind.chat.gslb.mi-idc.com");
        this.i = c();
        try {
            if (com.xiaomi.channel.commonutils.android.i.d()) {
                this.i.a((Context) this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
        }
        com.xiaomi.push.service.timers.a.a((Context) this);
        this.g.a((com.xiaomi.smack.d) this);
        this.j = new PacketSync(this);
        this.c = new af(this);
        new c().a();
        this.k = new d("Connection Controller Thread");
        a((g) new an(this, 11));
        y a3 = y.a();
        a3.e();
        a3.a((y.a) new ao(this));
        this.d = new d();
        registerReceiver(this.d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        if (q()) {
            r();
        }
        com.xiaomi.channel.commonutils.logger.b.a("XMPushService created pid = " + f);
    }

    public void onDestroy() {
        unregisterReceiver(this.d);
        this.k.c();
        a((g) new as(this, 2));
        a((g) new h());
        y.a().e();
        y.a().a((Context) this, 15);
        y.a().d();
        this.g.b((com.xiaomi.smack.d) this);
        ah.a().b();
        com.xiaomi.push.service.timers.a.a();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.a("Service destroyed");
    }

    public void onStart(Intent intent, int i2) {
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.c(String.format("onStart() with intent.Action = %s, chid = %s", new Object[]{intent.getAction(), intent.getStringExtra(aa.q)}));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.a("Service called on timer");
            } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.a("Service called on check alive.");
                if (!l()) {
                    return;
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                a((g) new f(intent));
                return;
            } else {
                return;
            }
            m();
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return a;
    }
}
