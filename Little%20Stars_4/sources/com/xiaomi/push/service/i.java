package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.y;
import com.xiaomi.smack.p;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;

public class i extends XMPushService.g {
    private XMPushService b;
    private byte[] c;
    private String d;
    private String e;
    private String f;

    public i(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.b = xMPushService;
        this.d = str;
        this.c = bArr;
        this.e = str2;
        this.f = str3;
    }

    public void a() {
        y.b bVar;
        f a = g.a(this.b);
        if (a == null) {
            try {
                a = g.a(this.b, this.d, this.e, this.f);
            } catch (IOException | JSONException e2) {
                b.a(e2);
            }
        }
        if (a == null) {
            b.d("no account for mipush");
            j.a(this.b, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        Collection<y.b> c2 = y.a().c("5");
        if (c2.isEmpty()) {
            bVar = a.a(this.b);
            this.b.a(bVar);
            y.a().a(bVar);
        } else {
            bVar = c2.iterator().next();
        }
        if (this.b.e()) {
            try {
                if (bVar.m == y.c.binded) {
                    this.b.a(this.d, this.c);
                } else if (bVar.m == y.c.unbind) {
                    XMPushService xMPushService = this.b;
                    XMPushService xMPushService2 = this.b;
                    xMPushService2.getClass();
                    xMPushService.a((XMPushService.g) new XMPushService.a(bVar));
                }
            } catch (p e3) {
                b.a((Throwable) e3);
                this.b.a(10, (Exception) e3);
            }
        } else {
            this.b.a(true);
        }
    }

    public String b() {
        return "register app";
    }
}
