package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.service.C1995at;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.mipush.sdk.f */
public class C1583f implements AbstractPushManager {

    /* renamed from: a */
    private static volatile C1583f f1717a;

    /* renamed from: a */
    private Context f1718a;

    /* renamed from: a */
    private PushConfiguration f1719a;

    /* renamed from: a */
    private Map<C1582e, AbstractPushManager> f1720a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f1721a = false;

    private C1583f(Context context) {
        this.f1718a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C1583f m2419a(Context context) {
        if (f1717a == null) {
            synchronized (C1583f.class) {
                if (f1717a == null) {
                    f1717a = new C1583f(context);
                }
            }
        }
        return f1717a;
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [boolean] */
    /* JADX WARNING: type inference failed for: r2v21, types: [boolean] */
    /* JADX WARNING: type inference failed for: r2v37, types: [boolean] */
    /* renamed from: a */
    private void m2420a() {
        AbstractPushManager a;
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        PushConfiguration pushConfiguration = this.f1719a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f1719a.getOpenHmsPush() + " HW online switch : " + C1586i.m2433a(this.f1718a, C1582e.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + C1560ag.HUAWEI.equals(C1592n.m2452a(this.f1718a)));
                C1524b.m2141a(sb.toString());
            }
            if (this.f1719a.getOpenHmsPush() && C1586i.m2433a(this.f1718a, C1582e.ASSEMBLE_PUSH_HUAWEI) != null && C1560ag.HUAWEI.equals(C1592n.m2452a(this.f1718a))) {
                if (!mo17188a(C1582e.ASSEMBLE_PUSH_HUAWEI)) {
                    mo17190a(C1582e.ASSEMBLE_PUSH_HUAWEI, C1564ak.m2292a(this.f1718a, C1582e.ASSEMBLE_PUSH_HUAWEI));
                }
                C1524b.m2159c("hw manager add to list");
            } else if (mo17188a(C1582e.ASSEMBLE_PUSH_HUAWEI) && (a4 = mo17188a(C1582e.ASSEMBLE_PUSH_HUAWEI)) != null) {
                mo17188a(C1582e.ASSEMBLE_PUSH_HUAWEI);
                a4.unregister();
            }
            if (this.f1719a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f1719a.getOpenFCMPush() + " FCM online switch : " + C1586i.m2433a(this.f1718a, C1582e.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + C1592n.m2452a(this.f1718a));
                C1524b.m2141a(sb2.toString());
            }
            if (this.f1719a.getOpenFCMPush() && C1586i.m2433a(this.f1718a, C1582e.ASSEMBLE_PUSH_FCM) != null && C1592n.m2452a(this.f1718a)) {
                if (!mo17188a(C1582e.ASSEMBLE_PUSH_FCM)) {
                    mo17190a(C1582e.ASSEMBLE_PUSH_FCM, C1564ak.m2292a(this.f1718a, C1582e.ASSEMBLE_PUSH_FCM));
                }
                C1524b.m2159c("fcm manager add to list");
            } else if (mo17188a(C1582e.ASSEMBLE_PUSH_FCM) && (a3 = mo17188a(C1582e.ASSEMBLE_PUSH_FCM)) != null) {
                mo17188a(C1582e.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f1719a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f1719a.getOpenCOSPush() + " COS online switch : " + C1586i.m2433a(this.f1718a, C1582e.ASSEMBLE_PUSH_COS) + " COS isSupport : " + C1592n.m2455b(this.f1718a));
                C1524b.m2141a(sb3.toString());
            }
            if (this.f1719a.getOpenCOSPush() && C1586i.m2433a(this.f1718a, C1582e.ASSEMBLE_PUSH_COS) != null && C1592n.m2455b(this.f1718a)) {
                mo17190a(C1582e.ASSEMBLE_PUSH_COS, C1564ak.m2292a(this.f1718a, C1582e.ASSEMBLE_PUSH_COS));
            } else if (mo17188a(C1582e.ASSEMBLE_PUSH_COS) && (a2 = mo17188a(C1582e.ASSEMBLE_PUSH_COS)) != null) {
                mo17188a(C1582e.ASSEMBLE_PUSH_COS);
                a2.unregister();
            }
            if (this.f1719a.getOpenFTOSPush() && C1586i.m2433a(this.f1718a, C1582e.ASSEMBLE_PUSH_FTOS) != null && C1592n.m2456c(this.f1718a)) {
                mo17190a(C1582e.ASSEMBLE_PUSH_FTOS, C1564ak.m2292a(this.f1718a, C1582e.ASSEMBLE_PUSH_FTOS));
            } else if (mo17188a(C1582e.ASSEMBLE_PUSH_FTOS) && (a = mo17188a(C1582e.ASSEMBLE_PUSH_FTOS)) != null) {
                mo17188a(C1582e.ASSEMBLE_PUSH_FTOS);
                a.unregister();
            }
        }
    }

    /* renamed from: a */
    public AbstractPushManager mo17188a(C1582e eVar) {
        return this.f1720a.get(eVar);
    }

    /* renamed from: a */
    public void mo17189a(PushConfiguration pushConfiguration) {
        this.f1719a = pushConfiguration;
        this.f1721a = C1995at.m5047a(this.f1718a).mo18472a(C1873ht.AggregatePushSwitch.mo17806a(), true);
        if (this.f1719a.getOpenHmsPush() || this.f1719a.getOpenFCMPush() || this.f1719a.getOpenCOSPush()) {
            C1995at.m5047a(this.f1718a).mo18469a((C1995at.C1996a) new C1584g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a */
    public void m2425a(C1582e eVar) {
        this.f1720a.remove(eVar);
    }

    /* renamed from: a */
    public void mo17190a(C1582e eVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f1720a.containsKey(eVar)) {
                this.f1720a.remove(eVar);
            }
            this.f1720a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a */
    public boolean m2427a(C1582e eVar) {
        return this.f1720a.containsKey(eVar);
    }

    /* renamed from: b */
    public boolean mo17191b(C1582e eVar) {
        int i = C1585h.f1723a[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f1719a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i != 2) {
            if (i == 3) {
                PushConfiguration pushConfiguration2 = this.f1719a;
                if (pushConfiguration2 != null) {
                    z = pushConfiguration2.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration3 = this.f1719a;
            return pushConfiguration3 != null ? pushConfiguration3.getOpenFTOSPush() : z;
        } else {
            PushConfiguration pushConfiguration4 = this.f1719a;
            if (pushConfiguration4 != null) {
                return pushConfiguration4.getOpenFCMPush();
            }
            return false;
        }
    }

    public void register() {
        C1524b.m2141a("ASSEMBLE_PUSH : assemble push register");
        if (this.f1720a.size() <= 0) {
            m2420a();
        }
        if (this.f1720a.size() > 0) {
            for (AbstractPushManager next : this.f1720a.values()) {
                if (next != null) {
                    next.register();
                }
            }
            C1586i.m2430a(this.f1718a);
        }
    }

    public void unregister() {
        C1524b.m2141a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager next : this.f1720a.values()) {
            if (next != null) {
                next.unregister();
            }
        }
        this.f1720a.clear();
    }
}
