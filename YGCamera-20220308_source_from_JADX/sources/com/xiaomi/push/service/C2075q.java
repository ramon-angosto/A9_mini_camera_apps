package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.XMPushService;
import java.util.Collection;

/* renamed from: com.xiaomi.push.service.q */
public class C2075q extends XMPushService.C1956i {

    /* renamed from: a */
    private XMPushService f3939a;

    /* renamed from: a */
    private String f3940a;

    /* renamed from: a */
    private byte[] f3941a;

    /* renamed from: b */
    private String f3942b;

    /* renamed from: c */
    private String f3943c;

    public C2075q(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f3939a = xMPushService;
        this.f3940a = str;
        this.f3941a = bArr;
        this.f3942b = str2;
        this.f3943c = str3;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "register app";
    }

    /* renamed from: a */
    public void m5323a() {
        C2003az.C2005b bVar;
        C2071n a = C2072o.m5301a((Context) this.f3939a);
        if (a == null) {
            try {
                a = C2072o.m5303a(this.f3939a, this.f3940a, this.f3942b, this.f3943c);
            } catch (Exception e) {
                C1524b.m2160d("fail to register push account. " + e);
            }
        }
        if (a == null) {
            C1524b.m2160d("no account for mipush");
            C2076r.m5324a(this.f3939a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        Collection a2 = C2003az.mo18481a().mo18483a("5");
        if (a2.isEmpty()) {
            bVar = a.mo18554a(this.f3939a);
            C1970ab.m4886a(this.f3939a, bVar);
            C2003az.mo18481a().mo18487a(bVar);
        } else {
            bVar = (C2003az.C2005b) a2.iterator().next();
        }
        if (this.f3939a.mo18423c()) {
            try {
                if (bVar.f3736a == C2003az.C2009c.binded) {
                    C1970ab.m4888a(this.f3939a, this.f3940a, this.f3941a);
                } else if (bVar.f3736a == C2003az.C2009c.unbind) {
                    XMPushService xMPushService = this.f3939a;
                    XMPushService xMPushService2 = this.f3939a;
                    xMPushService2.getClass();
                    xMPushService.mo18412a((XMPushService.C1956i) new XMPushService.C1948a(bVar));
                }
            } catch (C1823gf e2) {
                C1524b.m2160d("meet error, disconnect connection. " + e2);
                this.f3939a.mo18410a(10, (Exception) e2);
            }
        } else {
            this.f3939a.mo18418a(true);
        }
    }
}
