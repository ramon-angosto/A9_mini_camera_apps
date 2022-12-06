package com.huawei.android.pushagent.b.a;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.d;
import com.huawei.android.pushagent.b.a.a.b;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.e;
import java.util.LinkedList;
import java.util.List;

public class a {
    private static a d;
    C0032a a = C0032a.ConnectEntity_Polling;
    com.huawei.android.pushagent.b.a.a.a[] b = new com.huawei.android.pushagent.b.a.a.a[C0032a.values().length];
    private Context c;

    /* renamed from: com.huawei.android.pushagent.b.a.a$a  reason: collision with other inner class name */
    public enum C0032a {
        ConnectEntity_Push,
        ConnectEntity_Polling
    }

    private a(Context context) {
        this.c = context;
    }

    public static synchronized a a(Context context) {
        synchronized (a.class) {
            if (d != null) {
                a aVar = d;
                return aVar;
            } else if (context == null) {
                e.d("PushLogAC2705", "when init ChannelMgr g_channelMgr and context all null!!");
                return null;
            } else {
                d = new a(context);
                d.g();
                a aVar2 = d;
                return aVar2;
            }
        }
    }

    public static b b(Context context) {
        return a(context).d().e;
    }

    public static C0032a c() {
        return a((Context) null).a;
    }

    private static void c(Context context) {
        e.a("PushLogAC2705", "enter cancelDelayAlarm");
        com.huawei.android.pushagent.c.a.a.a(context, "com.huawei.action.CONNECT_PUSHSRV");
        com.huawei.android.pushagent.c.a.a.a(context, "com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT");
        com.huawei.android.pushagent.c.a.a.a(context, new Intent("com.huawei.intent.action.PUSH").putExtra("EXTRA_INTENT_TYPE", "com.huawei.android.push.intent.HEARTBEAT_REQ").putExtra("heartbeat_interval", 2592000000L).setPackage(context.getPackageName()));
    }

    public static com.huawei.android.pushagent.b.a.a.a e() {
        return a((Context) null).b[C0032a.ConnectEntity_Push.ordinal()];
    }

    public static com.huawei.android.pushagent.b.a.a.a f() {
        return a((Context) null).b[C0032a.ConnectEntity_Polling.ordinal()];
    }

    private boolean g() {
        e.a("PushLogAC2705", "begin to init ChannelMgr");
        int a2 = c.a(this.c, "curConnectEntity", C0032a.ConnectEntity_Polling.ordinal());
        e.a("PushLogAC2705", "in cfg curConEntity:" + a2);
        if (a2 >= 0 && a2 < C0032a.values().length) {
            this.a = C0032a.values()[a2];
        }
        if (C0032a.ConnectEntity_Polling == this.a && !com.huawei.android.pushagent.b.b.a.a(this.c).X() && com.huawei.android.pushagent.b.b.a.a(this.c).W()) {
            this.a = C0032a.ConnectEntity_Push;
        }
        this.b[C0032a.ConnectEntity_Push.ordinal()] = new com.huawei.android.pushagent.b.a.a.b.a((d) null, this.c);
        this.b[C0032a.ConnectEntity_Polling.ordinal()] = new com.huawei.android.pushagent.b.a.a.a.a((d) null, this.c);
        return true;
    }

    public List a() {
        LinkedList linkedList = new LinkedList();
        for (com.huawei.android.pushagent.b.a.a.a aVar : this.b) {
            if (aVar.e.c() != null) {
                linkedList.add(aVar.e.c());
            }
        }
        return linkedList;
    }

    public void a(long j) {
        e.a("PushLogAC2705", "next connect pushsvr will be after " + j);
        Intent intent = new Intent("com.huawei.action.CONNECT_PUSHSRV");
        intent.setPackage(this.c.getPackageName());
        com.huawei.android.pushagent.c.a.a.c(this.c, intent, j);
    }

    public void a(Intent intent) {
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("EXTRA_INTENT_TYPE");
        if ("com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT".equals(action)) {
            e.b("PushLogAC2705", "time out for wait heartbeat so reconnect");
            b(this.c).c(true);
            d().d();
            if (-1 != com.huawei.android.pushagent.c.a.b.a(this.c) && c() == C0032a.ConnectEntity_Push) {
                try {
                    d().a(false);
                } catch (com.huawei.android.pushagent.a.c e) {
                    e.c("PushLogAC2705", e.toString(), e);
                }
            }
        } else if (!"com.huawei.intent.action.PUSH".equals(action) || !"com.huawei.android.push.intent.HEARTBEAT_REQ".equals(stringExtra)) {
            if (!"com.huawei.android.push.intent.REFRESH_PUSH_CHANNEL".equals(action) && !"android.intent.action.TIME_SET".equals(action) && !"android.intent.action.TIMEZONE_CHANGED".equals(action)) {
                return;
            }
            if (d().a()) {
                b(this.c).a(false);
                b(this.c).g();
            } else if (-1 != com.huawei.android.pushagent.c.a.b.a(this.c)) {
                e.a("PushLogAC2705", "received " + action + ", but not Connect, go to connect!");
                PushService.a(new Intent("com.huawei.action.CONNECT_PUSHSRV"));
            } else {
                e.b("PushLogAC2705", "no net work, when recevice :" + action + ", do nothing");
            }
        } else if (-1 != com.huawei.android.pushagent.c.a.b.a(this.c)) {
            com.huawei.android.pushagent.b.a.a.a d2 = d();
            if (d2.a()) {
                d2.e.a(true);
                d2.e.g();
                return;
            }
            PushService.a(new Intent("com.huawei.action.CONNECT_PUSHSRV").setPackage(this.c.getPackageName()));
        } else {
            e.d("PushLogAC2705", "when send heart beat, not net work");
            b(this.c).b();
        }
    }

    public void a(C0032a aVar) {
        this.a = aVar;
        if (C0032a.ConnectEntity_Polling == aVar && !com.huawei.android.pushagent.b.b.a.a(this.c).X() && com.huawei.android.pushagent.b.b.a.a(this.c).W()) {
            aVar = C0032a.ConnectEntity_Push;
        }
        c.a(this.c, new com.huawei.android.pushagent.a.a("curConnectEntity", Integer.class, (Object) Integer.valueOf(aVar.ordinal())));
    }

    public void a(C0032a aVar, boolean z) {
        e.d("PushLogAC2705", "enter ChannelMgr:connect(entity" + aVar + ", forceCon" + z + ")");
        if (aVar != null) {
            try {
                this.b[aVar.ordinal()].a(z);
            } catch (com.huawei.android.pushagent.a.c e) {
                e.c("PushLogAC2705", e.toString(), e);
            }
        } else {
            e.d("PushLogAC2705", "entityMode is invalid!!");
        }
    }

    public void b() {
        c(this.c);
        for (com.huawei.android.pushagent.b.a.a.a d2 : this.b) {
            d2.d();
        }
    }

    public com.huawei.android.pushagent.b.a.a.a d() {
        e.a("PushLogAC2705", "enter getCurConnetEntity(curConnectType:" + this.a + ", ordinal:" + this.a.ordinal() + " curConnect:" + this.b[this.a.ordinal()].getClass().getSimpleName() + ")");
        if (C0032a.ConnectEntity_Polling == this.a && !com.huawei.android.pushagent.b.b.a.a(this.c).X() && com.huawei.android.pushagent.b.b.a.a(this.c).W()) {
            e.a("PushLogAC2705", "polling srv is not ready, push is ok, so change it to Push");
            this.a = C0032a.ConnectEntity_Push;
        }
        return this.b[this.a.ordinal()];
    }
}
