package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1874hu;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1887ig;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.service.C1995at;
import com.xiaomi.push.service.C1997au;

/* renamed from: com.xiaomi.mipush.sdk.ae */
public class C1558ae extends C1618ak.C1619a {

    /* renamed from: a */
    private Context f1646a;

    public C1558ae(Context context) {
        this.f1646a = context;
    }

    /* renamed from: a */
    public String mo16986a() {
        return "2";
    }

    public void run() {
        C1995at a = C1995at.m5047a(this.f1646a);
        C1887ig igVar = new C1887ig();
        igVar.mo17984a(C1997au.m5060a(a, C1874hu.MISC_CONFIG));
        igVar.mo17987b(C1997au.m5060a(a, C1874hu.PLUGIN_CONFIG));
        C1894in inVar = new C1894in("-1", false);
        inVar.mo18087c(C1878hy.DailyCheckClientConfig.f2959a);
        inVar.mo18082a(C1905iy.m4543a(igVar));
        C1568ao.m2317a(this.f1646a).mo17141a(inVar, C1868ho.Notification, (C1882ib) null);
    }
}
